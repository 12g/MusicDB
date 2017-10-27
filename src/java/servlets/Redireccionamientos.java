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
package servlets;

import service.SessionManager;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dto.*;

/**
 *
 * @author Benjamin "12g" La Madrid
 */
public class Redireccionamientos extends HttpServlet {

    /**
     * Procesa peticiones con los métodos <code>GET</code> y <code>POST</code>.
     *
     * @param peticion La petición recibida.
     * @param respuesta La respuesta a mandar.
     * @throws ServletException si ocurriera un error de servlet.
     * @throws IOException si ocurriera un error del sistema entrada/salida
     */
    protected void processRequest(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException {

        boolean usarPracticaHTTP303 = false;

        respuesta.setContentType("text/html;charset=UTF-8");

        //La URL que el usuario hubiese ingresado o a la que haya sido enviado
        String contexto = peticion.getContextPath(); // debiera ser siempre /MusicWiki en esta app web
        String servletSolicitado = peticion.getRequestURI().replace(contexto, "");
        String mapeoWebXMLDespacho;
        HttpSession sesion = peticion.getSession(false); //Obtiene la sesion
        if (sesion == null && !servletSolicitado.equals("/login")) {
            mapeoWebXMLDespacho = "/jsp/login";
        } else {
            switch (servletSolicitado) {
                case "/login": {
                    mapeoWebXMLDespacho = redireccionarInicio(sesion, peticion);
                    break;
                }
                case "/crear_artista": {
                    mapeoWebXMLDespacho = redireccionarCreacionArtista(peticion, sesion);
                    break;
                }
                case "/ver_artista": {
                    mapeoWebXMLDespacho = redireccionarDetallesArtista(peticion, sesion);
                    break;
                }
                case "/borrar_artista": {
                    mapeoWebXMLDespacho = redireccionarEliminacionArtista(peticion, sesion);
                    break;
                }
                case "/buscar_artista": {
                    mapeoWebXMLDespacho = redireccionarBusquedaArtista();
                    break;
                }
                default: {
                    mapeoWebXMLDespacho = "/jsp/error";
                    break;
                }
            }
        }

        //Código extra - Una microinvestigación en buenas prácticas
        if (usarPracticaHTTP303) {
            respuesta = etiquetarRedireccion303(respuesta, contexto, mapeoWebXMLDespacho);
        } else {
            RequestDispatcher redireccionador;

            //Mandamos al cliente a la página
            redireccionador = peticion.getRequestDispatcher(mapeoWebXMLDespacho);
            redireccionador.forward(
                    peticion, 
                    respuesta
            );
        }
        //Aquí termina el proceso de redirección
    }

    private String redireccionarInicio(HttpSession sesion, HttpServletRequest peticion) {
        String mapeoWebXMLDespacho = "/jsp/login";
        if (sesion == null) {
            String f_email = peticion.getParameter("email");
            String f_password = peticion.getParameter("password");
            
            if (f_email != null && f_password != null && !f_email.isEmpty() && !f_password.isEmpty()) {
                sesion = SessionManager.Login(sesion, f_email, f_password);
                System.out.println("Login exitoso con mail '" + f_email + "' y contraseña '" + f_password + "'");
                if (sesion != null) {
                    mapeoWebXMLDespacho = "/jsp/artista/todos";
                }
            }
        } else {
            mapeoWebXMLDespacho = "/jsp/artista/todos";
        }
        return mapeoWebXMLDespacho;
    }

    private String redireccionarDetallesArtista(HttpServletRequest peticion, HttpSession sesion) throws NumberFormatException {
        String mapeoWebXMLDespacho = "/jsp/artista/todos";
        String idArtista = peticion.getParameter("id");
        if (idArtista != null) {
            ArtistaDTO artistaEncontrado = SessionManager.ObtenerArtista(sesion, Integer.parseInt(idArtista));
            
            mapeoWebXMLDespacho = "/jsp/artista/ver";
            peticion.setAttribute("nombre", artistaEncontrado.getNombre());
            peticion.setAttribute("año", artistaEncontrado.getFechaNacimiento());
        }
        return mapeoWebXMLDespacho;
    }

    private String redireccionarCreacionArtista(HttpServletRequest peticion, HttpSession sesion) throws NumberFormatException {
        String mapeoWebXMLDespacho = "/jsp/artista/crear";
        String f_nombre = peticion.getParameter("nombre");
        String f_año = peticion.getParameter("ano");
        if (f_nombre != null && f_año != null) {
            sesion = SessionManager.CrearArtista(sesion, f_nombre, Integer.parseInt(f_año));
            mapeoWebXMLDespacho = "/jsp/artista/todos";
        }
        return mapeoWebXMLDespacho;
    }

    private String redireccionarEliminacionArtista(HttpServletRequest peticion, HttpSession sesion) throws NumberFormatException {
        String mapeoWebXMLDespacho = "/jsp/artista/todos";
        String idArtista = peticion.getParameter("id");
        if (idArtista != null) {
            String confirmar = peticion.getParameter("confirm");
            if (confirmar.equals("true")) {
                sesion = SessionManager.EliminarArtista(sesion, Integer.parseInt(idArtista));
            }
            else {
                mapeoWebXMLDespacho = "/jsp/artista/borrar";
                peticion.setAttribute("id", idArtista);
            }
        }
        return mapeoWebXMLDespacho;
    }
    
    private String redireccionarBusquedaArtista() {
        String mapeoWebXMLDespacho = "/jsp/artista/buscar";
        return mapeoWebXMLDespacho;
    }

    /**
     * Redirecciona la petición, devolviendo un código de respuesta 303. Esto
     * es, recibe la información de un formulario y manda al usuario a realizar
     * otra petición para recibir su información.
     *
     * @param respuesta La repsuesta.
     * @param mapeoWebXMLDespacho la URL que el usuario va a tener que
     * solicitar.
     * @return
     */
    private HttpServletResponse etiquetarRedireccion303(HttpServletResponse respuesta, String contexto, String mapeoWebXMLDespacho) {
        //Ponemos el código de respuesta
        respuesta.setStatus(303);
        //y setHeader nos permite MANDAR ese código al usuario
        respuesta.setHeader("Location", contexto + mapeoWebXMLDespacho);
        return respuesta;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
