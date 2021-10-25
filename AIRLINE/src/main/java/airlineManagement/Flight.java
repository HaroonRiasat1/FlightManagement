package airlineManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Flight {
private String flightid;
private int bussinessclass;
private int Economicclass;
private int seat;

Boolean[] seats; //zero means seats are not booked; SEATS[ROWS][COLUMNS]

public String getFlightid() {
	return flightid;
}

public Flight(String n,int seat,int business,int economic) {
	// TODO Auto-generated constructor stub
	flightid=n;
	seats=new Boolean[seat];
	this.setSeat(seat);
	bussinessclass=business;
	Economicclass=economic;
	for(int i=0;i<seat;i++)
	{
		seats[i]=false;
	}
	Reservedseats();
}
public void setFlight(String n,int seat) {
	// TODO Auto-generated constructor stub
	flightid=n;
	seats=new Boolean[seat];
	this.setSeat(seat);
}



public void setFlightid(String flightid) {
	this.flightid = flightid;
}
public Boolean[] getSeats() {
	return seats;
}
public void setSeats(Boolean[] seats) {
	this.seats = seats;
}

public int getBussinessclass() {
	return bussinessclass;
}

public void setBussinessclass(int bussinessclass) {
	this.bussinessclass = bussinessclass;
}

public int getEconomicclass() {
	return Economicclass;
}

public void setEconomicclass(int economicclass) {
	Economicclass = economicclass;
}

public int getSeat() {
	return seat;
}

public void setSeat(int seat) {
	this.seat = seat;
}
public boolean NotRseat(int i)
{
	if(seats[i]==false)
	{
		return true;
	}
	else {
		return false;
	}
}

public void Reservedseats()
{
	try {
		String filename= flightid+".txt";
		 File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\airlineManagement\\" +filename);
		  BufferedReader br= new BufferedReader(new FileReader(file));
		        String st;
		   
		        while ((st = br.readLine()) != null) {
		        		
		        			seats[Integer.parseInt(st)-1]=true;
		        	
			        	}
		        
		        	
		       
		        br.close();
	}
	catch (Exception e) {
		// TODO: handle exception
	}
}

}
