package br.ufc.dc.tpi.banco.contas;

import java.util.Vector;

public class VectorContas implements IRepositorioConta {
	private Vector<ContaAbstrata> contas;

	@Override
	public void inserir(ContaAbstrata conta) {
		contas.add(conta);

	}

	@Override
	public void remover(String numero) {
		contas.remove(numero);
	}

	@Override
	public ContaAbstrata procurar(String numero) {
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

	@Override
	public ContaAbstrata[] listar() {
		ContaAbstrata[] listacontas = new ContaAbstrata[contas.size()];
		int i = 0;
		for(i=0; i<contas.size(); i++) {
			listacontas[i] = contas.get(i);
		}
		return listacontas;
	}

	@Override
	public int tamanho() {
		return contas.size();
	}

}
