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
import model.Album;

/**
 *
 * @author benjamin
 */
public class AlbumesDAO implements AlbumesDAOInterfaz {

    @Override
    public Album getAlbumByName(String nombre) {
        try {
            Connection conexion = jdbc.DBConnection.getInstance();
            String queryString = "SELECT * FROM albumes WHERE albNombre = ?";
            PreparedStatement query = conexion.prepareStatement(queryString);
            query.setString(0, nombre);
            ResultSet rsQuery = query.executeQuery();
            if (rsQuery.first()) {
                Album returnValue = new Album(rsQuery.getString("albNombre"), rsQuery.getInt("albFLanzamiento"));
                return returnValue;
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Album> getAllAlbums() {
        try {
            Connection conexion = jdbc.DBConnection.getInstance();
            String queryString = "SELECT * FROM albumes";
            PreparedStatement query = conexion.prepareStatement(queryString);
            ResultSet rsQuery = query.executeQuery();
            if (rsQuery.first()) {
                List<Album> returnValue = new java.util.ArrayList<>();
                do {
                    returnValue.add(new Album(rsQuery.getString("albNombre"), rsQuery.getInt("albFLanzamiento")));
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
