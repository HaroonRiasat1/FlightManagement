package airlineManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Struct;

public class FLIGHTDetails extends Flight {
	private String flightID;
	private String flightRoute;
	private String Destination;
	private String DepartureCity;
	private String connectedCity;
	private String arrivalCity;
	private String dateString;
	private String time;
	private int costOfBusinessClass;
	private int costOfEconomicClass;

	private Flight dataFlight;
	
	public FLIGHTDetails(String Name,String duration,String Departure,String arrival,int seats,int bus,String date,String time )
	{
		super(Name,seats,bus,seats-bus);
		setFlightID(Name);
		setFlightRoute(duration);
		
		setDepartureCity(Departure);
		setArrivalCity(arrival);
		setDateString(date);
		setTime(time);
	}
	public FLIGHTDetails(String Name,String duration,String Departure,String arrival,String connected,int seats,int bus,int costB,int costC,String date,String time )
	{
		super(Name,seats,bus,seats-bus);
		setFlightID(Name);
		setFlightRoute(duration);
		
		setDepartureCity(Departure);
		setArrivalCity(arrival);
		setConnectedCity(connected);
		setDateString(date);
		setTime(time);
		setCostOfBusinessClass(costB);
		setCostOfEconomicClass(costC);
	}
	public void setFLIGHTDetails(String Name,String duration,String Departure,String arrival,int seats,String date,String time )
	{
		setFlight(Name,seats);
		setFlightID(Name);
		setFlightRoute(duration);
		
		setDepartureCity(Departure);
		setArrivalCity(arrival);
		setDateString(date);
		setTime(time);
	}
	public void setFLIGHTDetails(String Name,String duration,String Departure,String connected,String arrival,int seats,String date,String time )
	{
		setFlight(Name,seats);
		setFlightID(Name);
		setFlightRoute(duration);
		
		setDepartureCity(Departure);
		setArrivalCity(arrival);
		setConnectedCity(connected);
		setDateString(date);
		setTime(time);
	}


	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public String getDepartureCity() {
		return DepartureCity;
	}

	public void setDepartureCity(String departureCity) {
		DepartureCity = departureCity;
	}

	public String getDestination() {
		return Destination;
	}

	public void setDestination(String destination) {
		Destination = destination;
	}

	public String getFlightRoute() {
		return flightRoute;
	}

	public void setFlightRoute(String flightRoute) {
		this.flightRoute = flightRoute;
	}

	
	public Flight getDataFlight() {
		return dataFlight;
	}

	public void setDataFlight(Flight dataFlight) {
		this.dataFlight = dataFlight;
	}

	public String getFlightID() {
		return flightID;
	}

	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}

	public int getCostOfBusinessClass() {
		return costOfBusinessClass;
	}

	public void setCostOfBusinessClass(int costOfBusinessClass) {
		this.costOfBusinessClass = costOfBusinessClass;
	}

	public int getCostOfEconomicClass() {
		return costOfEconomicClass;
	}

	public void setCostOfEconomicClass(int costOfEconomicClass) {
		this.costOfEconomicClass = costOfEconomicClass;
	}
	
public void flightDetails()
{
	System.out.println("\nFlight Name:"+flightID);
	System.out.println("Flight Duration:"+flightRoute);
	System.out.println("Flight Arrival City:"+arrivalCity);
	System.out.println("Flight Departure City:"+DepartureCity);
	if(this.connectedCity!="")
	{	
		System.out.println("Flight Connected to City:"+connectedCity);
	}
	System.out.println("Departure Time:"+time);
	System.out.println("Departure Date:"+dateString);
	System.out.println("Total Number of Seats:"+getSeat());
	System.out.println("Business Class Seats:"+getBussinessclass());
	System.out.println("Economic Class Seats:"+getEconomicclass());
	System.out.println("Cost of Business Class Seat:"+costOfBusinessClass);
	System.out.println("Cost of Economic Class Seat:"+costOfEconomicClass);
	System.out.println("\n");

}
public String getDateString() {
	return dateString;
}
public void setDateString(String dateString) {
	this.dateString = dateString;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
	
public boolean Flightcheck(String d,String A)
{
	
	if(A.equals(this.arrivalCity)&&d.equals(this.DepartureCity))
	{
		return true;
		
	}	

	return false;
}
public boolean Flightcheck(String d,String A,String date)
{
	
	if(A.equals(this.arrivalCity)&&d.equals(this.DepartureCity)&&date.equals(this.dateString))
	{
		return true;
		
	}	

	return false;
}
public String getConnectedCity() {
	return connectedCity;
}
public void setConnectedCity(String connectedCity) {
	this.connectedCity = connectedCity;
}
	
public void addBookedSeats(int seat) {
	try
	{
	    String filename= flightID+".txt";
	    FileWriter fw = new FileWriter(System.getProperty("user.dir") + "\\src\\main\\java\\airlineManagement\\" +filename,true); //code taken from stackoverflow
	    fw.write(seat+"\n");//
	    fw.close();
	    System.out.print("\nSEAT Reserved\n");
	}
	catch(IOException ioe)
	{
	    System.err.println("IOException: " + ioe.getMessage());
	}	
}
public void cancelSeat(String seat) {
	seats[Integer.parseInt(seat)]=false;
	try {
		String filename= flightID+".txt";
		 File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\airlineManagement\\" +filename);
		  BufferedReader br= new BufferedReader(new FileReader(file));
		        String st;
		        String data="";
		        while ((st = br.readLine()) != null) {
		        		
		        			if(st.equals(seat))
		        			{
		        				data+="\n";
		        			}
		        			else {
								data+=st;
							}
		        	
			        	}
		        
		        	
		       
		        br.close();
		    	try
		    	{
		    	    String filename1= flightID+".txt";
		    	    FileWriter fw = new FileWriter(System.getProperty("user.dir") + "\\src\\main\\java\\airlineManagement\\" +filename1); //code taken from stackoverflow
		    	    fw.write(data);//
		    	    fw.close();
		    	   
		    	}
		    	catch(IOException ioe)
		    	{
		    	    System.err.println("IOException: " + ioe.getMessage());
		    	}	
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	
}	

}
