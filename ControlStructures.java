package pgdp.math;

import java.util.Scanner;

import static pgdp.PinguLib.*;

public class ControlStructures {
    public static void main(String[] args) {

       // printTriangle(5);
       // printTriangle(0);
        //printCollatz(11);
        //printCollatz(27);
        //threeAndSeven();
        //sumOfDigits(-5);
        //sumOfDigits(0);
        //sumOfDigits(15);
        //reverseNumber(0);
        //reverseNumber(4);
        //reverseNumber(1002);
        //reverseNumber(1200);
        //printPyramid(3);
        printPrimesUpTo(5);
    }

    public static void printTriangle(int sideLength) {
        if(sideLength <= 0){
            System.out.println("Eingabe muss größer als 0 sein!");
        }
        for(int i = sideLength ; i >= 1 ; i--){
            System.out.println("*".repeat(i));
        }

    }

    public static void printCollatz(int n) {
        if(n <= 0){
            System.out.println("Eingabe muss größer als 0 sein!");
            return;
        }
        int pointer = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        while(n != 1){
            if(n % 2 == 0){
                n = n/2;
                //pointer++;
            }
            else {
                n = 3*n + 1;
                //pointer ++;
            }
            sb.append(" ").append(n);
            pointer ++;
        }
        System.out.println(sb);
        System.out.println("Länge: " + pointer);

    }

    public static void threeAndSeven() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte Zahl eingeben:");
        int i = sc.nextInt();
        if(i <= 0){
            System.out.println("Eingabe muss größer oder gleich 0 sein!");
            return;
        }
        int p = 0;
        for(int c = 1; c <= i; c++){
            if(c % 3 == 0 || c % 7 == 0){
                p += c;
            }
        }
        System.out.println(p);
    }

    public static int sumOfDigits(int n) {
        int mod ;
        int sum = 0;
        if (n < 0) {
            System.out.println("Eingabe muss größer oder gleich 0 sein!");
            return -1;
        }
        if(n ==0){
            System.out.println("Eingabe muss größer oder gleich 0 sein!");
            return 0;
        }

        while( n != 0){
            mod = n % 10;
            sum += mod ;
            n = n / 10;
        }
        System.out.println(sum);
        return sum;
    }


    public static int reverseNumber(int n) {
        int rev = 0 ;
        int p;
        if ( n <= 0 || n >= 999999999){
        return 0; }
        /*else if ( n % 10 == n ){
            return n ; } */
        while (n > 0){
                p = n % 10;
                rev = rev * 10 + p;
                n = n/10;

            }
        System.out.println(rev);
            return rev;

    }

    public static boolean isPalindrome(int n) {
        if (n < 0) {
            return false;

        }
        int reverse = 0;
        int wert = n;
        while (n > 0) {
            reverse = reverse * 10 + n % 10;
            n = n / 10;
        }
        return wert == reverse;
    }


    public static void printPyramid(int height) {
        if(height <= 0){
            System.out.println("Eingabe muss größer als 0 sein!");
        }
        for(int i= 0; i <  height; i++) {
            for (int j = height - i; j > 1; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <  2*i +1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void printPrimesUpTo(int n) {
        if(n < 2){
            System.out.println("");
        }
        for(int i = 2; i <= n; i++ ){ //looping upto n
            boolean prime = true;
            for(int j = 2; j <= Math.sqrt(i); j++){ // checking for prime or not
                if(i % j == 0){
                    //System.out.print("not prime :( ");
                    prime = false;
                    break;
                }
            }
            if(prime == true){
                System.out.print(i + " ");
            }
        }
        //System.out.println();

} }
