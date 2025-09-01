package Task5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Task5_1 {
    private static int countWorkDaysBetween(Date startDate, Date endDate) {
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);

        if (startCal.after(endCal)) {
            Calendar temp = startCal;
            startCal = endCal;
            endCal = temp;
        }

        int workDays = 0;
        Calendar current = (Calendar) startCal.clone();

        while (current.before(endCal) || current.equals(endCal)) {
            int dayOfWeek = current.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                workDays++;
            }
            current.add(Calendar.DAY_OF_MONTH, 1);
        }

        return workDays;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        try {
            System.out.println("Введите дату в формате дд.мм.гггг:");
            String dateStr1 = scanner.nextLine();
            Date date1 = dateFormat.parse(dateStr1);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date1);
            calendar.add(Calendar.DAY_OF_MONTH, 45);
            Date date45 = calendar.getTime();
            System.out.println("Дата после увеличения на 45 дней: " + dateFormat.format(date45));

            calendar.setTime(date1);
            calendar.set(Calendar.MONTH, Calendar.JANUARY);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            Date startYear = calendar.getTime();
            System.out.println("Дата после сдвига на начало года: " + dateFormat.format(startYear));

            calendar.setTime(date1);
            int workDaysToAdd = 10;
            while (workDaysToAdd > 0) {
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                    workDaysToAdd--;
                }
            }
            Date date10 = calendar.getTime();
            System.out.println("Дата после увеличения на 10 рабочих дней: " + dateFormat.format(date10));

            System.out.println("Введите вторую дату в формате дд.мм.гггг:");
            String dateStr2 = scanner.nextLine();
            Date date2 = dateFormat.parse(dateStr2);

            int workDaysCount = countWorkDaysBetween(date1, date2);
            System.out.println("Количество рабочих дней между введенными датами: " + workDaysCount);

        } catch (ParseException e) {
            System.out.println("Ошибка: Неверный формат даты. Используйте формат dd.MM.yyyy");
        } finally {
            scanner.close();
        }
    }
}