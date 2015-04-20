package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Livro;

public class DaoLivro {
	
	public Livro consultaLivro(Livro livro)throws SQLException{
		Livro p=null;
		
		
			Connection c=JDBCUtil.getConnection();
			System.out.println("Conexão Efetuada");
			String sql="select * from livro where codLivro=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setInt(1, livro.getCodLivro());
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				p=new Livro();
				p.setCodLivro(Integer.parseInt(rs.getString("codLivro")));
				p.setTitulo(rs.getString("nome"));
				p.setEdicao(Integer.parseInt(rs.getString("edicao")));
				p.setAno(Integer.parseInt(rs.getString("ano")));
				
			}
			rs.close();
			ps.close();
			JDBCUtil.fechaConexao();
				
		return p;
		
	}
	
	public boolean insereLivro1(Livro livro)throws SQLException{
		boolean inserido=false;

			Connection c=JDBCUtil.getConnection();
			String sql="insert into livro values(?,?,?,?)";
			PreparedStatement ps=c.prepareStatement(sql);
			ps=c.prepareStatement(sql);
			ps.setInt(1, livro.getCodLivro());
			ps.setString(2, livro.getTitulo());
			ps.setInt(3, livro.getEdicao());
			ps.setInt(4, livro.getAno());
			ps.execute();
						
			
			ps.close();
			JDBCUtil.fechaConexao();
			inserido=true;
	
		return inserido;
		
	}
	
	public boolean atualizaLivro1(Livro livro)throws SQLException{
		boolean atualizado=false;
		
		
			Connection c=JDBCUtil.getConnection();
			String sql="update livro set nome=?,edicao=?,ano=? where codLivro=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps=c.prepareStatement(sql);
			ps.setString(1, livro.getTitulo());
			ps.setInt(2, livro.getEdicao());
			ps.setInt(3, livro.getAno());
			ps.setInt(4, livro.getCodLivro());
			
			ps.execute();
			ps.close();
			JDBCUtil.fechaConexao();
			atualizado=true;
			
			
		
		return atualizado;
		
	}
	
	public boolean excluiLivro(Livro livro) throws SQLException{
		boolean excluido=false;
		
		
		
			Connection c=JDBCUtil.getConnection();
			String sql="delete from livro where codLivro=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps = c.prepareStatement(sql);
			ps.setInt(1, livro.getCodLivro());
			ps.execute();
			excluido=true;
			
			ps.close();
			JDBCUtil.fechaConexao();
					
		return excluido;
	}
	
	
	
	
	public List<Livro> consultaListaLivro() throws SQLException{
		 List<Livro> listaLivro=new ArrayList<Livro>();
		 
		
			 		
				Connection c=JDBCUtil.getConnection();
				StringBuffer sql=new StringBuffer();
				sql.append("select * from livro");
				
				PreparedStatement ps=c.prepareStatement(sql.toString());
				ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				Livro p=new Livro();
				p=new Livro();
				p.setCodLivro(Integer.parseInt(rs.getString("codLivro")));
				p.setTitulo(rs.getString("nome"));
				p.setEdicao(Integer.parseInt(rs.getString("edicao")));
				p.setAno(Integer.parseInt(rs.getString("ano")));
				
				listaLivro.add(p);
			}
			
			rs.close();
			ps.close();
			JDBCUtil.fechaConexao();
			
		
			
		 return listaLivro;
	}
	

}
