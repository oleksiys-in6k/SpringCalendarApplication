package com.creatingCalendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class InputConfigReader {

    public List<Year> getMonthsFromConfig() throws FileNotFoundException {
        List<Year> result = new LinkedList<Year>();

        Scanner in = new Scanner(new File("config.txt"));
//
//
//        while (in.hasNextLine()) {
//            Calendar calendar = Calendar.getInstance();
//            int year = 0;
//            LinkedList<MonthCalendar> listOfMonth = new LinkedList<>();
//
//            if (in.hasNextInt()) {
//                year = calendar.get(Calendar.YEAR);
//            }
//            if (!in.hasNextInt()) {
//                String s = in.nextLine().trim();
//                listOfMonth.add(Arrays.asList(s));
//                result.addAll(listOfMonth);
//            }
//
//            Collections.sort(result);



//        }
        return result;

    }
}
