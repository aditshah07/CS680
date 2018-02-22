package edu.umb.cs.cs680.hw04;

public class SavingsAccount extends Account {

  public SavingsAccount(float amount){
    this.balance = amount;
  }

  public float withdraw(float amount) throws InsufficientFundsException {
    if (this.balance >= amount) {
      this.balance -= amount;
    } else { 
      throw new InsufficientFundsException("Not enough funds in Savings Account");
    }
    return this.balance;
  }
}