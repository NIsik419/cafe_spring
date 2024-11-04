//package com.example.fullCafe_spring_maven.service.cafe;
//
//import com.example.fullCafe_spring_maven.model.Cafe;
//import com.example.fullCafe_spring_maven.repository.cafe.CafeRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(SpringExtension.class)
//class CafeServiceImplTest {
//    private CafeService cafeService;
//    @MockBean
//    private CafeRepository cafeRepository;
//
//    private final Cafe cafe = Cafe.builder()
//            .name("cafe")
//            .address("address")
//            .phone("12345")
//            .build();
//
//    @BeforeEach
//    void setup(){
//        cafeService = new CafeServiceImpl(cafeRepository);
//    }
//
//    @Test
//    @DisplayName("카페 이름으로 카페 조회 - 서비스")
//    void findCafeByCafeName(){
//        //given
//        Optional<Cafe> optionalCafe = Optional.ofNullable(cafe);
//        Mockito.when(cafeRepository.findById(cafe.getName())).thenReturn(optionalCafe);
//        // 카페가 잘 존재
//        Cafe cafe1 = cafeService.findCafeByName(cafe.getName());
//        assertEquals(cafe1,cafe);
//        // 카페가 없으면 예외 발생
//        assertThrows(CafeNotFoundException.class,()->{
//            cafeService.findCafeByName("쓰레기 값");
//        });
//    }
//}