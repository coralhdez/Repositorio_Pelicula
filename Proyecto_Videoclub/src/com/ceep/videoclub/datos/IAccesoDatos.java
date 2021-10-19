
package com.ceep.videoclub.datos;


public interface IAccesoDatos {
    //metodos existe, escribir, listar, buscar, crear
    
    void existe(String nombreArchivo);
    
    void listar(String nombreArchivo);
    
    void crear(String nombreArchivo);
    
    void buscar(String nombreArchivo);
    
    
}


/*

//metodos EXISTE (String): boolean y LISTAR
    
    public boolean existe(String nombreArchivo){
        var a=0;
        return true;
    }
    
    public String listar(String nombreArchivo){
        //array List películar
        return nombreArchivo;
    }
    
    public void escribir(boolean anexar){
        
    }
    
    public String crear(String nombreArchivo){
        //
        return nombreArchivo;
    }
    public String buscar(String nombreArchivo){
        //
        return nombreArchivo;
    }
*/