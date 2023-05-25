package org.zerock.ex1.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.ex1.entity.Memo;

import java.util.Optional;
import java.util.function.IntToLongFunction;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@SpringBootTest
public class MemoRepositoryTests {
    @Autowired
    private MemoRepository memoRepository;

    @Test
    public void testInsert() {
        LongStream.rangeClosed(1, 100).forEach(i -> {
            Memo memo = Memo.builder().mno(i).memoText("text" + i).build();
            memoRepository.save(memo);
        });
    }

    @Test
    public void testSelect() {
        LongStream.rangeClosed(1, 100).forEach(mno -> {
            Optional<Memo> result = memoRepository.findById(mno);
            if (result.isPresent()) {
                Memo memo = result.get();
                System.out.println(memo);
            }
        });
    }

    @Test
    public void testUpdate() {
        LongStream.rangeClosed(1, 100).forEach(mno -> {
            Optional<Memo> result = memoRepository.findById(mno);
            if (result.isPresent()) {
                Memo memo = result.get();
                memo.setMemoText(memo.getMemoText() + " -> updated" + memo.getMno());
                memoRepository.save(memo);
            }
        });
    }

    @Test
    public void testDelete() {
        LongStream.rangeClosed(1, 100).forEach(mno -> {
            Optional<Memo> result = memoRepository.findById(mno);
            if (result.isPresent()) {
                memoRepository.deleteById(mno);
            }
        });
    }
}
