package com.github.qbek.bricks.glues;

import java.util.Iterator;
import java.util.Map;

public class Table {

  private Map<String, String> dataForTable;
  private String[] header;
  private StringBuilder renderedTable = new StringBuilder();

  public Table (Map<String, String> data) {
    dataForTable = data;
  }

  public String toString() {
    Iterator<Map.Entry<String, String>> it = dataForTable.entrySet().iterator();
    Map.Entry<String, String> entry;

    if(header != null) {
      appendHeader(header[0], header[1]);
    }

    while(it.hasNext()) {
      entry = it.next();
      appendRow(entry.getKey(), entry.getValue());
    }

    return renderedTable.toString();
  }

  public Table addHeaders (String a, String b) {
    header = new String[]{a, b};
    return this;
  }

  private void appendHeader (Object key, Object value) {
    appendLine(key.toString(), value.toString(), "|=");
  }

  private void appendRow (Object key, Object value) {
    appendLine(key.toString(), value.toString(), "|");
  }

  private void appendLine(String a, String b, String delimiter) {
//    renderedTable.append("\t");
    renderedTable.append(delimiter).append(" ").append(a).append(" ");
    renderedTable.append(delimiter).append(" ").append(b).append(" ");
    renderedTable.append("|\n");
  }
}

