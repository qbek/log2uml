package com.github.qbek;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.github.qbek.bricks.glues.Table;
public class TableTest {

  @Test
  public void renderTableTest () {
    Table table = new Table(createTestMap());
    assertThat(table.toString()).contains("| row_1 | value_1 |\n");
    assertThat(table.toString()).contains("| row_2 | value_2 |\n");
  }

  @Test
  public void renderHeaderTest () {
    Table table = new Table(createTestMap());
    table.addHeaders("ROWS", "VALUES");
    String firstLine = table.toString().split("\n")[0];
    assertThat(firstLine).contains("|= ROWS |= VALUES |");
  }


  private Map<String, String> createTestMap () {
    Map<String, String> testData = new HashMap();
    testData.put("row_1", "value_1");
    testData.put("row_2", "value_2");
    return testData;
  }
}