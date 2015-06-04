package com.springReader;

import com.creatingCalendar.InputConfigReader;
import com.creatingCalendar.Year;
import com.fillMonthCalendar.MonthCalendar;
import com.run.IMonthReader;

import java.io.FileNotFoundException;
import java.util.List;

public class ConfigFileInput implements IMonthReader {

    @Override
    public List<MonthCalendar> getMonths() throws FileNotFoundException {
        InputConfigReader config = new InputConfigReader();
        List<Year> years = config.getMonthsFromConfig();





        System.out.println(years);

        return null;
    }
}
