package org.github.gborkar.saga.chreography.paymentservice.rest.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.github.gborkar.saga.chreography.paymentservice.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AccountService {
    @Autowired
    private Source source;

    private static List<Account> accountList = new ArrayList<>(
            Arrays.asList(new Account(1L, 100), new Account(2L, 200)));

    public List<Account> getAccounts() {
        return accountList;
    }

    public Account getAccountById(long accountId) {
        return accountList.get((int) accountId);
    }

    public Long addAccount(@RequestBody Account account) {
        source.output().send(MessageBuilder.withPayload(account).build());
        return account.getAccountId();
    }
}
