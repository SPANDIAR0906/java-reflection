package com.spandiar.model;


public class Car {
	
	private Engine engine;
	private CarType carType;
	
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public CarType getCarType() {
		return carType;
	}
	public void setCarType(CarType carType) {
		this.carType = carType;
	}
	public Car() throws IllegalArgumentException, IllegalAccessException {
		super();
	}
	public Car(Engine engine, CarType carType) {
		super();
		this.engine = engine;
		this.carType = carType;
	}
	@Override
	public String toString() {
		return "Car [engine=" + engine + ", carType=" + carType + "]";
	}
	
}

enum CarType {
	
	HATCHBACK, SEDAN, SUV, MUV, SPORTS, LUXURY
	
}
