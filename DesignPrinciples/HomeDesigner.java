package com.DP;

class Main{
	public static void main(String args[]){
		HomeDesigner a = new DesignerA();
		HomeDesigner b = new DesignerB();
		a.design();
		b.design();
	}
}

public abstract class HomeDesigner {
	   abstract void DesignStructure();
	   abstract void DesignWalls();
	   abstract void DesignDoors();
	   abstract void DesignWindows();
	   abstract void DesignFurnishing();

	   public final void design(){
		   DesignStructure();
		   DesignWalls();
		   DesignDoors();
		   DesignWindows();
		   DesignFurnishing();
	   }
	}

class DesignerA extends HomeDesigner{

	@Override
	void DesignStructure() {
		System.out.println("Design Structure of Designer A");
	}

	@Override
	void DesignWalls() {
		System.out.println("Design Walls of Designer A");	
	}

	@Override
	void DesignDoors() {
		System.out.println("Design Doors of Designer A");
	}

	@Override
	void DesignWindows() {
		System.out.println("Design Windows of Designer A");
	}

	@Override
	void DesignFurnishing() {
		System.out.println("Design Furnishing of Designer A");
	}
	
}

class DesignerB extends HomeDesigner{

	@Override
	void DesignStructure() {
		System.out.println("Design Structure of Designer B");
	}

	@Override
	void DesignWalls() {
		System.out.println("Design Walls of Designer B");	
	}

	@Override
	void DesignDoors() {
		System.out.println("Design Doors of Designer B");
	}

	@Override
	void DesignWindows() {
		System.out.println("Design Windows of Designer B");
	}

	@Override
	void DesignFurnishing() {
		System.out.println("Design Furnishing of Designer B");
	}
	
}

