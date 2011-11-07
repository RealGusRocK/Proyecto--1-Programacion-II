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
    protected String nombrePieza1;  
    protected int jugador;          
    protected int pasos=0;          
    public static int PiezasPerdidas1=0;
    public static int PiezasPerdidas2=0;
    
    public Piezas(String n,int j){
        this.nombrePieza1=n;
        this.jugador=j;
    }
    
    
    public String imprimir(){
        return this.nombrePieza1;
    }
            
}
