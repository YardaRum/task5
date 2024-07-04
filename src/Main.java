import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.Calendar;

public class Main {
        public static void main(String[] args) {
            Date date = new Date();
            System.out.println("Введите дату в формате dd.MM.yyyy:");
            Scanner scan = new Scanner(System.in);
            String STR = scan.next();
            SimpleDateFormat SDF= new SimpleDateFormat("dd.MM.yyyy");
            try {
                date = SDF.parse(STR);
            } catch(ParseException e) {
                System.out.println("Нераспаршена с помощью " + SDF);
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH,+45);
            System.out.println("Дата после увеличения на 45 дней: " + SDF.format(calendar.getTime()));

            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.set(Calendar.MONTH, 0);
            System.out.println("Дата после сдвига на начало года: " + SDF.format(calendar.getTime()));

            calendar.setTime(date);
            int days = 10;
            for(int i=0;i<days;){
                if(calendar.get(Calendar.DAY_OF_WEEK)<=5)
                {i++;}
                calendar.add(Calendar.DAY_OF_MONTH,+1);
            }
            System.out.println("Дата после увеличения на 10 рабочих дней: " + SDF.format(calendar.getTime()));
            System.out.println("Введите вторую дату в формате dd.MM.yyyy:");
            STR = scan.next();
            Date date1 = new Date();
            try {
                date1 = SDF.parse(STR);
            } catch(ParseException e) {
                System.out.println("Нераспаршена с помощью " + SDF);
            }

            Calendar calendar1 = Calendar.getInstance();
            if (date1.getTime() >date.getTime()){
                calendar.setTime(date);
                calendar1.setTime(date1);
            }
            else {
                calendar.setTime(date1);
                calendar1.setTime(date);
            }
            int i;
            for(i=0;calendar.get(Calendar.DAY_OF_MONTH) != calendar1.get(Calendar.DAY_OF_MONTH) && calendar.get(Calendar.MONTH) == calendar1.get(Calendar.MONTH) ;){
                if(calendar.get(Calendar.DAY_OF_WEEK)<=5)
                { i++; }
                calendar.add(Calendar.DAY_OF_MONTH,+1);
            }
            System.out.println("Количество рабочих дней между введенными датами: " + i);
        }
}
