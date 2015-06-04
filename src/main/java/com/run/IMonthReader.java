package com.run;

import com.fillMonthCalendar.MonthCalendar;

import java.io.FileNotFoundException;
import java.util.List;

public interface IMonthReader {
    List <MonthCalendar> getMonths() throws FileNotFoundException;
}
