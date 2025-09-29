package com.fluxport.controller;

import com.fluxport.model.Message;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @GetMapping
    public Message getMessage() {
        return new Message("Hello from FluxPort GET!");
    }

    @PostMapping
    public Message postMessage(@RequestBody Message message) {
        return new Message("Received: " + message.getText());
    }
}
