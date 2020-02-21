package com.qualirede.api.dominio;

import java.util.ArrayList;

import com.qualirede.api.dominio.objeto.DominioObject;

import antlr.collections.List;

public enum DominioAutoriza implements BaseEnum {
	
	SIM("Sim"),
	NAO("Não");

    private static final DominioAutoriza[] ENUMS = DominioAutoriza.values();

    private String descricao;

    private DominioAutoriza(final String descricao) {
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
        final DominioAutoriza[] values = values();

        for (final DominioAutoriza dominio : values) {
            objects.add(new DominioObject(dominio.name(), dominio.descricao));
        }

        return (List) objects;
    }

}
