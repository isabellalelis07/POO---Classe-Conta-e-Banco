package br.ufc.dc.tpi.banco;

import br.ufc.dc.tpi.banco.contas.ContaAbstrata;
import br.ufc.dc.tpi.banco.contas.ContaEspecial;
import br.ufc.dc.tpi.banco.contas.ContaPoupança;
import br.ufc.dc.tpi.banco.exceptions.CIException;
import br.ufc.dc.tpi.banco.exceptions.SIException;

public class BancoIndependente implements IBanco {
	private ContaAbstrata[] contas;
	private int indice = 0;
	private double taxa = 0.2;
	
	public BancoIndependente(){
		contas = new ContaAbstrata[100];
	}
	
	public void cadastrar(ContaAbstrata conta) {
		String numeroDaConta = conta.numero();
		ContaAbstrata contaExistente = procurar(numeroDaConta);
		if(contaExistente == null) {
			contas[indice]= conta;
			indice++;
		} else {
			System.out.println("Erro: Esta conta já está cadastrada!");
		}
		
	}
	
	public ContaAbstrata procurar(String numero) {
		boolean achou = false;
		int i = 0;
		while((!achou) && (i < indice)) {
			if(contas[i].numero().equals(numero)) { 
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
	
	public void debitar(String numero, double valor) throws CIException, SIException {
		ContaAbstrata conta;
		conta = procurar(numero);
		if(conta != null) {
			if(conta.saldo() >= valor) {
				conta.debitar(valor);
			} else {
				throw new SIException(conta.saldo(), numero);
			}
		} else {
			throw new CIException(numero);
		}
	}
	
	public void creditar(String numero, double valor) throws CIException{
		ContaAbstrata conta;
		conta = procurar(numero);
		if(conta != null) {
			conta.creditar(valor);
		} else {
			throw new CIException(numero);
		}
	}
	
	public double saldo (String numero) throws CIException{
		ContaAbstrata conta;
		conta = procurar(numero);
		if(conta != null) {
			return conta.saldo();
		} else {
			throw new CIException(numero);
		}
	}
	
	public void transferir (String origem, String destino, double valor) throws CIException, SIException {
		ContaAbstrata c1;
		ContaAbstrata c2;
		c1 = procurar(origem);
		c2 = procurar(destino);
		if(c1 == null) {
			throw new CIException(origem);
		}
		if(c2 == null) {
			throw new CIException(destino);
		}
		if(c1.saldo() < valor) {
			throw new SIException(c1.saldo(), origem);
		}
		c1.debitar(valor);
		c2.creditar(valor);
	}
	
	public void renderJuros(String numero) throws CIException{
		ContaAbstrata conta;
		conta = procurar(numero);
		if(conta != null) {
			if(conta instanceof ContaPoupança) {
				((ContaPoupança) conta).renderJuros(this.taxa);
				System.out.println("Saldo com Juros:" + conta.saldo());
			} else {
				System.out.println("Essa conta não é poupança");
			}
		} else {
			throw new CIException(numero);
		}
	}
	
	public void renderBonus(String numero) throws CIException {
		ContaAbstrata conta;
		conta = procurar(numero);
		if(conta != null) {
			if(conta instanceof ContaEspecial) {
				((ContaEspecial) conta).renderBonus();
				System.out.println("Saldo com bonus:" + conta.saldo());
			} else {
				System.out.println("Essa conta não é especial");
			}
		} else {
			throw new CIException(numero);
		}
		
	}

	@Override
	public double saldoTotal() {
		double saldoTotal = 0;
		for(int i=0; i<indice; i++) {
			ContaAbstrata conta = contas[i];
			saldoTotal = saldoTotal + conta.saldo();
		}
		return saldoTotal;
	}

	@Override
	public int numeroContas() {
		return indice;
	}

	
	
	

}
