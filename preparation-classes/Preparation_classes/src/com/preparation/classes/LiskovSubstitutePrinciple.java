package com.preparation.classes;

interface Vehcile{
	public void start();
	public void end();
}

class Bike implements Vehcile{

	@Override
	public void start() {
		System.out.println("Bike is started");
	}

	@Override
	public void end() {
		System.out.println("Bike is ended");	
	}
	
}

class Ship implements Vehcile{

	@Override
	public void start() {
		System.out.println("Ship is started");
	}

	@Override
	public void end() {
		System.out.println("Ship is ended");	
	}
	
}

class AirLanes implements Vehcile{

	@Override
	public void start() {
		System.out.println("Airlanes is started");
	}

	@Override
	public void end() {
		System.out.println("Airlanes is ended");	
	}
	
}

class Car implements Vehcile{

	@Override
	public void start() {
		System.out.println("car is started");
	}

	@Override
	public void end() {
		System.out.println("car is ended");	
	}
	
}

public class LiskovSubstitutePrinciple {

	public static void register(Vehcile vehcile) {
		vehcile.start();
		vehcile.end();
	}
	
	public static void main(String[] args) {
		
		register(new AirLanes());
		
	}
	
}
