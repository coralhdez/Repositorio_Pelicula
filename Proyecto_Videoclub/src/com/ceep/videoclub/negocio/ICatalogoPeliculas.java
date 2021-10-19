
package com.ceep.videoclub.negocio;


public interface ICatalogoPeliculas {
     
    void agregarPelicula(String nombre, String nombreArchivo);
    
    void ListarPelicula(String nombreArchivo);
    
    void buscarPelicula(String nombreArchivo, String buscar);
    
    void iniciarPelicula(String nombreArchivo);
    
    
    
            
}
