package banksys;

public class Main {

	public static void main(String[] args) {
		Conta c = new Conta("12345");
		c.creditar(100);
		c.debitar(50);
		System.out.println("Saldo da conta " + c.numero() + " é " + c.saldo());

	}

}
