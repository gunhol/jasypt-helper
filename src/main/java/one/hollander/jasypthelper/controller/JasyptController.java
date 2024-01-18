package one.hollander.jasypthelper.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import one.hollander.jasypthelper.enums.JasyptVersion;
import one.hollander.jasypthelper.service.JasyptService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jasypt")
@RequiredArgsConstructor
@Tag(name = "Jasypt Actions")
public class JasyptController {
    private final JasyptService jasyptService;

    @PostMapping("/encrypt")
    public String encrypt(@RequestParam(value = "input") String input,
                          @RequestParam(value = "secret") String secret,
                          @RequestParam(value = "version") JasyptVersion jasyptVersion) {
        return jasyptService.encrypt(input, secret, jasyptVersion);
    }

    @PostMapping("/decrypt")
    public String decrypt(@RequestParam(value = "input") String input,
                          @RequestParam(value = "secret") String secret,
                          @RequestParam(value = "version") JasyptVersion jasyptVersion) {
        return jasyptService.decrypt(input, secret, jasyptVersion);
    }
}
