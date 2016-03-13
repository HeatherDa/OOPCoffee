package com.Heather;
import java.util.*;
import java.io.*;
public class DrinkManager {

    public static void main(String[] args) throws IOException {
	// write your code here
        Scanner scan=new Scanner (System.in);
        Double totcost=0.0;
        Double totprice=0.0;
        Double totprofit=0.0;
        ArrayList<Drink> drinks = new ArrayList<>();

        System.out.println("What is the name of the file?");
        String filename=scan.nextLine();
        //write(filename);
        try {
            drinks = readfile(filename);//read in information and create drinks
            for (Drink d:drinks) {//add information to each drink
                d.setSold(d.getName());
                d.setProfit();
                totcost=totcost+d.getCost();
                totprice=totprice+d.getPrice();
                totprofit=totprofit+d.getProfit();
                //d.writeProfits();
            }
            System.out.println("An itemized list of total transactions for the day follows:\n");
            for(Drink a:drinks){
                a.writeProfits();
            }
            System.out.format("\nTotals for today: Expenses $%.2f, Revenue $%.2f, Profit$%.2f", totcost, totprice, totprofit);//print totals
        }catch(FileNotFoundException fnf){
            System.out.println("Reader cannot find the file.");
        }

    }
    public static ArrayList<Drink> readfile(String filename) throws IOException {
    //read in information, parse it, and create objects from it.  Returns Arraylist of objects
        FileReader reader = new FileReader(filename);
        BufferedReader bufReader = new BufferedReader(reader);
        String line = bufReader.readLine();
        ArrayList<Drink> drinks=new ArrayList<>();

        while (line != null) {
            String[] linetext = line.split(";");
            String drink=linetext[0];//name of beverage

            Double cost=Double.parseDouble(linetext[1]);//cost to prepare beverage
            Double price=Double.parseDouble(linetext[2]);//price to purchase beverage
            Drink a=new Drink(drink,cost,price);
            drinks.add(a);                              //keep track of Drink objects
            line = bufReader.readLine();

        }

        bufReader.close();   //This closes the inner FileReader too
        return drinks;
    }
    private static void write(String filename) throws IOException {

        FileWriter writer = new FileWriter(filename);
        BufferedWriter bufWriter = new BufferedWriter(writer);
        try {
            bufWriter.write("\n");
            bufWriter.close();
        }catch(IOException io){
            System.out.println("There was an error writing to the file "+filename+".");
        }

    }
}
