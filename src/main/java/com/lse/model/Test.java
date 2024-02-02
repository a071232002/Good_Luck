package com.lse.model;

public class Test {

	
	public static void main(String[] args) { 
		String dataORI_lsePayAccount = "005 – 土地銀行 123-456-789";

        // Split the string based on one or more whitespace characters
        String[] parts = dataORI_lsePayAccount.split("\\s+");

        // Check if there are enough parts
     
            // Join the first two parts to get the bank
            String bank = parts[0] + " " + parts[1]+  " " + parts[2];

            // The rest of the parts make up the account
            String account = parts[3];

            System.out.println("Bank: " + bank);
            System.out.println("Account: " + account);

	
}
}
