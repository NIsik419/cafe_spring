package com.example.fullCafe_spring_maven.repository.cafe;

import com.example.fullCafe_spring_maven.model.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CafeRepository extends JpaRepository<Cafe, String> {

    @Query("SELECT c FROM Cafe c " +
            "LEFT JOIN c.keywords ck " +
            "WHERE (:name IS NULL OR c.name LIKE %:name%) " +
            "AND (:wifi IS NULL OR c.wifi = :wifi) " +
            "AND (:petFriendly IS NULL OR c.petFriendly = :petFriendly) " +
            "AND (:takeout IS NULL OR c.takeout = :takeout) " +
            "AND (:groupFriendly IS NULL OR c.groupFriendly = :groupFriendly) " +
            "AND (:parking IS NULL OR c.parking = :parking) " +
            "AND (:easyPayment IS NULL OR c.easyPayment = :easyPayment) " +
            "AND (:delivery IS NULL OR c.delivery = :delivery) " +
            "AND (:keywords IS NULL OR ck.keyword IN :keywords) " +
            "GROUP BY c " +
            "HAVING COUNT(DISTINCT ck.keyword) = :keywordCount " + // 선택된 모든 키워드를 포함하는 카페 필터링
            "ORDER BY SUM(CASE WHEN ck.keyword IN :keywords THEN ck.frequency ELSE 0 END) DESC")
    List<Cafe> findByFiltersWithKeywordPriority(@Param("name") String name,
                                                @Param("wifi") Boolean wifi,
                                                @Param("petFriendly") Boolean petFriendly,
                                                @Param("takeout") Boolean takeout,
                                                @Param("groupFriendly") Boolean groupFriendly,
                                                @Param("parking") Boolean parking,
                                                @Param("easyPayment") Boolean easyPayment,
                                                @Param("delivery") Boolean delivery,
                                                @Param("keywords") List<String> keywords,
                                                @Param("keywordCount") long keywordCount);

}