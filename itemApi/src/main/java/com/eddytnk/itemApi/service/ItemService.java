package com.eddytnk.itemApi.service;

import com.eddytnk.itemApi.model.Item;
import com.eddytnk.itemApi.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Author: Edward Tanko <br/>
 * Date: 12/24/19 3:39 PM <br/>
 */
@Service
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItem(Long id) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (!itemOptional.isPresent()) {
            throw new RuntimeException("Item not found.");
        }
        return itemOptional.get();
    }

    public Item addNewItem(Item item) {
        return itemRepository.save(item);
    }

    public void updateItem(Long id, Item item) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (!itemOptional.isPresent()) {
            throw new RuntimeException("Item not found.");
        }
        Item newItem = itemOptional.get();
        newItem.setId(item.getId());
        newItem.setName(item.getName());
        newItem.setPrice(item.getPrice());
        newItem.setQuantity(item.getQuantity());
        itemRepository.save(newItem);
    }

    public void removeItem(Long id) {
        itemRepository.deleteById(id);
    }


}
