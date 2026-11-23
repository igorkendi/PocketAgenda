package com.exemplo.pocketagenda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CompromissoRepository {
    private static final List<Compromisso> compromissos = new ArrayList<>();

    private CompromissoRepository() {
    }

    public static synchronized void adicionar(Compromisso compromisso) {
        compromissos.add(compromisso);
    }

    public static synchronized List<Compromisso> listar() {
        return Collections.unmodifiableList(new ArrayList<>(compromissos));
    }
}
