package dao;

import java.util.List;

import banco.MySQLDatabase;
import model.Pessoa;

public class PessoaDAO extends DAO<Pessoa> {

	public PessoaDAO(MySQLDatabase database) {
		super(database);
		this.database.connect();
	}
	
	@Override
	public boolean insert(Pessoa pessoa) {
		// TODO: criar função que prepara a Query para ser rodada no banco de dados
		String sql = "INSERT INTO Pessoa VALUES (\'?\')";
		
		sql = sql.replaceFirst("\\?",pessoa.getCpf());
		
		return this.database.insert(sql);
	}

	@Override
	public List<Pessoa> getAll() {
		// TODO Criar função para pegar todos os as pessoas cadastradas no banco de dados
		return null;
	}
	
	public boolean exist (Pessoa pessoa) {
		return false;
	}

}
