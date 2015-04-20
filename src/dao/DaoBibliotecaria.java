package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Bibliotecaria;

public class DaoBibliotecaria {

	public Bibliotecaria consultaBibliotecaria(Bibliotecaria bibliotecaria)throws SQLException{
		Bibliotecaria p=null;
		
		
			Connection c=JDBCUtil.getConnection();
			System.out.println("Conexão Efetuada");
			String sql="select * from bibliotecaria where codBibliotecaria=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setInt(1, bibliotecaria.getCodBibliotecaria());
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				p=new Bibliotecaria();
				p.setCodBibliotecaria(Integer.parseInt(rs.getString("codBibliotecaria")));
				p.setNome(rs.getString("nome"));
				
				Bibliotecaria p2=new Bibliotecaria();
				p2.setCodBibliotecaria(Integer.parseInt(rs.getString("codSupervisor")));
				
				p.setCodSupervisor(p2);
				
								
			}
			rs.close();
			ps.close();
			JDBCUtil.fechaConexao();
				
		return p;
		
	}
	
	public boolean insereBibliotecaria1(Bibliotecaria bibliotecaria)throws SQLException{
		boolean inserido=false;

			Connection c=JDBCUtil.getConnection();
			String sql="insert into bibliotecaria values(?,?,?)";
			PreparedStatement ps=c.prepareStatement(sql);
			ps=c.prepareStatement(sql);
			ps.setInt(1, bibliotecaria.getCodBibliotecaria());
			ps.setString(2, bibliotecaria.getNome());
			ps.setInt(3, bibliotecaria.getCodSupervisor().getCodBibliotecaria());
			
			ps.execute();
						
			
			ps.close();
			JDBCUtil.fechaConexao();
			inserido=true;
	
		return inserido;
		
	}
	
	public boolean atualizaBibliotecaria1(Bibliotecaria bibliotecaria)throws SQLException{
		boolean atualizado=false;
		
		
			Connection c=JDBCUtil.getConnection();
			String sql="update bibliotecaria set codSupervisor=?,nome=? where codBibliotecaria=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps=c.prepareStatement(sql);
			ps.setInt(1, bibliotecaria.getCodSupervisor().getCodBibliotecaria());
			ps.setString(2, bibliotecaria.getNome());
			ps.setInt(3, bibliotecaria.getCodBibliotecaria());
			
			ps.execute();
			ps.close();
			JDBCUtil.fechaConexao();
			atualizado=true;
			
			
		
		return atualizado;
		
	}
	
	public boolean excluiBibliotecaria(Bibliotecaria bibliotecaria) throws SQLException{
		boolean excluido=false;
		
		
		
			Connection c=JDBCUtil.getConnection();
			String sql="delete from bibliotecaria where codBibliotecaria=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps = c.prepareStatement(sql);
			ps.setInt(1, bibliotecaria.getCodBibliotecaria());
			ps.execute();
			excluido=true;
			
			ps.close();
			JDBCUtil.fechaConexao();
					
		return excluido;
	}
	
	

	
	public List<Bibliotecaria> consultaListaBibliotecaria() throws SQLException{
		 List<Bibliotecaria> listaBibliotecaria=new ArrayList<Bibliotecaria>();
		 
		
			 		
				Connection c=JDBCUtil.getConnection();
				StringBuffer sql=new StringBuffer();
				sql.append("select * from bibliotecaria");
				
				PreparedStatement ps=c.prepareStatement(sql.toString());
				ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				Bibliotecaria p=new Bibliotecaria();
				p=new Bibliotecaria();
				p.setCodBibliotecaria(Integer.parseInt(rs.getString("codBibliotecaria")));
				p.setNome(rs.getString("nome"));
				
				
				Bibliotecaria p2=new Bibliotecaria();
				p2.setCodBibliotecaria(Integer.parseInt(rs.getString("codSupervisor")));
				
				p.setCodSupervisor(p2);
				
				listaBibliotecaria.add(p);
			}
			
			rs.close();
			ps.close();
			JDBCUtil.fechaConexao();
			
		
			
		 return listaBibliotecaria;
	}
	
	
	
}
