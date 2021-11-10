package com.ceep.videoclub.datos;

import com.ceep.videoclub.dominio.Pelicula;
import com.ceep.videoclub.excepciones.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.*;

//CAPA QUE REALIZA  LAS OPERACIONES SOBRE EL FICHERO
//HACE USO DE LA CLASE PELÍCULA, CONVIERTE LAS LÍENAS DE FICHERO EN OBJETOS PELÍCULA.
//UNICA CAPA QUE TIENE ACCESO A LOS DATOS DEL FICHERO/BBDD
//ÚNICA CAPA QUE MANEJA EL ACCESO A LA INFORMACIÓN
public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) {

        File archivo = new File(nombreArchivo);
        return archivo.exists(); //metodo que devuelve un boolean
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        Pelicula pelicula = null;
        List<Pelicula> arrayMisPeliculas = new ArrayList<>();

        try {
            //ENTRADA ES EL DESCRIPTOR DE LECTURA
            var entrada = new BufferedReader(new FileReader(archivo)); //clase para leer archivos y filereader leer todo
            //DEVUELVE UNA LÍNEA DEL ARCHIVO
            var lectura = entrada.readLine();
            while (lectura != null) { // HASTA NULL
                //CUANDO ENCUENTRA UNA PELICULA, CREA EL OBJETO, creo objeto con cada línea del archivo
                //Añado cada pelicula/objeto a mi array de peliculas
                arrayMisPeliculas.add(new Pelicula(lectura));
                //AVANZAMOS EN LA LECTURA
                lectura = entrada.readLine();
            }
            entrada.close();

        } catch (FileNotFoundException e) { //cuando no encuentra un archivo
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando las películas"); // genero el mensaje de la excepciuón
        } catch (IOException e) { //error de entrada/salida
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error de lectura listando las películas");
        }
        return arrayMisPeliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        //declarar objeto 
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(nombreArchivo, true)); //para que no sobreescriba la informacion la agrega
            salida.println(pelicula.getNombre());
            salida.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new EscrituraDatosEx("Error de escritura al introducir la película"); // genero el mensaje de la excepciuón
        } catch (IOException e) { //excepciones de lectura/escritura
            e.printStackTrace(System.out);
            throw new EscrituraDatosEx("Error de escritura al introducir la película"); // genero el mensaje de la excepciuón
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        /* var archivo = new File(nombreArchivo); //instancio objeto tipo archovo
        var resultado = "";
        try {
            var entrada = new BufferedReader(new FileReader(archivo));//entrada es el descriptor de lectura
            var lectura = entrada.readLine();//nos devuelve una linea de nuestro archivo 
            int cont = 1; //xq empieza en 0
            while (!lectura.equalsIgnoreCase(buscar)) { //mientras no sean iguales
                cont++;
                lectura = entrada.readLine();// Avanzamos en la lectura
            }
            resultado = "\nLa pelicula: " + buscar + ", está en la posición " + cont;
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return resultado;*/
        var archivo = new File(nombreArchivo);
        int cont = 1;
        String mensaje = "";
        try {
            var entrada = new BufferedReader(new FileReader(archivo));//entrada es el descriptor de lectura
            var lectura = entrada.readLine();//nos devuelve una linea de nuestro archivo 
            while (lectura != null) { //mientras no sean iguales
                if (!lectura.equalsIgnoreCase(buscar)) {
                    mensaje = "La pelicula " + buscar + "Se encuantra en la linea " + cont + " del catálogo de películas";
                    break;
                }
                lectura = entrada.readLine();
                cont++;
            }
            if (lectura == null) {
                mensaje = "La pelicula " + buscar + " no está en el catálogo";
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error en el listado de las peliculas (FNE desde buscar de AcceoDatos Imp)");
        } catch (IOException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Error en el listado de las peliculas (IO desde buscar de AcceoDatos Imp)");
        }
        return mensaje; // retunr resultado
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosExcepciones {
        //Declaro un objeto de tipo File
        var archivo = new File(nombreArchivo);
        // PrintWriter clase que me permite escribir sobre el archivo

        try {
            var salida = new PrintWriter(new FileWriter(archivo));
            //Ya esta creado el archivo
            salida.close(); //cerrar el archivo          
        } catch (Exception e) { //excepcion por si no está el fichero
            e.printStackTrace(System.out);
            throw new AccesoDatosExcepciones("Error al crear el archivo");
        }
    }

    @Override
    public void borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
        System.out.println("Se ha borrado el archivo");
    }

}


