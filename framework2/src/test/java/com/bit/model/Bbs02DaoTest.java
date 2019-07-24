package com.bit.model;

import java.sql.Connection;
import java.sql.SQLException;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bit.model.entity.Bbs02Vo;

public class Bbs02DaoTest {
	
	static Bbs02Dao dao;
	
	@BeforeClass
	public static void setUpbeforeClass() throws SQLException{
		System.out.println("beforeClass...");
		dao=new Bbs02Dao();
	}

	@AfterClass
	public static void afterClass(){
		System.out.println("afterClass...");
	}
	
	@Before
	public void setUp() throws SQLException{
		System.out.println("before...");
		dao=new Bbs02Dao();
	}
	
	@After
	public void tearDown(){
		System.out.println("after...");
	}
	
	@Test
	public void testInsertOne() throws SQLException{
		System.out.println("testInsertOne...");
		Bbs02Vo bean=new Bbs02Vo();
		bean.setName("test");
		bean.setSub("testData");
		bean.setContent("test");
		Bbs02Dao dao=new Bbs02Dao();
		Assert.assertSame(1, dao.insertOne(bean)); // (예상치, 결과물)
	}
	
	@Test
	public void testSelectAll() throws SQLException{
		Assert.assertNotNull(dao.selectAll("test01"));
		Assert.assertTrue(dao.selectAll("%%").size()>0);
//		Assert.assertSame(1, dao.selectAll("test01").size());
	}
//		Assert.assertNull(null);		//널이면 성공
//		Assert.assertEquals(1, 1);		//같으면 성공
//		Assert.assertSame(1, 1);		//같으면 성공
//		Assert.assertNotSame(1, 2);		//같지 않으면 성공
//		Assert.assertTrue(true);		//true면 성공
//		Assert.assertFalse(false);		//false면 성공
		
	
}
