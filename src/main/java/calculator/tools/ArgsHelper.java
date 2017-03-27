package calculator.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ArgsHelper {

    private static String initExpress(String exp){
        String reStr;
        reStr = exp.replaceAll("\\s", "");
        if(reStr.startsWith("-")){
            reStr = "0"+reStr;
        }
        reStr = reStr.replaceAll("\\(-", "(0-");
        return reStr;
    }

    public static List<String> parseArgsToList(String baseExp) {
        List<String> expList = new ArrayList<>();
        String expInited = initExpress(baseExp);

        StringTokenizer st = new StringTokenizer(expInited,"+-*/^%()",true);
        while(st.hasMoreElements()){
            expList.add(st.nextElement().toString().trim());
        }

        return expList;
    }
}
