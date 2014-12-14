package br.com.wpattern.example.abstracts;

import org.apache.log4j.Logger;

import br.com.wpattern.example.interfaces.IAbstract;
import br.com.wpattern.example.interfaces.INested;

class Abstract01 implements IAbstract {

	private static final Logger logger = Logger.getLogger(Abstract01.class);

	@SuppressWarnings("unused")
	private INested nested = new Nested();

	private void privateMethod() {
		logger.info("Private method invoked in Abstract01.");
	}

	private class Nested implements INested {

		@Override
		public void nestedMethod() {
			Abstract01.this.privateMethod();
		}

	}

}
