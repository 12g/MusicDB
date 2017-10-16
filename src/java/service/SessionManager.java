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
            sesion.setAttribute("email", email);
            sesion.setAttribute("password", password);
            return sesion;
        }
        return null;
    }
    
    public static HttpSession EliminarArtista (HttpSession sesion, int artistaID) {
        boolean problems = false;
        if (!problems) {
            List<Artista> artistas = (ArrayList<Artista>)sesion.getAttribute("artistas");
            artistas.remove( artistaID );
            return sesion;
        }
        return null;
    }

}
