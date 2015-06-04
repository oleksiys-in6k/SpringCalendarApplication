package com.fillMonthCalendar;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WeekTest {

    Calendar calendar;

    @Before
    public void calendarInit() throws Exception {
        calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JUNE, 1);
    }

    @Test
    //@Ignore
    public void createNextWeek() throws Exception {
        // given
        Week week = new Week(calendar);

        // when
        Week nextWeek = week.createNextWeek();

        // then
        assertThat(nextWeek, is (weekForDayOfMonth(8)));
    }

    @Test
    public void stringRepresentation() throws Exception {
        // given
        Week week = new Week(calendar);

        // when
        String date = week.toString();

        // then
        assertThat(date, is("Jun 01, 2015"));
    }

    private Week weekForDayOfMonth(int dayOfMonth) {
        Calendar weekCalendar = (Calendar) calendar.clone();
        weekCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        return new Week(weekCalendar);
    }

    @Test
    public void compareEqualWeeks() throws Exception {
        // given
        Week firstWeek = weekForDayOfMonth(1);

        // expect
        assertThat(firstWeek.equals(weekForDayOfMonth(1)), is(true));
    }

    @Test
    public void compareDifferentWeeks() throws Exception {
        // given
        Week firstWeek = weekForDayOfMonth(1);

        // expect
        assertThat(firstWeek.equals(weekForDayOfMonth(15)), is(false));
    }

    @Test
    public void fillsItselfWithDays() throws Exception {
//        List<WeekDay> weekDays = new ArrayList<>();
//        weekDays.add( new WeekDay(calendar2));    calendar2.set(2012, Calendar.JANUARY, 2);
//        weekDays.add( new WeekDay(calendar2));    calendar2.set(2012, Calendar.JANUARY, 3);
//        weekDays.add( new WeekDay(calendar2));    calendar2.set(2012, Calendar.JANUARY, 4);
//        weekDays.add( new WeekDay(calendar2));    calendar2.set(2012, Calendar.JANUARY, 5);
//        weekDays.add( new WeekDay(calendar2));    calendar2.set(2012, Calendar.JANUARY, 6);
//        weekDays.add( new WeekDay(calendar2));    calendar2.set(2012, Calendar.JANUARY, 7);
//        weekDays.add( new WeekDay(calendar2));
    }

    @Test
    @Ignore
    public void isCurrentMonth() throws Exception {
        Week week = new Week(calendar);

        assertThat(week.isCurrentMonth(), is (true) );
    }

    @Test
    @Ignore
    public void isMonthEndsInSaturday() throws Exception {
        calendar.set(Calendar.MONTH, Calendar.MARCH);
        calendar.set(Calendar.DAY_OF_MONTH,25);
        Week week = new Week(calendar);

        assertThat(week.isLastDayOfMonth(),is(true));
    }
}
