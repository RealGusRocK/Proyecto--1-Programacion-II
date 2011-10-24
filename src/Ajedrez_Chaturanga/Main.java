/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ajedrez_Chaturanga;

/**
 *
 * @author Gustavo
 */
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner lea=new Scanner(System.in);
        int opc1=0;
        TableroJuego tablero=new TableroJuego();
        String piezamover;
        String Jugador1;
        String Jugador2;
        
        tablero.generarTablero();
        tablero.imprimirTablero();
        
        for(int i=0;i==0;i*=0){
            System.out.println("*********\t\t MENU PRINCIPAL \t\t*********");
            System.out.println("");
            System.out.println("1. Juar Chaturanga");
            System.out.println("2. Estadisticas de Juegos");
            System.out.println("3. Salir del Juego.");
            System.out.println("");
            System.out.println("Ingrese su opcion.");
            opc1=lea.nextInt();
            
            if(opc1==1){
                System.out.println("Nombre del Jugador 1");
                Jugador1=lea.next();
                System.out.println("Nombre del Jugador 2");
                Jugador1=lea.next();
                tablero.generarTablero();
                for(int j=0;j==0;j*=0){
                    
                    tablero.imprimirTablero();
                    System.out.println("Jugador 1 es su turno");
                    System.out.println("");
                    System.out.println("Ingrese la pieza que desea Mover.");
                    piezamover=lea.next();
                    tablero.verificarPieza(piezamover);
                    
                }
                
            }else if(opc1==2){
                
            }else if(opc1==3){
                System.out.println("Suerte para la proxima..");
                break;
            }else{
                System.out.println("Ingrese una opcion valida");
            }
            
        }
    }
}
