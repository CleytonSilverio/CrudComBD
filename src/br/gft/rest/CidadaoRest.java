package br.gft.rest;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.gft.business.BusinessException;
import br.gft.business.BusinessFacade;
import br.gft.dao.FabricaDao;
import br.gft.entidade.Cidadao;
import io.swagger.annotations.Api;



@Path("/cidadaorest")
@Api("/cidadaorest")
public class CidadaoRest {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cidadao> listar() {
		Dao<Cidadao> cidadaoDao = FabricaDao.criarCidadaoDao();
		List<Cidadao> cat = cidadaoDao.listar();
		return cat;		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Cidadao cidadao) {
		try {
			new BusinessFacade().inserirCidadao(cidadao);
		} catch (BusinessException e) {			
			e.printStackTrace();
		}
	}

}
