package springframework.com.service;

import springframework.spring.Component;

@Component("orderService")
public class OrderService {
    public void sayHello(){
        System.out.println("hello orderService");
    }
}
