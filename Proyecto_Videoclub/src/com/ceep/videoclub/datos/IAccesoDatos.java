
package com.ceep.videoclub.datos;

import com.ceep.videoclub.dominio.Pelicula;
import com.ceep.videoclub.excepciones.AccesoDatosExcepciones;
import com.ceep.videoclub.excepciones.EscrituraDatosEx;
import com.ceep.videoclub.excepciones.LecturaDatosEx;
import java.util.*;


public interface IAccesoDatos {
   //MÉTODOS PÚBLICOS Y ABSTRACTOS POR SER INTERFAZ
    /*EN LA CLASE QUE IMPLEMENTA A LA INTERFAZ DEFINIMOS ESTMOS MÉTODOS*/
    
    //Comprueba si el fichero existe
    boolean existe(String nombreArchivo); //va a poder generar una excepcion de accesoDatos ( de las tres que he creado)
    
    //Devuelve una lista de peliculas contenidas en el archivo nombreArchivo.
    List<Pelicula>listar(String nombreArchivo) throws LecturaDatosEx;
    
    //Escribe una nueva película en el archivo nombreArchivo
    //con el parámetro anexar podemos indicar si queremos agregar la película o sobreescribir
    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;
    
    //Busca la expresión de buscar en el archivo y nos muestra los mensajes
    //en caso de que lo encuentre o no.
    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;
    
    //Crea el archivo
    void crear(String nombreArchivo) throws AccesoDatosExcepciones ;
    
    //Borra el archivo
    void borrar(String nombreArchivo);
    
    
    
    
    
    
}


