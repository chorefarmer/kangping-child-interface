package com.liang.spring.boot.child.repository;

import com.liang.spring.boot.child.domain.FilePath;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by: elvis(李亮)
 * 2019-04-18 10:17
 * Version: 1.0
 */
public interface FilePathRepository extends JpaRepository<FilePath,Integer> {

}
