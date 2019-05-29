package com.liang.spring.boot.child.repository;

import com.liang.spring.boot.child.domain.Information;
import com.liang.spring.boot.child.domain.PastMedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * 主诉与症状    仓库.
 *
 * @since 1.0.0 2017年3月2日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface PastMedicalHistoryRepository extends JpaRepository<PastMedicalHistory, Long> {
}
