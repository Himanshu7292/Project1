package com.app;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Customer;
import com.app.model.Product;
import com.app.service.CustomerService;
import com.app.service.ProductService;
import com.app.service.impl.CustomerServiceImpl;
import com.app.service.impl.ProductServiceImpl;

public class Main {
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		ProductService productService = new ProductServiceImpl();
		CustomerService customerService = new CustomerServiceImpl();
		Scanner scanner = new Scanner(System.in);
		log.info(" Welcome to Online Shopping App");
		log.info("=================================");
		int choice = 0;
		do {
			log.info("1. Login As Employee");
			log.info("2. Login As Customer");
			log.info("3. Register yourself as a Customer");
			log.info("4. EXIT");
			try {
				choice = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {

			}

			switch (choice) {
			case 1:
				log.info("Under Construction");

				break;
			case 2:
				Customer customer1 = null;
				log.info("Enter your Email");
				String email = scanner.nextLine();
				log.info("Enter your Password");
				String password = scanner.nextLine();
				List<Customer> Details;
				try {
					customer1 = customerService.CustomerLogin(email, password);
					int option = 0;
					if (customer1.getCustomerId() != 0) {
						log.info("\nWelcome " + customer1.getCustomerFirstName());
						log.info("Your CustomerId is " + customer1.getCustomerId());
						log.info("\nSo," + customer1.getCustomerFirstName() + " What do you want to do");
						log.info("===================================================================");
						do {
							log.info("\n1.View Products");
							log.info("2.Add products to cart");
							log.info("3.View Cart");
							log.info("4.Mark order as recieved");
							log.info("5.Logout");
							log.info("\n Enter your choice 1-5 only");
							try {
								option = Integer.parseInt(scanner.nextLine());
							} catch (NumberFormatException e) {

							}
							switch (option) {
							case 1:
								log.info("All Products Are Given Below: ");
								List<Product> AllProductList = productService.ViewAllProduct();
								for (Product product : AllProductList) {
									log.info(product);
								}
								break;
							case 2:
								Cart cart = new Cart();

								log.info("Enter Your Customer Id");
								cart.setCustomerId(Integer.parseInt(scanner.nextLine()));
								log.info("Enter the Product Id of the product you want to add");
								cart.setProductId(Integer.parseInt(scanner.nextLine()));
								if (productService.AddToCart(cart) == 1) {
									log.info("product added to cart");
								}
								break;
							case 3:
								log.info("Under Construction");

								break;
							case 4:
								log.info("Under Construction");

								break;
							case 5:
								log.info("logged out successfuly");

								break;

							default:
								log.info("Choice will be from 1-5 only");
								break;
							}
						} while (option != 5);
					} else {
						log.info("Invalid Credentials");
						break;
					}

				} catch (BusinessException e1) {
					log.warn(e1.getMessage());
				}
				break;
			case 3:
				Customer customer = new Customer();
				log.info("Enter the your first name:");
				customer.setCustomerFirstName(scanner.nextLine());
				log.info("Enter the your last name:");
				customer.setCustomerLastName(scanner.nextLine());
				log.info("Enter your email");
				customer.setCustomerEmail(scanner.nextLine());
				log.info("Enter your password");
				customer.setCustomerPassword(scanner.nextLine());
				try {
					if (customerService.RegisterNewCustomer(customer) == 1) {
						log.info("Registered Succesfully..");
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
				}
				break;
			case 4:
				log.info("Thank you for using our app... ");

				break;
			default:
				log.warn("Invalid choice... Enter the choice between 1 to 4 ");
				break;
			}
		} while (choice != 4);
	}
}
