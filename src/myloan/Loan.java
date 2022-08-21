package myloan;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A public abstract class implements custom LoanConstants interface and
 * Serializable interface. It is the parent class of Business loan class and
 * Personal class.There are five private
 * variables(customerNo,loanNumber,customerLastName,amountOfLoan,term) stores in
 * this class. Three methods are used in this class.
 *
 */
public abstract class Loan implements LoanConstants, Serializable {

    private static int customerNoGenerator = 0;
    private int customerNo;
    private int loanNumber;
    private String customerLastName;
    private double amountOfLoan;
    private int term;

    /**
     * Constructs and initializes
     */
    public Loan() {
    }

    /**
     * Constructs and initializes
     *
     * @param loanNumber Loan number
     * @param customerLastName Customer's last name
     * @param amountOfLoan Customer's amount of loan
     * @param term Loan's term
     */
    public Loan(int loanNumber, String customerLastName, double amountOfLoan,
            int term) {
        customerNoGenerator++;
        customerNo = customerNoGenerator;
        this.loanNumber = loanNumber;
        this.customerLastName = customerLastName;
        this.amountOfLoan = amountOfLoan;
        this.term = term;
    }

    /**
     * The method used to convert a string object into a string and to display
     * customer loan details
     *
     * @return A display loan message with variables customerNo, loanNumber,
     * amountOfLoan
     */
    public String toString() {
        BusinessLoan bs = new BusinessLoan();
        String customerNoString = Integer.toString(customerNo);
        String loanNumbers = Integer.toString(loanNumber);
        String amountOfLoans = Double.toString(amountOfLoan);

        return "#" + customerNoString + "  Hi! " + customerLastName + " \n    Your loan number: "
                + loanNumbers + "\n    Your amount of loan: "
                + amountOfLoans + "\n    Loan Term: " + getTerm() + " year";
    }

    /**
     * The method to prompt the user input of loanNumber, customerLatName,
     * amountOfLoan and implement the chooseTerm method.
     *
     */
    public void askUserInput() {
        Scanner sc = new Scanner(System.in);
        boolean askAgain = false;
        do {
            try {
                System.out.println("What is your loan number?");
                loanNumber = sc.nextInt();
                System.out.println("What is your last name?");
                customerLastName = sc.next();
                break;
            } catch (InputMismatchException err) {
                System.out.println("*** Please enter an integer or an appropriate value ***");
                askAgain = true;
                sc.nextLine();
            }
        } while (askAgain = true);
        do {
            try {

                do {
                    System.out.println("What is your amount of loan");
                    amountOfLoan = sc.nextDouble();
                    //The amountOfLoan value cannot over the maxLoanAmount value
                    if (amountOfLoan > maxLoanAmount) {
                        System.out.println();
                        System.out.println("***** Over the maximum loan amount *****");
                        System.out.println("The maximum loan amount is $250,000");
                    } else {
                        break;
                    }
                } while (amountOfLoan > maxLoanAmount);
                break;
            } catch (InputMismatchException err) {
                System.out.println("*** Please enter an integer or an appropriate value ***");
                askAgain = true;
                sc.nextLine();
            }
        } while (askAgain = true);

        do {
            try {
                System.out.println("What is your loan term? (1:Short term. 2:medium term. 3: Long term)");
                chooseTerm(sc.nextInt());
                break;
            } catch (InputMismatchException err) {
                System.out.println("*** Please enter an integer or an appropriate value ***");
                askAgain = true;
                sc.nextLine();
            }
        } while (askAgain = true);
    }

    /**
     * The method to choose the term with its corresponding year
     *
     * @param chooseTerm
     * @return Years of term.
     */
    public int chooseTerm(int chooseTerm) {
        switch (chooseTerm) {
            case 1:
                this.term = shortTerm;
                break;
            case 2:

                this.term = mediumTerm;
                break;
            case 3:

                this.term = longTerm;
                break;
            default:
                this.term = shortTerm;
                break;
        }
        return term;
    }

    /**
     * Get the value of the private string variable customerLastName
     *
     * @return the customerLastName
     */
    public String getCustomerLastName() {
        return customerLastName;
    }

    /**
     * Get the value of the private string variable amountOfLoan
     *
     * @return the amountOfLoan
     */
    public double getAmountOfLoan() {
        return amountOfLoan;
    }

    /**
     * Get the value of the private string variable loanNumber
     *
     * @return the loanNumber
     */
    public int getLoanNumber() {
        return loanNumber;
    }

    /**
     * Get the value of the private string variable term
     *
     * @return the term
     */
    public int getTerm() {
        return term;
    }

}
