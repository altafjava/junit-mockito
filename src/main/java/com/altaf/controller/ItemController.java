package com.altaf.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.altaf.model.Item;
import com.altaf.service.ItemBusinessService;

@RestController
public class ItemController {

  @Autowired
  private ItemBusinessService itemBusinessService;

  @GetMapping("/dummy-item")
  public Item getItem() {
    return new Item(1, "Laptop", 12, 1300);
  }

  @GetMapping("/item-from-business-service")
  public Item itemFromBusinessService() {
    return itemBusinessService.getHardcodedItem();
  }
  
  @GetMapping("/all-items-from-db")
  public List<Item> getAllItemsFromDB(){
    return itemBusinessService.getAllItemsFromDB();
  }
}
