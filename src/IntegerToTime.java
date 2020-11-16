
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author summe
 */
public class IntegerToTime {

    public static void main(String[] args) {
        String makeReadable = makeReadable(86400);
        System.out.println(makeReadable);

    }
    //"00:00:05"

    public static String makeReadable(int seconds) {
        System.out.println(seconds);
        int hourse = 0;
        while (seconds > 86399) {
            seconds -= 86400;
            hourse += 24;
        }
        LocalTime ofSecondOfDay = LocalTime.ofSecondOfDay(seconds);
        int hour = ofSecondOfDay.getHour() + hourse;
        if (hour < 10) {
            return "0" + hour + "" + ofSecondOfDay.format(DateTimeFormatter.ofPattern(":mm:ss"));
        }
        return hour + "" + (ofSecondOfDay.format(DateTimeFormatter.ofPattern(":mm:ss")));
    }
}
