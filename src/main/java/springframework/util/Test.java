package springframework.util;

import springframework.com.service.UserService;
import springframework.spring.AppConfig;
import springframework.spring.ApplicationContext;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ApplicationContext(AppConfig.class);
        UserService userService = context.getBean("userService");
        System.out.println(userService.getOrderService());
    }
}
