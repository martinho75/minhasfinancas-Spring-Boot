package com.unitel.minhasfinancas.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
//import javax.persistence.Table;

@Entity
@Table( name = "usuario", schema = "financas")
@Data
@NoArgsConstructor
@AllArgsConstructor 
@Builder
public class Usuario {
	
	@Id
	@Column( name = "id")
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Long id;
	
	@Column( name = "nome")
	private String nome;
	
	@Column( name = "email")
	 private String email;
	
	@Column( name = "senha")
	private String senha;
}

