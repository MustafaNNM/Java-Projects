package money;

 public class Money {

	public int amount;
	protected String currency;

	public Money(int amount, String currency) {
		// TODO Auto-generated constructor stub
		this.amount=amount;
		this.currency = currency;
	}

	public boolean equals(Object object) {
		   Money money = (Money) object;
		   return amount == money.amount
		      && currency().equals(money.currency());
		}


	public static Money dollar(int amount) {
		// TODO Auto-generated method stub
		return new Dollar(amount, "USD");
	}

	public static Money franc(int amount) {
		// TODO Auto-generated method stub
		return new Franc(amount, "CHF");
	}

	public String currency() {
		// TODO Auto-generated method stub
		return currency;
	}
	
	public String toString() {
		   return amount + " " + currency;
		}

	public Money times(int multiplier) {   return new Money(amount * multiplier, currency);
	}

	public Money plus(Money addend) {   return new Money(amount + addend.amount, currency);
	}

	
}
