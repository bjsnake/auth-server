package com.landongnet.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.landongnet.auth.mapper.EmpMapper;
import com.landongnet.auth.model.entity.Emp;
import com.landongnet.auth.service.IEmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author snake
 * @since 2023-08-17
 */
@Slf4j
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {

}
