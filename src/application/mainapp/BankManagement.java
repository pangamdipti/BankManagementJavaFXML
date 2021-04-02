package application.mainapp;

import java.text.NumberFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class BankManagement {

	static CustomerData customer;
	static String uname, pass;
	static double amount;
	static double balance;
	static BankManagement bank = new BankManagement();

	Map<String, CustomerData> customerMap;

	BankManagement() {
		customerMap = new HashMap<String, CustomerData>();
	}

	public static String loginUser(String uname, String pass) {
		if (bank.customerMap.containsKey(uname)) {
			customer = bank.customerMap.get(uname);
			if (customer.pass.equals(pass)) {
				System.out.println("Username and password matched");
			} else {
				return "0";
			}
		} else {
			return "1";
		}
		return "2";
	}

	public static String registerUser(String name, String address, String phone, String uname, String pass,
			String iDeposit) {
		double amount = Double.parseDouble(iDeposit);

		if (bank.customerMap.containsKey(uname)) {
			return "0";
		}

		else if (!pass.matches((("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{8,}")))) {
			return "1";
		}

		customer = new CustomerData(uname, pass, name, address, phone, amount, new Date());
		bank.customerMap.put(uname, customer);
		return "2";
	}

	public static String depositAmount(String depositAmount) {
		double amount = Double.parseDouble(depositAmount);
		balance = customer.deposit(amount, new Date());
		return (String.format(
				"Updated Balance is : " + NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(balance)));
	}

	public static String transfer(String uname, String transferAmount) {
		double amount = Double.parseDouble(transferAmount);
		if (bank.customerMap.containsKey(uname)) {
			CustomerData payee = bank.customerMap.get(uname);
				payee.deposit(amount, new Date());
				balance = customer.withdraw(amount, new Date());
				if(balance==0) {
					return "1";
				}
		} else {
			return "0";
		}
		return (String.format(
				"Updated Balance is : " + NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(balance)));
	}

	public static String lastTransactions() {
		String trans = "\n";
		for (String transactions : customer.transactions) {
			trans = trans + "\n" + transactions;
		}
		return trans;

	}

	public static String details() {

		return ("\nAccount Holder Name: " + customer.name + "\nAccount Hoder Address: " + customer.address
				+ "\nAccount Holder Contact: " + customer.phone + "\n Balance: " + customer.balance);
	}

	public static String changePass(String newPass) {
		if (!newPass.matches((("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{8,}"))))
			return "1";

		else {
			customer.pass = newPass;
			return "2";
		}
	}

	public static void changeAdd(String addr) {
		customer.address = addr;

	}

	public static void changePho(String phone) {
		customer.phone = phone;
	}

}
