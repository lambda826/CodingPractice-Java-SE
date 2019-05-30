/**
 *  @author Yunxiang He
 *  @date   04/17/2019
 */

package java8.api.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

/*

Immutable
Plain date without the time
Doesn't carry any information about the time zone

*/

public class _001_LocalDate {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.of(2017, 9, 21); // create an instance by using the of static factory method
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();
        

        System.out.println(today);
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        System.out.println(dow);
        System.out.println(len);
        System.out.println(leap);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
