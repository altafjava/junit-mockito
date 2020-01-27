package com.altaf.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.altaf.model.Item;
import com.altaf.service.ItemBusinessService;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private ItemBusinessService itemBusinessService;

  @Test
  public void testDummyItem() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);
    MvcResult mvcResult = mockMvc.perform(requestBuilder).andExpect(status().isOk())
        .andExpect(
            content().json("\n{\"id\": 1,\"name\":\"Laptop\",\"price\":12,\"quantity\":1300}"))
        .andReturn();

  }

  @Test
  public void itemFromBusinessService() throws Exception {
    Mockito.when(itemBusinessService.getHardcodedItem())
        .thenReturn(new Item(222, "Football", 500, 1000));
    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/item-from-business-service")
        .accept(MediaType.APPLICATION_JSON);
    mockMvc.perform(requestBuilder).andExpect(status().is(200))
        .andExpect(content().json("{id:222,name:Football,quantity:1000}")).andReturn();
  }

  @Test
  public void retrieveAllItemsFromDb() throws Exception {
    Mockito.when(itemBusinessService.getAllItemsFromDB()).thenReturn(Arrays.asList(new Item(1001, "Ball", 10, 20),new Item(1002, "Laptop", 15000, 50)));
    RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/all-items-from-db").accept(MediaType.APPLICATION_JSON);
    mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().json("[{id:1001,name:Ball,price:10,quantity:20},{id:1002}]")).andReturn();
  }
}
