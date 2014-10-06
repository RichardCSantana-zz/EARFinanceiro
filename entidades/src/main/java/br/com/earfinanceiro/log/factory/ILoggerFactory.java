package br.com.earfinanceiro.log.factory;

import java.util.logging.Logger;

import javax.enterprise.inject.spi.InjectionPoint;

public interface ILoggerFactory {

	@SuppressWarnings("rawtypes")
	public abstract Logger getLog(Class clazz);

	public abstract Logger getLog(InjectionPoint injectionPoint);

}