
public class Beyaz {
	boolean atTehdit=false;
	boolean vezirTehdit=false;
	boolean filTehdit=false;
	boolean kaleTehdit=false;
	boolean piyonTehdit=false;
	boolean sahTehdit=false;
	int skor;
	int beyazpiyontehditsayisi=0,beyazfiltehditsayisi=0,beyazattehditsayisi=0,beyazkaletehditsayisi=0;
	int beyazvezirtehditsayisi=0,beyazsahtehditsayisi=0;
	
	 int piyon=0,at=0,kale=0,fil=0,vezir=0,sah;
	public void skor()
	{
		double skor=(beyazpiyontehditsayisi*0.5)+(piyon-beyazpiyontehditsayisi);
	 	skor+=(beyazfiltehditsayisi*1.5)+(fil-beyazfiltehditsayisi)*3;
	 	skor+=(beyazattehditsayisi*1.5)+(at-beyazattehditsayisi)*3;
	 	skor+=beyazkaletehditsayisi*2.5+(kale-beyazkaletehditsayisi)*5;
	 	skor+=beyazvezirtehditsayisi*4.5+(vezir-beyazvezirtehditsayisi)*9;
	 	skor+=beyazsahtehditsayisi*50+(sah-beyazsahtehditsayisi)*100;
	 	
	    System.out.println("Beyaz: "+ skor);
				
	}
	public void yazdir(String board[][])
	{
		
		for(int i=0;i<8;i++) {
    		for(int j=0;j<8;j++)
    		{
    			if(board[i][j].equalsIgnoreCase("fb"))
    			{
    				fil++;
    			}
    			if(board[i][j].equalsIgnoreCase("pb"))
    			{
    				piyon++;
    			}
    			if(board[i][j].equalsIgnoreCase("ab"))
    			{
    				at++;
    			}
    			if(board[i][j].equalsIgnoreCase("vb"))
    			{
    				vezir++;
    			}
    			if(board[i][j].equalsIgnoreCase("sb"))
    			{
    				sah++;
    			}
    			if(board[i][j].equalsIgnoreCase("kb"))
    			{
    				kale++;
    			}
    			
    		}
        }
			}
	
    public void BeyazFilTehditKontrol(String board[][])
    {
    	int x=0;
    	int y=0;
    	for(int i=0;i<8;i++) {
    		for(int j=0;j<8;j++)
    		{
    			if(board[i][j].equalsIgnoreCase("fs")) //tehdit eden fil kontrol
    			{
    			  
    				x=i;
    				y=j;
    				while(x>0 && y>0)//sol ust capraz deneme
    				{
    				 
    					karsilastirici(x-1,y-1,board);
    					if(board[x-1][y-1].charAt(1)=='b' || board[x-1][y-1].charAt(1)=='s') {
    					//	System.out.println("board member is "+ board[x][y]+" x is "+ x + " y is "+y);
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
    					if(board[x+1][y-1].charAt(1)=='b' || board[x+1][y-1].charAt(1)=='s') {
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
    					if(board[x-1][y+1].charAt(1)=='b' || board[x-1][y+1].charAt(1)=='s') {
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
    					if(board[x+1][y+1].charAt(1)=='b' || board[x+1][y+1].charAt(1)=='s') {
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
    {//tahtadaki degerle taþlar karsýlastýrýlýp artýrýldý
    	if(board[i][j].equalsIgnoreCase("pb"))
    	{
    		beyazpiyontehditsayisi++;
    		
    	}
    	if(board[i][j].equalsIgnoreCase("vb"))
    	{
    		beyazvezirtehditsayisi++;
    	}
    	if(board[i][j].equalsIgnoreCase("ab"))
    	{
    		beyazattehditsayisi++;
    	}
    	if(board[i][j].equalsIgnoreCase("fb"))
    	{
    		beyazfiltehditsayisi++;
    	}
    	if(board[i][j].equalsIgnoreCase("sb"))
    	{
    		beyazsahtehditsayisi++;
    	}
    	if(board[i][j].equalsIgnoreCase("kb"))
    	{
    		beyazkaletehditsayisi++;
    	}
    	
    }
    public void BeyazAtTehditKontrol(String board[][])
    {
   
    	for(int i=0;i<8;i++) { //bu for tahtadaki satýrlarý gezer
    		for(int j=0;j<8;j++) //bu tahtadaki sutunlarý gezer
    		{
    			if(board[i][j].equalsIgnoreCase("as"))
    			{
    				//atýn hamlelerini kontrol ediyoruz
    			
    				if(i>=1 && j>=2 && board[i-1][j-2].charAt(1)=='b')
    				{
    					karsilastirici(i-1,j-2,board);
    				
    				
    				}
    				if(j>=2 && i<7 && board[i+1][j-2].charAt(1)=='b')
    				{	
    					karsilastirici(i+1,j-2,board);
    			    
    				}
    				if(i<7 && j>=2 &&  board[i+1][j-2].charAt(1)=='b')
    				{
    					karsilastirici(i-2,j-1,board);
    			
    				}
    				if(i>=2 && j<7 && board[i-2][j+1].charAt(1)=='b')
    				{
    					karsilastirici(i-2,j+1,board);
    			        
    				}
    				if(j>=1 && i<6 &&  board[i+2][j-1].charAt(1)=='b')
    				{
    				
    					karsilastirici(i+2,j-1,board);
    		
    				}
    				
    				if(i<6 && j<7 && board[i+2][j+1].charAt(1)=='b')
    				{
    					karsilastirici(i+2,j+1,board);
    			
    				}
    				if(i>=1 && j<6 && board[i-1][j+2].charAt(1)=='b')
    				{
    					karsilastirici(i-1,j+2,board);
    			   
    				}
    				if(i<7 && j<6 && board[i+1][j+2].charAt(1)=='b')
    				{
    					karsilastirici(i+1,j+2,board);
    				
    				}
    				if(i>=2 && j>1 && board[i-2][j-1].charAt(1)=='b')
    				{
    					karsilastirici(i-2,j-1,board);
    			        
    				}
    				
    			}
    		}
    	}
    	
    	
    }
    
    
}
