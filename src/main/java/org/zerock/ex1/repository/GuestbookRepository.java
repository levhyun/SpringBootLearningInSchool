package org.zerock.ex1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.ex1.entity.Guestbook;

public interface GuestbookRepository extends JpaRepository<Guestbook, Long> {

}
