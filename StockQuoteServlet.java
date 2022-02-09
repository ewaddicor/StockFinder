import java.io.*;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.*;

public class StockQuoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Properties data = new Properties();
	private String dataPath;

	/* Handles GET requests from the server */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Retrieves stock ticker symbol
		String ticker = req.getParameter("ticker");
		
		// Creates a StockQuote object to obtain price information
		StockQuote stock = new StockQuote(ticker); 
		req.setAttribute("stock", stock);
		
		// Dispatches stock info to stock_view.jsp
		RequestDispatcher dispatch = req.getRequestDispatcher("stock_view.jsp");
		dispatch.forward(req, resp);
	}
}
