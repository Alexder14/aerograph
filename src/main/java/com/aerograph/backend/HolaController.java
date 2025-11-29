package com.aerograph.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 1. Dice: "Soy un recepcionista web"
public class HolaController {

    @GetMapping("/") // 2. Dice: "Cuando entren a la página principal..."
    public String saludar() {
        return "¡Hola Mundo! 🌍 AeroGraph está vivo en Docker ✈️"; // 3. "...responde esto"
    }
}