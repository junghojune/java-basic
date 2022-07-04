package miniWork;

import java.util.Scanner;

class Judge{
    int judgeAge(int age) {

        if(age < 3){
            return 1;
        }
        else if(age>=3 && age < 13){
            return 2;
        } else return 3;
    }

    Boolean judgeNational(String national){
        national.toLowerCase();
        if(national.equals("y")){
            return true;
        }else {
            return false;
        }
    }

    Boolean judgeWelfare(String welfareCard){
        welfareCard.toLowerCase();
        if(welfareCard.equals("y")){
            return true;
        }else
            return false;
    }

    Boolean judgeTime(int time){
        if(time >= 17 && time <= 24){
            return true;
        }else
            return false;
    }
  boolean judgeString(String alphaet){
        
        alphaet.toLowerCase();
        
        if (alphaet.equals("y") || alphaet.equals("n")){
            return true;
        } else 
            return false;
    }

    int judgeDiscount(int age, int time, String national, String welfare, int ticket) {
        if (judgeAge(age) == 1) {
            ticket = 0;
        } else if (judgeAge(age) == 2) {
            ticket = 4000;
        } else {
            if (judgeTime(time)) {
                ticket = 4000;
            } else if (judgeNational(national) || judgeWelfare(welfare)) {
                ticket = 8000;
            }
        }

        return ticket;
    }

}


public class Homework3 {
    public static void main(String[] args) {

        int ticket = 10000;
        int age;
        int time;
        String national;
        String welfare;

        System.out.print("[입장권 계산]" );

        System.out.println();

        System.out.print("나이를 입력해 주세요.(숫자):" );
        Scanner sc = new Scanner(System.in);
        age  = sc.nextInt();


        System.out.print("입장시간을 입력해 주세요:" );
        Scanner sc2 = new Scanner(System.in);
        time = sc2.nextInt();


        while (true) {
            System.out.print("국가유공자 여부를 입력해 주세요.(y/n):");
            Scanner sc3 = new Scanner(System.in);
            national = sc3.next();
            Judge judgeString = new Judge();

            if (judgeString.judgeString(national)){

                break;
            }
        }

        while (true) {
            System.out.print("복지카드 여부를 입력해 주세요.(y/n):");
            Scanner sc4 = new Scanner(System.in);
            welfare = sc4.next();
            Judge judgeString2 = new Judge();

            if (judgeString2.judgeString(welfare)){
                break;
            }
        }

        Judge judge = new Judge();
        ticket = judge.judgeDiscount(age, time, national, welfare, ticket);

        System.out.println("입장료: " + ticket);

    }
}
