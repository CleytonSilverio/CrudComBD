package br.gft.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.gft.entidade.Cidadao;
import br.gft.rest.Dao;

public class CidadaoDao implements Dao<Cidadao> {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("cidadao");

	public void inserir(Cidadao cidadao) {
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		System.out.println(cidadao);
		try {
			em.persist(cidadao);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("---ERRO " + e.getMessage());
		}
		System.out.println("Ok" + cidadao);
	}

	public void alterar(Cidadao cidadao) {
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.merge(cidadao);
		em.getTransaction().commit();
	}

	public void excluir(Cidadao cidadao) {
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.remove(em.merge(cidadao));
		em.getTransaction().commit();
	}


	public List<Cidadao> listar() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select c from Cidadao c");
		return q.getResultList();
	}

	public Cidadao buscarPorCodCidadao(Integer codCidadao) {
		EntityManager em = emf.createEntityManager();
		return em.find(Cidadao.class, codCidadao);
	}

	@Override
	public Cidadao buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
