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
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String servletSolicitado = request.getRequestURI();
        String dispatcherString;
        HttpSession session = request.getSession(); //obtiene la sesion del usuario o la crea
        
        if (servletSolicitado.equals("login")) {
            dispatcherString = "lista_artistas";
            
            String email = request.getParameter("email");
            String password = request.getParameter("password");
   
            session.setAttribute("email", email);
            session.setAttribute("password", password);
            
            List<Artista> artistas =  new ArrayList<Artista>();
            artistas.add(new Artista("Black Sabbath", 1968, true));
            artistas.add(new Artista("David Bowie", 1947, true));
            artistas.add(new Artista("Neutral Milk Hotel", 1989, true));
            artistas.add(new Artista("Juan Gabriel", 1950, true));
            session.setAttribute("artistas", artistas); 
        }
        else if (servletSolicitado.equals("borrarArtista")) {
            dispatcherString = "borrar_artista";
            
            int id = Integer.valueOf( request.getParameter("id") );
            request.setAttribute("id", id);
        }
        else if (servletSolicitado.equals("buscarArtistas")) {
            dispatcherString = "buscar_artista";
        }
        else if (servletSolicitado.equals("crearArtista")) {
            dispatcherString = "nuevo_artista";
        }
        else if (servletSolicitado.equals("verArtista")) {
            dispatcherString = "datos_artista";
            
            List<Artista> artistas = (ArrayList<Artista>)session.getAttribute("artistas"); 
            int idArtista = Integer.valueOf(request.getParameter("id"));
            
            Artista artista = artistas.get(idArtista);

            String nombreArtista = artista.getNombre();
            int añoArtista = artista.getFechaNac();
            
            request.setAttribute("nombre", nombreArtista);
            request.setAttribute("año", añoArtista);
        }
        else {
            dispatcherString = "error";
        }

        /* CODIGO ALTERNATIVO
            //Este Servlet fue llamado con un método POST, para recibir la información del formulario de login
            //Asumimos que además el cliente que completó dicho formulario espera ser llevado a otra página
            //Re-procesaremos la petición "request" para que desde aquí use el método GET
            //Para mayo HTTP, https://en.wikipedia.org/wiki/HTTP_303
            //response.setStatus(303);
            //response.setHeader("Location", "/music-wiki/"+dispatcherString);
        */
        
        //Mandamos al cliente a la pagina
        RequestDispatcher rd = request.getRequestDispatcher(dispatcherString);
        
        rd.forward(request, response);
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
