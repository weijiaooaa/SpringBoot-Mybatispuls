package com.springboot.mybatisplus.mapper;

import com.springboot.mybatisplus.entity.TbUser;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.MyMapper;

public interface TbUserMapper extends MyMapper<TbUser> {
}