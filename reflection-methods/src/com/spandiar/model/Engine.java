package com.spandiar.model;

public class Engine {
	
	private int cylinders;
	private float cubicCapacity;
	private FuelType fuelType;
	
	
	public Engine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Engine(int cylinders, float cubicCapacity, FuelType fuelType) {
		super();
		this.cylinders = cylinders;
		this.cubicCapacity = cubicCapacity;
		this.fuelType = fuelType;
	}

	public int getCylinders() {
		return cylinders;
	}
	public void setCylinders(int cylinders) {
		this.cylinders = cylinders;
	}
	public float getCubicCapacity() {
		return cubicCapacity;
	}
	public void setCubicCapacity(float cubicCapacity) {
		this.cubicCapacity = cubicCapacity;
	}
	public FuelType getFuelType() {
		return fuelType;
	}
	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	@Override
	public String toString() {
		return "Engine [cylinders=" + cylinders + ", cubicCapacity=" + cubicCapacity + ", fuelType=" + fuelType + "]";
	} 
	
}

enum FuelType {
	PETROL, DIESEL
}
