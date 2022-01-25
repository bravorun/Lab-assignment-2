package com.java.Assesment2.q1;

import java.io.Serializable;


enum MySigleton{
	INSTANCE;
}

class SingletonImplementation implements Serializable, Cloneable{
	//	Eager initialization 
	//private static volatile Singleton singleton=new Singleton();
	
	//added volatile to make it thread safe 
	private static volatile SingletonImplementation singleton = null;

	private SingletonImplementation() {
		if(singleton!=null) { // For handling Reflection Issue 
			// as we can invoke private methods using Reflection 
			// So if user tries to create object using reflection
			//Exception is thrown
			throw new IllegalStateException();
		}
	}
	public static SingletonImplementation getSingleton() {
	
		if (singleton == null) {
			synchronized (SingletonImplementation.class) {
				if (singleton == null) {//performing double lock checking
					//and making the singleton volatile
					singleton = new SingletonImplementation();
				}
			}
		}

		return singleton;
	}
	
	// For Handling Serialization issue
	// by using read resolve we instruct JVM not to de serialize
	//but perform the task defined  in readResolve
	private Object readResolve() {
		System.out.println("if u have defined the readResolve method then java will not for for de-ser");
		return singleton;
	}
// for Handling Cloning
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return singleton;
		//throw new CloneNotSupportedException();
	}

}
