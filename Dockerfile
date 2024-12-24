# 使用官方的 OpenJDK 11 镜像作为基础镜像
FROM openjdk:11

#作者
MAINTAINER sheng

# 设置工作目录
WORKDIR /app

#将jar包添加到容器中并更名为: hello-docker-image.jar
COPY alicloud-test-0.0.1.jar /app/your-java-app.jar

#暴露端口
EXPOSE 8080

# 定义容器启动时要执行的命令
CMD ["java", "-jar", "your-java-app.jar"]