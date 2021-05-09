
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
	
	 
	public void skor()
	{
		double skor=(beyazpiyontehditsayisi*0.5)+(8-beyazpiyontehditsayisi);
	 	skor+=(beyazfiltehditsayisi*1.5)+(2-beyazfiltehditsayisi)*3;
	 	skor+=(beyazattehditsayisi*1.5)+(2-beyazattehditsayisi)*3;
	 	skor+=beyazkaletehditsayisi*2.5+(2-beyazkaletehditsayisi)*5;
	 	skor+=beyazvezirtehditsayisi*4.5+(1-beyazvezirtehditsayisi)*9;
	 	skor+=beyazsahtehditsayisi*50+(1-beyazsahtehditsayisi)*100;
	 	
	    System.out.println("Beyaz: "+ skor);
				
	}
	public void yazdir()
	{
		System.out.println("tehdit edilen beyaz piyon sayýsý "+ beyazpiyontehditsayisi);
    	System.out.println("tehdit edilen beyaz fil sayýsý "+ beyazfiltehditsayisi);
    	System.out.println("tehdit edilen beyaz vezir sayýsý "+ beyazvezirtehditsayisi);
    	System.out.println("tehdit edilen beyaz sah sayýsý "+ beyazsahtehditsayisi);
    	System.out.println("tehdit edilen beyaz at sayýsý "+ beyazattehditsayisi);
    	System.out.println("tehdit edilen beyaz kale sayýsý "+ beyazkaletehditsayisi);
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
