package com.ltp.workbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowsController {
    @GetMapping("/")
    public String getShows() {
        return "shows";
    }
}
