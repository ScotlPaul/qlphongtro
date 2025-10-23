# Sử dụng image có sẵn của Java 17
FROM openjdk:17-jdk-slim

# Đặt thư mục làm việc trong container
WORKDIR /app

# Copy toàn bộ mã nguồn vào container
COPY . .

# Build ứng dụng bằng Maven Wrapper
RUN ./mvnw clean package -DskipTests

# Expose cổng ứng dụng
EXPOSE 8080

# Lệnh chạy khi khởi động container
CMD ["java", "-Dserver.port=8080", "-jar", "target/qlphongtro-0.0.1-SNAPSHOT.jar"]
