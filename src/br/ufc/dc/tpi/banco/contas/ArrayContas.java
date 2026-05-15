package br.ufc.dc.tpi.banco.contas;

import br.ufc.dc.tpi.banco.exceptions.CIException;

public class ArrayContas implements IRepositorioConta {
	private ContaAbstrata[] contas;
	private int indice;

	@Override
	public void inserir(ContaAbstrata conta) {
		contas[indice] = conta;
		indice++;
	}

	@Override
	public void remover(String numero) throws CIException {
		ContaAbstrata conta;
		conta = procurar(numero);
		if(conta == null) {throw new CIException(numero);}
		for(int i = 0; i<indice; i++){
			if(contas[i].getNumero().equals(numero)) {
				contas[i] = contas[indice-1];
				contas[indice-1] = null;
				indice --;
			}
		}

	}

	@Override
	public ContaAbstrata procurar(String numero) {
		int i = 0;
		boolean achou = false;
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

	@Override
	public ContaAbstrata[] listar() {
		ContaAbstrata[] listacontas = new ContaAbstrata[indice];
		int i = 0;
		for(i=0; i<indice; i++) {
			listacontas[i] = contas[i];
		}
		return listacontas;
	}

	@Override
	public int tamanho() {
		return indice;
	}

}
