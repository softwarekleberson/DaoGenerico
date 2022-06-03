import java.sql.SQLException;
import java.time.LocalDate;

import Funcionario.Cpf;
import Funcionario.Funcionario;
import Funcionario.Pessoa;
import Persistencia.DAO;
import Trabalho.Cargo;
import Trabalho.Departamento;
import Trabalho.Empreitada;
import Trabalho.Horista;
import Trabalho.LocalConserto;
import Trabalho.Mensalista;
import Trabalho.excessoes.ExcecaoCpfInvalido;
import Trabalho.excessoes.nomeInferiorADoisCaracteres;
import Trabalho.excessoes.numeroHorasTrabalho;
import Trabalho.excessoes.salarioBaseDepartamento;
import Trabalho.excessoes.salarioInferiorMinimo;
import Trabalho.excessoes.valorMinimoARceberPorHora;
import Trabalho.excessoes.valorMinimoObra;
import Validacao.ExcecaoNaoPodeSerNulo;
import Validacao.ExcecaoTamanhoMinimo;

public class Teste {
	public static void main(String[] args) throws ExcecaoCpfInvalido, salarioBaseDepartamento, 
	nomeInferiorADoisCaracteres, ExcecaoNaoPodeSerNulo, 
	ExcecaoTamanhoMinimo, salarioInferiorMinimo,
	valorMinimoARceberPorHora, numeroHorasTrabalho, valorMinimoObra, IllegalArgumentException, IllegalAccessException, SQLException {
		
		Pessoa pessoa = new Pessoa("kleberson");
		Cpf cpf = new Cpf("438.036.857-40");
		
		Departamento recursosHumanos = new Departamento("Recursos Humanos", 1500);
		Funcionario kleberson = new Funcionario(pessoa, cpf, recursosHumanos);
		
		Horista ti = new Horista(20, 60, kleberson , recursosHumanos);
		
		Cargo gestorTi = new Cargo("Gestor TI", recursosHumanos, kleberson);
		
		DAO dao = new DAO();
		dao.salvar(recursosHumanos);

	}
}
