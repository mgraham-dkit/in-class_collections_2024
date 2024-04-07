package reference;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class SampleWorkingWithDateTime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        LocalDate firstDate = null;
        boolean valid = false;
        System.out.println("Please enter a date using the format yyyy-MM-dd:");
        while(!valid) {
            String first = input.nextLine();
            try {
                // Create a date by parsing a text representation into a date object
                // This will use the default format of year-month-date (yyyy-MM-dd)
                firstDate = LocalDate.parse(first);
                // Toggle the boolean flag to indicate a valid date has been entered
                // (You only get to here if the parse action doesn't throw an exception)
                valid = true;
            } // Catch the potential exception where the user has entered something
            // not matching the required format
            catch(DateTimeParseException e){
                System.out.println("Please try again using the format yyyy-MM-dd");
            }
        }
        System.out.println("Date created!");
        System.out.println("The date you entered was: " + firstDate.getDayOfMonth() + " of "+ firstDate.getMonth() +
                ", " + firstDate.getYear());

        // Create a Date formatter to define the custom structure for your dates
        // Whatever is specified as the pattern is the structure that will be used
        // There are different symbols for different components
            // yyyy means the full year, yy means the final two digits
            // MM means month of year in numbers (case matters here, as mm means minute of HOUR!)
            // dd means day of month in numbers (case matters here, as DD means day of YEAR!)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate secondDate = null;
        valid = false;
        System.out.println("Please enter a new date in the format dd/MM/yyyy)");
        while(!valid){
            String first = input.nextLine();
            try {
                // Convert the text into a date, using the formatter to dictate how it should be parsed
                secondDate = LocalDate.parse(first, formatter);
                valid = true;
            } // Catch the potential format issue
            catch(DateTimeParseException e){
                System.out.println("Please try again using the format dd/MM/yyyy");
            }
        }

        System.out.println("Date created!");
        System.out.println("The date you entered was: " + secondDate.getDayOfMonth() + " of "+ secondDate.getMonth() +
                ", " + secondDate.getYear());
    }
}
