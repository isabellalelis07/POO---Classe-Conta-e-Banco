package banksys;

import br.ufc.dc.tpi.banco.contas.Conta;
import br.ufc.dc.tpi.banco.contas.ContaPoupança;

public class Main {

	public static void main(String[] args) {
		Conta c = new Conta("12345");
		c.creditar(100);
		c.debitar(50);
		System.out.println("Saldo da conta " + c.numero() + " é " + c.saldo());
		
		ContaPoupança poupança = new ContaPoupança("21.342-7");
		poupança.creditar(500.07);
		poupança.debitar(45.00);
		System.out.println(poupança.saldo());
		poupança.renderJuros(0.01);
		System.out.println(poupança.saldo());

	}

}
