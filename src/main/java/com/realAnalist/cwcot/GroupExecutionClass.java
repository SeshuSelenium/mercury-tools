package com.realAnalist.cwcot;

import org.testng.annotations.Test;

public class GroupExecutionClass {
	@Test(groups = {"smoke"})
	public void test() {
		System.out.println("test smoke");
	}
	@Test(groups = {"smoke","sanity"})
	public void test1(){
		System.out.println("smoke & sanity");
	}
	
	@Test(groups = {"sanity", "regression"})
	public void test2(){
		System.out.println("sanity  regration");
		
	}
	
	@Test(groups = {"regression"})
	public void test3() {
		System.out.println("regression");
	}
}
