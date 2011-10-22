package Ajedrez_Chaturanga;


public class TableroJuego {
    private static Object tablero[][]=new Object [8][8];
    private boolean verificarpieza=false;
    
    public void generarTablero(){
        tablero[0][0]=new Peones("PR");
        for(int i=0;i<tablero.length;i++){
            for(int j=0;j<tablero[i].length;j++){
                if(tablero[i][j]==null)
                tablero[i][j]=" - ";
            }
        }
    }
    public void imprimirTablero(){
        System.out.println("  1  2  3  4  5  6  7  8");
        for(int i=0;i<tablero.length;i++){
            System.out.print(i+1);
            for(int j=0;j<tablero[i].length;j++){
                if(tablero[i][j] instanceof Peones){
                    System.out.println(tablero[i][j].imprimir());                      
                }else{
                System.out.print(tablero[i][j]);
                }
            }
            System.out.println("");
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
