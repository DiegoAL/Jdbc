package br.com.Devell.Test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.Devell.Controller.ConnectionFactory;

public class ConnectionFactoryTest {

	@Test
	public void realizaConexao() {
		assertNotNull(ConnectionFactory.getConnection());

	}

}
