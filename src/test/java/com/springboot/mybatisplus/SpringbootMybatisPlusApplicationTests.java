package com.springboot.mybatisplus;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mybatisplus.entity.TbItem;
import com.springboot.mybatisplus.entity.TbUser;
import com.springboot.mybatisplus.mapper.TbItemMapper;
import com.springboot.mybatisplus.mapper.TbUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisPlusApplication.class)
@Transactional
@Rollback
public class SpringbootMybatisPlusApplicationTests {

    @Autowired
    private TbUserMapper tbUserMapper;
    @Autowired
    private TbItemMapper tbItemMapper;
    private TbUser tbUser;

    /**
     * 测试查询集合
     */
    @Test
    public void testSelect() {
        List<TbUser> tbUsers = tbUserMapper.selectAll();
        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }

    /**
    * 测试查询总条数
    * */
    @Test
    public void testCount(){
        int counts = tbUserMapper.selectCount(tbUser);
        System.out.println(counts);
    }

    /**
     * 测试分页查询
     */
    @Test
    public void testPage() {
        // PageHelper 使用非常简单，只需要设置页码和每页显示条数即可
        PageHelper.startPage(1, 10);

        // 设置分页查询条件
        Example example = new Example(TbItem.class);
        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItemMapper.selectByExample(example));

        // 获取查询结果
        List<TbItem> tbItems = pageInfo.getList();
        for (TbItem tbItem : tbItems) {
            System.out.println(tbItem.getTitle());
        }
    }
}
