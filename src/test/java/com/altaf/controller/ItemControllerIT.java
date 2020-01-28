package com.altaf.controller;

import static org.junit.Assert.assertEquals;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import com.altaf.model.Item;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Test
  public void testGetAllItemsFromDB() throws JSONException {
    String response = testRestTemplate.getForObject("/all-items-from-db", String.class);
    JSONAssert.assertEquals("[{id:1002},{quantity:20,name:Ball},{price:360}]", response, false);
  }

  @Test
  public void testItemFromBusinessService() {
    Item itemResponse = testRestTemplate.getForObject("/item-from-business-service", Item.class);
    assertEquals("Football", itemResponse.getName());
  }

  @Test
  public void testGetItem() throws JSONException {
    String response = testRestTemplate.getForObject("/dummy-item", String.class);
    JSONAssert.assertEquals("{name:Laptop,price:12}", response, false);
  }
}
