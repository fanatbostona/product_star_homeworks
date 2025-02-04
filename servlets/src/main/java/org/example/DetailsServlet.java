package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Expense;
import org.example.model.Transaction;

import java.io.IOException;
import java.util.List;

public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = req.getSession(false);
        if (session == null) {
            resp.getWriter().println("Not authorized");
            return;
        }

        var context = req.getServletContext();
        resp.getWriter().println("Expenses: ");
        for (Expense e : (List<Expense>)context.getAttribute("expenses")) {
            resp.getWriter().println(String.format("- %s(%d)", e.getName(), e.getSum()));
        }
        resp.getWriter().println("\n");
        resp.getWriter().println("Transactions: ");
        for (Transaction t : (List<Transaction>)context.getAttribute("transactions")) {
            resp.getWriter().println(String.format("- %s(%d)", t.getName(), t.getSum()));
        }



        resp.getWriter().println("\n");
    }
}
