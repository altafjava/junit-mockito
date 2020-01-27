package com.altaf.service;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.altaf.model.Item;
import com.altaf.repository.ItemRepository;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

  @InjectMocks
  private ItemBusinessService itemBusinessService;
  @Mock
  private ItemRepository itemRepository;

  @Test
  public void testGetAllItemsFromDB() {
    Mockito.when(itemRepository.findAll())
        .thenReturn(Arrays.asList(new Item(1001, "Ball", 10, 20)));
    List<Item> items = itemBusinessService.getAllItemsFromDB();
    assertEquals(200, items.get(0).getValue());
  }

}
