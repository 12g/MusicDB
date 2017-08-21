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
package music_db;

/**
 * Clase que abstrae información sobre una pista específica de un álbum.
 * @author Benjamin "12g" La Madrid
 */
public class Pista {
    
    private String identificador;

    /**
     * Obtiene el número y título de la pista.
     * @return Un string que contiene tanto el número de la pista como su título.
     */
    public String getIdentificador() {
        return identificador;
    }

    /**
     * Set the value of titulo
     * @param identificador Un string que contiene tanto el número de la pista como su título.
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Pista(String identificador) {
        setIdentificador(identificador);
    }

    
}
