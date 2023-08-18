package com.landongnet.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.landongnet.auth.mapper.EmpOrgMapper;
import com.landongnet.auth.model.entity.EmpOrg;
import com.landongnet.auth.service.IEmpOrgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author snake
 * @since 2023-08-17
 */
@Slf4j
@Service
public class EmpOrgServiceImpl extends ServiceImpl<EmpOrgMapper, EmpOrg> implements IEmpOrgService {

}
