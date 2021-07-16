package com.carlos.springpage.repository;

import java.util.Optional;
import java.util.Set;

import com.carlos.springpage.entity.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{

    /**
     * Se usa la convencion sobre configuracion para realizar consultas de cirtos parametros
     * Como los metodos de esta interfaz es "findBy" + variable del objeto usando UperCamelCase
    */
    public Set<User> findByEmail(String email);
    public Optional<User> findByUsername(String username);
}
