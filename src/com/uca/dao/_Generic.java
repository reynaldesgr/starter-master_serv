package com.uca.dao;

import java.sql.Connection;

public abstract class _Generic<T> {

    public Connection connect = _Connector.getInstance();

    /**
     * Permet de créer une entrée dans la base de données
     * par rapport à un objet
     * @param obj
     */
    public abstract T create(T obj);

    /**
     * Permet la suppression d'une entrée de la base
     * @param obj
     */
    public abstract void delete(T obj);

    /**
     * Permet la sélection d'une entrée de la base
     * à partir d'un identifiant donné
     * @param id
     */
    public abstract T getById(int id);
}
