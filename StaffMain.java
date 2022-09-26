package com.gl.cadeStudy1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaffMain {
	public static Double totalCalculation(Applicant applicant)
	{
		double total;
		if(applicant.getSubject1Mark()<50 || applicant.getSubject2Mark()<50 || applicant.getSubject3Mark()<50)
		{
			total=0;
			
		}
		else
		{
			total=applicant.getSubject1Mark()+applicant.getSubject2Mark()+applicant.getSubject3Mark();
		}
		return total;
		
	}
	 public static Double percentageCalculation (Double total) {
		 double percentage=(total/300)*100;
		 
		 return  percentage ; 
	 }

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of applicants:");
		List<Applicant> AppList=new ArrayList<Applicant>();
		int n=Integer.parseInt(sc.nextLine());
		for(int i=1;i<=n;i++) {
			System.out.println("Enter applicant details:");
			String str=sc.nextLine();
			String[] stg=str.split(",");
			int id=100+i;
			Double sbj1=Double.parseDouble(stg[1]);
			Double sbj2=Double.parseDouble(stg[2]);
			Double sbj3=Double.parseDouble(stg[3]);
			Applicant app=new Applicant();
			app.setId(id);
			app.setName(stg[0]);
			app.setSubject1Mark(sbj1);
			app.setSubject2Mark(sbj2);
			app.setSubject3Mark(sbj3);
			try {
			if(sbj1<0 || sbj1>100 || sbj2<0 || sbj2>100 || sbj3<0 || sbj3>100)
				throw new MarksException("Subject marks were less than zero or greater than 100");
			}
			catch (MarksException me)
			{
				me.getMessage();
			}
			Double total=totalCalculation(app);
			if(total!=0) {
			Double percentage=percentageCalculation (total);
			app.setTotal(total);
			app.setPercentage(percentage);
			AppList.add(app);}
			
		}
		AppList.forEach((value)->System.out.println(value));
	}

}
