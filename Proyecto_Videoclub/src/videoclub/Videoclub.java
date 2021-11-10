package videoclub;

import com.ceep.videoclub.dominio.Pelicula;
import com.ceep.videoclub.negocio.*;
import java.util.Scanner;

public class Videoclub {
    
    public static void main(String[] args) {
        var nombreCatalogo = "VideoClub.txt";
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
        
        while (true) {
            System.out.println("\t*** VIDEOCLUB ***");
            System.out.println(" 1.- Iniciar Catálogo de películas");
            System.out.println(" 2.- Agregar pelicula");
            System.out.println(" 3.- Listar peliculas");
            System.out.println(" 4.- Buscar pelicula");
            System.out.println(" 0.- Salir");
            System.out.print("Indica la opción deseada: ");
            Scanner sn = new Scanner(System.in);
            int opcion = sn.nextInt();
            
            switch (opcion) {
                case 1:
                    catalogo.iniciarCatálogo(nombreCatalogo);
                    System.out.println("Catálogo iniciado");
                    break;
                case 2:
                    System.out.print("Introduce el nombre de la pelicula a agregar:\t");
                    Scanner dato = new Scanner(System.in);
                    String nombrePelicula = dato.nextLine();
                    catalogo.agregarPelicula(nombrePelicula, nombreCatalogo);                   
                    break;
                case 3:
                    catalogo.ListarPelicula(nombreCatalogo);
                    break;
                case 4:
                    System.out.printf("Intorduce el nombre de la película a buscar: ");
                    Scanner busqueda = new Scanner(System.in);
                    String buscar = busqueda.nextLine();
                    catalogo.buscarPelicula(nombreCatalogo, buscar);                   
                    break;
                case 0:
                    System.out.println("Gracias!, hasta la próxima");
                    break;
                default:
                        System.out.println("Opción desconocida.");
                
            }
        }
        
    }
    
}
