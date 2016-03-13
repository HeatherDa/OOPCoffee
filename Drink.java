package com.Heather;
import java.util.*;
/**
 * Created by cryst on 3/12/2016.
 */
public class Drink {
    Scanner scandoub=new Scanner (System.in);
    private String name;
    private Double cost;
    private Double price;
    private Double sold;
    private Double profit;

    Drink(String drinkname, Double drinkcost, Double drinkprice){
        this.name=drinkname;
        this.cost=drinkcost;
        this.price=drinkprice;
        this.sold=0.0;
        this.profit=0.0;
    }

    public String getName() {
        return name;
    }

    public Double getCost() {
        return cost;
    }

    public Double getSold(){
        return this.sold;
    }

    public void setProfit(){
        Double drinkcost=getCost();
        Double drinkprice=getPrice();
        Double sprofit=drinkprice-drinkcost;
        this.profit=sprofit*getSold();

    }
    public Double getProfit(){
        return profit;
    }

    public void setSold(String drinkname){
        System.out.println("How many cups of "+drinkname+" were sold today?");
        this.sold=scandoub.nextDouble();
    }

    public Double getPrice() {
        return price;
    }

    public void writeProfits(){
        Double tcost=this.cost*this.sold;
        Double tprice=this.price*this.sold;
        System.out.format(this.name+": Sold %.0f, Expenses $%.2f, Revenue $%.2f, Profit $%.2f \n", this.sold, tcost, tprice, this.profit);

    }
}
