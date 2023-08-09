package com.ecommerce.library.service.impl;

import com.ecommerce.library.model.CartItem;
import com.ecommerce.library.model.Customer;
import com.ecommerce.library.model.Product;
import com.ecommerce.library.model.ShoppingCart;
import com.ecommerce.library.repository.CartItemRepository;
import com.ecommerce.library.repository.ShoppingCartRepository;
import com.ecommerce.library.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private CartItemRepository itemRepository;

    @Autowired
    private ShoppingCartRepository cartRepository;

    @Override
    public ShoppingCart addItemToCart(Product product, int quantity, Customer customer) {

        ShoppingCart cart = customer.getCart();

        if (cart == null) {
            cart = new ShoppingCart();
        }

        Set<CartItem> cartItems = cart.getCartItems(); // khai báo list k có phần tử trùng lặp

        CartItem cartItem = findCartItem(cartItems, product.getId());

        if (cartItems == null) {

            cartItems = new HashSet<>(); // khai báo list k có phần tử trùng lặp

            if (cartItem == null) {
                cartItem = new CartItem();
                cartItem.setProduct(product);
                cartItem.setTotalPrice(quantity * product.getCostPrice());
                cartItem.setQuantity(quantity);
                cartItem.setCart(cart);
                cartItems.add(cartItem);
                itemRepository.save(cartItem);
            }
        } else {
            if (cartItem == null) {

                cartItem = new CartItem();

                cartItem.setProduct(product);
                cartItem.setTotalPrice(quantity * product.getCostPrice());
                cartItem.setQuantity(quantity);
                cartItem.setCart(cart);
                cartItems.add(cartItem);
                itemRepository.save(cartItem);
            } else {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                cartItem.setTotalPrice(cartItem.getTotalPrice() + (quantity * product.getCostPrice()));
                itemRepository.save(cartItem);
            }
        }
        cart.setCartItems(cartItems);
        int totalItem = totalItems(cart.getCartItems());
        double totalPrice = totalPrice(cart.getCartItems());

        cart.setTotalItems(totalItem);
        cart.setTotalPrices(totalPrice);
        cart.setCustomer(customer);
        return cartRepository.save(cart);
    }

    @Override
    public ShoppingCart updateItemToCart(Product product, int quantity, Customer customer) {
        ShoppingCart cart = customer.getCart();

        if (cart == null) {
            cart = new ShoppingCart();
        }

        Set<CartItem> cartItems = cart.getCartItems(); // khai báo list k có phần tử trùng lặp

        CartItem item = findCartItem(cartItems, product.getId());
        item.setQuantity(quantity);
        item.setTotalPrice(quantity * product.getCostPrice());
        itemRepository.save(item);
        int totalItems = totalItems(cartItems);
        double totalPrice = totalPrice(cartItems);

        cart.setTotalItems(totalItems);
        cart.setTotalPrices(totalPrice);
        return cartRepository.save(cart);
    }

    @Override
    public ShoppingCart deleteItemToCart(Product product, Customer customer) {
        ShoppingCart cart = customer.getCart();

        if (cart == null) {
            cart = new ShoppingCart();
        }

        Set<CartItem> cartItems = cart.getCartItems(); // khai báo list k có phần tử trùng lặp

        CartItem item = findCartItem(cartItems, product.getId());

        cartItems.remove(item);
        itemRepository.delete(item);

        int totalItems = totalItems(cartItems);
        double totalPrice = totalPrice(cartItems);

        cart.setCartItems(cartItems);
        cart.setTotalItems(totalItems);
        cart.setTotalPrices(totalPrice);

        return cartRepository.save(cart);
    }

    @Override
    public void deleteCartById(Long id) {
        ShoppingCart cart = cartRepository.getById(id);
        for (CartItem item : cart.getCartItems()){
            itemRepository.deleteById(item.getId());
        }
        cart.setCustomer(null);
        cart.getCartItems().clear();
        cart.setTotalPrices(0);
        cart.setTotalItems(0);
        cartRepository.save(cart);
    }

    private int totalItems(Set<CartItem> cartItems) {
        int totalItem = 0;
        for (CartItem cartItem : cartItems) {
            totalItem += cartItem.getQuantity();
        }
        return totalItem;

    }

    private double totalPrice(Set<CartItem> cartItems) {
        double totalPrice = 0.0;
        for (CartItem cartItem : cartItems) {
            totalPrice += cartItem.getTotalPrice();
        }
        return totalPrice;
    }


    private CartItem findCartItem(Set<CartItem> cartItems, Long productId) {
        if (cartItems == null) {
            return null;
        }
        CartItem cartItem = null;
        for (CartItem item : cartItems) {
            if (item.getProduct().getId() == productId) {
                cartItem = item;

            }
        }
        return cartItem;
    }


}
