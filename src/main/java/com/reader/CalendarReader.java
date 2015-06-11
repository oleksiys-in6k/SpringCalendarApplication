package com.reader;

import com.creatingCalendar.Year;
import com.fillMonthCalendar.MonthCalendar;

import java.io.FileNotFoundException;
import java.util.List;

public interface CalendarReader {
    List <MonthCalendar> getMonths() throws FileNotFoundException;
}
