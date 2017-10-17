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

/**
 *
 * @author benjamin
 */
public class DataManager {
    public UsuarioDTO getUsuarioByUserAndPass(String username, String userpass){
        UsuariosDAO objDAO = new UsuariosDAO(); 
        model.Usuario usuarioModel = objDAO.getUsuarioByNameAndPass(username, userpass);
        
        if (usuarioModel != null) {
            UsuarioDTO objDTO = Transformer.UsuarioModelToDTO(usuarioModel);
            return objDTO;
        }
        
        return null;    
    }

    public List<UsuarioDTO> getUsuariosList() {
        UsuariosDAO objDAO = new UsuariosDAO(); 
        List<model.Usuario> modelList = objDAO.getAllUsuarios();
        
        if (modelList.size() > 0) {
            List<UsuarioDTO> dtoList = new java.util.ArrayList<UsuarioDTO>();
            for (model.Usuario um : modelList) {
                UsuarioDTO objDTO = Transformer.UsuarioModelToDTO(um);
                dtoList.add(objDTO);
            }
            return dtoList;
        }
        
        return null;
    }
}
