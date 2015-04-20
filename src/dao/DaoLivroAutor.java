package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.*;

public class DaoLivroAutor {
	
	public LivroAutor consultaLivro(LivroAutor livroAutor)throws SQLException{
		LivroAutor p=null;
		
		
			Connection c=JDBCUtil.getConnection();
			System.out.println("Conexão Efetuada");
			String sql="select * from livroAutor where codLivro=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setInt(1, livroAutor.getLivro().getCodLivro());
			ps.setInt(1, livroAutor.getAutor().getCodAutor());
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				p=new LivroAutor();
				
				Livro l=new Livro();
				l.setCodLivro(rs.getInt("codLivro"));
				
				Autor a=new Autor();
				a.setCodAutor(rs.getInt("codAutor"));
				
				p.setAutor(a);
				p.setLivro(l);
					
								
			}
			rs.close();
			ps.close();
			JDBCUtil.fechaConexao();
				
		return p;
		
	}
	
	public boolean insereLivro1(LivroAutor livroAutor)throws SQLException{
		boolean inserido=false;

			Connection c=JDBCUtil.getConnection();
			String sql="insert into livroautor values(?,?)";
			PreparedStatement ps=c.prepareStatement(sql);
			ps=c.prepareStatement(sql);
			ps.setInt(1, livroAutor.getLivro().getCodLivro());
			ps.setInt(2, livroAutor.getAutor().getCodAutor());
			ps.execute();
						
			
			ps.close();
			JDBCUtil.fechaConexao();
			inserido=true;
	
		return inserido;
		
	}
	
	public boolean atualizaLivro1(LivroAutor livroAutor)throws SQLException{
		boolean atualizado=false;
		
		
			Connection c=JDBCUtil.getConnection();
			String sql="update livroautor set codLivro=?,codAutor=? where codLivro=? and codAutor=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps=c.prepareStatement(sql);
			ps.setInt(1, livroAutor.getLivro().getCodLivro());
			ps.setInt(2, livroAutor.getAutor().getCodAutor());
			ps.setInt(3, livroAutor.getLivro().getCodLivro());
			ps.setInt(4, livroAutor.getAutor().getCodAutor());
			
			ps.execute();
			ps.close();
			JDBCUtil.fechaConexao();
			atualizado=true;
			
			
		
		return atualizado;
		
	}
	
	public boolean excluiLivro(LivroAutor livroAutor) throws SQLException{
		boolean excluido=false;
		
		
		
			Connection c=JDBCUtil.getConnection();
			String sql="delete from livroautor where codLivro=? and codAutor=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps = c.prepareStatement(sql);
			ps.setInt(1, livroAutor.getLivro().getCodLivro());
			ps.setInt(2, livroAutor.getAutor().getCodAutor());
			ps.execute();
			excluido=true;
			
			ps.close();
			JDBCUtil.fechaConexao();
					
		return excluido;
	}
	
	
	
	public List<LivroAutor> consultaListaLivro() throws SQLException{
		 List<LivroAutor> listaLivro=new ArrayList<LivroAutor>();
		 
		
			 		
				Connection c=JDBCUtil.getConnection();
				StringBuffer sql=new StringBuffer();
				sql.append("select * from livroautor");
				
				PreparedStatement ps=c.prepareStatement(sql.toString());
				ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				LivroAutor p=new LivroAutor();
							
				Livro l=new Livro();
				l.setCodLivro(rs.getInt("codLivro"));
				
				Autor a=new Autor();
				a.setCodAutor(rs.getInt("codAutor"));
				
				p.setAutor(a);
				p.setLivro(l);
				
				listaLivro.add(p);
			}
			
			rs.close();
			ps.close();
			JDBCUtil.fechaConexao();
			
		
			
		 return listaLivro;
	}
	

}
