
public class Siyah {
	
	int siyahpiyontehditsayisi=0,siyahfiltehditsayisi=0,siyahattehditsayisi=0,kaletehditsayisi=0;
	int siyahvezirtehditsayisi=0,siyahsahtehditsayisi=0;
	 int piyon=0,at=0,kale=0,fil=0,vezir=0,sah;

	public void skor()
	{
		double skor=(siyahpiyontehditsayisi*0.5)+(piyon-siyahpiyontehditsayisi);
	 	skor+=(siyahfiltehditsayisi*1.5)+(fil-siyahfiltehditsayisi)*3;
	 	skor+=(siyahattehditsayisi*1.5)+(at-siyahattehditsayisi)*3;
	 	skor+=kaletehditsayisi*2.5+(kale-kaletehditsayisi)*5;
	 	skor+=siyahvezirtehditsayisi*4.5+(vezir-siyahvezirtehditsayisi)*9;
	 	skor+=siyahsahtehditsayisi*50+(sah-siyahsahtehditsayisi)*100;
	 	
	    System.out.println("Siyah: "+ skor);
				
	}
	public void yazdir(String board[][])
	{
		for(int i=0;i<8;i++) {
    		for(int j=0;j<8;j++)
    		{
    			if(board[i][j].equalsIgnoreCase("fs"))
    			{
    				fil++;
    			}
    			if(board[i][j].equalsIgnoreCase("ps"))
    			{
    				piyon++;
    			}
    			if(board[i][j].equalsIgnoreCase("as"))
    			{
    				at++;
    			}
    			if(board[i][j].equalsIgnoreCase("vs"))
    			{
    				vezir++;
    			}
    			if(board[i][j].equalsIgnoreCase("ss"))
    			{
    				sah++;
    			}
    			if(board[i][j].equalsIgnoreCase("ks"))
    			{
    				kale++;
    			}
    			
    		}}	
	}
	
    public void FilTehditKontrol(String board[][])
    {
    	/**/
    	int x=0;
    	int y=0;
    	for(int i=0;i<8;i++) 
    	{
    		for(int j=0;j<8;j++)
    		{
    			if(board[i][j].equalsIgnoreCase("fb"))
    			{
    				x=i;
    				y=j;
    				while(x>0 && y>0)//sol ust capraz deneme
    				{
    				 
    					karsilastirici(x-1,y-1,board);
    					if(board[x-1][y-1].charAt(1)=='s') {
    						//System.out.println("board member is "+ board[x][y]+" x is "+ x + " y is "+y);
    						break;
    						
    					}
    					x--;
    					y--;
    			
    				}
    				x=i;
    				y=j;
    				while(x<7 && y>0)//sol alt capraz deneme
    				{
    					karsilastirici(x+1,y-1,board);
    					if(board[x+1][y-1].charAt(1)=='s') {
    					//	System.out.println("second while");
    					//	System.out.println("board member is "+ board[x][y]+" x is "+ x + " y is "+y);
    						break;
    						
    					}
    					x++;
    					y--;
    				}
    				x=i;
    				y=j;
    				while(x>0 && y<7)//sag ust capraz deneme
    				{
    				    
    					karsilastirici(x-1,y+1,board);
    					if(board[x][y].charAt(1)=='s') {
    					//	System.out.println("third while");
    					//	System.out.println("board member is "+ board[x][y]+" x is "+ x + " y is "+y);
    						break;
    						
    					}
    					x--;
    					y++;
    				}
    				x=i;
    				y=j;
    				while(x<7 && y<7)//sag alt capraz deneme
    				{

    					karsilastirici(x+1,y+1,board);
    					if(board[x+1][y+1].charAt(1)=='s') {
    					
    					//	System.out.println("board member is "+ board[x][y]+" x is "+ x + " y is "+y);
    						break;
    					}
    					x++;
    					y++;
    				}
    				
    				
    			}
    			
    		}
    	}		
    	
    	
    }
    public void karsilastirici(int i,int j,String board[][])
    {
    	if(board[i][j].equalsIgnoreCase("ps"))
    	{
    		siyahpiyontehditsayisi++;
    		
    		
    	}
    	if(board[i][j].equalsIgnoreCase("vs"))
    	{
    		siyahvezirtehditsayisi++;
    	}
    	if(board[i][j].equalsIgnoreCase("as"))
    	{
    		siyahattehditsayisi++;
    	}
    	if(board[i][j].equalsIgnoreCase("fs"))
    	{
    		siyahfiltehditsayisi++;
    	}
    	if(board[i][j].equalsIgnoreCase("ss"))
    	{
    		siyahsahtehditsayisi++;
    	}
    	if(board[i][j].equalsIgnoreCase("ks"))
    	{
    		kaletehditsayisi++;
    	}
    	
    }
    public void AtTehditKontrol(String board[][])
    {
   
    	for(int i=0;i<8;i++) { //bu for tahtadaki satýrlarý gezer
    		for(int j=0;j<8;j++) //bu tahtadaki sutunlarý gezer
    		{
    			if(board[i][j].equalsIgnoreCase("ab"))
    			{
    				if(i>=1 && j>=2 && board[i-1][j-2].charAt(1)=='s')
    				{
    					karsilastirici(i-1,j-2,board);
    				
    				
    				}
    				if(j>=2 && i<7 && board[i+1][j-2].charAt(1)=='s')
    				{	
    					karsilastirici(i+1,j-2,board);
    			    
    				}
    				if(i<7 && j>=2 &&  board[i+1][j-2].charAt(1)=='s')
    				{
    					karsilastirici(i-2,j-1,board);
    			
    				}
    				if(i>=2 && j<7 && board[i-2][j+1].charAt(1)=='s')
    				{
    					karsilastirici(i-2,j+1,board);
    			        
    				}
    				
    				//x2 üst y 1 üsy
    				if(i>=2 && j>1 && board[i-2][j-1].charAt(1)=='s')
    				{
    					karsilastirici(i-2,j-1,board);
    			        
    				}
    				if(j>=1 && i<6 &&  board[i+2][j-1].charAt(1)=='s')
    				{

    					karsilastirici(i+2,j-1,board);
    		
    				}
    				if(i<6 && j>=1 && board[i+2][j-1].charAt(1)=='s')
    				{
    					karsilastirici(i+2,j-1,board);
    			
    				}
    				
    				if(i>=1 && j<6 && board[i-1][j+2].charAt(1)=='s')
    				{
    					karsilastirici(i-1,j+2,board);
    			        board[i-1][j+2]="xx";
    				}
    				if(i<7 && j<6 && board[i+1][j+2].charAt(1)=='s')
    				{
    					karsilastirici(i+1,j+2,board);
    				
    				}
    			}
    		}
    	}
    	
    	
    }
    
    
}
