
package com.ceep.videoclub.negocio;


public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

    @Override
    public void agregarPelicula(String nombre, String nombreArchivo) {
        System.out.println("Agregando Peliculas");
    }

    @Override
    public void ListarPelicula(String nombreArchivo) {
        System.out.println("Listando Peliculas");
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
        System.out.println("Buscando Peliculas");
    }

    @Override
    public void iniciarPelicula(String nombreArchivo) {
       System.out.println("Iniciando Peliculas");
    }
    
}
