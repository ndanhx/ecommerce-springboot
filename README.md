# 🛒 eCommerce SpringBoot

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-latest-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.8.x-blue.svg)](https://maven.apache.org/)

A simple, modular eCommerce platform built with Spring Boot. This project demonstrates core eCommerce functionality with a clean, modular architecture.

## 📋 Overview

This application implements a basic eCommerce system with fundamental features like product management, shopping cart functionality, and order processing. The project follows a multi-module Maven structure to maintain clean separation of concerns.

## 🏗️ High-Level Architecture

The application follows a multi-module Maven project structure:

- **Library**: Common module containing domain models (JPA entities), DTOs, repositories, and core services.
- **Admin**: Spring Boot application for the administrative interface.
- **Customer**: Spring Boot application for the customer-facing storefront.
 

## ✨ Core Features

- Product and category management
- Basic shopping cart functionality
- Simple order processing
- User account management
- Admin dashboard for inventory management

## 🛠️ Technical Stack

- **Backend**: Spring Boot, Spring Data JPA
- **Database**: MySQL
- **Build Tool**: Maven

## 💼 Business Logic

The application implements these core eCommerce components:

- **Category Management**: Basic CRUD operations for product categories
- **Product Catalog**: Product information management with images
- **Shopping Cart**: Add/remove products and update quantities
- **Order Processing**: Simple order creation and status tracking
- **User Management**: Basic user authentication and authorization

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Maven 3.8+
- MySQL/PostgreSQL

### Setup Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/ndanhx/ecommerce-springboot.git
   cd ecommerce-springboot
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Configure your database connection in `application.properties`

4. Run the applications:
   ```bash
   # Run Admin application
   cd admin
   mvn spring-boot:run
   
   # Run Customer application
   cd customer
   mvn spring-boot:run
   ```

---

<p align="center">Developed by Nguyen Duy Anh</p>
