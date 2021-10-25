package airlineManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Passenger extends payment {
private String name;
private String gender;
private String age;
private String address;
private String PassportNo;
private String password;
private String email;
private String Booking;
private int flightNo;
private int seat;
private String flightName;

private FLIGHTDetails passengerFlightDetails;
public Passenger(String name2, String gender2, String age2, String address2, String passportNo2, String email2, String password2)
{
	setName(name2);
	setGender(gender2);
	setAge(age2);
	setAddress(address2);
	setPassportNo(passportNo2);
	setEmail(email2);
	setPassword(password2);
	
}

public Passenger(String n,String a,String ad,String Pn){
	setName(n);
	setAge(a);
	setAddress(ad);
	setPassportNo(Pn);
}
public Passenger() {
	// TODO Auto-generated constructor stub
}

public void setPassenger(String name2, String gender2, String age2, String address2, String passportNo2, String email2, String password2)
{
	setName(name2);
	setGender(gender2);
	setAge(age2);
	setAddress(address2);
	setPassportNo(passportNo2);
	setEmail(email2);
	setPassword(password2);
	
}


public void displayDetails()
{
	System.out.println("Customer Name:"+getName());
	System.out.println("Customer Age:"+getAge());
	System.out.println("Customer Address:"+getAddress());
	System.out.println("Customer PassportNo:"+getPassportNo());
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPassportNo() {
	return PassportNo;
}
public void setPassportNo(String passportNo) {
	PassportNo = passportNo;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


public void addIntofile(String name2, String gender2, String age2, String address2, String passportNo2, String email2, String password2) {
	try
	{
	    String filename= "userLoginData.txt";
	    FileWriter fw = new FileWriter(System.getProperty("user.dir") + "\\src\\main\\java\\airlineManagement\\" +filename,true); //code taken from stackoverflow
	    fw.write(name2+","+gender2+","+age2+","+address2+","+passportNo2+","+email2+","+password2+"\n");//
	    fw.close();
	    System.out.print("Account Created");
	}
	catch(IOException ioe)
	{
	    System.err.println("IOException: " + ioe.getMessage());
	}

}
public boolean login(String email,String pass)
{

	try {
		 File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\airlineManagement\\" +"userLoginData.txt");
		  BufferedReader br= new BufferedReader(new FileReader(file));
		        String st;
		   
		        while ((st = br.readLine()) != null) {
		        	int k=0;
		        	String name="";
		        	 String gender="";
		        	String age="";
		        	 String address="";
		        	 String PassportNo="";
		        	 String password="";
		        	 String email1="";
		        	 for(int i=0;i<st.length();i++)
			        	{
			        		if(st.charAt(i)==',')
			        		{
			        			k++;
			        		}
			        		else if(k==0) {
								name+=st.charAt(i);
							}
			        		else if(k==1) {
								gender+=st.charAt(i);
							}
			        		else if(k==2) {
								age+=st.charAt(i);
							}
			        		else if(k==3) {
								address+=st.charAt(i);
							}
			        		else if(k==4) {
								PassportNo+=st.charAt(i);
							}
			        		else if(k==5) {
								email1+=st.charAt(i);
							}
			        		else if(k==6) {
								password+=st.charAt(i);
							}
			        	}
		        	 if(email.equals(email1)&&password.equals(pass))
		        	 {
		        		 this.setPassenger(name, gender, age, address, PassportNo, email1, password);
		        		 return true;
		        	 }
		        	
		        }
		        br.close();
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	
	return false;
}

public FLIGHTDetails getPassengerFlightDetails() {
	return passengerFlightDetails;
}

public void setPassengerFlightDetails(FLIGHTDetails passengerFlightDetails) {
	this.passengerFlightDetails = passengerFlightDetails;
}

public int getFlightNo() {
	return flightNo;
}

public void setFlightNo(int flightNo) {
	this.flightNo = flightNo;
}

public int getSeat() {
	return seat;
}

public void setSeat(int seat) {
	this.seat = seat;
}



public String getFlightName() {
	return flightName;
}

public void setFlightName(String flightName) {
	this.flightName = flightName;
}

public void printTicket(FLIGHTDetails a) {
	 Booking=this.flightName+this.flightNo+this.seat;
	System.out.print("\n-----------------------------------TICKET--------------------------------\nName:"+name+"\t\tPassportNo:"+PassportNo+"\nFlightID:"+a.getFlightID()+"\tDepartureCity:"+a.getDepartureCity()+"\nArrivalCity:"+a.getArrivalCity()+"\t\tSeatNo:"+this.seat+"\n Booking Id:"+Booking);
	
}
public void addbookingData(FLIGHTDetails a)
{
	try
	{
	    String filename= "passengerBooking.txt";
	    FileWriter fw = new FileWriter(System.getProperty("user.dir") + "\\src\\main\\java\\airlineManagement\\" +filename,true); //code taken from stackoverflow
	    fw.write(Booking+","+name+","+PassportNo+","+a.getFlightID()+","+a.getDepartureCity()+","+a.getArrivalCity()+","+this.seat);//
	    fw.close();
	   
	}
	catch(IOException ioe)
	{
	    System.err.println("IOException: " + ioe.getMessage());
	}	
}
public Boolean checkBooking()
{
	String filename= "passengerBooking.txt";
	File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\airlineManagement\\" +filename);
	try {  
	BufferedReader br= new BufferedReader(new FileReader(file));
	        String st;
	   
	        while ((st = br.readLine()) != null) {
	        	int k=0;
	        	String booking="";
	        	String name="";
	        	 String gender="";
	        	String age="";
	        	 String address="";
	        	 String PassportNo1="";
	        	 String password="";
	        	 String email1="";
	        	 for(int i=0;i<st.length();i++)
		        	{
		        		if(st.charAt(i)==',')
		        		{
		        			k++;
		        		}
		        		else if(k==0) {
							booking+=st.charAt(i);
						}
		        		else if(k==1) {
							name+=st.charAt(i);
						}
		        		else if(k==2) {
							PassportNo1+=st.charAt(i);
						}
		        		
		        	}
	        	 if(PassportNo.equals(PassportNo1))
	        	 {
	        		
	        		 return true;
	        	 }
	        	
	        }
	        br.close();
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	
	return false;
}

public void cancelReservation() {
	// TODO Auto-generated method stub
	String filename= "passengerBooking.txt";
	File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\airlineManagement\\" +filename);
	try {  
	BufferedReader br= new BufferedReader(new FileReader(file));
	        String st;
	        String data="";
	   
	        while ((st = br.readLine()) != null) {
	        	int k=0;
	        	String booking="";
	        	String name="";
	        	 String gender="";
	        	String age="";
	        	 String address="";
	        	 String PassportNo1="";
	        	 String password="";
	        	 String email1="";
	        	 for(int i=0;i<st.length();i++)
		        	{
		        		if(st.charAt(i)==',')
		        		{
		        			k++;
		        		}
		        		else if(k==0) {
							booking+=st.charAt(i);
						}
		        		else if(k==1) {
							name+=st.charAt(i);
						}
		        		else if(k==2) {
							PassportNo1+=st.charAt(i);
						}
		        		
		        	}
	        	 if(PassportNo.equals(PassportNo1))
	        	 {
	        		
	        		data+="\n";
	        	 }
	        	 else {
					data+=data;
				}
	        	
	        }
	        br.close();
	        
	        
	        try
	    	{
	    	    String filename1= "passengerBooking.txt";
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

public void printTicket1() {
	String filename= "passengerBooking.txt";
	File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\airlineManagement\\" +filename);
	try {  
	BufferedReader br= new BufferedReader(new FileReader(file));
	        String st;
	        String data="";
	   
	        while ((st = br.readLine()) != null) {
	        	int k=0;
	        	String booking="";
	        	String name1="";
	        	 String PassportNo1="";
	        	 String flightid="";
	        	 String dci="";
	        	 String Aci="";
	        	 String seat1="";
	        	 
//	        	 Booking+","+name+","+PassportNo+","+a.getFlightID()+","+a.getDepartureCity()+","+a.getArrivalCity()+","+this.seat
	        	 for(int i=0;i<st.length();i++)
		        	{
		        		if(st.charAt(i)==',')
		        		{
		        			k++;
		        		}
		        		else if(k==0) {
							booking+=st.charAt(i);
						}
		        		else if(k==1) {
							name1+=st.charAt(i);
						}
		        		else if(k==2) {
							PassportNo1+=st.charAt(i);
						}
		        		else if(k==3) {
		        			flightid+=st.charAt(i);
						}
		        		else if(k==4) {
							dci+=st.charAt(i);
						}
		        		else if(k==5) {
							Aci+=st.charAt(i);
						}
		        		else if(k==6) {
							seat1+=st.charAt(i);
						}
		        		
		        		
		        	}
	        	 if(PassportNo.equals(PassportNo1))
	        	 {
	        		
	        			System.out.print("\n-----------------------------------TICKET--------------------------------\nName:"+name1+"\t\tPassportNo:"+PassportNo1+"\nFlightID:"+flightid+"\tDepartureCity:"+dci+"\nArrivalCity:"+Aci+"\t\tSeatNo:"+seat1+"\n Booking Id:"+booking);
	        	 }
	        	
	        }
	        br.close();	
	}
	        catch (Exception e) {
				// TODO: handle exception
			}
	   
	
}

public static void details() {
	// TODO Auto-generated method stub
	try {
	File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\airlineManagement\\" +"userLoginData.txt");
	  BufferedReader br= new BufferedReader(new FileReader(file));
	        String st;
	   
	        while ((st = br.readLine()) != null) {
	        	int k=0;
	        	String name="";
	        	 String gender="";
	        	String age="";
	        	 String address="";
	        	 String PassportNo="";
	        	 String password="";
	        	 String email1="";
	        	 for(int i=0;i<st.length();i++)
		        	{
		        		if(st.charAt(i)==',')
		        		{
		        			k++;
		        		}
		        		else if(k==0) {
							name+=st.charAt(i);
						}
		        		else if(k==1) {
							gender+=st.charAt(i);
						}
		        		else if(k==2) {
							age+=st.charAt(i);
						}
		        		else if(k==3) {
							address+=st.charAt(i);
						}
		        		else if(k==4) {
							PassportNo+=st.charAt(i);
						}
		        		else if(k==5) {
							email1+=st.charAt(i);
						}
		        		else if(k==6) {
							password+=st.charAt(i);
						}
		        	}
	        	System.out.println("UserName:"+name+" UserGender:"+gender+" UserAge:"+age+" UserAddress"+address+" UserPassport:"+PassportNo+" UserEmail:"+email1+" Userpassword:"+password);
	        	
	        }
	        br.close();
}
catch (Exception e) {
	// TODO: handle exception
}
}

public static void bookingdetails() {
	String filename= "passengerBooking.txt";
	File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\airlineManagement\\" +filename);
	try {  
	BufferedReader br= new BufferedReader(new FileReader(file));
	        String st;
	        String data="";
	   
	        while ((st = br.readLine()) != null) {
	        	int k=0;
	        	String booking="";
	        	String name1="";
	        	 String PassportNo1="";
	        	 String flightid="";
	        	 String dci="";
	        	 String Aci="";
	        	 String seat1="";
	        	 
//	        	 Booking+","+name+","+PassportNo+","+a.getFlightID()+","+a.getDepartureCity()+","+a.getArrivalCity()+","+this.seat
	        	 for(int i=0;i<st.length();i++)
		        	{
		        		if(st.charAt(i)==',')
		        		{
		        			k++;
		        		}
		        		else if(k==0) {
							booking+=st.charAt(i);
						}
		        		else if(k==1) {
							name1+=st.charAt(i);
						}
		        		else if(k==2) {
							PassportNo1+=st.charAt(i);
						}
		        		else if(k==3) {
		        			flightid+=st.charAt(i);
						}
		        		else if(k==4) {
							dci+=st.charAt(i);
						}
		        		else if(k==5) {
							Aci+=st.charAt(i);
						}
		        		else if(k==6) {
							seat1+=st.charAt(i);
						}
		        		
		        		
		        	}
	        	
	        		
	        			System.out.println("Name:"+name1+"\tPassportNo:"+PassportNo1+"\tFlightID:"+flightid+"\tDepartureCity:"+dci+"\tArrivalCity:"+Aci+"\tSeatNo:"+seat1+"\tBooking Id:"+booking);
	        	 
	        	
	        }
	        br.close();	
	}
	        catch (Exception e) {
				// TODO: handle exception
			}
	
}

}