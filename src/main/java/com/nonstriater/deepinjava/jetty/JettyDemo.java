package com.nonstriater.deepinjava.jetty;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.function.Supplier;

public class JettyDemo {

    private static ServletHandler servletHandler = ((Supplier<ServletHandler>) () -> {

        ServletHandler ret = new ServletHandler() {
            //jetty 会取一个新的线程来处理
            @Override
            public void doHandle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
                try {
                    super.doHandle(target, baseRequest, request, response);
                } finally {
                }
            }
        };

        ret.addServletWithMapping(TXServlet.class, "/api/tx");
        ret.addServletWithMapping(TTServlet.class, "/api/tt");

        return ret;
    }).get();


    public static class TXServlet extends HttpServlet {
        public TXServlet(){
            super();
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
            req.setCharacterEncoding("utf-8");
            resp.setCharacterEncoding("utf-8");
            resp.setHeader("content-type","text/html;charset=UTF-8");
            System.out.println("TXServlet运行起来了");
            resp.getWriter().write("TXServlet运行起来了");
            resp.getWriter().close();
        }

    }

    public static class TTServlet extends HttpServlet {
        public TTServlet(){
            super();
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
            req.setCharacterEncoding("utf-8");
            resp.setCharacterEncoding("utf-8");
            resp.setHeader("content-type","text/html;charset=UTF-8");
            System.out.println("TTServlet运行起来了");
            resp.getWriter().write("TTServlet运行起来了");
            resp.getWriter().close();
        }
    }

    public static void main(String[] args) throws Exception {
        Server server = ((Supplier<Server>)()-> {
            Server s  = new Server(8086);
            s.setErrorHandler(null);
            s.setHandler(servletHandler);
            return s;
        }).get();
        server.start();
    }
}
