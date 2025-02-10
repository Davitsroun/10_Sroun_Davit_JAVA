public class SavingAccount implements Account{

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    static String AccountNumber= String.valueOf((int) (Math.random() * 100));
    private String UserName;
    private String DateofBirth;
    private Gender gender;
    private String PhineNumber;
    private double rate;
    AccountUtil util =new AccountUtil();

    public SavingAccount() {

    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public SavingAccount(double rate){
        this.rate=rate;
    }

    public SavingAccount( String userName, String dateofBirth, Gender gender, String phineNumber, double rate) {

        UserName = userName;
        DateofBirth = dateofBirth;
        this.gender = gender;
        PhineNumber = phineNumber;
        this.rate = rate;
    }


    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getDateofBirth() {
        return DateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        DateofBirth = dateofBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhineNumber() {
        return PhineNumber;
    }

    public void setPhineNumber(String phineNumber) {
        PhineNumber = phineNumber;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                ", AccountNumber='" + AccountNumber + '\'' +
                ", UserName='" + UserName + '\'' +
                ", DateofBirth='" + DateofBirth + '\'' +
                ", gender=" + gender +
                ", PhineNumber='" + PhineNumber + '\'' +
                "rate=" + rate +
                '}';
    }

    public void setRate(double rate) {
        this.rate = rate;
    }




    @Override
    public double deposit(double amount) {

        System.out.println();
        System.out.println(ANSI_GREEN+"Recieve:\t\t\t\t$"+amount);
        double a;
        boolean onetime= true;
        while (onetime ) {
            if (amount >= 200.00) {

                a = (amount * 0.05);
                double c = amount + a;
                amount = c;
                onetime = false;
            } else {
                break;
            }
        }
        rate+=amount;
        System.out.println("Total amount:\t\t\t$"+rate+ANSI_RESET);


        return rate;
    }

    @Override
    public double withdraw(double amount) {

         while (true){

             if (amount > 0 && amount <= rate *0.8) {
                 rate -= amount;
                 System.out.println(ANSI_GREEN+"Width draw:\t\t\t$"+amount);
                 System.out.println("Total balance:\t\t\t$"+rate+ANSI_RESET);
                 System.out.println(ANSI_CYAN+"==========================="+ANSI_RESET);
                 System.out.println();
                 break;
             }else if (amount > rate * 0.8) {

                 System.out.println(ANSI_RED + "Cannot withdraw more than 80% of the balance.At least you should have"+rate*0.2 + ANSI_RESET);
                 break;}
             else {
                 System.out.println(ANSI_RED+"Insufficient balance or invalid amount."+ANSI_RESET);
                 break;
             }

         }

        return rate;
    }

    @Override
    public double tranfer(double amount, Account target) {
        System.out.println();
        System.out.println(ANSI_BLUE+"============== Trsnfer to Checikng Account =============="+ANSI_RESET);
        System.out.println(ANSI_GREEN+"Tranferred:\t\t\t\t"+amount);
        System.out.println("from \t:Checking Account ID:"+getUserName());
        System.out.println("To \t\t:Savint Account ID:"+CheakingAccount.AccountNumber);
        if (amount <= rate){
            rate-=amount;
            target.deposit(amount);
            System.out.println(ANSI_YELLOW+"================================================"+ANSI_RESET);
            System.out.println(ANSI_GREEN+"Tranfer $"+amount+" TO Account: "+CheakingAccount.AccountNumber);
            System.out.println(" SUCCESS FULLY TRANFER!"+ANSI_RESET);

        }else{
            System.out.println(ANSI_RED+"Youn don't have enough money...."+ANSI_RESET);
            return 0;        }

        return 0;
    }

    @Override
    public double Delete(Account targeet) {

            while (true){
                String  a=util.InputYN();
                if (a.equals("n")){
                    return 0;
                }

                System.out.println(ANSI_BLUE+"============== Delete  Saving Account =============="+ANSI_RESET);
                System.out.println();
                System.out.println(ANSI_GREEN+"Tranferred: \t\t\t\t"+rate);
                System.out.println("from \t:Checking Account ID:"+getUserName());
                System.out.println("To \t\t:Savint Account ID\t:"+SavingAccount.AccountNumber);

                targeet.deposit(rate);
                setRate(0);
                setDateofBirth(null);
                setAccountNumber(null);
                setGender(Gender.NONE);
                setPhineNumber(null);
                setUserName(null);
                System.out.println("Total Remain:\t\t\t"+rate+ANSI_RESET);

                System.out.println(ANSI_YELLOW+"================================================"+ANSI_RESET);
                System.out.println(ANSI_GREEN+"Tranfer $"+rate+" TO Account: "+SavingAccount.AccountNumber);
                System.out.println(" SUCCESS FULLY TRANFER!"+ANSI_RESET);
                return 0;
            }


    }


    @Override
    public void displayAcc() {
        System.out.println(ANSI_BLUE+">>>>>>>>>>>>>>>>> Saving  Account <<<<<<<<<<<<<<<<<<"+ANSI_RESET);
        System.out.println(ANSI_GREEN+"Acccount Type: Checking Account");
        System.out.println("Account Number: "+AccountNumber);
        System.out.println("User Name: "+ UserName);
        System.out.println("Date OF Birth:"+DateofBirth);
        System.out.println("Gender: "+gender);
        System.out.println("Phone Number: "+PhineNumber);
        System.out.println("Balance: "+rate+ANSI_RESET);
        System.out.println(ANSI_WHITE+"===================================================="+ANSI_RESET);
        System.out.println();

    }



}
