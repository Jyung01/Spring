package org.example.ch05.service;

import lombok.RequiredArgsConstructor;
import org.example.ch05.dao.User4DAO;
import org.example.ch05.dao.User5DAO;
import org.example.ch05.dto.User4DTO;
import org.example.ch05.dto.User5DTO;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class User5Service {

    //  주입 대상 속성에 final 선언해서 RequiredArgsConstructor 어노테이션 으로 주입
    private final User5DAO dao;

    // DAO 호출 메서드
    public void register(User5DTO dto) {
        dao.insert(dto);
    }

    public User5DTO getById(String seq) {
        return dao.select(seq);
    }

    public List<User5DTO> getAll() {
        return dao.selectAll();
    }

    public void modify(User5DTO user5DTO) {
        dao.update(user5DTO);
    }

    public void remove(String seq) {
        dao.delete(seq);
    }

}
