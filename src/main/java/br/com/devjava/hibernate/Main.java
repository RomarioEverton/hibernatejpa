package br.com.devjava.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	private static EntityManagerFactory entityManagerFactory;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		entityManagerFactory = Persistence.createEntityManagerFactory("hibernatejpa");
		
		EntityManager em = entityManagerFactory.createEntityManager();

		try {
			Lembrete lembrete = em.find(Lembrete.class, 1L);

			em.getTransaction().begin();
			em.remove(lembrete);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Delete " + e.getMessage());

		} finally {
			em.close();
		}
		
	/*
	 //Atualizando dados na tabela
		EntityManager em = entityManagerFactory.createEntityManager();

		try {
			Lembrete lembrete = em.find(Lembrete.class, 1L);

			lembrete.setTitulo("Reunião semanal");
			lembrete.setDescricao("Hoje, 08h00");

			em.getTransaction().begin();
			em.merge(lembrete);
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Update " + e.getMessage());

		} finally {
			em.close();
		}
	*/
		

		/*
		 * //Consulta por coluna especifica
		 * 
		 * List<Lembrete> lembretes = null;
		 * 
		 * EntityManager em = entityManagerFactory.createEntityManager();
		 * 
		 * try { lembretes =
		 * em.createQuery("from Lembrete l where l.titulo like '%leite%'").getResultList
		 * (); } catch (Exception e) { System.out.println("LIST ALL: " +
		 * e.getMessage());
		 * 
		 * } finally { em.close(); }
		 * 
		 * if(lembretes != null) { lembretes.forEach(System.out::println); }
		 */

		/*
		 * //Consulta por ID
		 * 
		 * EntityManager em = entityManagerFactory.createEntityManager();
		 * 
		 * Lembrete lembrete = null;
		 * 
		 * try { lembrete = em.find(Lembrete.class,1L); System.out.println(lembrete); }
		 * catch (Exception e) { System.out.println(e.getMessage());
		 * 
		 * } finally { em.close(); }
		 */

		/*
		 * //Consulta todos os registros
		 * 
		 * List<Lembrete> lembretes = null;
		 * 
		 * EntityManager em = entityManagerFactory.createEntityManager();
		 * 
		 * try { lembretes = em.createQuery("from Lembrete").getResultList(); } catch
		 * (Exception e) { System.out.println("LIST ALL: " + e.getMessage());
		 * 
		 * } finally { em.close(); }
		 * 
		 * if(lembretes != null) { lembretes.forEach(System.out::println); }
		 */

		/*
		 * //Insere informações na base
		 * 
		 * Lembrete lembrete = new Lembrete(); lembrete.setTitulo("Comprar Feijão");
		 * lembrete.setDescricao("Hoje, 11h00");
		 * 
		 * EntityManager em = entityManagerFactory.createEntityManager();
		 * 
		 * try { em.getTransaction().begin(); em.persist(lembrete);
		 * em.getTransaction().commit();
		 * 
		 * } catch (Exception e) { em.getTransaction().rollback();
		 * System.out.println("INSERT: " + e.getMessage()); } finally { em.close(); }
		 */

	}

}
