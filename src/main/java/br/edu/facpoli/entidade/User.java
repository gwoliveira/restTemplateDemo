package br.edu.facpoli.entidade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.edu.facpoli.pojo.RandomUser;

@Entity
public class User {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private String foto;
	private String email;
	private String endereco;
	private String telefone;
	private String password;
	private Date nascimento;

	public User() {
	}

	public User(RandomUser randomUser) {
		this.nome = randomUser.getName().simpleName();
		this.foto = randomUser.getPicture().getLarge();
		this.email = randomUser.getEmail();
		this.endereco = randomUser.getLocation().getStreet();
		this.telefone = randomUser.getPhone();
		this.password = randomUser.getLogin().getPassword();
		try {
			this.nascimento = sdf.parse(randomUser.getDob());
		} catch (ParseException e) {
			e.printStackTrace();
		}
				
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

}
