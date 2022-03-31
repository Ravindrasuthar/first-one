package Project_Phase1;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		while(true) {
		 System.out.println("********Enter the number given below to perform operation********");
	     System.out.println("1.Retrive files from the menu");
	     System.out.println("2.Business level operations like : Add,Delete,Search");
	     System.out.println("3.Exit from the applicatin");
	     Scanner s = new Scanner(System.in);
	     int a = s.nextInt();
	     String path="E:\\Project\\";
	     switch(a) {
	     case 1 :    
	                 File f=new File(path);
	                 File filename[]=f.listFiles();
	                 for(File ff:filename) {
	     	         System.out.println(ff.getName());
	                 }
	                break;
	                 
	     case 2 :    int counter = 0;
	    	         while(counter == 0) {
	    	         System.out.println("****Enter the number given below to perform business operation****");
	    	         System.out.println("1.Add file to the menu");
	                 System.out.println("2.Delete file from the menu");
	                 System.out.println("3.Search file from the menu");
	                 System.out.println("4.Go to main menu");
	                 int n = s.nextInt();
	                 
	                 switch(n) {
	                 
	                 case 1 : 
	                          

          	                  ArrayList<String> al=new ArrayList<>();
                               char t = 'Y';
 	                           while(t == 'Y'){
	                          System.out.println("enter the file name to create");
	                          String filename1=s.next();
	                          String finalname=path+filename1;
	                          System.out.println(finalname);

	                          //create a file 

	                          File f1=new File(finalname);
	                          boolean b=f1.createNewFile();
	                          if(b!=true) {
	                 	                   System.out.println("the file not created");
	                                      }
	                          else {
	                 	      al.add(filename1);
	                 	      System.out.println("file created");
	                               }

	                          System.out.println("the collection of files is "+ al);
	                          System.out.println("want to add more file press Y or N");
	                          char p = s.next().charAt(0);
	                          if(p == 'N')
	                          {
	                          	t = 'N';
	                          }
	                          else
	                          	break;
	                          
	                               }
 	                           continue;
 	                          
 	                         
	                  case 2 : System.out.println("enter the file name to be deleted");
	                           String filname=s.next();
	                           String finalfile=path+filname;
	                           File file=new File(finalfile);
	                           file.delete();
	                           System.out.println("file deleted");
	                           
	                           continue;
	                           
	                  case 3 : File f2=new File(path);
	                           Scanner sc=new Scanner(System.in);
	                           System.out.println("enter the file name to search");
	                           String filsearchname=sc.next();
	                           File filename2[]=f2.listFiles();
	                           int flag=0;
	                           for(File ff:filename2) {
	                  	        if(ff.getName().equals(filsearchname)) {
	                  		        flag=1;
	                  		        break;
	                  	       }
	                  	       else {
	                  		        flag=0;
	                  	       }
	                  	
	                  	
	                  	
	                           }

	                           if(flag==1) {
	                  	            System.out.println("found the file");
	                           }
	                           else {
	                  	            System.out.println("file is not found");
	                                }
	                           continue;
	                           
	                  case 4 :  counter = 1;
	                	        break;
	        
	                               }
	                          
	     }
	     break;
	
	     case 3 : System.out.println("Thank you for using the application");
	    	      System.exit(0);
	              break;

}
}		
}	
}