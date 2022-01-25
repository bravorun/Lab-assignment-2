package com.java.Assesment2.q1;

import java.lang.reflect.*;
import java.util.*;

public class SingletonCalling{
	public static void main(String args[]){
		//creating instance of singleton class
		SingletonImplementation singleton1=SingletonImplementation.getSingleton();
		
		//breaking using Java Reflection
	
			Class<SingletonImplementation> class1;
			try {
				class1 = (Class<SingletonImplementation>) Class.forName("com.java.Assesment2.q1.SingletonImplementation");
			
			Constructor[] constructors=class1.getDeclaredConstructors();
			constructors[0].setAccessible(true);
			try {
				SingletonImplementation singleton=(SingletonImplementation) constructors[0].newInstance();
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (InstantiationException e) {
				
				e.printStackTrace();
			
			}
			//Implementing Enum singleton pattern, since by default enum is singleton
			//But it is a misuse of Enum concept yet we can create a singleton object.
			MySigleton mySigleton=MySigleton.INSTANCE;
	}
}
