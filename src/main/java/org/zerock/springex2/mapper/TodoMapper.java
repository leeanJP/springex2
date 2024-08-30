package org.zerock.springex2.mapper;

import org.zerock.springex2.domain.TodoVO;
import org.zerock.springex2.dto.PageRequestDTO;

import java.util.List;

public interface TodoMapper {

    void insert(TodoVO todoVO);

    List<TodoVO> selectAll();

    List<TodoVO> selectList(PageRequestDTO pageRequestDTO);

    TodoVO selectOne(Long tno);

    void update(TodoVO todoVO);

    void delete(Long tno);

    int getCount(PageRequestDTO pageRequestDTO);







}
