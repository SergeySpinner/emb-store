package projectFiles.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ControllerFactory {

    private Map<String, Controller> controllerMap = new HashMap<>();

    private void init() {
        controllerMap.put("GET/profile", new ProfileController());
        controllerMap.put("GET/login", new ShowPageController("login"));
        controllerMap.put("GET/main", new ShowPageController("main"));
        controllerMap.put("GET/client", new ShowPageController("login"));
        controllerMap.put("GET/logout", new LogOutController());
        controllerMap.put("GET/addToBasket", new AddBasketController());
        controllerMap.put("GET/basket", new ShowBasketPageController());
        controllerMap.put("GET/deleteBasketItem", new DeleteBasketItemController());

        controllerMap.put("GET/shop-page", new ShopController());

        controllerMap.put("POST/login", new LoginController());

        controllerMap.put("GET/registration", new ShowPageController("registration"));
        controllerMap.put("POST/registration", new RegistrationController());
    }

    public Controller getController(HttpServletRequest request) {
        if (controllerMap.isEmpty()) {
            init();
        }
        return controllerMap.get(request.getMethod() + request.getPathInfo());
    }
}