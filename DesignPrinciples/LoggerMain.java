package com.DP;

public class LoggerMain {
	public static void main(String args[]){
		Logger l = Logger.getInstance();
		l.setRecord("Log 1");
		System.out.println(l.getRecord());
		l.setRecord("Log 2");
		System.out.println(l.getRecord());
	}
}

class Logger{
	private static Logger log;
	private String record;
	 
	  private Logger() 
	  {
	     System.out.println("Logger initialized");
	     record = "";
	  }
	  
	  public String getRecord() {
		return record;
	  }

	  public void setRecord(String record) {
		this.record = record;
	  }



	public static Logger getInstance() 
	  {
		  if (log == null) 
		  {
			  log = new Logger();
		  }
		  return log;
	  }
}