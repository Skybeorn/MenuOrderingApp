package Controller;

import Services.RestaurantServer;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MenuInput", urlPatterns = {"/MenuInput"})
public class MenuInput extends HttpServlet {

    private final static String RESULT_PAGE = "/BillResult.jsp";
    private RestaurantServer waiter = new RestaurantServer();
    private String YES = "YES";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String isNewOrder = request.getParameter("isNewOrder");
        String lineItem = request.getParameter("menuChoice");

        if (isNewOrder.equals(YES)) {
            waiter = new RestaurantServer();
        }
        waiter.addToOrder(lineItem);
        
        request.setAttribute("bill", waiter.getReceipt());
        RequestDispatcher view = request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
