# A React App to display data from a Public API

The application is divided into two distinct projects within a single repository, ensuring scalability and maintaining a clear separation of responsibilities:

**api** - This project is a Spring Boot application responsible for managing backend functionality.

**by-react-app** - This is a React-based application that utilizes AG-Grid to display and populate data.
## Prerequisites

 Ensure you have the following prerequisites installed on your system:

- **Java Development Kit (JDK)**: Version 8 or later.
- **Apache Maven**: You'll need Maven for building the project.
- **Node Package Manager(v9.8.0)**: You'll need npm to install dependencies for React project and run the application.

## Getting Started
### Setting up backend application

Follow these steps to set up, run, and test the application:

1. **Clone the Repository**

```bash
git clone https://github.com/your-username/your-repo-name.git
```

2. **Navigate to the api Directory**

```bash
cd your-repo-name/api
```

3. **Build the Backend**

```bash

mvn clean install
```

4. **Run the Backend**
Simply run the class ApiApplication.java

The backend will be accessible at http://localhost:8080.


### Setting up frontend application

1. **Navigate to the by-react-app Directory**

```bash
cd your-repo-name/by-react-app
```

2. **Install dependencies**
```bash
npm install
```
3. **Run React App**
```bash
npm start
```

The React app will open in your web browser at http://localhost:3000, fetching and displaying data from the Spring Boot backend.
