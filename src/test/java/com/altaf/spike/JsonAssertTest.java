package com.altaf.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

  @Test
  public void strictTrue_ExactMatchExceptForSpaces() throws JSONException {
    String actualResult = "{\"id\":1,\"name\":\"Laptop\",\"price\":12,\"quantity\"  :1300}";
    String expectedResult = "{\"id\":1,\"name\":\"Laptop\",\"price\": 12,\"quantity\":1300}";
    JSONAssert.assertEquals(expectedResult, actualResult, true);
  }

  @Test
  public void strictFalse() throws JSONException {
    String actualResult = "{\"id\":1,\"name\":\"Laptop\",\"price\"  :12,\"quantity\":1300}";
    String expectedResult = "{\"id\":1,\"name\":\"Laptop\",\"price\": 12}";
    JSONAssert.assertEquals(expectedResult, actualResult, false);
  }

  @Test
  public void strictFalse_WithoutEscapeCharacter() throws JSONException {
    String actualResult = "{\"id\":1,\"name\":\"Laptop\",\"price\"  :12,\"quantity\":1300}";
    String expectedResult = "{id:1,name:Laptop,price: 12}";
    JSONAssert.assertEquals(expectedResult, actualResult, false);
  }
}
