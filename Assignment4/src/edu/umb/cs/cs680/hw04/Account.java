package edu.umb.cs.cs680.hw04;
 
public abstract class Account{

	public float balance=0;

	public float getBalance(){
		return this.balance;
	}

	public float deposit(float amount){
		this.balance += amount;
		return this.balance;
	}

	public abstract float withdraw(float amount) throws InsufficientFundsException;

}