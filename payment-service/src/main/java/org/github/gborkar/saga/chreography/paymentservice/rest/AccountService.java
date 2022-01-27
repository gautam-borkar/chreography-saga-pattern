package org.github.gborkar.saga.chreography.paymentservice.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.github.gborkar.saga.chreography.paymentservice.kafka.PublishCreateAccount;
import org.github.gborkar.saga.chreography.paymentservice.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AccountService {
    @Autowired
    PublishCreateAccount publishCreateAccount;

    private static List<Account> accountList = new ArrayList<>(
            Arrays.asList(new Account(1L, 100), new Account(2L, 200)));

    public List<Account> getAccounts() {
        return accountList;
    }

    public Account getAccountById(long accountId) {
        return accountList.get((int) accountId);
    }

    public Long addAccount(@RequestBody Account account) {
        publishCreateAccount.raiseCreateAccount(account);
        return account.getAccountId();
    }
}
