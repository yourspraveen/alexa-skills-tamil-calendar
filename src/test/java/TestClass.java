import com.yourspraveen.DateCompute;
import com.yourspraveen.TamilCalendarSpeechlet;

import java.util.GregorianCalendar;

public class TestClass {

    public static void main(String[] args) {
        String value = DateCompute.getTamilDate(new GregorianCalendar(2014,11,14));

        System.out.println(value);
    }
}
