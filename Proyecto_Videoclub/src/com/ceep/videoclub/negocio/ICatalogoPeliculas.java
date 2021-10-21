
package com.ceep.videoclub.negocio;

// CAPA DE LA LÓGICA
// ME DEVUELVEN LOS OBJETOS DE LAS PELICULAS
//CAPA QUE ME IMPRIME LA INFO UNA VEZ CREADOS LOS OBJETOS DE PELICULAS POR LA CAPA DE DATOS -> PELICULA

public interface ICatalogoPeliculas {
     
    //Agregar una película al catálogo
    void agregarPelicula(String nombrePelicula, String nombreCatalogo);
    
    //Mostrar todas las películas del catalogo
    void ListarPelicula(String nombreCatalogo);
    
    //Busca la película "Buscar" en nuestro catálogo
    void buscarPelicula(String nombreCatalogo, String buscar);
    
    //Inicia nuestro catálogo
    void iniciarCatálogo(String nombreCatalogo);
    
    
    
            
}
