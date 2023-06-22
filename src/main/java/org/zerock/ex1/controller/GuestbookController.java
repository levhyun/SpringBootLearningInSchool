package org.zerock.ex1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.zerock.ex1.dto.GuestbookDTO;
import org.zerock.ex1.service.GuestbookService;

import java.util.List;

@RestController
@RequestMapping("/guestbook")
@RequiredArgsConstructor
@Slf4j
public class GuestbookController {
    private final GuestbookService guestbookService;

    @GetMapping("/{gno}")
    public GuestbookDTO get(@PathVariable("gno") Long gno) {
        return guestbookService.get(gno);
    }

    @GetMapping("/list")
    public List<GuestbookDTO> getList() {
        return guestbookService.getList();
    }

    @PostMapping("/")
    public Long register(@RequestBody GuestbookDTO dto) {
        log.info(dto.toString());
        return guestbookService.register(dto);
    }

    @PutMapping("/")
    public void modify(@RequestBody GuestbookDTO dto) {
        log.info(dto.toString());
        guestbookService.modify(dto);
    }

    @DeleteMapping("/{gno}")
    public void remove(@PathVariable("gno") Long gno) {
        guestbookService.remove(gno);
    }


}