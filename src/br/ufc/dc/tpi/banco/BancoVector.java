package br.ufc.dc.tpi.banco;

//ARRAY-> tem um número fixo, não poe mais adicionar
//VECTOR -> array dinâmico, pode ir adicionando 

//contas;add() -> adicionar conta para o vector
//contas;get(indice) -> pega o item que etá naquela posição
//contas.size() -> quantos itens tem guardados até o momento
//contas.remove(objeto) -> tira um item da lista


import java.util.Vector; //biblioteca do java

import br.ufc.dc.tpi.banco.contas.Conta;
import br.ufc.dc.tpi.banco.contas.ContaAbstrata;
import br.ufc.dc.tpi.banco.contas.ContaPoupança;
import br.ufc.dc.tpi.banco.contas.ContaEspecial;

public class BancoVector {
	private Vector<ContaAbstrata> contas;
	private double taxa = 0.2;
	
	public BancoVector() { //criando o vector
		contas = new Vector<ContaAbstrata>();
	}
	
	public void cadastrar(ContaAbstrata conta) {
		contas.add(conta);
	}
	
	private ContaAbstrata procurar(String numero) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < contas.size())){
			if(contas.get(i).getNumero().equals(numero)) {
				achou = true;
			} else {
				i++;
			}
		}
		if(achou == true) {
			return contas.get(i);
		} else {
			return null;
		}
	}
	
	public void debitar(String numero, double valor) {
		ContaAbstrata conta;
		conta = procurar(numero);
		if(conta != null) {
			conta.debitar(valor);
		} else {
			System.out.println("Conta Inexistente");
		}
	}
	
	public void creditar(String numero, double valor) {
		ContaAbstrata conta;
		conta = procurar(numero);
		if(conta != null) {
			conta.creditar(valor);
		} else {
			System.out.println("Conta Inexistente");
		}
	}
	
	public void transferir(String origem, String destino, double valor) {
		ContaAbstrata c1;
		ContaAbstrata c2;
		
		c1 = procurar(origem);
		c2 = procurar(destino);
		
		if((c1 != null) && (c2 != null)) {
			c1.debitar(valor);
			c2.creditar(valor);
		} else {
			System.out.println("Operação Inválida");
		}
	}
	
	public void renderJuros(String numero) {
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
			System.out.println("Essa conta não existe");
		}
	}
	
	public void renderBonus(String numero) {
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
			System.out.println("Essa conta não existe");
		}
		
	}

}