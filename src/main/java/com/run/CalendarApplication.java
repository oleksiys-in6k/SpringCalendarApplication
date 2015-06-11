package com.run;

import com.creatingCalendar.MonthCalendarFile;
import com.creatingCalendar.Year;
import com.fillMonthCalendar.MonthCalendar;
import com.reader.CalendarReader;
import com.writer.CalendarWriter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CalendarApplication {

    private CalendarWriter calendarWriter;
    private CalendarReader reader;


    public void execute() throws FileNotFoundException {

        List <MonthCalendar> monthCalendars = reader.getMonths();
        //System.out.println(monthCalendars.get(0));
        for (MonthCalendar month : monthCalendars)
            System.out.println(calendarWriter.render(month));
    }

    public void setReader(CalendarReader reader) {
        this.reader = reader;
    }

    public void setCalendarWriter(CalendarWriter calendarWriter) {
        this.calendarWriter = calendarWriter;
    }

    public List<MonthCalendarFile> creatingListOfAllMonths() throws FileNotFoundException {
        InputConfigReader config = new InputConfigReader();
        List<Year> years = config.getMonthsFromConfig();

        List<MonthCalendarFile> allMonths = new ArrayList<>();

        for (Year year : years) {
            allMonths.addAll(year.getMonths());
        }
        return allMonths;
    }

    public void writeEachMonthInConsole(List<MonthCalendarFile> allMonths) {
        ListIterator<MonthCalendarFile> it = allMonths.listIterator();
        while (it.hasNext()) {
            MonthCalendarFile previous = null, next = null;
            if (it.hasPrevious()) {
                previous = allMonths.get(it.previousIndex());
            }

            MonthCalendarFile calendarFile = it.next();

            if (it.hasNext()) {
                next = allMonths.get(it.nextIndex());
            }
            calendarFile.writeToConsole(previous, next);
        }
    }

    public void writeEachMonthInOwnFile(List<MonthCalendarFile> allMonths) throws FileNotFoundException {
        ListIterator<MonthCalendarFile> it = allMonths.listIterator();
        while (it.hasNext())

        {
            MonthCalendarFile previous = null, next = null;

            if (it.hasPrevious()) {
                previous = allMonths.get(it.previousIndex());
            }

            MonthCalendarFile calendarFile = it.next();

            if (it.hasNext()) {
                next = allMonths.get(it.nextIndex());
            }
            calendarFile.writeToFile(previous, next);
        }
    }

}
