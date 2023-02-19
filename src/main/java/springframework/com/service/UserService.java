package springframework.com.service;

import jdk.nashorn.internal.objects.annotations.Getter;
import springframework.spring.Autowired;
import springframework.spring.Component;

@Component("userService")
public class UserService {

    @Autowired
    private OrderService orderService;

    public OrderService getOrderService() {
        return orderService;
    }
}
