package com.funding.web.controller.membe.mypage;

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

import com.funding.web.dao.FundingDao;
import com.funding.web.dao.MemberDao;
import com.funding.web.dao.SelEventDao;
import com.funding.web.dao.oracle.OracleFundingDao;
import com.funding.web.dao.oracle.OracleMemberDao;
import com.funding.web.dao.oracle.OracleSelEventDao;
import com.funding.web.entity.Funding;
import com.funding.web.entity.SelEvent;
@WebServlet("/view/member/eventreg")
@MultipartConfig(
			location = "C:\\imsi",
			fileSizeThreshold = 1024*1024,
			maxFileSize = 1024*1024*5,
			maxRequestSize = 1024*1024*5*5
		)
public class EventRegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String mid = (String)session.getAttribute("id");
		
		MemberDao dao = new OracleMemberDao();
		FundingDao fDao = new OracleFundingDao();
		Funding funding = new Funding();
		try {
			
			funding = fDao.get(mid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		req.setAttribute("funding", funding);
		req.getRequestDispatcher("/WEB-INF/view/member/eventreg.jsp").forward(req,resp);
			
		}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String mid = (String)session.getAttribute("id");
		
		Part filePart = req.getPart("file");
		String manager = req.getParameter("manager");
		String sDate = req.getParameter("sDate");
		String eDate = req.getParameter("eDate");
		String eMail = req.getParameter("man_eamil");
		String rink = req.getParameter("rink");
		
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
			}else {
				String indexC = name.substring(parenS+1, parenE);
				int indexN = Integer.parseInt(indexC);
				indexN++;
				fileName = fileName.substring(0, parenS +1)+indexN + ")" + suffix;
				filePath = path+File.separator+fileName;
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
		FundingDao fDao = new OracleFundingDao();
		try {
		
			SelEvent selEvent = new SelEvent(fDao.get(mid).getId(),sDate, eDate, fileName, rink, manager, eMail);
			
			SelEventDao sdao = new OracleSelEventDao();
			result = sdao.insert(selEvent);
			
		
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
