package com.spandiar;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) 
			throws InstantiationException, IllegalAccessException, 
				IllegalArgumentException, InvocationTargetException {
		
		getConstructorDetails(Person.class);
		
		Address vijayAve = createInstance(Address.class, "B12 Vijay Ave", "Venkatrangam St", "Chennai", 600005);
		Person shankee = createInstance(Person.class, "Shankee", LocalDate.of(1981, 9, 6), vijayAve);
		System.out.println(shankee);
		
	}
	
	public static void getConstructorDetails(Class<?> classz) {
		
		Constructor<?>[] declaredConstructors = classz.getDeclaredConstructors();
		
		for(Constructor<?> ctr : declaredConstructors) {
			
			Class<?>[] parameterTypes = ctr.getParameterTypes();
			
			List<String> collect = Arrays.stream(parameterTypes)
					.map(pt -> pt.getSimpleName())
						.collect(Collectors.toList());
			
			System.out.println(collect);
			
		}
				
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T createInstance(Class<T> classz, Object ... args) 
				throws InstantiationException, IllegalAccessException, 
					IllegalArgumentException, InvocationTargetException {
		
		Constructor<?>[] ctrs = classz.getConstructors();
		
		for(Constructor<?> ctr : ctrs) {
			
			if(ctr.getParameterCount() == args.length) {
				return (T) ctr.newInstance(args);
			}
			
		}
		
		return null;
		
	}

}

class Person {
	
	private String name;
	private LocalDate dob;
	private Address address;
	
	public Person(String name, LocalDate dob, Address address) {
		super();
		this.name = name;
		this.dob = dob;
		this.address = address;
	}

	public Person(String name, LocalDate dob) {
		super();
		this.name = name;
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", dob=" + dob + ", address=" + address + "]";
	}
	
}

class Address {
	
	private String doorNumber;
	private String streetName;
	private String city;
	private int zipCode;
	
	public Address(String doorNumber, String streetName, String city, int zipCode) {
		super();
		this.doorNumber = doorNumber;
		this.streetName = streetName;
		this.city = city;
		this.zipCode = zipCode;
	}

	public Address(String doorNumber, String streetName, String city) {
		super();
		this.doorNumber = doorNumber;
		this.streetName = streetName;
		this.city = city;
	}

	public Address(String doorNumber, String streetName) {
		super();
		this.doorNumber = doorNumber;
		this.streetName = streetName;
	}

	@Override
	public String toString() {
		return "Address [doorNumber=" + doorNumber + ", streetName=" + streetName + ", city=" + city + ", zipCode="
				+ zipCode;
	}
	
}
