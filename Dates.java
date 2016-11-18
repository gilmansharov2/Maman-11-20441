import java.util.Scanner;
public class Dates {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in); // defining a scanner
		int day, month, year; // Declaration of variables
		int num;
		System.out.println("Please enter 3 integers to represent a valid date:");
		day = scan.nextInt(); //day
		month = scan.nextInt(); // month
		year = scan.nextInt(); // year
		
		if (day > 31 || month > 12 || month < 1 || day < 1 || year < 1) // day is not between 1-31 or month is not between 1-12 or year isn't positive 
			System.out.println("The original date " + day +"/" + month + "/" + year + " is invalid."); 
		
		else if ((year%4!=0 || year%100==0 && year%400 != 0) && month==2 && day > 28) // February days bigger than 28 and year is not leap
			System.out.println("The original date " + day +"/" + month + "/" + year + " is invalid.");
		
		else if (((year%4==0 && year%100!=0) || year%400==0) && month==2 && day > 29) // February days bigger than 29 and year is leaped
			System.out.println("The original date " + day +"/" + month + "/" + year + " is invalid.");
		
		else if (month == 4 && day > 30) // 31/4 is not valid
			System.out.println("The original date " + day +"/" + month + "/" + year + " is invalid.");
		
		else if (month == 6 && day > 30) // 31/6 is not valid
			System.out.println("The original date " + day +"/" + month + "/" + year + " is invalid.");
		
		else if (month == 9 && day > 30) // 31/9 is not valid
			System.out.println("The original date " + day +"/" + month + "/" + year + " is invalid.");
		
		else if (month == 11 && day > 30) // 31/11 is not valid
			System.out.println("The original date " + day +"/" + month + "/" + year + " is invalid.");
		
		else // rest of the dates
		{
			System.out.println("Please enter an integer which represents the number of days:");
			num = scan.nextInt();
			if (num > 10) // num is bigger than 10
				System.out.println("The number of days must be bertween 1-10.");
			else if (num <= 0) // num isn't positive
				System.out.println("The number of days must be positive.");
			else // num is valid
			{
				System.out.println("The original date is " + day + "/" + month + "/" + year + ".");
				day += num;
				if (day <= 28) // if the days are smaller than 28, no need to change the month or the year. we won't change the year if the month will increase since the month isn't December (12)
					System.out.println("After " + num + " days the date is " + day + "/" + month + "/" + year + ".");
				else if (month == 2) // if it's February we'l check for two cases: leap year and not a leap year
				{
					if ((year%4==0 && year%100!=0) || year%400==0) // leap year
					{
						if (day == 29)
							System.out.println("After " + num + " days the date is " + day + "/" + month + "/" + year + ".");
						else
						{
							day -= 29;
							month++;
							System.out.println("After " + num + " days the date is " + day + "/" + month + "/" + year + ".");
						}
					}
					else // not a leap year
					{
						day -= 28;
						month++;
						System.out.println("After " + num + " days the date is " + day + "/" + month + "/" + year + ".");
					}
				}
				else if (month == 4 || month == 6 || month == 9 || month == 11) // if it's April, June, September or November (4, 6, 9 or 11)
				{
					if (day <= 30) // If the days are smaller or equal to 30, no need to change the month
						System.out.println("After " + num + " days the date is " + day + "/" + month + "/" + year + ".");
					else // if the days are bigger than 30, we will increase the month by 1 and decrease the days by 30, the year won't change since we know the month is not December
					{
						day -= 30;
						month++;
						System.out.println("After " + num + " days the date is " + day + "/" + month + "/" + year + ".");
					}
				}
				else // if it's the rest of the months with 31 days
				{
					if (day <= 31)
						System.out.println("After " + num + " days the date is " + day + "/" + month + "/" + year + ".");
					else
					{
						day -= 31;
						month++;
						if (month > 12)  // if December became January, it means we need to increase the year
						{
							year++;
							month = 1;
						}
						System.out.println("After " + num + " days the date is " + day + "/" + month + "/" + year + ".");
					}
				}
			}
		}
		scan.close();
	}

}
