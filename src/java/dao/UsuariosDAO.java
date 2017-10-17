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
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import model.Usuario;

/**
 *
 * @author benjamin
 */
public class UsuariosDAO implements UsuariosDAOInterfaz {
    
    @Override
    public Usuario getUsuarioByNameAndPass(String username, String password) {
        String[] argumentos = {username, password};
        try {
            Connection conexion = jdbc.DBConnection.getInstance();
            String queryString = "SELECT * FROM usuarios WHERE usrNombre = ? AND usrPass = ?";
            PreparedStatement query = conexion.prepareStatement(queryString, argumentos);
            ResultSet rsQuery = query.executeQuery();
            if (rsQuery.first()) {
                Usuario returnValue = new Usuario(rsQuery.getString("usrNombre"), rsQuery.getString("usrPass"));
                return returnValue;
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        try {
            Connection conexion = jdbc.DBConnection.getInstance();
            String queryString = "SELECT * FROM usuarios";
            PreparedStatement query = conexion.prepareStatement(queryString);
            ResultSet rsQuery = query.executeQuery();
            if (rsQuery.first()) {
                List<Usuario> returnValue = new java.util.ArrayList<>();
                do {
                    returnValue.add(new Usuario(rsQuery.getString("usrNombre"), rsQuery.getString("usrPass")) );
                } while (rsQuery.next());
                return returnValue;
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
}
