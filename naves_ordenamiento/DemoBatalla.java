/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naves_ordenamiento;

import java.util.*;


public class DemoBatalla {

	public static void main(String[] args) {
		Nave[] misNaves = new Nave[4];
		Scanner sc = new Scanner(System.in);

		String nomb, nombrebusqueda;
		int fil, punt, col, pos;
		boolean est;
                crearNavesAutomaticamente(misNaves);

		/*for (int i = 0; i < misNaves.length; i++) {
			System.out.println("Nave " + (i + 1));
			System.out.print("Nombre: ");
			nomb = sc.next();
			System.out.println("Fila ");
			fil = sc.nextInt();
			System.out.print("Columna: ");
			col = sc.nextInt();
			System.out.print("Estado: ");
			est = sc.nextBoolean();
			System.out.print("Puntos: ");
			punt = sc.nextInt();

			// Se crea un objeto Nave y se asigna su referencia a misNaves
			misNaves[i] = new Nave();
			misNaves[i].setNombre(nomb);
			misNaves[i].setFila(fil);
			misNaves[i].setColumna(col);
			misNaves[i].setEstado(est);
			misNaves[i].setPuntos(punt);
		}*/

		System.out.println("\nNaves creadas:");

		mostrarNaves(misNaves);
                System.out.println("\n"+"\n");
                //mostrarMatrizDeNaves(misNaves);
                
		// Hacer un menu para elegir que quiere mostrar
                System.out.println("DESEA INGRESAR AL MENÚ  «si» «no»");
                String menu = sc.next(); 
                int quever; 
                do {
                    
                    if(menu.equals("si")){
                        
                        System.out.println("¿QUÉ DESEA VER?\n 1.NAVE POR NOMBRE "
                                + "\n 2.NAVE POR PUNTOS \n 3.NAVES ALEATORIAS");
                        System.out.println("******ADICIONALES*******\n 4.ordenarPorPuntosBurbuja"
                                + "\n 5.ordenarPorNombreBurbuja\n 6.ordenarPorPuntosSeleccion"
                                + "\n 7.ordenarPorNombreSeleccion\n 8.ordenarPorPuntosInsercion"
                                + "\n 9.ordenarPorNombreInsercion\n 10.busquedaBinariaNombre");
                        quever = sc.nextInt();
                        
                        switch (quever) {
                            case 1:
                                System.out.println("\n");
                                mostrarPorNombre(misNaves);
                                break;
                            case 2:
                                System.out.println("\n");
                                mostrarPorPuntos(misNaves);
                                break;
                            case 3:
                                System.out.println("\n");
                                mostrarNaves(NuevoArregloAleatorio(misNaves));
                                break;
                            case 4:
                                System.out.println("\n");
                                ordenarPorPuntosBurbuja(misNaves);
                                mostrarNaves(misNaves);
                                break;
                            case 5:
                                System.out.println("\n");
                                ordenarPorNombreBurbuja(misNaves);
                                mostrarNaves(misNaves);
                                break;
                            case 6:
                                System.out.println("\n");
                                ordenarPorPuntosSeleccion(misNaves);
                                mostrarNaves(misNaves);
                                break;
                            case 7:
                                System.out.println("\n");
                                ordenarPorNombreSeleccion(misNaves);
                                mostrarNaves(misNaves);
                                break;
                            case 8:
                                System.out.println("\n");
                                ordenarPorPuntosInsercion(misNaves);
                                mostrarNaves(misNaves);
                                break;   
                            case 9:
                                System.out.println("\n");
                                ordenarPorNombreInsercion(misNaves);
                                mostrarNaves(misNaves);
                                break;
                            case 10:
                                System.out.println("*Se ordenó por nombre automáticamente*");
                                ordenarPorNombreInsercion(misNaves);
                                System.out.println("Ingrese nombre: ");
                                nombrebusqueda = sc.next();
                                System.out.println("");
                                pos = busquedaBinariaNombre(misNaves,nombrebusqueda);
                                System.out.println("pos  "+pos);
                                if(pos>=0){
                                System.out.println("La nave "+(pos+1)+" es: "+misNaves[pos].getNombre()+" con "
                        +misNaves[pos].getPuntos()+" puntos y de estado "+misNaves[pos].getEstado());
                                }
                                 else{
                                System.out.println("No se ha encontrado la nave");
                                }
                                break;    
                            default:
                                break;
                        }
                    }
                    System.out.println("\n");
                    System.out.println("¿DESEA MOSTRAR ALGO MÁS? «si» «no»");
                    menu = sc.next(); 
                }
                while(menu.equals("si"));

	}
        public static void crearNavesAutomaticamente(Nave[] misNaves) {
            
            Random random = new Random();
            
                String nomb;
		int fil, punt, col;
		boolean est;
            
            for (int i = 0; i < misNaves.length; i++) {
			
                        char carac = (char) (random.nextInt(26) + 'a');
			nomb = carac+"Nave";
			
			fil = i;
			
			col = i;
			
			est = true;
			
			punt = (int) (Math.random()*100+1);

			// Se crea un objeto Nave y se asigna su referencia a misNaves
			misNaves[i] = new Nave();
			misNaves[i].setNombre(nomb);
			misNaves[i].setFila(fil);
			misNaves[i].setColumna(col);
			misNaves[i].setEstado(est);
			misNaves[i].setPuntos(punt);
		}
            
        }

	// M�todo para mostrar todas las naves
        
	public static void mostrarNaves(Nave[] flota) {
            
            System.out.println("LAS NAVES SON LAS SIGUIENTES: ");
            
            for (int i = 0; i < flota.length; i++){
                
                System.out.println("La nave "+(i+1)+" es: "+flota[i].getNombre()+" con "
                        +flota[i].getPuntos()+" puntos y de estado "+flota[i].getEstado());
                
            }
	}

	// M�todo para mostrar todas las naves de un nombre que se pide por teclado
	public static void mostrarPorNombre(Nave[] flota) {
            
            Scanner sc = new Scanner(System.in);
            
            System.out.println("INGRESE NOMBRE: ");
            String nombre= sc.next();
            
            int cantidad=0;
            
            for (int i = 0; i < flota.length; i++) {
                
                if(nombre.equals(flota[i].getNombre())){
                    
                    cantidad++;
                    System.out.println("SE HA ENCONTRADO ESTA NAVE: ");
                    System.out.println("La nave "+(i+1)+" es: "+flota[i].getNombre()+" con "
                        +flota[i].getPuntos()+" puntos y de estado "+flota[i].getEstado());
                }
            }
            System.out.println("SE HAN ENCONTRADO "+cantidad+" NAVES");
	}

	// M�todo para mostrar todas las naves con un n�mero de puntos inferior o igual
	// al n�mero de puntos que se pide por teclado
        
	public static void mostrarPorPuntos(Nave[] flota) {
            
            Scanner sc = new Scanner(System.in);
            
            System.out.println("INGRESE CANTIDAD DE PUNTOS: ");
            int nombre= sc.nextInt();
            
            int cantidad=0;
            
            for (int i = 0; i < flota.length; i++) {
                
                if(nombre==flota[i].getPuntos()){
                    
                    cantidad++;
                    System.out.println("SE HA ENCONTRADO ESTA NAVE: ");
                    System.out.println("La nave "+(i+1)+" es: "+flota[i].getNombre()+" con "
                        +flota[i].getPuntos()+" puntos y de estado "+flota[i].getEstado());
                }
            }
            System.out.println("SE HAN ENCONTRADO "+cantidad+" NAVES");
	}

	// M�todo que muestra las naves de forma matricial
	public static void mostrarMatrizDeNaves(Nave[] flota) {
            
            System.out.println("                       ***LAS NAVES****");
            
            System.out.println("\n");
        
            int columna=0, fila=0;
                    
            for (int i = 0; i < flota.length; i++) {
                if (flota[i].getColumna() > columna) {
                    columna = flota[i].getColumna();
                }
                if (flota[i].getFila() > fila) {
                    fila = flota[i].getFila();
                }
            }
            
            String [][] A = new String[fila][columna];
            
            for (int i = 0; i < flota.length; i++) {
                 A[flota[i].getFila()-1][flota[i].getColumna()-1]= flota[i].getNombre();
            }
            
            for (String[] A1 : A) {
                for (String item : A1) {
                    System.out.print(item + "              ");
                }
                System.out.println();
            }
            System.out.println("\n");

    }
        public static Nave[] NuevoArregloAleatorio(Nave[] flota) {
            
            Nave[] flo = new Nave[flota.length];
            
            for (int i = 0; i < flota.length; i++) {
                
                flo[i]=flota[i];
            
            }
            Nave cambiar;
            
            for (int i = 0; i < flota.length; i++) {
                int n = (int) (Math.random() * (flota.length - 1) +1);
                cambiar = flo[i];
                flo[i] = flo[n];
                flo[n] = cambiar;
            }
            
            return flo; 
            
	}
        
        
        
        
        //ADICIONALES
        
        
        
        
        
        
        public static void ordenarPorPuntosBurbuja(Nave[] flota){
            
            Nave aux;
            
            for(int i=0; i< (flota.length -1); i++){
            
            for(int k=0; k<(flota.length -1); k++){
                
                if(flota[k].getPuntos()>flota[k+1].getPuntos()){
                    
                    aux = flota[k];
                    flota[k]= flota[k+1];
                    flota[k+1] = aux;
                    
                }
            }   
        }
            
        }
        
        
        public static void ordenarPorNombreBurbuja(Nave[] flota){
            
            
            int c;
            Nave nav;
        
            for(int i=0; i< (flota.length-1); i++){
            
                for(int k=0; k<(flota.length-1); k++){
                    c= flota[k].getNombre().compareTo(flota[k+1].getNombre());
                    
                    if(c>0){
                        nav = flota[k];
                        flota[k]= flota[k+1];
                        flota[k+1] = nav;
                    
                    }
                }   
        }
    }
        

        
        public static int busquedaBinariaNombre(Nave[] flota, String nombre){
            
        int alta= flota.length -1, baja=0, media;
        while(baja<= alta){
            
            media = (baja + alta)/2;
            if (flota[media].getNombre().compareTo(nombre)==0){
                
                return media;
            }
            else {
                if(flota[media].getNombre().compareTo(nombre)>0){
                    alta = media-1;
                }
                else{
                    baja = media+1;
                }
            }
            
        }
        return -1; 
        
    }
        
        
        
        public static void ordenarPorPuntosSeleccion(Nave[] flota){
            
            
            int posciondelmenor;
            
            Nave cambiar;
        
            for (int i = 0; i < flota.length; i++) {
            
            posciondelmenor= i;
            
            for (int j = (i+1); j < flota.length  ; j++) {
                
                if(flota[j].getPuntos() < flota[posciondelmenor].getPuntos()){
                    
                    posciondelmenor=j;
                }
                
            }
            
            cambiar = flota[i];
            flota[i] = flota[posciondelmenor]; 
            flota[posciondelmenor] = cambiar; 
        }
        
        
        }
        
        public static void ordenarPorNombreSeleccion(Nave[] flota){
         
            int posciondelmenor, c;
            
            Nave cambiar;
            
        
            for (int i = 0; i < flota.length; i++) {
            
                posciondelmenor= i;
            
                for (int j = (i+1); j < flota.length  ; j++) {
                    
                    c=flota[j].getNombre().compareTo(flota[posciondelmenor].getNombre());
                    
                    if(c <= 0){
                    
                        posciondelmenor=j;
                    }
                }
            
                cambiar = flota[i];
                flota[i] = flota[posciondelmenor]; 
                flota[posciondelmenor] = cambiar; 
            }
        
        }
        
        public static void ordenarPorPuntosInsercion(Nave[] flota){
            
            int posicion;
            Nave NaveACambiar;
        
            for (int i = 0; i < flota.length ; i++){
            
                posicion = i;
                NaveACambiar = flota[i];
            
                while (posicion>0 && flota[posicion-1].getPuntos()>NaveACambiar.getPuntos()){
                
                    flota[posicion] = flota[posicion-1];
                    posicion--;
                }
            
                flota[posicion]= NaveACambiar;
                
            }
        }
        
        public static void ordenarPorNombreInsercion(Nave[] flota){
            
            int posicion, c=0;
            Nave NaveACambiar;
        
            for (int i = 0; i < flota.length ; i++){
            
                posicion = i;
                NaveACambiar = flota[i];
                if(posicion>0){
                 
                    c = flota[posicion-1].getNombre().compareTo(NaveACambiar.getNombre());
                }
                while (posicion>0 && c>=0){
                
                    flota[posicion] = flota[posicion-1];
                    posicion--;
                }
            
                flota[posicion]= NaveACambiar;
                
            }
        }



        
        
        
}