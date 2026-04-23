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


import com.dao.XizhuangfenleiDao;
import com.entity.XizhuangfenleiEntity;
import com.service.XizhuangfenleiService;
import com.entity.vo.XizhuangfenleiVO;
import com.entity.view.XizhuangfenleiView;

@Service("xizhuangfenleiService")
public class XizhuangfenleiServiceImpl extends ServiceImpl<XizhuangfenleiDao, XizhuangfenleiEntity> implements XizhuangfenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XizhuangfenleiEntity> page = this.selectPage(
                new Query<XizhuangfenleiEntity>(params).getPage(),
                new EntityWrapper<XizhuangfenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XizhuangfenleiEntity> wrapper) {
		  Page<XizhuangfenleiView> page =new Query<XizhuangfenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<XizhuangfenleiVO> selectListVO(Wrapper<XizhuangfenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XizhuangfenleiVO selectVO(Wrapper<XizhuangfenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XizhuangfenleiView> selectListView(Wrapper<XizhuangfenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XizhuangfenleiView selectView(Wrapper<XizhuangfenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
