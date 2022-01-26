package org.github.gborkar.saga.chreography.paymentservice.kafka.streams.publisher;

import org.github.gborkar.saga.chreography.paymentservice.model.Account;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.handler.annotation.SendTo;

@SuppressWarnings("deprecation")
@EnableBinding(Source.class)
public class CreateAccountPublisher {

    @SendTo(Source.OUTPUT)
    public Account raiseCreateAccountEvent(Account account) {
        return account;
    }

}
