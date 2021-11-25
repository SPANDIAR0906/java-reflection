package com.spandiar;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.spandiar.model.Car;
import com.spandiar.model.Engine;

public class Main {

	public static void main(String[] args) {
		
		Car car = new Car();
		Engine engine = new Engine();
		
		validateClassGetterMethods(engine);
		validateClassSetterMethods(engine);
		
	}
	
	@SuppressWarnings("unchecked")
	private static <T> void validateClassSetterMethods(T obj) {
		
		final Class<? extends T> classInfo = (Class<? extends T>) obj.getClass();
		final Field[] declaredFields = classInfo.getDeclaredFields();
		String expectedSetterName;
		
		for(Field field : declaredFields) {
			
			expectedSetterName = "set" + captializeFirstLetter(field.getName());
			try {
				final Method result = classInfo.getMethod(expectedSetterName, field.getType());
				
				if(!result.getReturnType().equals(void.class))
				{
					throw new IllegalStateException("Return Type of setter should be void - " + expectedSetterName);
				}
				
			} catch (NoSuchMethodException | SecurityException e) {
				System.out.println("Setter is not found or incorrect");
				e.printStackTrace();
			}
			
		}
		
	}

	@SuppressWarnings("unchecked")
	public static <T> void exploreMethods(T t) {
		
		System.out.println("Class is: " + t.getClass());
		
		final Class<T> classDetail = (Class<T>) t.getClass();
		final Method[] declaredMethods = classDetail.getDeclaredMethods();
		
		for (Method dm : declaredMethods) {
			
			System.out.println("Method name is: " + dm.getName());
			System.out.println("Return Type is: " + dm.getReturnType().getName());
			
		}
		
	}
	
	private static <T> void validateClassGetterMethods(T obj) {
		
		final Class<? extends T> classInfo = (Class<? extends T>) obj.getClass();
		final Field[] declaredFields = classInfo.getDeclaredFields();
		final Method[] declaredMethods = classInfo.getMethods();
		final Map<String, Method> methodMap = new HashMap<>();
		
		for(Method method : declaredMethods) {
			methodMap.put(method.getName(), method);
		}
		
		for (Field field : declaredFields) {
			
			StringBuilder sb = new StringBuilder();
			final String fieldName = field.getName();
			final String fieldType = field.getType().getSimpleName();
			
			
			String expectedGetterName = sb.append("get").append(captializeFirstLetter(fieldName)).toString();
			
			if(! methodMap.containsKey(expectedGetterName)) {
				throw new IllegalStateException("Missing or Invalid getter name for "
						+ "field " + field + " Expected Getter is " + expectedGetterName);
			}
			
			final Method getterMethod = methodMap.get(expectedGetterName);
			
			if(!getterMethod.getReturnType().getSimpleName().equals(fieldType)) {
				throw new IllegalStateException("Invalid return type for "
						+ "field " + field);
			}
			
			if(getterMethod.getParameterCount() > 0) {
				throw new IllegalStateException("Getter cannot have parameters - " + getterMethod.getName());
			}
		
		}
		
	}
	
	public static String captializeFirstLetter(String str) {
		
		 return str.substring(0, 1).toUpperCase().concat(str.substring(1));
		
	}

}
