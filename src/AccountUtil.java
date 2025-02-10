import java.time.Year;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AccountUtil {
    public  final String ANSI_GREEN = "\u001B[32m";
    public  final String ANSI_RED = "\u001B[31m";
    public  final String ANSI_RESET = "\u001B[0m";


    String rege="^[1-9]$";
    String nameRegex="^[a-zA-Z]+$";
    String regexDate="^^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
    Scanner sc=new Scanner(System.in);
    String RegexPhone= "^0\\d{7,11}$";
    String regeDouble="[0-9]+(\\\\.[0-9]{1,2})?$";
      String YesNo= "^[y|n]$";

    public  String InputYN() {
        String answer;
        while (true){
            System.out.println(ANSI_GREEN+"=>Do you want to cotineu? (y/n):"+ANSI_RESET);
            answer= sc.next().trim().toLowerCase();
            if (Pattern.matches(YesNo, answer)) {
                break;
            } else {
                System.out.println(ANSI_RED + "Invalid input. Please enter a valid number." + ANSI_RESET);
            }
        }
        return  answer;
    }

    public int InputOption(String text ){
        String number;
        do {
            System.out.print(ANSI_GREEN+text+ANSI_RESET);
            number =sc.next();
            if (Pattern.matches(rege, number)){
                break;
            }else {
                System.out.println(ANSI_RED+"input only number"+ANSI_RESET);
            }
        }while (true);

        return  Integer.parseInt(number);
    }

    public String Inputname(String text){
        String name;
        do {
            System.out.print(text);
            name = sc.next();
            if (Pattern.matches(nameRegex,name)){
                break;
            }else {
                System.out.println(ANSI_RED+"You can input number....."+ANSI_RESET);
            }
        }while (true);

        return name;
    }


    public String InputDate(String text) {
        String Date;

        Year year= Year.now();
        int y = Integer.parseInt(String.valueOf(year));
        do {
            System.out.print(text);
            Date = sc.next();
            if (Pattern.matches(regexDate,Date)){
                String []a =Date.split("-");
                int year2= Integer.parseInt(a[2]);
                if  (y-year2 > 18 ){
                    break;
                }else {
                    System.out.println(ANSI_RED+"We donn't allow user under 18 create ACC...."+ANSI_RESET);
                }

            }else {
                System.out.println(ANSI_RED+"Invalid data"+ANSI_RESET);
            }
        }while (true);

        return Date;
    }

    public Gender InputGender(String text){
        String Gnder;
        while (true){
            System.out.print(text);
            Gnder= sc.next().toUpperCase().trim();
            if(Gnder.equals("MALE")){
                return Gender.MALE;
            }
            if (Gnder.equals("FEMALE")){
                return  Gender.FEMALE;
            }
            else {
                System.out.println(ANSI_RED+"Cannot input anythig only(MALE/FEMALE)"+ANSI_RESET);
            }

        }

    }

    public String PhonNumber(String text){
        String Phone;
        do {
            System.out.print(text);
            Phone=sc.next();
            if (Pattern.matches(RegexPhone,Phone)){
                break;
            }
            else {
                System.out.println(ANSI_RED+"Invalid data....."+ANSI_RESET);

            }
        }while (true);
        return Phone;
    }



    public double Inputbalance(String text){
       String balance;
        do {
            System.out.print(text);
            balance=sc.next();

            if (Pattern.matches(regeDouble, balance)){
                break;
            }else {
                System.out.println(ANSI_RED+"Invalid data....."+ANSI_RESET);
            }
        }while (true);
        return Double.parseDouble(balance);
    }



    public double InputRate(String text){
        String rate;
        do {
            System.out.println(text);
            rate=sc.next();


            if (Pattern.matches(regeDouble, rate)){
                break;
            }else {
                System.out.println(ANSI_RED+"Invalid data....."+ANSI_RESET);
            }
        }while (true);
        return Double.parseDouble(rate);
    }


}





