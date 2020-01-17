package br.gft.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import br.gft.business.BusinessException;
import br.gft.business.BusinessFacade;
import br.gft.entidade.Cidadao;

public class CidadaoTeste {
	
	@Test
	public void deveriaCadastrarUmCidadao() {
		
		Cidadao c = new Cidadao();
		c.setId(0);
		c.setNome("Jão");
		c.setSobreNome("gameply");
		c.setTelefone("12345678");
		c.setEmail("gameply@jao");
		
		try {
			new BusinessFacade().inserirCidadao(c);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		assertEquals(true,c.getId() != null);		
	}	


}
