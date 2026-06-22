package org.example.ch06.repository;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.example.ch06.dto.User1DTO;
import org.example.ch06.entity.User1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@SpringBootTest
class User1RepositoryTest {

    @Autowired
    private User1Repository repository;

    @Test
    void findByUserid() {

        User1 entity = repository.findByUserid("test123");

        log.info(entity.toString());
    }

    @Test
    void findByName() {
        List<User1> entityList = repository.findByName("김유신");
        log.info(entityList);
    }

    @Test
    void findByNameNot() {
        List<User1> entityList = repository.findByNameNot("김유신");
        log.info(entityList);

    }

    @Test
    void findByUseridAndName() {
        User1 entity = repository.findByUseridAndName("A101", "김유신");
        log.info(entity);
    }

    @Test
    void findByUseridOrName() {
        List<User1> entityList = repository.findByUseridOrName("A102", "김유신");
        log.info(entityList);
    }

    @Test
    void findByHp() {
        List<User1> entityList = repository.findByHp("010-1234-1111");
        log.info(entityList);
    }

    @Test
    void findByAgeGreaterThan() {
        List<User1> entityList = repository.findByAgeGreaterThan(25);
        log.info(entityList);
    }

    @Test
    void findByAgeGreaterThanEqual() {
        List<User1> entityList = repository.findByAgeGreaterThanEqual(25);
        log.info(entityList);
    }

    @Test
    void findByAgeLessThan() {
        List<User1> entityList = repository.findByAgeLessThan(25);
        log.info(entityList);
    }

    @Test
    void findByAgeLessThanEqual() {
        List<User1> entityList = repository.findByAgeLessThanEqual(25);
        log.info(entityList);
    }

    @Test
    void findByAgeBetween() {
        List<User1> entityList = repository.findByAgeBetween(25, 40);
        log.info(entityList);
    }

    @Test
    void findByNameLike() {
        List<User1> entityList = repository.findByNameLike("유");
        log.info(entityList);
    }

    @Test
    void findByNameContains() {
        List<User1> entityList = repository.findByNameContains("유");
        log.info(entityList);
    }

    @Test
    void findByNameStartsWith() {
        List<User1> entityList = repository.findByNameStartsWith("김");
        log.info(entityList);
    }

    @Test
    void findByNameEndsWith() {
        List<User1> entityList = repository.findByNameEndsWith("신");
        log.info(entityList);
    }

    @Test
    void findByOrderByName() {
        List<User1> entityList = repository.findByOrderByName();
        log.info(entityList);
    }

    @Test
    void findByOrderByAgeAsc() {
        List<User1> entityList = repository.findByOrderByAgeAsc();
        log.info(entityList);
    }

    @Test
    void findByOrderByAgeDesc() {
        List<User1> entityList = repository.findByOrderByAgeDesc();
        log.info(entityList);
    }

    @Test
    void findByAgeGreaterThanOrderByAgeDesc() {
        List<User1> entityList = repository.findByAgeGreaterThanOrderByAgeDesc(40);
        log.info(entityList);
    }

    @Test
    void countByUserid() {
        int result = repository.countByUserid("A101");
        log.info(result);
    }

    @Test
    void countByName() {
        int result = repository.countByName("김유신");
        log.info(result);
    }

    @Test
    void selectUnderAge30() {
        List<User1> entityList = repository.selectUnderAge30();
        log.info(entityList);
    }

    @Test
    void selectByName() {
        List<User1> entityList = repository.selectByName("김유신");
        log.info(entityList);
    }

    @Test
    void selectByUserid() {
        List<Object[]> objList = repository.selectByUserid("a101");

        for (Object[] obj : objList) {
            log.info(obj[0]);
            log.info(obj[1]);
            log.info(obj[2]);
        }

    }

    @Test
    void selectParentChild() {

    }
}