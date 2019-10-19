public class Application {
    public static void main(String args[]) {
        int i;
        double newBal1;
        double newBal2;
        double initialBal1;
        double initialBal2;


        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();

        saver1.modifyInterestRate(0.04);
        saver2.modifyInterestRate(0.04);

        initialBal1 = 2000.00;
        initialBal2 = 3000.00;

        saver1.setBalance(initialBal1);
        saver2.setBalance(initialBal2);

        System.out.printf("Saver 1 initial balance: $%.2f\n", initialBal1);

        for (i = 1; i < 13; i++) {
            newBal1 = saver1.calculateMonthlyInterest();
            System.out.print("Saver 1 balance after " + i + " month");
            if (i != 1) {
                System.out.print("s");
            }
            System.out.printf(": $%.2f\n", newBal1);
        }

        System.out.println();

        for (i = 1; i < 13; i++) {
            newBal2 = saver2.calculateMonthlyInterest();
            System.out.print("Saver 2 balance after " + i + " month");
            if (i != 1) {
                System.out.print("s");
            }
            System.out.printf(": $%.2f\n", newBal2);
        }

        System.out.println();

        saver1.modifyInterestRate(0.05);
        saver2.modifyInterestRate(0.05);

        saver1.setBalance(initialBal1);
        saver2.setBalance(initialBal2);

        newBal1 = saver1.calculateMonthlyInterest();
        System.out.printf("Saver 1 balance after 1 month: $%.2f\n", newBal1);

        newBal2 = saver2.calculateMonthlyInterest();
        System.out.printf("Saver 2 balance after 1 month: $%.2f\n", newBal2);

    }
}
