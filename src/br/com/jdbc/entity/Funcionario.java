package br.com.jdbc.entity;

public class Funcionario {
	
	//VARS
	private int codigo;
	private String nome;
	private int cargo;
	private String descricao_cargo;
	private String setor;
	private double salario;
	
	//Set CLAss contructor
	public Funcionario() {
		super();
	}
	
	
	//GETTERS AND SETTERS
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCargo() {
		return cargo;
	}
	public void setCargo(int cargo) {
		this.cargo = cargo;
	}
	public String getDescricao_cargo() {
		return descricao_cargo;
	}
	public void setDescricao_cargo(String descricao_cargo) {
		this.descricao_cargo = descricao_cargo;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	
}
