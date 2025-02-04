package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Expense;
import org.example.model.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var context = req.getServletContext();
        context.log("[TransactionServlet] doGet");


        var session = req.getSession(false);
        if (session == null) {
            resp.getWriter().println("Not authorized");
            return;
        }

        var transactions = new ArrayList<Transaction>((List)context.getAttribute("transactions"));

        int freeMoney = (int) context.getAttribute("freeMoney");
        for (var k : req.getParameterMap().keySet()) {
            int value = Integer.parseInt(req.getParameter(k));
            freeMoney += value;
            transactions.add(new Transaction(k,value));
        }

        context.setAttribute("freeMoney", freeMoney);
        context.setAttribute("transactions",transactions);
        resp.getWriter().println("Transactions were added");

        resp.sendRedirect("/summary");


    }
}
