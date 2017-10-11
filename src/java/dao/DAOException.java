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

/**
 *
 * @author benjamin
 */
public class DAOException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * Construye DAOException con el mensaje que informa los detalles
     * @param message el mensaje detallado para esta excepcion
     */
    public DAOException(String message) {
        super(message);
    }

    /**
     * Construye DAOException con la causa raiz de la excepcion.
     * @param cause La causa raiz de la exoepcion.
     */
    public DAOException(Throwable cause) {
        super(cause);
    }

    /**
     * Construye una  DAOException con un mensaje y una causa.
     * @param message el mensaje detallado para esta excepcion.
     * @param cause La causa raiz de la exoepcion.
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
