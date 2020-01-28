package com.altaf.spike;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class AssertJTest {

  @Test
  public void test() {
    List<Integer> numbers = Arrays.asList(15, 20, 30);
    assertThat(numbers).hasSize(3).contains(20).allMatch(a -> a > 10).allMatch(a -> a < 50).noneMatch(a -> a <= 0);
    assertThat("").isEmpty();
    assertThat("ABCDEF").contains("BC").startsWith("ABC").endsWith("DEF");
  }

}
