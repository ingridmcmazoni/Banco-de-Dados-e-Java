package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.*;


public class DaoExemplar {
	public Exemplar consultaExemplar(Exemplar exemplar)throws SQLException{
		Exemplar p=null;
		
		
			Connection c=JDBCUtil.getConnection();
			System.out.println("Conexão Efetuada");
			String sql="select * from exemplar where codExemplar=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setInt(1, exemplar.getCodExemplar());
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				p=new Exemplar();
				p.setCodExemplar(rs.getInt("codExemplar"));
				
				Livro b=new Livro();
				b.setCodLivro(rs.getInt("codLivro"));
				
				Estante e=new Estante();
				e.setCodEstante(rs.getInt("codEstante"));
				
				Editora ed=new Editora();
				ed.setCodEditora(rs.getInt("codEditora"));
				
				p.setEditora(ed);
				p.setEstante(e);
				p.setLivro(b);
			
						
			}
			rs.close();
			ps.close();
			JDBCUtil.fechaConexao();
				
		return p;
		
	}
	
	public boolean insereExemplar1(Exemplar exemplar)throws SQLException{
		boolean inserido=false;

			Connection c=JDBCUtil.getConnection();
			String sql="insert into exemplar values(?,?,?,?)";
			PreparedStatement ps=c.prepareStatement(sql);
			ps=c.prepareStatement(sql);
			ps.setInt(1, exemplar.getCodExemplar());
			ps.setInt(2, exemplar.getLivro().getCodLivro());
			ps.setInt(3, exemplar.getEstante().getCodEstante());
			ps.setInt(4, exemplar.getEditora().getCodEditora());
			ps.execute();
						
			
			ps.close();
			JDBCUtil.fechaConexao();
			inserido=true;
	
		return inserido;
		
	}
	
	public boolean atualizaExemplar1(Exemplar exemplar)throws SQLException{
		boolean atualizado=false;
		
		
			Connection c=JDBCUtil.getConnection();
			String sql="update exemplar set codLivro=?,codEstante=?,codEditora=? where codExemplar=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps=c.prepareStatement(sql);
			ps.setInt(1, exemplar.getCodExemplar());
			ps.setInt(2, exemplar.getLivro().getCodLivro());
			ps.setInt(3, exemplar.getEstante().getCodEstante());
			ps.setInt(4, exemplar.getEditora().getCodEditora());
			
			ps.execute();
			ps.close();
			JDBCUtil.fechaConexao();
			atualizado=true;
			
			
		
		return atualizado;
		
	}
	
	public boolean excluiExemplar(Exemplar exemplar) throws SQLException{
		boolean excluido=false;
		
		
		
			Connection c=JDBCUtil.getConnection();
			String sql="delete from exemplar where codExemplar=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps = c.prepareStatement(sql);
			ps.setInt(1, exemplar.getCodExemplar());
			ps.execute();
			excluido=true;
			
			ps.close();
			JDBCUtil.fechaConexao();
					
		return excluido;
	}
	
		
	public List<Exemplar> consultaListaExemplar() throws SQLException{
		 List<Exemplar> listaExemplar=new ArrayList<Exemplar>();
		 
		
			 		
				Connection c=JDBCUtil.getConnection();
				StringBuffer sql=new StringBuffer();
				sql.append("select * from listaexemplar");
				
				PreparedStatement ps=c.prepareStatement(sql.toString());
				ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				Exemplar p=new Exemplar();
				p=new Exemplar();
				//p.setCodExemplar(rs.getInt("codExemplar"));
				
			
				Livro b=new Livro();
				b.setCodLivro(rs.getInt("codLivro"));
				b.setTitulo(rs.getString("nome"));
				b.setEdicao(rs.getInt("edicao"));
				b.setAno(rs.getInt("ano"));
				
				Estante e=new Estante();
				//e.setCodEstante(rs.getInt("codEstante"));
				
				Editora ed=new Editora();
				ed.setCodEditora(rs.getInt("codEditora"));
				ed.setNome(rs.getString("nomeEditora"));
				
				p.setEditora(ed);
				p.setEstante(e);
				p.setLivro(b);
				
				listaExemplar.add(p);
			}
			
			rs.close();
			ps.close();
			JDBCUtil.fechaConexao();
			
		
			
		 return listaExemplar;
	}
	
	
	public Exemplar consultaExemplar2(Exemplar exemplar) throws SQLException{
		Exemplar p=null;
		 
		
			 		
				Connection c=JDBCUtil.getConnection();
				StringBuffer sql=new StringBuffer();
				sql.append("select livroeditora.codLivro,livro.nome,livro.edicao,livro.ano,livroeditora.codEditora,editora.nomeEditora from livro inner join livroeditora on livroeditora.codLivro=livro.codLivro inner join editora on livroeditora.codEditora=editora.codEditora where livroeditora.codLivro=? and livroeditora.codEditora=?");
				
				PreparedStatement ps=c.prepareStatement(sql.toString());
				ps.setInt(1, exemplar.getLivro().getCodLivro());
				ps.setInt(2, exemplar.getEditora().getCodEditora());
				ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				p=new Exemplar();
						
			
				Livro b=new Livro();
				b.setCodLivro(rs.getInt("codLivro"));
				b.setTitulo(rs.getString("nome"));
				b.setEdicao(rs.getInt("edicao"));
				b.setAno(rs.getInt("ano"));
				
						
				Editora ed=new Editora();
				ed.setCodEditora(rs.getInt("codEditora"));
				ed.setNome(rs.getString("nomeEditora"));
				
				p.setEditora(ed);
				p.setLivro(b);
				
			
			}
			
			rs.close();
			ps.close();
			JDBCUtil.fechaConexao();
			
		
			
		 return p;
	}
	
	
}
