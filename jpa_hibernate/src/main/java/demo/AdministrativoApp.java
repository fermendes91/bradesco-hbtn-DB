package demo;

import java.util.List;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;
public class AdministrativoApp {
    public static void main(String[] args) {
        ProdutoModel produtoModel = new ProdutoModel();

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);

        // 1) Criando um produto
        produtoModel.create(p1);

        Produto p2 = new Produto();
        p2.setNome("SOM");
        p2.setPreco(100.0);
        p2.setQuantidade(50);
        p2.setStatus(false);

        // 1) Criando um produto
        produtoModel.create(p2);

        //2) Buscando todos os produtos na base de dados
        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        Produto p3 = new Produto();
        p3.setId(2);
        p3.setNome("SOM");
        p3.setPreco(77.0);
        p3.setQuantidade(49);
        p3.setStatus(false);
        //3) atualizando produto na base de dados
        produtoModel.update(p3);

        //4) pesquisando um produto na base de dados
        Produto produto = produtoModel.findById(p1);
        System.out.println("Produto encontrado : " + produto.toString());

        //5) Deletando um produto na base de dados
        //produtoModel.delete(p1);


        PessoaModel pessoaModel = new PessoaModel();

        Pessoa pes = new Pessoa();
        pes.setNome("NOme TEste");
        pes.setCpf(123456789);
        pes.setData_nascimento("23/12/1986");
        pes.setEmail("teste@teste.com.br");
        pes.setIdade(38);

        // 1) Criando um Pessoa
        pessoaModel.create(pes);

        Pessoa pes1 = new Pessoa();
        pes1.setNome("NOme teste2");
        pes1.setCpf(555555555);
        pes1.setData_nascimento("24/12/1986");
        pes1.setEmail("teste2@teste2.com.br");
        pes1.setIdade(55);

        // 1) Criando um Pessoa
        pessoaModel.create(pes1);

        //2) Buscando todos as pessoas na base de dados
        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("Qtde de pessoas encontradas : " + pessoas.size());


        Pessoa pes2 = new Pessoa();
        pes2.setId(2);
        pes2.setNome("NOme teste2");
        pes2.setCpf(555555555);
        pes2.setData_nascimento("25/12/1986");
        pes2.setEmail("teste2@teste2.com.br");
        pes2.setIdade(44);
        //3) atualizando pessoa na base de dados
        pessoaModel.update(pes2);

        //4) pesquisando um pessoa na base de dados
        Pessoa pessoa = pessoaModel.findById(pes);
        System.out.println("Pessoa encontrada : " + pessoa.toString());

        //5) Deletando uma pessoa na base de dados
        //pessoaModel.delete(pes);

    }
}
