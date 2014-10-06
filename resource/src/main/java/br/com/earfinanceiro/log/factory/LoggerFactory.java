/**
 * 
 */
package br.com.earfinanceiro.log.factory;

import java.util.logging.Logger;

import javax.ejb.Local;
import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * @author richard
 *
 */
@Singleton
@Local
public class LoggerFactory implements ILoggerFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.log.factory.ILoggerFactory#getLog(java.lang.Class)
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public Logger getLog(Class clazz) {
		return Logger.getLogger(clazz.getName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.earfinanceiro.log.factory.ILoggerFactory#getLog(javax.enterprise
	 * .inject.spi.InjectionPoint)
	 */
	@Override
	@Produces
	public Logger getLog(InjectionPoint injectionPoint) {
		String point = injectionPoint.getMember().getDeclaringClass().getName();
		return Logger.getLogger(point);
	}
}
