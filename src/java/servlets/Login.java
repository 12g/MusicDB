/*
 * Copyright (C) 2017 benjamin
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
package servlets;

import java.io.IOException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author benjamin
 */
public class Login {

    public static HttpSession Do (HttpSession sesion, String email, String password){
        boolean problems = false;
        if (!problems) {
            sesion.setAttribute("email", email);
            sesion.setAttribute("password", password);
            return sesion;
        }
        return null;
    }

}
