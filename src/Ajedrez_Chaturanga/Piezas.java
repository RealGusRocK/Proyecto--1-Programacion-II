/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ajedrez_Chaturanga;

/**
 *
 * @author Gustavo y German
 */
public class Piezas {
    
    protected boolean turno=false;  
    protected String nombrePieza1;  // Nombre de la Pieza.
    protected int jugador;          //Variable para almacenar a que jugador Pertenece la ficha. 
    protected int pasos=0;          //Contador del numero de pasos dado por la ficha.
    
    public Piezas(String n,int j){
        this.nombrePieza1=n;
        this.jugador=j;
    }
    
    public int moverPieza(){
        return 0;
    }
    
    public String imprimir(){
        return this.nombrePieza1;
    }
            
}
