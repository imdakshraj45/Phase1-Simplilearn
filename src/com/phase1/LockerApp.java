package com.phase1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LockerApp {
	
	static File fileObj = new File("D:\\Java\\Phase 1\\src\\com\\phase1.database.txt");
	
	static File fileRObj = new File("D:\\Java\\Phase 1\\src\\com\\register.txt");
	
	Scanner sc = new Scanner(System.in);
	
	private String username;
	private String pswd;
	
	FileInputStream fin = null;

	private Scanner keyboard;
	
	public void register(File file) 
	{
		//REgistration 
		System.out.println("**************************");
		System.out.println("|  LOCKER REGISTRATION	  |");
		System.out.println("**************************");
		System.out.println("");
		
		//Enter Username and password
		System.out.print("Username: ");
		username = sc.nextLine();
		System.out.print("Password: ");
		pswd = sc.nextLine();
		System.out.print("***Registered Successfully!***");	
		
		
		//Store Register data in locker.txt file
		FileWriter fw2;
		try {
			fw2 = new FileWriter(fileRObj,true);
			BufferedWriter bw2 = new BufferedWriter(fw2);
			bw2.write(username);
			bw2.write("\n");
			bw2.write(pswd);
			bw2.write("\n");
			bw2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void register(File file) 
	{
		//REgistration 
		System.out.println("**************************");
		System.out.println("|  LOCKER REGISTRATION	  |");
		System.out.println("**************************");
		System.out.println("");
		
		//Enter Username and password
		System.out.print("Username: ");
		username = sc.nextLine();
		System.out.print("Password: ");
		pswd = sc.nextLine();
		System.out.print("***Registered Successfully!***");	
		
		
		//Store Register data in locker.txt file
		FileWriter fw2;
		try {
			fw2 = new FileWriter(fileRObj,true);
			BufferedWriter bw2 = new BufferedWriter(fw2);
			bw2.write(username);
			bw2.write("\n");
			bw2.write(pswd);
			bw2.write("\n");
			bw2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	}

	private void loginPage(File file) throws IOException {
		//Login page
		System.out.println("=================");
		System.out.println("|  WELCOME	|");
		System.out.println("|   LOGIN 	|");
		System.out.println("|   PAGE 	|");
		System.out.println("+++++++++++++++++");
		System.out.println();
		
		//option of LOgin page
		System.out.println("1. Fetch all data Store in Database");
		System.out.println("2. Store crendential in Database");
		
		int ch = sc.nextInt();
		//switch case for options
		switch(ch)
		{
		case 1: fetchData(file);
				break;
				
		case 2: storeData(file);
				break;
				
		default: 
			System.out.println("Please enter valid option! ");
		}
	}

	private void storeData(File file) throws IOException {
		
		//Store credential enter by user in database.txt file
		System.out.println("*****************************");
		System.out.println("|     STORE CREDENTIALS	    |");
		System.out.println("*****************************");
		
		System.out.println("Site Name: ");
		sc.nextLine();
		String site =sc.nextLine();
		
		System.out.println("Username: ");
		String user = sc.nextLine();
		
		System.out.println("Password");
		String password = sc.nextLine();
		
		try {
			FileWriter fw = new FileWriter(fileObj,true);
			BufferedWriter br = new BufferedWriter(fw);
			br.write("Site: "+site);
			br.write("\n");
			br.write("Username: "+user);
			br.write("\n");
			br.write("Password: "+password);
			br.write("\n");
			br.close();
			System.out.println("Updated Success!");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	private void fetchData(File file) throws IOException {
		System.out.println("*****************************");
		System.out.println("|     FETCH CREDENTIALS	    |");
		System.out.println("*****************************");
		
		//fetching credentials from database.txt file
		try {
			fin = new FileInputStream(file);
			int i=0;
			while((i=fin.read()) != -1) {
				System.out.print((char)i);
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) throws IOException {
		
		LockerApp lock1 = new LockerApp();
		
		
		System.out.println("==========================================");
		System.out.println("|                                         |");
		System.out.println("|             WELCOME   	          |");
		System.out.println("|       LOCKME DIGITAL LOCKER             |");
		System.out.println("==========================================");
		System.out.println();
		System.out.println("1. Registration. Don't have an account?");
		System.out.println("2. Login");
		
		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();
		
		switch(ch)
		{
		case 1: lock1.register(fileObj);
				break;
				
		case 2: lock1.login(fileObj);
				break;
				
		default:	
				System.out.println("Enter Valid option !");
		}
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
}
