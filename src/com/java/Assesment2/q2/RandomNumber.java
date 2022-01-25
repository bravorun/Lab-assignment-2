package com.java.Assesment2.q2;

import java.util.*;

public class RandomNumber implements Runnable{
	private ArrayList<Integer> num=new ArrayList<Integer>();
	
	public ArrayList<Integer> getNum() {
		return num;
	}

	@Override
	public void run() {
		Random random = new Random();  
		int x=random.nextInt(10)+1;
		synchronized(RandomNumber.class) {
		num.add(x);}
		System.out.println(Thread.currentThread().getName() + " number : " + x);
	}
	
}