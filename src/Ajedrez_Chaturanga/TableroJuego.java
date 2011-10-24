package Ajedrez_Chaturanga;


public class TableroJuego {
    private static Object tablero[][]=new Object [8][8];
    private boolean verificarpieza=false;
    
    public void generarTablero(){
        //tablero[0][0]=new Peones("PR");
        for(int a=0;a<tablero.length;a++){
            tablero[6][a]=new Peones(" PV ",2);
            tablero[1][a]=new Peones(" PR ",1);
        }
        tablero[0][0]=new Piezas(" TR ",1);
        tablero[7][0]=new Piezas(" TV ",2);
        tablero[0][1]=new Piezas(" CR ",1);
        tablero[7][1]=new Piezas(" CV ",2);
        tablero[0][2]=new Piezas(" ER ",1);
        tablero[7][2]=new Piezas(" EV ",2);
        tablero[0][3]=new Piezas(" VR ",1);
        tablero[7][3]=new Piezas(" VV ",2);
        tablero[0][4]=new Piezas(" RR ",1);
        tablero[7][4]=new Piezas(" RV ",2);
        tablero[0][5]=new Piezas(" ER ",1);
        tablero[7][5]=new Piezas(" EV ",2);
        tablero[0][6]=new Piezas(" CR ",1);
        tablero[7][6]=new Piezas(" CV ",2);
        tablero[0][7]=new Piezas(" TR ",1);
        tablero[7][7]=new Piezas(" TV ",2);
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
    public void verificarPieza(String pieza){
        verificarpieza=false;
        for(int i=0;i<tablero.length;i++){
            for(int j=0;j<tablero[i].length;j++){
                if(tablero[i][j].equals(pieza)){
                    verificarpieza= true;
                    break;
                }
            }
        }
    }
    public void moverPieza(){
        
    }
}
