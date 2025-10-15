package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Pessoa;

public class PessoaModel {

    public void create(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Pessoa criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar o Pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");

            Pessoa pso = em.find(Pessoa.class, p.getId());
            pso.setNome(p.getNome());
            pso.setCpf(p.getCpf());
            pso.setData_nascimento(p.getData_nascimento());
            pso.setEmail(p.getEmail());
            pso.setIdade(p.getIdade());
            em.getTransaction().begin();
            em.merge(pso);
            em.getTransaction().commit();
            System.out.println("Pessoa alterada com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao alterar a Pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");

            Pessoa pso = em.find(Pessoa.class, p.getId());
            em.getTransaction().begin();
            em.remove(pso);
            em.getTransaction().commit();
            System.out.println("Pessoa exclída com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao excluir a Pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }    }

    public Pessoa findById(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        Pessoa pso = new Pessoa();
        try {
            System.out.println("Iniciando a transação");
            pso = em.find(Pessoa.class, p.getId());


        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao pesquisar a Pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        return pso;
    }

    public List<Pessoa> findAll() {

        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT p FROM Pessoa p");
            pessoas =  query.getResultList();



        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao lista o pessoas !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        return pessoas;

    }
}
