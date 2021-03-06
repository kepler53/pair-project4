package com.happyhouse.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.happyhouse.model.DTO.HouseDealDTO;
import com.happyhouse.model.DTO.MemberDTO;
import com.happyhouse.model.service.HouseDealService;
import com.happyhouse.model.service.HouseDealServiceImpl;
import com.happyhouse.model.service.MemberService;
import com.happyhouse.model.service.MemberServiceImpl;



/**
 * Servlet implementation class MainController
 */
@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberService memberService;
	private HouseDealService houseDealService;

	@Override
	public void init() throws ServletException {
		 super.init();
		 memberService = new MemberServiceImpl();
		 houseDealService = new HouseDealServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		
		String act = request.getParameter("act");
		
		System.out.println(act);
		
		if("mvlogin".equals(act)) { //로그인 페이지 이동
			response.sendRedirect(root + "/user/login.jsp");
		}else if ("login".equals(act)) { //로그인 페이지에서 로그인 버튼을 눌렀을 때
			login(request,response);
		}else if("mvjoin".equals(act)) { //회원가입 페이지 이동
			response.sendRedirect(root + "/user/join.jsp");
		}else if("join".equals(act)) { //회원가입 내용
			join(request,response);
		}else if("logout".equals(act)) {
			logout(request,response);
		}else if("delete".equals(act)) {
			delete(request,response);
		}else if("update".equals(act)) {
			update(request,response);
		}else if("search".equals(act)) {
			search(request,response);
		}
	}

	

	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		String dongcode = request.getParameter("dongcode");
		
		try {
			List<HouseDealDTO> houseList = houseDealService.search(dongcode);
			
			if(houseList != null) {
				//session 설정, id하고 비밀번호 들고 다님
					HttpSession session = request.getSession();
					session.setAttribute("houseList", houseList);
					//path 설정 => result page로 갈건지 아니면 그냥 index.jsp로 갈것인지....
					path = "/index.jsp";
				} else {
					
				}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("목록 못 불러옴");
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		MemberDTO userinfo =  (MemberDTO) request.getSession().getAttribute("userinfo");
		String userid = userinfo.getUserid();
		String userpwd = request.getParameter("userpwd");
		String email_front = request.getParameter("useremail-front");
		String email_end = request.getParameter("email");
		String email = email_front + "@" + email_end;
		
		System.out.println(userid + " " + userpwd + " " + email);
		
		MemberDTO memberDTO = new MemberDTO(userid, userpwd, email);
		
		try {
			int result = memberService.update(memberDTO);
			if(result==1) {
				//성공했을 때
				path = "/index.jsp";
			}else {
				//실패했을 때
			}
			
		}catch (Exception e) {
			System.out.println("회원 업데이트 실패했어");
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		MemberDTO userinfo =  (MemberDTO) request.getSession().getAttribute("userinfo");
		String userid = userinfo.getUserid();
		
//		System.out.println("여긴왔니");
		
		try {
			int result = memberService.delete(userid);
//			System.out.println(result);
			if(result==1) {
//				System.out.println(userid);
				HttpSession session = request.getSession();
				session.removeAttribute("userinfo");
				session.invalidate();
				response.sendRedirect(request.getContextPath());
				//성공했을 때
				path = "/index.jsp";
				
				
			}else {
				//실패했을 때
			}	
		}catch (Exception e) {
			System.out.println("회원 삭제 실패했어");
			e.printStackTrace();
		}
		
		//request.getRequestDispatcher(path).forward(request, response);
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/index.jsp"; 
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		
		try {
			MemberDTO memberDto = memberService.login(userid, userpwd);
					
			if(memberDto != null) {
			//session 설정, id하고 비밀번호 들고 다님
				HttpSession session = request.getSession();
				session.setAttribute("userinfo", memberDto);
				//path 설정 => result page로 갈건지 아니면 그냥 index.jsp로 갈것인지....
				path = "/index.jsp";
			} else {
				request.setAttribute("msg", "아이디 또는 비밀번호 확인 후 로그인해 주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "로그인 중 문제가 발생했습니다.");
			//path = "/error.jsp"; => 에러페이지
			//path 어디로 갈건지 설정 에러 페이지
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	private void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		String email_front = request.getParameter("useremail-front");
		String email_end = request.getParameter("email");
		String email = email_front + "@" + email_end;
		
//		System.out.println(email);

		MemberDTO memberDTO = new MemberDTO(userid,userpwd, email);
		
		try {
			int result = memberService.insert(memberDTO);
			if(result==1) {
				//성공했을 때
				path = "/index.jsp";
			}else {
				//실패했을 때
			}
			
		}catch (Exception e) {
			System.out.println("회원 가입 실패했어");
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("houseList");
		session.removeAttribute("userinfo");
		session.invalidate();
		response.sendRedirect(request.getContextPath());
	}
	
	
}
