package com.github.qbek;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.github.qbek.bricks.Message;

public class MessageTest {

  private final String SENDER = "sender";
  private final String RECIEPIENT = "recipient";

  @Test
  public void requestTest () {
    Message msg = new Message("test request").from(SENDER).to(RECIEPIENT).asRequest();
    assertThat(msg.toString()).matches(SENDER + "->" + RECIEPIENT + ":test request\n");
  }

  @Test
  public void responseTest () {
    Message msg = new Message("test response").from(RECIEPIENT).to(SENDER).asResponse();
    assertThat(msg.toString()).matches(RECIEPIENT + "-->" + SENDER + ":test response\n");
  }  
}