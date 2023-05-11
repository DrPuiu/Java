package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagementSingleton {

    private static EntityManagementSingleton singleInstance = null;

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    public EntityManager em = emf.createEntityManager();

    private EntityManagementSingleton(){}

    public static EntityManagementSingleton getSingleInstance(){
        if(singleInstance == null){
            singleInstance = new EntityManagementSingleton();
        }
        return singleInstance;
    }

    public void close(){
        em.close();
        emf.close();
    }
}