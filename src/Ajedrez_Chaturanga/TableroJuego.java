package Ajedrez_Chaturanga;


public class TableroJuego {
    private String tablero[][]=new String [8][8];
    
    public void generarTablero(){
        for(int i=0;i<tablero.length;i++){
            for(int j=0;j<tablero[i].length;j++){
                tablero[i][j]=" - ";
            }
        }
    }
    public void imprimirTablero(){
        System.out.println("  1  2  3  4  5  6  7  8");
        for(int i=0;i<tablero.length;i++){
            System.out.print(i+1);
            for(int j=0;j<tablero[i].length;j++){
                System.out.print(tablero[i][j]);
            }
            System.out.println("");
        }
    }
}
