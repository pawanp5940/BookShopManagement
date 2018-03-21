import java.io.*;

class Write
{

	String bname,cname,date,mobno;
	double cost;
	
	
	/*cname=Customer name,
	  bname=Book name
	  mobno=mobile no
	*/
	 public void getData()throws IOException
	{
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader stdin =new BufferedReader(isr);
		System.out.print("Enter the name of the customer:");
		cname=stdin.readLine();
		System.out.println();
		System.out.print("Enter the name of the book:");
		bname=stdin.readLine();
		System.out.println();
		System.out.print("Enter the cost of the book:");
		cost=Double.parseDouble(stdin.readLine());
		System.out.println();
		System.out.print("Enter date(dd/mm/yy):");
		date=stdin.readLine();
		System.out.println();
		System.out.print("Enter the mobile no of the customer:");
		mobno=stdin.readLine();
		System.out.println("\\n\n");
		
	}
	public void writeFile()throws IOException
	{
		
		
		FileWriter f1=new FileWriter("E:/java programs/project3.txt",true);
		BufferedWriter bf=new BufferedWriter(f1);
		
		
			
		bf.write("\n"+cname+"\t\t"+bname+"\t\t"+cost+"\t"+date+"\t\t"+mobno+"\n");
	
	    
		
		bf.close();
	}
	
	public void writeFile1()throws IOException
	{
		
		
		FileWriter f1=new FileWriter("E:/java programs/project3.txt",true);
		BufferedWriter bf=new BufferedWriter(f1);
		
		
			
		bf.write("Name\t\tbook name\t\tPrice\t\t\tdd/mm/yy\t\t\tMobile.no\n");
		bf.write("----------------------------------------------------------------------\n\n");
	
	    
		
		bf.close();
	}
	
}

class Reading
{
	public void readFile()throws IOException
	{
		String s1;
		FileReader f1=new FileReader("project3.txt");
		BufferedReader bf=new BufferedReader(f1);
		while((s1=bf.readLine())!=null)
		{	
			System.out.println(s1);
		}
		bf.close();
		
	}
	
	
	
	//THIS METHOD SEARCHES THE BOOK PURCHASED ON THE SPECIFIC DATE
	public void readFile2()throws IOException
	{
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader stdin =new BufferedReader(isr);
		
		String s1,s2;
	
		
		boolean x=false;
		int count=0;
		
		
		
		
		FileReader f1=new FileReader("project3.txt");
		BufferedReader bf=new BufferedReader(f1,50);
		System.out.println("Enter the date :");
		s2=stdin.readLine();
		
		while((s1=bf.readLine())!=null)
		{
			x=s1.contains(s2);
			if(x==true)
			{
			System.out.println(s1);
			count++;
			}
		
		}
		if(count==0)
			System.out.println("Sorry,NO BOOK WAS PURCHASED ON THIS DAY");
		
		bf.close();
	
}

//THIS METHOD SEARCHES IF THE BOOK IS AVAILABLE IN THE STOCK
	public void searchBook()throws IOException
	{
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader stdin =new BufferedReader(isr);
		
		String s1,s2;
	
		
		boolean x=false;
		int count=0;
		
		
		
		
		FileReader f1=new FileReader("Books.txt");
		BufferedReader bf=new BufferedReader(f1,50);
		System.out.println("Enter the name of the book :");
		s2=stdin.readLine();
		s2=s2.toUpperCase();
		
		while((s1=bf.readLine())!=null)
		{
			x=s1.contains(s2);
			if(x==true)
			{
			System.out.println("This book is available in the stock");
			count++;
			}
		
		}
		if(count==0)
			System.out.println("Sorry,This book is not available !!");
		
		bf.close();
	
}


//ONLY IF THE BOOK IS NOT AVAILABLE IN THE BOOK,THIS METHOD WILL ADD THE BOOK IN THE STOCK
	public void addBook()throws IOException
	{
		
		FileWriter f2=new FileWriter("E:/java programs/Books.txt",true);
		BufferedWriter bfa=new BufferedWriter(f2);
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader stdin =new BufferedReader(isr);
		
		String s1,s2;
	
		
		boolean x=false;
		int count=0;
		
		
		
		
		FileReader f1=new FileReader("Books.txt");
		BufferedReader bf=new BufferedReader(f1,50);
		System.out.println("Enter the name of the book :");
		s2=stdin.readLine();
		s2=s2.toUpperCase();
		
		while((s1=bf.readLine())!=null)
		{
			x=s1.contains(s2);
			if(x==true)
			{
			System.out.println("Sorry,This book is already available in the stock");
			count++;
			}
		
		}
		if(count==0)
			bfa.write("\n"+s2);
		
		bf.close();
		bfa.close();
	
}
	
	public void displayBook()throws IOException
	{
		String s1;
		FileReader f1=new FileReader("Books.txt");
		BufferedReader bf=new BufferedReader(f1);
		while((s1=bf.readLine())!=null)
		{	
			System.out.println(s1);
		}
		bf.close();
		
	}
	
	
	

}


	
/*three methods in class Bill are created to write in file 
1.it will print name of the customer and date on which the book was purchased 
2 to pass data book name and price of the book and that method is called within the for loop 
3. to print the total price of the all the  books purchased*/

class Bill
{
	String cuname,bookname,date;
	int n;
	int total=0;
	int i;
	int[]a=new int[10];
	
	void getDetails()throws IOException
	{
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader stdin =new BufferedReader(isr);
		System.out.print("Enter the name of the customer:");
		cuname=stdin.readLine();
		System.out.println();
		System.out.print("Enter the date(dd/mm/yy):");
		date=stdin.readLine();
		System.out.print("Enter the no of books purchased:");
		n=Integer.parseInt(stdin.readLine());
		printBill2(cuname,date);
		
		for(i=0;i<n;i++)
		{
			System.out.print("Enter the name of book:");
			bookname=stdin.readLine();
			System.out.println();
			System.out.print("Enter the price of the book :");
			a[i]=Integer.parseInt(stdin.readLine());
			printBill(bookname,a[i]);
			total+=a[i];
			
			System.out.println();
		}
		printBill3(total);
		
	}
	public void printBill(String bookname,int a)throws IOException
	{
		
		FileWriter f1=new FileWriter("E:/java programs/Bill.txt",true);
		BufferedWriter bf=new BufferedWriter(f1);
		
		
			
		bf.write("\n"+bookname+"\t\t\t\t"+a);
	
	    
		
		bf.close();
	}
	public void printBill2(String cuname,String date)throws IOException
	{
		FileWriter f1=new FileWriter("E:/java programs/Bill.txt");
		BufferedWriter bf=new BufferedWriter(f1);
		
		
			
		bf.write("\nName:"+cuname+"\nDate:"+date);
		bf.write("\nBookname\t\t\tPrice");
	
	    
		
		bf.close();
	}
	
	public void printBill3(int total)throws IOException
	{
		FileWriter f1=new FileWriter("E:/java programs/Bill.txt",true);
		BufferedWriter bf=new BufferedWriter(f1);
		
		
		bf.write("\n---------------------------------------------------------");	
		bf.write("\nTOTAL:\t\t\t\t"+total);
		
	
	    
		
		bf.close();
	}
}


class ProjectMain3{

	public static void main(String args[])throws IOException
	{
		
		
		String x;
		String y="no";
		boolean z;
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader stdin =new BufferedReader(isr);
		Write w=new Write();
		Reading r=new Reading();
		Bill b=new Bill();
		FileWriter f1=new FileWriter("E:/java programs/project3.txt",true);
		BufferedWriter bf=new BufferedWriter(f1);
		
		
		
		
		int choice;
		
	
		
		do
		{
			System.out.println("\n\n\t***WELCOME TO THE BOOKSHOP MANAGEMENT SYSTEM***\t\t");
			System.out.println("\t\tPRESS(1) TO CREATE ENTRY FOR BOOK\t\t");
			System.out.println("\t\tPRESS(2) TO DISPLAY RECORDS\t\t");
			System.out.println("\t\tPRESS(3) TO CREATE BILL\t\t");
			System.out.println("\t\tPRESS(4) TO DISPLAY THE BOOK PURCHASED ON SPECIFIC DATE");
			System.out.println("\t\tPRESS(5) TO DISPLAY IF THE BOOK IS AVAILABLE IN THE STOCK");
			System.out.println("\t\tPRESS(6) TO ADD THE BOOK IN THE STOCK");
			System.out.println("\t\tPRESS(7) TO DISPLAY THE BOOKS AVAILABLE IN THE BOOK");
			System.out.println("\t\tPRESS(8) EXIT\t\t");
		    System.out.print("\n\nEnter your choice:");
			choice=Integer.parseInt(stdin.readLine());
			System.out.println();
			switch(choice)
			{
				case 1:System.out.print("Do you want to append the entry into the existing file ?(yes or no)");
						x=stdin.readLine();
						
						z=x.equalsIgnoreCase(y);
						if(z==true)
						{
							w.writeFile1();
							w.getData();
							w.writeFile();
							System.out.println("Record Successfully stored");
						}
						else
						{
							w.getData();
							w.writeFile();
							System.out.println("Record Successfully stored");
						}
						break;
				case 2: r.readFile();
						break;
				case 3: b.getDetails();
						break;
				
				case 4: r.readFile2();
						break;
						
				case 5:r.searchBook();
						break;
				case 6:r.addBook();
						break;
				case 7:r.displayBook();
						break;
				
				case 8:break;
				default:System.out.println("Invalid choice");
						break;
			}
			
		}while(choice!=8);
	
	}

}