/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import Model.BancoDeDados;
import Model.Livro;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Cimol
 */
public class TesteIncluirLivro {
     public static void main(String[] args) {
        BancoDeDados bd = new BancoDeDados();
        String titulo = "novo livro do harry potter";
        int anoLancamento = 2019;
        int numeroPaginas = 480;
        String resumo = "um livro mais ou menos pra ser sincero";
        String pais = "Reino Unido";
        String idioma = "Inglês";
        
        if(bd.getStatusConexao()){
            Livro livro = new Livro(bd.getConexao());
            livro.setTitulo(titulo);
            livro.setAnoLancamento(anoLancamento);
            livro.setNumeroPaginas(numeroPaginas);
            livro.setResumo(resumo);
            livro.setPais(pais);
            livro.setIdioma(idioma);
            
            try{
                if(livro.incluirLivro())
                    System.out.println("livro incluido com sucesso");
            }catch(SQLException ex){
                System.out.println("erro ao incluir livro "+ex.toString());
            }
        }
        
    }   
}
