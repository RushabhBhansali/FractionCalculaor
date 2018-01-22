import java.util.Scanner;
import java.util.regex.Pattern;


public class FractionCalculator {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){

        introduction();



        while(true) {
            String  operator = getOperation(input);
            Fraction fraction1 = getFraction(input);
            Fraction fraction2 = getFraction(input);
            Fraction result;


            if (operator.equals("+")) {
                result = fraction1.add(fraction2);
                System.out.println(fraction1.toString() +"  "+ operator+"  "+ fraction2.toString() + " = " + result.toString());
            } else if (operator.equals("-")) {
                result = fraction1.subtract(fraction2);
                System.out.println(fraction1.toString() +"  "+ operator+"  "+ fraction2.toString() + " = " + result.toString());
            } else if (operator.equals("/")) {
                result = fraction1.divide(fraction2);
                if(result == null){
                    System.out.println(fraction1.toString() + "  " + operator + "  " + fraction2.toString() + " = " + "undefined");
                }
                else {
                    System.out.println(fraction1.toString() + "  " + operator + "  " + fraction2.toString() + " = " + result.toString());
                }

            } else if (operator.equals("*")) {
                result = fraction1.multiply(fraction2);
                System.out.println(fraction1.toString() +"  "+ operator+"  "+ fraction2.toString() + " = " + result.toString());
            } else {
                boolean ret = fraction1.equals(fraction2);
                System.out.println(fraction1.toString() +"  "+ operator+"  " + fraction2.toString() + " is " + ret);
            }
            System.out.println(" ------------------------------------------------------------------------------------- ");
        }
    }

    public static void introduction(){
        System.out.println("This program is a fraction calculator");
        System.out.println(" It will add, subtract, multiply and divide fractions until you type Q to quit");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers");
        System.out.println(" ------------------------------------------------------------------------------------- ");
    }

    public static String getOperation(Scanner input){
        //System.out.println("Please enter an operation (+, -, /, *, = or Q to quit)");
        System.out.print("\n Please enter an operation (+, -, /, * = or Q to quit):");
        //String operator = input.nextLine();
        while(true){
            String operator = input.nextLine();
            if (operator.equals("+") || operator.equals("-") || operator.equals("/") || operator.equals("*") || operator.equals("=")){
                return operator;
            }
            else if (operator.toUpperCase().equals("Q")){
                System.exit(0);
            }
            else{
                System.out.print("Invalid input (+, -, /, * = or Q to quit):");
            }
        }
    }

    public static boolean validFraction(String input){
        return input.matches("^-?\\d+((\\/[1-9](\\d*))|(\\/0+[1-9](\\d*))|)$");
    }

    public static Fraction getFraction(Scanner input){
        System.out.print("\n Please enter a fraction (a/b) or integer (a):");


        while(true){
            String inputString = input.nextLine().toString();
            if(validFraction(inputString)){
                int num;
                int den;
                if(inputString.contains("/")){
                   num = Integer.parseInt(inputString.split("/")[0]);
                   den = Integer.parseInt(inputString.split("/")[1]);
                }
                else{
                    num = Integer.parseInt(inputString);
                    den = 1;
                }
                Fraction retObj = new Fraction(num, den);
                return retObj;

            }
            else{
                System.out.print("Invalid fraction. PLease enter (a/b) or (a), where a and b are integers and b is not zero: ");
            }

        }
    }

}
