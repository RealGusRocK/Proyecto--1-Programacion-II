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
        int fili = 0,coli = 0,filf = 0,colf = 0;
        TableroJuego tablero=new TableroJuego();
        Estadisticas stats=new Estadisticas();
        boolean retirar=false;
        String piezamover;
        int contx=0;
        
        
        
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
                retirar=false;
                tablero.juegoTerminado=false;
                System.out.println("Nombre del Jugador 1");
                tablero.nombreJ1=lea.next();
                System.out.println("Nombre del Jugador 2");
                tablero.nombreJ2=lea.next();
                tablero.generarTablero();
                for(int j=0;j==0;j*=0){
                    
                    System.out.println("Jugador 1 es su turno");
                    System.out.println("");

                    for(int x=0;x==0;x*=0){
                    tablero.imprimirTablero();
                    
                    System.out.println("");
                    for(int f=0;f==0;f*=0){
                        System.out.println("Numero de Fila de la ficha a mover:");
                        fili=lea.nextInt();
                        if((fili>=1 && fili<=8) || fili==-1)
                            break;
                        else
                            System.out.println("Ingrese una fila correcta.");
                    }
                    for(int f=0;f==0;f*=0){
                        System.out.println("Numero de Columna de la ficha a mover:");
                        coli=lea.nextInt();
                        if((coli>=1 && coli<=8) || coli==-1){
                            break;
                        }else{
                            System.out.println("Numero de Columna Invalida.");
                        }
                    }
                    if(fili==-1 && coli==-1){
                        char c;
                        System.out.println("Esta seguro que desea retirarse del juego? (S/N) ");
                        c=lea.next().charAt(0);
                            if(c=='S'){
                                retirar=true;
                                break;
                            }
                    }
                            if(tablero.verificarPieza(fili-1, coli-1, 1)){
                                for(int e=0;e==0;e*=0){
                                    System.out.println("Fila a mover la pieza: ");
                                    filf=lea.nextInt();
                                    if(filf<1 && filf>8){
                                        System.out.println("Ingrese una fila correcta.");
                                        continue;
                                    }else if(filf>=1 && filf<=8){
                                        break;
                                    }
                                }
                                for(int e=0;e==0;e*=0){
                                    System.out.println("Columna a mover la pieza: ");
                                    colf=lea.nextInt();
                                    if(colf>=1 && colf<=8){
                                        break;
                                    }else{
                                        System.out.println("Ingrese una columna correcta.");
                                        continue;
                                    }
                                    
                                }
                                
                            }else{
                                continue;
                            }
                            
                            if(tablero.moverPieza(filf-1, colf-1, fili-1, coli-1, 1)==false){
                                continue;
                            }else{
                              break;
                            }
                    }
                  //  tablero.obtenerPosReyes();
                    if(tablero.terminarJuego()){
                        stats.agregarEstadisticas(tablero.nombreJ1, tablero.nombreJ2, 2, 1,contx);
                        contx++;
                        break;
                    }
                    if(retirar){
                        System.out.println("El jugador "+tablero.nombreJ2+" ha ganado porque el jugador "+tablero.nombreJ1+" se ha retirado.");
                        stats.agregarEstadisticas(tablero.nombreJ2, tablero.nombreJ1, 2,-1,contx);
                        contx++;
                        break;
                    }
                            System.out.println("Jugador 2 Es su Turno.");
                            System.out.println("");
                    for(int x=0;x==0;x*=0){        
                            tablero.imprimirTablero();
                    for(int f=0;f==0;f*=0){
                        System.out.println("Numero de Fila de la ficha a mover:");
                        fili=lea.nextInt();
                        if((fili>=1 && fili<=8) || fili==-1)
                            break;
                        else
                            System.out.println("Ingrese una fila correcta.");
                    }
                    for(int f=0;f==0;f*=0){
                        System.out.println("Numero de Columna de la ficha a mover:");
                        coli=lea.nextInt();
                        if((coli>=1 && coli<=8) || coli==-1){
                            break;
                        }else{
                            System.out.println("Numero de Columna Invalida.");
                        }
                    }
                    if(fili==-1 && coli==-1){
                        char c;
                        System.out.println("Esta seguro que desea retirarse? (S/N) ");
                        c=lea.next().charAt(0);
                        if(c=='S'){
                            retirar=true;
                            break;
                        }
                    }
                            if(tablero.verificarPieza(fili-1, coli-1, 2)){
                                for(int e=0;e==0;e*=0){
                                    System.out.println("Fila a mover la pieza: ");
                                    filf=lea.nextInt();
                                    if(filf<1 && filf>8){
                                        System.out.println("Ingrese una fila correcta.");
                                        continue;
                                    }else if(filf>=1 && filf<=8){
                                        break;
                                    }
                                }
                                for(int e=0;e==0;e*=0){
                                    System.out.println("Columna a mover la pieza: ");
                                    colf=lea.nextInt();
                                    if(colf>=1 && colf<=8){
                                        break;
                                    }else{
                                        System.out.println("Ingrese una columna correcta.");
                                        continue;
                                    }
                                    
                                }
                                
                            }else{
                                continue;
                            }
                            
                            if(tablero.moverPieza(filf-1, colf-1, fili-1, coli-1, 2)==false){
                                continue;
                            }else{
                              break;
                            }
                            
                            
                    }
                   // tablero.obtenerPosReyes();
                    if(tablero.terminarJuego()){
                        stats.agregarEstadisticas(tablero.nombreJ2, tablero.nombreJ1, 1, 1,contx);
                        contx++;
                        break;
                    }
                    if(retirar){
                        System.out.println("El jugador "+tablero.nombreJ1+" ha ganado porque el jugador "+tablero.nombreJ2+" se ha retirado.");
                        stats.agregarEstadisticas(tablero.nombreJ1, tablero.nombreJ2, 1, -1,contx);
                        contx++;
                        break;
                    }
                }
                
            }else if(opc1==2){
                System.out.println("********\t\t Estadisticas \t\t********");
                System.out.println("");
                    stats.ordenar();
                
                stats.imprimir();       
            }else if(opc1==3){
                System.out.println("Suerte para la proxima..");
                break;
            }else{
                System.out.println("Ingrese una opcion valida");
            }
            
        }
    }
}
