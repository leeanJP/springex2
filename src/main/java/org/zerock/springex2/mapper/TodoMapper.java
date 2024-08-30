package org.zerock.springex2.mapper;

import org.zerock.springex2.domain.TodoVO;

import java.util.List;

public interface TodoMapper {

    void insert(TodoVO todoVO);

    List<TodoVO> selectAll();

    TodoVO selectOne(Long tno);

    void update(TodoVO todoVO);

    void delete(Long tno);






}
