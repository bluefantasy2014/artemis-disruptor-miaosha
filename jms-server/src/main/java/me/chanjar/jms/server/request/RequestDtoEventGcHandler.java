package me.chanjar.jms.server.request;

import com.lmax.disruptor.EventHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.chanjar.jms.server.request.RequestDtoEvent;

/**
 * RequestDtoEvent的GC处理器
 */
public class RequestDtoEventGcHandler implements EventHandler<RequestDtoEvent> {
  private static final Logger LOGGER = LoggerFactory.getLogger(RequestDtoEventDbOutputer.class);

  @Override
  public void onEvent(RequestDtoEvent event, long sequence, boolean endOfBatch) throws Exception {
    LOGGER.debug("#4 --- RequestDtoEventGcHandler called");

    event.clearForGc();

  }

}
