package com.example.fullCafe_spring_maven.service.cafe;

import com.example.fullCafe_spring_maven.model.Cafe;
import com.example.fullCafe_spring_maven.repository.cafe.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CafeServiceImpl implements CafeService {

    @Autowired
    private CafeRepository cafeRepository;

    @Override
    public Cafe findCafeByName(String name) {
        return cafeRepository.findById(name).orElse(null);
    }

    @Override
    public List<Cafe> findAllCafes() {
        return cafeRepository.findAll();
    }

    @Override
    public List<Cafe> searchCafesByFilters(String name, Boolean wifi, Boolean petFriendly, Boolean takeout,
                                           Boolean groupFriendly, Boolean parking, Boolean easyPayment,
                                           Boolean delivery, List<String> keywords) {
        long keywordCount = (keywords != null) ? keywords.size() : 0;
        return cafeRepository.findByFiltersWithKeywordPriority(name, wifi, petFriendly, takeout,
                groupFriendly, parking, easyPayment, delivery, keywords, keywordCount);
    }
}
