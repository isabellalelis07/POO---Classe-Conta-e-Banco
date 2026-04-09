package br.ufc.dc.tpi.banco;

//ARRAY-> tem um número fixo, não poe mais adicionar
//VECTOR -> array dinâmico, pode ir adicionando 

//contas;add() -> adicionar conta para o vector
//contas;get(indice) -> pega o item que etá naquela posição
//contas.size() -> quantos itens tem guardados até o momento
//contas.remove(objeto) -> tira um item da lista


import java.util.Vector; //biblioteca do java
import br.ufc.dc.tpi.banco.contas.Conta; //importando nosso outro pacote

public class BancoVector {
	private Vector<Conta> contas;
	
	public BancoVector() { //criando o vector
		contas = new Vector<Conta>();
	}
	
	public void cadastrar(Conta conta) {
		contas.add(conta);
	}
	
	private Conta procurar(String numero) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < contas.size())){
			if(contas.get(i).equals(numero)) {
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
	
	public void transferir(String origem, String destino, double valor) {
		Conta c1;
		Conta c2;
		
		c1 = procurar(origem);
		c2 = procurar(destino);
		
		if((c1 != null) && (c2 != null)) {
			c1.debitar(valor);
			c2.creditar(valor);
		} else {
			System.out.println("Operação Inválida");
		}
	}


}
