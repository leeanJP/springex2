package org.zerock.springex2.service;

import org.zerock.springex2.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    void register(TodoDTO todoDTO);

    List<TodoDTO> getAll();

    TodoDTO getOne(Long tno);

    void modify(TodoDTO todoDTO);

    void delete(Long tno);
}
