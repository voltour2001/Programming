package bank;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

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
                    List<String> cred = Login.login();
                    System.out.println("\n\n+++++++++++++++++++++++++++++\n\n" + cred + "\n\n");

                    if (cred.isEmpty()) {
                        System.out.println("\n\n===> User does not exist <===\n\n");
                        break innerLoop;
                    }
                    
                    while(true){
                        System.out.println("1. Test");
                        System.out.println("2. Test");
                        System.out.println("3. Exit");
                        choice = scanner.nextInt();
                        switch(choice){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
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