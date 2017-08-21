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
package music_db;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Benjamin "12g" La Madrid
 */
public class Artista {
    
    private List<Album> albumes;
    private String nombre;
    private String fechaNac;
    private boolean grupo;

    /**
     * Obtiene todos los álbumes del artista.
     * @return La lista de álbumes del artista, en forma de un objeto ArrayList.
     */
    public List<Album> getAlbumes() {
        return albumes;
    }

    /**
     * Ingresa una nueva entrada en la lista de álbumes del artista.
     * @param album El objeto de clase Album a agregar.
     */
    public void addAlbum(Album album) {
        this.albumes.add(album);
    }

    /**
     * Elimina una entrada de la lista de álbumes del artista.
     * @param index El número que identifica esta entrada.
     */
    public void removeAlbum(int index) {
        this.albumes.remove(index);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fecha) {
        this.fechaNac = fecha;
    }

    public boolean isGrupo() {
        return grupo;
    }

    public void setEsGrupo(boolean esGrupo) {
        this.grupo = esGrupo;
    }

    public Artista(String nombre, String fecha, boolean grupo) {
        albumes = new ArrayList<Album>();
        setNombre(nombre);
        setFechaNac(fecha);
        setEsGrupo(grupo);
    }

    public Artista(String nombre, String fecha, boolean grupo, ArrayList<Album> albumes) {
        this.albumes = albumes;
        setNombre(nombre);
        setFechaNac(fecha);
        setEsGrupo(grupo);
    }
    
    
}
