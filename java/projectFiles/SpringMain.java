package projectFiles;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import projectFiles.entity.Basket;
import projectFiles.entity.Product;
import projectFiles.service.BasketService;
import projectFiles.service.ServiceException;

import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        try(final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("projectFiles")){
            final String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
            System.out.println(Arrays.toString(beanDefinitionNames));
            final BasketService basketService = ctx.getBean(BasketService.class);
            final Basket basket = basketService.getUsersBasket(15);
            for (Product product : basket.getBasketList()) {
                System.out.println(product.toString());
            }

        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
