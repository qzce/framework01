package com.bit.action;

import java.util.List;

import com.bit.model.entity.Struts04Dto;
import com.opensymphony.xwork2.Action;

public class ListAction implements Action{
	private List<Struts04Dto> alist;
	
	public List<Struts04Dto> getAlist(){
		return alist;
	}
	@Override
	public String execute() throws Exception {
		alist=new Struts04Dao().getList();
		return this.SUCCESS;
	}
}
