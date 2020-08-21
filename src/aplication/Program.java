package aplication;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Room number:");
		int number =sc.nextInt();
		System.out.print("Check-In date (dd/MM/yyyy):");
		Date checkIn = sdf.parse(sc.next());	
		System.out.print("Check-Out date (dd/MM/yyyy):");
		Date checkOut = sdf.parse(sc.next());
		  
		//https://github.com/acenelio/exceptions1-java
		
		if(!checkOut.after(checkIn)) {
			System.out.println("ERROR IN RESERVATION : CHECK-OUT DATE MUST BE AFTER CHECK-IN DATE");
			
			
		}
		else {
			Reservation reservation = new Reservation(number, checkIn ,checkOut);
			System.out.println("Reservation: "+ reservation);
		
		
		System.out.println();
		System.out.println("Enter data to update the reservation: ");
	
		System.out.print("Check-In date (dd/MM/yyyy):");
		checkIn = sdf.parse(sc.next());	
		System.out.print("Check-Out date (dd/MM/yyyy):");
		checkOut = sdf.parse(sc.next());
		
		Date now = new Date();
		
		if(checkIn.before(now)|| checkOut.before(now)) {
			System.out.println("ERROR IN RESEVATION : RESERVATION DATES FOR UPDATE MUST FUTURE DATES ");

		}
		else if(checkIn.before(now)|| checkOut.before(now)) {
			System.out.println("ERROR IN RESEVATION : RESERVATION DATES FOR UPDATE MUST FUTURE DATES ");

		}else {
		
		reservation.updateDates(checkIn, checkOut);
		System.out.println("Reservation: "+ reservation);
		
		}
		
		
		}
		sc.close();
	}

}
