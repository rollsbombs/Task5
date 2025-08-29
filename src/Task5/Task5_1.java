package Task5;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.text.ParseException;

public class Task5_1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            try {
                System.out.println("Введите дату в формате дд.мм.гггг");
                String dateStr1 = scanner.nextLine();
                Date date1 = sdf.parse(dateStr1);
                GregorianCalendar calendar = new GregorianCalendar();
                calendar.setTime(date1);
                calendar.add(GregorianCalendar.DAY_OF_MONTH, 45);
                Date date45 = calendar.getTime();
                System.out.println("Дата после увеличения на 45 дней: " + sdf.format(date45));
                calendar.setTime(date1);
                calendar.set(GregorianCalendar.DAY_OF_MONTH, 1);
                calendar.set(GregorianCalendar.MONTH, GregorianCalendar.JANUARY);
                Date begindate = calendar.getTime();
                System.out.println("Дата после сдвига на начало года: " + sdf.format(begindate));
                calendar.setTime(date1);
                int workdays = 10;
                while (workdays > 0) {
                    calendar.add(GregorianCalendar.DAY_OF_MONTH, 1;

                }
                }
            } catch (ParseException e) {

            }
        }
    }
}