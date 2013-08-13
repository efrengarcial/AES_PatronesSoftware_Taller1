package com.wtf.commons;

public class RegistrySingleton {

	  private static final Registry INSTANCE = new Registry();

	   // Private constructor prevents instantiation from other classes
	   private RegistrySingleton() {}

	   public static Registry getInstance() {
	      return INSTANCE;
	   }
	
}
