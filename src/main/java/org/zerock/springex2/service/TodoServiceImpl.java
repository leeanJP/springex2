package org.zerock.springex2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.springex2.domain.TodoVO;
import org.zerock.springex2.dto.PageRequestDTO;
import org.zerock.springex2.dto.PageResponseDTO;
import org.zerock.springex2.dto.TodoDTO;
import org.zerock.springex2.mapper.TodoMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoMapper todoMapper;

    private final ModelMapper modelMapper;


    @Override
    public void register(TodoDTO todoDTO) {
        log.info(modelMapper);
        TodoVO vo = modelMapper.map(todoDTO, TodoVO.class);

        log.info(vo);

        todoMapper.insert(vo);

    }

//    @Override
//    public List<TodoDTO> getAll() {
//        List<TodoDTO> dtoList = todoMapper.selectAll().stream()
//                .map(vo-> modelMapper.map(vo,TodoDTO.class))
//                .collect(Collectors.toList());
//
//        return dtoList;
//    }


    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {

        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
        List<TodoDTO> dtoList = voList.stream()
                .map(vo->modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());

        int total = todoMapper.getCount(pageRequestDTO);

        PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }

    @Override
    public TodoDTO getOne(Long tno) {

        TodoVO vo = todoMapper.selectOne(tno);
        TodoDTO dto = modelMapper.map(vo,TodoDTO.class);
        return dto;
    }

    @Override
    public void modify(TodoDTO todoDTO) {
        TodoVO vo = modelMapper.map(todoDTO, TodoVO.class);
        todoMapper.update(vo);
    }

    @Override
    public void delete(Long tno) {
        todoMapper.delete(tno);
    }
}
