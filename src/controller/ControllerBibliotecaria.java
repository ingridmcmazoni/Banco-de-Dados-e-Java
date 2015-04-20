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

import dao.DaoBibliotecaria;
import dao.DaoBibliotecaria;
import entidades.Bibliotecaria;
import entidades.Bibliotecaria;

/**
 * Servlet implementation class ControllerBibliotecaria
 */
@WebServlet("/ControllerBibliotecaria")
public class ControllerBibliotecaria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerBibliotecaria() {
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
					
					Bibliotecaria p=new Bibliotecaria();
					p.setCodBibliotecaria(Integer.parseInt(request.getParameter("codigo")));
					DaoBibliotecaria daoBibliotecaria=new DaoBibliotecaria();
					
					daoBibliotecaria.excluiBibliotecaria(p);
					request.setAttribute("Mensagem", "O produto foi removido com sucesso !");
					request.setAttribute("ListaBibliotecarias",daoBibliotecaria.consultaListaBibliotecaria());
					
			
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
					RequestDispatcher rd = request.getRequestDispatcher("./Bibliotecaria.jsp");
					rd.include( request, response );
				
				}
			
			}else if(btn.equalsIgnoreCase("Atualizar")){
					
					
					try{
						Bibliotecaria p=new Bibliotecaria();
						Bibliotecaria p2;
						p.setCodBibliotecaria(Integer.parseInt(request.getParameter("codigo")));
					
						DaoBibliotecaria daoBibliotecaria=new DaoBibliotecaria();
					
						if((p2=daoBibliotecaria.consultaBibliotecaria(p))!=null){
					
							request.setAttribute("Bibliotecaria", p2);
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
						request.setAttribute("Mensagem", erro.getMessage());
						erro.printStackTrace();
					}
					finally{
						RequestDispatcher rd = request.getRequestDispatcher("./Bibliotecaria.jsp");
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
				
				Bibliotecaria p=new Bibliotecaria();
				p.setCodBibliotecaria(Integer.parseInt(request.getParameter("codigo")));
				p.setNome(request.getParameter("nome"));
				
				Bibliotecaria p2=new Bibliotecaria();
				try{
					String supervisor=String.valueOf(request.getParameter("supervisor").charAt(0));
					p2.setCodBibliotecaria(Integer.parseInt(supervisor));
				}
				catch(NullPointerException e){
					p2.setCodBibliotecaria(Integer.parseInt(request.getParameter("codigo")));
						
				}
				
				
				p.setCodSupervisor(p2);
				
				DaoBibliotecaria daoBibliotecaria=new DaoBibliotecaria();
				
				daoBibliotecaria.insereBibliotecaria1(p);
				request.setAttribute("Mensagem", "O cliente foi adicionado com sucesso !");
				request.setAttribute("ListaBibliotecarias",daoBibliotecaria.consultaListaBibliotecaria());
				
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
				RequestDispatcher rd = request.getRequestDispatcher("./Bibliotecaria.jsp");
				rd.include( request, response );
			
			}
			
			
				
		}
		else if(btn.equalsIgnoreCase("Atualizar")){
			
			
			try{
				Bibliotecaria p=new Bibliotecaria();
				
				p.setCodBibliotecaria(Integer.parseInt(request.getParameter("codigo")));
				p.setNome(request.getParameter("nome"));
				
				Bibliotecaria p2=new Bibliotecaria();
				String supervisor=String.valueOf(request.getParameter("supervisor").charAt(0));
				p2.setCodBibliotecaria(Integer.parseInt(supervisor));
				
				p.setCodSupervisor(p2);
				
				
				DaoBibliotecaria daoBibliotecaria=new DaoBibliotecaria();
				
				daoBibliotecaria.atualizaBibliotecaria1(p);
				request.setAttribute("Mensagem", "O cliente foi atualizado com sucesso !");
				request.setAttribute("ListaBibliotecarias",daoBibliotecaria.consultaListaBibliotecaria());
				
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
				RequestDispatcher rd = request.getRequestDispatcher("./Bibliotecaria.jsp");
				rd.include( request, response );
			
			}
						
			}
			else if(btn.equalsIgnoreCase("Excluir")){
				
				
					try{
						
						Bibliotecaria p=new Bibliotecaria();
						p.setCodBibliotecaria(Integer.parseInt(request.getParameter("codigo")));
						DaoBibliotecaria daoBibliotecaria=new DaoBibliotecaria();
						
						daoBibliotecaria.excluiBibliotecaria(p);
						request.setAttribute("Mensagem", "O produto foi removido com sucesso !");
						request.setAttribute("ListaBibliotecarias",daoBibliotecaria.consultaListaBibliotecaria());
						
				
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
						RequestDispatcher rd = request.getRequestDispatcher("./Bibliotecaria.jsp");
						rd.include( request, response );
					
					}	
				
				
					
				}
				else if(btn.equalsIgnoreCase("Pesquisar")){
					
					
					try{
						
						Bibliotecaria p=new Bibliotecaria();
						Bibliotecaria p2;
						p.setCodBibliotecaria(Integer.parseInt(request.getParameter("codigo")));
					
						DaoBibliotecaria daoBibliotecaria=new DaoBibliotecaria();
					
						if((p2=daoBibliotecaria.consultaBibliotecaria(p))!=null){
					
							request.setAttribute("Bibliotecaria", p2);
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
						request.setAttribute("Mensagem", erro.getMessage());
						erro.printStackTrace();
					}
					finally{
						RequestDispatcher rd = request.getRequestDispatcher("./Bibliotecaria.jsp");
						rd.include( request, response );
					
					}
					
					
				}
	}
	
	public List<Bibliotecaria> carregaLista(){
		DaoBibliotecaria daoBi=new DaoBibliotecaria();
		
		try {
			return daoBi.consultaListaBibliotecaria();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
