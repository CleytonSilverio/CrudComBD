package br.gft.business;

import br.gft.dao.FabricaDao;
import br.gft.entidade.Cidadao;
import br.gft.rest.Dao;

public class CidadaoBusiness {

public void inserir(Cidadao cidadao)throws BusinessException{
		
		if (cidadao.getNome() == null) { 
			throw new BusinessException("Erro: Nome não pode ser vazio");
		}
			
		Dao<Cidadao> cidadaoDao = FabricaDao.criarCidadaoDao();
		cidadaoDao.inserir(cidadao);
	}

}
