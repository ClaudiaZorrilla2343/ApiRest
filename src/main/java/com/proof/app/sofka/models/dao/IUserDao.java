package com.proof.app.sofka.models.dao;


import com.proof.app.sofka.models.entities.User;
import org.springframework.data.repository.CrudRepository;

//Interfaz que admite valores genericos
public interface IUserDao extends CrudRepository<User, Long> {
}
