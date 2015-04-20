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
 * Servlet implementation class ControllerEstante
 */
@WebServlet("/ControllerEstante")
public class ControllerEstante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerEstante() {
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
					
					Estante p=new Estante();
					p.setCodEstante(Integer.parseInt(request.getParameter("codEstante")));
					DaoEstante daoEstante=new DaoEstante();
					
					daoEstante.excluiEstante(p);
					request.setAttribute("Mensagem", "A estante foi removido com sucesso !");
					request.setAttribute("ListaEstantes",daoEstante.consultaListaEstante());
					
			
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
					RequestDispatcher rd = request.getRequestDispatcher("./Estante.jsp");
					rd.include( request, response );
				}
				
			}else if(btn.equalsIgnoreCase("Atualizar")){
					
					
					try{
						Estante p=new Estante();
						Estante p2;
						p.setCodEstante(Integer.parseInt(request.getParameter("codEstante")));
					
						DaoEstante daoEstante=new DaoEstante();
						
					
						if((p2=daoEstante.consultaEstante(p))!=null){
					
							request.setAttribute("Estante", p2);
							request.setAttribute("Mensagem", "A estante foi pesquisado com sucesso !");
							
							
						}
						else{
							request.setAttribute("Mensagem", "A estante não foi encontrado !");
							
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
						RequestDispatcher rd = request.getRequestDispatcher("./Estante.jsp");
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
				
				Estante p=new Estante();
				p.setCodEstante(Integer.parseInt(request.getParameter("codEstante")));
				
				Bibliotecaria b=new Bibliotecaria();
				String biblio=String.valueOf(request.getParameter("codBibliotecaria").charAt(0));
				b.setCodBibliotecaria(Integer.parseInt(biblio));
				
				p.setB(b);
				p.setCorredor(request.getParameter("corredor"));
				p.setPrateleira(request.getParameter("prateleira"));
								
				DaoEstante daoEstante=new DaoEstante();
				
				daoEstante.insereEstante1(p);
				request.setAttribute("Mensagem", "A estante foiadicionado com sucesso !");
				request.setAttribute("ListaEstantes",daoEstante.consultaListaEstante());
				
			
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
				RequestDispatcher rd = request.getRequestDispatcher("./Estante.jsp");
				rd.include( request, response );
			}
			
			
				
		}
		else if(btn.equalsIgnoreCase("Atualizar")){
			
			
			try{
				Estante p=new Estante();
				p.setCodEstante(Integer.parseInt(request.getParameter("codEstante")));
				
				Bibliotecaria b=new Bibliotecaria();
				String biblio=String.valueOf(request.getParameter("codBibliotecaria").charAt(0));
				b.setCodBibliotecaria(Integer.parseInt(biblio));
				
				p.setB(b);
				p.setCorredor(request.getParameter("corredor"));
				p.setPrateleira(request.getParameter("prateleira"));
				
				DaoEstante daoEstante=new DaoEstante();
				
				
				daoEstante.atualizaEstante1(p);
				request.setAttribute("Mensagem", "A estante foiatualizado com sucesso !");
				request.setAttribute("ListaEstantes",daoEstante.consultaListaEstante());
				
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
				RequestDispatcher rd = request.getRequestDispatcher("./Estante.jsp");
				rd.include( request, response );
			}
			
			
			
			
				
			}
			else if(btn.equalsIgnoreCase("Excluir")){
				
				
					try{
						Estante p=new Estante();
						p.setCodEstante(Integer.parseInt(request.getParameter("codEstante")));
						DaoEstante daoEstante=new DaoEstante();
						
						
						daoEstante.excluiEstante(p);
						request.setAttribute("Mensagem", "A estante foi removido com sucesso !");
						request.setAttribute("ListaEstantes",daoEstante.consultaListaEstante());
						
				
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
						RequestDispatcher rd = request.getRequestDispatcher("./Estante.jsp");
						rd.include( request, response );
					}
				
				
					
				}
				else if(btn.equalsIgnoreCase("Pesquisar")){
					
					
					try{
						Estante p=new Estante();
						Estante p2;
						p.setCodEstante(Integer.parseInt(request.getParameter("codEstante")));
					
						DaoEstante daoEstante=new DaoEstante();
						
					
						if((p2=daoEstante.consultaEstante(p))!=null){
					
							request.setAttribute("Estante", p2);
							request.setAttribute("Mensagem", "A estante foi pesquisado com sucesso !");
							
							
						}
						else{
							request.setAttribute("Mensagem", "A estante não foi encontrado !");
							
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
						RequestDispatcher rd = request.getRequestDispatcher("./Estante.jsp");
						rd.include( request, response );
					}
					
					
					
				}
	}
	
	
	public List<Estante> carregaLista(){
		DaoEstante daoBi=new DaoEstante();
		
		try {
			return daoBi.consultaListaEstante();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
