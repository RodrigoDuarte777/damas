package ProjetoDamasnovo;
import java.util.ArrayList;
import java.util.Scanner;

public class ProjetoDamasnovo {
    private static char tabela[][] = new char [8][8] ;
    
    private static void prinTabela()
    {
        for (int i=1 ; i<9 ; ++i)
        {
            System.out.print("   " + i) ;
        }
        System.out.print("\n  ") ;
        for (int i=0 ; i<8 ; ++i) 
            System.out.print("+---") ;
        System.out.print("+\n") ;
        for (int i=0 ; i<8 ; ++i) {
            System.out.print((i+1) + " ") ;
            for (int j=0 ; j<8 ; ++j){
                System.out.print("| " + tabela[i][j] + " ") ;
            }
            System.out.print("|\n  ") ;
            for (int i2=0 ; i2<8 ; ++i2) 
                System.out.print("+---") ;
            System.out.print("+\n") ;
        }
    }
    
    public static void main(String[] args)
    {
        for (int i=0 ; i<8 ; ++i) 
            for (int j=0 ; j<8 ; ++j) 
                tabela[i][j] = ' ' ;
        for (int i=0 ; i<3 ; ++i) {
            if (i%2==0) {
                for (int j=1 ; j<8 ; j+=2) 
                    tabela[i][j] = 'g' ;
            }
            else {
                for (int j=0 ; j<8 ; j+=2) 
                    tabela[i][j] = 'g' ;
            }
        }
        for (int i=7 ; i>4 ; --i) {
            if (i%2==0)
            {
                for (int j=1 ; j<8 ; j+=2) 
                    tabela[i][j] = 'r' ;
            }
            else
            {
                for (int j=0 ; j<8 ; j+=2) 
                    tabela[i][j] = 'r' ;
            }
        }
        prinTabela() ;
        int usuario = 0 ;
        Scanner in = new Scanner(System.in) ; 
        while (true)
        { 
            if (usuario==0) usuario=1 ; 
            else usuario=0 ; 
            int sw=0, once=1 , row1=0 , col1=0 ;  
            while (sw==0) 
            {
                ArrayList <Caminho> cellsMustGo = new ArrayList<>() ; 
                sw=1 ;  
                for (int i=0 ; i<8 ; ++i)
                {
                    for (int j=0 ; j<8 ; ++j)
                    {
                        if (once==0)
                        {
                            i = row1 ; 
                            j = col1 ; 
                        }
                        Cell now = new Cell(i, j) ; 
                        if (usuario==0 && tabela[i][j] == 'r')
                        {
                            if (i<6 && j>1 && (tabela[i+1][j-1]=='g' || tabela[i+1][j-1]=='G') && tabela[i+2][j-2]==' ')
                            {
                                cellsMustGo.add(new Caminho(now, new Cell(i+2 , j-2)) ) ;
                                sw=0 ; 
                            }
                            if (i<6 && j<6 && (tabela[i+1][j+1]=='g' || tabela[i+1][j+1]=='G') && tabela[i+2][j+2]==' ')
                            {
                                cellsMustGo.add(new Caminho(now, new Cell(i+2 , j+2))) ;
                                sw=0 ; 
                            }
                        }
                        else if (usuario==1 && tabela[i][j] == 'g')
                        {
                            if (i>1 && j>1 && (tabela[i-1][j-1]=='r' || tabela[i-1][j-1]=='R') && tabela[i-2][j-2]==' ')
                            {
                                cellsMustGo.add(new Caminho(now, new Cell(i-2 , j-2))) ;
                                sw=0 ; 
                            }
                            if (i>1 && j<6 && (tabela[i-1][j+1]=='r' || tabela[i-1][j+1]=='R') && tabela[i-2][j+2]==' ')
                            {
                                cellsMustGo.add(new Caminho(now, new Cell(i-2 , j+2))) ;
                                sw=0 ; 
                            }
                        }
                        else if (usuario==0 && tabela[i][j] == 'R') 
                        {
                            if (i>1 && j>1 && (tabela[i-1][j-1]=='g' || tabela[i-1][j-1]=='G') && tabela[i-2][j-2]==' ')
                            {
                                cellsMustGo.add(new Caminho(now, new Cell(i-2 , j-2))) ;
                                sw=0 ; 
                            }
                            if (i>1 && j<6 && (tabela[i-1][j+1]=='g' || tabela[i-1][j+1]=='G') && tabela[i-2][j+2]==' ')
                            {
                                cellsMustGo.add(new Caminho(now, new Cell(i-2 , j+2))) ;
                                sw=0 ; 
                            }
                            if (i<6 && j>1 && (tabela[i+1][j-1]=='g' || tabela[i+1][j-1]=='G') && tabela[i+2][j-2]==' ')
                            {
                                cellsMustGo.add(new Caminho(now, new Cell(i+2 , j-2))) ;
                                sw=0 ; 
                            }
                            if (i<6 && j<6 && (tabela[i+1][j+1]=='g' || tabela[i+1][j+1]=='G') && tabela[i+2][j+2]==' ')
                            {
                                cellsMustGo.add(new Caminho(now, new Cell(i+2 , j+2))) ;
                                sw=0 ; 
                            }
                        }
                        else if (usuario==1 && tabela[i][j] == 'G') 
                        {
                            if (i>1 && j>1 && (tabela[i-1][j-1]=='r' || tabela[i-1][j-1]=='G') && tabela[i-2][j-2]==' ')
                            {
                                cellsMustGo.add(new Caminho(now, new Cell(i-2 , j-2))) ;
                                sw=0 ; 
                            }
                            if (i>1 && j<6 && (tabela[i-1][j+1]=='r' || tabela[i-1][j+1]=='R') && tabela[i-2][j+2]==' ')
                            {
                                cellsMustGo.add(new Caminho(now, new Cell(i-2 , j+2))) ;
                                sw=0 ; 
                            }
                            if (i<6 && j>1 && (tabela[i+1][j-1]=='r' || tabela[i+1][j-1]=='R') && tabela[i+2][j-2]==' ')
                            {
                                cellsMustGo.add(new Caminho(now, new Cell(i+2 , j-2))) ;
                                sw=0 ; 
                            }
                            if (i<6 && j<6 && (tabela[i+1][j+1]=='r' || tabela[i+1][j+1]=='R') && tabela[i+2][j+2]==' ')
                            {
                                cellsMustGo.add(new Caminho(now, new Cell(i+2 , j+2))) ;
                                sw=0 ; 
                            }
                        }
                        if (once==0) break ; 
                    } 
                    if (once==0) break ;
                } 
                
                
                if (sw==1) 
                {
                	break ; 
                }
                else
                {
                    System.out.print("usuario " + (usuario+1) + " escolha uma das células que mostram abaixo para o próximo movimento: \n") ;
                    int it=1 ; 
                    for (Caminho p:cellsMustGo)
                    {
                        System.out.println(it + ". " + (p.getStart().getRow()+1) + "|" + (p.getStart().getCol()+1) + " to " + (p.getEnd().getRow()+1) + "|" + (p.getEnd().getCol()+1) ) ;
                        it++ ; 
                    }
                    int tmp = in.nextInt() ; 
                    row1 = cellsMustGo.get(tmp-1).getEnd().getRow() ; 
                    col1 = cellsMustGo.get(tmp-1).getEnd().getCol() ; 
                    tabela[row1][col1] = tabela[cellsMustGo.get(tmp-1).getStart().getRow()][cellsMustGo.get(tmp-1).getStart().getCol()];  
                    tabela[cellsMustGo.get(tmp-1).getStart().getRow()][cellsMustGo.get(tmp-1).getStart().getCol()] = ' ' ;
                    int newRow = (cellsMustGo.get(tmp-1).getStart().getRow() + row1) / 2; 
                    int newCol = (cellsMustGo.get(tmp-1).getStart().getCol() + col1) / 2;
                    if (usuario==0 && row1==7 && tabela[row1][col1]=='r') tabela[row1][col1] = 'R' ; 
                    if (usuario==1 && row1==0 && tabela[row1][col1]=='g') tabela[row1][col1] = 'G' ;
                    tabela[newRow][newCol] = ' ' ;
                    once=0 ;
                }
                prinTabela() ; 
            } 
            if (once==1)
            {
                do
                {
                    System.out.print("usuario " + (usuario+1) + " insira a linha da célula inicial: \n") ;  
                    int startRow = in.nextInt() ;                                                        
                    System.out.print("usuario " + (usuario+1) + "insira a coluna da célula inicial:: \n") ;    
                    int startCol = in.nextInt() ;                                                        
                    System.out.print("usuario " + (usuario+1) + " insira a linha da célula final: \n") ;         
                    int endRow = in.nextInt() ;                                                          
                    System.out.print("usuario " + (usuario+1) + " insira a coluna da célula final: \n") ;      
                    int endCol = in.nextInt() ;                                                          
                    startRow-- ;                                                                         
                    startCol-- ;                                                                         
                    endRow-- ;                                                                           
                    endCol-- ;                                                                           
                    
                    if (startRow>-1 && startRow<8 && startCol>-1 && startCol<8 && endRow>-1 && endRow<8 && endCol>-1 && endCol<8 && tabela[endRow][endCol]==' ' ) {
                        if (usuario==0 && tabela[startRow][startCol] == 'r') 
                        {
                            if ( endRow==startRow+1 && (endCol==startCol-1 || endCol==startCol+1) )
                            {
                                tabela[endRow][endCol] = 'r' ; 
                                tabela[startRow][startCol] = ' ' ;
                                if (usuario==0 && endRow==7 && tabela[endRow][endCol]=='r') tabela[endRow][endCol] = 'R' ; 
                                break ; 
                            }
                        }
                        else if (usuario==1 && tabela[startRow][startCol] == 'r') 
                        {
                            if ( endRow==startRow-1 && (endCol==startCol-1 || endCol==startCol+1) )
                            {
                                tabela[endRow][endCol] = 'g' ; 
                                tabela[startRow][startCol] = ' ' ;
                                if (usuario==1 && endRow==0 && tabela[endRow][endCol]=='g') tabela[endRow][endCol] = 'G' ; 
                                break ; 
                            }
                        }
                        else if (usuario==0 && tabela[startRow][startCol] == 'R') 
                        {
                            if ( (endRow==startRow-1 || endRow==startRow+1) && (endCol==startCol-1 || endCol==startCol+1) )
                            {
                                tabela[endRow][endCol] = 'R' ; 
                                tabela[startRow][startCol] = ' ' ;
                                break ; 
                            }
                        }
                        else if (usuario==1 && tabela[startRow][startCol] == 'G') 
                        {
                            if ( (endRow==startRow-1 || endRow==startRow+1) && (endCol==startCol-1 || endCol==startCol+1) )
                            {
                                tabela[endRow][endCol] = 'G' ; 
                                tabela[startRow][startCol] = ' ' ;
                                break ; 
                            }
                        }
                    }
                    System.out.println("Insira algum valido !");
                } while(true) ; 
                prinTabela() ;
            }
            int cntR=0, cntG=0 ; 
            for (int i=0 ; i<8 ; ++i) { 
                for (int j=0 ; j<8 ; ++j) {
                    if (tabela[i][j] == 'r' || tabela[i][j] == 'R') cntR++ ; 
                    if (tabela[i][j] == 'g' || tabela[i][j] == 'G') cntG++ ; 
                }
            }
            if (cntR==0) {
                System.out.println("Gabriel ganhou!");
                break ; 
            }
            if (cntG==0) {
                System.out.println("Rodrigo ganhou!");
                break ; 
            }
        } 
    }
    
}

class Cell {
    private int fileira , coluna ; 
    
    Cell (int r, int c) {
        this.fileira = r ; 
        this.coluna = c ; 
    }

    public int getRow() {
        return fileira;
    }

    public int getCol() {
        return coluna;
    }

    public void setRow(int row) {
        this.fileira = row;
    }

    public void setCol(int col) {
        this.coluna = col;
    }
    
}

class Caminho {
    private Cell start, end ; 
    
    Caminho (Cell s, Cell e) {
        this.start = s ;
        this.end = e ; 
    }

    public Cell getStart() {
        return start;
    }

    public Cell getEnd() {
        return end;
    }

    public void setStart(Cell start) {
        this.start = start;
    }

    public void setEnd(Cell end) {
        this.end = end;
    }
}