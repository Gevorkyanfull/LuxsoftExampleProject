package com.guzichenko.view;

import java.io.IOException;
import java.util.List;

import com.guzichenko.Utils.IBufferReader;
import com.guzichenko.dao.DaoException;
import com.guzichenko.domain.Client;
import com.guzichenko.domain.Product;
import com.guzichenko.exceptions.BusinessException;
import com.guzichenko.services.*;

public class AdminMenu {

    private final IBufferReader br;
    private final ClientService clientService;
    private final ProductService productService;

    public AdminMenu(IBufferReader br, ClientService clientService, ProductService productService) {
        this.br = br;
        this.clientService = clientService;
        this.productService = productService;
    }

    public void show() throws IOException, BusinessException {
        while (true) {
            showMenu();
            switch (br.readString()) {
                case "1":
                    createClient();
                    break;
                case "2":
                    System.out.println("Modify client");
                    modifyClient();
                    break;
                case "3":
                    System.out.println("Remove client");
                    removeClient();
                    break;
                case "4":
                    System.out.println("All clients:");
                    showAllClients();
                    break;
                case "5":
                    createProduct();
                    break;
                case "6":
                    modifyProduct();
                    break;
                case "7":
                    removeProduct();
                    break;
                case "8":
                    listProduct();
                    break;
                case "0":
                    System.exit(0);
                default:
                    System.out.println("Wrong input!!!");
                    break;
            }
        }
    }

    private void createClient() {
        System.out.println("Create new client:");
        try {
            Long id = clientService.createClient(inputClientData());
            System.out.println("Client Saved: " + id);
        } catch (BusinessException e) {
            System.out.println("Can not create a client "+ e.getMessage());

        }
        catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    private void modifyClient() throws IOException {
        System.out.println("Enter client's id:");
        Long id = br.readLong();
        ClientData data = inputClientData();
        clientService.modifyClient(id, data);
    }

    private void removeClient() throws IOException {
        System.out.println("Enter client's id:");
        Long id = br.readLong();
        try {
            clientService.removeClient(id);
        } catch (DaoException e) {
            System.out.println("Can not remove client with id " + e.id + ", reason: " + e.message);
        }
        System.out.println("Your account has been deleted");
    }

    private ClientData inputClientData() throws IOException{
        System.out.println("Input name: ");
        String name = br.readString();
        System.out.println("Input surname: ");
        String surname = br.readString();
        System.out.println("Input age: ");
        int age = br.readInteger();
        System.out.println("Input phone number: ");
        String phoneNumber = br.readString();
        System.out.println("Input email: ");
        String email = br.readString();

        return new ClientData(name, surname, age, phoneNumber, email);
    }

    private void showMenu() {
        System.out.println("1. Add client");
        System.out.println("2. Modify client"); // by ID
        System.out.println("3. Remove client");
        System.out.println("4. List all clients");
        System.out.println();
        System.out.println("5. Add product");
        System.out.println("6. Modify product");
        System.out.println("7. Remove product");
        System.out.println("8. List all product");
        System.out.println();
        System.out.println("9. Modify order");
        System.out.println("10. Remove order");
        System.out.println("11. List all order");
        System.out.println();
        System.out.println("R. Return");
        System.out.println("E. Exit");
    }


    private void showAllClients() {
        for (Client client : clientService.getAllClients()) {
            System.out.println(client);
        }
    }

    private void createProduct() throws IOException {

        ProductData productData = inputProductData();
        try {
            productService.createProduct(productData);
        } catch (BusinessException e) {
            System.out.println("Can not create product" + e.getMessage());
        }
        System.out.println("Product has been created");
    }

    private void modifyProduct() throws IOException, BusinessException {
        System.out.println("Enter product's id:");
        Long id = br.readLong();
        ProductData data = inputProductData();
        productService.modifyProduct(id, data);
    }

    private ProductData inputProductData() throws IOException {
        System.out.println("Enter product's name");
        String name=br.readString();
        System.out.println("Enter product's price");
        Long price=br.readLong();
        return new ProductData(price,name);


    }
    private void removeProduct() throws IOException, BusinessException {
        System.out.println("Enter product's id");
        Long id=br.readLong();
        try {
            productService.removeProduct(id);
        } catch (DaoException e) {
            System.out.println("Dude are you crazy? There is no such ID to remove"+ e.message);
        }
    }
    private void listProduct()throws IOException{
            for(Product product:productService.getAllProducts()){
            System.out.println(product.toString());

        }
    }
}