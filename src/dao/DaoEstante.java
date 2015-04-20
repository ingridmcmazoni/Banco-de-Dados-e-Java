package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.*;

public class DaoEstante {
	public Estante consultaEstante(Estante estante)throws SQLException{
		Estante p=null;
		
		
			Connection c=JDBCUtil.getConnection();
			System.out.println("Conexão Efetuada");
			String sql="select * from estante where codEstante=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setInt(1, estante.getCodEstante());
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				p=new Estante();
				p.setCodEstante(rs.getInt("codEstante"));
				Bibliotecaria b=new Bibliotecaria();
				b.setCodBibliotecaria(rs.getInt("codBibliotecaria"));
				p.setB(b);
				p.setCorredor(rs.getString("corredor"));
				p.setPrateleira(rs.getString("prateleira"));
			
						
			}
			rs.close();
			ps.close();
			JDBCUtil.fechaConexao();
				
		return p;
		
	}
	
	public boolean insereEstante1(Estante estante)throws SQLException{
		boolean inserido=false;

			Connection c=JDBCUtil.getConnection();
			String sql="insert into estante values(?,?,?,?)";
			PreparedStatement ps=c.prepareStatement(sql);
			ps=c.prepareStatement(sql);
			ps.setInt(1, estante.getCodEstante());
			ps.setInt(2, estante.getB().getCodBibliotecaria());
			ps.setString(3, estante.getCorredor());
			ps.setString(4, estante.getPrateleira());
			ps.execute();
						
			
			ps.close();
			JDBCUtil.fechaConexao();
			inserido=true;
	
		return inserido;
		
	}
	
	public boolean atualizaEstante1(Estante estante)throws SQLException{
		boolean atualizado=false;
		
		
			Connection c=JDBCUtil.getConnection();
			String sql="update estante set codBibliotecaria=?,corredor=?,prateleira=? where codEstante=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps=c.prepareStatement(sql);
			ps.setInt(1, estante.getB().getCodBibliotecaria());
			ps.setString(2, estante.getCorredor());
			ps.setString(3, estante.getPrateleira());
			ps.setInt(4, estante.getCodEstante());
			
			ps.execute();
			ps.close();
			JDBCUtil.fechaConexao();
			atualizado=true;
			
			
		
		return atualizado;
		
	}
	
	public boolean excluiEstante(Estante estante) throws SQLException{
		boolean excluido=false;
		
		
		
			Connection c=JDBCUtil.getConnection();
			String sql="delete from estante where codEstante=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps = c.prepareStatement(sql);
			ps.setInt(1, estante.getCodEstante());
			ps.execute();
			excluido=true;
			
			ps.close();
			JDBCUtil.fechaConexao();
					
		return excluido;
	}
	
	
	
	
	public List<Estante> consultaListaEstante() throws SQLException{
		 List<Estante> listaEstante=new ArrayList<Estante>();
		 
		
			 		
				Connection c=JDBCUtil.getConnection();
				StringBuffer sql=new StringBuffer();
				sql.append("select * from estante");
				
				PreparedStatement ps=c.prepareStatement(sql.toString());
				ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				Estante p=new Estante();
				p=new Estante();
				p.setCodEstante(rs.getInt("codEstante"));
				
				Bibliotecaria b=new Bibliotecaria();
				b.setCodBibliotecaria(rs.getInt("codBibliotecaria"));
				p.setB(b);
				
				p.setCorredor(rs.getString("corredor"));
				p.setPrateleira(rs.getString("prateleira"));
				listaEstante.add(p);
			}
			
			rs.close();
			ps.close();
			JDBCUtil.fechaConexao();
			
		
			
		 return listaEstante;
	}
	
	

}
