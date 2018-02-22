package edu.umb.cs.cs680.hw04;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*; 
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class CheckingAccountTest {

	private CheckingAccount checkingAccount;
  private SavingsAccount savingsAccount;

  	@Before
  	public void createAccount() throws InsufficientFundsException {
     	float amount = 25.0f; 		
      savingsAccount = new SavingsAccount(amount);
    	checkingAccount = new CheckingAccount(savingsAccount, amount);
  	}

  	@Test
  	public void checkBalance() throws InsufficientFundsException {
    	float actual = checkingAccount.getBalance();
    	float expected = 25.0f;
    	assertThat(actual,is(expected));
  	}

    @Test
    public void withdrawFunds() throws InsufficientFundsException {
      float amount = 20.0f;
      float actual = checkingAccount.withdraw(amount);
      float expected = 5.0f;
      assertThat(actual,is(expected));
    } 

    @Test
    public void depositFunds() throws InsufficientFundsException {
      float amount = 10.0f;
      float actual = checkingAccount.deposit(amount);
      float expected = 35.0f;
      assertThat(checkingAccount.getBalance(),is(expected));
    }

    @Test
    public void withdrawWithFineFunds() throws InsufficientFundsException {
      float amount = 35.0f;
      float actual = checkingAccount.withdraw(amount);
      float expected = -50.0f;
      assertThat(checkingAccount.getBalance(),is(expected));
    }

    @Test
    public void depositWithdrawFunds() throws InsufficientFundsException {
      float amountdeposit = 10.0f;
      float amountwithdraw = 20.0f;
      checkingAccount.deposit(amountdeposit);
      float actual = checkingAccount.withdraw(amountwithdraw);
      float expected = 15.0f;
      assertThat(checkingAccount.getBalance(),is(expected));
    }

    @Test
    public void withdrawDepositFunds() throws InsufficientFundsException {
      float amountdeposit = 20.0f;
      float amountwithdraw = 10.0f;
      checkingAccount.withdraw(amountwithdraw);
      float actual = checkingAccount.deposit(amountdeposit);
      float expected = 35.0f;
      assertThat(checkingAccount.getBalance(),is(expected));
    }


    @Test(expected = InsufficientFundsException.class)
    public void withdrawInsufficientFunds() throws InsufficientFundsException {
      float amount = 55.0f;
      float actual = checkingAccount.withdraw(amount);
    } 
}