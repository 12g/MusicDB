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

    private String nombre;
    private int añoLanzamiento;

    
    public String getNombre() {
        return nombre;
    }
    
    public int getAñoLanzamiento() {
        return añoLanzamiento;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setAñoLanzamiento(int añoLanzamiento) {
        this.añoLanzamiento = añoLanzamiento;
    }
    
    public Album(String nombre, int añoLanzamiento) {
        setNombre(nombre);
        setAñoLanzamiento(añoLanzamiento);
    }
    
}
