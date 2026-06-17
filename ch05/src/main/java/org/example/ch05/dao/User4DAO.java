package org.example.ch05.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.ch05.dto.User4DTO;
import org.springframework.stereotype.Repository;

import java.util.List;

// MyBatis API 호출 컴포넌트
@Mapper
@Repository
public interface User4DAO {

    public void insert(User4DTO dto);
    public User4DTO select(String userid);
    public List<User4DTO> selectAll();
    public void update(User4DTO dto);
    public void delete(String userid);
}
