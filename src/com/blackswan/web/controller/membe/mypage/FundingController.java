package com.blackswan.web.controller.membe.mypage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.blackswan.web.dao.FundingDao;
import com.blackswan.web.dao.MemberDao;
import com.blackswan.web.dao.oracle.OracleFundingDao;
import com.blackswan.web.dao.oracle.OracleMemberDao;
import com.blackswan.web.entity.Funding;
@WebServlet("/view/member/funding")
@MultipartConfig(
			location = "C:\\imsi",
			fileSizeThreshold = 1024*1024,
			maxFileSize = 1024*1024*5,
			maxRequestSize = 1024*1024*5*5
		)
public class FundingController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String email = (String)session.getAttribute("email");
		
		
		System.out.println(session.getAttribute("email"));
		
		req.getRequestDispatcher("/WEB-INF/view/member/funding.jsp").forward(req,resp);
			
		}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String email = (String)session.getAttribute("email");
		
		String title = req.getParameter("title");
		Part filePart = req.getPart("img");
		String category = req.getParameter("category");
		String amount = req.getParameter("amount");
		String sDate = req.getParameter("sDate");
		String eDate = req.getParameter("eDate");
		
		String urlPath = "/upload";
		String path = req.getServletContext().getRealPath(urlPath);
		System.out.println(path);
		String fileName = filePart.getSubmittedFileName();
		
		//리얼경로에서 파일명  경로지정
		String filePath = path+File.separator+fileName;
		
		File pathFile = new File(path);
		if(!pathFile.exists()) {
			pathFile.mkdirs();
		}
		
		File sameFile = new File(filePath);
		if(sameFile.exists()) {
			int ne = fileName.lastIndexOf(".");
			String name = fileName.substring(0,ne);
			String suffix = fileName.substring(ne);
			
			int parenS = name.lastIndexOf("(");
			int parenE = name.lastIndexOf(")");
			
			System.out.println(name);
			System.out.println(suffix);
			System.out.println(parenE);
			
			if(parenE == -1) {
				fileName = name + "("+1+")"+suffix;
				filePath = path+File.separator+fileName;
				System.out.println(filePath);
			}else {
				String indexC = name.substring(parenS+1, parenE);
				int indexN = Integer.parseInt(indexC);
				indexN++;
				fileName = fileName.substring(0, parenS +1)+indexN + ")" + suffix;
				
				filePath = path+File.separator+fileName;
				System.out.println(filePath);
			}
		}
		InputStream fis =filePart.getInputStream();
		OutputStream fos =new FileOutputStream(filePath);
		
		int i= 0;
		byte[] arr = new byte[1024];
		
		while((i=fis.read(arr)) != -1) {
			fos.write(arr, 0, i);
		}
		fos.close();
		fis.close();
		
		int result = 0;
		MemberDao dao = new OracleMemberDao();
		try {
			dao.get(email);
			Funding funding = new Funding(dao.get(email).getId(), category, title, amount, fileName, sDate, eDate);
			
			FundingDao fdao = new OracleFundingDao();
			result = fdao.insert(funding);
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result != 1)
			resp.sendRedirect("error");
		else
			resp.sendRedirect("mypage");
	}
	
}
