package br.com.earfinanceiro.dao;

import java.util.List;

public interface IDAO<T> {

	public abstract void salvar(T valor);

	public abstract void atualizar(T valor);

	public abstract void excluir(T valor);

	public abstract List<T> listaTodos();

}