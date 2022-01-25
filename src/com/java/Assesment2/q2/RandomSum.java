package com.java.Assesment2.q2;

import java.util.ArrayList;
import java.util.Random;


public class RandomSum {
	public static void main(String[] args) {
		RandomNumber randomNummber =new RandomNumber();
		Thread thread1=new Thread(randomNummber,"thread1");
		Thread thread2=new Thread(randomNummber,"thread2");
		Thread thread3=new Thread(randomNummber,"thread3");
		Thread thread4=new Thread(randomNummber,"thread4");
		Thread thread5=new Thread(randomNummber,"thread5");
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
			thread5.join();	
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		ArrayList<Integer> numbers=randomNummber.getNum();
		printSum(numbers);
	}

	private static void printSum(ArrayList<Integer> numbers) {
		int sum=0;
		for(Integer tempInt:numbers) {
			sum+=tempInt;
		}
		System.out.println("Sum = " + sum);
	}
}