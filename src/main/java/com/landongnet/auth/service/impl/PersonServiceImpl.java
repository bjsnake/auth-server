package com.landongnet.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.landongnet.auth.mapper.PersonMapper;
import com.landongnet.auth.model.entity.Person;
import com.landongnet.auth.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author snake
 * @since 2023-08-17
 */
@Slf4j
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

}
