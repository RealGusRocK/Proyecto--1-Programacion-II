/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ajedrez_Chaturanga;

/**
 *
 * @author Gustavo
 */
public class Estadisticas {
    
    public String Ganador[]=new String [10];
    public String Perdedor[]=new String [10];
    public int m[]=new int[10];
    public int jugador[]=new int[10];
    public int cont=0;
    public int x[]=new int [10];
    
    public void agregarEstadisticas(String g, String p, int j, int a, int y, int x){
        if(x<10){
            if(Ganador[x]==null && x<=9){
                Ganador[x]=g;
                Perdedor[x]=p;
                m[x]=a;
                jugador[x]=j;
                this.x[x]=y;
            }else if(Ganador[x]!=null && x==9){
                Ganador[x]=g;
                Perdedor[x]=p;
                m[x]=a;
                jugador[x]=j;
                this.x[x]=y;
            }else{
                agregarEstadisticas(g,p,j,a,y,x+1);
            }
        }
    }
    public void ordenar(){
        
        
        
        String temp1,temp2;
        int tm,tm1,tmx;
        for(int i=0;i<10;i++){
            for(int j=0;j<9;j++){
                if(x[j]<x[j+1]){
                    
                    temp1=Ganador[j];
                    temp2=Perdedor[j];
                    tm=m[j];
                    tmx=x[j];
                    tm1=jugador[j];
                    Ganador[j]=Ganador[j+1];
                    Perdedor[j]=Perdedor[j+1];
                    m[j]=m[j+1];
                    jugador[j]=jugador[j+1];
                    x[j]=x[j+1];
                    Ganador[j+1]=temp1;
                    Perdedor[j+1]=temp2;
                    m[j+1]=tm;
                    x[j+1]=tmx;
                    jugador[j+1]=tm1;
                }
            }
        }
    }
    
    public void imprimir(){
         for(int i=0;i<10;i++){
             if(Ganador[i]!=null){
                 if(m[i]==1){
                     if(jugador[i]==1)
                        System.out.println((i+1)+". "+Ganador[i]+" le gano a "+Perdedor[i]+" comiendose al rey y "+Piezas.PiezasPerdidas2+" piezas mas.");
                     else
                         System.out.println((i+1)+". "+Ganador[i]+" le gano a "+Perdedor[i]+" comiendose al rey y "+Piezas.PiezasPerdidas1+" piezas mas.");
                 }else if(m[i]==-1){
                     System.out.println((i+1)+". "+Perdedor[i]+" se retiro del juego dejando como ganador a "+Ganador[i]);
                 }
             }else{
                 System.out.println((i+1)+". "+"-------------------------");
             }
         }
    }
    
}
