package com.cognizant.dailyshareprice.repository;

import com.cognizant.dailyshareprice.model.ShareDetails;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareDetailRepository extends JpaRepository<ShareDetails, Long> {
    ShareDetails findByShareName(String shareName);

    @Query("SELECT s FROM ShareDetails s WHERE s.shareId IN (:shareID) order by s.shareId")
    List<ShareDetails> findByShareId(@Param("shareID") List<String> shareID);
}
