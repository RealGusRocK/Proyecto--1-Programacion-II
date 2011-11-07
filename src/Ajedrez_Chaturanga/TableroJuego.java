package Ajedrez_Chaturanga;


public class TableroJuego {
    private static Object tablero[][]=new Object [8][8];
    private boolean verificarpieza=false;
    public String nombreJ1;
    public String nombreJ2;
    public boolean juegoTerminado=false;
    
    public void generarTablero(){
        for(int a=0;a<tablero.length;a++){
            tablero[6][a]=new Peones(" PV ",2);
            tablero[1][a]=new Peones(" PR ",1);
        }
        tablero[0][0]=new Torres(" TR ",1);
        tablero[7][0]=new Torres(" TV ",2);
        tablero[0][1]=new Caballos(" CR ",1);
        tablero[7][1]=new Caballos(" CV ",2);
        tablero[0][2]=new Elefantes(" ER ",1);
        tablero[7][2]=new Elefantes(" EV ",2);
        tablero[0][4]=new Visir(" VR ",1);
        tablero[7][3]=new Visir(" VV ",2);
        tablero[0][3]=new Rey(" RR ",1,true);
        tablero[7][4]=new Rey(" RV ",2,true);
        tablero[0][5]=new Elefantes(" ER ",1);
        tablero[7][5]=new Elefantes(" EV ",2);
        tablero[0][6]=new Caballos(" CR ",1);
        tablero[7][6]=new Caballos(" CV ",2);
        tablero[0][7]=new Torres(" TR ",1);
        tablero[7][7]=new Torres(" TV ",2);
        for(int i=2;i<=5;i++){
            for(int j=0;j<tablero[i].length;j++){
                tablero[i][j]=new Object();
                tablero[i][j]=" - ";
            }
        }
    }
    public void imprimirTablero(){
        int cont=0;
        System.out.println("Rojos: "+Piezas.PiezasPerdidas1+"\t\t  Verdes: "+Piezas.PiezasPerdidas2);
        System.out.println("");
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
    public boolean verificarPieza(int x, int y,int j){
        if(tablero[x][y] instanceof Peones){
            System.out.println("Ha selecciona un Peon.");
        }else if(tablero[x][y] instanceof Torres){
            System.out.println("Ha seleccionado una Torre.");
        }else if(tablero[x][y] instanceof Elefantes){
            System.out.println("Ha seleccionado un Elefante.");
        }else if(tablero[x][y] instanceof Caballos){
            System.out.println("Ha seleccionado un Caballo.");
        }else if(tablero[x][y] instanceof Rey){
            System.out.println("Ha seleccionado al Rey.");
        }else if(tablero[x][y] instanceof Visir){
            System.out.println("Ha seleccionado al Visir.");
        }
        if(tablero[x][y].equals("  - ")){
            System.out.println("Pieza Invalida.");
            return false;
        }else{
            if(tablero[x][y] instanceof Piezas){
             if(((Piezas)tablero[x][y]).jugador==j){
                 return true;
             }else{
                 System.out.println("Pieza de jugador contrario.");
                 return false;
             }
        }else{
                System.out.println("No ha seleccionada alguna ficha.");
                return false;
            }
        }

    }
    public boolean moverPieza(int x, int y,int a, int b, int j){
        if(tablero[a][b] instanceof Peones){
            if(moverPeon(x,y,a,b,j))
            return true;
            else
                return false;
        }else if(tablero[a][b] instanceof Caballos){
            if(moverCaballo(x,y,a,b,j))
            return true;
            else
                return false;
        }else if (tablero[a][b] instanceof Visir){
            if(moverVisir(x,y,a,b,j))
            return true;
                else
                return false;
        }else if(tablero[a][b] instanceof Torres){
            if(moverTorre(x,y,a,b,j))
                return true;
            else
                return false;
        }else if(tablero[a][b] instanceof Elefantes){
            if(moverElefante(x,y,a,b,j))
                return true;
            else
                return false;
        }else if(tablero[a][b] instanceof Rey){
            if(moverRey(x,y,a,b,j))
                return true;
            else
                return false;
        }else{
            return false;
        }
        
    }
    public void valJaquePeon(int x, int y, int j){
          if(j==1){
            if(x!=7 && y!=7 && x!=0 && y!=0){
                if((tablero[x-1][y-1] instanceof Rey && ((Piezas)tablero[x-1][y-1]).jugador!=j) || (tablero[x-1][y+1] instanceof Rey && ((Piezas)tablero[x-1][y+1]).jugador!=j) || (tablero[x+1][y-1] instanceof Rey && ((Piezas)tablero[x+1][y-1]).jugador!=j) || (tablero[x+1][y+1] instanceof Rey && ((Piezas)tablero[x+1][y+1]).jugador!=j)){
                    System.out.println("El rey del Jugador "+this.nombreJ2+" esta en peligro.");
                    
                }
            }else if(x>=0 && x<=7 && y>0 && y<7){
                if(x==7){
                    if((tablero[x-1][y-1] instanceof Rey && ((Piezas)tablero[x-1][y-1]).jugador!=j) || (tablero[x-1][y+1] instanceof Rey && ((Piezas)tablero[x-1][y+1]).jugador!=j)){
                        System.out.println("El rey del Jugador "+this.nombreJ2+" esta en peligro.");
                    }
                }else if(x==0){
                   if( (tablero[x+1][y-1] instanceof Rey && ((Piezas)tablero[x+1][y-1]).jugador!=j) || (tablero[x+1][y+1] instanceof Rey && ((Piezas)tablero[x+1][y+1]).jugador!=j)){
                    System.out.println("El rey del Jugador "+this.nombreJ2+" esta en peligro.");
                    
                    }    
                }
            }else if(x>0 && y<7 && x>=0 && x<=7){
                if(y==7){
                    if((tablero[x-1][y-1] instanceof Rey && ((Piezas)tablero[x-1][y-1]).jugador!=j) || (tablero[x-1][y+1] instanceof Rey && ((Piezas)tablero[x-1][y+1]).jugador!=j)){
                        System.out.println("El rey del Jugador "+this.nombreJ2+" esta en peligro.");
                    }
                }else if(y==0){
                    if( (tablero[x-1][y+1] instanceof Rey && ((Piezas)tablero[x-1][y+1]).jugador!=j) || (tablero[x+1][y+1] instanceof Rey && ((Piezas)tablero[x+1][y+1]).jugador!=j)){
                        System.out.println("El rey del Jugador "+this.nombreJ2+" esta en peligro.");
                    
                    }
                }
            }
        }else{
             if(x!=7 && y!=7 && x!=0 && y!=0){
                if((tablero[x-1][y-1] instanceof Rey && ((Piezas)tablero[x-1][y-1]).jugador!=j) || (tablero[x-1][y+1] instanceof Rey && ((Piezas)tablero[x-1][y+1]).jugador!=j) || (tablero[x+1][y-1] instanceof Rey && ((Piezas)tablero[x+1][y-1]).jugador!=j) || (tablero[x+1][y+1] instanceof Rey && ((Piezas)tablero[x+1][y+1]).jugador!=j)){
                    System.out.println("El rey del Jugador "+this.nombreJ1+" esta en peligro.");
                    
                }
            }else if(x>=0 && x<=7 && y>0 && y<7){
                if(x==7){
                    if((tablero[x-1][y-1] instanceof Rey && ((Piezas)tablero[x-1][y-1]).jugador!=j) || (tablero[x-1][y+1] instanceof Rey && ((Piezas)tablero[x-1][y+1]).jugador!=j)){
                        System.out.println("El rey del Jugador "+this.nombreJ1+" esta en peligro.");
                    }
                }else if(x==0){
                   if( (tablero[x+1][y-1] instanceof Rey && ((Piezas)tablero[x+1][y-1]).jugador!=j) || (tablero[x+1][y+1] instanceof Rey && ((Piezas)tablero[x+1][y+1]).jugador!=j)){
                    System.out.println("El rey del Jugador "+this.nombreJ1+" esta en peligro.");
                    
                    }    
                }
            }else if(x>0 && y<7 && x>=0 && x<=7){
                if(y==7){
                    if((tablero[x-1][y-1] instanceof Rey && ((Piezas)tablero[x-1][y-1]).jugador!=j) || (tablero[x-1][y+1] instanceof Rey && ((Piezas)tablero[x-1][y+1]).jugador!=j)){
                        System.out.println("El rey del Jugador "+this.nombreJ1+" esta en peligro.");
                    }
                }else if(y==0){
                    if( (tablero[x-1][y+1] instanceof Rey && ((Piezas)tablero[x-1][y+1]).jugador!=j) || (tablero[x+1][y+1] instanceof Rey && ((Piezas)tablero[x+1][y+1]).jugador!=j)){
                        System.out.println("El rey del Jugador "+this.nombreJ1+" esta en peligro.");
                    
                    }
                }
            } 
          }
    }
    public boolean moverPeon(int x,int y,int a,int b,int j){
            valJaquePeon(x,y,j);
         if(tablero[x][y] instanceof String){
            if(((x-a==1 || x-a==-1) && (y==b))){
                if(j==1)
                    tablero[x][y]=new Peones(" PR ",j);
                else
                    tablero[x][y]=new Peones(" PV ",j);
                tablero[a][b]=new Object();
                tablero[a][b]="  - ";
                return true;
            }else{
                System.out.println("Movimiento Invalido.");
                return false;
            }
        }else if(tablero[x][y] instanceof Piezas && ((Piezas)tablero[x][y]).jugador!=j){
            mostrarMensaje(x,y,a,b,j);
            if(((x-a==1 || x-a==-1) && (y!=b))){
                tablero[a][b]=new Object();
                tablero[a][b]="  - ";
                if(j==1){
                    tablero[x][y]=new Peones(" PR ",1);
                    Piezas.PiezasPerdidas2++;
                }else{
                    tablero[x][y]=new Peones(" PV ",2);
                    Piezas.PiezasPerdidas1++;
               }
                return true;
            }else{
                System.out.println("Moviemiento Invalido.");
                return false;
            }
        }else if( tablero[x][y] instanceof Piezas && ((Piezas)tablero[x][y]).jugador==j){
            System.out.println("En esa posicion se encuentra una pieza propia.");
            return false;
        }else{
            return false;
        }
        

    }
public void verificarJaqueCaballo(int x, int y, int j){
    if(j==1){
        if(x>1 && x<6 && y>1 && y<6){
            if((tablero[x-2][y-1] instanceof Rey && ((Piezas)tablero[x-2][y-1]).jugador!=j) || (tablero[x-2][y+1] instanceof Rey && ((Piezas)tablero[x-2][y+1]).jugador!=j) || (tablero[x+2][y-1] instanceof Rey && ((Piezas)tablero[x+2][y-1]).jugador!=j) || (tablero[x+2][y+1] instanceof Rey && ((Piezas)tablero[x+2][y+1]).jugador!=j)|| (tablero[x-1][y-2] instanceof Rey && ((Piezas)tablero[x-1][y-2]).jugador!=j) || (tablero[x+1][y-2] instanceof Rey && ((Piezas)tablero[x+1][y-2]).jugador!=j) || (tablero[x-1][y+2] instanceof Rey && ((Piezas)tablero[x-1][y+2]).jugador!=j) || (tablero[x+1][x+2] instanceof Rey && ((Piezas)tablero[x+1][y+2]).jugador!=j)){
                System.out.println("El rey del jugador 2 esta en peligro.");
            }
        }
    }else{
        if(x>1 && x<6 && y>1 && y<6){
            if((tablero[x-2][y-1] instanceof Rey && ((Piezas)tablero[x-2][y-1]).jugador!=j) || (tablero[x-2][y+1] instanceof Rey && ((Piezas)tablero[x-2][y+1]).jugador!=j) || (tablero[x+2][y-1] instanceof Rey && ((Piezas)tablero[x+2][y-1]).jugador!=j) || (tablero[x+2][y+1] instanceof Rey && ((Piezas)tablero[x+2][y+1]).jugador!=j)|| (tablero[x-1][y-2] instanceof Rey && ((Piezas)tablero[x-1][y-2]).jugador!=j) || (tablero[x+1][y-2] instanceof Rey && ((Piezas)tablero[x+1][y-2]).jugador!=j) || (tablero[x-1][y+2] instanceof Rey && ((Piezas)tablero[x-1][y+2]).jugador!=j) || (tablero[x+1][x+2] instanceof Rey && ((Piezas)tablero[x+1][y+2]).jugador!=j)){
                System.out.println("El rey del jugador 1 esta en peligro.");
            }
        }
    }
}
    public boolean moverCaballo(int x,int y,int a,int b,int j){
        verificarJaqueCaballo(x,y,j);
        if(tablero[x][y] instanceof String){
            if(((x-a==2 || x-a==-2) && (y-b==1 || y-b==-1)) || ((x-a==1 || x-a==-1) && (y-b==2 || y-b==-2))){
                if(j==1)
                    tablero[x][y]=new Caballos(" CR ",j);
                else
                    tablero[x][y]=new Caballos(" CV ",j);
                tablero[a][b]=new Object();
                tablero[a][b]="  - ";
                return true;
            }else{
                System.out.println("Movimiento Invalido.");
                return false;
            }
        }else if(tablero[x][y] instanceof Piezas && ((Piezas)tablero[x][y]).jugador!=j){
            mostrarMensaje(x,y,a,b,j);
            if((((x-a==1 || x-a==-1)) && ((y-b==2 || y-b==-2))) || ((x-a==2 || x-a==-2) && (y-b==1 || y-b==-1))){
                tablero[a][b]=new Object();
                tablero[a][b]="  - ";
                if(j==1){
                    tablero[x][y]=new Caballos(" CR ",1);
                    Piezas.PiezasPerdidas2++;
                }else{
                    tablero[x][y]=new Caballos(" CV ",2);
                    Piezas.PiezasPerdidas1++;
               }
                return true;
            }else{
                System.out.println("Moviemiento Invalido.");
                return false;
            }
        }else if( tablero[x][y] instanceof Piezas && ((Piezas)tablero[x][y]).jugador==j){
            System.out.println("En esa posicion se encuentra una pieza propia.");
            return false;
        }else{
            return false;
        }
    }
    public void valJaqueVisir(int x, int y, int j){
        if(j==1){
            if(x>0 && x<7 && y>0 && y<7){
                if((tablero[x-1][y-1] instanceof Rey && ((Piezas)tablero[x-1][y-1]).jugador!=j) || (tablero[x+1][y+1] instanceof Rey && ((Piezas)tablero[x+1][y+1]).jugador!=j) || (tablero[x+1][y-1] instanceof Rey && ((Piezas)tablero[x+1][y-1]).jugador!=j) || (tablero[x-1][y+1] instanceof Rey && ((Piezas)tablero[x-1][y+1]).jugador!=j)){
                  System.out.println("El Rey del jugador "+this.nombreJ2+" esta en jaque. ");
                }
            }else if(x>0 && x<7 && y>=0 && y<=7){
                if(y==7){
                    if((tablero[x-1][y-1] instanceof Rey && ((Piezas)tablero[x-1][y-1]).jugador!=j)  || (tablero[x+1][y-1] instanceof Rey && ((Piezas)tablero[x+1][y-1]).jugador!=j)){
                        System.out.println("El Rey del jugador "+this.nombreJ2+" esta en jaque. ");
                    }
                }else if(y==0){
                    if( (tablero[x+1][y+1] instanceof Rey && ((Piezas)tablero[x+1][y+1]).jugador!=j) ||  (tablero[x-1][y+1] instanceof Rey && ((Piezas)tablero[x-1][y+1]).jugador!=j)){
                        System.out.println("El Rey del jugador "+this.nombreJ2+" esta en jaque. ");
                    }   
                }
            }else if(x>=0 && x<=7 && y>0 && y<7){
                if(x==7){
                    if((tablero[x-1][y-1] instanceof Rey && ((Piezas)tablero[x-1][y-1]).jugador!=j) || (tablero[x-1][y+1] instanceof Rey && ((Piezas)tablero[x-1][y+1]).jugador!=j)){
                        System.out.println("El Rey del jugador "+this.nombreJ2+" esta en jaque. ");
                    }
                }else if(x==0){
                    if((tablero[x+1][y+1] instanceof Rey && ((Piezas)tablero[x+1][y+1]).jugador!=j) || (tablero[x+1][y-1] instanceof Rey && ((Piezas)tablero[x+1][y-1]).jugador!=j)){
                        System.out.println("El Rey del jugador "+this.nombreJ2+" esta en jaque. ");
                    }
                }
                
            }
        }else{
            if(x>0 && x<7 && y>0 && y<7){
                if((tablero[x-1][y-1] instanceof Rey && ((Piezas)tablero[x-1][y-1]).jugador!=j) || (tablero[x+1][y+1] instanceof Rey && ((Piezas)tablero[x+1][y+1]).jugador!=j) || (tablero[x+1][y-1] instanceof Rey && ((Piezas)tablero[x+1][y-1]).jugador!=j) || (tablero[x-1][y+1] instanceof Rey && ((Piezas)tablero[x-1][y+1]).jugador!=j)){
                  System.out.println("El Rey del jugador "+this.nombreJ1+" esta en jaque. ");
                }
            }else if(x>0 && x<7 && y>=0 && y<=7){
                if(y==7){
                    if((tablero[x-1][y-1] instanceof Rey && ((Piezas)tablero[x-1][y-1]).jugador!=j)  || (tablero[x+1][y-1] instanceof Rey && ((Piezas)tablero[x+1][y-1]).jugador!=j)){
                        System.out.println("El Rey del jugador "+this.nombreJ1+" esta en jaque. ");
                    }
                }else if(y==0){
                    if( (tablero[x+1][y+1] instanceof Rey && ((Piezas)tablero[x+1][y+1]).jugador!=j) ||  (tablero[x-1][y+1] instanceof Rey && ((Piezas)tablero[x-1][y+1]).jugador!=j)){
                        System.out.println("El Rey del jugador "+this.nombreJ1+" esta en jaque. ");
                    }   
                }
            }else if(x>=0 && x<=7 && y>0 && y<7){
                if(x==7){
                    if((tablero[x-1][y-1] instanceof Rey && ((Piezas)tablero[x-1][y-1]).jugador!=j) || (tablero[x-1][y+1] instanceof Rey && ((Piezas)tablero[x-1][y+1]).jugador!=j)){
                        System.out.println("El Rey del jugador "+this.nombreJ1+" esta en jaque. ");
                    }
                }else if(x==0){
                    if((tablero[x+1][y+1] instanceof Rey && ((Piezas)tablero[x+1][y+1]).jugador!=j) || (tablero[x+1][y-1] instanceof Rey && ((Piezas)tablero[x+1][y-1]).jugador!=j)){
                        System.out.println("El Rey del jugador "+this.nombreJ1+" esta en jaque. ");
                    }
                }
                
            }
        }
    }
        
    public boolean moverVisir(int x,int y,int a,int b,int j){
        valJaqueVisir(x,y,j);
        if(tablero[x][y] instanceof String){
            if(((x-a==1 || x-a==-1) && (y-b==1 || y-b==-1))){
                if(j==1)
                    tablero[x][y]=new Visir(" VR ",j);
                else
                    tablero[x][y]=new Visir(" VV ",j);
                tablero[a][b]=new Object();
                tablero[a][b]="  - ";
                return true;
            }else{
                System.out.println("Movimiento Invalido.");
                return false;
            }
        }else if(tablero[x][y] instanceof Piezas && ((Piezas)tablero[x][y]).jugador!=j){
            mostrarMensaje(x,y,a,b,j);
            if((((x-a==1 || x-a==-1)) && ((y-b==1 || y-b==-1)))){
                tablero[a][b]=new Object();
                tablero[a][b]="  - ";
                if(j==1){
                    tablero[x][y]=new Visir(" VR ",1);
                    Piezas.PiezasPerdidas2++;
                }else{
                    tablero[x][y]=new Visir(" VR ",2);
                    Piezas.PiezasPerdidas1++;
               }
                return true;
            }else{
                System.out.println("Moviemiento Invalido.");
                return false;
            }
        }else if( tablero[x][y] instanceof Piezas && ((Piezas)tablero[x][y]).jugador==j){
            System.out.println("En esa posicion se encuentra una pieza propia.");
            return false;
        }else{
            return false;
        }
    }
    
    
     public void verificarJaqueTorre(int x, int y, int j){
      if(j==1){
       for(int i=0;i<8;i++){
            if((tablero[x][i] instanceof Rey && ((Piezas)tablero[x][i]).jugador!=j) || (tablero[i][y] instanceof Rey && ((Piezas)tablero[i][y]).jugador!=j)){
              System.out.println("El Rey del jugador 2 esta en peligro.");
            }
      }
      }else if(j==2){
        for(int i=0;i<8;i++){
        if((tablero[x][i] instanceof Rey &&((Piezas)tablero[x][i]).jugador!=j ) || (tablero[i][y] instanceof Rey && ((Piezas)tablero[i][y]).jugador!=j )){
        System.out.println("El Rey del jugador 1 esta en peligro.");
        }
        }
        }
        }


    
    public boolean moverTorre(int x, int y, int a,int b, int j){
        if(valTorre(x,y,a,b,1)){
            verificarJaqueTorre(x,y,j);
            if(tablero[x][y] instanceof String){
                if(x==a && y!=b){
                    tablero[a][b]=new Object();
                    tablero[a][b]="  - ";
                    if(j==1)
                        tablero[x][y]=new Torres(" TR ",1);
                    else
                        tablero[x][y]=new Torres(" TV ",2);
                    return true;
                }else if(x!=a && y==b){
                    tablero[a][b]=new Object();
                    tablero[a][b]="  - ";
                    if(j==1)
                        tablero[x][y]=new Torres(" TR ",1);
                    else
                        tablero[x][y]=new Torres(" TV ",2);
                    return true;
                }else{
                    System.out.println("Movimiento invalido.");
                    return false;
                }
            }else if(tablero[x][y] instanceof Piezas && ((Piezas)tablero[x][y]).jugador!=j){
                mostrarMensaje(x,y,a,b,j);
                if((x==a && y!=b) || (x!=a && y==b)){
                    tablero[a][b]=new Object();
                    tablero[a][b]="  - ";
                    if(j==1){
                        tablero[x][y]=new Torres(" TR ",1);
                        Piezas.PiezasPerdidas2++;
                    }else{
                        tablero[x][y]=new Torres(" TV ",2);
                        Piezas.PiezasPerdidas1++;
                    }
                    return true;
                }else{
                    System.out.println("Movimiento Invalido.");
                    return false;
                }
            }else{
                System.out.println("Ya hay una pieza propia en esa posicion.");
                return false;
            } 
        }else{
            System.out.println("Movimiento Invalido.");
            return false;
        }
    }
    public boolean valTorre(int x,int y,int a,int b,int c){ //Mandar parametro c=0;
        if((x==a && y!=b)){
            if(y>b){
               if((b+c)<y){
                    if(tablero[x][b+c] instanceof Piezas){
                        return false;
                    }else{
                        return valTorre(x,y,a,b,c+1);
                    }
               }else{
                   return true;
               }
            }else{
                if(b-c>y){
                    if(tablero[x][b-c] instanceof Piezas){
                        return false;
                    }else{
                        return valTorre(x,y,a,b,c+1);
                    }
               }else{
                   return true;
               }
                }
            }else if((x!=a && y==b)){
              if(x>a){
               if((a+c)<x){
                    if(tablero[a+c][y] instanceof Piezas){
                        return false;
                    }else{
                        return valTorre(x,y,a,b,c+1);
                    }
               }else{
                   return true;
               }
            }else{
                if(a-c>x){
                    if(tablero[a-c][y] instanceof Piezas){
                        return false;
                    }else{
                        return valTorre(x,y,a,b,c+1);
                    }
               }else{
                   return true;
               }
            }
        }else{
                return false;
            }
    }
        public void valJaqueElefante(int x, int y, int j){
        if(j==1){
            if(x>1 && x<6 && y>1 && y<6){
                if((tablero[x-2][y-2] instanceof Rey && ((Piezas)tablero[x-2][y-2]).jugador!=j) || (tablero[x+2][y+2] instanceof Rey && ((Piezas)tablero[x+2][y+2]).jugador!=j) || (tablero[x+2][y-2] instanceof Rey && ((Piezas)tablero[x+2][y-2]).jugador!=j) || (tablero[x-2][y+2] instanceof Rey && ((Piezas)tablero[x-2][y+2]).jugador!=j)){
                  System.out.println("El Rey del jugador "+this.nombreJ2+" esta en jaque. ");
                }
            }else if(x>1 && x<6 && y>=0 && y<=7){
                if(y==6 || y==7){
                    if((tablero[x-2][y-2] instanceof Rey && ((Piezas)tablero[x-2][y-2]).jugador!=j)  || (tablero[x+2][y-2] instanceof Rey && ((Piezas)tablero[x+2][y-2]).jugador!=j)){
                        System.out.println("El Rey del jugador "+this.nombreJ2+" esta en jaque. ");
                    }
                }else if(y==0 || y==1){
                    if( (tablero[x+2][y+2] instanceof Rey && ((Piezas)tablero[x+2][y+2]).jugador!=j) ||  (tablero[x-2][y+2] instanceof Rey && ((Piezas)tablero[x-2][y+2]).jugador!=j)){
                        System.out.println("El Rey del jugador "+this.nombreJ2+" esta en jaque. ");
                    }   
                }
            }else if(x>=0 && x<=7 && y>1 && y<6){
                if(x==6 || x==7){
                    if((tablero[x-2][y-2] instanceof Rey && ((Piezas)tablero[x-2][y-2]).jugador!=j) || (tablero[x-2][y+2] instanceof Rey && ((Piezas)tablero[x-2][y+2]).jugador!=j)){
                        System.out.println("El Rey del jugador "+this.nombreJ2+" esta en jaque. ");
                    }
                }else if(x==0 || x==1){
                    if((tablero[x+2][y+2] instanceof Rey && ((Piezas)tablero[x+2][y+2]).jugador!=j) || (tablero[x+2][y-2] instanceof Rey && ((Piezas)tablero[x+2][y-2]).jugador!=j)){
                        System.out.println("El Rey del jugador "+this.nombreJ2+" esta en jaque. ");
                    }
                }
                
            }
        }else{
            if(x>1 && x<6 && y>1 && y<6){
                if((tablero[x-2][y-2] instanceof Rey && ((Piezas)tablero[x-2][y-2]).jugador!=j) || (tablero[x+2][y+2] instanceof Rey && ((Piezas)tablero[x+2][y+2]).jugador!=j) || (tablero[x+2][y-2] instanceof Rey && ((Piezas)tablero[x+2][y-2]).jugador!=j) || (tablero[x-2][y+2] instanceof Rey && ((Piezas)tablero[x-2][y+2]).jugador!=j)){
                  System.out.println("El Rey del jugador "+this.nombreJ1+" esta en jaque. ");
                }
            }else if(x>1 && x<6 && y>=0 && y<=7){
                if(y==6 || y==7){
                    if((tablero[x-2][y-2] instanceof Rey && ((Piezas)tablero[x-2][y-2]).jugador!=j)  || (tablero[x+2][y-2] instanceof Rey && ((Piezas)tablero[x+2][y-2]).jugador!=j)){
                        System.out.println("El Rey del jugador "+this.nombreJ1+" esta en jaque. ");
                    }
                }else if(y==0 || y==1){
                    if( (tablero[x+2][y+2] instanceof Rey && ((Piezas)tablero[x+2][y+2]).jugador!=j) ||  (tablero[x-2][y+2] instanceof Rey && ((Piezas)tablero[x-2][y+2]).jugador!=j)){
                        System.out.println("El Rey del jugador "+this.nombreJ1+" esta en jaque. ");
                    }   
                }
            }else if(x>=0 && x<=7 && y>1 && y<6){
                if(x==6 || x==7){
                    if((tablero[x-2][y-2] instanceof Rey && ((Piezas)tablero[x-2][y-2]).jugador!=j) || (tablero[x-2][y+2] instanceof Rey && ((Piezas)tablero[x-2][y+2]).jugador!=j)){
                        System.out.println("El Rey del jugador "+this.nombreJ1+" esta en jaque. ");
                    }
                }else if(x==0 || x==1){
                    if((tablero[x+2][y+2] instanceof Rey && ((Piezas)tablero[x+2][y+2]).jugador!=j) || (tablero[x+2][y-2] instanceof Rey && ((Piezas)tablero[x+2][y-2]).jugador!=j)){
                        System.out.println("El Rey del jugador "+this.nombreJ1+" esta en jaque. ");
                    }
                }
                
            }
        }
    }
    
    public boolean moverElefante(int x, int y, int a,int b, int j){
        valJaqueElefante(x,y,j);
            if(tablero[x][y] instanceof String){
                if((x-a==2 || x-a==-2) && (y-b==2 || y-b == -2)){
                    tablero[a][b]=new Object();
                    tablero[a][b]="  - ";
                    if(j==1)
                        tablero[x][y]=new Elefantes(" ER ",1);
                    else
                        tablero[x][y]=new Elefantes(" EV ",2);
                    return true;
                }else{
                    System.out.println("Movimiento invalido.");
                    return false;
                }
            }else if(tablero[x][y] instanceof Piezas && ((Piezas)tablero[x][y]).jugador!=j){
                mostrarMensaje(x,y,a,b,j);
                if((x-a==2 || x-a==-2) && (y-b==2 || y-b == -2)){
                    tablero[a][b]=new Object();
                    tablero[a][b]="  - ";
                    if(j==1){
                        tablero[x][y]=new Elefantes(" ER ",1);
                        Piezas.PiezasPerdidas2++;
                    }else{
                        tablero[x][y]=new Elefantes(" EV ",2);
                        Piezas.PiezasPerdidas1++;
                    }
                    return true;
                }else{
                    System.out.println("Movimiento Invalido.");
                    return false;
                }
            }else{
                System.out.println("Ya hay una pieza propia en esa posicion.");
                return false;
            } 
        
    }
    


    public void verificarJaqueRey(int x, int y, int j){
    if(j==1){
    if( tablero[x][y] instanceof Rey && (((Rey)tablero[x][y]).movimientoL)==false){
    if(x!=7 && y!=7 && x!=0 && y!=0 && x!=1 && x!=7 && y!=1 && y!=7){
    if((tablero[x-2][y-1] instanceof Rey && ((Piezas)tablero[x-2][y-1]).jugador!=j) || (tablero[x-2][y+1] instanceof Rey && ((Piezas)tablero[x-2][y+1]).jugador!=j) || (tablero[x+2][y-1] instanceof Rey && ((Piezas)tablero[x+2][y-1]).jugador!=j) || (tablero[x+2][y+1] instanceof Rey && ((Piezas)tablero[x+2][y+1]).jugador!=j)|| (tablero[x-1][y-2] instanceof Rey && ((Piezas)tablero[x-1][y-2]).jugador!=j) || (tablero[x+1][y-2] instanceof Rey && ((Piezas)tablero[x+1][y-2]).jugador!=j) || (tablero[x-1][y+2] instanceof Rey && ((Piezas)tablero[x-1][y+2]).jugador!=j) || (tablero[x+1][x+2] instanceof Rey && ((Piezas)tablero[x+1][y+2]).jugador!=j) ||
    (tablero[x-1][y-1] instanceof Rey && ((Piezas)tablero[x-1][y-1]).jugador!=j) || (tablero[x-1][y+1] instanceof Rey && ((Piezas)tablero[x-1][y+1]).jugador!=j) || (tablero[x+1][y-1] instanceof Rey && ((Piezas)tablero[x+1][y-1]).jugador!=j) || (tablero[x+1][y+1] instanceof Rey && ((Piezas)tablero[x+1][y+1]).jugador!=j)){
    System.out.println("El Rey del jugador 2 esta en peligro.");
    }
    }
    else if(x!=8 && y!=8 && x!=1 && y!=1){
    if((tablero[x-1][y-1] instanceof Rey && ((Piezas)tablero[x-1][y-1]).jugador!=j) || (tablero[x-1][y+1] instanceof Rey && ((Piezas)tablero[x-1][y+1]).jugador!=j) || (tablero[x+1][y-1] instanceof Rey && ((Piezas)tablero[x+1][y-1]).jugador!=j) || (tablero[x+1][y+1] instanceof Rey && ((Piezas)tablero[x+1][y+1]).jugador!=j)){
    System.out.println("El Rey del jugador 2 esta en peligro.");
    }
    }
    }else if(j==2){
    if((((Rey)tablero[x][y]).movimientoL)==false){
    if(x!=8 && y!=8 && x!=1 && y!=1 && x!=1 && x!=7 && y!=1 && y!=7){
    if((tablero[x-2][y-1] instanceof Rey && ((Piezas)tablero[x-2][y-1]).jugador!=j) || (tablero[x-2][y+1] instanceof Rey && ((Piezas)tablero[x-2][y+1]).jugador!=j) || (tablero[x+2][y-1] instanceof Rey && ((Piezas)tablero[x+2][y-1]).jugador!=j) || (tablero[x+2][y+1] instanceof Rey && ((Piezas)tablero[x+2][y+1]).jugador!=j)|| (tablero[x-1][y-2] instanceof Rey && ((Piezas)tablero[x-1][y-2]).jugador!=j) || (tablero[x+1][y-2] instanceof Rey && ((Piezas)tablero[x+1][y-2]).jugador!=j) || (tablero[x-1][y+2] instanceof Rey && ((Piezas)tablero[x-1][y+2]).jugador!=j) || (tablero[x+1][x+2] instanceof Rey && ((Piezas)tablero[x+1][y+2]).jugador!=j) ||
    (tablero[x-1][y-1] instanceof Rey && ((Piezas)tablero[x-1][y-1]).jugador!=j) || (tablero[x-1][y+1] instanceof Rey && ((Piezas)tablero[x-1][y+1]).jugador!=j) || (tablero[x+1][y-1] instanceof Rey && ((Piezas)tablero[x+1][y-1]).jugador!=j) || (tablero[x+1][y+1] instanceof Rey && ((Piezas)tablero[x+1][y+1]).jugador!=j)){
    System.out.println("El Rey del jugador 1 esta en peligro.");
    }
    }
    }else if(x!=8 && y!=8 && x!=1 && y!=1){
    if((tablero[x-1][y-1] instanceof Rey && ((Piezas)tablero[x-1][y-1]).jugador!=j) || (tablero[x-1][y+1] instanceof Rey && ((Piezas)tablero[x-1][y+1]).jugador!=j) || (tablero[x+1][y-1] instanceof Rey && ((Piezas)tablero[x+1][y-1]).jugador!=j) || (tablero[x+1][y+1] instanceof Rey && ((Piezas)tablero[x+1][y+1]).jugador!=j)){
    System.out.println("El Rey del jugador 1 esta en peligro.");
    }
    }


    }

    }
    }
    public boolean moverRey(int x, int y, int a, int b, int j){
        verificarJaqueRey(x,y,j);
        if(tablero[x][y] instanceof String){
            if((x==a && (y-b==1 || y-b==-1)) || (y==b && (x-a==1 || x-a==-1)) || ((x-a==-1 || x-a==1) && (y-b==1 || y-b==-1))){
                
               
                if(j==1){
                    if( tablero[a][b] instanceof Rey &&((Rey)tablero[a][b]).movimientoL)
                        tablero[x][y]=new Rey(" RR ",1,true);
                    else
                        tablero[x][y]=new Rey(" RR ",1,false);
                }else{
                    if(tablero[a][b] instanceof Rey && ((Rey)tablero[a][b]).movimientoL)
                        tablero[x][y]=new Rey(" RV ",2,true);
                    else
                        tablero[x][y]=new Rey(" RV ",2,false);
                }
                tablero[a][b]=new Object();
                tablero[a][b]="  - ";
                 return true;
            }else if((((x-a==2 || x-a==-2) && (y-b==1 || y-b==-1)) || ((x-a==1 || x-a==-1) && (y-b==2 || y-b==-2))) && (tablero[a][b] instanceof Rey && ((Rey)tablero[a][b]).movimientoL==true)){

                if(j==1)
                    tablero[x][y]=new Rey(" RR ",1,false);
                else
                    tablero[x][y]=new Rey(" RV ",2,false);
                System.out.println("Ha utilizado el movimiento especial mortal del Rey");
                tablero[a][b]=new Object();
                tablero[a][b]="  - ";
                return true;
            }else{
                System.out.println("Movimiento Invalido.");
                return false;
            }
        }else if(tablero[x][y] instanceof Piezas && ((Piezas)tablero[x][y]).jugador!=j){
            mostrarMensaje(x,y,a,b,j);
            if((x==a && (y-b==1 || y-b==-1)) || (y==b && (x-a==1 || x-a==-1)) || ((x-a==-1 || x-a==1) && (y-b==1 || y-b==-1))){
                tablero[a][b]=new Object();
                tablero[a][b]="  - ";
                if(j==1){
                    if(((Rey)tablero[x][y]).movimientoL)
                        tablero[x][y]=new Rey(" RR ",1,true);
                    else
                        tablero[x][y]=new Rey(" RR ",1,false);
                    Piezas.PiezasPerdidas2++;
                }else{
                    if(((Rey)tablero[x][y]).movimientoL)
                        tablero[x][y]=new Rey(" RV ",2,true);
                    else
                        tablero[x][y]=new Rey(" RV ",2,false);
                    Piezas.PiezasPerdidas2++;
                }
                return true;
            }else if(((x-a==2 || x-a==-2) && (y-b==1 || y-b==-1)) || ((x-a==1 || x-a==-1) && (y-b==2 || y-b==-2)) && (tablero[a][b] instanceof Rey && ((Rey)tablero[a][b]).movimientoL==true)){
                ((Rey)tablero[a][b]).movimientoL=false;
                tablero[a][b]=new Object();
                tablero[a][b]="  - ";
                if(j==1){
                    tablero[x][y]=new Rey(" RR ",1,false);
                    Piezas.PiezasPerdidas2++;
                }else{
                    tablero[x][y]=new Rey(" RV ",2,false);
                    Piezas.PiezasPerdidas1++;
                }
                System.out.println("Ha utilizado el movimiento especial mortal del Rey");
                
                return true;
            }else{
                System.out.println("Movimiento Invalido.");
                return false;
            }
        }else{
            System.out.println("Movimiento Invalido.");
            return false;
        }
    }
    
    public void mostrarMensaje(int x, int y, int a, int b,int j){
        String pieza1="", pieza2="";
        if(tablero[x][y] instanceof Piezas){
            if(tablero[a][b] instanceof Peones){
                pieza1="Peon";
            }else if(tablero[a][b] instanceof Caballos){
                pieza1="Caballo";
            }else if(tablero[a][b] instanceof Elefantes){
                pieza1="Elefante";
            }else if(tablero[a][b] instanceof Torres){
                pieza1="Torre";
            }else if(tablero[a][b] instanceof Rey){
                pieza1="Rey";
            }else if(tablero[a][b] instanceof Visir){
                pieza1="Visir";
            }
            if(tablero[x][y] instanceof Peones){
                pieza2="Peon";
            }else if(tablero[x][y] instanceof Caballos){
                pieza2="Caballo";
            }else if(tablero[x][y] instanceof Elefantes){
                pieza2="Elefante";
            }else if(tablero[x][y] instanceof Torres){
                pieza2="Torre";
            }else if(tablero[x][y] instanceof Rey){
                pieza2="Rey";
            }else if(tablero[x][y] instanceof Visir){
                pieza2="Visir";
            }
            
            if(j==1){
                System.out.println(this.nombreJ1+" se comio con la pieza "+pieza1+" a la pieza "+pieza2+ " del jugador "+this.nombreJ2);
                if(pieza2.equals("Rey")){
                    juegoTerminado=true;
                    
                }
            }else{
                System.out.println(this.nombreJ2+" se comio con la pieza "+pieza1+" a la pieza "+pieza2+ " del jugador "+this.nombreJ1);
                if(pieza2.equals("Rey")){
                    juegoTerminado=true;
                    
                }
            }
        }
    }
    public boolean terminarJuego(){
        if(this.juegoTerminado){
            System.out.println("Fin del Juego.");
            return true;
        }else{
            return false;
        }
    }
}
