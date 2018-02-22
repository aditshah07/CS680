package edu.umb.cs.cs680.hw04;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*; 
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class SavingsAccountTest {

	private SavingsAccount savingsAccount;

  	@Before
  	public void createAccount() throws InsufficientFundsException {
     	float amount = 25.0f; 		
    	savingsAccount = new SavingsAccount(amount);
  	}

  	@Test
  	public void checkcreateAccount() throws InsufficientFundsException {
  		float amount = 25.0f;
    	SavingsAccount savingsAccountCheck = new SavingsAccount(amount);
    	float expected = 25.0f;
    	assertThat(savingsAccountCheck.getBalance(),is(expected));
  	}


  	@Test
  	public void checkBalance() throws InsufficientFundsException {
    	float actual = savingsAccount.getBalance();
    	float expected = 25.0f;
    	assertThat(actual,is(expected));
  	}

    @Test
    public void withdrawFunds() throws InsufficientFundsException {
      float amount = 20.0f;
      float actual = savingsAccount.withdraw(amount);
      float expected = 5.0f;
      assertThat(actual,is(expected));
    } 

    @Test
    public void depositFunds() throws InsufficientFundsException {
      float amount = 10.0f;
      float actual = savingsAccount.deposit(amount);
      float expected = 35.0f;
      assertThat(savingsAccount.getBalance(),is(expected));
    }

    @Test
    public void depositWithdrawFunds() throws InsufficientFundsException {
      float amountdeposit = 10.0f;
      float amountwithdraw = 20.0f;
      savingsAccount.deposit(amountdeposit);
      float actual = savingsAccount.withdraw(amountwithdraw);
      float expected = 15.0f;
      assertThat(savingsAccount.getBalance(),is(expected));
    }

    @Test
    public void withdrawDepositFunds() throws InsufficientFundsException {
      float amountdeposit = 20.0f;
      float amountwithdraw = 10.0f;
      savingsAccount.withdraw(amountwithdraw);
      float actual = savingsAccount.deposit(amountdeposit);
      float expected = 35.0f;
      assertThat(savingsAccount.getBalance(),is(expected));
    }


    @Test(expected = InsufficientFundsException.class)
    public void withdrawInsufficientFunds() throws InsufficientFundsException {
      float amount = 30.0f;
      float actual = savingsAccount.withdraw(amount);
    } 
}