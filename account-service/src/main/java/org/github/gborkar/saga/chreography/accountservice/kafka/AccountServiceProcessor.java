package org.github.gborkar.saga.chreography.accountservice.kafka;

import java.util.function.Consumer;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.stereotype.Component;

@Component(value = "process")
public class AccountServiceProcessor
        implements Consumer<KStream<String, String>> {

    @Override
    public void accept(KStream<String, String> input) {
        input.foreach((key, value) -> {
            System.out.println("Key: " + key + " Value: " + value);
        });
    }

}
