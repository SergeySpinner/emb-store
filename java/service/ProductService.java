package service;

import dao.DaoException;
import dao.ProductDao;
import entity.Product;

import java.util.List;

public class ProductService {
    private ProductDao productDao = new ProductDao();

    public List<Product> findAll() throws ServiceException {
        try{
            List<Product> products = productDao.findAll();
            return products;
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }
}
