package org.github.gborkar.saga.chreography.accountservice.kafka;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

import org.apache.kafka.streams.kstream.KStream;
import org.github.gborkar.saga.chreography.avroschemas.constants.StatusEnum;
import org.github.gborkar.saga.chreography.avroschemas.model.Account;
import org.github.gborkar.saga.chreography.avroschemas.model.AuditLog;
import org.springframework.stereotype.Component;

@Component(value = "process")
public class AccountServiceProcessor implements
        Function<KStream<String, Account>, KStream<String, AuditLog>> {

    @Override
    public KStream<String, AuditLog> apply(KStream<String, Account> input) {

        input.foreach((key, value) -> {
            System.out.println("Key: " + key + " Value: " + value);

        });

        ;
        return input.mapValues(account -> new AuditLog(account.getAccountId(),
                StatusEnum.ACCOUNT_CREATED.toString(),
                DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss")
                        .format(LocalDateTime.now())));
    }

}
