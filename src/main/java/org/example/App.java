package org.example;

import org.example.impl.customer.Customer;
import org.example.impl.payment.BankTransfer;
import org.example.impl.payment.CreditCard;
import org.example.impl.shopping.Cart;
import org.example.impl.shopping.ShoppingList;
import org.example.impl.tea.BlackTea;
import org.example.impl.tea.BlueTea;
import org.example.impl.tea.GreenTea;
import org.example.impl.tea.RedTea;
import org.example.interfaces.shooping.PriceList;

public class App {
    public static void main(String[] args) {
        PriceList priceList = PriceList.getPriceList();

        priceList.add(new GreenTea("ginger", 1), 80, 70, 4);
        priceList.add(new BlackTea("kiwi", 1), 120);
        priceList.add(new RedTea("strawberry", 1), 80);
        priceList.add(new GreenTea("jasmine", 1), 150);

        Customer herbal = new Customer("herbal", 2000);
        herbal.addToShoppingList(new GreenTea("ginger", 5));
        herbal.addToShoppingList(new RedTea("strawberry", 5));
        herbal.addToShoppingList(new BlueTea("vanilla", 3));
        herbal.addToShoppingList(new BlackTea("kiwi", 3));

        ShoppingList herbalList = herbal.getShoppingList();
        System.out.println("Customer shopping list: " + herbalList);

        Cart herbalCart = herbal.getCart();
        herbal.repack();
        System.out.println("Shopping list of customer after repacking: " + herbal.getShoppingList());
        System.out.println("Customer's cart after repacking: " + herbalCart);
        System.out.println("Strawberry tea in Herbal's cart costs: " + PriceList.getPriceList().getPrice(herbalCart.getTeas().stream()
            .filter(t -> t.getFlavor().equals("strawberry"))
            .findFirst()
            .orElse(new RedTea("strawberry", 0)), herbalCart.getTotalWeightOfTeaWithFlavor("strawberry")));
        herbal.pay(new BankTransfer());
        System.out.println("Herbal funds after payment: " + herbal.getFunds());
        System.out.println("Customer's cart after payment: " + herbal.getCart());

        Customer kawus = new Customer("kawus", 620);
        kawus.addToShoppingList(new GreenTea("ginger", 3));
        kawus.addToShoppingList(new BlackTea("kiwi", 4));

        ShoppingList kawusList = kawus.getShoppingList();
        System.out.println("Customer's shopping list: " + kawusList);
        Cart kawusCart = kawus.getCart();
        kawus.repack();
        System.out.println("Customer's shopping list after repacking: " + kawus.getShoppingList());
        System.out.println("Customer's cart after repacking: " + kawusCart);
        kawus.pay(new CreditCard());
        System.out.println("Kawus funds after payment: " + kawus.getFunds());
        kawus.returnTea(new BlackTea("kiwi", 0), 4);
        System.out.println("Kawus funds after return: " + kawus.getFunds());
        System.out.println("Customer's cart after return: " + kawus.getCart());
    }
}

