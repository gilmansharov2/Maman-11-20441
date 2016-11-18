import java.util.Scanner;
public class Milliseconds {

	/**
	 We need to convert milliseconds to a form of days, hours, minutes and seconds.
	 The days will be represented as: milliseconds divided by minute(60 seconds=60000 milliseconds), divided by hour(60 minutes=3600 seconds), divided by day(24 hours=1440 minutes), divided by second(seconds=1000 milliseconds).
	 Now that we represented each time value as milliseconds, we need to subtract the milliseconds we calcuated(days as milliseconds will be subtracted from the milliseconds variable etc.).
	 
	 The constants represents days, hours, minutes and seconds - in milliseconds.
	 */
	
	public static void main(String[] args) 
	{
		final long SECOND = 1000, MINUTE = SECOND * 60, HOUR = MINUTE * 60, DAY = HOUR * 24; // Second is 1000 milliseconds, minute is 60 seconds, hour is 60 minutes, day is 24 hours. We declare constant variable for each time value
		long days, hours, minutes, seconds; //Variable declaration: each identifier represents a time value, these variables value is depended on the milliseconds variable (long ms) that will be adjusted below.
		
		Scanner scan = new Scanner (System.in);
		System.out.println("This program reads an integer which " + "hours, minutes and seconds. ");
		System.out.println("Please enter the number of Milliseconds");
		long ms = scan.nextLong();
		scan.close();
		days = ms / DAY; // the number of days equals [milliseconds]/[maximum_seconds]/[maximum_minutes]/[maximum_hours]/[milliseconds/seconds]
		ms -= days * DAY; // subtracting the [days] variable from the [ms] variable
		hours = ms / HOUR; // the number of hours equals [milliseconds]/[maximum_seconds]/[maximum_minutes]/[milliseconds/seconds]
		ms -= hours * HOUR; // subtracting the [hours] variable from the [ms] variable
		minutes = ms / MINUTE; // the number of minutes equals [milliseconds]/[maximum_seconds]/[milliseconds/seconds]
		ms -= minutes * MINUTE; // subtracting the [minutes] variable from the [ms] variable
		seconds = ms / SECOND; // dividing seconds by milliseconds, because what's left from milliseconds is the seconds (multiplied by 1000) 
		
		
		System.out.println(days + " days " + hours + ":" + minutes + ":" + seconds + " hours");

	}

}
