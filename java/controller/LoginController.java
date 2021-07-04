package controller;

import entity.User;
import service.ServiceException;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller {

    private UserService userService = new UserService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        if(req.getSession().getAttribute("userId") == null) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");

            User user = userService.getByLogin(login);

            if (user.getPassword().equals(password)) {
                req.setAttribute("user", user);
                req.getSession().setAttribute("userId", user.getId());
                req.getSession().setAttribute("req", req);
                return new ControllerResultDto("profile");
            } else {
                return new ControllerResultDto("error-403");
            }
        } else return new ControllerResultDto("profile");
    }
}