package application.mainapp;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

interface Savings{
	final double limit=10000, minlimit = 200;
	double deposit(double n, Date d);
	double withdraw(double n, Date d);
}

public class CustomerData implements Savings{
	
	String uname, pass, name, address, phone;
	double balance;
	ArrayList<String> transactions;
	
	public CustomerData(String uname, String pass, String name, String address, String phone, double balance, Date date) {
		
		this.uname = uname;
		this.pass = pass;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.balance = balance;
		transactions = new ArrayList<String>(5);
		addTransaction(String.format("Initial deposit - " +NumberFormat.getCurrencyInstance(new Locale("en","IN")).format(balance)+" as on "+"%1$tD"+" at "+"%1$tT.",date));

	}

	@Override
	public double deposit(double amount, Date date) {
		balance+=amount;
		addTransaction(String.format(NumberFormat.getCurrencyInstance(new Locale("en","IN")).format(amount)+" credited to your account. Balance - " +NumberFormat.getCurrencyInstance(new Locale("en","IN")).format(balance)+" as on " + "%1$tD"+" at "+"%1$tT.",date));
		return balance;
	}

	@Override
	public double withdraw(double amount, Date date) {
		if(amount>(balance-200)) {
			return 0; 
		}else {
			balance -= amount;
			addTransaction(String.format(NumberFormat.getCurrencyInstance(new Locale("en","IN")).format(amount)+" debited from your account. Balance - " +NumberFormat.getCurrencyInstance(new Locale("en","IN")).format(balance)+" as on " + "%1$tD"+" at "+"%1$tT.",date));
			return balance;
		}
		
	}
	
	private void addTransaction(String message) {
		transactions.add(0,message);
		if(transactions.size()>5) {
			transactions.remove(5);
			transactions.trimToSize();
		}	
	}
}
