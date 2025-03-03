package com.grpcdemo.grpcdemoclient;

import com.grpcdemo.grpcdemoclient.service.GrpcClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class GrpcDemoClientApplication {

    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(GrpcDemoClientApplication.class, args);
        GrpcClientService service = context.getBean(GrpcClientService.class);
        Scanner scanner = new Scanner(System.in);

        while (true){
            String name = scanner.nextLine();
            String message = service.sayHello(name);
            System.out.println(message);
        }
    }

}
