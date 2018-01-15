package com.DP;

public class Sports_Retail_Shop {

    private static Application configureApplication() {
        Application app;
        Company factory;
        String sportsName = "ADIDAS".toLowerCase();
        if (sportsName.contains("adidas")) {
            factory = new Adidas();
            app = new Application(factory);
        } else {
            factory = new Brooks();
            app = new Application(factory);
        }
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}

class Application {
	private Bat bat;
	private Wicket wicket;

	public Application(Company factory) {
		bat = factory.createBat();
		wicket = factory.createWicket();
	}

	public void paint() {
		bat.createBat();
		wicket.createWicket();
	}
}


interface Company{
	 public abstract Wicket createWicket();
	 public abstract Bat createBat();
}

class Adidas implements Company{

	@Override
	public Wicket createWicket() {
		// TODO Auto-generated method stub
		return new AdidasWicket();
	}

	@Override
	public Bat createBat() {
		// TODO Auto-generated method stub
		return new AdidasBat();
	}
	
}

class Brooks implements Company{

	@Override
	public Wicket createWicket() {
		// TODO Auto-generated method stub
		return new BrooksWicket();
	}

	@Override
	public Bat createBat() {
		// TODO Auto-generated method stub
		return new BrooksBat();
	}
	
}

interface Bat {
	public abstract void createBat();
}

class BrooksBat implements Bat{

	@Override
	public void createBat() {
		// TODO Auto-generated method stub
		System.out.println("Creating Brooks Bat");
	}
	
}

class AdidasBat implements Bat{

	@Override
	public void createBat() {
		// TODO Auto-generated method stub
		System.out.println("Creating Adidas Bat");
	}
	
}

interface Wicket {
	public abstract void createWicket();
}

class BrooksWicket implements Wicket{

	@Override
	public void createWicket() {
		// TODO Auto-generated method stub
		System.out.println("Creating Brooks Wicket");
	}
	
}

class AdidasWicket implements Wicket{

	@Override
	public void createWicket() {
		// TODO Auto-generated method stub
		System.out.println("Creating Adidas Wicket");
	}
	
}