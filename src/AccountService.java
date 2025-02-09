import java.util.Arrays;

public class AccountService {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
   static String ID;
   static String UserName;
    static String Date;
    static Gender Genser;
    static String PhoneNumber;
    static String ID2;
    static String UserName2;
    static String Date2;
    static Gender Genser2;
    static String PhoneNumber2;
   static double Balance;
    static   double amount;
    static AccountUtil util =new AccountUtil();
  static CheakingAccount check= new CheakingAccount(ID,UserName,Date,Genser,PhoneNumber, Balance);
  static SavingAccount saving =new SavingAccount(ID2,UserName2,Date2,Genser2,PhoneNumber2, amount);

 static Account []acc= new Account[2];{
     acc[0]= check;
     acc[1]=saving;
    }
static void ShowOption(){
    System.out.println(ANSI_BLUE+"=============== Online Baking System ======================"+ANSI_RESET);
    System.out.println("1. Create Account");
    System.out.println("2. Deposite Money");
    System.out.println("3. withdraw Money");
    System.out.println("4. Tranfer Money");
    System.out.println("5. Display Account Information");
    System.out.println("6. Delete Account");
    System.out.println("7. Exist");
    System.out.println("------------------------------------------------------------");
}


//create acc case1
static void CreateAcc(){

    do {
        System.out.println(ANSI_BLUE+"=============== Account Information ======================"+ANSI_RESET);
        System.out.println("1. Checking Account");
        System.out.println("2. Saving Account");
        System.out.println("3. Back");
        System.out.println("================================================================");
        int OptionCase1= util.InputOption("What type of account do you want to crate?");
            switch (OptionCase1){
                case 1:{
                    if (acc[0] !=null){
                        System.out.println(ANSI_RED+"Acoount already created cann't create again...."+ANSI_RESET);
                        System.out.println();
                        break;
                    }
                    System.out.println(ANSI_GREEN+"============== Checking Account ==================="+ANSI_RESET);
                     ID = String.valueOf(Math.random());
                     UserName= util.Inputname("Enter your name:");
                     Date= util.InputDate("Enter Date of birth (dd/mm/yyyy)");
                     Genser= util.InputGender("Enter your Gender:");
                     PhoneNumber=util.PhonNumber("Enter your PhoneNumber:");
                    acc[0]= new CheakingAccount(ID,UserName,Date,Genser,PhoneNumber, Balance);
                    System.out.println(ANSI_GREEN+"==================================");
                    System.out.println("Your checking account has been created successfuly!"+ANSI_RESET);
                    System.out.println();
                    for (Account b: acc){
                        System.out.println(b);
                    }
                    break;

                }
                case 2:{
                    if (acc[1] !=null){
                        System.out.println(ANSI_RED+"Acoount already created cann't create again...."+ANSI_RESET);
                        System.out.println();
                        break;
                    }
                    System.out.println(ANSI_GREEN+"==============  Saving Account ==================="+ANSI_RESET);
                     ID = String.valueOf(Math.random());
                     UserName= util.Inputname("Enter your name:");
                     Date= util.InputDate("Enter Date of birth (dd/mm/yyyy)");
                     Genser= util.InputGender("Enter your Gender:");
                     PhoneNumber=util.PhonNumber("Enter your PhoneNumber:");
                    acc[1]= new SavingAccount(ID2,UserName2,Date2,Genser2,PhoneNumber2, amount);
                    System.out.println(ANSI_GREEN+"==================================");
                    System.out.println("Your saving account has been created successfuly!"+ANSI_RESET);
                    System.out.println();
                    break;
                }
                case 3:{
                    return;
                }
                default:
                    System.out.println(ANSI_RED+"Invalid number......"+ANSI_RESET);
            }

    }while (true);

}

    public static void Deposit(){

    do {
        System.out.println(ANSI_BLUE+"=============== Deposit Money ======================"+ANSI_RESET);
        System.out.println("1. Checking Account");
        System.out.println("2. Saving Account");
        System.out.println("3. Back");
        System.out.println("================================================================");
        int OptionCase1= util.InputOption(ANSI_PURPLE+"What type of account do you want to crate?"+ANSI_RESET);
        switch (OptionCase1){
            case 1:{
                double a;
                 a=util.Inputbalance("Enter money to deposite:");
                System.out.println(ANSI_GREEN+"Recieve:\t\t\t\t$"+a);
                Balance+=a;
                System.out.println("Total amount:\t\t\t$"+Balance+ANSI_RESET);
                System.out.println(ANSI_WHITE+"========================================"+ANSI_RESET);

                acc[0]= new CheakingAccount(ID,UserName,Date,Genser,PhoneNumber, Balance);
                break;
            }
            case 2:{
                double b;
                b=util.Inputbalance("Enter money to deposite:");
                System.out.println(ANSI_GREEN+"Recieve:\t\t\t\t$"+b);
                amount+=b;
                System.out.println("Total amount:\t\t\t$"+amount+ANSI_RESET);
                acc[1]= new SavingAccount(ID2,UserName2,Date2,Genser2,PhoneNumber2, amount);
                System.out.println(ANSI_WHITE+"========================================"+ANSI_RESET);
                break;
            }
            case 3:{
                return;
            }
            default:System.out.println(ANSI_RED+"Invalid number......"+ANSI_RESET);
        }

    }while (true);


    }


public  static  void Widthdraw(){
     do {
         System.out.println(ANSI_BLUE+"=============== Widthraw Money ======================"+ANSI_RESET);
         System.out.println("1. Checking Account");
         System.out.println("2. Saving Account");
         System.out.println("3. Back");
         System.out.println("================================================================");
         int OptionCase1= util.InputOption("What type of account do you want to crate?");
         switch (OptionCase1){
             case 1:{
                 double e=util.Inputbalance("Enter money to Widthraw:" );
                 Balance= check.withdraw(Balance,e);
                 acc[0]= new CheakingAccount(ID,UserName,Date,Genser,PhoneNumber, Balance);
             }
             case 2:{
                 double e=util.Inputbalance("Enter money to Widthraw:" );
                 amount=  saving.withdraw(amount,e);
                 acc[1]= new SavingAccount(ID2,UserName2,Date2,Genser2,PhoneNumber2, amount);

                 break;
             }
             case 3:{
                 return;
             }
             default:System.out.println(ANSI_RED+"Invalid number......"+ANSI_RESET);
         }


     }while (true);

}



    public static void main(String[] args) {
    while (true){
        ShowOption();
        int option= util.InputOption("input your option");
        switch (option){
            case 1:{
                CreateAcc();
                break;
            }

            case 2:{
                Deposit();
                break;
            }
            case 3:{

                break;
            }
            case 4:{

                break;
            }
            case 5:{
                for (Account b: acc){
                    System.out.println(b);
                }
                break;
            }
            case 6:{

                break;
            }
            case 7:{
                System.out.println(ANSI_RED+"Exite System"+ANSI_RESET);
                return;
            }
            default:
                System.out.println(ANSI_RED+"Wrong input...."+ANSI_RESET);


        }




    }

    }
}
