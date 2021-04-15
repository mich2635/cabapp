package cab;
import java.util.*;
import java.time.*;
import java.util.Scanner;
public class Main {
	/**
	 * method -car types function
	 */
	public static void cartypes() {
		Scanner sp=new Scanner(System.in);							//sp is scanner object for page 1
		System.out.println("Select the car types");
		System.out.println("1.MICRO(Rs 10/km)");
		System.out.println("2.MINI(Rs 15/km)");
		System.out.println("3.PRIME(Rs 20/km)");
		int ch=sp.nextInt();										//ch is choice
		priceestimation(ch);
		sp.close();
		
	}
	/**
	 * method price estimation
	 * @param ch
	 */
	public static void priceestimation(int ch)
	{
		int cost;
		float gst;													//gst is gst value
		float gstcost;
		Scanner st=new Scanner(System.in);							//st is scanner object for page 3
		System.out.println("Enter the km");
		int km=st.nextInt();
		switch(ch) {
		case 1:
			cost=km*10;
			System.out.println("YOUR TRAVEL AMOUNT!!!"+cost);
			gst=(float)0.07*cost;
			System.out.println("YOUR GST PERCENTAGE"+gst);
			gstcost=(float)cost+gst;
			System.out.println("YOUR AMOUNT INCLUDING GST:  "+gstcost);
			booking(gstcost);
			break;
		case 2:
			cost=km*15;
			System.out.println("YOUR TOTAL AMOUNT"+cost);
			gst=(float)0.07*cost;
			System.out.println("YOUR GST PERCENTAGE"+gst);
			gstcost=(float)cost+gst;
			System.out.println("YOUR AMOUNT INCLUDING GST:  "+gstcost);
			booking(gstcost);
			break;
		case 3:
			cost=km*20;
			System.out.println("YOUR TOTAL AMOUNT"+cost);
			gst=(float)0.07*cost;
			System.out.println("YOUR GST PERCENTAGE"+gst);
			gstcost=(float)cost+gst;
			System.out.println("YOUR AMOUNT INCLUDING GST:  "+gstcost);
			booking(gstcost);
			break;
		default :
			System.out.println("SELECT THE CAR CORRECTLY!!!");
			break;
			
		
		}
		st.close();
	}
	/**
	 * method booking
	 * @param gstcost
	 */
	public static void booking(float gstcost) {
		try {
		float gstcost1=gstcost;
		Scanner si=new Scanner(System.in);							//si is scanner object
		System.out.println("ENTER THE JOURNEY DATE");
		String jdate=si.next();										//jdate is journey date
		System.out.println("ENTER THE TIME IN HH:MM FORMAT!!");
		String time=si.next();				
		System.out.println("YOUR JOURNEY DATE"+jdate);
		peaktime(gstcost1,time);
		si.close();
		}
		catch(Exception e) {
			System.out.println("ENTER THE DETAILS CORRECTLY!!!");
		}
		
	}
	public static void peaktime(float gstcost,String time1) {
		String time=time1.concat(":30");

		LocalTime rectime=LocalTime.parse(time);					//recttime is recent time
		int check=rectime.getHour();
		if(check>=17&&check<=19) {
			float cost=(float)(0.0125*gstcost)+gstcost;
			System.out.println("TTHIS IS PEAK HOUR SO IT COSTS EXTRA 1.25%!!!"+cost);
			seniorcitizen(cost);
		}
		else
		{
			System.out.println("THIS IS NOT PEAK HOUR SO NO SPECIAL CHARGE");
			seniorcitizen(gstcost);
		}
		
	}
	/**
	 * method senior citizen
	 * @param cost
	 */
	public static void seniorcitizen(float cost) {
		
		Scanner sl=new Scanner(System.in);							//sl is scanner object
		try {
		System.out.println("ENTER YOUR DOB IN YYYY-MM-DD FORMAT!!");
		String s=sl.next();
		LocalDate age=LocalDate.parse(s);
		int age1=age.getYear();
		LocalDateTime rectime=LocalDateTime.now();
		int curyear=rectime.getYear();
		int yage=curyear-age1;
		if(yage>60) {
			float yourbill=(float)cost/2;
			System.out.println("YOUR A SENIOR CITIZEN SO ENJOY 50% DISCOUNT!!!"+yourbill);
			System.out.println("HAPPY JOURNEY");
		}else {
			System.out.println("YOUR NOT A SENIOR CITIZEN SO THERE IS NO DISCOUNT!!!"+cost);
			System.out.println("HAPPY JOURNEY");
		}
		sl.close();
		}
		catch(Exception e) {
			System.out.println("ENTER THE DEAILS CORRECTLY!!!");
			login();
		}
			
	}
	/**
	 * main method
	 * @param args
	 */public static void login(){
		 Scanner sc=new Scanner(System.in);							//sc is scanner object
			//log in page
			long ver=8870907039L;
			int ver1=1234;												//ver means verification value
			System.out.println("enter the mobile number");
			double phno=sc.nextDouble();								//phno=phone number
			System.out.println("enter the password");
			int paswrd=sc.nextInt();									//paswrd=password
			if(phno==ver&&paswrd==ver1)
			{
				cartypes();
			}
			else
			{
				System.out.println("Enter the correct login id");
				login();
			}
			sc.close();
	 }
	 
	public static void main(String[] args) {
		login();
	}
	}


