package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Editora;
import entidades.Livro;
import entidades.LivroEditora;

public class DaoLivroEditora {
	public LivroEditora consultaLivro(LivroEditora livroEditora)throws SQLException{
		LivroEditora p=null;
		
		
			Connection c=JDBCUtil.getConnection();
			System.out.println("Conexão Efetuada");
			String sql="select * from livroEditora where codLivro=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setInt(1, livroEditora.getLivro().getCodLivro());
			ps.setInt(1, livroEditora.getEditora().getCodEditora());
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				p=new LivroEditora();
				
				Livro l=new Livro();
				l.setCodLivro(rs.getInt("codLivro"));
				
				Editora e=new Editora();
				e.setCodEditora(rs.getInt("codEditora"));
				
				p.setEditora(e);
				p.setLivro(l);
					
								
			}
			rs.close();
			ps.close();
			JDBCUtil.fechaConexao();
				
		return p;
		
	}
	
	public boolean insereLivro1(LivroEditora livroEditora)throws SQLException{
		boolean inserido=false;

			Connection c=JDBCUtil.getConnection();
			String sql="insert into livroeditora values(?,?)";
			PreparedStatement ps=c.prepareStatement(sql);
			ps=c.prepareStatement(sql);
			ps.setInt(1, livroEditora.getLivro().getCodLivro());
			ps.setInt(2, livroEditora.getEditora().getCodEditora());
			ps.execute();
						
			
			ps.close();
			JDBCUtil.fechaConexao();
			inserido=true;
	
		return inserido;
		
	}
	
	public boolean atualizaLivro1(LivroEditora livroEditora)throws SQLException{
		boolean atualizado=false;
		
		
			Connection c=JDBCUtil.getConnection();
			String sql="update livroeditora set codLivro=?,codEditora=? where codLivro=? and codEditora=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps=c.prepareStatement(sql);
			ps.setInt(1, livroEditora.getLivro().getCodLivro());
			ps.setInt(2, livroEditora.getEditora().getCodEditora());
			ps.setInt(3, livroEditora.getLivro().getCodLivro());
			ps.setInt(4, livroEditora.getEditora().getCodEditora());
			
			ps.execute();
			ps.close();
			JDBCUtil.fechaConexao();
			atualizado=true;
			
			
		
		return atualizado;
		
	}
	
	public boolean excluiLivro(LivroEditora livroEditora) throws SQLException{
		boolean excluido=false;
		
		
		
			Connection c=JDBCUtil.getConnection();
			String sql="delete from livroeditora where codLivro=? and codEditora=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps = c.prepareStatement(sql);
			ps.setInt(1, livroEditora.getLivro().getCodLivro());
			ps.setInt(2, livroEditora.getEditora().getCodEditora());
			ps.execute();
			excluido=true;
			
			ps.close();
			JDBCUtil.fechaConexao();
					
		return excluido;
	}
	
	
	
	public List<LivroEditora> consultaListaLivro() throws SQLException{
		 List<LivroEditora> listaLivro=new ArrayList<LivroEditora>();
		 
		
			 		
				Connection c=JDBCUtil.getConnection();
				StringBuffer sql=new StringBuffer();
				sql.append("select * from livroeditora");
				
				PreparedStatement ps=c.prepareStatement(sql.toString());
				ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				LivroEditora p=new LivroEditora();
							
				Livro l=new Livro();
				l.setCodLivro(rs.getInt("codLivro"));
				
				Editora e=new Editora();
				e.setCodEditora(rs.getInt("codEditora"));
				
				p.setEditora(e);
				p.setLivro(l);
				
				listaLivro.add(p);
			}
			
			rs.close();
			ps.close();
			JDBCUtil.fechaConexao();
			
		
			
		 return listaLivro;
	}
	


}
