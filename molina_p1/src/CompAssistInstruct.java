import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.NoSuchProviderException;
import java.util.Scanner;
import java.lang.Math;

public class CompAssistInstruct {
    public static int getRandomInt(SecureRandom srg, int min, int max){
        //SecureRandom srg = SecureRandom.getInstance("SHA1PRNG");
        int x, r;
        x = srg.nextInt(max - min + 1);
        r = (x + min);
        return r;
    }
    public static void printCorrect(int statementNum){

        switch(statementNum){
            case 0:
                System.out.println("Very good!");
                break;
            case 1:
                System.out.println("Excellent!");
                break;
            case 2:
                System.out.println("Nice work!");
                break;
            case 3:
                System.out.println("Keep up the good work!");
                break;
        }
    }
    public static void printError(int randomNum){
        System.out.println(randomNum);
        switch(randomNum){
            case 0:
                System.out.println("No. Please try again.");
                break;
            case 1:
                System.out.println("Wrong. Try once more.");
                break;
            case 2:
                System.out.println("Don't give up!");
                break;
            case 3:
                System.out.println("No. Keep trying.");
                break;
        }
    }
    public static int printMultProblem(int num1, int num2){
        int ans;
        int response;
        Scanner scnr = new Scanner(System.in);
        ans = num1 * num2;
        while(true) {
            System.out.println("How much is " + num1 + " times " + num2 + "?");
            response = scnr.nextInt();
            if (response == ans) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }
    public static int printAddProblem(int num1, int num2){
        int ans;
        int response;
        Scanner scnr = new Scanner(System.in);
        ans = num1 + num2;
        while(true) {
            System.out.println("How much is " + num1 + " plus " + num2 + "?");
            response = scnr.nextInt();
            if (response == ans) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }
    public static int printSubProblem(int num1, int num2){
        int ans;
        int response;
        Scanner scnr = new Scanner(System.in);
        ans = num1 - num2;
        while(true) {
            System.out.println("How much is " + num1 + " minus " + num2 + "?");
            response = scnr.nextInt();
            if (response == ans) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }
    public static int printDivProblem(double num1, double num2){
        double ans;
        double response;
        Scanner scnr = new Scanner(System.in);
        ans = num1 / num2;
        ans = Math.round(ans*100.0) / 100.0;
        while(true) {
            System.out.println("How much is " + num1 + " divided by " + num2 + "?\n(Round to two decimal places)");
            response = scnr.nextDouble();
            if (response == ans) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }
    public static int runTenTimes(int min, int max, int aType){
        SecureRandom randgen = new SecureRandom();
        int i;
        int op1, op2;
        int ansCorrect = 0;
        int x = aType;
        for (i = 0; i < 10; i++) {
            op1 = getRandomInt(randgen,min,max);
            op2 = getRandomInt(randgen,min,max);


            if (aType == 5) {
                x = getRandomInt(randgen, 1 , 4);
            }

            switch (x) {
                case 1:
                    ansCorrect += printAddProblem(op1, op2);
                    break;
                case 2:
                    ansCorrect += printMultProblem(op1, op2);
                    break;
                case 3:
                    ansCorrect += printSubProblem(op1, op2);
                    break;
                case 4:
                    if (op2 == 0){
                        op2++;
                    }
                    ansCorrect += printDivProblem((double)op1, (double)op2);
                    break;
            }
        }
        System.out.println("Answers correct: " + ansCorrect);
        return ansCorrect;
    }
    public static int setDifficulty(Scanner scnr){
        System.out.println("Select difficulty (1-4)");
        int difficulty = scnr.nextInt();
        if (difficulty > 4 || difficulty < 1) {
            System.out.println("Invalid diffculty");
            return setDifficulty(scnr);
        }
        else {
            return difficulty;
        }
    }
    public static int arithmeticType(Scanner scnr){
        int input;
        System.out.println("Press 1 for addition");
        System.out.println("Press 2 for multiplication");
        System.out.println("Press 3 for subtraction");
        System.out.println("Press 4 for division");
        System.out.println("Press 5 for random");
        input = scnr.nextInt();
        if (input > 5 || input < 1) {
            System.out.println("Invalid input");
            return arithmeticType(scnr);
        }
        else {
            return input;
        }
    }
    public static void calcScore(){
        Scanner scnr = new Scanner(System.in);
        int diff = setDifficulty(scnr);
        int score = 0;
        int aType = arithmeticType(scnr);
        switch(diff){
            case 1:
                score = runTenTimes(0,9, aType);
                break;
            case 2:
                score = runTenTimes(10,99, aType);
                break;
            case 3:
                score = runTenTimes(100,999, aType);
                break;
            case 4:
                score = runTenTimes(1000,9999, aType);
                break;
        }

        if (score > 7){
            System.out.println("Congratulations, you are ready to go to the next level!");
        }
        else{
            System.out.println("Please ask your teacher for extra help.");
        }
    }
    public static void main(String[] args) {
        String x;
        Scanner scnr = new Scanner(System.in);
        while(true){
            calcScore();
            System.out.println("Would you like to start a new session? (Y or N)");
            x = scnr.nextLine();
            if ((x.compareTo("n") == 0) || (x.compareTo("N") == 0)) {
                return;
            }
        }
    }
}
