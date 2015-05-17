/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sow.jordan.repositorios;

import com.sow.jordan.modelos.Comentario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author HectorJavier
 */
public interface RepositorioComentario extends CrudRepository<Comentario, Integer>{
    
}
