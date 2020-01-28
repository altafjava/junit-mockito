package com.altaf.spike;

import org.junit.Test;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {

  @Test
  public void test() {
    String responseFromString = "[{\"id\":1000,\"name\":\"Ball\",\"price\":150,\"quantity\":450}," + "{\"id\":1001,\"name\":\"Ball\",\"price\":400,\"quantity\":100},"
        + "{\"id\":1002,\"name\":\"Pencil\",\"price\":50,\"quantity\":300}," + "]";
    
    DocumentContext documentContext = JsonPath.parse(responseFromString);
    int length = documentContext.read("$.length()");
    System.out.println("len="+length);
  }
}
