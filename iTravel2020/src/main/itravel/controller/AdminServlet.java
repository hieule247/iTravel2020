package itravel.controller;

import com.google.gson.Gson;
import itravel.model.Data;
import itravel.model.DataFactory;
import itravel.model.User;
import service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author Hailian
 * @Poject name iTravel2020
 * @creat2020-11-10 3:53 PM
 */

import service.AdminService;

import static java.lang.Boolean.parseBoolean;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    protected void getUserList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);

//        List<User> userList = DataFactory.getInstance().getUserList();
//        Gson gson = new Gson();
//        String userListGson = gson.toJson(userList);
//        //req.setAttribute("userList", DataFactory.getInstance().getUserList());
//       // req.getRequestDispatcher("/adminUserList2.jsp").forward(req,resp);
//        resp.getWriter().write(userListGson);

    }


    private class JData<T> {
        int total;
        List<T> list;
        public JData(int total, List<T> list){
            this.total = total;
            this.list = list;
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Check isLogged first
        if (isLogged(req, resp) == false)
            return;

        Data data = DataFactory.getInstance();
        String cmdType = req.getParameter("cmdType");
        // Check
        if (cmdType.equals("init")) {
            doLoadInitBooks(data, req, resp);
        } else if (cmdType.equals("add")){
            doAddBook(data, req, resp);
        } else if (cmdType.equals("upd")){
            doUpdUser(data, req, resp);
        } else if (cmdType.equals("del")){
            doDelBook(data, req, resp);
        }else if (cmdType.equals("showDeactiveUser")){
            doShowDeactiveUser(data, req, resp);
        }

    }

    public void doLoadInitBooks(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // send data to client
        sendToClient(data, req, resp);
    }

    public void doAddBook(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Get Data from parameter
        String id       = req.getParameter("id");
        String title    = req.getParameter("title");
        String author   = req.getParameter("author");
        String subject  = req.getParameter("subject");
        String isbn     = req.getParameter("isbn");
        // Not Exist: Add new book
        if (data.getBook(id) == null)
            data.addBook(id, title, author, subject, isbn);
        // send data to client
        sendToClient(data, req, resp);
    }

    public void doUpdUser(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Get Data from parameter
        String id = req.getParameter("id");
        // Update the book
        data.updUserStates(id, false);
        // Send data to client
        sendToClient(data, req, resp);
    }

    public void doDelBook(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Get Data from parameter
        String id = req.getParameter("id");
        // Delete the book
        data.delBook(id);
        // send data to client
        sendToClient(data, req, resp);
    }

    public void sendToClient(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String respJson = new Gson().toJson(data.getDeactivUserList());
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(respJson);

/*
        int pageno = Integer.parseInt(req.getParameter("pageno"));
        int pageSize = 9;
        List<Book> list = data.getBookList();
        List<Book> lst = list.stream()
                .skip((pageno - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
        BookMnServlet.JData jdata = new BookMnServlet.JData(list.size(), lst);
        String respJson = new Gson().toJson(jdata);
        resp.getWriter().write(respJson);
*/
    }

    public Boolean isLogged(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        // Write to log for debug
        String strType = (String)session.getAttribute("userType");
        String strId = (String)session.getAttribute("userID");
        Boolean logged = (Boolean) session.getAttribute("isLogged");
        System.out.println("Before Updated session: " + strId + ", " + strType + ", " + logged);
        // isLogged == invalid
        if (logged == null || logged == false)
        {
            System.out.println("Need to login......! ");
            // Send Redirect to Login Page
            resp.sendRedirect("login.jsp");
            return false;
        }
        // isLogged
        return true;
    }

    public void doShowDeactiveUser(Data data, HttpServletRequest req, HttpServletResponse resp) throws IOException {
//data是数据库，传进来这个数据库再操作，再传回给客户端
        String respJson = new Gson().toJson(DataFactory.getInstance().getDeactivUserList());
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(respJson);//resp里面的都是返回到action里面的，这里是把json的字符串返回到ajax的action里

    }

}
