package br.edu.facpoli.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.edu.facpoli.entidade.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
