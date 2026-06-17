package org.example.ch05.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.ch05.dto.User4DTO;
import org.example.ch05.dto.User5DTO;
import org.springframework.stereotype.Repository;

import java.util.List;

// MyBatis API 호출 컴포넌트
@Mapper
@Repository
public interface User5DAO {

    public void insert(User5DTO dto);
    public User5DTO select(String seq);
    public List<User5DTO> selectAll();
    public void update(User5DTO dto);
    public void delete(String seq);
}
