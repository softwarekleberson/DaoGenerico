package Persistencia;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO {

	 public void salvar(Object objeto) throws SQLException, 
	    IllegalArgumentException, IllegalAccessException {

		  Tabela tabela = objeto
	                .getClass()
	                .getDeclaredAnnotation(Tabela.class);

	        String nomeTabela = "_" + objeto
	                .getClass()
	                .getSimpleName()
	                .toLowerCase();

	        if (null != tabela && !tabela.nome().equals("_SEM_NOME_")) {
	            nomeTabela = tabela.nome();
	        }

	        String sql = "INSERT INTO " + nomeTabela;
	        sql += "(";

	        String parteFinalSQL = " VALUES(";
	        Field[] atributos = objeto.getClass().getDeclaredFields();
	        for (Field atributo : atributos) {
	            Transiente transiente = atributo.getDeclaredAnnotation(Transiente.class);
	            if(null != transiente)
	                continue;
	            
	            Id id = atributo.getDeclaredAnnotation(Id.class);
	            if (null == id) {
	                String nomeColuna = atributo
	                        .getName()
	                        .toLowerCase();
	                
	                Coluna coluna = atributo.getDeclaredAnnotation(Coluna.class);
	                if(null != coluna && !coluna.nome().equals("_SEM_NOME_")) {
	                    nomeColuna = coluna.nome();
	                }
	                
	                sql += nomeColuna + ", ";
	                parteFinalSQL += "?, ";
	            }
	        }

	        sql = sql.substring(0, sql.length() - 2) + ")";
	        sql += parteFinalSQL.substring(0, parteFinalSQL.length() - 2) + ")";

	        Connection conexao = ConexaoBD.getConnection();
	        PreparedStatement psql = conexao.prepareStatement(sql);

	        int i = 1;
	        for (Field atributo : atributos) {
	            Transiente transiente = atributo.getDeclaredAnnotation(Transiente.class);
	            if(null != transiente)
	                continue;
	            
	            Id id = atributo.getDeclaredAnnotation(Id.class);
	            if (null == id) {
	                atributo.setAccessible(true);
	                psql.setObject(i++, atributo.get(objeto));
	            }
	        }

	        psql.execute();
	        conexao.close();
	        
	        System.out.println(sql);

	 }
}
