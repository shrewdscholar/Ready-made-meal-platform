package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussxizhuangxinxiDao;
import com.entity.DiscussxizhuangxinxiEntity;
import com.service.DiscussxizhuangxinxiService;
import com.entity.vo.DiscussxizhuangxinxiVO;
import com.entity.view.DiscussxizhuangxinxiView;

@Service("discussxizhuangxinxiService")
public class DiscussxizhuangxinxiServiceImpl extends ServiceImpl<DiscussxizhuangxinxiDao, DiscussxizhuangxinxiEntity> implements DiscussxizhuangxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxizhuangxinxiEntity> page = this.selectPage(
                new Query<DiscussxizhuangxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussxizhuangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxizhuangxinxiEntity> wrapper) {
		  Page<DiscussxizhuangxinxiView> page =new Query<DiscussxizhuangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussxizhuangxinxiVO> selectListVO(Wrapper<DiscussxizhuangxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussxizhuangxinxiVO selectVO(Wrapper<DiscussxizhuangxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussxizhuangxinxiView> selectListView(Wrapper<DiscussxizhuangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussxizhuangxinxiView selectView(Wrapper<DiscussxizhuangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
