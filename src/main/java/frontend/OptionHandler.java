package frontend;

import java.util.List;

public class OptionHandler {
    protected void optionHandler(String userOption, List<UserOption> userOptionList){
        for (UserOption option:userOptionList) {
            if(true){
                option.execute();
            }
        }
        System.out.println("Incorrect command!");
    }
}
