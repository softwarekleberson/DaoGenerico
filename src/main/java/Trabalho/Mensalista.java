package Trabalho;

import Funcionario.Funcionario;
import Persistencia.Id;
import Persistencia.Tabela;
import Persistencia.Transiente;
import Trabalho.excessoes.numeroHorasTrabalho;
import Trabalho.excessoes.valorMinimoARceberPorHora;
import Validacao.ExcecaoNaoPodeSerNulo;
import Validacao.ExcecaoTamanhoMinimo;

@Tabela(nome = "mensalista")
public class Mensalista {
	
	@Transiente
	private static final double VALOR_HORA_MINIMA = 2;
	@Transiente
	private static final int MIMINO_HORAS_TRABALHADAS = 0;
	
	@Id
	private int id;
	private double valorHora;
	private int horasTrabalhadas;
	private Funcionario funcionario;
	private Departamento departamento;
	
	
	public Mensalista(Funcionario funcionario ,Departamento departamento)
			throws ExcecaoNaoPodeSerNulo, ExcecaoTamanhoMinimo, valorMinimoARceberPorHora, numeroHorasTrabalho {
		super();

		setValorHora(valorHora);
		setHorasTrabalhadas(horasTrabalhadas);
	
	}
	
	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) throws valorMinimoARceberPorHora {
		if(valorHora < VALOR_HORA_MINIMA) {
			throw new valorMinimoARceberPorHora("valor minimo a receber abaixo da regra");
		}
		this.valorHora = valorHora;
	}

	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(int horasTrabalhadas) throws numeroHorasTrabalho {
		if(horasTrabalhadas < MIMINO_HORAS_TRABALHADAS) {
			throw new numeroHorasTrabalho("minimo de horas inferior ao acordado");
		}
		this.horasTrabalhadas = horasTrabalhadas;
	}

	@Override
	public String toString() {
		return "Mensalista [valorHora=" + valorHora + ", horasTrabalhadas=" + horasTrabalhadas + ", funcionario="
				+ funcionario + ", departamento=" + departamento + "]";
	}

	
}
