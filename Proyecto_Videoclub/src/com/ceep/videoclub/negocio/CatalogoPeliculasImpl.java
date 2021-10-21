package com.ceep.videoclub.negocio;

//EN ESTA CLASE TRABAJO CON LOS OBJETOS CREADOS, NO CON ARCHIVOS, TRABAJO CON LA CLASE DE PELÍCULA Y ACCESODATOS
import com.ceep.videoclub.datos.AccesoDatosImpl;
import com.ceep.videoclub.datos.*;
import com.ceep.videoclub.dominio.Pelicula;
import com.ceep.videoclub.excepciones.AccesoDatosExcepciones;
import com.ceep.videoclub.excepciones.EscrituraDatosEx;
import com.ceep.videoclub.excepciones.LecturaDatosEx;
import java.io.File;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

    private final IAccesoDatos datos;  //Para acceder a las operaciones de la interfaz
    //creo esta variable para poder acceder a los metodos de la clase de accesoDatos y con el hago la comunicación.

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreCatalogo) {
        //Pelicula pelicula = new Pelicula(nombrePelicula);

        try {
            if (this.datos.existe(nombreCatalogo)) {
                this.datos.escribir(new Pelicula(nombrePelicula), nombreCatalogo, true);
            } else {
                System.out.println("Catálogo no inicializado");
            }
        } catch (EscrituraDatosEx ex) {
            System.out.println("Error al escribir en el catálogo");
            ex.printStackTrace(System.out); //imprime todo el listado de excepciones que se pudieran haber generado
        }

    }

    @Override
    public void ListarPelicula(String nombreCatalogo) {
        List<Pelicula> arrayPeliculas = new ArrayList<>();

        try {
            arrayPeliculas = this.datos.listar(nombreCatalogo);//me tiene que devolver un ArrayList
            arrayPeliculas.forEach(pelicula -> {
                System.out.println("pelicula = " + pelicula.getNombre());
            });
        } catch (LecturaDatosEx ex) {
            System.out.println("Error leyendo el catálogo");
            ex.printStackTrace(System.out); //imprime todo el listado de excepciones que se pudieran haber generado
        }

    }

    @Override
    public void buscarPelicula(String nombreCatalogo, String buscar) {
        //Su misión es imprimir el mensaje de la capa de AcesoDatos
        try {
            System.out.println(this.datos.buscar(nombreCatalogo, buscar));
        } catch (AccesoDatosExcepciones ex) {
            System.out.println("Error al buscar en el catálogo una película");
            ex.printStackTrace(System.out);
        }

    }

    @Override
    //crear el catalogo
    public void iniciarCatálogo(String nombreCatalogo) {
        try {
            if (this.datos.existe(nombreCatalogo)) {
                this.datos.borrar(nombreCatalogo); //si ya existiese lo borro y lo creo de nuevo y asi lo tengo vacío
                this.datos.crear(nombreCatalogo);
            } else {
                this.datos.crear(nombreCatalogo);
            }
        } catch (AccesoDatosExcepciones ex) {
            System.out.println("Error al crear en el catálogo una película");
            ex.printStackTrace(System.out);
        }
    }

}
