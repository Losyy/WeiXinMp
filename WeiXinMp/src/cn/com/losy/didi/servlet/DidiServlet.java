package cn.com.losy.didi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static cn.com.losy.weixinmp.util.Printer.println;

public class DidiServlet extends HttpServlet {  
    private static final long serialVersionUID = 4440739483644821988L;  
  
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    	println("DidiServlet doGet request: " + request.getRequestURI());
    	
    	String table = request.getParameter("table");
        String code = request.getParameter("code"); 
        String param = request.getParameter("param"); 
        
        String content;
        if (table.equals("p")) {
        	content = PassengerUtil.hanlde(code, param);
        } else if (table.equals("d")){
        	content = DriverUtil.hanlde(code, param);
        } else {
        	content = DriverStatuUtil.hanlde(code, param);
        }
  
        PrintWriter out = response.getWriter();  
        
        out.print(content);  
        out.close();  
        out = null;  
        
        println("DidiServlet doGet response: " + content.toString());
    }  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    	println("DidiServlet doPost request: " + request.getRequestURI());
    	
    	// 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
        request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
  
        // 调用核心业务类接收消息、处理消息  
//        String respMessage = CoreService.processRequest(request);  
//          
//        // 响应消息  
//        PrintWriter out = response.getWriter();  
//        out.print(respMessage);  
//        out.close();
//        
//        println("DidiServlet doPost response: " + respMessage);
    }  
  
}  
