# npl/README.md

# NPL Project

This project is a Spring Boot application that provides a RESTful API for various text processing functionalities. It includes endpoints for generating a unique letter bank, sorting letters, and matching words from a predefined word list.

## Features

- **Greeting Endpoint**: 
  - `GET /` - Returns a simple greeting message.
  
- **Letter Bank**: 
  - `GET /v1/letter-bank?q={query}` - Returns a unique set of letters from the provided query string.
  
- **Sort Letters**: 
  - `GET /v1/sort?q={query}` - Returns the letters from the provided query string sorted in alphabetical order.
  
- **Word Match**: 
  - `GET /v1/word-match?q={query}` - Reads a word list from a resource file and returns the sorted letters from the provided query string.

## Setup Instructions

1. **Clone the Repository**:
   ```
   git clone <repository-url>
   cd npl
   ```

2. **Build the Project**:
   Ensure you have Maven installed, then run:
   ```
   mvn clean install
   ```

3. **Run the Application**:
   ```
   mvn spring-boot:run
   ```

4. **Access the API**:
   Open your browser and navigate to `http://localhost:8080` to access the greeting message. Use the following endpoints for other functionalities:
   - `http://localhost:8080/v1/letter-bank?q=yourQuery`
   - `http://localhost:8080/v1/sort?q=yourQuery`
   - `http://localhost:8080/v1/word-match?q=yourQuery`

## Web Interface

The project includes a simple web interface located at `src/main/resources/static/index.html` that allows users to interact with the API endpoints easily.

## Word List

The word list used for the `word-match` endpoint is located in `src/main/resources/wordlists/words_alpha.txt`. Ensure this file is present for the endpoint to function correctly.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.