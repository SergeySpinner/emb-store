package controller;

import dao.ProductDao;
import entity.Product;
import entity.User;
import service.ProductService;
import service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShopController implements Controller {

    private ProductService productService = new ProductService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {

        Integer userId = (Integer) req.getSession().getAttribute("userId");

        List<Product> products = productService.findAll();

        req.setAttribute("products", products);

        return new ControllerResultDto("shop-page");
    }
}
