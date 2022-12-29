package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Menu;
import DTO.Rstrn;
import DAO.FoodDAO;

@WebServlet("/")
public class FoodController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FoodDAO dao = null;

    @Override
	public void init() throws ServletException {
		super.init();
		dao = new FoodDAO();
	}

	public FoodController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dopro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		dopro(request, response);
	}
	
	protected void dopro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String context = request.getContextPath();
		String command = request.getServletPath();
		String site = null;
		
		switch (command) {
		case "/menucheck":
			site = showmenu(request);
			break;

		case "/detailmenu":
			site = showdetail(request);
			break;
		case "/ordermenu":
			site = order(request);
			break;
		case "/orderview":
			site = checklist(request);
			break;
		case "/checkorder":
			site = orderlist(request);
			break;
		case "/checkview":
			site =view(request);
			break;
		case "/ordercheck" :
			site = "ordercheck2.jsp";
			break;
		case "/lookup":
			site = lookup(request);
			break;
		case "/delete" :
			delete(request,response);
			break;
		case "/Modify" :
			break;
		}
		
		if(site.startsWith("redirect:/")) { //redirect
			String  rview = site.substring("redirect:/".length());
			System.out.println(rview);
			response.sendRedirect(rview);
		}else {//forward
			getServletContext().getRequestDispatcher("/" + site).forward(request, response);
		}		
	}
	
	public String showmenu(HttpServletRequest request) {
		ArrayList<Menu> menulist; 
		
		try {
			menulist = dao.showMenu();
			request.setAttribute("menulist", menulist);

		} catch (SQLException e) {
			System.out.println("============컨트롤러 checkmenu에서 에러");
			e.printStackTrace();
		}
		
		return "menucheck.jsp";
	}
	
	
	public String showdetail(HttpServletRequest request) {
		Menu m = new Menu();
		try {
			String name = request.getParameter("food_name");
			m = dao.detail(name);
			request.setAttribute("m", m);
		} catch (SQLException e) {
			System.out.println("============컨트롤러 checkmenu에서 에러");
			e.printStackTrace();
		}
		
		return "detail.jsp";
	}
	
	public String order(HttpServletRequest request) {
		ArrayList<Menu> menulist; 
		
		try {
			menulist = dao.showMenu();
			request.setAttribute("menulist", menulist);

		} catch (SQLException e) {
			System.out.println("============컨트롤러 checkmenu에서 에러");
			e.printStackTrace();
		}
		
		return "ordermenu.jsp";
	}
	//주문정보 불러오기
	public String checklist(HttpServletRequest request) {
	String name = request.getParameter("food_name");
	String price = request.getParameter("price");
		
		request.setAttribute("food_name", name);
		request.setAttribute("price", price);
		
		return "orderview.jsp";
	}
	
	public String orderlist(HttpServletRequest request) {
		String name = request.getParameter("cust_name");
		String food = request.getParameter("food_name");
		int pay = Integer.parseInt(request.getParameter("pay"));
		String addr = request.getParameter("order_addr");
		
		dao.insert(name,food,pay,addr);
		Rstrn rt = new Rstrn();
		try {
			rt = dao.insertOrderList(request);
		} catch (SQLException e) {
			System.out.println("===========================콘트롤러 orderlist");
			e.printStackTrace();
		}			
		return "redirect:/checkview?order_number=" + rt.getOrder_number();
	}
	
	public String view(HttpServletRequest request) {
		Rstrn rt = new Rstrn();
		
		try {
			rt = dao.vieworder(request);
			request.setAttribute("rt", rt);
		} catch (SQLException e) {
			System.out.println("===================1");
			e.printStackTrace();
		}
		
		return "ordercheck.jsp";
	}
	
	public String lookup(HttpServletRequest request) {
		int num = Integer.parseInt(request.getParameter("order_num"));
		Rstrn rt = new Rstrn();
		try {
			rt = dao.lookup(num);
			request.setAttribute("rt", rt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "lookup.jsp";
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("order_number"));
		
		try {
			dao.delete(num);
			response.setContentType("text/html; charset=utf-8");
			PrintWriter alr = response.getWriter();
			alr.write("<script>alert('주문삭제가 완료되었습니다.'); location.href='index.jsp' </script>");
			alr.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String Modify(HttpServletRequest request) {
		int num = Integer.parseInt(request.getParameter("order_number"));
		String addr = request.getParameter("");
		
	}
	
}

