package controller;

import entity.Basket;
import entity.BasketState;
import entity.Product;
import service.BasketService;
import service.ProductService;
import service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AddBasketController implements Controller{
    private ProductService productService = new ProductService();
    private BasketService basketService = new BasketService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        try {
            String productId = req.getParameter("productId");
            Product product = productService.findById(Integer.parseInt(productId));
            Integer buyerId = (Integer) req.getSession().getAttribute("userId");

            Basket basket = new Basket(BasketState.ON_AGREEMENT.toString() , product, buyerId);

            basketService.insertService(basket);

            List<Product> products = productService.findAll();

            req.setAttribute("products", products);


            return new ControllerResultDto("shop-page");
        } catch (ServiceException e){
            return new ControllerResultDto("error-500");
        }
    }
}
