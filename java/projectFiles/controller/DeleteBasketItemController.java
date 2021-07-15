package projectFiles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import projectFiles.entity.Product;
import projectFiles.service.BasketService;
import projectFiles.service.ProductService;
import projectFiles.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class DeleteBasketItemController implements Controller {
    @Autowired
    private BasketService basketService;
    private ProductService productService = new ProductService();
    private ShowBasketPageController sbpc = new ShowBasketPageController();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        try {
            Integer basketProductId = Integer.parseInt(req.getParameter("productId"));
            basketService.deleteProductPosition(basketProductId);

            List<Product> products = productService.findAll();

            req.setAttribute("products", products);

            return sbpc.execute(req, resp);
        } catch (ServiceException e) {
            return new ControllerResultDto("error-500");
        }
    }
}
