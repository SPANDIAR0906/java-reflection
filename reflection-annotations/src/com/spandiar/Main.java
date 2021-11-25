package com.spandiar;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import com.spandiar.annotations.Travel;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		
		travelLocations();

	}
	
	@Travel(locations = {"Sunnyvale", "Seattle", "New York"})
	public static void travelLocations() throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		
	final Class<?> mainClass = Class.forName("com.spandiar.Main");
//	for (Method method : mainClass.getMethods()) {
//		final Parameter[] parameters = method.getParameters();
//		System.out.println(method.getName() + " " + method.getParameterCount());
//		
//		for(Parameter param : parameters) {
//			System.out.println(param.getName() + " " + param.getType());
//		}
//	}
	final Method travelLocationMethod = mainClass.getMethod("travelLocations");
	if(travelLocationMethod.isAnnotationPresent(Travel.class)) {
		
		final Travel travelAnnotation = travelLocationMethod.getAnnotation(Travel.class);
		
		for(String location : travelAnnotation.locations()) {
			System.out.println(location);
		}
		
	}
		
		
		
		
	}

}
