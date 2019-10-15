/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import Model.BancoDeDados;
import Model.Livro;
import java.sql.SQLException;

/**
 *
 * @author Cimol
 */
public class TesteEditarLivro {
     public static void main(String[] args) {
        BancoDeDados bd = new BancoDeDados();
        String titulo = "novo livro do harry potter";
        int anoLancamento = 2019;
        int numeroPaginas = 480;
        String resumo = "um livro mais ou menos pra ser sincero";
        String pais = "Inglaterra";
        String idioma = "Inglês";
        
        if(bd.getStatusConexao()){
            Livro livro = new Livro(bd.getConexao());
            livro.setTitulo(titulo);
            livro.setAnoLancamento(anoLancamento);
            livro.setNumeroPaginas(numeroPaginas);
            livro.setResumo(resumo);
            livro.setPais(pais);
            livro.setIdioma(idioma);
            livro.setIdLivro(3);
            
            try{
                livro.atualizaLivro();
                System.out.println("livro atualizado com sucesso");
            }catch(SQLException ex){
                System.out.println("erro ao atualizar livro "+ex.toString());
            }
        }
        
    }   
}
