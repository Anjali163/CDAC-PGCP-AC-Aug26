import java.util.Scanner;

class DaysOfWeek{
	public static void main(String args[]){
		
	int DayNumber = 3;
	
	switch (DayNumber){
		case 1: 
			{System.out.println("The Day is Monday");
			} break;
		case 2: 
			{System.out.println("The Day is Tuesday");
			} break;
		case 3: 
			{System.out.println("The Day is Wednesday");
			} break;
		case 4: 
			{System.out.println("The Day is Thrusday");
			} break;
		case 5: 
			{System.out.println("The Day is Friday");
			} break;
		case 6: 
			{System.out.println("The Day is Saturaday");
			} break;
		case 7: 
			{System.out.println("The Day is Sunday");
			} break;
		default:
			{System.out.println("Invalid Day Number");
			}
		}
	}
}