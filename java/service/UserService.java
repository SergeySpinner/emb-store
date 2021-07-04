package service;

import dao.DaoException;
import dao.UserDao;
import entity.User;

public class UserService {
    private UserDao userDao = new UserDao();

    public User getByLogin(String name) throws ServiceException {
        try {
            return userDao.getByLogin(name);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    public Integer createUser(User user) throws ServiceException {
        try {
            return userDao.create(user);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    public User getByEmail(String email) throws ServiceException {
        try {
            return userDao.getByEmail(email);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    public User getById(Integer id) throws ServiceException {
        try {
            return userDao.getById(id);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

}
