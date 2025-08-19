package com.mypackage.springboot.todowebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {

    @RequestMapping("/todowebapp/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello World";
    }

    @RequestMapping("/todowebapp/hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>Todo</title></head>");
        sb.append("<body><h1>Hello World</h1></body></html>");
        return sb.toString();
    }

    @RequestMapping("/todowebapp/hello-jsp") 
    public String sayHelloJSP() {
        return "sayHello";
    }
}
