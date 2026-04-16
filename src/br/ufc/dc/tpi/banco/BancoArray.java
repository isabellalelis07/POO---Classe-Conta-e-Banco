package br.ufc.dc.tpi.banco;

import br.ufc.dc.tpi.banco.contas.Conta;
import br.ufc.dc.tpi.banco.contas.ContaEspecial;
import br.ufc.dc.tpi.banco.contas.ContaPoupança;

public class BancoArray {
	private Conta[] contas;
	private int indice = 0;
	private double taxa = 0.2;
	
	public BancoArray(){
		contas = new Conta[100];
	}
	
	public void cadastrar(Conta conta) {
		contas[indice]= conta;
		indice++;
	}
	
	private Conta procurar(String numero) {
		int i = 0;
		boolean achou = false;
		while((!achou) && (i < indice)) {
			if(contas[i].numero().equals(numero)) { // metodo p/ fornecer uma comparação -> entra na casa e ve oq tem dentro
				achou = true;
			} else {
				i++;
			}
		}
		if(achou == true) {
			return contas[i];
		} else {
			return null;
		}
	}
	
	public void debitar(String numero, double valor) {
		Conta conta;
		conta = procurar(numero);
		if(conta != null) {
			conta.debitar(valor);
		} else {
			System.out.println("Conta Inexistente");
		}
	}
	
	public void creditar(String numero, double valor) {
		Conta conta;
		conta = procurar(numero);
		if(conta != null) {
			conta.creditar(valor);
		} else {
			System.out.println("Conta Inexistente");
		}
	}
	
	public double saldo (String numero) {
		Conta conta;
		conta = procurar(numero);
		if(conta != null) {
			return conta.saldo();
		} else {
			return -1;
		}
	}
	
	public void transferir (String origem, String destino, double valor) {
		Conta c1;
		Conta c2;
		c1 = procurar(origem);
		c2 = procurar(destino);
		if(c1 != null && c2 != null) {
			c1.debitar(valor);
			c2.creditar(valor);
		} else {
			System.out.println("Operação inválida");
		}
	}
	
	public void renderJuros(String numero) {
		Conta conta;
		conta = procurar(numero);
		if(conta != null) {
			if(conta instanceof ContaPoupança) {
				((ContaPoupança) conta).renderJuros(this.taxa);
				System.out.println("Saldo com Juros:" + conta.saldo());
			} else {
				System.out.println("Essa conta não é poupança");
			}
		} else {
			System.out.println("Essa conta não existe");
		}
	}
	
	public void renderBonus(String numero) {
		Conta conta;
		conta = procurar(numero);
		if(conta != null) {
			if(conta instanceof ContaEspecial) {
				((ContaEspecial) conta).renderBonus();
				System.out.println("Saldo com bonus:" + conta.saldo());
			} else {
				System.out.println("Essa conta não é especial");
			}
		} else {
			System.out.println("Essa conta não existe");
		}
		
	}
	
	
	

}
