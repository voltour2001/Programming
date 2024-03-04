package bank;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Register reg = new Register();
        Login log = new Login();
        outerLoop:
        while(true){
            System.out.println("\n\n===> BANK <===");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.print("3. Exit\n:");
            int choice = scanner.nextInt();
            innerLoop:
            switch(choice){
                case 1:
                    log.login();
                    
                    while(true){
                        System.out.println("1. Test");
                        System.out.println("2. Exit");
                        choice = scanner.nextInt();
                        switch(choice){
                            case 1:
                                break;
                            case 2:
                                break innerLoop;

                        }
                    }
                case 2:
                    reg.register();
                    break;
                case 3:
                    System.exit(0);
            }
        }


    }
}