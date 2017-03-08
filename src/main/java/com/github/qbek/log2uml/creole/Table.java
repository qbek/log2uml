package com.github.qbek.log2uml.creole;

import java.util.ArrayList;

public class Table {

  private ArrayList<String[]> data;
  private String[] headers;

  public Table (ArrayList<String[]> data) {
    this.data = data;
  }

  public String toString() {
    StringBuilder renderedTable = new StringBuilder();
    if(headers != null) {
       renderedTable.append(renderHeader(headers));
    }

    for (String[] row : data) {
        renderedTable.append(renderRow(row));
    }

    return renderedTable.toString();
  }

  public Table addHeaders (String[] headers) {
    this.headers = headers;
    return this;
  }

  private String renderHeader(String[] header) {
      return renderLine(header, "|=");
  }

  private String renderRow(String[] row) {
      return renderLine(row, "|");
  }

  private String renderLine(String[] data, String delimiter) {
    StringBuilder line = new StringBuilder();
    for (String e : data) {
        line.append(delimiter).append(" ").append(e).append(" ");
    }
    line.append("|\n");
    return line.toString();
  }
}

