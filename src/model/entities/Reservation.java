package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}


	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();//Calcula a diferença entre as datas em Milisegundos
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);//Converte os Milisegundos pare Dias
		
	
	}
	public String updateDates(Date checkIn , Date checkOut) {
		
		Date now = new Date();
		if(checkIn.before(now)|| checkOut.before(now)) {
			return " RESERVATION DATES FOR UPDATE MUST FUTURE DATES ";

		}
		if(checkIn.after (checkIn)) {
			return "ERROR IN RESEVATION : CHECK-OUT DATES  MUST BE AFTER CHECK-IN DATE";

		}
		
		this.checkIn=checkIn;
		this.checkOut=checkOut;
		return null;
		
	}
	@Override
	public String toString() {
		
		return "Room"
			+ roomNumber
			+ ", Check-In:"
			+sdf.format(checkIn)
			+" , Check-Out:"
			+sdf.format(checkIn)
			+" , "
			+duration()
			+" Nights ";

	}


}

