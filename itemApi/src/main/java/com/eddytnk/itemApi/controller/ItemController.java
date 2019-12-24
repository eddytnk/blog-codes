package com.eddytnk.itemApi.controller;

import com.eddytnk.itemApi.model.Item;
import com.eddytnk.itemApi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * Author: Edward Tanko <br/>
 * Date: 12/24/19 3:58 PM <br/>
 */
@RestController
@RequestMapping("/api")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PutMapping("/items")
    public ResponseEntity<?> addItem(@RequestBody Item item) {
        Item savedItem = itemService.addNewItem(item);
        return ResponseEntity.created(URI.create("/items/" + savedItem.getId())).build();
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @GetMapping("/items/{itemId}")
    public ResponseEntity<Item> getItem(@PathVariable("itemId") Long id) {
        return ResponseEntity.ok(itemService.getItem(id));
    }

    @PostMapping("/items/{itemId}")
    public ResponseEntity<?> updateItem(@PathVariable("itemId") Long id, @RequestBody Item item) {
        itemService.updateItem(id, item);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable("itemId") Long id) {
        itemService.removeItem(id);
        return ResponseEntity.noContent().build();
    }


}
