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
public class Teste {
    public static void main(String[] args) {
        BancoDeDados bd = new BancoDeDados();
        
        if(bd.getStatusConexao()){
            Livro livro = new Livro(bd.getConexao());
            try{
                ResultSet listaLivros = livro.obterListaLivros();
                while(listaLivros.next()){
                    System.out.println("titulo: "+listaLivros.getString("titulo"));
                    System.out.println("ano: "+listaLivros.getInt("anoLancamento"));
                    System.out.println("n° paginas: "+listaLivros.getString("numeroPaginas"));
                    System.out.println("resumo: "+listaLivros.getString("resumo"));
                    System.out.println("idioma: "+listaLivros.getString("idioma"));
                    System.out.println("pais: "+listaLivros.getString("paisOrigem"));
                    System.out.println("*******************************************");
                }
            }catch(SQLException ex){
                System.out.println(ex.toString());
            }
        } else {
            System.out.println("não deu");
            System.out.println(bd.getMensagemErro());
        }
        
        
        
    }   
}
