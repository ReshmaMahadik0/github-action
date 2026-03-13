echo "STEP 1 : Build Spring Boot Project"
./mvnw clean install -DskipTests


echo "STEP 2 : Run Tests"
./mvnw test