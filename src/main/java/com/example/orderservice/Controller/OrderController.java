package com.example.orderservice.Controller;

import com.example.orderservice.entity.Order;
import com.example.orderservice.Service.OrderService;
import com.example.orderservice.util.ApiOrderPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(ApiOrderPath.V1)
@Slf4j
public class OrderController {

    @Autowired
    public OrderService orderService;

    @PostMapping(ApiOrderPath.CREATE_ORDER)
    public Order createOrder (@RequestBody Order order){
        log.debug("Request Received for Order !!");
        if(order == null){
            log.warn("Order Request Body is Null.....");
        }
             Order or =     orderService.createOrder(order);
                  if  (or==null){
                      log.error("Order is Missing..... or Order Fail.. ");
                  }
                  log.info("Order Placed Succesfully....");
                  return or;
    }
    @GetMapping("/order/{id}")
    public Order getOrderById(@PathVariable Long id) {
        log.debug("Receving Order By Order Id: {}",id);
        if(id==null){
            log.info("Order is Inalid Or Wrong...");
        }
        Order or = orderService.getOrderById(id);
            if (or == null){
                log.warn("Order is Not Available for this Id.....");
            }
            log.info("Order Found Succusfully... {}",id);
        return or;
    }
    
    @GetMapping("/user/{userId}")
    public List<Order>getOrdersByUserId(@PathVariable Long userId){
        return orderService.getOrdersByUserId(userId);
    }
}
