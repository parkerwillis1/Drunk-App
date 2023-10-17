/**
 *  @author Robert-Anthony Tellez (ece282)
 *  UTSA CS 3443 - Group Project
 *  Spring 2023
 *  Calculate.java
 *  class that handles calculations of the BAC Calculator
 */

package edu.utsa.cs3443.drunkappfinal.Model;

public class Calculate
{
    /**
     * variables
     */
    static Double legalTexasBAC = 0.08;
    static Double sexMale = 0.68;
    static Double sexFemale = 0.55;
    static Double beer = 12.0;
    static Double beerPercent = 0.05;
    static Double wine = 5.0;
    static Double winePercent = 0.12;
    static Double maltLiquor = 8.0;
    static Double maltLiquorPercent = 0.08;
    static Double spirit = 1.5;
    static Double spiritPercent = 0.4;

    /**
     * calculates the blood alcohol content of a person using provided info
     * @param weight
     * @param sex
     * @param hours
     * @param drink
     * @param drinkNum
     * @return
     */
    public static double calculate(String weight, String sex, String hours, String drink, String drinkNum)
    {
        //local variables
        double sexValue = 0;
        double drinkValue = 0;
        double BACvalue = 0;
        double alcoholGrams = 0.0;
        double alcoholPercentCalc = 0;
        double weightCalc = Double.parseDouble(weight);
        double drinkNumCalc = Double.parseDouble(drinkNum);
        double hoursCalc = Double.parseDouble(hours);

        //if statements that return zero if information is not properly entered
        if(Double.parseDouble(weight) < 0)
        {
            return 0;
        }
        if(!sex.equals("Male") && !sex.equals("Female"))
        {
            return 0;
        }
        if(Double.parseDouble(hours) < 0)
        {
            return 0;
        }
        if(!drink.equals("Beer") && !drink.equals("Wine") && !drink.equals("Malt Liquor") && !drink.equals("Spirit"))
        {
            return 0;
        }
        if(Double.parseDouble(drinkNum) < 0)
        {
            return 0;
        }

        //if - else statements that get the proper values for sex and drink alcohol percentage
        if(sex.equals("Male"))
        {
            sexValue = sexMale;
        } else if (sex.equals("Female"))
        {
            sexValue = sexFemale;
        }
        if(drink.equals("Beer"))
        {
            drinkValue = beer;
            alcoholPercentCalc = beerPercent;
        } else if (drink.equals("Wine"))
        {
            drinkValue = wine;
            alcoholPercentCalc = winePercent;
        }else if (drink.equals("Malt Liquor"))
        {
            drinkValue = maltLiquor;
            alcoholPercentCalc = maltLiquorPercent;
        }else if (drink.equals("Spirit"))
        {
            drinkValue = spirit;
            alcoholPercentCalc = spiritPercent;
        }

        //BAC calculation
        alcoholGrams = drinkValue * 29.5735 * alcoholPercentCalc * 0.789;
        BACvalue = (((alcoholGrams*drinkNumCalc)/((weightCalc*454) * sexValue))*100)-(0.015 * hoursCalc);
        BACvalue = (double) Math.round(BACvalue * 100) / 100;

        //return result
        return BACvalue;
    }

    /**
     * determines if it is legal to drive
     * @param calculatedBAC
     * @return
     */
    public static int legalLimit(double calculatedBAC)
    {
        if(calculatedBAC > legalTexasBAC)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}