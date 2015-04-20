package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import entidades.*;

/**
 * Servlet implementation class ControllerEditora
 */
@WebServlet("/ControllerEditora")
public class ControllerEditora extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerEditora() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn=request.getParameter("cmd");
		
		if(btn.equalsIgnoreCase("Atualizar")){
			
			
			try{
				Editora p=new Editora();
				Editora p2;
				p.setCodEditora(Integer.parseInt(request.getParameter("codEditora")));
			
				DaoEditora daoEditora=new DaoEditora();
				
				if((p2=daoEditora.consultaEditora(p))!=null){
			
					request.setAttribute("Editora", p2);
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
				RequestDispatcher rd = request.getRequestDispatcher("./Editora.jsp");
				rd.include( request, response );
			}
		}else if(btn.equalsIgnoreCase("Excluir")){
				
				
					try{
						Editora p=new Editora();
						p.setCodEditora(Integer.parseInt(request.getParameter("codEditora")));
						DaoEditora daoEditora=new DaoEditora();
						
						
						daoEditora.excluiEditora(p);
						request.setAttribute("Mensagem", "A editora foi removido com sucesso !");
						request.setAttribute("ListaEditoras",daoEditora.consultaListaEditora());
					
				
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
						RequestDispatcher rd = request.getRequestDispatcher("./Editora.jsp");
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
				Editora p=new Editora();
				p.setCodEditora(Integer.parseInt(request.getParameter("codEditora")));
				p.setNome(request.getParameter("nome"));
				p.setCnpj(request.getParameter("cnpj"));
				p.setRazaoSocial(request.getParameter("razaoSocial"));
				
				DaoEditora daoEditora=new DaoEditora();
				
				
				daoEditora.insereEditora1(p);
				request.setAttribute("Mensagem", "A editora foi adicionada com sucesso !");
				request.setAttribute("ListaEditoras",daoEditora.consultaListaEditora());
				
			
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
				RequestDispatcher rd = request.getRequestDispatcher("./Editora.jsp");
				rd.include( request, response );
			}
			
			
				
		}
		else if(btn.equalsIgnoreCase("Atualizar")){
			
			
			try{
				Editora p=new Editora();
							
				p.setCodEditora(Integer.parseInt(request.getParameter("codEditora")));
				p.setNome(request.getParameter("nome"));
				p.setCnpj(request.getParameter("cnpj"));
				p.setRazaoSocial(request.getParameter("razaoSocial"));
				
				DaoEditora daoEditora=new DaoEditora();
				
				
				daoEditora.atualizaEditora1(p);
				request.setAttribute("Mensagem", "A editora foi atualizada com sucesso !");
				request.setAttribute("ListaEditoras",daoEditora.consultaListaEditora());
				
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
				RequestDispatcher rd = request.getRequestDispatcher("./Editora.jsp");
				rd.include( request, response );
			}
			
			
			
			
				
			}
			else if(btn.equalsIgnoreCase("Excluir")){
				
					try{
						
						Editora p=new Editora();
						p.setCodEditora(Integer.parseInt(request.getParameter("codEditora")));
						DaoEditora daoEditora=new DaoEditora();
						
						
						daoEditora.excluiEditora(p);
						request.setAttribute("Mensagem", "A editora foi removida com sucesso !");
						request.setAttribute("ListaEditoras",daoEditora.consultaListaEditora());
						
				
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
						RequestDispatcher rd = request.getRequestDispatcher("./Editora.jsp");
						rd.include( request, response );
					}
				
				
					
				}
				else if(btn.equalsIgnoreCase("Pesquisar")){
					
					
					try{
						Editora p=new Editora();
						Editora p2;
						p.setCodEditora(Integer.parseInt(request.getParameter("codEditora")));
					
						DaoEditora daoEditora=new DaoEditora();
						
					
						if((p2=daoEditora.consultaEditora(p))!=null){
					
							request.setAttribute("Editora", p2);
							request.setAttribute("Mensagem", "A editora foi pesquisada com sucesso !");
							
							
						}
						else{
							request.setAttribute("Mensagem", "A editora não foi encontrada !");
							
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
						RequestDispatcher rd = request.getRequestDispatcher("./Editora.jsp");
						rd.include( request, response );
					}
					
					
					
				}
		}
		
	
	public List<Editora> carregaLista(){
		DaoEditora daoEd=new DaoEditora();
		
		try {
			return daoEd.consultaListaEditora();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
		
	}


