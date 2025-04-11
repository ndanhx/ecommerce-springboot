# 🏢 Apartment Rental Website

[![Angular](https://img.shields.io/badge/Angular-16-DD0031?style=for-the-badge&logo=angular)](https://angular.io/)
[![Java](https://img.shields.io/badge/Java-21-007396?style=for-the-badge&logo=java)](https://www.oracle.com/java/)
[![Tomcat](https://img.shields.io/badge/Tomcat-11.0.0-F8DC75?style=for-the-badge&logo=apache-tomcat)](https://tomcat.apache.org/)
[![VNPAY](https://img.shields.io/badge/Payment-VNPAY-2361DE?style=for-the-badge)](https://sandbox.vnpayment.vn/)

A comprehensive web application for apartment rental listings developed by third-year university students. The platform connects customers seeking apartments with sellers listing their properties. Our solution simplifies the rental process by providing a user-friendly interface, robust search capabilities, and secure payment processing.
 
## 📋 Table of Contents

- [Features](#-features)
- [User Roles](#-user-roles)
- [Technology Stack](#-technology-stack)
- [Statistics & Analytics](#-statistics--analytics)
- [Project Architecture](#-project-architecture)
- [Installation & Setup](#-installation--setup)
  - [Prerequisites](#prerequisites)
  - [Backend Setup](#backend-setup)
  - [Frontend Setup](#frontend-setup)
- [Key Components](#-key-components)
- [Usage](#-usage)
- [Screenshots](#-screenshots)
- [Contributing](#-contributing)
- [License](#-license)

## ✨ Features

- **Seamless Apartment Search**: Advanced filtering and search capabilities based on location, price range, amenities, and more
- **Listing Management**: Intuitive interface for creating and managing properties with multi-image upload and detailed property information
- **Approval System**: Quality assurance through moderation to ensure only legitimate and accurately described properties are published
- **Admin Dashboard**: Comprehensive analytics and user management with real-time statistics
- **Payment Integration**: Secure transaction processing with VNPAY for rental deposits and payments
- **Responsive Design**: Fully optimized for mobile, tablet, and desktop viewing experiences
- **Notifications System**: Automatic alerts for listing updates, approvals, and messages
- **Multi-language Support**: Interface available in both English and Vietnamese
- **Interactive Maps**: Location visualization using map integration

## 👥 User Roles

### Customer
- Browse and search for available rental listings with advanced filtering
- Save favorite listings to a personal collection for future reference
- View property details including high-resolution images, amenities, and location maps
- Contact sellers directly through the in-platform messaging system
- Make secure payments and reservations through VNPAY integration
- Leave reviews and ratings for properties they've rented

### Seller
- Create and manage apartment listings efficiently with comprehensive property details
- Update listing details and manage availability in real-time
- Track listing performance and viewer statistics with detailed analytics
- Respond to customer inquiries through the messaging system
- Receive notifications for new inquiries and booking requests
- Verify payments and manage reservation confirmations

### Moderator
- Review and approve new listings to ensure quality and compliance with platform standards
- Monitor user activities and ensure compliance with terms of service
- Manage content and user interactions including dispute resolution
- Flag suspicious activities and take appropriate actions
- Oversee review system to prevent fraudulent or inappropriate content
- Generate reports on platform activity for administrative review

### Admin
- Manage user accounts and define roles with comprehensive access controls
- Access and analyze platform statistics including financial reports and user engagement metrics
- Oversee and optimize overall functionality of the platform
- Configure system settings and parameters
- Implement and manage promotional campaigns
- Access audit logs and security reports
- Perform database management and system maintenance tasks

## 🛠️ Technology Stack

### Frontend
- **Angular 16**: Modern, robust framework for dynamic web applications
- **TypeScript**: Enhanced JavaScript for better type safety and developer experience
- **RxJS**: Reactive programming for handling asynchronous operations
- **Angular Material**: UI component library for consistent and professional design
- **SCSS**: Advanced styling with variables and nested rules
- **NgRx**: State management for complex application data flow

### Backend
- **Java**: Core programming language for server-side development
- **JDBC**: Database connectivity and interactions for efficient data management
- **RESTful API**: Modern API architecture for seamless client-server communication
- **JWT Authentication**: Secure token-based user authentication and authorization
- **Apache Tomcat**: Reliable web server and servlet container

### Database
- **MySQL**: Robust relational database for structured data storage
- **Stored Procedures**: Optimized database operations for complex queries

### Payment
- **VNPAY Sandbox**: Secure payment simulation environment for testing transactions
- **Payment API Integration**: Complete payment lifecycle management

### DevOps
- **Git**: Version control for collaborative development
- **Maven**: Dependency management and build automation
- **Continuous Integration**: Automated testing and deployment workflows

## 📊 Statistics & Analytics

The platform provides comprehensive analytics including:

- **Revenue Tracking**: Financial performance metrics with detailed transaction history
  - Daily, weekly, monthly, and yearly revenue reports
  - Payment method distribution analytics
  - Revenue forecasting based on historical data

- **Listing Views**: Popularity indicators for each property
  - Detailed view counts with time-based analysis
  - User demographic information for property views
  - Conversion rates from views to inquiries and bookings

- **Inventory Monitoring**: Total published listing counts
  - Distribution by property type, location, and price range
  - Listing status tracking (pending, approved, rented)
  - Average time-to-rent metrics

- **User Engagement**: Comprehensive user activity metrics
  - Active users statistics with retention analysis
  - User behavior patterns and journey mapping
  - Feature usage distribution across different user segments

## 🏗️ Project Architecture

The application follows a modular architecture with clear separation of concerns:

### Frontend Architecture
```
apartment-rental-frontend/
├── src/
│   ├── app/
│   │   ├── core/           # Core modules, services, and guards
│   │   ├── shared/         # Shared components, directives, and pipes
│   │   ├── features/       # Feature modules (customer, seller, admin, etc.)
│   │   ├── layouts/        # Application layout components
│   │   └── app.module.ts   # Main application module
│   ├── assets/            # Static assets (images, fonts, etc.)
│   └── environments/      # Environment configuration
└── angular.json          # Angular configuration file
```

### Backend Architecture
```
apartment-rental-backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── controller/ # REST API endpoints
│   │   │   ├── model/      # Domain models
│   │   │   ├── service/    # Business logic
│   │   │   ├── repository/ # Data access layer
│   │   │   ├── config/     # Configuration classes
│   │   │   └── util/       # Utility classes
│   │   └── resources/     # Application resources
│   └── test/             # Unit and integration tests
└── pom.xml              # Maven configuration file
```

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
   node -v  # Should be v16.x or higher
   npm -v   # Should be v8.x or higher
   ```
   [Download Node.js](https://nodejs.org/)

4. **MySQL Database**
   ```bash
   # Verify MySQL installation
   mysql --version
   ```
   [Download MySQL](https://dev.mysql.com/downloads/)

### Backend Setup

1. **Clone Repository**
   ```bash
   git clone https://github.com/ndanhx/apartment-rental.git 
   cd apartment-backend
   ```

2. **Configure Database**
   ```bash
   # Create database and user
   mysql -u root -p
   CREATE DATABASE apartment_rental;
   CREATE USER 'apartment_user'@'localhost' IDENTIFIED BY 'your_password';
   GRANT ALL PRIVILEGES ON apartment_rental.* TO 'apartment_user'@'localhost';
   FLUSH PRIVILEGES;
   EXIT;
   
   # Import initial database schema
   mysql -u apartment_user -p apartment_rental < database/schema.sql
   ```

3. **Configure Application Properties**
   
   Update `src/main/resources/application.properties`:
   ```properties
   db.url=jdbc:mysql://localhost:3306/apartment_rental
   db.username=apartment_user
   db.password=your_password
   
   # VNPAY configuration
   vnpay.tmn.code=your_vnpay_tmn_code
   vnpay.hash.secret=your_vnpay_hash_secret
   vnpay.api.url=https://sandbox.vnpayment.vn/paymentv2/vpcpay.html
   ```

4. **Build and Deploy**
   ```bash
   mvn clean package
   # Copy the WAR file to Tomcat's webapps directory
   cp target/apartment-backend-1.0-SNAPSHOT.war /path/to/tomcat/webapps/
   ```

5. **Start Tomcat**
   ```bash
   # Navigate to Tomcat bin directory
   cd /path/to/tomcat/bin
   ./startup.sh  # On Unix/Linux/Mac
   # OR
   startup.bat   # On Windows
   ```
   Backend will be available at: `http://localhost:8080/apartment-backend-1.0-SNAPSHOT/`

### Frontend Setup

1. **Navigate to Frontend Directory**
   ```bash
   cd apartment-frontend
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
     apiUrl: 'http://localhost:8080/apartment-backend-1.0-SNAPSHOT/',
     mapApiKey: 'your_map_api_key',
     vnpayReturnUrl: 'http://localhost:4200/payment/return'
   };
   ```

4. **Run Application**
   ```bash
   npm start
   # OR
   ng serve --open
   ```
   Frontend will be available at: `http://localhost:4200/`

## 🧩 Key Components

### Customer Portal
- **Property Search**: Advanced search with filters for location, price, amenities, and property type
- **Property Details**: Comprehensive property information with images, maps, and amenities
- **Favorites**: Save and organize favorite properties
- **Booking**: Streamlined booking process with payment integration
- **User Profile**: Manage personal information and booking history

### Seller Dashboard
- **Listing Management**: Create, edit, and delete property listings
- **Analytics**: Track property performance and viewer statistics
- **Messaging**: Communicate with interested customers
- **Calendar**: Manage property availability and bookings
- **Notifications**: Real-time alerts for inquiries and bookings

### Admin Control Panel
- **User Management**: Create, edit, and manage user accounts and roles
- **Property Oversight**: Monitor and manage all property listings
- **Revenue Reports**: Generate and export financial reports
- **System Configuration**: Adjust platform settings and parameters
- **Activity Logs**: Track user actions and system events

## 🎮 Usage

1. Access the application at `http://localhost:4200/`
2. Create an account and select your user role
3. Explore the platform based on your permissions:
   - Customers can browse and save listings
   - Sellers can create and manage properties
   - Moderators can approve content
   - Admins can manage users and view analytics

### Demo Accounts

For testing purposes, you can use these pre-configured accounts:

- **Customer**: 
  - Email: customer@example.com
  - Password: Customer@123

- **Seller**: 
  - Email: seller@example.com
  - Password: Seller@123

- **Moderator**: 
  - Email: moderator@example.com
  - Password: Moderator@123

- **Admin**: 
  - Email: admin@example.com
  - Password: Admin@123
 
## 🤝 Contributing

We welcome contributions to improve the Apartment Rental Website. Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Coding Standards
- Follow Angular Style Guide for frontend code
- Follow Google Java Style Guide for backend code
- Write unit tests for new features
- Document public APIs using JavaDoc and JSDoc standards
 
---

<p align="center">Developed with ❤️ by Nguyen Duy Anh (Brian)</p>
