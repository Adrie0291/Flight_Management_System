package frontend;

public class OptionHandler {
    protected void optionHandler(String userOption, Account account){
        for (UserOption option:CreateUserOptions.optionList(account)) {
            if(option.getName().equals(userOption)){
                option.execute(account);
            }
        }
        System.out.println("Incorrect command!");
    }
}
