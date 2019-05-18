package com.service;

import com.dao.GoodsDetailMapper;
import com.entity.GoodsDetail;
import com.entity.GoodsSort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品详情业务逻辑
 */
@Service("goodsDetailService")
public class GoodsDetailServiceImpl implements GoodsDetailService {


    @Resource(name = "goodsDetailMapper")
    private GoodsDetailMapper goodsDetailMapper;


    @Override
    public List<GoodsDetail> findDetail(String sortId, int startRow, int endRow) {
        return goodsDetailMapper.findDetail(sortId,startRow,endRow);
    }

    @Override
    public List<GoodsSort> findSort() {
        return goodsDetailMapper.findSort();
    }

    @Override
    public GoodsDetail getDetailById(int id) {
        return goodsDetailMapper.getDetailById(id);
    }

    @Override
    public int updateDetail(GoodsDetail goodsDetail) {
        return goodsDetailMapper.updateDetail(goodsDetail);
    }

    @Override
    public int getTotalCount(String sortId) {
        return goodsDetailMapper.getTotalCount(sortId);
    }
}
