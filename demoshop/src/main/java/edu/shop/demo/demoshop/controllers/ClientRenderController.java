package edu.shop.demo.demoshop.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

//Clase enfocada en devolve otro tipo de valores que no sean JSON como en el ClientRestController.
@RestController
public class ClientRenderController {


    @GetMapping(value = "/client-html", produces = MediaType.TEXT_HTML_VALUE)
    public String getClientAsHTML()//Esto tambien podriamos hacerlo con un xml
    {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<body>");
        stringBuilder.append("<div> Test </div>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        return stringBuilder.toString();
    }




}
