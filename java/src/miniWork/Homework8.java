package miniWork;

import java.util.Scanner;

public class Homework8 {

    static Homework8 hw8 = new Homework8();

    public static void main(String[] args) {
        hw8.start();
    }

    public void start(){
        Scanner sc = new Scanner(System.in);

        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.:");
        int income = sc.nextInt();

        setTax(income);
    }


    public void setTax(int income){
        int tax =0;

        int[] setAmount = new int[8];
        setAmount[0] = 0;
        setAmount[1] = 12000000;
        setAmount[2] = 46000000;
        setAmount[3] = 88000000;
        setAmount[4] = 150000000;
        setAmount[5] = 300000000;
        setAmount[6] = 500000000;
        setAmount[7] = 1000000000;

        double[] setRate = new double[8];
        setRate[0] = 0.06;
        setRate[1] = 0.15;
        setRate[2] = 0.24;
        setRate[3] = 0.35;
        setRate[4] = 0.38;
        setRate[5] = 0.40;
        setRate[6] = 0.42;
        setRate[7] = 0.45;

        int taxation = 0;
        int division = 0;

        for(int i = 0; i< setAmount.length; i++){
            if(income - setAmount[i] < 0){
                taxation = i-1;
                break;
            }else
                taxation = 7;
        }

        for(int i = 0; i< taxation + 1; i++){
            if(i == 0){
                division += Math.min(income,setAmount[1]);
            } else if(taxation != 1 && i<taxation){
                division = setAmount[i+1] - setAmount[i];
            } else if(i == taxation){
                division = Math.min(income - division, income - setAmount[i]);
            }
            int result = (int) (division * setRate[i]);
            tax += result;
            System.out.printf("%10d * %2d%% = %10d\n", division,(int) (setRate[i] * 100), result);
        }

        System.out.println();
        String result1 = "[세율에 의한 세금]:";
        String result2 = "[누진공제 계산에 의한 세금]:";
        System.out.printf("%-10s\t%18d\n", result1, tax);
        System.out.printf("%-10s\t%10d\n", result2, tax);
    }

}
