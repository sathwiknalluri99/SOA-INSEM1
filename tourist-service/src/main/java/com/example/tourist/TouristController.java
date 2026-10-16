package com.example.tourist;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TouristController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/tourists")
    public Map<String, Object> getTourists() {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("service", "TOURIST-SERVICE");
        response.put("instancePort", port);
        response.put("message", "Tourist service instance handled this request");
        response.put("tourists", new String[] {
            "Tirupati", "Araku Valley", "Charminar", "Konaseema"
        });
        return response;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP", "port", port);
    }
}
