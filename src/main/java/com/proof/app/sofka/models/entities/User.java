package com.proof.app.sofka.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "USERS")
/**
 *construye los setters y getters
 */
@Getter
@Setter
/**
 *Identificador
 */
public class User implements Serializable {
    /**
     *Agregamos etiquetas
     */
    @Id
    /**
     * Notación para que se vaya incrementando
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * nombre que va obtener la BD
     */
    @Column(name = "ID", unique = true, nullable = false, updatable = true)

    private long id;
    private String username;
    private String email;
    private int priority;


}
