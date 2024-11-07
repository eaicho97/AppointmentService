Appointment Service
This project is part of a dog grooming appointment system. The Appointment microservice manages the scheduling, updating, deletion, and retrieval of grooming appointments for dogs, linking information from registered dogs and their owners.

Technologies
Java 21
Spring Boot
MySQL (shared with the Owner and Dog microservices)
Spring Cloud (for Eureka and API Gateway integration)
Dependencies
The project requires the following main dependencies:

Spring Web: To expose REST endpoints with HTTP methods (GET, POST, PUT, DELETE).
Spring Data JPA: For handling entities and database integration.
MySQL Driver: To connect with the MySQL database.
Spring Cloud (Eureka Discovery Client): To register the service with Eureka (if using microservices and an API Gateway).
Spring Boot Actuator: For application monitoring (optional).
Configuration
Clone the repository and navigate to the project folder:

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka

API Endpoints
Method	Endpoint	Description
GET	/appointments	Retrieves all scheduled appointments.
GET	/appointments/{id}	Retrieves a specific appointment by ID.
POST	/appointments	Creates a new appointment.
PUT	/appointments/{id}	Updates an appointment by ID.
DELETE	/appointments/{id}	Deletes an appointment by ID.
Request/Response Example
POST /appointments

Additional Notes
This microservice is designed to function alongside the Owner and Dog microservices, integrating through the shared database and registration with Eureka Server (if used).

Contributions
To contribute, create a new branch from main, make your changes, and open a Pull Request describing your improvements or fixes.

License
