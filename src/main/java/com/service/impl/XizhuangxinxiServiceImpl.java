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


import com.dao.XizhuangxinxiDao;
import com.entity.XizhuangxinxiEntity;
import com.service.XizhuangxinxiService;
import com.entity.vo.XizhuangxinxiVO;
import com.entity.view.XizhuangxinxiView;

@Service("xizhuangxinxiService")
public class XizhuangxinxiServiceImpl extends ServiceImpl<XizhuangxinxiDao, XizhuangxinxiEntity> implements XizhuangxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XizhuangxinxiEntity> page = this.selectPage(
                new Query<XizhuangxinxiEntity>(params).getPage(),
                new EntityWrapper<XizhuangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XizhuangxinxiEntity> wrapper) {
		  Page<XizhuangxinxiView> page =new Query<XizhuangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<XizhuangxinxiVO> selectListVO(Wrapper<XizhuangxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XizhuangxinxiVO selectVO(Wrapper<XizhuangxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XizhuangxinxiView> selectListView(Wrapper<XizhuangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XizhuangxinxiView selectView(Wrapper<XizhuangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
