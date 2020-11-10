package controller;

import com.google.gson.Gson;
import model.Data;
import model.DataFactory;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// System.out.println("");
@WebServlet("/initDataServlet")
public class InitDataServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Data data = DataFactory.getInstance();
        String cmdType = req.getParameter("cmdType");
        // Check
        if (cmdType.equals("init")) {
            doLoadInitUsers(data, resp);
        }
    }

    public void doLoadInitUsers(Data data, HttpServletResponse resp) throws IOException {
        // send data to client
        sendToClient(data, resp);
    }

    public void sendToClient(Data data, HttpServletResponse resp) throws IOException {
        String respJson = new Gson().toJson(data.getBookList());
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(respJson);
    }
}


