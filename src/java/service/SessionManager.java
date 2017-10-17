/*
 * Copyright (C) 2017 cetecom
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
package service;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import model.Artista;

/**
 *
 * @author cetecom
 */
public class SessionManager {

    public static HttpSession Login (HttpSession sesion, String email, String password){
        boolean problems = false;
        if (!problems) {
            List<Artista> artistas;
            
            artistas = LlenarListaConEjemplos(new ArrayList<>());
            
            sesion.setAttribute("artistas", artistas);
            sesion.setAttribute("email", email);
            sesion.setAttribute("password", password);
            
            return sesion;
        }
        return null;
    }
    
    public static HttpSession EliminarArtista (HttpSession sesion, int artistaID) {
        boolean problems = false;
        if (!problems) {
            List<Artista> artistas;
            
            artistas = (ArrayList<Artista>)sesion.getAttribute("artistas");
            
            artistas.remove( artistaID );
            sesion.setAttribute("artistas", artistas);
            return sesion;
        }
        return null;
    }
    
    public static Artista ObtenerArtista (HttpSession sesion, int artistaID) {
        boolean problems = false;
        if (!problems) {
            List<Artista> artistas;
            Artista rt;
            
            artistas    = (ArrayList<Artista>)(sesion.getAttribute("artistas"));
            rt          = artistas.get( artistaID );
            return rt;
        }
        return null;
    }
    
    public static HttpSession CrearArtista (HttpSession sesion, String nombre, int año) {
        boolean problems = false;
        if (!problems) {
            List<Artista> artistas;
            Artista nuevo;
            
            artistas    = (ArrayList<Artista>)(sesion.getAttribute("artistas"));
            nuevo       = new Artista(nombre, año);
            
            artistas.add(nuevo);
            sesion.setAttribute("artistas", artistas);
           
            return sesion;
        }
        return null;
    }

    /**
     * Añade los siguientes artistas a una lista:
     * Black Sabbath, David Bowie, Neutral Milk Hotel, Juan Gabriel
     * @param artistas La lista a la cual agregar estos objetos Artista.
     * @return La lista que fue puesta como parámetro del método.
     */
    private static List<Artista> LlenarListaConEjemplos(List<Artista> artistas) {
        artistas.add(new Artista("Black Sabbath", 1968));
        artistas.add(new Artista("David Bowie", 1947));
        artistas.add(new Artista("Neutral Milk Hotel", 1989));
        artistas.add(new Artista("Juan Gabriel", 1950));
        return artistas;
    }
}
