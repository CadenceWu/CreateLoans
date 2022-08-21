package createloans;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import myloan.*;
import java.util.Scanner;
//Java AT2 Activity 1 
//Date:06/2022

/**
 * The CreateLoans class contains loan objects in a collection type, with the
 * function of storing,displaying, saving and reading customer's loan
 * information.
 *
 * @author cheng Chieh Wu
 */
public class CreateLoans {

    //Create an ArrayList to store loans objects.
    private static ArrayList<Loan> loans = new ArrayList<>(5);

    /**
     * The main method to run the programmer
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean askAgain = false;//Ask user again will be true if they enter the wrong type or an inappropriate value

        Loan bsLoan = new BusinessLoan() {
        };

        Loan psLoan = new PersonalLoan() {
        };
        double interestRateEnter = 0;
        do {
            try {
                System.out.println("What is the current prime interest rate?");
                interestRateEnter = sc.nextDouble();
                break;
            } catch (InputMismatchException err) {
                System.out.println("*** Please enter an integer or an appropriate value ***");
                askAgain = true;
                sc.nextLine();
            }
        } while (askAgain = true);
        do {
            try {
                for (int i = 0; i < 3; i++) {
                    do {
                        System.out.println("What is your loan type (enter the number)? (1:Business,2:Personal)");
                        int loanType = sc.nextInt();

                        if (loanType == 1) {
                            bsLoan.askUserInput();
                            loans.add(new BusinessLoan(bsLoan.getLoanNumber(), bsLoan.getCustomerLastName(), bsLoan.getAmountOfLoan(),
                                    bsLoan.getTerm(), interestRateEnter) {
                            });
                            break;
                        } else if (loanType == 2) {
                            psLoan.askUserInput();
                            loans.add(new PersonalLoan(psLoan.getLoanNumber(), psLoan.getCustomerLastName(), psLoan.getAmountOfLoan(),
                                    psLoan.getTerm(), interestRateEnter) {
                            });
                            break;
                        } else {
                            System.out.println("Only 1 or 2");
                            continue;
                        }
                    } while (askAgain = true);
                    System.out.println("***** Successfully saved the information *****");
                }
                break;
            } catch (InputMismatchException err) {
                System.out.println("*** Please enter an integer or an appropriate value ***");
                askAgain = true;
                sc.nextLine();
            }
        } while (askAgain = true);
        System.out.println(" >>>  Show all the loans  <<<");
        for (Loan loan : loans) {
            System.out.println(loan);//Display the data using toString() 
        }
        writingToFile();//Use the writingToFile method
        readingFromFile();//Use the readingFromFile method
    }

    /**
     * The writingToFile method stores the collection object in a binary file
     * using the Serializable interface
     */
    public static void writingToFile() {
        System.out.println();
        System.out.println("*****  Writing to file *****");

        try {
            FileOutputStream fileOut = new FileOutputStream("loans.bin");//Save the file as loans.bin
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(loans);
            fileOut.close();
            System.out.println("Successfully Saved the file as loans.bin");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * The readingFromFile method reads the object from the binary file and
     * display the contents on the screen
     */
    public static void readingFromFile() {
        System.out.println();
        System.out.println("*****  Reading from file  *****");
        ArrayList al = new ArrayList();

        try {
            FileInputStream fileIn = new FileInputStream("loans.bin");//Read the file named loans.bin
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            al = (ArrayList) objectIn.readObject();
            fileIn.close();
        } catch (IOException err) {
            System.out.println(err);
        } catch (ClassNotFoundException err) {
            System.out.println(err);
        }
        for (int i = 0; i < al.size(); i++) {
            Loan temp = (Loan) al.get(i);
            System.out.println(temp);
        }
    }
}
