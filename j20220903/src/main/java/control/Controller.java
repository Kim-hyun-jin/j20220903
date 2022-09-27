package control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommandProcess;

/**
 * Servlet implementation class Controller
 */
// @WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Map<String, Object> commandMap = new HashMap<String, Object>();
    
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// web.xml에서 propertyConfig에 해당하는 init-param 의 값을 읽어와 String으로 만듦 (properties파일이름)
		String props = config.getInitParameter("config");
		// /WEB-INF/command.properties
		System.out.println("1. String props=>"+props); // /ch16/com
		
		Properties			pr	= new Properties();  //properties방식으로 읽은 String값을 만들기 위해 pr선언.
		FileInputStream		f	= null;
		
		
		
		try {
			String configFilePath	= config.getServletContext().getRealPath(props); //배포된 위치에 있는 파일을 읽어왔다!
			System.out.println("2. String configFilePath=>"+configFilePath); // och16/com //.metadata~ 폴더는 배포되는 웹app의 폴더.
			f = new FileInputStream(configFilePath); //proferties형식의 파일이 이 생성되었다!
			System.out.println("2.5 f => "+f);
			
			pr.load(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (f != null) 
				try { f.close();
			} catch (Exception e2) {}
		}
		Iterator keyIter = pr.keySet().iterator(); 
		
		while(keyIter.hasNext()) {
			String command  = (String)keyIter.next();
			String className= pr.getProperty(command);
			System.out.println("3. init command => "+command);
			System.out.println("4. init className => "+className);
			
			try {
				Class commandClass = Class.forName(className);
				Object commandInstance = commandClass.newInstance();
				commandMap.put(command, commandInstance);
				
			} catch (Exception e) {
			}
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestServletPro(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestServletPro(request, response);
	}
	protected void requestServletPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String			view	= null;
		CommandProcess	com		= null;
		String			command	= request.getRequestURI();
		System.out.println("1. requestServletPro command => "+command); 
		command = command.substring(request.getContextPath().length());
		System.out.println("2. requestServletPro command substring => "+command);
		
		try {
			com = (CommandProcess) commandMap.get(command);
			System.out.println("3. requestServletPro command => "+command);
			System.out.println("4. requestServletPro com => "+com);
			
			view = com.requestPro(request, response);
			System.out.println("5. requestServletPro view => "+view);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		if(command.contains("ajaxGet")) {
			System.out.println("ajaxGet String->"+command);
			String writer = (String) request.getAttribute("writer");
			PrintWriter pw = response.getWriter();
			pw.write(writer);
			pw.flush();
			
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}
}
