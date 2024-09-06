# Password Generator

**Password Generator** is a web application designed as part of Task 5 for my Future Intern internship. This project focuses on creating a versatile and user-friendly tool for generating strong, secure passwords. The application features customizable options and real-time validation, aiming to enhance security and user experience.

## Tech Stack

- **Frontend**:
  - HTML
  - CSS (Tailwind CSS)
  - JavaScript

- **Backend**:
  - Java
  - Spring Boot

- **Others**:
  - Thymeleaf (for templating)
  - Maven (for project management)

## Features

- **Dynamic Typing Text**: Engages users with a stylish animated typing effect.
- **Customizable Password Generation**: Options to specify password length, quantity, and include various character types (numbers, lowercase letters, uppercase letters, symbols).
- **Real-time Validation**: Ensures form fields are correctly filled, including at least one selected checkbox and a maximum limit of 10 passwords.
- **Responsive Design**: The application is designed to be fully responsive and functional across all device sizes.
- **Reset Functionality**: Clears all checkboxes, removes generated passwords, and resets form fields to default values.
- **Copy to Clipboard**: Allows users to easily copy generated passwords.

## Usage

1. **Generate Passwords**
   - Enter the desired password length and quantity.
   - Select the options for including numbers, lowercase letters, uppercase letters, and symbols.
   - Click "Generate Passwords" to create the passwords.

2. **Reset Form**
   - Click "Reset" to clear all checkboxes, generated passwords, and reset the form fields to default values.

3. **Copy Passwords**
   - Use the "Copy" button next to a generated password to copy it to the clipboard.

## UI Screenshot

![Password-generator](https://github.com/user-attachments/assets/99bcd930-94ad-49e4-8ee8-0926ac5fb74d)


## API Endpoints

### Generate Passwords

**POST** `/password/generate`

- **Request Body**: 
  ```json
  {
    "length": 12,
    "quantity": 3,
    "includeNumbers": true,
    "includeLowercase": true,
    "includeUppercase": true,
    "includeSymbols": true,
    "noSimilarChars": false,
    "noDuplicateChars": false,
    "noSequentialChars": false
  }

- **Response**:
  ```json
  [
  "A1b2C3d4E5fG6",
  "H7i8J9kL0mN1O",
  "P2q3R4s5T6uV7"
  ]

## Installation
- **1 .Clone the Repository**

```
git clone https://github.com/hey-its-d2t2/Futureintern_JD_5.git
cd Futureintern_JD_5
```
-  **2. Set Up the Backend**
    - Navigate to the backend directory and build the Spring Boot application.
```
cd backend
./mvnw spring-boot:run
```
- **3. Set Up the Frontend**

Open the following url your browser to view the application.
```
http://localhost:8080/password
```
## Development
To contribute to this project or make modifications, please follow these guidelines:
  - Ensure code adheres to project standards.
  - Include appropriate tests for new features.
  - Submit pull requests with detailed descriptions of changes.

### Acknowledgements
- **Tailwind CSS:** For providing beautiful and responsive UI components.
- **Spring Boot:** For enabling robust backend development.
- **Thymeleaf:** For effective templating.

## Contact
For any questions or feedback, please contact me at deepsinghkumar01@gmail.com.

