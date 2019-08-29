package com.liang.spring.boot.child.repository;

import com.liang.spring.boot.child.domain.PeopleKey;
import com.liang.spring.boot.child.domain.SystemImgUpload;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: liliang
 * @Description:
 * @Date: Create in 15:23 2019/6/21
 */
public interface SystemImgUploadRepository extends JpaRepository<SystemImgUpload, PeopleKey> {
}
