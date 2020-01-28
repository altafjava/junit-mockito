package com.altaf.spike;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.startsWith;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class HamcrestTest {

  @Test
  public void test() {
    List<Integer> numbers = Arrays.asList(15, 20, 30);
    assertThat(numbers, hasItem(20));
    assertThat(numbers, hasItems(15, 30));
    assertThat(numbers, hasSize(3));
    assertThat(numbers, everyItem(greaterThan(10)));
    assertThat(numbers, everyItem(lessThan(50)));

    assertThat("", isEmptyString());
    assertThat("ABCDEF", containsString("BC"));
    assertThat("ABCDEF", startsWith("ABC"));
    assertThat("ABCDEF", containsString("DEF"));
  }

}
