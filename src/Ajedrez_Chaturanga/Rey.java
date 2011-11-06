/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ajedrez_Chaturanga;

/**
 *
 * @author Gustavo
 */
public class Rey extends Piezas{
    public boolean movimientoL;
    
    public Rey(String n, int j,boolean t){
        super(n,j);
        this.movimientoL=t;
    }
}
