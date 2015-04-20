package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


import entidades.Cliente;

public class DaoCliente {
	
	public DaoCliente(){
		
	}
	
	 

	public Cliente consultaCliente(Cliente cliente)throws SQLException{
		Cliente p=null;
		
		
			Connection c=JDBCUtil.getConnection();
			System.out.println("Conexão Efetuada");
			String sql="select * from cliente where codCliente=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setInt(1, cliente.getCodCliente());
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				p=new Cliente();
				p.setCodCliente(Integer.parseInt(rs.getString("codCliente")));
				p.setNome(rs.getString("nome"));
				p.setLogradouro(rs.getString("logradouro"));
				p.setEndereco(rs.getString("endereco"));
				p.setNumero(rs.getString("numero"));
				p.setComplemento(rs.getString("bairro"));
				p.setCep(rs.getString("cep"));
				p.setBairro(rs.getString("complemento"));
				p.setTelefone(rs.getString("telefone"));
				p.setCelular(rs.getString("celular"));
				
						
			}
			rs.close();
			ps.close();
			JDBCUtil.fechaConexao();
				
		return p;
		
	}
	
	public boolean insereCliente1(Cliente cliente)throws SQLException{
		boolean inserido=false;

			Connection c=JDBCUtil.getConnection();
			String sql="insert into cliente values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=c.prepareStatement(sql);
			ps=c.prepareStatement(sql);
			ps.setInt(1, cliente.getCodCliente());
			ps.setString(2, cliente.getNome());
			ps.setString(3, cliente.getLogradouro());
			ps.setString(4, cliente.getEndereco());
			ps.setString(5,cliente.getNumero());
			ps.setString(6,cliente.getBairro());
			ps.setString(7, cliente.getCep());
			ps.setString(8, cliente.getComplemento());
			ps.setString(9, cliente.getTelefone());
			ps.setString(10, cliente.getCelular());
			ps.execute();
						
			
			ps.close();
			JDBCUtil.fechaConexao();
			inserido=true;
	
		return inserido;
		
	}
	
	public boolean atualizaCliente1(Cliente cliente)throws SQLException{
		boolean atualizado=false;
		
		
			Connection c=JDBCUtil.getConnection();
			String sql="update cliente set nome=?,logradouro=?,endereco=?,numero=?,bairro=?,cep=?,complemento=?,telefone=?,celular=? where codCliente=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps=c.prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getLogradouro());
			ps.setString(3, cliente.getEndereco());
			ps.setString(4,cliente.getNumero());
			ps.setString(5,cliente.getBairro());
			ps.setString(6, cliente.getCep());
			ps.setString(7, cliente.getComplemento());
			ps.setString(8, cliente.getTelefone());
			ps.setString(9, cliente.getCelular());
			ps.setInt(10, cliente.getCodCliente());
			
			ps.execute();
			ps.close();
			JDBCUtil.fechaConexao();
			atualizado=true;
			
			
		
		return atualizado;
		
	}
	
	public boolean excluiCliente(Cliente cliente) throws SQLException{
		boolean excluido=false;
		
		
		
			Connection c=JDBCUtil.getConnection();
			String sql="delete from cliente where codCliente=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps = c.prepareStatement(sql);
			ps.setInt(1, cliente.getCodCliente());
			ps.execute();
			excluido=true;
			
			ps.close();
			JDBCUtil.fechaConexao();
					
		return excluido;
	}
	
	
	
	
	public List<Cliente> consultaListaCliente() throws SQLException{
		 List<Cliente> listaCliente=new ArrayList<Cliente>();
		 
		
			 		
				Connection c=JDBCUtil.getConnection();
				StringBuffer sql=new StringBuffer();
				sql.append("select * from cliente");
				
				PreparedStatement ps=c.prepareStatement(sql.toString());
				ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				Cliente p=new Cliente();
				p=new Cliente();
				p.setCodCliente(Integer.parseInt(rs.getString("codCliente")));
				p.setNome(rs.getString("nome"));
				p.setLogradouro(rs.getString("logradouro"));
				p.setEndereco(rs.getString("endereco"));
				p.setNumero(rs.getString("numero"));
				p.setComplemento(rs.getString("bairro"));
				p.setCep(rs.getString("cep"));
				p.setBairro(rs.getString("complemento"));
				p.setTelefone(rs.getString("telefone"));
				p.setCelular(rs.getString("celular"));
				listaCliente.add(p);
			}
			
			rs.close();
			ps.close();
			JDBCUtil.fechaConexao();
			
		
			
		 return listaCliente;
	}
	

}
