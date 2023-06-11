FROM openjdk:11
WORKDIR /hw01
COPY ./3_Homeworks/Homework01 ./src
RUN mkdir ./out
RUN javac -sourcepath ./src -d out ./src/hw01/app/Main.java
CMD java -classpath ./out hw01.app.Main