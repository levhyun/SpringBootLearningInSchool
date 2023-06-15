package org.zerock.ex1.service;

import org.zerock.ex1.dto.GuestbookDTO;
import org.zerock.ex1.entity.Guestbook;

import java.util.List;

public interface GuestbookService {

    Long register(GuestbookDTO dto);

    List<GuestbookDTO> getList();

    GuestbookDTO get(Long gno);

    void modify(GuestbookDTO dto);

    void remove(Long gno);

    default Guestbook dtoToEntity(GuestbookDTO dto) {
        return Guestbook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
    }

    default GuestbookDTO entityToDto(Guestbook entity) {
        return GuestbookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
    }

}
