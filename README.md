# 🏢 Apartment Rental Website

[![Angular](https://img.shields.io/badge/Angular-16-DD0031?style=for-the-badge&logo=angular)](https://angular.io/)
[![Java](https://img.shields.io/badge/Java-21-007396?style=for-the-badge&logo=java)](https://www.oracle.com/java/)
[![Tomcat](https://img.shields.io/badge/Tomcat-11.0.0-F8DC75?style=for-the-badge&logo=apache-tomcat)](https://tomcat.apache.org/)
[![VNPAY](https://img.shields.io/badge/Payment-VNPAY-2361DE?style=for-the-badge)](https://sandbox.vnpayment.vn/)

A comprehensive web application for apartment rental listings developed by third-year university students. The platform connects customers seeking apartments with sellers listing their properties.

![Apartment Rental Banner](https://via.placeholder.com/1200x400?text=Apartment+Rental+Platform)

## 📋 Table of Contents

- [Features](#-features)
- [User Roles](#-user-roles)
- [Technology Stack](#-technology-stack)
- [Statistics & Analytics](#-statistics--analytics)
- [Installation & Setup](#-installation--setup)
  - [Prerequisites](#prerequisites)
  - [Backend Setup](#backend-setup)
  - [Frontend Setup](#frontend-setup)
- [Usage](#-usage)
- [Contributing](#-contributing)
- [License](#-license)

## ✨ Features

- **Seamless Apartment Search**: Advanced filtering and search capabilities
- **Listing Management**: Intuitive interface for creating and managing properties
- **Approval System**: Quality assurance through moderation
- **Admin Dashboard**: Comprehensive analytics and user management
- **Payment Integration**: Secure transaction processing with VNPAY

## 👥 User Roles

### Customer
- Browse and search for available rental listings
- Save favorite listings to a personal collection
- View property details and contact information

### Seller
- Create and manage apartment listings efficiently
- Update listing details and manage availability
- Track listing performance and viewer statistics

### Moderator
- Review and approve new listings to ensure quality
- Monitor user activities and ensure compliance
- Manage content and user interactions

### Admin
- Manage user accounts and define roles
- Access and analyze platform statistics
- Oversee and optimize overall functionality

## 🛠️ Technology Stack

### Frontend
- **Angular 16**: Modern, robust framework for dynamic web applications

### Backend
- **Java**: Core programming language
- **JDBC**: Database connectivity and interactions

### Payment
- **VNPAY Sandbox**: Secure payment simulation environment

## 📊 Statistics & Analytics

The platform provides comprehensive analytics including:

- **Revenue Tracking**: Financial performance metrics
- **Listing Views**: Popularity indicators for each property
- **Inventory Monitoring**: Total published listing counts

## 🚀 Installation & Setup

### Prerequisites

1. **Java Development Kit (JDK)**
   ```bash
   # JDK 21 required
   java -version  # Verify installation
   ```
   [Download JDK 21](https://www.oracle.com/java/technologies/downloads/#java21)

2. **Apache Tomcat**
   ```bash
   # Tomcat 11.0.0 required
   # Verify installation by accessing http://localhost:8080 after starting
   ```
   [Download Tomcat 11.0.0](https://tomcat.apache.org/download-11.cgi)

3. **Node.js and NPM**
   ```bash
   # Verify installations
   node -v
   npm -v
   ```
   [Download Node.js](https://nodejs.org/)

### Backend Setup

1. **Clone Repository**
   ```bash
   git clone https://github.com/your-username/apartment-rental-backend.git
   cd apartment-rental-backend
   ```

2. **Build and Deploy**
   ```bash
   mvn clean package
   # Copy the WAR file to Tomcat's webapps directory
   cp target/apartment-backend-1.0-SNAPSHOT.war /path/to/tomcat/webapps/
   ```

3. **Start Tomcat**
   ```bash
   # Navigate to Tomcat bin directory
   cd /path/to/tomcat/bin
   ./startup.sh  # On Unix/Linux/Mac
   # OR
   startup.bat   # On Windows
   ```
   Backend will be available at: `http://localhost:8080/apartment-backend-1.0-SNAPSHOT/`

### Frontend Setup

1. **Clone Repository**
   ```bash
   git clone https://github.com/your-username/apartment-rental-frontend.git
   cd apartment-rental-frontend
   ```

2. **Install Dependencies**
   ```bash
   npm install
   ```

3. **Configure Backend API**
   
   Update `src/environments/environment.ts`:
   ```typescript
   export const environment = {
     production: false,
     apiUrl: 'http://localhost:8080/apartment-backend-1.0-SNAPSHOT/'
   };
   ```

4. **Run Application**
   ```bash
   npm start
   # OR
   ng serve
   ```
   Frontend will be available at: `http://localhost:4200/`

## 🎮 Usage

1. Access the application at `http://localhost:4200/`
2. Create an account and select your user role
3. Explore the platform based on your permissions:
   - Customers can browse and save listings
   - Sellers can create and manage properties
   - Moderators can approve content
   - Admins can manage users and view analytics
 

---

<p align="center">Developed with ❤️ by Nguyen Duy Anh (Brian)</p>
