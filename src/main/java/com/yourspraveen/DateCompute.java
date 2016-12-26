package com.yourspraveen;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.joda.time.Days;
import org.joda.time.LocalDate;

import java.util.Calendar;

public class DateCompute {
    /**
     * Array of month names.
     */
    private static final String[] MONTH_NAMES = {
            "Chithirai",
            "Vaikaasi",
            "Aani",
            "Aadi",
            "Aavani",
            "Purattaasi",
            "Aippasi",
            "Karthikai",
            "Maargazhi",
            "Thai",
            "Maasi",
            "Panguni"
    };

    /**
     * Array of year names.
     */
    private static final String[] YEAR_NAMES = {
            "Prabhava",
            "Vibhava",
            "Sukla",
            "Pramodoota",
            "Prachorpaththi",
            "Aangirasa",
            "Srimukha",
            "Bhava",
            "Yuva",
            "Dhaatu",
            "Eesvara",
            "Vehudhanya",
            "Pramathi",
            "Vikrama",
            "Vishu",
            "Chitrabaanu",
            "Subhaanu",
            "Dhaarana",
            "Paarthiba",
            "Viya",
            "Sarvajith",
            "Sarvadhari",
            "Virodhi",
            "Vikruthi",
            "Kara",
            "Nandhana",
            "Vijaya",
            "Jaya",
            "Manmatha",
            "Dhunmuki",
            "Hevilambi",
            "Vilambi",
            "Vikari",
            "Sarvari",
            "Plava",
            "Subakrith",
            "Sobakrith",
            "Krodhi",
            "Visuvaasuva",
            "Parabhaava",
            "Plavanga",
            "Keelaka",
            "Saumya",
            "Sadharana",
            "Virodhikrithu",
            "Paridhaabi",
            "Pramaadhisa",
            "Aanandha",
            "Rakshasa",
            "Nala",
            "Pingala",
            "Kalayukthi",
            "Siddharthi",
            "Raudhri",
            "Dunmathi",
            "Dhundubhi",
            "Rudhrodhgaari",
            "Raktakshi",
            "Krodhana",
            "Akshaya"
    };

    public static String getTamilDate(Calendar cal) {
        LocalDate localDate = new LocalDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
        Pair<Integer, Integer> tamilMonthDay = findMonthDay(localDate);
        int yearInd = localDate.monthOfYear().get()<4?localDate.getYear()-1:localDate.getYear();

        String month = MONTH_NAMES[tamilMonthDay.getLeft()];

        String date = tamilMonthDay.getRight().toString();

        String year = YEAR_NAMES[yearInd - 1987];

        return year + " varudam " + month + " madham " + date + " naal";
    }

    private static Pair<Integer, Integer> findMonthDay(LocalDate inDate) {
        LocalDate[] allDates = createDates(inDate.getYear());
        Pair<Integer, Integer> pair = null;
        for (int i = 0; i < allDates.length && pair == null; i++) {
            LocalDate startMonth = allDates[i];
            LocalDate tillMonth = i < 11 ? allDates[i + 1] : allDates[0];

            if (startMonth.equals(inDate)) {
                pair = new MutablePair<>(i, 1);
            } else if (inDate.isAfter(startMonth) && inDate.isBefore(tillMonth)) {
                pair = new MutablePair<>(i, Days.daysBetween(startMonth,inDate).getDays());
            }
        }
        return pair;
    }


    private static LocalDate[] createDates(int year) {
        return new LocalDate[]{
                new LocalDate(year, 4, 14),
                new LocalDate(year, 5, 14),
                new LocalDate(year, 6, 15),
                new LocalDate(year, 7, 16),
                new LocalDate(year, 8, 17),
                new LocalDate(year, 9, 17),
                new LocalDate(year, 10, 17),
                new LocalDate(year, 11, 16),
                new LocalDate(year, 12, 16),
                new LocalDate(year, 1, 14),
                new LocalDate(year, 2, 13),
                new LocalDate(year, 3, 14)
        };
    }
}
