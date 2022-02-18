package com.proof.app.sofka.services;

import org.springframework.stereotype.Service;

import java.util.List;
/**
 *Rellenar clase servicio, para implementar los metodos crud
 */

public interface IEntityService<T> {
    List<T> findAllForPriority(int priority);
    List<T> findAll();
    T findById(Long id);
    void save (T entity);
    void deleteById(Long Id);
}
