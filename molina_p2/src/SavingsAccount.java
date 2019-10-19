public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public double calculateMonthlyInterest() {
        double monthlyInterest = (savingsBalance * annualInterestRate) / 12.0;
        savingsBalance += monthlyInterest;
        savingsBalance = Math.round(savingsBalance *100.0) / 100.0;
        return savingsBalance;
    }
    public static void modifyInterestRate(double rate){
        annualInterestRate = rate;
    }
    public void setBalance(double bal){
        savingsBalance = bal;
    }
    public static void main(String args[]) {

    }
}
