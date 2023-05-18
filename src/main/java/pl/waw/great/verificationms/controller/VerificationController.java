package pl.waw.great.verificationms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.waw.great.verificationms.service.VerificationService;

@RestController
@RequestMapping(value = "/verify")
public class VerificationController {

    @Autowired
    private VerificationService verificationService;

    @PostMapping("{ean}/{action}")
    public VerificationResponse verificationResponse(@PathVariable String ean, @PathVariable ActionType action) {
        return verificationService.doAction(ean, action);
    }
}
