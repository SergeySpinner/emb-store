package service;

import dao.DaoException;
import dao.UserDao;
import entity.User;

public class UserService {
    private UserDao userDao = new UserDao();

    public User getByLogin(String name) throws ServiceException {
        try {
            return userDao.getByLogin(name);
        }catch (DaoException e){
            throw new ServiceException();
        }
    }
}
