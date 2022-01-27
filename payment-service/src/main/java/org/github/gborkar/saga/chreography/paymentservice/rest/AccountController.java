package org.github.gborkar.saga.chreography.paymentservice.rest;

import java.net.URI;
import java.util.List;

import org.github.gborkar.saga.chreography.paymentservice.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class AccountController {

    @Autowired
    AccountService paymentRestService;

    @SuppressWarnings("rawtypes")
    @GetMapping("/account")
    public ResponseEntity<List> getAccount() {
        return new ResponseEntity<List>(paymentRestService.getAccounts(),
                HttpStatus.OK);
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<Account> getAccountById(
            @PathVariable long accountId) {
        return new ResponseEntity<Account>(
                paymentRestService.getAccountById(accountId), HttpStatus.OK);
    }

    @PostMapping("/account")
    public ResponseEntity<Void> addAccount(@RequestBody Account account) {
        long accountId = paymentRestService.addAccount(account);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}").buildAndExpand(accountId).toUri();
        return ResponseEntity.noContent().location(location).build();
    }
}
