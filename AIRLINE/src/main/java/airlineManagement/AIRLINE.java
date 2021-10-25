
package airlineManagement;

import java.util.ArrayList;

import java.util.Scanner;
import java.awt.desktop.SystemSleepEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SuppressWarnings("unused")

public class AIRLINE {

	public static ArrayList<FLIGHTDetails> populate()
	{
		ArrayList<FLIGHTDetails> popDetails=new ArrayList<FLIGHTDetails>();
		
		try {
		 File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\airlineManagement\\" +"flightdetails.txt");
		  BufferedReader br= new BufferedReader(new FileReader(file));
		        String st;
		    	
		        while ((st = br.readLine()) != null) {
		        	int k=0;
		        	int l=0;
		            String FNAME = "";
			        String DURATION = "";
			        String ARRIVAL = "";
			        String DEPARTURE = "";
			        String seat = "";
			        String dateString="";
			        String timString="";
			        String connecttString="";
			        String businessClassString="";
			        String costBusinessclassString="";
			        String costeconomicClassString="";
		        	for(int i=0;i<st.length();i++)
		        	{
		        		if(st.charAt(i)==',')
		        		{
		        			k++;
		        		}
		        		else if(st.charAt(i)=='.')
		        		{
		        			l++;
		        		}
		        		else if(l==1) {
							connecttString+=st.charAt(i);
						}
		        		else if(k==0) {
							FNAME+=st.charAt(i);
						}
		        		else if(k==1) {
							DURATION+=st.charAt(i);
						}
		        		else if(k==2) {
							ARRIVAL+=st.charAt(i);
						}
		        		else if(k==3) {
							DEPARTURE+=st.charAt(i);
						}
		        		else if(k==4) {
							seat+=st.charAt(i);
						}
		        		else if(k==5) {
							businessClassString+=st.charAt(i);
						}
		        		else if(k==6) {
						costBusinessclassString+=st.charAt(i);
						}
		        		else if(k==7) {
						costeconomicClassString+=st.charAt(i);
						}
		        		else if(k==8) {
							dateString+=st.charAt(i);
						}
		        		else if(k==9) {
							timString+=st.charAt(i);
						}
		        	}
		        
		            // Print the string
		     
		        popDetails.add(new FLIGHTDetails(FNAME, DURATION, DEPARTURE, ARRIVAL,connecttString, Integer.parseInt(seat),Integer.parseInt(businessClassString),Integer.parseInt(costBusinessclassString),Integer.parseInt(costeconomicClassString),dateString,timString));
		        }
		        br.close();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return popDetails;
	}
	
	
	public static void main(String[] args) 
	throws IOException
	{
		TestDataa a=new TestDataa(); 
		ArrayList<FLIGHTDetails> dataDetails=populate();
		Passenger Passengerdata = null;
		Boolean loggedin =false;
	System.out.print("Welcome to AIRBLUE ONLINE BOOKING SYSTEM \nSelect Revelant Option \n"
			+ "1)Check Flight Schedule \n2)Search Direct Flights\n3)Register to login into the System:\n4)Login into the System\n5)Login As Admin\nEnter Input:");

	BufferedReader input = new BufferedReader(
            new InputStreamReader(System.in));
	int option=Integer.parseInt(input.readLine());
	if(option==1)
	{	
	for(int i=0;i<dataDetails.size();i++)
	{
		dataDetails.get(i).flightDetails();
	}
		
		
	}
	else if (option==2) {
		int i;
		String arrivalString;
		String departureString;
		
	
		System.out.print("\n Enter City of Departure :");
		departureString=input.readLine();
		
		System.out.print("\n Enter city of Arrival:");
		arrivalString=input.readLine();
		
		 ArrayList<Integer> fl = new ArrayList<Integer>();
	for( i=0;i<dataDetails.size();i++)
		{
			if(dataDetails.get(i).Flightcheck(departureString, arrivalString))
			{
			fl.add(i);
				
			}
		}
		if(0==fl.size())
		{
			System.out.println("No flights avaliable between "+departureString+" "+arrivalString);
		}
		else {
			for (int l : fl) {
				dataDetails.get(l).flightDetails();
			    }
			
		}
		
	}
	else if (option==3) {
	 String name;
	 String gender;
	String age;
	 String address;
	 String PassportNo;
	 String password;
	 String email;
		System.out.println("Enter Your Name:");
		name=input.readLine();
		System.out.println("Enter Your Gender(Male/Female):");
		gender=input.readLine();
		try {
			a.genderValidation(gender);
			}
			  catch (Exception ex)  
	        {  
	            System.out.println("Caught the exception");  
	            System.out.println("Exception occured: " + ex);  
	            return;
	        }
		System.out.println("Enter Your Age:");
		age=input.readLine();
	
		try {
		a.ageValidation(Integer.parseInt(age));
		}
		  catch (Exception ex)  
        {  
            System.out.println("Caught the exception");  
            System.out.println("Exception occured: " + ex);  
            return;
        }  
		System.out.println("Enter Your Address:");
		address=input.readLine();
		try {
			a.NullException(address, "Address");
			}
			  catch (Exception ex)  
	        {  
	            System.out.println("Caught the exception");  
	            System.out.println("Exception occured: " + ex);  
	            return;
	        } 
		
		System.out.println("Enter Your PassportNo:");
		PassportNo=input.readLine();
		try {
			a.NullException(PassportNo, "Passport");
			}
			  catch (Exception ex)  
	        {  
	            System.out.println("Caught the exception");  
	            System.out.println("Exception occured: " + ex);  
	            return;
	        } 
		System.out.println("Enter Your email:");
		email=input.readLine();
		try {
			a.NullException(email, "Email");
			}
			  catch (Exception ex)  
	        {  
	            System.out.println("Caught the exception");  
	            System.out.println("Exception occured: " + ex);  
	            return;
	        } 
		System.out.println("Enter Your passoword:");
		password=input.readLine();
		try {
			a.NullException(password, "Passowrd");
			}
			  catch (Exception ex)  
	        {  
	            System.out.println("Caught the exception");  
	            System.out.println("Exception occured: " + ex);  
	            return;
	        } 
		
		Passengerdata=new Passenger(name,gender,age,address,PassportNo,email,password);
		Passengerdata.addIntofile(name, gender, age, address, PassportNo, email, password);
		Passengerdata.displayDetails();
		loggedin=true;
		
	}
	else if(option==4)
	{
		String emailString;
		String passwordString;
	System.out.println("\nPlease Enter your Credentials to log in the System");
	System.out.print("Please enter your Email:");
	emailString=input.readLine();
	System.out.print("\nPlease enter your Password:");
	passwordString=input.readLine();	
	Passengerdata=new Passenger();
	if(Passengerdata.login(emailString, passwordString))
	{
	Passengerdata.displayDetails();
	System.out.println("User Logged In");
	loggedin=true;
	}
	else {
		System.out.println("User not found");
	}
	}else if(option==5) {
		String username;
		String password;
	System.out.println("\nPlease Enter your Credentials to log in the System");
	System.out.print("Please enter your username:");
	username=input.readLine();
	System.out.print("\nPlease enter your Password:");
	password=input.readLine();
	if(username.equals("admin")&&password.equals("admin"))
	{
		System.out.print("Welcome Admin\nSelect Revelant Option \n"
				+ "1)Check Flight Schedule \n2)Search Flights\n3)Check Passengers \n4)Check Bookings\nEnter Input:");
		int option3=Integer.parseInt(input.readLine());
		if(option3==1)
		{	
		for(int i=0;i<dataDetails.size();i++)
		{
			dataDetails.get(i).flightDetails();
		}
			
			
		}
		else if (option3==2) {
			int i;
			String arrivalString;
			String departureString;
			
		
			System.out.print("\n Enter City of Departure :");
			departureString=input.readLine();
			
			System.out.print("\n Enter city of Arrival:");
			arrivalString=input.readLine();
			
			 ArrayList<Integer> fl = new ArrayList<Integer>();
		for( i=0;i<dataDetails.size();i++)
			{
				if(dataDetails.get(i).Flightcheck(departureString, arrivalString))
				{
				fl.add(i);
					
				}
			}
			if(0==fl.size())
			{
				System.out.println("No flights avaliable between "+departureString+" "+arrivalString);
			}
			else {
				for (int l : fl) {
					dataDetails.get(l).flightDetails();
				    }
				
			}
			
		}
		else if (option3==3) {
			
			Passenger.details();
		}
else if (option3==4) {
			
			Passenger.bookingdetails();
		}
	}
	}
	
	else {
		System.out.print("Wrong Input:"+option);
	}
		
	
	if(loggedin)
	{
		
		System.out.print("You are Succesfully Logged \nSelect Revelant Option \n"
				+ "1)Reserve Flight\n2)Cancel Reservation\n3)Print Ticket \nEnter Input:");
		int option1=Integer.parseInt(input.readLine());
		if(option1==1)
		{
		String arrival;
		String departure;
		String date;
		if(Passengerdata.checkBooking())
		{
			 System.out.println("You have already Booked a Seat Please Cancel Reservation to Book new Seat");
			return;
		}
		System.out.print("\nEnter departure city:");
		departure=input.readLine();
		try {
			a.NullException(departure, "Departure city");
			}
			  catch (Exception ex)  
	        {  
	            System.out.println("Caught the exception");  
	            System.out.println("Exception occured: " + ex);  
	            return;
	        } 
		System.out.print("\nEnter Arrival city:");
		arrival=input.readLine();
		try {
			a.NullException(arrival, "Arrival City");
			}
			  catch (Exception ex)  
	        {  
	            System.out.println("Caught the exception");  
	            System.out.println("Exception occured: " + ex);  
	            return;
	        } 
		System.out.print("\nEnter Date Format(16/Nov/2021)");
		date=input.readLine();
		try {
			a.NullException(date, "Date format");
			}
			  catch (Exception ex)  
	        {  
	            System.out.println("Caught the exception");  
	            System.out.println("Exception occured: " + ex);  
	            return;
	        } 
		
		
		 ArrayList<Integer> fl = new ArrayList<Integer>();
			for(int i=0;i<dataDetails.size();i++)
				{
					if(dataDetails.get(i).Flightcheck(departure, arrival,date))
					{
					fl.add(i);
						
					}
				}
				if(0==fl.size())
				{
					System.out.println("No flights avaliable between "+departure+" "+arrival+" on date:"+date);
				}
				else {
					for (int l : fl) {
						System.out.print("\nFlight No:"+l);
						dataDetails.get(l).flightDetails();
					    }
					
					System.out.print("Do you want to Proceed towards Booking Seat(y/n):");
					String option2=input.readLine();
					try {
						a.yesno(option2);
					}
					catch (Exception e) {
						// TODO: handle exception
						System.out.println(e);
					}

					if(option2.equals("y")||option2.equals("Y"))
					{
						System.out.print("Please enter Flight No to book:");
						int flight;
						String classString;
						flight=Integer.parseInt(input.readLine());
						try {
							a.NullException(Integer.toString(flight), "Flight");
							}
							  catch (Exception ex)  
					        {  
					            System.out.println("Caught the exception");  
					            System.out.println("Exception occured: " + ex);  
					            return;
					        } 
						
						dataDetails.get(flight).flightDetails();
						System.out.print("Do you want to Book a Economy Class or Business Class(E/B)");
						classString=input.readLine();
						try {
							a.EB(classString);
						}
						catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}

						if(classString.equals("E")||classString.equals("e"))
						{
							System.out.println("Avaliable Seats");
							for(int i=dataDetails.get(flight).getEconomicclass();i<dataDetails.get(flight).getSeat();i++)
							{
								
								int j=i+1;
								if(dataDetails.get(flight).NotRseat(i))
								System.out.print(j+",");
							}
							
							System.out.print("\n Please Enter Seat you want to reserve:");
							int seat=Integer.parseInt(input.readLine());
							try {
								a.NullException(Integer.toString(seat), "Seat");
								}
								  catch (Exception ex)  
						        {  
						            System.out.println("Caught the exception");  
						            System.out.println("Exception occured: " + ex);  
						            return;
						        } 
							if(!dataDetails.get(flight).NotRseat(seat))
							{
							System.out.print("\nSeat Already Booked\n");	
							return;
							}
							dataDetails.get(flight).addBookedSeats(seat);
							String card;
							System.out.print("\n You have Pay:"+dataDetails.get(flight).getCostOfEconomicClass());
							System.out.print("\n Please Enter your Card Number:");
							card=input.readLine();
							try {
								a.NullException(card, "Card No");
								}
								  catch (Exception ex)  
						        {  
						            System.out.println("Caught the exception");  
						            System.out.println("Exception occured: " + ex);  
						            return;
						        } 
							Passengerdata.setFlightNo(flight);
							Passengerdata.setSeat(seat);
							Passengerdata.setCardNoString(card);
							Passengerdata.setPaymentq(true);
							Passengerdata.setFlightName(dataDetails.get(flight).getFlightid());
							System.out.println("Payment Recieved");
							Passengerdata.printTicket(dataDetails.get(flight));
							Passengerdata.addbookingData(dataDetails.get(flight));
							
										
						}
						else if(classString.equals("B")||classString.equals("b"))
						{
							
								System.out.println("Avaliable Seats");
								for(int i=0;i<dataDetails.get(flight).getBussinessclass();i++)
								{
									int j=i+1;
									if(dataDetails.get(flight).NotRseat(i))
									System.out.print(j+",");
								}
								
								System.out.print("\n Please Enter Seat you want to reserve:");
								int seat=Integer.parseInt(input.readLine());
								try {
									a.NullException(Integer.toString(seat), "Seat");
									}
									  catch (Exception ex)  
							        {  
							            System.out.println("Caught the exception");  
							            System.out.println("Exception occured: " + ex);  
							            return;
							        } 
								if(!dataDetails.get(flight).NotRseat(seat))
								{
								System.out.print("\nSeat Already Booked\n");	
								return;
								}
								dataDetails.get(flight).addBookedSeats(seat);
								String card;
								System.out.print("\n You have Pay:"+dataDetails.get(flight).getCostOfBusinessClass());
								System.out.print("\n Please Enter your Card Number:");
								card=input.readLine();
								try {
									a.NullException(card, "Card No");
									}
									  catch (Exception ex)  
							        {  
							            System.out.println("Caught the exception");  
							            System.out.println("Exception occured: " + ex);  
							            return;
							        } 
							
								Passengerdata.setFlightNo(flight);
								Passengerdata.setSeat(seat);
								Passengerdata.setCardNoString(card);
								Passengerdata.setPaymentq(true);
								Passengerdata.setFlightName(dataDetails.get(flight).getFlightid());
								System.out.println("Payment Recieved");
								Passengerdata.printTicket(dataDetails.get(flight));
								Passengerdata.addbookingData(dataDetails.get(flight));
											
						
						
						
						
					}
				}
		
		
		
			
		}
		
	}
	else if(option1==2) {
		if(!Passengerdata.checkBooking())
		{
			System.out.println("You dont have any Bookings");
		}
		else {
			System.out.println("Do you really Want to cancel Your Booking(Y/N):");
			String optionString=input.readLine();
			try {
				a.yesno(optionString);
				}
				  catch (Exception ex)  
		        {  
		            System.out.println("Caught the exception");  
		            System.out.println("Exception occured: " + ex);  
		            return;
		        } 
			if(optionString.equals("y")||optionString.equals("Y"))
			{
				Passengerdata.cancelReservation();
				dataDetails.get(Passengerdata.getFlightNo()).cancelSeat(Integer.toString(Passengerdata.getSeat()));
			}
			
			
		}
	}	
	else if(option1==3)
	{
		if(Passengerdata.checkBooking())
		{
		Passengerdata.printTicket1();
		}
		else {
			System.out.print("Please Reserve Ticket");
		}
	}
		else {
			System.out.print("Wrong Option:"+option1);
		}
	
		
		
		
		
		
		
		
		
		
		
//		BufferedReader input = new BufferedReader(
//	            new InputStreamReader(System.in));
//		String name=input.readLine();
//		
//		System.out.print("\nEnter your age:");
//		String Age=input.readLine();
//		
//		System.out.print("\nEnter your Address:");
//		String Address=input.readLine();
//		
//		System.out.print("\nEnter your Passport Number:"); 
//		String PassportID=input.readLine();
//		
//		
//	Passenger customer=new Passenger(name,Age,Address,PassportID);
//	customer.displayDetails();	
//		
		
		
		
		
	}
	
	}
}


 