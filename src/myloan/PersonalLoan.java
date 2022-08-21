package myloan;

/**
 * This class is as the sub class of the Loan class with two variables
 * (interestRate,loanFee)
 *
 */
public class PersonalLoan extends Loan {

    private double interestRate;
    double loanFee;

    /**
     * Constructs and initializes
     */
    public PersonalLoan() {
    }

    /**
     * Inherit the constructor from the Loan class, adding a variable
     * interestRate
     *
     * @param loanNumber
     * @param customerLastName
     * @param amountOfLoan
     * @param term
     * @param interestRate
     */
    public PersonalLoan(int loanNumber, String customerLastName, double amountOfLoan,
            int term, double interestRate) {
        super(loanNumber, customerLastName, amountOfLoan, term);
        this.interestRate = interestRate + 0.02;//The interest rate will be 2% over the prime interest rate
        loanFee = amountOfLoan * this.interestRate * term;
    }

    /**
     * The method used to convert a string object into a string and to display
     * customer loan details. The method is inherit from the Loan class.
     *
     * @return A display loan message with variables customerNo, loanNumber,
     * amountOfLoan, interestRataea and loanFee
     */
    @Override
    public String toString() {
        return super.toString() + "\n    The interestRate for Personal loan: " + interestRate
                + "\n    Your total amount owed: " + loanFee;
    }

    /**
     * Get the value of the private string variable interestRate
     *
     * @return the interestRate
     */
    public double getInterestRate() {
        interestRate = interestRate + 0.02;
        return interestRate;
    }
}
