package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Autor;

public class DaoAutor {
	
	public Autor consultaAutor(Autor autor)throws SQLException{
		Autor p=null;
		
		
			Connection c=JDBCUtil.getConnection();
			System.out.println("Conexão Efetuada");
			String sql="select * from autor where codAutor=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setInt(1, autor.getCodAutor());
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				p=new Autor();
				p.setCodAutor(Integer.parseInt(rs.getString("codAutor")));
				p.setNome(rs.getString("nome"));
				
				
						
			}
			rs.close();
			ps.close();
			JDBCUtil.fechaConexao();
				
		return p;
		
	}
	
	public boolean insereAutor1(Autor autor)throws SQLException{
		boolean inserido=false;

			Connection c=JDBCUtil.getConnection();
			String sql="insert into autor values(?,?)";
			PreparedStatement ps=c.prepareStatement(sql);
			ps=c.prepareStatement(sql);
			ps.setInt(1, autor.getCodAutor());
			ps.setString(2, autor.getNome());
			ps.execute();
						
			
			ps.close();
			JDBCUtil.fechaConexao();
			inserido=true;
	
		return inserido;
		
	}
	
	public boolean atualizaAutor1(Autor autor)throws SQLException{
		boolean atualizado=false;
		
		
			Connection c=JDBCUtil.getConnection();
			String sql="update autor set nome=? where codAutor=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps=c.prepareStatement(sql);
			ps.setString(1, autor.getNome());
			ps.setInt(2, autor.getCodAutor());
			
			ps.execute();
			ps.close();
			JDBCUtil.fechaConexao();
			atualizado=true;
			
			
		
		return atualizado;
		
	}
	
	public boolean excluiAutor(Autor autor) throws SQLException{
		boolean excluido=false;
		
		
		
			Connection c=JDBCUtil.getConnection();
			String sql="delete from autor where codAutor=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps = c.prepareStatement(sql);
			ps.setInt(1, autor.getCodAutor());
			ps.execute();
			excluido=true;
			
			ps.close();
			JDBCUtil.fechaConexao();
					
		return excluido;
	}
	
	
	
	
	public List<Autor> consultaListaAutor() throws SQLException{
		 List<Autor> listaAutor=new ArrayList<Autor>();
		 
		
			 		
				Connection c=JDBCUtil.getConnection();
				StringBuffer sql=new StringBuffer();
				sql.append("select * from autor");
				
				PreparedStatement ps=c.prepareStatement(sql.toString());
				ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				Autor p=new Autor();
				p=new Autor();
				p.setCodAutor(Integer.parseInt(rs.getString("codAutor")));
				p.setNome(rs.getString("nome"));
				listaAutor.add(p);
			}
			
			rs.close();
			ps.close();
			JDBCUtil.fechaConexao();
			
		
			
		 return listaAutor;
	}
	
	

}
