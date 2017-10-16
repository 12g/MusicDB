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

import java.util.List;
import java.util.ListIterator;
import model.Usuario;

/**
 *
 * @author benjamin
 */
public class UsuariosDAO implements UsuariosDAOInterfaz {
    private List<Usuario> listaUsuarios;
    
    
    @Override
    public Usuario getUsuarioByNameAndPass(String username, String userpass) throws DAOException {
        if (listaUsuarios.size() > 0) {
            try {
                ListIterator<Usuario> iterador = listaUsuarios.listIterator();
                do {
                    Usuario puntero = iterador.next();
                } while (iterador != null);
            }
            catch (DAOException exc) {
                throw exc;
            }
        }
        return null;
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return listaUsuarios;
    }
    
}
