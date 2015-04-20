package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;

import entidades.Cliente;

/**
 * Servlet implementation class controllerCliente
 */
@WebServlet("/controllerCliente")
public class ControllerCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerCliente() {
        super();
        
    }
    
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn=request.getParameter("cmd");
		
		if(btn.equalsIgnoreCase("Atualizar")){
			
			
			try{
				
				Cliente p=new Cliente();
				Cliente p2;
				p.setCodCliente(Integer.parseInt(request.getParameter("codigo")));
			
				DaoCliente daoCliente=new DaoCliente();
			
				if((p2=daoCliente.consultaCliente(p))!=null){
			
					request.setAttribute("Cliente", p2);
					
					
				}
				else{
					request.setAttribute("Mensagem", "O produto não foi encontrado !");
					
				}
			
			}
			catch(SQLException erro){
				erro.printStackTrace();
				request.setAttribute("Mensagem", erro.getMessage());
				
			}
			catch(NumberFormatException erro){
				erro.printStackTrace();
				request.setAttribute("Mensagem", erro.getMessage());
			}
			finally{
				RequestDispatcher rd = request.getRequestDispatcher("./Cliente.jsp");
				rd.include( request, response );
			}
			
			
		}else if(btn.equalsIgnoreCase("Excluir")){
			
			
				try{
					
					Cliente p=new Cliente();
					p.setCodCliente(Integer.parseInt(request.getParameter("codigo")));
					DaoCliente daoCliente=new DaoCliente();
					
					daoCliente.excluiCliente(p);
					request.setAttribute("Mensagem", "O produto foi removido com sucesso !");
					request.setAttribute("ListaClientes",daoCliente.consultaListaCliente());
					
			
				}	
				catch(SQLException erro){
					request.setAttribute("Mensagem", erro.getMessage());
					erro.printStackTrace();
					
				}
				catch(NumberFormatException erro){
					erro.printStackTrace();
					request.setAttribute("Mensagem", erro.getMessage());
				}
				finally{
					RequestDispatcher rd = request.getRequestDispatcher("./Cliente.jsp");
					rd.include( request, response );
				}
			
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String btn=request.getParameter("cmd");
		
		if(btn.equalsIgnoreCase("Inserir")){
			
			try{
				Cliente p=new Cliente();
				p.setCodCliente(Integer.parseInt(request.getParameter("codigo")));
				p.setNome(request.getParameter("nome"));
				p.setLogradouro(request.getParameter("logradouro"));
				p.setEndereco(request.getParameter("endereco"));
				p.setNumero(request.getParameter("numero"));
				p.setComplemento(request.getParameter("bairro"));
				p.setCep(request.getParameter("cep"));
				p.setBairro(request.getParameter("complemento"));
				p.setTelefone(request.getParameter("telefone"));
				p.setCelular(request.getParameter("celular"));
				
				
				DaoCliente daoCliente=new DaoCliente();
				
				
				daoCliente.insereCliente1(p);
				request.setAttribute("Mensagem", "O cliente foi adicionado com sucesso !");
				request.setAttribute("ListaClientes",daoCliente.consultaListaCliente());
				
			
			}
			catch(SQLException erro){
				request.setAttribute("Mensagem", erro.getMessage());
				erro.printStackTrace();
				
			}
			catch(NumberFormatException erro){
				erro.printStackTrace();
				request.setAttribute("Mensagem", erro.getMessage());
			}
			finally{
				RequestDispatcher rd = request.getRequestDispatcher("./Cliente.jsp");
				rd.include( request, response );
			}
			
			
				
		}
		else if(btn.equalsIgnoreCase("Atualizar")){
			
			
			try{
				
				Cliente p=new Cliente();
				p.setCodCliente(Integer.parseInt(request.getParameter("codigo")));
				p.setNome(request.getParameter("nome"));
				p.setLogradouro(request.getParameter("logradouro"));
				p.setEndereco(request.getParameter("endereco"));
				p.setNumero(request.getParameter("numero"));
				p.setComplemento(request.getParameter("bairro"));
				p.setCep(request.getParameter("cep"));
				p.setBairro(request.getParameter("complemento"));
				p.setTelefone(request.getParameter("telefone"));
				p.setCelular(request.getParameter("celular"));
				
				DaoCliente daoCliente=new DaoCliente();
				
				daoCliente.atualizaCliente1(p);
				request.setAttribute("Mensagem", "O cliente foi atualizado com sucesso !");
				request.setAttribute("ListaClientes",daoCliente.consultaListaCliente());
				
			}
			catch(SQLException erro){
				request.setAttribute("Mensagem", erro.getMessage());
				erro.printStackTrace();
				
			}
			catch(NumberFormatException erro){
				erro.printStackTrace();
				request.setAttribute("Mensagem", erro.getMessage());
			}
			finally{
				RequestDispatcher rd = request.getRequestDispatcher("./Cliente.jsp");
				rd.include( request, response );
			}
			
			
			
				
			}
			else if(btn.equalsIgnoreCase("Excluir")){
				
				
					try{
						Cliente p=new Cliente();
						p.setCodCliente(Integer.parseInt(request.getParameter("codigo")));
						DaoCliente daoCliente=new DaoCliente();
						
						daoCliente.excluiCliente(p);
						request.setAttribute("Mensagem", "O produto foi removido com sucesso !");
						request.setAttribute("ListaClientes",daoCliente.consultaListaCliente());
						
				
					}	
					catch(SQLException erro){
						request.setAttribute("Mensagem", erro.getMessage());
						erro.printStackTrace();
						
					}
					catch(NumberFormatException erro){
						erro.printStackTrace();
						request.setAttribute("Mensagem", erro.getMessage());
					}
					finally{
						RequestDispatcher rd = request.getRequestDispatcher("./Cliente.jsp");
						rd.include( request, response );
					}
				
				
					
				}
				else if(btn.equalsIgnoreCase("Pesquisar")){
					
					
					try{
						Cliente p=new Cliente();
						Cliente p2;
						p.setCodCliente(Integer.parseInt(request.getParameter("codigo")));
					
						DaoCliente daoCliente=new DaoCliente();
						
					
						if((p2=daoCliente.consultaCliente(p))!=null){
					
							request.setAttribute("Cliente", p2);
							request.setAttribute("Mensagem", "O produto foi pesquisado com sucesso !");
							
							
						}
						else{
							request.setAttribute("Mensagem", "O produto não foi encontrado !");
							
						}
					
					}
					catch(SQLException erro){
						erro.printStackTrace();
						request.setAttribute("Mensagem", erro.getMessage());
						
					}
					catch(NumberFormatException erro){
						erro.printStackTrace();
						request.setAttribute("Mensagem", erro.getMessage());
					}
					finally{
						RequestDispatcher rd = request.getRequestDispatcher("./Cliente.jsp");
						rd.include( request, response );
					}
					
					
					
				}
		}
		
		
	
	public List<Cliente> carregaLista(){
		DaoCliente daoCli=new DaoCliente();
		
		try {
			return daoCli.consultaListaCliente();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	
}


