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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.financeiro.br.model.Item;
import com.financeiro.br.repository.ItemRepository;

@Controller
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @ResponseBody
    @GetMapping(value = "/listaitems")
    public ResponseEntity<List<Item>> lista() {
        List<Item> listaItem = itemRepository.findAll();
        return new ResponseEntity<List<Item>>(listaItem, HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(value = "/listaitemsmes")
    public ResponseEntity<List<Item>> listaItemsMesVigente(@RequestParam int mes) {
        List<Item> listaItems = itemRepository.findByMes(mes);
        return new ResponseEntity<>(listaItems, HttpStatus.OK);
    }

    @PostMapping("/itemssalvar")
    public ResponseEntity<Item> salvarItem(@RequestBody Item item) {
        try {
            System.out.println("Saving item: " + item); // Log para depuração
            Item newItem = itemRepository.save(item);
            return ResponseEntity.status(HttpStatus.CREATED).body(newItem);
        } catch (Exception e) {
            e.printStackTrace(); // Log do erro
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @ResponseBody
    @DeleteMapping(value = "/lista/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        itemRepository.deleteById(id);
        return new ResponseEntity<String>("Item deletado!!!", HttpStatus.CREATED);
    }
}
