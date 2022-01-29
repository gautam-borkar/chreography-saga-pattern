package org.github.gborkar.saga.chreography.avroschemas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    String accountId;

    Long balance;
}