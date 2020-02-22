package com.qualirede.api.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.qualirede.api.dominio.DominioAutoriza;
import com.qualirede.api.dominio.DominioSexo;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties("valid")
@Getter
@Setter
@Entity
@Table(name = "procedimento", uniqueConstraints = @UniqueConstraint(columnNames = { "numero_procedimento", "idade", "sexo" }, 
name = "numero_procedimento_ukey"))
public class Procedimento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numero_procedimento", nullable=false)
	private Integer procedimento;
	
	@Column(name = "idade", nullable=false)
	private Integer idade;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "sexo", length = 1, nullable=false)
	private DominioSexo sexo;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "permitido", length = 3, nullable=false)
	private DominioAutoriza autoriza;
	
	public Procedimento(Integer procedimento, Integer idade, DominioSexo sexo, DominioAutoriza autoriza) {
		this.procedimento = procedimento;
		this.idade = idade;
		this.sexo = sexo;
		this.autoriza = autoriza;
	}
	
	public boolean isValid() {
		if(procedimento != null && idade != null && sexo != null && autoriza != null) {
			return true;
		}
		return false;
	}

}
