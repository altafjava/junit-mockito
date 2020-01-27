package com.altaf.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.altaf.model.Item;
import com.altaf.repository.ItemRepository;

@Service
public class ItemBusinessService {

  @Autowired
  private ItemRepository itemRepository;

  public Item getHardcodedItem() {
    return new Item(222, "Football", 500, 1000);
  }


  public List<Item> getAllItemsFromDB() {
    List<Item> items = itemRepository.findAll();
    for (Item item : items) {
      item.setValue(item.getPrice() * item.getQuantity());
    }
    return items;
  }

}
