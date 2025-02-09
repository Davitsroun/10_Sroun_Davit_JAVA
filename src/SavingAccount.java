public class SavingAccount extends field implements Account{

    public  final String ANSI_GREEN = "\u001B[32m";
    public  final String ANSI_RED = "\u001B[31m";
    public  final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    private double rate;

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

    public SavingAccount(String accountNumber, String userName, String dateofBirth, Gender gender, String phineNumber,double rate) {
        super(accountNumber, userName, dateofBirth, gender, phineNumber);
        this.rate=rate;
    }

    @Override
    public double deposit(double amount) {
        return 0;
    }

    @Override
    public double withdraw(double amount, double yourmoney) {

        if (yourmoney > 0 && yourmoney <= amount) {
            amount -= yourmoney;
        } else {
            System.out.println(ANSI_RED+"Insufficient balance or invalid amount."+ANSI_RESET);
        }
        System.out.println(ANSI_GREEN+"Width draw:\t\t\t$"+yourmoney);
        System.out.println("Total balance:\t\t\t$"+amount+ANSI_RESET);
        System.out.println(ANSI_CYAN+"==========================="+ANSI_RESET);
        System.out.println();
        return amount;
    }

    @Override
    public void tranfer(double amount, Object object) {

    }

    @Override
    public void displayAcc() {

    }

}
