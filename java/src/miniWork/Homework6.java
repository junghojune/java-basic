package miniWork;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Homework6 {

    static Homework6 hw = new Homework6();

    public static void main(String[] args) {
        hw.setCandidate();
    }
    public void setCandidate(){
        Map<String, Integer> candidate = new HashMap<>();

        candidate.put("이재명", 0);
        candidate.put("윤석열", 0);
        candidate.put("심상정", 0);
        candidate.put("안철수", 0);

        vote(candidate);
    }

    public void vote(Map<String, Integer> candidate){

        int vote = 0;
        String timeWinner = "";
        Random random = new Random();

        while (vote != 100000) {
            int chance = random.nextInt(4);
            switch (chance){
                case 0:
                    candidate.put("이재명" , candidate.get("이재명") + 1);
                    timeWinner = "이재명";
                    break;
                case 1:
                    candidate.put("윤석열" , candidate.get("윤석열") + 1);
                    timeWinner = "윤석열";
                    break;
                case 2:
                    candidate.put("심상정" , candidate.get("심상정") + 1);
                    timeWinner = "심상정";
                    break;
                case 3:
                    candidate.put("안철수" , candidate.get("안철수") + 1);
                    timeWinner = "안철수";
                    break;
            }
            vote++;
            calProbability(candidate, vote, timeWinner);
        }
    }
    public void calProbability(Map<String, Integer> candidate, int vote, String timeWinner){
        double progress = (vote * 100) / 100000.0;

        Double[] prob = {0.0,0.0,0.0,0.0};

        prob[0] = (candidate.get("이재명") * 100) / 100000.0;
        prob[1] = (candidate.get("윤석열") * 100) / 100000.0;
        prob[2] = (candidate.get("심상정") * 100) / 100000.0;
        prob[3] = (candidate.get("안철수") * 100) / 100000.0;

        printResult(candidate, progress, prob, timeWinner, vote);
    }

    //TODO : 동률 당선 조작
    public void setNotSameProbability(Map<String, Integer> candidate){
        Integer maxVote = Collections.max(candidate.values());
        String[] list = {"이재명", "윤석열", "심상정", "안철수"};
        String[] winner = new String[4];
        String president = "";

        for(int i =0; i<list.length; i++){
            if(candidate.get(i).equals(maxVote)){
                winner[i] = list[i];
            }
        }


        if(winner.length == 1){
            president = winner[0];
        }else



        System.out.printf("[투표결과] 당선인: %s\n", winner);
    }

    public void printResult(Map<String, Integer> candidate , double progress, Double[] prob , String timeWinner, int vote){
        System.out.printf("[투표진행율]: %4.2f%%, %d명 투표 => %s\n", progress, vote, timeWinner);

        System.out.printf("[기호:1] 이재명: %4.2f, (투표수: %d)\n", prob[0], candidate.get("이재명"));

        System.out.printf("[기호:2] 윤석열: %4.2f, (투표수: %d)\n", prob[1], candidate.get("윤석열"));

        System.out.printf("[기호:3] 심상정: %4.2f, (투표수: %d)\n", prob[2], candidate.get("심상정"));

        System.out.printf("[기호:4] 안철수: %4.2f, (투표수: %d)\n",prob[3], candidate.get("안철수"));

        setNotSameProbability(candidate);
    }
}
