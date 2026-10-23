import java.util.Scanner;

public class App {
    static String GREEN = "\u001B[32m";
    static String RED = "\u001B[31m";
    static String RESET = "\u001B[0m";
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        double balance = 0;
        int choice;
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("------------");
            System.out.println(RED + "BANKING PROGRAM");
            System.out.println("------------");
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit" + RESET);
            System.out.println("------------");

            System.out.print(GREEN + "Enter your choice (1-4): " + RESET);
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> showBalance(balance);
                case 2 -> balance += deposit();
                case 3 -> balance -= withdraw(balance);
                case 4 -> {
                    isRunning = false;
                    System.out.println(RED + "----------------------------" + RESET);
                    System.out.println(GREEN + "Thank you! Have a nice day!" + RESET);
                    System.out.println(RED + "----------------------------" + RESET);

                }

                default -> System.out.println(RED + "Invalid Choice!" + RESET);
            }

        }
    }

    static void showBalance(double balance){
        System.out.printf(GREEN + "$%.2f\n" + RESET, balance );
    }
    static double deposit(){

        double amount;

        System.out.print(RED + "Enter an amount to be deposited: " + RESET);
        amount = scanner.nextDouble();

        if(amount < 0 ){
            System.out.println(RED + "Amount can't be negative" + RESET);
            return 0;
        }else{
            return amount;
        }
    }
    static double withdraw(double balance){
        double amount;

        System.out.print(RED + "Enter amount to be withdrawn: " + RESET);
        amount = scanner.nextDouble();

        if(amount > balance){
            System.out.println(RED + "INSUFFICIENT FUNDS" + RESET);
            return 0;
        }else if(amount < 0){
            System.out.println(RED + "Amount can't be negative" + RESET);
            return 0;
        }else{
            return amount;
        }
        
        
    }

}