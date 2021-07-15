package projectFiles.controller;

import projectFiles.entity.User;
import projectFiles.service.ServiceException;
import projectFiles.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationController implements Controller {

    private UserService userService = new UserService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {

        String userName = req.getParameter("userName");
        String role = req.getParameter("userRole");
        String mail = req.getParameter("mail");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = new User(0, userName, role, mail, login, password);

        User userTempLogin = userService.getByLogin(user.getLogin());
        User userTempEmail = userService.getByEmail(user.getMailContact());

        if (userTempLogin != null) {
            req.setAttribute("login", user.getLogin());
            return new ControllerResultDto("login-error");
        } else if (userTempEmail != null) {
            req.setAttribute("email", user.getMailContact());
            return new ControllerResultDto("email-error");
        } else {
            user.setId(userService.createUser(user));
            req.setAttribute("user", user);

            return new ControllerResultDto("profile");
        }
    }
}
