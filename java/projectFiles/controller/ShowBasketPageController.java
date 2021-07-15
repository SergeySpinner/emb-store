package projectFiles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import projectFiles.entity.Basket;
import projectFiles.entity.Product;
import projectFiles.service.BasketService;
import projectFiles.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;

public class ShowBasketPageController implements Controller {

    @Autowired
    private BasketService basketService;

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        try {
            Integer userId = (Integer) req.getSession().getAttribute("userId");

            Basket basket = basketService.getUsersBasket(userId);

            Iterator<Product> productIterator = basket.getBasketList().iterator();
            Iterator<Integer> idIterator = basket.getIdList().iterator();
            HashMap<Integer, Product> productMap = new HashMap<>();

            while (productIterator.hasNext() && idIterator.hasNext())
                productMap.put(idIterator.next(),productIterator.next());

            req.setAttribute("map", productMap);

            return new ControllerResultDto("basket");
        } catch (ServiceException e) {
            e.printStackTrace();
            return new ControllerResultDto("error-500");
        }
    }
}
