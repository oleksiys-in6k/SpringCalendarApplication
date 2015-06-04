package com.fillMonthCalendar;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.core.IsSame.sameInstance;

public class WeekDayTest {

    @Test
    public void constructor() throws Exception {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2012, Calendar.JANUARY, 1);

        WeekDay wd = new WeekDay(calendar1);

        assertThat(wd.getCalendar(), not(sameInstance(calendar1)));

        WeekDayType wdt = WeekDayType.values()[calendar1.get(Calendar.DAY_OF_WEEK) - 1];

        assertThat(wd.getType(), is (wdt));
    }

    @Test
    public void sameDaysWithDifferentMilliseconds__shouldBeEqual() throws Exception {
        Calendar calendar = Calendar.getInstance();
        Calendar twoMinutesLater = (Calendar) calendar.clone();
        twoMinutesLater.add(Calendar.MINUTE, 2);

        assertThat(new WeekDay(calendar).equals(new WeekDay(twoMinutesLater)), is (true) );
    }

    @Test
    public void weekDaysWithDifferentDayOfMonth__shouldNotBeEqual() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JUNE, 1);
        Calendar anotherDay = (Calendar) calendar.clone();
        anotherDay.set(Calendar.DAY_OF_MONTH, 2);

        assertThat( new WeekDay(calendar).equals(new WeekDay(anotherDay)), is (false) );
    }
    @Test
    public void weekDaysWithDifferentMonths__shouldNotBeEqual() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JUNE, 1);
        Calendar anotherDay = (Calendar) calendar.clone();
        anotherDay.set(Calendar.MONTH, Calendar.JULY);

        assertThat( new WeekDay(calendar).equals(new WeekDay(anotherDay)), is (false) );
    }
    @Test
    public void weekDaysWithDifferentYears__shouldNotBeEqual() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JUNE, 1);
        Calendar anotherDay = (Calendar) calendar.clone();
        anotherDay.set(Calendar.YEAR, 2016);

        assertThat( new WeekDay(calendar).equals(new WeekDay(anotherDay)), is (false) );
    }

}
