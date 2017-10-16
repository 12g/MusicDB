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

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Artista;

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
        String contexto = peticion.getContextPath(); 
        String servletSolicitado = peticion.getRequestURI().replace(contexto, ""); 
        String mapeoWebXMLDespacho;
        HttpSession sesion = peticion.getSession(); //Obtiene o crea la sesion
        switch (servletSolicitado) {
            case "/login/confirmar":
            {
                String formulario_email, formulario_password;
                
                formulario_email = peticion.getParameter("email");
                formulario_password = peticion.getParameter("password");
                
                //mandamos la información con el Login.Do
                if ((sesion = Login.Do(sesion, formulario_email, formulario_password)) != null) {
                    List<Artista> artistas = llenarListaConEjemplos(new ArrayList<>());
                    sesion.setAttribute("artistas", artistas);

                    mapeoWebXMLDespacho = "/jsp/artista/todos";
                    System.out.println(mapeoWebXMLDespacho);
                    break;
                }
                //sin break, esto se va al case default
            }
            case "/artista/borrar":
            {
                int idArtista;
                
                idArtista = Integer.valueOf( peticion.getParameter("id") );
                
                mapeoWebXMLDespacho = "/jsp/artista/borrar";
                peticion.setAttribute("id", idArtista);
                break;
            }
            case "/artista/buscar":
            {
                mapeoWebXMLDespacho = "/jsp/artista/buscar";
                break;
            }
            case "/artista/crear":
            {
                mapeoWebXMLDespacho = "/jsp/artista/crear";
                break;
            }
            case "/artista/ver":
            {
                List<Artista> todosMisArtistas;
                int idArtista;
                Artista artistaEncontrado;
                String nombreArtista;
                int añoArtista;

                todosMisArtistas    = (ArrayList<Artista>)sesion.getAttribute("artistas");
                idArtista           = Integer.valueOf(peticion.getParameter("id"));
                artistaEncontrado   = todosMisArtistas.get(idArtista);
                nombreArtista       = artistaEncontrado.getNombre();
                añoArtista          = artistaEncontrado.getFechaNac();

                mapeoWebXMLDespacho = "/jsp/artista/ver";
                peticion.setAttribute("nombre", nombreArtista);
                peticion.setAttribute("año", añoArtista);
                break;
            }
            case "/artista/borrar/no":
            {
                mapeoWebXMLDespacho = "/jsp/artista/todos";
                break;
            }
            default:
            {
                mapeoWebXMLDespacho = "/jsp/error";
                break;
            }
        }

        
        //Código extra - Una microinvestigación en buenas prácticas
        if (usarPracticaHTTP303) {
            respuesta = etiquetarRedireccion303 (respuesta, mapeoWebXMLDespacho);
        }
        else {
            //Mandamos al cliente a la página
            RequestDispatcher redireccionador;
            redireccionador = peticion.getRequestDispatcher(mapeoWebXMLDespacho);
            redireccionador.forward(peticion, respuesta);
        }
        //Termina el proceso de redirección
    }
    
    /**
     * Redirecciona la petición, devolviendo un código de respuesta 303. 
     * Esto es, recibe la información de un formulario
     * y manda al usuario a realizar otra petición para recibir su información.
     * @param respuesta La repsuesta.
     * @param mapeoWebXMLDespacho la URL que el usuario va a tener que solicitar.
     * @return 
     */
    private HttpServletResponse etiquetarRedireccion303 (HttpServletResponse respuesta, String mapeoWebXMLDespacho) {
        //Ponemos el código de respuesta
        respuesta.setStatus(303);
        //y setHeader nos permite MANDAR ese código al usuario
        respuesta.setHeader("Location", "/music-wiki/"+mapeoWebXMLDespacho);
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

    /**
     * Añade los siguientes artistas a una lista:
     * Black Sabbath, David Bowie, Neutral Milk Hotel, Juan Gabriel
     * @param artistas La lista a la cual agregar estos objetos Artista.
     * @return La lista que fue puesta como parámetro del método.
     */
    private List<Artista> llenarListaConEjemplos(List<Artista> artistas) {
        artistas.add(new Artista("Black Sabbath", 1968));
        artistas.add(new Artista("David Bowie", 1947));
        artistas.add(new Artista("Neutral Milk Hotel", 1989));
        artistas.add(new Artista("Juan Gabriel", 1950));
        return artistas;
    }

}
