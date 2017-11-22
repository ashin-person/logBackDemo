package ljx.ashin.utils;

/**
 * Created by AshinLiang on 2017/11/22.
 */
public class MathTool {

    public static String get4RandomNumber(){
        String randomNum = "";
        int random =(int)((Math.random()*9+1)*1000);
        return randomNum+random;
    }
}
