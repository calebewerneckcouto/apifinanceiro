package com.financeiro.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financeiro.br.model.Categoria;
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	

}
