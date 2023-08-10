package com.ecommerce.library.service.impl;

import com.ecommerce.library.model.CartItem;
import com.ecommerce.library.model.Order;
import com.ecommerce.library.model.OrderDetail;
import com.ecommerce.library.model.ShoppingCart;
import com.ecommerce.library.repository.CartItemRepository;
import com.ecommerce.library.repository.OrderDetailRepository;
import com.ecommerce.library.repository.OrderRepository;
import com.ecommerce.library.repository.ShoppingCartRepository;
import com.ecommerce.library.service.OrderService;
import com.ecommerce.library.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ShoppingCartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ShoppingCartService shoppingCartService;


    @Override
    public void saveOrder(ShoppingCart cart) {

        Order order = new Order();

        order.setOrderDate(new Date());
        order.setNotes("PENDING");
        order.setCustomer(cart.getCustomer());
        order.setTotalPrice(cart.getTotalPrices());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        for (CartItem item : cart.getCartItems()) {
            OrderDetail orderDetail = new OrderDetail();

            orderDetail.setOrder(order);
            orderDetail.setQuantity(item.getQuantity());
            orderDetail.setProduct(item.getProduct());
            orderDetail.setUnitPrice(item.getProduct().getCostPrice());
            orderDetailRepository.save(orderDetail);
            orderDetailList.add(orderDetail);
        }

        order.setOrderDetailList(orderDetailList);

        cart.setCartItems(new HashSet<>());
        cart.setTotalPrices(0);
        cart.setTotalItems(0);

        shoppingCartService.deleteCartById(cart.getId());
        orderRepository.save(order);
    }

    @Override
    public void acceptOrder(Long id) {
        Order order = orderRepository.getById(id);
        order.setDeliveryDate(new Date());
        order.setNotes("Shipping");
        orderRepository.save(order);
    }

    @Override
    public void cancelOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
