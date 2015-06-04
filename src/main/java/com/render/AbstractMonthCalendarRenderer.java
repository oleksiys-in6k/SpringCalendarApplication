package com.render;


import com.fillMonthCalendar.MonthCalendar;
import com.fillMonthCalendar.Week;
import com.fillMonthCalendar.WeekDay;
import com.fillMonthCalendar.WeekDayType;

public abstract class AbstractMonthCalendarRenderer implements CalendarRender {


    public String render(MonthCalendar monthCalendar) {

        String result = "";
        result += getOpenMonthToken();
        result += getOpenWeekToken();
        result += renderHeader();
        result += getCloseWeekToken();
        result += renderWeeks(monthCalendar);

        result += getCloseMonthToken();
        return result;
    }

    private String renderWeeks(MonthCalendar monthCalendar) {
        String result = "";

        for (Week week : monthCalendar.getWeeks()) {
            result += getOpenWeekToken();
            result += renderDay(week);
            result += getCloseWeekToken();
        }
        return result;
    }

    private String renderHeader () {
        String result="";
        for (WeekDayType weekDayType : WeekDayType.values()) {
            result += getOpenTitleToken();
            result += weekDayType.getTitle();

            result += getCloseTitleToken();
        }
        return result;
    }

    private String renderDay(Week week) {
        String result = "";
        for (WeekDay weekDay : week.getDays()) {
            result += getOpenDayToken(weekDay.getType());
            result += weekDay.getDayInMonth(); //
            result += getCloseDayToken();
        }
        return result;
    }

    public abstract String getOpenDayToken(WeekDayType weekDay);
    public abstract String getCloseDayToken();

    public abstract String getOpenWeekToken();
    public abstract String getCloseWeekToken();

    public abstract String getOpenMonthToken();
    public abstract String getCloseMonthToken();

    public abstract String getOpenTitleToken();
    public abstract String getCloseTitleToken();


}
