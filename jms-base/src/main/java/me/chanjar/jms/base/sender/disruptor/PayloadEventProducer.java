package me.chanjar.jms.base.sender.disruptor;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

import javax.jms.JMSException;

public class PayloadEventProducer {

  private final RingBuffer<PayloadEvent> ringBuffer;

  private static final EventTranslatorOneArg<PayloadEvent, Object> TRANSLATOR =
      (event, sequence, requestDto) -> {
        System.out.println("sjj  transfer message to event: " + requestDto + ",event:" + event);
                           event.setPayload(requestDto);
                                         };

  public PayloadEventProducer(RingBuffer<PayloadEvent> ringBuffer) {
    this.ringBuffer = ringBuffer;
  }

  public void onData(Object payload) throws JMSException {

    System.out.println("sjj " +  ringBuffer + "," + payload);
    ringBuffer.publishEvent(TRANSLATOR, payload);

  }

}
