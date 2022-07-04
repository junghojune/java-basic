package miniWork;

import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {

        System.out.println("[캐시백 계산]");

        System.out.print("결제 금액을 입력해 주세요. (금액):" );
        Scanner sc = new Scanner(System.in);

        int amount = sc.nextInt();

        int cashback;
        if(amount  >= 3000){
            cashback = 300;
        }else if(amount > 2000){
            cashback = 200;
        }else if(amount > 1000){
            cashback = 100;
        }else
            cashback = 0;

        System.out.println("결제 금액은 " + amount + "원이고, 캐시백은 " + cashback + "원 입니다.");
    }

}
