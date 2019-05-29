package com.liang.spring.boot.child.repository;

import com.liang.spring.boot.child.domain.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 基本信息 仓库.
 *
 * @since 1.0.0 2017年3月2日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface InformationRepository extends JpaSpecificationExecutor<Information>,JpaRepository<Information, Long>{

}
