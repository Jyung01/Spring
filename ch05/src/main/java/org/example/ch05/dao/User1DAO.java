package org.example.ch05.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.ch05.dto.User1DTO;
import org.springframework.stereotype.Repository;

import java.util.List;

// MyBatis API 호출 컴포넌트
@Mapper
@Repository
public interface User1DAO {

    public void insert(User1DTO dto);
    public User1DTO select(String userid);
    public List<User1DTO> selectAll();
    public void update(User1DTO dto);
    public void delete(String userid);
}
