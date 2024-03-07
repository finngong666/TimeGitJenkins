package time;

import java.util.Scanner;

/**
 * @modfied by Liz Dancy
 * Used to show how to catch multiple Exceptions and then as a base class
 * for the testing exercise with JUnit
 *
 */


import javax.swing.JOptionPane;

/**
 * Taken from Wendi Jollymore :http://www-acad.sheridanc.on.ca/~jollymor/prog24178/oop2.html
 * @modfied by Liz Dancy
 * Used  as a base class
 * for the testing exercise with JUnit
 *  Winter 2021
 */
public class Time
{
	public static void main(String[] args) 
	{
		try {
            String time = JOptionPane.showInputDialog(null,
                "Enter a time in the format hh:mm:ss.SSS", "Enter Time",
                JOptionPane.QUESTION_MESSAGE);

            int totalMilliseconds = getTotalMilliseconds(time);
            JOptionPane.showMessageDialog(null, totalMilliseconds, "Total Milliseconds",
                JOptionPane.INFORMATION_MESSAGE);
        } catch (StringIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null,
                    "You entered the time in the wrong format.\n" +
                    "Please enter the time in the form hh:mm:ss.SSS",
                    "Invalid Time", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "You entered an invalid time.\nPlease enter numbers only.",
                    "Invalid Time", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            System.out.println("An unexpected Exception occurred");
        }
    }

    public static int getTotalMilliseconds(String time) throws NumberFormatException, StringIndexOutOfBoundsException {
        int hours = getTotalHours(time);
        int minutes = getTotalMinutes(time);
        int seconds = getSeconds(time);
        int milliseconds = getMilliseconds(time);
        return (hours * 3600 + minutes * 60 + seconds) * 1000 + milliseconds;
    }

    public static int getMilliseconds(String time) throws NumberFormatException, StringIndexOutOfBoundsException {
        if (time.length() != 12) {
            throw new NumberFormatException("The time format is incorrect. Please enter the time as hh:mm:ss.SSS.");
        }
        return Integer.parseInt(time.substring(9));
    }
    
    
   
    public static int getSeconds(String time) throws NumberFormatException, StringIndexOutOfBoundsException {
        return Integer.parseInt(time.substring(6, 8));
    }

    public static int getTotalMinutes(String time) throws NumberFormatException, StringIndexOutOfBoundsException {
        if (time.length() < 8) {
            throw new NumberFormatException("The time format is too short. Please enter the time as hh:mm:ss.SSS.");
        }
        return Integer.parseInt(time.substring(3, 5));
    }

    public static int getTotalHours(String time) throws NumberFormatException, StringIndexOutOfBoundsException {
        if (time.length() < 2) {
            throw new NumberFormatException("The time format is too short. Please enter the time as hh:mm:ss.SSS.");
        }
        return Integer.parseInt(time.substring(0, 2));
    }
	
	
	 

	
}



