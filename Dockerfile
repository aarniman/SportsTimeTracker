# Use the latest Maven image to build the application
FROM maven:latest

# Set the working directory
WORKDIR /app

# Copy the pom.xml to download the dependencies
COPY pom.xml /app/

# Copy yhe entire project to the container
COPY . /app/

# Package the application using Maven
RUN mvn clean package

# Run the main class from the built JAR
CMD ["java", "-jar", "target/SportsTimeTracker.jar"]
