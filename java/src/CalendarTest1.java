//WAJP to print the calender for the current month as per the locale using the API class Gregorian Calender. Mark the current date with a *

import java.text.DateFormatSymbols;
import java.util.*;
public class CalendarTest1
{
   public static void main(String[] args)
   {

	System.out.printf("%s\n",Locale.getDefault());
	

     
      GregorianCalendar d = new GregorianCalendar();

     
      int today = d.get(Calendar.DAY_OF_MONTH);
      int month = d.get(Calendar.MONTH);

      // [3] set d to start date of the month
      d.set(Calendar.DAY_OF_MONTH, 1);

      /** [4] Fetch from d the value of the weekday (Sun to Sat) corresponding to the
              start day (dd) of the month */
      int weekday = d.get(Calendar.DAY_OF_WEEK);

      // [5] get first day of week (Sunday in the U.S.) in that locale
      int firstDayOfWeek = d.getFirstDayOfWeek();

      // [6] determine the required indentation for the first line
      int indent = 0;
      while (weekday != firstDayOfWeek)
      {
         indent++;
         d.add(Calendar.DAY_OF_MONTH, -1);
         weekday = d.get(Calendar.DAY_OF_WEEK);
      }

      // [7] print weekday names
      String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
      do
      {
         System.out.printf("%4s", weekdayNames[weekday]);
         d.add(Calendar.DAY_OF_MONTH, 1);
         weekday = d.get(Calendar.DAY_OF_WEEK);
      }
      while (weekday != firstDayOfWeek);
      System.out.println();


      // [8] Printing the spaces
      for (int i = 1; i <= indent; i++)
         System.out.print("    ");
	
      // [9] set d to first day of the month and then print each date till month changes
      d.set(Calendar.DAY_OF_MONTH, 1);

      // till month doesn't change
      do
      {
         // print day
         int day = d.get(Calendar.DAY_OF_MONTH);
         System.out.printf("%3d", day);

         // mark current day with *
         if (day == today) System.out.print("*");
         else System.out.print(" ");

         // advance d to the next day
         d.add(Calendar.DAY_OF_MONTH, 1);
         weekday = d.get(Calendar.DAY_OF_WEEK);

         // start a new line at the start of the week
         if (weekday == firstDayOfWeek) System.out.println();
      }
      while (d.get(Calendar.MONTH) == month);
      // the loop exits when d is day 1 of the next month

      // print final end of line if necessary
      if (weekday != firstDayOfWeek) System.out.println();
   }
}
