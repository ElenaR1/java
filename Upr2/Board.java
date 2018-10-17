import java.util.Random;
import java.util.Scanner;

public class Board {
    private int[][] mines;
    private char[][] boardgame;
    private int Line, Column;
    Random random = new Random();
    Scanner input = new Scanner(System.in);
    
    public Board (){
        mines = new int[10][10];
        boardgame = new char[10][10];
        startMines();
        randomMines();
        fillTips();
        startBoard();
        
    }
    //if count==10 t.k imame 10 mini
    public boolean win(){
        int count=0;
        for(int line = 1 ; line < 9 ; line++)
            for(int column = 1 ; column < 9 ; column++)
                if(boardgame[line][column]=='_')
                    count++;
        if(count == 10)
            return true;
        else
            return false;                
    }
    //Line i Col sa dostupni oshte ot kakto sme gi vkarali v setPosition  ?? 
    //otvarqme susedite na mines[line][col]
    public void openNeighbors(){
        for(int i=-1 ; i<2 ; i++)
            for(int j=-1 ; j<2 ; j++)
                if( (mines[Line+i][Column+j] != -1) && (Line != 0 && Line != 9 && Column != 0 && Column != 9) )
                    boardgame[Line+i][Column+j]=Character.forDigit(mines[Line+i][Column+j], 10);
        
    }
    
    public int getPosition(int Line, int Column){
        return mines[Line][Column];
    }
    
    public boolean setPosition(){
            
            do{
                System.out.print("\nLine: "); 
                Line = input.nextInt();
                System.out.print("Column: "); 
                Column = input.nextInt();
                
                if( (boardgame[Line][Column] != '_') && ((Line < 9 && Line > 0) && (Column < 9 && Column > 0)))
                    System.out.println("Field already shown");
                
                if( Line < 1 || Line > 8 || Column < 1 || Column > 8)
                    System.out.println("Choose a number between 1 and 8");
                
            }while((Line < 1 || Line > 8 || Column < 1 || Column > 8) || (boardgame[Line][Column] != '_') );
            //ako  e true znachi che imame nqkakv stoinost za kletkata >0 t.e ne e bomba t.k bombata e
            //sus stoinost -1
            if(getPosition(Line, Column)== -1)
                return true;
            else
                return false;
            
    }
    
    public void show(){
        System.out.println("\n     Lines");
        for(int Line = 8 ; Line > 0 ; Line--){
            System.out.print("       "+Line + " ");
            
            for(int Column = 1 ; Column < 9 ; Column++){
                    System.out.print("   "+ boardgame[Line][Column]);
            }
                
            System.out.println();
        }
            
        System.out.println("\n            1   2   3   4   5   6   7   8");
        System.out.println("                      Columns");
        
    }
    
    public void fillTips(){
        for(int line=1 ; line < 9 ; line++)
            for(int column=1 ; column < 9 ; column++){
                
                    for(int i=-1 ; i<=1 ; i++)
                        for(int j=-1 ; j<=1 ; j++)
                            if(mines[line][column] != -1)
                                if(mines[line+i][column+j] == -1)
                                    mines[line][column]++;
                
            }
            
    }
    
    public void showMines(){
        for(int i=1 ; i < 9; i++)
            for(int j=1 ; j < 9 ; j++)
                if(mines[i][j] == -1)
                    boardgame[i][j]='*';
        
        show();
     }
    //boardgame si e drug masiv ot char-ove
    public void startBoard(){
        for(int i=1 ; i<mines.length ; i++)
            for(int j=1 ; j<mines.length ; j++)
                boardgame[i][j]= '_';
    }
    
    public void startMines(){
        for(int i=0 ; i<mines.length ; i++)
            for(int j=0 ; j<mines.length ; j++)
                mines[i][j]=0;
    }
    
    public void randomMines(){
        boolean raffled;
        int Line, Column;
        for(int i=0 ; i<10 ; i++){
            
            do{
                Line = random.nextInt(8) + 1;//random.nextInt(8) returns a value between 0 and 8 t.e ot 0 do 7 vkljuchitelno
                Column = random.nextInt(8) + 1;
                
                if(mines[Line][Column] == -1)//ao veche sme go set-nali da e =-1
                    raffled=true; 
                else
                    raffled = false;
            }while(raffled);
            
            mines[Line][Column] = -1;
        }
    }
}
