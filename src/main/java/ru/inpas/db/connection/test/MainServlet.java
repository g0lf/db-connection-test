package ru.inpas.db.connection.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.inpas.db.connection.test.services.ScenariosService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MainServlet", urlPatterns = "/*")
public class MainServlet extends HttpServlet {

    public static final Logger log = LoggerFactory.getLogger(MainServlet.class);

    @Inject
    private ScenariosService scenariosService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            scenariosService.scenario(20, 5);
            // scenariosService.dbFilling(20000);
        } catch (Exception e) {
            log.error("", e.getMessage());
            response.setStatus(430);
        }
    }

}
