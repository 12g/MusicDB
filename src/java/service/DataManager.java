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
package service;

import common.Transformer;
import java.util.List;
import dao.*;
import dto.*;
import java.util.ArrayList;

/**
 *
 * @author benjamin
 */
public class DataManager {
    public static UsuarioDTO getUsuarioByUserAndPass(String username, String userpass){
        UsuariosDAO objDAO = new UsuariosDAO(); 
        model.Usuario usuarioModel = objDAO.getUsuarioByNameAndPass(username, userpass);
        
        if (usuarioModel != null) {
            UsuarioDTO objDTO = Transformer.UsuarioModelToDTO(usuarioModel);
            return objDTO;
        }
        
        return null;    
    }

    public static List<UsuarioDTO> getUsuariosList() {
        UsuariosDAO objDAO = new UsuariosDAO(); 
        List<model.Usuario> modelList = objDAO.getAllUsuarios();
        
        if (modelList.size() > 0) {
            List<UsuarioDTO> dtoList = new java.util.ArrayList<>();
            for (model.Usuario um : modelList) {
                UsuarioDTO objDTO = Transformer.UsuarioModelToDTO(um);
                dtoList.add(objDTO);
            }
            return dtoList;
        }
        
        return null;
    }
    
    public static List<ArtistaDTO> getArtistasByName(String nombre){
        ArtistasDAO objDAO = new ArtistasDAO(); 
        List<model.Artista> artistas = objDAO.getArtistasByName(nombre);
        
        if (artistas != null && artistas.size() > 0) {
            List<ArtistaDTO> listaDTO = new ArrayList<>();
            for (int i = 0; i < artistas.size(); i++) {
                model.Artista nuevo = artistas.get(i);
                ArtistaDTO dto = Transformer.ArtistaModelToDTO(nuevo);
                listaDTO.add(dto);
            }
            return listaDTO;
        }
        
        return null;    
    }

    public static List<ArtistaDTO> getAllArtistas() {
        ArtistasDAO objDAO = new ArtistasDAO(); 
        List<model.Artista> modelList = objDAO.getAllArtistas();
        
        if (modelList.size() > 0) {
            List<ArtistaDTO> dtoList = new java.util.ArrayList<ArtistaDTO>();
            for (model.Artista um : modelList) {
                ArtistaDTO objDTO = Transformer.ArtistaModelToDTO(um);
                dtoList.add(objDTO);
            }
            return dtoList;
        }
        
        return null;
    }
    
    public static AlbumDTO getAlbumByName(String nombre){
        AlbumesDAO objDAO = new AlbumesDAO(); 
        model.Album albumModel = objDAO.getAlbumByName(nombre);
        
        if (albumModel != null) {
            AlbumDTO objDTO = Transformer.AlbumModelToDTO(albumModel);
            return objDTO;
        }
        
        return null;    
    }

    public static List<AlbumDTO> getAllAlbumes() {
        AlbumesDAO objDAO = new AlbumesDAO(); 
        List<model.Album> modelList = objDAO.getAllAlbums();
        
        if (modelList.size() > 0) {
            List<AlbumDTO> dtoList = new java.util.ArrayList<>();
            for (model.Album um : modelList) {
                AlbumDTO objDTO = Transformer.AlbumModelToDTO(um);
                dtoList.add(objDTO);
            }
            return dtoList;
        }
        
        return null;
    }
    
    public static boolean addArtista(String nombre, int año){
        ArtistasDAO objDAO = new ArtistasDAO(); 
        return objDAO.addArtista(nombre, año);
    }
    
    public static boolean removeArtista(int id){
        ArtistasDAO objDAO = new ArtistasDAO(); 
        return objDAO.removeArtista(id);
    }
}
