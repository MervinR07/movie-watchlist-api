# Use an official JDK runtime as a parent image
FROM eclipse-temurin:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper and build files
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# Copy the entire project and build the application
COPY src ./src
RUN ./mvnw clean package -DskipTests

# Run the application
CMD ["java", "-jar", "/app/target/movie-watchlist-0.0.1-SNAPSHOT.jar"]

