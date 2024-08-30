package org.zerock.springex2.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.springex2.domain.TodoVO;
import org.zerock.springex2.dto.PageRequestDTO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
class TodoMapperTests {

    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    public void selectList() {

        PageRequestDTO dto = PageRequestDTO.builder()
                .page(2)
                .size(10)
                .build();

        List<TodoVO> voList = todoMapper.selectList(dto);

        voList.forEach(vo-> log.info(vo));

    }
}