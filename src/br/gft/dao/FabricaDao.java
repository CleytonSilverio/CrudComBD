package br.gft.dao;

import br.gft.entidade.Cidadao;
import br.gft.rest.Dao;

public class FabricaDao {
	
	public static Dao<Cidadao> criarCidadaoDao() {
		return new CidadaoDao();
	}

}
