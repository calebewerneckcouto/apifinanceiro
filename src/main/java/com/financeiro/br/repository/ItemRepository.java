package com.financeiro.br.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.financeiro.br.model.Item;

	public interface ItemRepository extends JpaRepository<Item, Long> {
		@Query("SELECT i FROM Item i WHERE EXTRACT(MONTH FROM i.data) = :mes")
	    List<Item> findByMes(int mes);
	}

   

