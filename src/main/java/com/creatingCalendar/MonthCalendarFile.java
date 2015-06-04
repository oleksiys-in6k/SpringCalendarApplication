package com.creatingCalendar;

import com.fillMonthCalendar.MonthCalendar;
import com.render.ConsoleCalendarRender;
import com.render.HTMLCalendarRender;
import com.render.CalendarRender;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MonthCalendarFile {
    public static CalendarRender calendarRender;

    public static final String OUTPUT_DIR = "output";
    private static final String HTMLEXTENSION = ".html";

    private Calendar calendar = Calendar.getInstance();
    private MonthCalendar monthCalendar;
    private File file;

    public MonthCalendarFile(Calendar calendar) {
        this.calendar.setTime(calendar.getTime());
        this.monthCalendar = new MonthCalendar(calendar);
        this.file = new File(getPathToFile(calendar));

        deleteOutputDirectory( new File(OUTPUT_DIR));
    }

    private void deleteOutputDirectory(File directory) {
        if (directory.isDirectory()) {
            String[] children = directory.list();
            for (String aChildren : children) {
                File susItem = new File(directory, aChildren);
                deleteOutputDirectory(susItem);
            }
            directory.delete();
        } else directory.delete();
    }

    private String getPathToFile(Calendar c) {
        return OUTPUT_DIR
                + File.separator
                + c.get(Calendar.YEAR)
                + File.separator
                + new SwitchesOfMonth().getMonthNameByIndex((c.get(Calendar.MONTH)))
                + HTMLEXTENSION;
    }

    public void writeToFile(MonthCalendarFile previous, MonthCalendarFile next) throws FileNotFoundException {
        File directory = new File(file.getParent() + File.separator);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        PrintWriter writer = new PrintWriter(file);

        if (previous != null) {
            writer.println(previous.getLink());
        }
        if (next != null) {
            writer.println(next.getLink());
        }

        calendarRender = new HTMLCalendarRender();
        writer.println("<h1>" + getMonthTitle() + "</h1>");
        writer.println(calendarRender.render(monthCalendar));
        writer.close();
    }

    public void writeToConsole (MonthCalendarFile previous, MonthCalendarFile next) {
        calendarRender = new ConsoleCalendarRender();
        System.out.println(getMonthTitle() );
        System.out.println(calendarRender.render(monthCalendar));

    }

    private String getLink() {
        String pathToIndex = getPathToFile(calendar);
        String s = "<a href=\"../../" + pathToIndex + "\">"+ getMonthTitle() + "</a>" ;
        return s;
    }

    private String getMonthTitle() {
        SimpleDateFormat format = new SimpleDateFormat("MMMM YYYY");
        return format.format(calendar.getTime());
    }

}
