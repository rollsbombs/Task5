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
                int workDaysToAdd = 10;
                while (workDaysToAdd > 0) {
                    calendar.add(GregorianCalendar.DAY_OF_MONTH, 1);
                    int dayOfWeek = calendar.get(GregorianCalendar.DAY_OF_WEEK);
                    if (dayOfWeek != GregorianCalendar.SATURDAY && dayOfWeek != GregorianCalendar.SUNDAY) {
                        workDaysToAdd--;
                    }
                }
                Date date10 = calendar.getTime();
                System.out.println("Дата после увеличения на 10 рабочих дней: " + sdf.format(date10));
                System.out.println("Введите вторую дату в формате дд.мм.гггг");
                String dateStr2 = scanner.nextLine();
                Date date2 = sdf.parse(dateStr2);
                calendar.setTime(date1);
                int workDays = 0;
                while (!calendar.getTime().after(date2)) {
                    int dayOfWeek = calendar.get(GregorianCalendar.DAY_OF_WEEK);
                    if (dayOfWeek != GregorianCalendar.SATURDAY && dayOfWeek != GregorianCalendar.SUNDAY) {
                        workDays++;
                    }
                    calendar.add(GregorianCalendar.DAY_OF_MONTH, 1);
                }
                System.out.println("Количество рабочих дней между введёнными датами: " + sdf.format(workDays));
            } catch (ParseException e) {
                System.out.println("Ошибка: Неверный формат даты. Используйте формат 'дд.мм.гггг'");
            }
        }
    }
}