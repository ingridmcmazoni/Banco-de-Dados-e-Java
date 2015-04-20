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
 * Servlet implementation class ControllerEmprestimo
 */
@WebServlet("/ControllerEmprestimo")
public class ControllerEmprestimo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerEmprestimo() {
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
				Emprestimo p=new Emprestimo();
				Emprestimo p2;
				p.setCodExemplar(Integer.parseInt(request.getParameter("codExemplar")));
				
				Cliente c=new Cliente();
				String cliente=String.valueOf(request.getParameter("codCliente").charAt(0));
				c.setCodCliente(Integer.parseInt(cliente));
				p.setC(c);
			
				DaoEmprestimo daoEmprestimo=new DaoEmprestimo();
				
			
				if((p2=daoEmprestimo.consultaEmprestimo(p))!=null){
			
					request.setAttribute("Emprestimo", p2);
					request.setAttribute("Mensagem", "O empréstimo foi pesquisada com sucesso !");
					
					
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
				request.setAttribute("Mensagem", erro.getMessage());
				erro.printStackTrace();
			}
			finally{
				RequestDispatcher rd = request.getRequestDispatcher("./Emprestimo.jsp");
				rd.include( request, response );
			}
			
		}
		else if(btn.equalsIgnoreCase("Excluir")){
				
				
				try{
					Emprestimo p=new Emprestimo();
					p.setCodExemplar(Integer.parseInt(request.getParameter("codExemplar")));
					
					Cliente c=new Cliente();
					String cliente=String.valueOf(request.getParameter("codCliente").charAt(0));
					c.setCodCliente(Integer.parseInt(cliente));
					p.setC(c);
					
					DaoEmprestimo daoEmprestimo=new DaoEmprestimo();
										
					
					daoEmprestimo.excluiEmprestimo(p);
					request.setAttribute("Mensagem", "O empréstimo foiremovida com sucesso !");
					request.setAttribute("ListaEmprestimos",daoEmprestimo.consultaListaEmprestimo());
					
			
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
					RequestDispatcher rd = request.getRequestDispatcher("./Emprestimo.jsp");
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
				
				Emprestimo p=new Emprestimo();
				p.setCodExemplar(Integer.parseInt(request.getParameter("codExemplar")));
				
				Cliente c=new Cliente();
				String cliente=String.valueOf(request.getParameter("cliente").charAt(0));
				c.setCodCliente(Integer.parseInt(cliente));
				p.setC(c);
				
				p.setDataEmprestimo(request.getParameter("dataEmprestimo"));
				p.setDataDevolucaoPrevista(request.getParameter("devolucaoPrevista"));
				p.setDataDevolucaoReal(request.getParameter("devolucaoReal"));
				
				DaoEmprestimo daoEmprestimo=new DaoEmprestimo();
				
				daoEmprestimo.insereEmprestimo(p);
				request.setAttribute("Mensagem", "O empréstimo foiadicionada com sucesso !");
				request.setAttribute("ListaEmprestimos",daoEmprestimo.consultaListaEmprestimo());
				
			
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
				RequestDispatcher rd = request.getRequestDispatcher("./Emprestimo.jsp");
				rd.include( request, response );
			}
			
				
		}
		else if(btn.equalsIgnoreCase("Atualizar")){
			
			
			try{
				Emprestimo p=new Emprestimo();
				
				
				p.setCodExemplar(Integer.parseInt(request.getParameter("codExemplar")));
				
				Cliente c=new Cliente();
				String cliente=String.valueOf(request.getParameter("cliente").charAt(0));
				c.setCodCliente(Integer.parseInt(cliente));
				p.setC(c);
				
				p.setDataEmprestimo(request.getParameter("dataEmprestimo"));
				p.setDataDevolucaoPrevista(request.getParameter("devolucaoPrevista"));
				p.setDataDevolucaoReal(request.getParameter("devolucaoReal"));
				
				DaoEmprestimo daoEmprestimo=new DaoEmprestimo();
				
				
				daoEmprestimo.atualizaEmprestimo(p);
				request.setAttribute("Mensagem", "O empréstimo foiatualizada com sucesso !");
				request.setAttribute("ListaEmprestimos",daoEmprestimo.consultaListaEmprestimo());
				
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
				RequestDispatcher rd = request.getRequestDispatcher("./Emprestimo.jsp");
				rd.include( request, response );
			}
			
			
			
			
				
			}
			else if(btn.equalsIgnoreCase("Excluir")){
				
				
					try{
						Emprestimo p=new Emprestimo();
						p.setCodExemplar(Integer.parseInt(request.getParameter("codExemplar")));
						
						Cliente c=new Cliente();
						String cliente=String.valueOf(request.getParameter("cliente").charAt(0));
						c.setCodCliente(Integer.parseInt(cliente));
						p.setC(c);
						
						DaoEmprestimo daoEmprestimo=new DaoEmprestimo();
											
						
						daoEmprestimo.excluiEmprestimo(p);
						request.setAttribute("Mensagem", "O empréstimo foiremovida com sucesso !");
						request.setAttribute("ListaEmprestimos",daoEmprestimo.consultaListaEmprestimo());
						
				
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
						RequestDispatcher rd = request.getRequestDispatcher("./Emprestimo.jsp");
						rd.include( request, response );
					}
				
				
					
				}
				else if(btn.equalsIgnoreCase("Pesquisar")){
					
					
					try{
						Emprestimo p=new Emprestimo();
						Emprestimo p2;
						p.setCodExemplar(Integer.parseInt(request.getParameter("codExemplar")));
						
						Cliente c=new Cliente();
						String cliente=String.valueOf(request.getParameter("cliente").charAt(0));
						c.setCodCliente(Integer.parseInt(cliente));
						p.setC(c);
					
						DaoEmprestimo daoEmprestimo=new DaoEmprestimo();
						
					
						if((p2=daoEmprestimo.consultaEmprestimo(p))!=null){
					
							request.setAttribute("Emprestimo", p2);
							request.setAttribute("Mensagem", "O empréstimo foi pesquisada com sucesso !");
							
							
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
						request.setAttribute("Mensagem", erro.getMessage());
						erro.printStackTrace();
					}
					finally{
						RequestDispatcher rd = request.getRequestDispatcher("./Emprestimo.jsp");
						rd.include( request, response );
					}
					
					
					
				}
	}
	
	
	public List<Emprestimo> carregaLista(){
		DaoEmprestimo daoEmprestimo=new DaoEmprestimo();
		
		try {
			return daoEmprestimo.consultaListaEmprestimo();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}


}
