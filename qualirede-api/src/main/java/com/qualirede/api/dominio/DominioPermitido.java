package com.qualirede.api.dominio;

import java.util.ArrayList;

import com.qualirede.api.dominio.objeto.DominioObject;

import antlr.collections.List;

public enum DominioPermitido implements BaseEnum {
	
	SIM("Sim"),
	NAO("Não");

    private static final DominioPermitido[] ENUMS = DominioPermitido.values();

    private String descricao;

    private DominioPermitido(final String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public DominioObject getObject() {
        return DominioObject.builder().value(this.name()).label(this.descricao).build();
    }

    public static List objects() {
        final ArrayList<DominioObject> objects = new ArrayList<>();
        final DominioPermitido[] values = values();

        for (final DominioPermitido dominio : values) {
            objects.add(new DominioObject(dominio.name(), dominio.descricao));
        }

        return (List) objects;
    }

}
