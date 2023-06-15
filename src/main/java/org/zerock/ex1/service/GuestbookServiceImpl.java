package org.zerock.ex1.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zerock.ex1.dto.GuestbookDTO;
import org.zerock.ex1.entity.Guestbook;
import org.zerock.ex1.repository.GuestbookRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class GuestbookServiceImpl implements GuestbookService {

    private final GuestbookRepository guestbookRepository;

    @Override
    public Long register(GuestbookDTO dto) {
        log.info("register------------------------");
        log.info(dto.toString());
        Guestbook entity = dtoToEntity(dto);
        Guestbook save = guestbookRepository.save(entity);
        return save.getGno();
    }

    @Override
    public List<GuestbookDTO> getList() {
        List<Guestbook> result = guestbookRepository.findAll();
        List<GuestbookDTO> list = result.stream().map(e -> entityToDto(e)).collect(Collectors.toList());
        return list;
    }

    @Override
    public GuestbookDTO get(Long gno) {
        Optional<Guestbook> result = guestbookRepository.findById(gno);
        return (result.isPresent()) ? entityToDto(result.get()) : null;
    }

    @Override
    public void modify(GuestbookDTO dto) {
        Optional<Guestbook> result = guestbookRepository.findById(dto.getGno());
        if (result.isPresent()) {
            Guestbook guestbook = result.get();
            guestbook.changeContent(dto.getContent());
            guestbook.changeTitle(dto.getTitle());
            guestbookRepository.save(guestbook);
        }
    }

    @Override
    public void remove(Long gno) {
        guestbookRepository.deleteById(gno);
    }

}
