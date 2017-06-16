import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Created by kuwu on 2017/06/11.
 * This program will calculate the duration between the dates
 * in Years, Months and Days. The result of the difference
 * will be output to the console.
 */


public class DateDifference {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
    Scanner scnr = new Scanner(System.in);

    // Get date input, txt allows Method to be used more than once.
    LocalDate getDate(String txt) {
        System.out.println("Enter " + txt + " date:  mm dd yyyy"); // txt allows Method to be used more than once.
        String text = scnr.nextLine();
        LocalDate date;


        // check for correct input of date.
        try {
            date = LocalDate.parse(text, formatter);
            System.out.printf("%s%n", date);

        } catch (DateTimeParseException exc) {
            System.out.printf("Error, please retype the date. You entered %s %n", text);
            throw exc;     // Rethrow the exception.
        }

        return date;

    }



    public static void main(String[] args) {

        // The Method asks for the first and second date
        DateDifference main = new DateDifference();
        LocalDate one = main.getDate("first");
        LocalDate two = main.getDate("second");


        // Use Period Class to find the difference between the two dates.
        Period p = Period.between(one,two);

        // Print out of the difference
        System.out.println("The difference between the two dates is "+p.getYears()+" years, "+p.getMonths()+" months, and "+p.getDays()+" days.");

        return;


    }
}