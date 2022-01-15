# Microservice design pattern: chreography-saga-pattern

## Saga Pattern
Saga pattern splits a large business transaction into smaller microservice specific transaction. Saga pattern uses events to trigger next local trasaction.

## Business case 
**payment-service**
- Payment service receives POST request for account debit.
- Request is inserted into database with status as `PAYMENT_REQUEST_RECEIVED`. 
- Produces an event `PAYMENT_REQUEST_RECEIVED` for validation by account service and fraud service.
- After validation, payment is committed and payment-service produces `PAYMENT_PROCESSED`.

**account-service**

PAYMENT_REQUEST_RECEIVED :- 
- Account service consumes `PAYMENT_REQUEST_RECEIVED`.
- Validates if there is enough balance in the account.
- Reserves the amount for debit.
- Confirms the reservation by producing `AMOUNT_RESERVED` or `AMOUNT_NOT_RESERVED` event.

PAYMENT_PROCESSED :- 
- Account service consumes `PAYMENT_PROCESSED`.
- Amount reserved is commit to database.

**fraud-service**
- Fraud service consumes `PAYMENT_REQUEST_RECEIVED`.
- Validates if the trasaction is not a fradulent transaction.
- Confirms by producing the event `FRAUD_TRANSACTION` or `NO_FRAUD_TRANSACTION`.

## Chreography saga pattern

## Advantages of Chreography saga pattern
- Loose coupling
- Horizontal scaling
- Fault tolerant
- No service dependency

## Pre-requisite to run the example
- Java
- Spring boot
- Apache kafka

## Steps to execute
