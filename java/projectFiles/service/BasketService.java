package projectFiles.service;

import projectFiles.dao.BasketDao;
import projectFiles.dao.DaoException;
import projectFiles.entity.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketService {
    private BasketDao basketDao;

    @Autowired
    public BasketService(BasketDao basketDao){
        this.basketDao = basketDao;
        System.out.println("CRINNNNNNNNNNNNNNNNNNNNNGE");
    }

    public void insertService(Basket basket) throws ServiceException {
        try {
            basketDao.insertBasket(basket);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

//    public void deleteService() throws ServiceException{
//        try {
//            basketDao.deletePositionOfBasket();
//        } catch (DaoException e){
//            throw new ServiceException();
//        }
//    }

    public void clearService(Basket basket) throws ServiceException {
        try {
            basketDao.clearBasket(basket);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    public void updateService(Basket basket) throws ServiceException {
        try {
            basketDao.updateBasket(basket);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    public Basket getUsersBasket(Integer userId) throws ServiceException {
        try {
            return basketDao.getUsersBasket(userId);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }
    public void deleteProductPosition(Integer productId) throws ServiceException {
        try{
            basketDao.deletePositionOfBasket(productId);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

}
