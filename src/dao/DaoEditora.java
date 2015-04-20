package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Editora;

public class DaoEditora {
	
	public Editora consultaEditora(Editora editora)throws SQLException{
		Editora p=null;
		
		
			Connection c=JDBCUtil.getConnection();
			System.out.println("Conexão Efetuada");
			String sql="select * from editora where codEditora=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setInt(1, editora.getCodEditora());
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				p=new Editora();
				p.setCodEditora(Integer.parseInt(rs.getString("codEditora")));
				p.setNome(rs.getString("nomeEditora"));
				p.setCnpj(rs.getString("cnpjEditora"));
				p.setRazaoSocial(rs.getString("razaoSocial"));
										
			}
			rs.close();
			ps.close();
			JDBCUtil.fechaConexao();
				
		return p;
		
	}
	
	public boolean insereEditora1(Editora editora)throws SQLException{
		boolean inserido=false;

			Connection c=JDBCUtil.getConnection();
			String sql="insert into editora values(?,?,?,?)";
			PreparedStatement ps=c.prepareStatement(sql);
			ps=c.prepareStatement(sql);
			ps.setInt(1, editora.getCodEditora());
			ps.setString(2, editora.getNome());
			ps.setString(3, editora.getCnpj());
			ps.setString(4, editora.getRazaoSocial());
		
			ps.execute();
						
			
			ps.close();
			JDBCUtil.fechaConexao();
			inserido=true;
	
		return inserido;
		
	}
	
	public boolean atualizaEditora1(Editora editora)throws SQLException{
		boolean atualizado=false;
		
		
			Connection c=JDBCUtil.getConnection();
			String sql="update editora set nomeEditora=?,cnpjEditora=?,razaoSocial=? where codEditora=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps=c.prepareStatement(sql);
			ps.setString(1, editora.getNome());
			ps.setString(2, editora.getCnpj());
			ps.setString(3, editora.getRazaoSocial());
			ps.setInt(4, editora.getCodEditora());
			
			ps.execute();
			ps.close();
			JDBCUtil.fechaConexao();
			atualizado=true;
			
			
		
		return atualizado;
		
	}
	
	public boolean excluiEditora(Editora editora) throws SQLException{
		boolean excluido=false;
		
		
		
			Connection c=JDBCUtil.getConnection();
			String sql="delete from editora where codEditora=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps = c.prepareStatement(sql);
			ps.setInt(1, editora.getCodEditora());
			ps.execute();
			excluido=true;
			
			ps.close();
			JDBCUtil.fechaConexao();
					
		return excluido;
	}
	
	
	
	public List<Editora> consultaListaEditora() throws SQLException{
		 List<Editora> listaEditora=new ArrayList<Editora>();
		 
		
			 		
				Connection c=JDBCUtil.getConnection();
				StringBuffer sql=new StringBuffer();
				sql.append("select * from editora");
				
				PreparedStatement ps=c.prepareStatement(sql.toString());
				ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				Editora p=new Editora();
				p=new Editora();
				p.setCodEditora(Integer.parseInt(rs.getString("codEditora")));
				p.setNome(rs.getString("nomeEditora"));
				p.setCnpj(rs.getString("cnpjEditora"));
				p.setRazaoSocial(rs.getString("razaoSocial"));
				listaEditora.add(p);
			}
			
			rs.close();
			ps.close();
			JDBCUtil.fechaConexao();
			
		
			
		 return listaEditora;
	}
	


}
