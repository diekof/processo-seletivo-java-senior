package br.com.diegosilva.seletivo.application;

public abstract class UnitUseCase<IN> {

    public abstract void execute(IN anIn);
}