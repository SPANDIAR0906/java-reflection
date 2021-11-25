package com.spandiar.reflection;

import java.lang.reflect.Field;

import com.spandiar.annotations.Mandatory;

public class Validations {
	
	public static <T> void checkMandatoryFields(T obj) throws IllegalArgumentException, IllegalAccessException{
		
		final Class<T> classz = (Class<T>) obj.getClass();
		final Field[] fields = classz.getDeclaredFields();
		
		System.out.println("Inside checkMandatoryFields. Class is " + classz.getName());
		
		for(Field field : fields) {
			
			System.out.println("Field is " + field.getName());
			
			if(field.isAnnotationPresent(Mandatory.class)) {
				
				System.out.println("Annotation Check");
				
				field.setAccessible(true);
				final Class<?> declaringClass = field.getType();
				System.out.println("Field Class is " + declaringClass);
				if(null == field.get(declaringClass)) {
					throw new RuntimeException(declaringClass.getName() + " cannot be null");
				}
				
			}
			
		}
		
	}

}
