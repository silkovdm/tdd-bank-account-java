package org.xpdojo.bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    @Test
    public void balanceOfNewAccount() {
        assertEquals(0, new Account().balance());
    }

    @Test
    public void createNewAccountWithAmount() {
        assertEquals(10, new Account(10).balance());
    }

    @Test
    public void depositAnAmountToIncreaseTheBalance() {
        Account account = new Account();

        account.deposit(10);
        assertEquals(10, account.balance());
    }

    @Test
    public void depositNegativeAmount() {
        Assertions.assertThrows(RuntimeException.class, () -> new Account().deposit(-10));
    }

    @Test
    public void withdrawAnAmountToDecreaseTheBalance() {
        Account account = new Account();
        account.deposit(10);
        account.withdraw(9);

        assertEquals(1, account.balance());
    }

    @Test
    public void withdrawAnAmountToDecreaseTheBalanceToZero() {
        Account account = new Account();
        account.deposit(10);
        account.withdraw(10);

        assertEquals(0, account.balance());
    }

    @Test
    public void withdrawAnAmountMoreThanBalance() {
        Assertions.assertThrows(RuntimeException.class, () -> new Account().withdraw(10));
    }

    @Test
    public void withdrawNegativeAmount() {

        Assertions.assertThrows(RuntimeException.class, () -> new Account().withdraw(-10));
    }

    @Test
    public void transferBetweenAccounts() {
        Account account1 = new Account();
        Account account2 = new Account();

        account1.deposit(10);
        account1.transfer(8, account2);

        assertEquals(2, account1.balance());
        assertEquals(8, account2.balance());
    }

    @Test
    public void transferBetweenAccountsMoreThanBalance() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            Account account1 = new Account();
            Account account2 = new Account();

            account1.transfer(8, account2);
        });
    }
}
