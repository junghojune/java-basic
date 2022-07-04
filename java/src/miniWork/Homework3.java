package miniWork;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.time.Year;

class JudgeAge{

    Boolean JudgeAge(int age){
        if(age < 3){
            return true;
        }
        else {
            return false;
        }
    }
}

class JudgeNational{
    Boolean JudgeNational(String national){
        if(national.equals("Y")){
            return true;
        }else {
            return false;
        }
    }
}

class JudgeWelfare{

    Boolean JudgeWelfare(String welfareCard){
        if(welfareCard.equals("Y")){
            return true;
        }else
            return false;
    }
}

class JudgeTime{

    Boolean JudgeTime(int time){
        if(time >= 17 && time <= 24){
            return true;
        }else
            return false;
    }
}


public class Homework3 {
    public static void main(String[] args) {

    }
}
