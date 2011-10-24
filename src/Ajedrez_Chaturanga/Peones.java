/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ajedrez_Chaturanga;

/**
 *
 * @author Gustavo
 */
public class Peones extends Piezas{
    
    

    public Peones(String P1,int j){
        super(P1,j);
    }
    
    @Override
    public String imprimir(){
        return this.nombrePieza1;
    }
}
