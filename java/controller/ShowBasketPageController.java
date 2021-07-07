package controller;

import entity.Basket;
import entity.Product;
import service.BasketService;
import service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShowBasketPageController implements Controller {

    private BasketService basketService = new BasketService();

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
