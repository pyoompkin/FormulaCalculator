import java.lang.reflect.Method;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class Calculator{
    public static void main(String[]args){
        menu();
    }

//Turns a string into a method, then executes it
    public static void executeMethod(String methodName) {
        try {
            Method method = Calculator.class.getDeclaredMethod(methodName);
            method.invoke(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //menu screen
    public static void menu() throws InputMismatchException {
        Scanner input = new Scanner(System.in);
        String equation;
        System.out.println("Please select from the following menu or enter \"done\":");
        System.out.println("Common Core Math \nShapes \nStatistics \nSequences \nPolynomial/Quadratic Formula \nInterest \nMatrix \nDistance Between Two Points");
        String answer;

        while (true) {
            try {
                answer = input.nextLine().toLowerCase();
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry. Please try again");
                continue;
            }
            if (answer.equals("common core math") || answer.equals("common") || answer.equals("common core")) {
                System.out.println("Please select from the following choices:");
                System.out.println("Addition \nSubtraction \nMultiplication \nDivision");
                while (true) {
                    try {
                        answer = input.nextLine().toLowerCase();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid entry. Please try again");
                    }
                    if(answer.equals("addition")){
                        equation = "x + y";
                        ask(answer, equation);
                        break;
                    }else if(answer.equals("subtraction")){
                        equation = "x - y";
                        ask(answer, equation);
                        break;
                    }else if(answer.equals("multiplication")){
                        equation = "x * y";
                        ask(answer, equation);
                        break;
                    }else if(answer.equals("division")){
                        equation = "x/y";
                        ask(answer, equation);
                        break;
                    }
                }
            } else if (answer.equals("shapes") || answer.equals("shape")) {
                System.out.println("Please select from the following shapes:");
                System.out.println("Area \nVolume");
                while (true) {
                    answer = input.nextLine().toLowerCase();
                    if (answer.equals("area")) {
                        System.out.println("Please select from the following choices:");
                        System.out.println("Square/Rectangle \nCircle \nTriangle");
                        while (true) {
                            try {
                                answer = input.nextLine().toLowerCase();
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid entry. Please try again");
                                continue;
                            }
                            if (answer.equals("square") || answer.equals("rectangle") || answer.equals("square/rectangle")) {
                                answer = "rectangle";
                                equation = "bh";
                                ask(answer, equation);
                                break;
                            } else if (answer.equals("circle")) {
                                equation = "pi * r^2";
                                ask(answer, equation);
                                break;
                            } else if (answer.equals("triangle")) {
                                equation = "bh/2";
                                ask(answer, equation);
                                break;
                            }else{
                                System.out.println("Invalid input. Please try again");
                            }
                        }
                    }else if(answer.equals("volume")){
                        System.out.println("Please select from the following choices:");
                        System.out.println("Cube \nSphere \nPyramid");

                        while (true) {
                            try {
                                answer = input.nextLine().toLowerCase();
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid entry. Please try again");
                                continue;
                            }
                            if(answer.equals("cube")){
                                equation = "lwh";
                                ask(answer, equation);
                                break;
                            }else if(answer.equals("sphere")){
                                equation = "4/3 * pi * r^3";
                                ask(answer, equation);
                                break;
                            }else if(answer.equals("pyramid")){
                                equation = "lwh/3";

                            }else{
                                System.out.println("Invalid input. Please try again");
                            }
                        }
                    }else{
                        System.out.println("Invalid input. Please try again");
                        continue;
                    }
                }
            }else if (answer.equals("statistics") || answer.equals("stats") || answer.equals("stat")) {
                answer = "statistics";
                equation = "\nMean: Sum of the elements / Number of elements \nMedian: Elements from smallest to largest \nRange: Largest element - Smallest element";
                ask(answer, equation);
                break;
            }else if (answer.equals("polynomial") || answer.equals("polynomial equation") || answer.equals("quadratic") || answer.equals("quadratic formula")) { //Need to add else if with all possible options
                answer = "polynomial";
                equation = "Ax^2 + Bx + C = 0";
                ask(answer, equation);
                break;
            }else if(answer.equals("interest")){
                equation = "find the amount of interest after a certain amount of years based on an initial amount.";
                ask(answer, equation);
            }else if(answer.equals("matrix")){
                equation = "solves a 2x2 matrix";
                ask(answer, equation);
            }else if(answer.equals("done")){
                System.exit(0);
            }else if(answer.equals("distance") || answer.equals("distance between two points")){
                equation = "([x2 - x1]^2 + [y2 - y1]^2)^1/2";
                ask(answer, equation);
            }else {
                System.out.println("Invalid input. Please try again");
            }
        }
    }

    //display formula and transition from menu screen to equation solving
    public static void ask(String methodName, String methodEq){
        Scanner input = new Scanner(System.in);

        System.out.println("The formula for " + methodName + " is " + methodEq);
        System.out.println("Would you like to enter variables to solve?");
        String answer;

        while(true){
            try{
                answer = input.nextLine().toUpperCase();
            }
            catch(InputMismatchException e){
                System.out.println("Invalid entry. Please try again");
                continue;
            }
            if(answer.equals("YES")){
                executeMethod(methodName);
            }else if(answer.equals("NO")){
                menu();
            }else{
                System.out.println("Invalid input. Please try again");
            }
        }
    }

    //area of a rectangle
    public static void rectangle(){
        Scanner input = new Scanner(System.in);
        double base;
        double height;

        System.out.println("Enter a number for the base: ");
        while(true){
            if(input.hasNextDouble()){
                base = input.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                input.next();
            }
        }

        System.out.println("Enter a number for the height: ");
        while(true){
            if(input.hasNextDouble()){
                height = input.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                input.next();
            }
        }

        double area = base * height;

        System.out.println("The area is: " + area);
        System.out.println();
        menu();
    }

    //area of a circle
    public static void circle(){
        Scanner input = new Scanner(System.in);
        double radius;

        System.out.println("Enter a number for the radius: ");
        while(true){
            if(input.hasNextDouble()){
                radius = input.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                input.next();
            }
        }

        double area = radius * radius * Math.PI;

        System.out.println("The area is: " + area);
        System.out.println();
        menu();
    }

    //area of a triangle
    public static void triangle(){
        Scanner input = new Scanner(System.in);
        double base;
        double height;

        System.out.println("Enter a number for the base: ");
        while(true){
            if(input.hasNextDouble()){
                base = input.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                input.next();
            }
        }

        System.out.println("Enter a number for the height: ");
        while(true){
            if(input.hasNextDouble()){
                height = input.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                input.next();
            }
        }

        double area = base * height / 2;

        System.out.println("The area is: " + area);
        System.out.println();
        menu();
    }

    //volume of a cube
    public static void cube(){
        Scanner input = new Scanner(System.in);
        double length;
        double height;
        double width;

        System.out.println("Enter a number for the length: ");
        while(true){
            if(input.hasNextDouble()){
                length = input.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                input.next();
            }
        }

        System.out.println("Enter a number for the width: ");
        while(true){
            if(input.hasNextDouble()){
                width = input.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                input.next();
            }
        }

        System.out.println("Enter a number for the height: ");
        while(true){
            if(input.hasNextDouble()){
                height = input.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                input.next();
            }
        }

        double volume = length * width * height;

        System.out.println("The volume is: " + volume);
        System.out.println();
        menu();
    }

    //volume of a sphere
    public static void sphere(){
        Scanner input = new Scanner(System.in);
        double radius;

        System.out.println("Enter a number for the radius: ");
        while(true){
            if(input.hasNextDouble()){
                radius = input.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                input.next();
            }
        }

        double volume = (4/3 * Math.PI * (radius * radius * radius));

        System.out.println("The volume is: " + volume);
        System.out.println();
        menu();
    }

    //volume of a pyramid
    public static void pyramid(){
        Scanner input = new Scanner(System.in);
        double length;
        double height;
        double width;

        System.out.println("Enter a number for the length: ");
        while(true){
            if(input.hasNextDouble()){
                length = input.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                input.next();
            }
        }

        System.out.println("Enter a number for the width: ");
        while(true){
            if(input.hasNextDouble()){
                width = input.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                input.next();
            }
        }

        System.out.println("Enter a number for the height: ");
        while(true){
            if(input.hasNextDouble()){
                height = input.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                input.next();
            }
        }

        double volume = length * width * height / 3;

        System.out.println("The volume is: " + volume);
        System.out.println();
        menu();
    }

    //polynomial/quadratic equation
    public static void polynomial(){
        Scanner input = new Scanner(System.in);
        double A;
        double B;
        double C;

        System.out.println("Enter a number for A: ");
        while(true){
            if(input.hasNextDouble()){
                A = input.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                input.next();
            }
        }

        System.out.println("Enter a number for B: ");
        while(true){
            if(input.hasNextDouble()){
                B = input.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                input.next();
            }
        }

        System.out.println("Enter a number for C: ");
        while(true){
            if(input.hasNextDouble()){
                C = input.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                input.next();
            }
        }

        double discriminant = B * B - 4 * A * C;

        if (discriminant > 0) {
            double root1 = (-B + Math.sqrt(discriminant)) / (2 * A);
            double root2 = (-B - Math.sqrt(discriminant)) / (2 * A);
            System.out.println("Root 1: " + root1);
            System.out.println("Root 2: " + root2);
            System.out.println();
            menu();
        } else if (discriminant == 0) {
            double root = -B / (2 * A);
            System.out.println("Root: " + root);
            System.out.println();
            menu();
        } else {
            System.out.println("The equation has complex roots.");
            double realPart = -B / (2 * A);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * A);
            System.out.println("Root 1: " + realPart + " + " + imaginaryPart + "i");
            System.out.println("Root 2: " + realPart + " - " + imaginaryPart + "i");
            System.out.println();
            menu();
        }
    }

    //mean/median/range of a list of elements
    public static void statistics() {
        Scanner input = new Scanner(System.in);
        int size;
        int[] dataSet;

        System.out.println("How large of a data set would you like to examine? ");
        while(true){
            if(input.hasNextInt()){
                size = input.nextInt();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                input.next();
            }
        }

        dataSet = new int[size];

        System.out.println("Enter the elements of the dataset: ");
        for (int i = 0; i < size; i++) {
            while(true){
                if(input.hasNextInt()){
                    dataSet[i] = input.nextInt();
                    break;
                }else{
                    System.out.println("Invalid input. Please try again");
                    input.next();
                }
            }
        }
        double mean = calculateMean(dataSet);
        double median = calculateMedian(dataSet);
        int range = calculateRange(dataSet);

        System.out.println("Mean: " + mean);
        System.out.println("Median: " + median);
        System.out.println("Range: " + range);
        System.out.println("\n\n");

        menu();
    }

    //method to calculate median
    private static int calculateMedian(int[] dataSet) {
        Arrays.sort(dataSet);
        int middle = dataSet.length / 2;
        if (dataSet.length % 2 == 0) {
            return (dataSet[middle - 1] + dataSet[middle] / 2);
        } else {
            return dataSet[middle];
        }
    }

    //method to calculate mean
    private static double calculateMean(int[] dataSet) {
        int sum = 0;
        for (int num : dataSet) {
            sum += num;
        }
        return (double) sum / dataSet.length;
    }

    //method to calculate range
    private static int calculateRange(int[] dataSet) {
        Arrays.sort(dataSet);
        return dataSet[dataSet.length - 1] - dataSet[0];
    }

    //interest accrued over time
    public static void interest() {
        Scanner input = new Scanner(System.in);
        double initialAmount;
        double annualInterest;
        double timeInYears;

        System.out.println("Enter the initial amount: ");
        while(true){
            if(input.hasNextDouble()){
                initialAmount = input.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                input.next();
            }
        }

        System.out.println("Enter the annual interest rate (as a percent): ");
        while(true){
            if(input.hasNextDouble()){
                annualInterest = input.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                input.next();
            }
        }

        System.out.println("Enter the amount of years: ");
        while(true){
            if(input.hasNextDouble()){
                timeInYears = input.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                input.next();
            }
        }

        double interest = calculateInterest(initialAmount, annualInterest, timeInYears);
        System.out.println("The simple interest is: " + interest);
        System.out.println("\n\n");
        menu();
    }

    //calculate interest accrued over time
    private static double calculateInterest(double initialAmount, double annualInterest, double timeInYears) {
        double rate = annualInterest / 100;
        return initialAmount * rate * timeInYears;
    }

    //2x2 matrix
    public static void matrix() {
        Scanner scanner = new Scanner(System.in);
        double a11;
        double a12;
        double a21;
        double a22;

        System.out.println("Enter the elements of the 2x2 matrix: ");

        System.out.print("Enter element a11: ");
        while(true){
            if(scanner.hasNextDouble()){
                a11 = scanner.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                scanner.next();
            }
        }

        System.out.print("Enter element a12: ");
        while(true){
            if(scanner.hasNextDouble()){
                a12 = scanner.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                scanner.next();
            }
        }

        System.out.print("Enter element a21: ");
        while(true){
            if(scanner.hasNextDouble()){
                a21 = scanner.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                scanner.next();
            }
        }

        System.out.print("Enter element a22: ");
        while(true){
            if(scanner.hasNextDouble()){
                a22 = scanner.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                scanner.next();
            }
        }

        double[][] matrix = {{a11, a12}, {a21, a22}};
        double determinant = calculateDeterminant(matrix);

        System.out.println("\nResults:");

        System.out.println("Determinant: " + determinant);

        System.out.println("[" + a11 + "]  [" + a12 + "]\n[" + a21 + "]  [" + a22 + "]");
        System.out.println("\n\n");
        menu();
    }

    //calculate the determinant for the matrix
    private static double calculateDeterminant(double[][] matrix) {
        return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
    }

    //basic addition
    public static void addition(){
        Scanner scanner = new Scanner(System.in);
        double value1;
        double value2;

        System.out.println("Enter the first value you would like to add: ");
        while(true){
            if(scanner.hasNextDouble()){
                value1 = scanner.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                scanner.next();
            }
        }

        System.out.println("Enter the second value you would like to add: ");
        while(true){
            if(scanner.hasNextDouble()){
                value2 = scanner.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                scanner.next();
            }
        }

        double answer = value1 + value2;
        System.out.println("The sum of the values is " + answer + ".");
        System.out.println();
        menu();
    }

    //basic subtraction
    public static void subtraction(){
        Scanner scanner = new Scanner(System.in);
        double value1;
        double value2;

        System.out.println("Enter the first value you would like to subtract from: ");
        while(true){
            if(scanner.hasNextDouble()){
                value1 = scanner.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                scanner.next();
            }
        }

        System.out.println("Enter the second value you would like to subtract: ");
        while(true){
            if(scanner.hasNextDouble()){
                value2 = scanner.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                scanner.next();
            }
        }

        double answer = value1 - value2;
        System.out.println("The difference of the values is " + answer + ".");
        System.out.println();
        menu();
    }

    //basic multiplication
    public static void multiplication(){
        Scanner scanner = new Scanner(System.in);
        double value1;
        double value2;

        System.out.println("Enter a value to be multiplied: ");
        while(true){
            if(scanner.hasNextDouble()){
                value1 = scanner.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                scanner.next();
            }
        }

        System.out.println("Enter another value to be multiplied: ");
        while(true){
            if(scanner.hasNextDouble()){
                value2 = scanner.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                scanner.next();
            }
        }

        double answer = value1 * value2;
        System.out.println("The answer is " + answer + ".");
        System.out.println();
        menu();
    }

    //basic division
    public static void division(){
        Scanner scanner = new Scanner(System.in);
        double value1;
        double value2;

        System.out.println("Enter the value to be divided: ");
        while(true){
            if(scanner.hasNextDouble()){
                value1 = scanner.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                scanner.next();
            }
        }
        System.out.println("Enter the value to divide: ");
        while(true){
            if(scanner.hasNextDouble()){
                value2 = scanner.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                scanner.next();
            }
        }

        double answer = value1 / value2;
        System.out.println("The answer is " + answer + ".");
        System.out.println();
        menu();
    }

    //calculate the distance between two points
    public static void distance(){
        Scanner scanner = new Scanner(System.in);
        double x1;
        double x2;
        double y1;
        double y2;

        System.out.println("Enter the x value for the first point: ");
        while(true){
            if(scanner.hasNextDouble()){
                x1 = scanner.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                scanner.next();
            }
        }

        System.out.println("Enter the y value for the first point: ");
        while(true){
            if(scanner.hasNextDouble()){
                y1 = scanner.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                scanner.next();
            }
        }

        System.out.println("Enter the x value for the second point: ");
        while(true){
            if(scanner.hasNextDouble()){
                x2 = scanner.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                scanner.next();
            }
        }

        System.out.println("Enter the y value for the second point: ");
        while(true){
            if(scanner.hasNextDouble()){
                y2 = scanner.nextDouble();
                break;
            }else{
                System.out.println("Invalid input. Please try again");
                scanner.next();
            }
        }

        double answer = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println("The distance between the two points is " + answer + ".");
        System.out.println();
        menu();
    }

}