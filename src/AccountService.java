public class AccountService  {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";



   static String UserName;
    static String Date;
    static Gender Genser;
    static String PhoneNumber;

    static String UserName2;
    static String Date2;
    static Gender Genser2;
    static String PhoneNumber2;
   static double Balance;
    static   double rate;
    static AccountUtil util =new AccountUtil();
  static Account check= null;
  static Account saving =null;


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

static void CreateAcc(){

    do {
        System.out.println();
        if (saving != null && check != null){
            System.out.println(ANSI_RED+"All Account had been created"+ANSI_RESET);
            return;
        }
        System.out.println(ANSI_BLUE+"=============== Account Information ======================"+ANSI_RESET);
        System.out.println("1. Checking Account");
        System.out.println("2. Saving Account");
        System.out.println("3. Back");
        System.out.println("================================================================");
        int OptionCase1= util.InputOption("What type of account do you want to crate?");
            switch (OptionCase1){
                case 1:{
                    if (check !=null){
                        System.out.println(ANSI_RED+"Account have already create" + ANSI_RESET);
                        return;
                    }

                    System.out.println(ANSI_GREEN+"============== Checking Account ==================="+ANSI_RESET);

                     UserName= util.Inputname("Enter your name:");
                     Date= util.InputDate("Enter Date of birth (dd/mm/yyyy)");
                     Genser= util.InputGender("Enter your Gender:");
                     PhoneNumber=util.PhonNumber("Enter your PhoneNumber:");
                     check= new CheakingAccount(UserName,Date,Genser,PhoneNumber, Balance);
                    System.out.println(ANSI_GREEN+"==================================");
                    System.out.println("Your checking account has been created successfuly!"+ANSI_RESET);
                    System.out.println();
                    break;

                }
                case 2:{
                    System.out.println();
                    if (saving !=null){
                        System.out.println(ANSI_RED+"Account have already create" + ANSI_RESET);
                        return;
                    }

                    System.out.println(ANSI_GREEN+"==============  Saving Account ==================="+ANSI_RESET);

                     UserName2= util.Inputname("Enter your name:");
                     Date2= util.InputDate("Enter Date of birth (dd/mm/yyyy)");
                     Genser2= util.InputGender("Enter your Gender:");
                     PhoneNumber2=util.PhonNumber("Enter your PhoneNumber:");
                     saving= new SavingAccount(UserName2,Date2,Genser2,PhoneNumber2, rate);
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
        System.out.println();
        if (saving == null && check == null){
            System.out.println(ANSI_RED+"Donnot have any Account yet"+ANSI_RESET);
            System.out.println();
            return;
        }

        System.out.println(ANSI_BLUE+"=============== Deposit Money ======================"+ANSI_RESET);
        System.out.println("1. Checking Account");
        System.out.println("2. Saving Account");
        System.out.println("3. Back");
        System.out.println("================================================================");
        int OptionCase1= util.InputOption(ANSI_PURPLE+"What type of account do you want to crate?"+ANSI_RESET);
        System.out.println();
        switch (OptionCase1){
            case 1:{
                if (check == null){
                    System.out.println(ANSI_RED+"Dontnot have Cheacking Account yet.."+ANSI_RESET);
                    return;
                }

                double a;
                System.out.println();
                System.out.println(ANSI_BLUE+"========= Cheacking Account ============"+ANSI_RESET);
                 a=util.Inputbalance("Enter money to deposite:");
                Balance=check.deposit(a);
                System.out.println(ANSI_BLUE+"Deposite successfuly"+ANSI_RESET);
                System.out.println();

                break;
            }
            case 2:{
                if (saving == null){
                    System.out.println(ANSI_RED+"Dontnot have Saving Account yet.."+ANSI_RESET);
                    return;
                }
                System.out.println();
                System.out.println(ANSI_BLUE+"========= Saving acc Account ============"+ANSI_RESET);
                double b;
                b=util.InputRate("Enter money to deposite:");
                System.out.println(ANSI_GREEN+"Recieve:\t\t\t\t$"+b);
                rate =saving.deposit(b);
                System.out.println(ANSI_BLUE+"Deposite successfuly"+ANSI_RESET);
                System.out.println();

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
         System.out.println();
         if (saving == null && check == null){
             System.out.println(ANSI_RED+"Donnot have any Account yet"+ANSI_RESET);
             System.out.println();
             return;
         }
         System.out.println(ANSI_BLUE+"=============== Widthraw Money ======================"+ANSI_RESET);
         System.out.println("1. Checking Account");
         System.out.println("2. Saving Account");
         System.out.println("3. Back");
         System.out.println("===========================================================");
         int OptionCase1= util.InputOption("What type of account do you want to crate?");
         System.out.println();
         switch (OptionCase1){

             case 1:{
                 if (check==null){
                     System.out.println(ANSI_RED+"You donot have Checking  Account yet"+ANSI_RESET);
                     return;
                 }
                 System.out.println(ANSI_BLUE+"========= Cheacking Account ============"+ANSI_RESET);
                 double deposite= util.Inputbalance("Enter your Withdraw:");
                 double input = check.withdraw( deposite);
                 Balance =input;
                 break;
             }
             case 2:{
                 if (saving==null){
                     System.out.println(ANSI_RED+"You donot have Saving  Account yet"+ANSI_RESET);
                     return;
                 }
                 System.out.println(ANSI_BLUE+"========= Saving Account ============"+ANSI_RESET);
                 double deposite= util.Inputbalance("Enter your Withdraw:");
                 double input=  saving.withdraw(deposite);
                 rate =input;
                 break;
             }
             case 3:{
                 return;
             }
             default:System.out.println(ANSI_RED+"Invalid number......"+ANSI_RESET);
         }
     }while (true);

}

public static void DisplayAcc(){
    System.out.println();
         if (check !=null){
             check.displayAcc();
         }
         if (saving!=null){
             saving.displayAcc();
         }
}
public static void TranferMoney(){
     do {
         System.out.println();
         if (saving == null && check == null){
             System.out.println(ANSI_RED+"Donnot have any Account yet"+ANSI_RESET);
             return;
         }
         System.out.println();
         System.out.println(ANSI_BLUE+"============== Tranfer Money========="+ANSI_RESET);
         System.out.println("1. Checking Account -> Saving Account");
         System.out.println("2. Saving Account ->  Checking Account");
         System.out.println("3. Back");
         System.out.println("================================================");
         int OptionCase1= util.InputOption("What type of account do you want to crate?");
         switch (OptionCase1){
             case 1:{
                if (saving == null){
                    System.out.println(ANSI_RED+"Dontnot have Saving Account to tranfer.."+ANSI_RESET);
                    System.out.println();
                    return;
                }

            double tranfer=util.Inputbalance("Enter your money:");

                 check.tranfer(tranfer, saving);
                 break;
             }
             case 2:{
                 if (check == null){
                     System.out.println(ANSI_RED+"Dontnot have Checking Account to tranfer.."+ANSI_RESET);
                     return;
                 }

                 double tranfer=util.Inputbalance("Enter your money:");

                 saving.tranfer(tranfer, check);
                     break;
             }
             case 3:{
                 return;
             }
             default:System.out.println(ANSI_RED+"Invalid number......"+ANSI_RESET);
         }

     }while (true);


}
public  static void DeleteAcc(){
    System.out.println();
    if (check== null &&saving == null){
        System.out.println(ANSI_RED+"You donot have any Account yet"+ANSI_RESET);
        return;
    }
    System.out.println(ANSI_BLUE+"============== Delete Account========="+ANSI_RESET);
    System.out.println("1. Checking Account ");
    System.out.println("2. Saving Account ");
    System.out.println("3. Back");
    System.out.println("===============================================");
    int OptionCase1= util.InputOption("What type of account do you want to crate?");
    System.out.println();
    switch (OptionCase1){

        case 1:{
            System.out.println();
            if (check==null){
                System.out.println(ANSI_RED+"You donot have Checking  Account yet"+ANSI_RESET);
                break;

            }
           String a=util.InputYN();
            if (a.equals("n")){
                break;
            }
            break;
        }
        case 2:{
            System.out.println();
            if (saving==null){
                System.out.println(ANSI_RED+"You donot have Checking  Account yet"+ANSI_RESET);
                break;
            }
            String a=util.InputYN();
            if (a.equals("n")){
                break;
            }else {

            }
            break;
        }
        case 3:{
            return;
        }
        default:System.out.println(ANSI_RED+"Invalid number......"+ANSI_RESET);
    }

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
                Widthdraw();

                break;
            }
            case 4:{
                    TranferMoney();

                break;
            }
            case 5:{
                DisplayAcc();
                break;
            }
            case 6:{
                DeleteAcc();

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
