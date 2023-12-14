# 🚗 Bilabonnement Backend 🚀

Welcome to the BA Backend repository!🌟

## Getting Started 🏁

Here's how to get the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java JDK 17
- Maven
- MySQL

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/ArneFogh/BABackend.git
   ```
2. Navigate to the project directory:
   ```bash
   cd BABackend
   ```
3. Install dependencies:
   ```bash
   mvn install
   ```
4. Run the application
   ```bash
   mvn spring-boot:run
   ```

## API Documentation 📚

The BA Backend API provides a comprehensive set of endpoints for managing various aspects of the car subscription service. Below is an overview of the available endpoints:

### Cars 🚗

- `GET /car`: Retrieve a list of all cars.
- `GET /car/{id}`: Retrieve a car by its ID.
- `POST /car/create`: Add a new car.
- `PUT /car/update/{id}`: Update a car's information.
- `DELETE /car/delete/{id}`: Remove a car from the system.

### Customers 👥

- `GET /customer`: Get all customers.
- `GET /customer/{id}`: Get details of a specific customer.
- `POST /customer/create`: Create a new customer.
- `PUT /customer/update/{id}`: Update a customer's information.
- `DELETE /customer/delete/{id}`: Delete a customer.

### Lease Agreements 📄

- `GET /leaseAgreement`: List all lease agreements.
- `GET /leaseAgreement/{id}`: Get details of a specific agreement.
- `POST /leaseAgreement/create`: Create a new lease agreement.
- `PUT /leaseAgreement/update/{id}`: Update an agreement.
- `DELETE /leaseAgreement/delete/{id}`: Terminate an agreement.

### Pickup Locations 📍

- `GET /pickupLocation`: Retrieve all pickup locations.
- `GET /pickupLocation/{id}`: Retrieve a pickup location by its ID.
- `POST /pickupLocation/create`: Add a new pickup location.
- `PUT /pickupLocation/update/{id}`: Update a pickup location's details.
- `DELETE /pickupLocation/delete/{id}`: Remove a pickup location.

### Users 👤

- `GET /user`: Get all users.
- `GET /user/{id}`: Get details of a specific user.
- `POST /user/create`: Create a new user.
- `PUT /user/update/{id}`: Update a user's information.
- `DELETE /user/delete/{id}`: Delete a user.
- `GET /user/loginCheck`: Check user login credentials.

## 👨‍👨‍👦‍👦Group members (Gruppe 5)

 - 😎Arne Fogh `@arnefogh` 
 - 🤠Gustav Frederik S.  `@gust9196`
 - 🌞Mads Runge `@madsrunge`
 - 🧐Nicklas Sienczak `@nicklassienczak`
 

If you wish to contact us, you can mention us by tagging with `@` followed by the username. We will receive a notification and will be able to assist you. Our usernames are listed above! Thanks 🥰

## ⚖️ License

This project is licensed under a [Creative Commons Attribution-NonCommercial 4.0 International License](https://creativecommons.org/licenses/by-nc/4.0/).
