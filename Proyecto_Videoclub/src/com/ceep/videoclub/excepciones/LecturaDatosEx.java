
package com.ceep.videoclub.excepciones;


//LAS EXCEPCIONES SOLO SE ENCARGAN DE LANZAR EL MENSAJE DE LA EXCEPCION
//AQUI NO SE GESTIONA EL TRY CACTH
public class LecturaDatosEx extends AccesoDatosExcepciones{

    public LecturaDatosEx(String mensaje) {
        super(mensaje);
    }
    
}
