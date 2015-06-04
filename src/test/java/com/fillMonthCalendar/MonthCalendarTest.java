package com.fillMonthCalendar;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MonthCalendarTest {

    @Test
    public void constructor() throws Exception {

        List<Week> weeks = new ArrayList<Week>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2012,Calendar.JANUARY,1);

        MonthCalendar monthCalendar = new MonthCalendar(calendar);

        weeks.add(new Week(calendar));     calendar.add(Calendar.DAY_OF_YEAR,7);
        weeks.add(new Week(calendar));     calendar.add(Calendar.DAY_OF_YEAR,7);
        weeks.add(new Week(calendar));     calendar.add(Calendar.DAY_OF_YEAR,7);
        weeks.add(new Week(calendar));     calendar.add(Calendar.DAY_OF_YEAR,7);
        weeks.add(new Week(calendar));     calendar.add(Calendar.DAY_OF_YEAR,7);

        assertThat(monthCalendar.getWeeks(), is (weeks));

    }
}
