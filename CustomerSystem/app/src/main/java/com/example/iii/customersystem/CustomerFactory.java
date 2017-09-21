package com.example.iii.customersystem;

import java.util.ArrayList;
import java.util.List;



public class CustomerFactory {
    private ArrayList<Customer> list_customer;
    private int index;

    public CustomerFactory(){
        loadData();
    }

    private void loadData() {
        list_customer = new ArrayList<Customer>();
        list_customer.add(new Customer("Peter00", "pete00", "01", "00@gmail.com", "基隆"));
        list_customer.add(new Customer("Peter01", "pete01", "11", "01@gmail.com", "台北"));
        list_customer.add(new Customer("Peter02", "pete02", "21", "02@gmail.com", "新北"));
        list_customer.add(new Customer("Peter03", "pete03", "31", "03@gmail.com", "新竹"));
        list_customer.add(new Customer("Peter04", "pete04", "41", "04@gmail.com", "桃園"));
        list_customer.add(new Customer("Peter05", "pete05", "51", "05@gmail.com", "苗栗"));
    }

    public void moveToFirst(){
        index = 0;
    }

    public void moveToNext(){
        index++;

        if(index > (list_customer.size() - 1))
            index = (list_customer.size() - 1);
    }

    public void moveToPrevious(){
        index--;

        if(index < 0)
            index = 0;
    }

    public void moveToLast(){
        index = list_customer.size() - 1;
    }

    public void moveTo(int to){
        index = to;
    }

    public Customer customerData(){
        return list_customer.get(index);
    }

    public Customer[] allData(){
        return list_customer.toArray(new Customer[list_customer.size() - 1]);
    }
}
