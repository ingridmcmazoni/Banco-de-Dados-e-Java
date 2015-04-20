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

import dao.DaoAutor;
import dao.DaoAutor;
import entidades.Autor;
import entidades.Autor;

/**
 * Servlet implementation class ControllerAutor
 */
@WebServlet("/ControllerAutor")
public class ControllerAutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAutor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn=request.getParameter("cmd");
		if(btn.equalsIgnoreCase("Excluir")){
			
			
				try{
					
					Autor p=new Autor();
					p.setCodAutor(Integer.parseInt(request.getParameter("codAutor")));
					DaoAutor daoAutor=new DaoAutor();
					
					daoAutor.excluiAutor(p);
					request.setAttribute("Mensagem", "O autor foi removido com sucesso !");
					request.setAttribute("ListaAutors",daoAutor.consultaListaAutor());
					
			
				}	
				catch(SQLException erro){
					request.setAttribute("Mensagem", erro.getMessage());
					erro.printStackTrace();
							
				}
				catch(NumberFormatException erro){
					request.setAttribute("Mensagem", erro.getMessage());
					erro.printStackTrace();
				}
				finally{
					RequestDispatcher rd = request.getRequestDispatcher("./Autor.jsp");
					rd.include( request, response );
				}
			}else if(btn.equalsIgnoreCase("Atualizar")){
					
					
					try{
						
						Autor p=new Autor();
						Autor p2;
						p.setCodAutor(Integer.parseInt(request.getParameter("codAutor")));
					
						DaoAutor daoAutor=new DaoAutor();
					
						if((p2=daoAutor.consultaAutor(p))!=null){
					
							request.setAttribute("Autor", p2);
							request.setAttribute("Mensagem", "O autor foi pesquisado com sucesso !");
							
							
						}
						else{
							request.setAttribute("Mensagem", "O autor não foi encontrado !");
							
						}
					
					}
					catch(SQLException erro){
						erro.printStackTrace();
						request.setAttribute("Mensagem", erro.getMessage());
						
					}
					catch(NumberFormatException erro){
						request.setAttribute("Mensagem", erro.getMessage());
						erro.printStackTrace();
					}
					finally{
						RequestDispatcher rd = request.getRequestDispatcher("./Autor.jsp");
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
				
				Autor p=new Autor();
				p.setCodAutor(Integer.parseInt(request.getParameter("codAutor")));
				p.setNome(request.getParameter("nome"));
				
				
				DaoAutor daoAutor=new DaoAutor();
				
				
				daoAutor.insereAutor1(p);
				request.setAttribute("Mensagem", "O autor foi adicionado com sucesso !");
				request.setAttribute("ListaAutors",daoAutor.consultaListaAutor());
				
			
			}
			catch(SQLException erro){
				request.setAttribute("Mensagem", erro.getMessage());
				erro.printStackTrace();
				
			}
			catch(NumberFormatException erro){
				request.setAttribute("Mensagem", erro.getMessage());
				erro.printStackTrace();
			}
			finally{
				RequestDispatcher rd = request.getRequestDispatcher("./Autor.jsp");
				rd.include( request, response );
			}
			
			
				
		}
		else if(btn.equalsIgnoreCase("Atualizar")){
			
			try{
				Autor p=new Autor();
								
				p.setCodAutor(Integer.parseInt(request.getParameter("codAutor")));
				p.setNome(request.getParameter("nome"));
								
				DaoAutor daoAutor=new DaoAutor();
				
				daoAutor.atualizaAutor1(p);
				request.setAttribute("Mensagem", "O autor foi atualizado com sucesso !");
				request.setAttribute("ListaAutors",daoAutor.consultaListaAutor());
				
			}
			catch(SQLException erro){
				request.setAttribute("Mensagem", erro.getMessage());
				erro.printStackTrace();
				
			}
			catch(NumberFormatException erro){
				request.setAttribute("Mensagem", erro.getMessage());
				erro.printStackTrace();
			}
			finally{
				RequestDispatcher rd = request.getRequestDispatcher("./Autor.jsp");
				rd.include( request, response );
			}
			
			
			
			
				
			}
			else if(btn.equalsIgnoreCase("Excluir")){
				
				
					try{
						Autor p=new Autor();
						p.setCodAutor(Integer.parseInt(request.getParameter("codAutor")));
						DaoAutor daoAutor=new DaoAutor();
						
						daoAutor.excluiAutor(p);
						request.setAttribute("Mensagem", "O autor foi removido com sucesso !");
						request.setAttribute("ListaAutors",daoAutor.consultaListaAutor());
						
				
					}	
					catch(SQLException erro){
						request.setAttribute("Mensagem", erro.getMessage());
						erro.printStackTrace();
						
					}
					catch(NumberFormatException erro){
						request.setAttribute("Mensagem", erro.getMessage());
						erro.printStackTrace();
					}
					finally{
						RequestDispatcher rd = request.getRequestDispatcher("./Autor.jsp");
						rd.include( request, response );
					}
				
				
					
				}
				else if(btn.equalsIgnoreCase("Pesquisar")){
					
					try{
						Autor p=new Autor();
						Autor p2;
						p.setCodAutor(Integer.parseInt(request.getParameter("codAutor")));
					
						DaoAutor daoAutor=new DaoAutor();
										
						
						if((p2=daoAutor.consultaAutor(p))!=null){
					
							request.setAttribute("Autor", p2);
							request.setAttribute("Mensagem", "O autor foi pesquisado com sucesso !");
							
							
						}
						else{
							request.setAttribute("Mensagem", "O autor não foi encontrado !");
							RequestDispatcher rd = request.getRequestDispatcher("./Autor.jsp");
							rd.include( request, response );
						}
					
					}
					catch(SQLException erro){
						erro.printStackTrace();
						request.setAttribute("Mensagem", erro.getMessage());
						
					}
					catch(NumberFormatException erro){
						request.setAttribute("Mensagem", erro.getMessage());
						erro.printStackTrace();
					}
					finally{
						RequestDispatcher rd = request.getRequestDispatcher("./Autor.jsp");
						rd.include( request, response );
					}
					
					
					
				}
	}
	
	
	public List<Autor> carregaLista(){
		DaoAutor daoAutor=new DaoAutor();
		
		try {
			return daoAutor.consultaListaAutor();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	

}
