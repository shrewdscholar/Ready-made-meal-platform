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


import com.dao.XizhuangdingzhiDao;
import com.entity.XizhuangdingzhiEntity;
import com.service.XizhuangdingzhiService;
import com.entity.vo.XizhuangdingzhiVO;
import com.entity.view.XizhuangdingzhiView;

@Service("xizhuangdingzhiService")
public class XizhuangdingzhiServiceImpl extends ServiceImpl<XizhuangdingzhiDao, XizhuangdingzhiEntity> implements XizhuangdingzhiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XizhuangdingzhiEntity> page = this.selectPage(
                new Query<XizhuangdingzhiEntity>(params).getPage(),
                new EntityWrapper<XizhuangdingzhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XizhuangdingzhiEntity> wrapper) {
		  Page<XizhuangdingzhiView> page =new Query<XizhuangdingzhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<XizhuangdingzhiVO> selectListVO(Wrapper<XizhuangdingzhiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XizhuangdingzhiVO selectVO(Wrapper<XizhuangdingzhiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XizhuangdingzhiView> selectListView(Wrapper<XizhuangdingzhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XizhuangdingzhiView selectView(Wrapper<XizhuangdingzhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
