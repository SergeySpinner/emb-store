package projectFiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import projectFiles.dao.DaoException;
import projectFiles.dao.ProductDao;
import projectFiles.entity.Product;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private ProductDao productDao;

    @Autowired
    public void setProductDao(ProductDao productDao){
        this.productDao = productDao;
    }

    public List<Product> findAll() throws ServiceException {
        try{
            List<Product> products = productDao.findAll();
            return products;
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }

    public Product findById(Integer productId) throws ServiceException{
        try{
            return productDao.getById(productId);
        }catch (DaoException e){
            throw new ServiceException();
        }
    }
}
