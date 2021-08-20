package com.app;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Customer;
import com.app.model.Employee;
import com.app.model.Product;
import com.app.service.CartService;
import com.app.service.CustomerSearchService;
import com.app.service.CustomerService;
import com.app.service.EmployeeService;
import com.app.service.ProductService;
import com.app.service.impl.CartServiceImpl;
import com.app.service.impl.CustomerSearchServiceImpl;
import com.app.service.impl.CustomerServiceImpl;
import com.app.service.impl.EmployeeServiceImpl;
import com.app.service.impl.ProductServiceImpl;

public class Main {
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		ProductService productService = new ProductServiceImpl();
		CustomerService customerService = new CustomerServiceImpl();
		CartService cartService = new CartServiceImpl();
		EmployeeService employeeService = new EmployeeServiceImpl();
		CustomerSearchService customerSearchService = new CustomerSearchServiceImpl();
		Scanner scanner = new Scanner(System.in);
		log.info(" Welcome to Online Shopping App");
		log.info("====================================");
		int choice = 0;
		do {
			log.info("___________________________________");
			log.info("|1. Login As Employee              |");
			log.info("|2. Login As Customer              |");
			log.info("|3. Register yourself as a Customer|");
			log.info("|4. EXIT                           |");
			log.info("|__________________________________|\n");
			try {
				choice = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {

			}

			switch (choice) {
			case 1:
				Employee employee = new Employee();
				int EmpId = 0;
				try {
					log.info("Enter your Employee Id: ");
					try {
						EmpId = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
						throw new BusinessException("Employee id should be digit only");

					}
					log.info("Enter your Password: ");
					String EmpPassword = scanner.nextLine();
					int empChoice = 0;
					if (employeeService.EmployeeLogin(EmpId, EmpPassword) == 1) {
						log.info("Employee logged in successfully");
						log.info("So what do you want to do today");
						do {
							log.info("___________________________________");
							log.info("|1.Add a new product:               |");
							log.info("|2.Update a product Price           |");
							log.info("|3.Search Customers                 |");
							log.info("|4.Logout                           |");
							log.info("|___________________________________|\n");
							empChoice = Integer.parseInt(scanner.nextLine());
							switch (empChoice) {
							case 1:
								Product product = new Product();
								log.info("Enter the Product name");
								product.setProductName(scanner.nextLine());
								log.info("Enter the Product price");
								try {
									product.setProductPrice(Double.parseDouble(scanner.nextLine()));
									if (productService.AddProduct(product) == 1) {
										log.info("New Product Added Successfullty");
									}
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}
								break;
							case 2:
								Product product1 = new Product();
								try {
									log.info("Enter the id of the product whose price you want to update:");
									product1.setProductId(Integer.parseInt(scanner.nextLine()));
									log.info("Enter the new price of the product");
									product1.setProductPrice(Double.parseDouble(scanner.nextLine()));
									if (productService.UpdateProductPrice(product1) == 1) {
										log.info("Error ocurred");
									}
								} catch (NumberFormatException e) {
									log.warn("Product id and price will be digits only");
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}
								break;
							case 3:
								int filter = 0;
								log.info("Below are the filters on the basis of which you can search customer");
								do {
									log.info("___________________________________");
									log.info("|1.Using Customer Id                |");
									log.info("|2.Using Customer First name        |");
									log.info("|3.Using Customer Last name         |");
									log.info("|4.Using Customer Email             |");
									log.info("|5.Go back to Employee menu         |");
									log.info("|___________________________________|\n");
									filter = Integer.parseInt(scanner.nextLine());
									switch (filter) {
									case 1:
										log.info("Enter the Customer id");
										try {
											int CustomerId = Integer.parseInt(scanner.nextLine());
											Customer customer2 = customerSearchService
													.getCustomerDetailsByCustomerId(CustomerId);
											if (customer2 != null) {
												log.info("Customer with id " + CustomerId
														+ " found... Below are the details");
												log.info(customer2);
											}
										} catch (NumberFormatException e) {
											log.warn("Customer Id  should be in Digits Only");
										} catch (BusinessException e) {
											log.warn(e.getMessage());
										}
										break;
									case 2:
										log.info(
												"Enter the First name to get the detials of customers with that name:");
										String FirstName = scanner.nextLine();
										try {
											List<Customer> customerListByFirstName = customerSearchService
													.getCustomerDetailsByCustomerFirstName(FirstName);
											if (customerListByFirstName != null && customerListByFirstName.size() > 0) {
												for (Customer customer : customerListByFirstName) {
													log.info(customer);
												}
											}
										} catch (BusinessException e) {
											log.warn(e.getMessage());
										}

										break;
									case 3:
										log.info(
												"Enter the Last name to get the detials of customers with that last name:");
										String lastName = scanner.nextLine();
										try {
											List<Customer> customerListByLastName = customerSearchService
													.getCustomerDetailsByCustomerLastName(lastName);
											if (customerListByLastName != null && customerListByLastName.size() > 0) {
												for (Customer customer : customerListByLastName) {
													log.info(customer);
												}
											}
										} catch (BusinessException e) {
											log.warn(e.getMessage());
										}

										break;
									case 4:
										log.info("Enter the Customer Email id");
										try {
											String CustomerEmail = scanner.nextLine();
											Customer customer2 = customerSearchService
													.getCustomerDetailsByCustomerEmail(CustomerEmail);
											if (customer2 != null) {
												log.info("Customer with email " + CustomerEmail
														+ "found... Below are the details");
												log.info(customer2);
											}
										} catch (BusinessException e) {
											log.warn(e.getMessage());
										}

										break;
									case 5:
										log.info("Going Back to main menu\n ");

										break;
									default:
										log.info("Invalid choice");
										break;
									}

								} while (filter != 5);
								break;
							case 4:
								log.info("logged out successfully");
								break;

							default:
								log.info("Enter the valid choice");
								break;
							}
						} while (empChoice != 4);
					}

					else {
						log.info("Wrong Employee Credentials");
					}

				} catch (NumberFormatException e2) {

				} catch (BusinessException e2) {
					log.warn(e2.getMessage());
				}
				break;
			case 2:
				Customer customer1 = null;
				log.info("Enter your Email");
				String Custemail = scanner.nextLine();
				log.info("Enter your Password");
				String Custpassword = scanner.nextLine();
				List<Customer> Details;
				try {
					customer1 = customerService.CustomerLogin(Custemail, Custpassword);
					int option = 0;
					if (customer1.getCustomerId() != 0) {
						log.info("\nWelcome " + customer1.getCustomerFirstName());
						log.info("Your CustomerId is " + customer1.getCustomerId());
						log.info("\nSo," + customer1.getCustomerFirstName() + " What do you want to do");
						log.info("===================================================================");
						do {
							log.info("___________________________________");
							log.info("|1.View Products                   |");
							log.info("|2.Add products to cart            |");
							log.info("|3.View Cart                       |");
							log.info("|4.Logout                          |");
							log.info("|__________________________________|\n");
							log.info("\n| Enter your choice 1-5 only|");
							try {
								option = Integer.parseInt(scanner.nextLine());
							} catch (NumberFormatException e) {
								log.warn("Enter the digit only");
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
								Cart cart1 = new Cart();
								log.info("Enter your Customer Id");
								int CustomerId = Integer.parseInt(scanner.nextLine());
								List<Product> viewCart = cartService.viewCart(CustomerId);
								if (viewCart != null && viewCart.size() > 0) {
									log.info("Your cart details are: ");
									for (Product product : viewCart) {
										log.info(product);
									}
								} else {
									log.info(" cart is empty... add some products first");
								}
								break;

							case 4:
								log.info("logged out successfuly");

								break;

							default:
								log.info("Choice will be from 1-5 only");
								break;
							}
						} while (option != 4);
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
