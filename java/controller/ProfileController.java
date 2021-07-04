package controller;

import entity.User;
import service.ServiceException;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileController implements Controller {

    UserService userService = new UserService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        Integer userId = (Integer) req.getSession().getAttribute("userId");

        User user = userService.getById(userId);


        if (user != null) {
            req.setAttribute("user", user);
            return new ControllerResultDto("profile");
        } else
            return new ControllerResultDto("error-403");
    }
}
