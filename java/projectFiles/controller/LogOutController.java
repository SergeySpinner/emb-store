package projectFiles.controller;

import projectFiles.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOutController implements Controller{
    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        req.getSession().setAttribute("userId", null);

        return new ControllerResultDto("logout");
    }
}
