package br.com.diegosilva.seletivo.application;

import java.util.function.Function;

public interface Presenter<UC_OUT, NEW_OUT> extends Function<UC_OUT, NEW_OUT> {
}
