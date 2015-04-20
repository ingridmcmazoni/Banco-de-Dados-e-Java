package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.*;

public class DaoEmprestimo {
	
	public Emprestimo consultaEmprestimo(Emprestimo emprestimo)throws SQLException{
		Emprestimo p=null;
		
		
			Connection c=JDBCUtil.getConnection();
			System.out.println("Conexão Efetuada");
			String sql="select * from listaEmprestimo where codExemplar=? and codCliente=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setInt(1, emprestimo.getCodExemplar());
			ps.setInt(2, emprestimo.getC().getCodCliente());
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				p=new Emprestimo();
				p.setCodExemplar(Integer.parseInt(rs.getString("codExemplar")));
				
				Cliente cli=new Cliente();
				cli.setCodCliente(Integer.parseInt(rs.getString("codCliente")));
				p.setC(cli);
				p.setDataEmprestimo(rs.getString("dataEmprestimo"));
				p.setDataDevolucaoPrevista(rs.getString("dataDevolucaoPrevista"));
				p.setDataDevolucaoReal(rs.getString("dataDevolucaoReal"));
				
				
						
			}
			rs.close();
			ps.close();
			JDBCUtil.fechaConexao();
				
		return p;
		
	}
	
	public boolean insereEmprestimo1(Emprestimo emprestimo)throws SQLException{
		boolean inserido=false;

			Connection c=JDBCUtil.getConnection();
			String sql="insert into emprestimo values(?,?,?,?,?)";
			PreparedStatement ps=c.prepareStatement(sql);
			ps=c.prepareStatement(sql);
			ps.setInt(1, emprestimo.getCodExemplar());
			ps.setInt(2, emprestimo.getC().getCodCliente());
			ps.setString(3, emprestimo.getDataEmprestimo());
			ps.setString(4, emprestimo.getDataDevolucaoReal());
			ps.setString(5,emprestimo.getDataDevolucaoPrevista());
			ps.execute();
						
			
			ps.close();
			JDBCUtil.fechaConexao();
			inserido=true;
	
		return inserido;
		
	}
	
	public boolean atualizaEmprestimo1(Emprestimo emprestimo)throws SQLException{
		boolean atualizado=false;
		
		
			Connection c=JDBCUtil.getConnection();
			String sql="update emprestimo set codCliente=?,dataEmprestimo=?,dataDevolucaoPrevista=?,dataDevolucaoReal=? where codExemplar=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps=c.prepareStatement(sql);
			ps.setInt(1, emprestimo.getC().getCodCliente());
			ps.setString(2, emprestimo.getDataEmprestimo());
			ps.setString(3, emprestimo.getDataDevolucaoReal());
			ps.setString(4,emprestimo.getDataDevolucaoPrevista());
			ps.setInt(5, emprestimo.getCodExemplar());
			
			ps.execute();
			ps.close();
			JDBCUtil.fechaConexao();
			atualizado=true;
			
			
		
		return atualizado;
		
	}
	
	public boolean excluiEmprestimo(Emprestimo emprestimo) throws SQLException{
		boolean excluido=false;
		
		
		
			Connection c=JDBCUtil.getConnection();
			String sql="delete from emprestimo where codExemplar=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps = c.prepareStatement(sql);
			ps.setInt(1, emprestimo.getCodExemplar());
			ps.execute();
			excluido=true;
			
			ps.close();
			JDBCUtil.fechaConexao();
					
		return excluido;
	}
	
	
	public boolean insereEmprestimo(Emprestimo emprestimo)throws SQLException{
		boolean inserido=false;
			
		
			Connection c=JDBCUtil.getConnection();
			String sql="{call biblioteca.insereEmprestimo(?,?,?,?,?)}";
			CallableStatement cs=c.prepareCall(sql);
			cs.setInt(1, emprestimo.getCodExemplar());
			cs.setInt(2, emprestimo.getC().getCodCliente());
			cs.setString(3, emprestimo.getDataEmprestimo());
			cs.setString(4, emprestimo.getDataDevolucaoPrevista());
			cs.setString(5, emprestimo.getDataDevolucaoReal());
			cs.execute();
			cs.close();
			JDBCUtil.fechaConexao();
			inserido=true;
			
		
		return inserido;
	}
	
	public boolean atualizaEmprestimo(Emprestimo emprestimo)throws SQLException{
		boolean inserido=false;
			
		
			Connection c=JDBCUtil.getConnection();
			String sql="{call biblioteca.atualizaEmprestimo(?,?,?,?,?)}";
			CallableStatement cs=c.prepareCall(sql);
			cs.setInt(1, emprestimo.getCodExemplar());
			cs.setInt(2, emprestimo.getC().getCodCliente());
			cs.setString(3, emprestimo.getDataEmprestimo());
			cs.setString(4, emprestimo.getDataDevolucaoPrevista());
			cs.setString(5, emprestimo.getDataDevolucaoReal());
			cs.execute();
			cs.close();
			inserido=true;
			cs.close();
			JDBCUtil.fechaConexao();
			
		
		return inserido;
	}
	
	public List<Emprestimo> consultaListaEmprestimo() throws SQLException{
		 List<Emprestimo> listaEmprestimo=new ArrayList<Emprestimo>();
		 
		
			 		
				Connection c=JDBCUtil.getConnection();
				StringBuffer sql=new StringBuffer();
				sql.append("select * from listaEmprestimo");
				
				PreparedStatement ps=c.prepareStatement(sql.toString());
				ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				Emprestimo p=new Emprestimo();
				p=new Emprestimo();
				p.setCodExemplar(Integer.parseInt(rs.getString("codExemplar")));
				
				Cliente cli=new Cliente();
				cli.setCodCliente(Integer.parseInt(rs.getString("codCliente")));
				p.setC(cli);
				
				p.setDataEmprestimo(rs.getString("dataEmprestimo"));
				p.setDataDevolucaoPrevista(rs.getString("dataDevolucaoPrevista"));
				p.setDataDevolucaoReal(rs.getString("dataDevolucaoReal"));
				
				listaEmprestimo.add(p);
			}
			
			rs.close();
			ps.close();
			JDBCUtil.fechaConexao();
			
		
			
		 return listaEmprestimo;
	}
	
	

}
