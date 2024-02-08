// Programmers:  Costa Marmaras
// Course:  CS 212
// Due Date: 2/8/24
// In class assesment: Phone Bill
// Problem Statement: Create a program that will calculate a users phone bill based on their package
//                      and data used
// Data In: Package and how many GBs of data used
// Data Out: Final cost taking into account the amount of GBs of data used
// Credits: [Is your code based on an example in the book, in class, or something else?
//            Reminder: you should never take code from the Internet or another person

//Import scanner and decimal format
import java.util.Scanner;
import java.text.DecimalFormat;
class HelloWorld {
    public static void main(String[] args) {
        //initialize scanner and decimal format, and intro print statement
        Scanner input = new Scanner(System.in);
        System.out.println("This program will calculate your phone bill based on your package");
        DecimalFormat twoDigits = new DecimalFormat("$.00");

        //initialize the needed boolean variable
        boolean hasCoupon = false;

        //ask the user what package they have and strips and sets it to lower case
        System.out.println("What Phone Package Do You Have? (Green, Blue, or Purple)");
        String phonePack = input.nextLine().strip().toLowerCase();

        //keep asking the user for what package they use until they input a valid answer
        while(!phonePack.equals("green") && !phonePack.equals("blue") && !phonePack.equals("purple"))
        {
            System.out.println("That is not a valid input.\nPlease input a valid input (green, blue, or purple");
            phonePack = phonePack = input.nextLine().strip().toLowerCase();
        }

        //Ask the user if they have a coupon if they have the green package
        if(phonePack.equals("green"))
        {
            System.out.println("Do you have a coupon? (Y or N)");
            String coup = input.nextLine().strip().toUpperCase();
            //Ask until they input a valid answer
            while(!coup.equals("Y") && !coup.equals("N"))
            {
                System.out.println("That is not a valid input\nPlease input a valid input (Y/N)");
                coup = input.nextLine().strip().toUpperCase();
            }
            if(coup.equals("Y"))
            {
                hasCoupon = true;
            }
        }
        /*if elif ternary operator to find the max GBs of data and the base cost of the phone plan
         (if its purple it is defaulted to 0
         because data is not accounted in purple and therefore could be any number
         */
        int maxGB = (phonePack.equals("green"))? 2 : phonePack.equals("blue")? 4 : 0;
        double cost = (phonePack.equals("green"))? 49.99 : phonePack.equals("blue")? 70.00 : 99.95;

        //Ask the user how many GBs of data they used and make sure that it is above 0
        System.out.println("How many GBs of data did you use this month?");
        int gbUsed = input.nextInt();
        while(gbUsed < 0)
        {
            System.out.println("That is not a valid input\nPlease input a number 0 or above");
            gbUsed = input.nextInt();
        }

        if(phonePack.equals("green"))
        {
            if(gbUsed > maxGB)
            {
                gbUsed -= 2;
                gbUsed *= 15;
                cost += gbUsed;
            }
            if(hasCoupon)
            {
                cost -= 20;
            }
        }
        else if(phonePack.equals("blue"))
        {
            if(gbUsed > maxGB)
            {
                gbUsed -= 4;
                gbUsed *= 10;
                cost += gbUsed;
            }
        }
        System.out.println("Your phone bill for this month will be: " + twoDigits.format(cost));
    }
}
