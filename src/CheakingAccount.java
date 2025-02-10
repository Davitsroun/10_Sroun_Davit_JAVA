public class CheakingAccount implements Account{
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";



    private double balance;
    private String AccountNumber=String.valueOf((int) (Math.random() * 100));
     private String UserName;
     private String DateofBirth;
     private Gender gender;
    private String PhineNumber;
    AccountUtil util= new AccountUtil();

    public CheakingAccount(  String userName, String dateofBirth, Gender gender, String phineNumber,double balance) {
        this.balance = balance;

        UserName = userName;
        DateofBirth = dateofBirth;
        this.gender = gender;
        PhineNumber = phineNumber;
    }

    public CheakingAccount() {

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return AccountNumber;
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


    public double getBalnace() {
        return balance;
    }



    public void setBalnace(double balnace) {
        this.balance = balnace;
    }


    public CheakingAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public double deposit(double amount) {
        System.out.println();
        System.out.println(ANSI_GREEN+"Recieve:\t\t\t\t$"+amount);
        balance +=amount;
        System.out.println("Total amount:\t\t\t$"+balance+ANSI_RESET);
        System.out.println(ANSI_WHITE+"========================================"+ANSI_RESET);
        return balance;
    }

    @Override
    public double withdraw( double amount) {

        while (true){

            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println(ANSI_GREEN+"Width draw:\t\t\t$"+amount);
                System.out.println("Total balance:\t\t\t$"+balance+ANSI_RESET);
                System.out.println(ANSI_CYAN+"==========================="+ANSI_RESET);
                System.out.println();

                break;
            } else {
                System.out.println(ANSI_RED+"Insufficient balance or invalid amount."+ANSI_RESET);
                break;
            }

        }

        return balance;
    }

    //Account account=new SavingAccount();

    @Override
    public double tranfer(double amount ,Account target) {
        System.out.println();
        System.out.println(ANSI_GREEN+"Tranferred: \t\t\t"+amount);
        System.out.println("from\t\t:Checking Account ID:"+getUserName());
        System.out.println("To\t\t:Savint Account ID\t:");
        if (amount <= balance){
            balance-=amount;

            System.out.println("Total Remain:\t\t\t"+balance+ANSI_RESET);
            target.deposit(amount);
            System.out.println(ANSI_YELLOW+"================================================"+ANSI_RESET);
            System.out.println("Tranfer $"+amount+" TO Account");
            System.out.println(ANSI_GREEN+" SUCCESS FULLY TRANFER!"+ANSI_RESET);

        }else{
            System.out.println(ANSI_RED+"Youn don't have enough money...."+ANSI_RESET);
            return 0.0;
        }
        return   0.0;
    }

    @Override
    public void displayAcc() {
        System.out.println(ANSI_BLUE+">>>>>>>>>>>>>>>>> Cheacking Account <<<<<<<<<<<<<<<<<<"+ANSI_RESET);
        System.out.println(ANSI_GREEN+"Acccount Type: Checking Account");
        System.out.println("Account Number: "+AccountNumber);
        System.out.println("User Name: "+ UserName);
        System.out.println("Date OF Birth:"+DateofBirth);
        System.out.println("Gender: "+gender);
        System.out.println("Phone Number: "+PhineNumber);
        System.out.println("Balance: "+balance+ANSI_RESET);
        System.out.println(ANSI_WHITE+"===================================================="+ANSI_RESET);
        System.out.println();


    }

    @Override
    public String toString() {
        return "CheakingAccount{" +
                ", AccountNumber='" + AccountNumber + '\'' +
                ", UserName='" + UserName + '\'' +
                ", DateofBirth='" + DateofBirth + '\'' +
                ", gender=" + gender +
                ", PhineNumber='" + PhineNumber + '\'' +
                "balnace=" + balance +
                '}';
    }
}
