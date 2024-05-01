package com.preparation.classes;

interface Hotel extends VegMeals, NonVegMeals{
}

interface VegMeals {
public void vegTypeMealsI();
}

interface NonVegMeals {
	public void nonVegTypeMealsI();
}

class SanjuVegHotel implements VegMeals{

	@Override
	public void vegTypeMealsI() {
		// TODO Auto-generated method stub
		
	}
	
}

class SanjuNonVegHotel implements NonVegMeals{

	@Override
	public void nonVegTypeMealsI() {
		// TODO Auto-generated method stub
		
	}
	
}


class SanjuHotel implements Hotel{

	@Override
	public void vegTypeMealsI() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nonVegTypeMealsI() {
		// TODO Auto-generated method stub
		
	}
	
}

public class InterfaceSegragationPrinciple {

	public static void main(String[] args) {
		
	}
	
}
