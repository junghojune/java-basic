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

        winningNumber();

        compareMyToWinnig(winningNumber(), mylotto);
    }

    public List<Integer> winningNumber(){
        Random rdm = new Random();
        Set<Integer> set = new HashSet<Integer>();

        while(set.size() != 6){
            set.add((int) (Math.random() * 45 +1));
        }

        List<Integer> list = new ArrayList<Integer>(set);
        Collections.sort(list);

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

    public void compareMyToWinnig(List<Integer> winning, Map<Character, List<Integer>> select){


    }
}
