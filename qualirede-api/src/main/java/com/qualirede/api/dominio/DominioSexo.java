package com.qualirede.api.dominio;

import java.util.ArrayList;

import com.qualirede.api.dominio.objeto.DominioObject;

import antlr.collections.List;

public enum DominioSexo implements BaseEnum {
	
	M("Masculino"),
	F("Feminino");

    private static final DominioSexo[] ENUMS = DominioSexo.values();

    private String descricao;

    private DominioSexo(final String descricao) {
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
        final DominioSexo[] values = values();

        for (final DominioSexo dominio : values) {
            objects.add(new DominioObject(dominio.name(), dominio.descricao));
        }

        return (List) objects;
    }

}
