package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Produto;

public class ProdutoModel {

    public void create(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Produto criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");

            Produto prd = em.find(Produto.class, p.getId());
            prd.setNome(p.getNome());
            prd.setPreco(p.getPreco());
            prd.setQuantidade(p.getQuantidade());
            prd.setStatus(p.isStatus());
            em.getTransaction().begin();
            em.merge(prd);
            em.getTransaction().commit();
            System.out.println("Produto alterado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao alterar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }

    }

    public void delete(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");

            Produto prd = em.find(Produto.class, p.getId());
            em.getTransaction().begin();
            em.remove(prd);
            em.getTransaction().commit();
            System.out.println("Produto exclído com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao excluir o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Produto findById(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        Produto prd = new Produto();
        try {
            System.out.println("Iniciando a transação");
            prd = em.find(Produto.class, p.getId());


        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao pesquisar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        return prd;
    }

    public List<Produto> findAll() {
        List<Produto> produtos = new ArrayList<Produto>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        try {

            Query query = em.createQuery("SELECT p FROM Produto p");
            produtos = query.getResultList();


        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao listar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        return produtos;
    }
}
