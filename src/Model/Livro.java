/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Cimol
 */
public class Livro {
    
    public Livro(Connection conexao){
        this.conexao = conexao;
    }

    public Livro(int idLivro, String titulo, int anoLancamento, int numeroPaginas, String resumo, String paisOrigem, String idioma, Connection conexao) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.numeroPaginas = numeroPaginas;
        this.resumo = resumo;
        this.paisOrigem = paisOrigem;
        this.idioma = idioma;
        this.conexao = conexao;
    }

    public Livro(int idLivro, String titulo, int anoLancamento, int numeroPaginas, String resumo, String paisOrigem, String idioma) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.numeroPaginas = numeroPaginas;
        this.resumo = resumo;
        this.paisOrigem = paisOrigem;
        this.idioma = idioma;
    }
    
    private int idLivro;
    private String titulo;
    private int anoLancamento;
    private int numeroPaginas;
    private String resumo;
    private String paisOrigem;
    private String idioma;
    private Connection conexao;

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getPais() {
        return paisOrigem;
    }

    public void setPais(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    public ResultSet obterListaLivros() throws SQLException{
        String sql = "select * from livro";
        PreparedStatement requisicao = this.conexao.prepareStatement(sql);
        return requisicao.executeQuery();
        
    }
    
    public boolean incluirLivro() throws SQLException{
        String sql = "INSERT INTO livro (titulo,anoLancamento,"
                + "numeroPaginas,"
                + "resumo,"
                + "idioma,"
                + "paisOrigem)"
                + "VALUES (?,?,?,?,?,?)";
        
        PreparedStatement requisicao = this.conexao.prepareStatement(sql);
        requisicao.setString(1, this.titulo);
        requisicao.setInt(2, this.anoLancamento);
        requisicao.setInt(3, this.numeroPaginas);
        requisicao.setString(4, this.resumo);
        requisicao.setString(5, this.idioma);
        requisicao.setString(6, this.paisOrigem);
    
        int retorno = requisicao.executeUpdate();
        requisicao.close();
        
        return retorno!=0;
    }
    
    public void atualizaLivro() throws SQLException{
        String sql = "UPDATE livro set titulo=?,"
                + "anoLancamento=?,"
                + "numeroPaginas=?,"
                + "resumo=?,"
                + "idioma=?,"
                + "paisOrigem=?"
                + "WHERE idLivro = ?";
        
        PreparedStatement requisicao = this.conexao.prepareStatement(sql);
        requisicao.setString(1, this.titulo);
        requisicao.setInt(2, this.anoLancamento);
        requisicao.setInt(3, this.numeroPaginas);
        requisicao.setString(4, this.resumo);
        requisicao.setString(5, this.idioma);
        requisicao.setString(6, this.paisOrigem);
        requisicao.setInt(7, this.idLivro);
        
        requisicao.executeUpdate();
        requisicao.close();
        
        
    }
    
    public boolean removerLivro(int id) throws SQLException{
        String sql = "DELETE FROM livro WHERE idLivro = ?";
        
        PreparedStatement requisicao = this.conexao.prepareStatement(sql);
        requisicao.setInt(1,id);
        int rowCount = requisicao.executeUpdate();
        requisicao.close();
        
        return rowCount != 0;
        
    }
    
}
