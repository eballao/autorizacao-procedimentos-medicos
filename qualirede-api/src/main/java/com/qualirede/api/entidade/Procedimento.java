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
import javax.validation.constraints.NotNull;

import com.qualirede.api.dominio.DominioPermitido;
import com.qualirede.api.dominio.DominioSexo;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "procedimento")
@Getter
@Setter
public class Procedimento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "procedimento")
	private Integer procedimento;
	
	@NotNull
	@Column(name = "idade")
	private Integer idade;
	
	@NotNull
	@Enumerated(EnumType.STRING)
    @Column(name = "sexo", length = 1)
	private DominioSexo sexo;
	
	@NotNull
	@Enumerated(EnumType.STRING)
    @Column(name = "permitido", length = 3)
	private DominioPermitido permitido;

}
