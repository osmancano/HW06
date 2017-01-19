package com.ironyard.servlets;

import com.ironyard.data.Ticket;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by osmanidris on 1/18/17.
 */
@WebServlet(name = "TicketServlet", urlPatterns = "/generateTicket")
public class TicketServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Ticket ticket = new Ticket();
        int[] nums = new int[6];
        String paramName;
        for(int i=0; i< nums.length;i++){
            paramName = "num"+i;
            System.out.println(paramName);
            nums[i] = Integer.parseInt(request.getParameter(paramName));
        }
        ticket.setNumbers(nums);
        ArrayList<Ticket> myList = null;
        myList = (ArrayList<Ticket>) request.getSession().getAttribute("ticket_list");
        if(myList == null){
            // need to create
            myList = new ArrayList<>();
            // only when new list
            request.getSession().setAttribute("ticket_list", myList);
        }

        // add to list
        myList.add(ticket);
        String nextJSP = "/home.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Ticket ticket = new Ticket();
        ticket.generateTicket();
        ArrayList<Ticket> myList = null;
        myList = (ArrayList<Ticket>) request.getSession().getAttribute("ticket_list");
        if(myList == null){
            // need to create
            myList = new ArrayList<>();
            // only when new list
            request.getSession().setAttribute("ticket_list", myList);
        }

        // add to list
        myList.add(ticket);
        // forward to JSP
        String nextJSP = "/home.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);
    }
}
