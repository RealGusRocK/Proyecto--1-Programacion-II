package Ajedrez_Chaturanga;


public class TableroJuego {
    private static Object tablero[][]=new Object [8][8];
    private boolean verificarpieza=false;
    
    public void generarTablero(){
        for(int a=0;a<tablero.length;a++){
            tablero[6][a]=new Peones(" PV ",2);
            tablero[1][a]=new Peones(" PR ",1);
        }
        tablero[0][0]=new Torres(" TR ",1);
        tablero[7][0]=new Torres(" TV ",2);
        tablero[0][1]=new Caballos(" CR ",1);
        tablero[7][1]=new Caballos(" CV ",2);
        tablero[0][2]=new Elefantes(" ER ",1);
        tablero[7][2]=new Elefantes(" EV ",2);
        tablero[0][3]=new Visir(" VR ",1);
        tablero[7][3]=new Visir(" VV ",2);
        tablero[0][4]=new Rey(" RR ",1);
        tablero[7][4]=new Rey(" RV ",2);
        tablero[0][5]=new Elefantes(" ER ",1);
        tablero[7][5]=new Elefantes(" EV ",2);
        tablero[0][6]=new Caballos(" CR ",1);
        tablero[7][6]=new Caballos(" CV ",2);
        tablero[0][7]=new Torres(" TR ",1);
        tablero[7][7]=new Torres(" TV ",2);
        for(int i=0;i<tablero.length;i++){
            for(int j=0;j<tablero[i].length;j++){
                if(tablero[i][j]==null)
                tablero[i][j]=" - ";
            }
        }
    }
    public void imprimirTablero(){
        int cont=0;
        System.out.println("  1   2   3   4   5   6   7   8");
        for(Object figura[]: tablero){
            System.out.print(cont+1);
            for(Object figura1:figura){
                if(figura1 instanceof Peones){
                    System.out.print(((Peones)figura1).imprimir());                      
                }else if(figura1 instanceof Piezas){
                    System.out.print(((Piezas)figura1).imprimir());
                }else{
                System.out.print("  - ");
                }
            }
            System.out.println("");
            cont++;
        }
    }
    public boolean verificarPieza(int x, int y,int j){
        if(((Piezas)tablero[x][y]).nombrePieza1.equals("  - ")){
            System.out.println("Pieza Invalida.");
            return false;
        }else{
             if(((Piezas)tablero[x][y]).jugador==j){
                 return true;
             }else{
                 System.out.println("Pieza de jugador contrario.");
                 return false;
             }
        }

    }
    public void moverPieza(int x, int y,int a, int b, int j){
        if(tablero[x][y] instanceof Peones){
            moverPeon(x,y,a,b,j);
        }
        
    }
    public void moverPeon(int x,int y,int a,int b,int j){
            if(x-a==1 || x-a==-1 && y==b && tablero[x][y]==null){
                if(j==1)
                    tablero[x][y]=new Peones("PR",j);
                else
                    tablero[x][y]=new Peones("PV",j);
                  //  ((Peones)tablero[x][y]).nombrePieza1=((Peones)tablero[a][b]).nombrePieza1;
                    tablero[a][b]=new Object();
                    tablero[a][b]="  - ";
            }else if((x-a==1 || x-a==-1 && y!=b) && tablero[x][y]!=null &&((Peones)tablero[x][y]).jugador!=j){
                    ((Piezas)tablero[x][y]).nombrePieza1=((Piezas)tablero[a][b]).nombrePieza1;
                    tablero[a][b]=new Object();
                    tablero[a][b]="  - ";
                    if(j==1){
                        Piezas.PiezasPerdidas2++;
                    }else{
                        Piezas.PiezasPerdidas1++;
                    }
                }else if((x-a==1 || x-a==-1 && y!=b) && tablero[x][y]!=null &&((Peones)tablero[x][y]).jugador==j){
                    System.out.println("Ya hay una pieza propia en esa posicion.");
                }else{
                System.out.println("Movimiento invalido.");
            }
    }
}
