import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Main {
	
	
	public static void main(String [] args) throws IOException {
		
	   
	   Scanner scan = new Scanner(System.in);
	   ArrayList<String> arr=new ArrayList<>();
	   String [][] board = new String [8][8];
		
       File file = new File("C:\\Users\\demir\\OneDrive\\\\Desktop\\figures\\\\board2.txt");  
       Scanner sc = new Scanner(file);
       
       //n
       while (sc.hasNextLine())
       {
    	   Scanner s1 = new Scanner(sc.nextLine());
	       while (s1.hasNext()) {
	        	
	            String s = s1.next();
	            arr.add(s);
	           
	     }}
      int k=0;
      
    //n
      for(int i=0;i<8;i++)
      {
    	  for(int j=0;j<8;j++)
    	  {
    		  board[i][j]=arr.get(k++);
    	  }
      }
      
      System.out.println("Dosya adý : "+file.getName());
      Siyah siyahskor = new Siyah();
      siyahskor.AtTehditKontrol(board);
      siyahskor.FilTehditKontrol(board);
      siyahskor.yazdir(board);
      siyahskor.skor();
      
      System.out.println("---");
      Beyaz beyazskor = new Beyaz();
      beyazskor.BeyazAtTehditKontrol(board);
      beyazskor.BeyazFilTehditKontrol(board);
        beyazskor.yazdir(board);
        beyazskor.skor();
    
      
}
    
	

}
