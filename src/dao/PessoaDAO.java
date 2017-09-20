package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	/**
	 * Verifica se o email e senha informados pertence a algum usuário cadastrado no banco de dados.
	 * @author Caio de Freitas
	 * @since 2017/09/20
	 * @param pessoa: objeto que representa uma pessoa.
	 * @return Retorna um TRUE caso exista um usuário cadastrano no banco com os dados informados
	 */
	public Pessoa exist (Pessoa pessoa) {
		
		boolean exist = true;
		
		String sql = "SELECT * FROM Pessoas WHERE email = \'?\' AND senha = \'?\';";
		
		sql = sql.replaceFirst("\\?", pessoa.getEmail());
		sql = sql.replaceFirst("\\?", pessoa.getSenha());
		
		System.out.println("sql = " + sql);
		
		ResultSet result = this.database.query(sql);
		
		try {
			
			if (result.next()) {
				System.out.println("usuário encontrado");
				// pega os dados do usuário
				pessoa.setCpf(result.getString("cpf"));
				pessoa.setRg(result.getString("rg"));
				pessoa.setExpeditor(result.getString("expeditor"));
				pessoa.setNome(result.getString("nome"));
				pessoa.setProntuario(result.getString("prontuario"));
				pessoa.setEmail(result.getString("email"));
				pessoa.setSobrenome(result.getString("sobrenome"));
				
			} else {
				pessoa = null;
			}
				
		} catch (SQLException e) {
			exist = false;
			e.printStackTrace();
		}
		
		return pessoa;
	}

}
