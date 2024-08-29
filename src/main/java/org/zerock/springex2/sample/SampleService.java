package org.zerock.springex2.sample;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@ToString
@Service
@RequiredArgsConstructor
public class SampleService {

    //@NoArgsConstructor : 기본 생성자
    //@AllArgsConstructor : 모든 필드를 가지는 생성자
    //@RequiredArgsConstructor : final필드, @Notnull 필드
    //를 가지는 생성자

    @Qualifier("normal")
    private final SampleDAO sampleDAO;
}
