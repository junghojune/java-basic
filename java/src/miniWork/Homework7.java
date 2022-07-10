package miniWork;

import java.util.*;

public class Homework7 {

    static Homework7 hw7 = new Homework7();

    public static void main(String[] args) {
        hw7.stater();
    }

    public void stater(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("[로또 당청 프로그램]");
        System.out.print("로또 개수를 입력해 주세.(숫자 1~10):");
        int number = scanner.nextInt();
        Map<Character, List<Integer>> mylotto = new HashMap<>();

        for(int i=0; i< number; i++){
            char aski = (char) (i + 65);
            System.out.print("" + aski + "   ");
            List<Integer> lotto = selectNumber();
            mylotto.put(aski,lotto);

            for(int j = 0; j<lotto.size(); j++) {
                if(j==5){
                    System.out.printf("%02d\n", lotto.get(j));
                }else
                    System.out.printf("%02d,", lotto.get(j));
            }
        }

        List<Integer> winningNumber = winningNumber();

        compareMyToWinnig(winningNumber, mylotto, number);
    }

    public List<Integer> winningNumber(){
        Random rdm = new Random();
        Set<Integer> set = new HashSet<Integer>();

        while(set.size() != 6){
            set.add((int) (Math.random() * 45 +1));
        }

        List<Integer> list = new ArrayList<Integer>(set);
        Collections.sort(list);
        System.out.println("\n[로또 발표]");

        System.out.print("    ");
        for (int k = 0; k < 6; k++) {
            if (k < 5) {
                System.out.printf("%02d,", list.get(k));
            } else {
                System.out.printf("%02d\n\n", list.get(k));
            }
        }

        return list;

    }
    public List<Integer> selectNumber(){
        Random random = new Random();
        Set<Integer> set = new HashSet<Integer>();

        while(set.size() != 6){
            set.add((int) (Math.random() * 45 +1));
        }

        List<Integer> list = new ArrayList<Integer>(set);
        Collections.sort(list);

        return list;

    }

    public void compareMyToWinnig(List<Integer> winning, Map<Character, List<Integer>> select, int number){

        System.out.println("[내 로또 결과]");


        for(int i=0; i< number; i++){
            int count = 0;
            char aski = (char) (i + 65);

            System.out.print("" + aski + "   ");

            List<Integer> myLottoResult = select.get(aski);


            for(int k : winning){
                if(myLottoResult.contains(k)){
                    count++;
                }
            }

            for(int j = 0; j<myLottoResult.size(); j++) {
                if(j==5){
                    System.out.printf("%02d ", myLottoResult.get(j));
                }else
                    System.out.printf("%02d,", myLottoResult.get(j));
            }
            System.out.printf(" => %d개 일치\n", count);
        }
    }
}
