package org.github.gborkar.saga.chreography.paymentservice.kafka;

import org.github.gborkar.saga.chreography.avroschemas.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

@SuppressWarnings("deprecation")
@EnableBinding(Source.class)
public class PublishCreateAccount {

    @Autowired
    private MessageChannel output;

    public void raiseCreateAccount(Account account) {
        Account accountTest = Account.newBuilder()
                .setAccountId(account.getAccountId())
                .setBalance(account.getBalance()).build();
        output.send(MessageBuilder.withPayload(accountTest)
                .setHeader("messageKey", account.getAccountId()).build());
    }
}
