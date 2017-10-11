/*
 * Copyright (C) 2017 Benjamin "12g" La Madrid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package model;

/**
 *
 * @author Benjamin "12g" La Madrid
 */
public class Album {

    private String[] pistas;
    private String nombre;
    private int añoLanzamiento;

    /**
     * Obtiene el nombre del álbum.
     * @return Un string conteniendo el nombre de dicho álbum.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Obtiene el año de lanzamiento del álbum.
     * @return El entero correspondiente al año de lanzamiento.
     */
    public int getAñoLanzamiento() {
        return añoLanzamiento;
    }
    
    /**
     * Obtiene la lista de canciones del álbum.
     * @return Un array de Strings, con todos los títulos de las pistas correspondientes.
     */
    public String[] getPistas() {
        return pistas;
    }
    
    /**
     * Cambia el nombre del álbum.
     * @param nombre El nuevo nombre del álbum.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Cambia el año de lanzamiento del álbum.
     * @param añoLanzamiento El año de lanzamiento al que se desea cambiar.
     */
    public void setAñoLanzamiento(int añoLanzamiento) {
        this.añoLanzamiento = añoLanzamiento;
    }

    /**
     * En el número especificado, agrega o reemplaza una canción al repertorio del álbum.
     * @param numero El número de la pista.
     * @param pista Un nombre de pista.
     */
    public void setPista(int numero, String pista){
        this.pistas[numero] = pista;
    }
    
    /**
     * Trunca el número de pistas del álbum a la cantidad especificada, evitando perder los nombres de éstas en la medida de lo posible.
     * @param numero El número de pistas deseado.
     */
    public void setCantidadPistas(int numero){
        String[] pistasAntiguo = this.pistas; //"respaldamos" el listado de pistas antiguo en una variable
        this.pistas = new String[numero]; //reiniciamos el listado real
        
        //obtenemos el largo del listado mas corto entre los dos...
        int iterador = (pistasAntiguo.length < numero)? pistasAntiguo.length : numero;
        //...para hacer la copia de los datos anteriores sin que hayan errores
        System.arraycopy(pistasAntiguo, 0, this.pistas, 0, iterador);
    }

    /**
     * Crea un objeto Album con una lista de canciones vacía.
     * @param nombre El nombre del álbum.
     * @param añoLanzamiento El año de lanzamiento del álbum.
     * @param numeroPistas La cantidad de pistas que el álbum tendrá.
     */
    public Album(String nombre, int añoLanzamiento, int numeroPistas) {
        this.pistas = new String[numeroPistas];
        setNombre(nombre);
        setAñoLanzamiento(añoLanzamiento);
    }
    
    /**
     * Crea un objeto Album con una lista de canciones completa.
     * @param nombre El nombre del álbum.
     * @param añoLanzamiento El año de lanzamiento del álbum.
     * @param pistas Todos los nombres de las pistas que el álbum tendrá, en formato de array de Strings.
     */
    public Album(String nombre, int añoLanzamiento, String[] pistas) {
        this.pistas = pistas;
        setNombre(nombre);
        setAñoLanzamiento(añoLanzamiento);
    }
    
}
