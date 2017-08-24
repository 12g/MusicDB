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
    private int fechaNac;
    private boolean grupo;

    /**
     * Obtiene todos los álbumes del artista publicados.
     * @return Un objeto ArrayList con dichos álbumes del artista.
     */
    public List<Album> getAlbumes() {
        return albumes;
    }

    /**
     * Ingresa una nueva entrada en la lista de álbumes del artista.
     * @param album El objeto, de clase Album, a agregar a dicha lista.
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

    /**
     * Obtiene el nombre completo del artista.
     * @return Un string con el nombre del artista.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del artista.
     * @param nombre Un string conteniendo el nombre completo de dicho artista.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la fecha de nacimiento (o formación) del artista.
     * @return Un string en formato 'DD/MM/AAAA'.
     */
    public int getFechaNac() {
        return fechaNac;
    }

    /**
     * Cambia la fecha de nacimiento establecida del artista.
     * @param fecha Un String conteniendo una fecha en el formato 'DD/MM/AAAA'
     */
    public void setFechaNac(int fecha) {
        this.fechaNac = fecha;
    }

    /**
     * Este método responde la pregunta: ¿es este artista, un grupo o una persona?
     * @return true si es un grupo, false si es una persona
     */
    public boolean esGrupo() {
        return grupo;
    }

    /**
     * Configura el artista para ser un grupo o una persona
     * @param esGrupo true si es un grupo, false si es una persona
     */
    public void setEsGrupo(boolean esGrupo) {
        this.grupo = esGrupo;
    }

    /**
     * Crea un nuevo objeto Artista y crea una lista de álbumes vacía para éste.
     * @param nombre Nombre completo del artista
     * @param fecha Fecha, en formato 'DD/MM/AAAA'
     * @param grupo true si es un grupo, false si es una persona
     */
    public Artista(String nombre, int fecha, boolean grupo) {
        this.albumes = new ArrayList<Album>();
        setNombre(nombre);
        setFechaNac(fecha);
        setEsGrupo(grupo);
    }

    /**
     * Crea un nuevo objeto Artista y le asigna una lista de álbumes ya creada.
     * @param nombre Nombre completo del artista
     * @param fecha Fecha, en formato 'DD/MM/AAAA'
     * @param grupo true si es un grupo, false si es una persona
     * @param albumes 
     */
    public Artista(String nombre, int fecha, boolean grupo, ArrayList<Album> albumes) {
        this.albumes = albumes;
        setNombre(nombre);
        setFechaNac(fecha);
        setEsGrupo(grupo);
    }
    
}
