package com.springReader;

import com.fillMonthCalendar.MonthCalendar;
import com.run.IMonthReader;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements IMonthReader {
    @Override
    public List<MonthCalendar> getMonths() {

        System.out.println("Enter Year");
        Scanner scanner = new Scanner(System.in);
        int year = Integer.parseInt(scanner.next());
        System.out.println("Enter month");
        int month = Integer.parseInt(scanner.next());


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.MONTH, month - 1 );
        calendar.set(Calendar.YEAR, year);

        MonthCalendar monthCalendar = new MonthCalendar(calendar);
        List <MonthCalendar> list = new ArrayList <> ();
        list.add(monthCalendar);

        return list;
    }
}
