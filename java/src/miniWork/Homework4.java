package miniWork;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

class JudgeString{

    String judgeString (String any){
        if(any.length() == 4 || any.length() == 2){
            return any;
        } else if (any.equals("m") || any.equals("f")) {
            return any;
        } else {
            return "false";
        }
    }

    StringBuffer makeIdNumber(String year, String month, String day, String sex){
        Random random = new Random();

        StringBuffer idnumber = new StringBuffer();

        idnumber.append(year.substring(2)).append(month).append(day).append(" - ");

        if(sex.equals("m")){
            idnumber.append(3);
        }else idnumber.append(4);

        for(int i = 0; i < 6; i++){
            idnumber.append(random.nextInt(10));
        }

        return idnumber;
    }


}


public class Homework4 {

    public static void main(String[] args) {
        String year;
        String month;
        String day;
        String sex;
        JudgeString judge = new JudgeString();

        System.out.println("[주민등록번호 계산]");

        while(true) {
            System.out.print("출생년도를 입력해 주세요. (yyyy) :");
            Scanner sc = new Scanner(System.in);
            year = sc.nextLine();

            if(judge.judgeString(year).equals(year)){
                break;
            }

        }


        while(true) {
            System.out.print("출생월을 입력해 주세요. (mm) :");
            Scanner sc1 = new Scanner(System.in);
            month = sc1.nextLine();

            if(judge.judgeString(month).equals(month)){
                break;
            }
        }

        while(true) {
            System.out.print("출생일을 입력해 주세요. (dd) :");
            Scanner sc2 = new Scanner(System.in);
            day = sc2.nextLine();

            if(judge.judgeString(day).equals(day)){
                break;
            }
        }

        while(true) {
            System.out.print("성별을 입력해 주세요. (m/f) :");
            Scanner sc3 = new Scanner(System.in);
            sex = sc3.nextLine();

            if(judge.judgeString(sex.toLowerCase()).equals(sex.toLowerCase())){
                break;
            }
        }

        System.out.println(judge.makeIdNumber(year,month,day,sex));
    }
}
