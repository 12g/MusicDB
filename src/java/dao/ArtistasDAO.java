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
import java.util.ArrayList;
import java.util.List;
import model.Artista;

/**
 *
 * @author benjamin
 */
public class ArtistasDAO implements ArtistasDAOInterfaz {
    
    @Override
    public List<Artista> getArtistasByName(String filtro) {
        try {
            Connection conexion = jdbc.DBConnection.getInstance();
            PreparedStatement query = conexion.prepareStatement("SELECT * FROM artistas WHERE artNombres = ?");
            query.setString(0, filtro);
            ResultSet rsQuery = query.executeQuery();
            if (rsQuery.first()) {
                List<Artista> returnValue = new ArrayList<>();
                do {
                    Artista nuevo = new Artista(rsQuery.getString("artNombres"), rsQuery.getInt("artFNacimiento"));
                    returnValue.add(nuevo);
                } while(rsQuery.next());
                return returnValue;
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Artista> getAllArtistas() {
        try {
            Connection conexion = jdbc.DBConnection.getInstance();
            PreparedStatement query = conexion.prepareStatement("SELECT * FROM artistas");
            ResultSet rsQuery = query.executeQuery();
            if (rsQuery.first()) {
                List<Artista> returnValue = new java.util.ArrayList<>();
                do {
                    returnValue.add(new Artista(rsQuery.getString("usrNombre"), rsQuery.getInt("artFNacimiento")));
                } while (rsQuery.next());
                return returnValue;
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public boolean addArtista(String nombre, int año) {
        try {
            Connection conexion = jdbc.DBConnection.getInstance();
            PreparedStatement query = conexion.prepareStatement("INSERT INTO artistas ) VALUES (?, ?)");
            query.setString(1, nombre);
            query.setInt(2, año);
            int cantidadNuevos = query.executeUpdate();
            return (cantidadNuevos > 0);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean removeArtista(int id) {
        try {
            Connection conexion = jdbc.DBConnection.getInstance();
            PreparedStatement query = conexion.prepareStatement("DELETE FROM artistas WHERE artID = ?");
            query.setInt(1, id);
            int cantidadEliminados = query.executeUpdate();
            return (cantidadEliminados > 0);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
}
