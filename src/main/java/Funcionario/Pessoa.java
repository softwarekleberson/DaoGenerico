package Funcionario;

import Persistencia.Id;
import Persistencia.Tabela;
import Persistencia.Transiente;
import Validacao.ExcecaoNaoPodeSerNulo;
import Validacao.ExcecaoTamanhoMinimo;
import Validador.Validador;

@Tabela(nome = "pessoa")
public class Pessoa{
	
	@Transiente
	public static final int TAMANHO_MINIMO_NOME = 3;
	
	@Id
	private int id;
	private String nomePessoa;
	
	public Pessoa(String nomePessoa)throws ExcecaoNaoPodeSerNulo, ExcecaoTamanhoMinimo {
		setNomePessoa(nomePessoa);
	}

	public String getNomePessoa() {
		return nomePessoa;
	}
	
	public void setNomePessoa(String nomePessoa) throws ExcecaoNaoPodeSerNulo, ExcecaoTamanhoMinimo{
		this.nomePessoa = Validador.ExcecaoTamanhoMinimo(Validador.ExcecaoNaoPodeSerNulo(nomePessoa, "nomePessoa"),
		TAMANHO_MINIMO_NOME, "nome");
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nomePessoa=" + nomePessoa + "]";
	}
	
	
	
}
