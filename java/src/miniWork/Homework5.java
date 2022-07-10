package miniWork;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Homework5 {

    static Homework5 homework5 = new Homework5();

    public static void main(String[] args) {
        homework5.starter();
    }

    public void starter(){
        int year = getYear();
        int month = getMonth();

        buildCalender(year, month);
    }

    public int getYear(){

        System.out.println("[달력 출력 프로그램]");

        Scanner scanner = new Scanner(System.in);
        System.out.print("달력의 년도를 입력하세요. (yyyy):");
        int year = scanner.nextInt();

        if(year <= 0){
            System.out.print("달력의 년도를 입력하세요. (yyyy):");
            year = scanner.nextInt();
        }

        return year;
    }

    public int getMonth(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("달력의 월을 입력하세요. (mm):");
        int month = scanner.nextInt();

        if(month > 12 && month < 1){
            System.out.print("달력의 월을 입력하세요. (mm):");
            month = scanner.nextInt();
        }

        return month;
    }

    public Boolean isLeapYear(int year){
        if(year % 4 == 0 && year % 100 != 0 || year % 400 ==0){
            return true;
        }else
            return false;
    }

    public int cal1stDayWeek(int year, int month){
        Calendar calendar =  Calendar.getInstance();
        Date monthDay = new Date();
        String YMD = year + "-" + month + "-01";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String today = formatter.format(monthDay);
        try {
            calendar.setTime(formatter.parse(YMD));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int dayNum = calendar.get(Calendar.DAY_OF_WEEK);
//      1(일) ~ 7(토)

        return dayNum;
    }

    public void buildCalender(int year, int month){
        int dayMax;
        int[] day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if(isLeapYear(year) && month == 2){
            dayMax = day[month -1] + 1;
        } else if (!isLeapYear(year) && month == 2) {
            dayMax = day[month -1];
        }else
            dayMax = day[month -1 ];

        int dayWeekFirst = cal1stDayWeek(year,month);
        printCaleder(year, month, dayMax, dayWeekFirst);
    }

    private void printCaleder(int year, int month, int dayMax, int dayWeekFirst) {
        System.out.println("\n[" + year + "년 " + String.format("%02d", month) + "월]");
        System.out.println("일\t월\t화\t수\t목\t금\t토");
        for (int j = 1; j < dayWeekFirst; j++) {
            System.out.print("\t"); //
        }
        for (int i = 1; i <= dayMax; i++) {
            if (i < 10) {// 한 자리 수이면 앞에 공백 한 번 더 추가
                System.out.print(String.format("%02d", i)+"\t");
            }
            if (i >= 10) {
                System.out.print(i + "\t");
            }
            // 줄바꿈
            if ((dayWeekFirst - 1 + i ) % 7 == 0) { // 공백 = (dayWeek1 - 1) + i 가 일주일 한 줄.
                System.out.println();//줄바꿈
            }
        }

    }

}
