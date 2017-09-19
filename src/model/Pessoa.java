package model;

public class Pessoa {

	private String cpf;
	private String rg;
	private String expeditor;
	private String nome;
	private String sobrenome;
	private String prontuario;
	private String email;
	private String senha;
	
	// Construtor
	
	public Pessoa(String cpf, String rg, String nome) {
		this.cpf = cpf;
		this.rg = rg;
		this.nome = nome;
	}
	
	public Pessoa(String cpf, String nome) {
		this(cpf, null, nome);
	}
	
	public Pessoa() {}
	
	//	Métodos
	
	public String getExpeditor() {
		return expeditor;
	}
	public void setExpeditor(String expeditor) {
		this.expeditor = expeditor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getProntuario() {
		return prontuario;
	}
	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
}
