package com.encontrarte.encontrarte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encontrarte.encontrarte.model.OrdenesCompra;
//En repository vivira mi JpaRepository que me permitira extender los metodos especificos de la JPA, asi como anotaciones que e reviran para indicar acciones. El JpaRepository recibe dos argumentos, el modelo o  logica de neociacion  

public interface OrdenesCompraRepository extends JpaRepository<OrdenesCompra, Long>{

}
