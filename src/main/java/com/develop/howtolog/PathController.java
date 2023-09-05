package com.develop.howtolog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class PathController 
{
    @GetMapping("/logTest")
    public String logging()
    {
        log.info("부부젤라");
        log.debug("디버그");
        log.error("에러만");

        return "done";
    }

    @GetMapping("/errorE")
    public void logging_Error()
    {
        log.error("에러 발생!");
    }


    @GetMapping("/info")
    public void logging_INFO()
    {
        log.info("인포 발생");
    }

    @GetMapping("/debug")
    public void logging_DEBUG()
    {
        log.debug("디버그 발생");
    }
}
