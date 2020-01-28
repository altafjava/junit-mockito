package com.altaf.repository;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.altaf.model.Item;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

  @Autowired
  private ItemRepository itemRepository;

  @Test
  public void testFindAll() {
    List<Item> items = itemRepository.findAll();
    assertEquals(3, items.size());
  }

  @Test
  public void testFindById() {
    Item item = itemRepository.findById(1001).get();
    assertEquals("Ball", item.getName());
  }

}
