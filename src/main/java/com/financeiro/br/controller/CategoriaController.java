package com.financeiro.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.financeiro.br.model.Categoria;
import com.financeiro.br.repository.CategoriaRepository;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @ResponseBody
    @GetMapping(value = "/listacategoria")
    public ResponseEntity<List<Categoria>> lista() {
        List<Categoria> listaItem = categoriaRepository.findAll();
        return new ResponseEntity<>(listaItem, HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping(value = "/categoriasalvar")
    public ResponseEntity<Categoria> salvar(@RequestBody Categoria item) {
        Categoria salva = categoriaRepository.save(item);
        return new ResponseEntity<>(salva, HttpStatus.OK);
    }

    @ResponseBody
    @DeleteMapping(value = "/listarcategorias/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        categoriaRepository.deleteById(id);
        return new ResponseEntity<>("Item deletado!!!", HttpStatus.OK);
    }
}
