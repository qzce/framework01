package com.bit.framework;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlets extends HttpServlet{
//	Map<String,Controller> map=new HashMap<String,Controller>();
	
	@Override
	public void init() throws ServletException {
		
		Properties prop=new Properties();
		Class<? extends DispatcherServlets> clz= getClass();
		ClassLoader loader=clz.getClassLoader();
		InputStream is=loader.getResourceAsStream("bit.properties");
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Set keys=prop.keySet();
		Iterator<String> ite=keys.iterator();
		while(ite.hasNext()){
			String key=ite.next();
			String clInfo=prop.getProperty(key);
			BitHandlerMapping.setMap(key, clInfo);
		}
		
		/*
		Map<String,String> map=new HashMap<String,String>();
		map.put("/index.bit", "com.bit.controller.IndexController");
		map.put("/main.bit", "com.bit.controller.MainController");
		map.put("/list.bit", "com.bit.controller.ListController");
		map.put("/add.bit", "com.bit.controller.AddController");
		map.put("/insert.bit", "com.bit.controller.InsertController");

		Set<String> keys=map.keySet();
		Iterator<String> ite=keys.iterator();
		while(ite.hasNext()){
			String key=ite.next();
			String clInfo=map.get(key);
			BitHandlerMapping.setMap(key, clInfo);
		}
		*/
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doDo(req,resp); //doDO 호출
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		doDo(req,resp); //doDO 호출
	}
	
	public void doDo(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.print("doDo 호출...");
		
		String root=req.getContextPath();
		String path=req.getRequestURI().substring(root.length()); //root를 잘라내기 위함 
//		System.out.println("->"+root);
		System.out.println("->"+path);//특정 url일때 아래 코드 실행
		
		Controller controller=null;
		
		controller=BitHandlerMapping.getController(path);

//		if(path.equals("/index.bit")){
////			controller=new com.bit.controller.IndexController(); //객체 생성
//			clInfo ="com.bit.controller.IndexController"; //객체 생성하지 않고 path를 이용하여 접근
//		}else if(path.equals("/main.bit")){
////			controller=new com.bit.controller.MainController();
//			clInfo="com.bit.controller.MainController";
//		}else if(path.equals("/list.bit")){
////			controller=new com.bit.controller.ListController();
//			clInfo="com.bit.controller.ListController";
//		}else if(path.equals("/add.bit")){
////			controller=new com.bit.controller.AddController();
//			clInfo="com.bit.controller.AddController";
//		}else if(path.equals("/insert.bit")){
////			controller=new com.bit.controller.InsertController();
//			clInfo="com.bit.controller.InsertController";
//		}
		
//		clInfo=map.get(path);
		
		
		String viewName=null;
		try {
			viewName = controller.execute(req);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String prefix="/WEB-INF/view/";
		String suffix=".jsp";
		if(viewName.startsWith("redirect:")){
			resp.sendRedirect(root+viewName.substring("redirect:".length()));
		}else{			
			viewName=prefix+viewName+suffix;
			//위에 부분을 처리할 controller 생성
			req.getRequestDispatcher(viewName).forward(req, resp);//index.jsp 포워드 해서 req, resp를 전달//view 역할
		}
	}
		
	
}











