package edu.umb.cs.cs680.hw04;

public class CheckingAccount extends Account {
  private SavingsAccount savingsAccount;

  public CheckingAccount(SavingsAccount savingsAccount, float amount){
   
    this.balance += amount;
    this.savingsAccount = savingsAccount;
  }

  public float withdraw(float amount) throws InsufficientFundsException {
    if (this.getBalance() > amount) {
      this.balance -= amount;
    } else if (this.getBalance() + savingsAccount.getBalance() >= amount) {
      amount -= this.balance;
      this.balance = -50.0f;
      savingsAccount.withdraw(amount);
    } else {
      throw new InsufficientFundsException("Insufficient Funds in both Account");
    }
    return this.balance;
  }
}
