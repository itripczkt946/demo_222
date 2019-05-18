package com.dao;

import com.entity.GoodsDetail;
import com.entity.GoodsSort;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * 商品详情接口
 */
public interface GoodsDetailMapper {

    /**
     * 商品详情
     * @return
     */
    public List<GoodsDetail> findDetail(@Param("sortId") String sortId, @Param("startRow") int startRow, @Param("endRow")int endRow);


    /**
     * 查询分类
     * @return
     */
    public List<GoodsSort> findSort();


    /**
     * 根据编号查询商品详情
     * @param id
     * @return
     */
    public GoodsDetail getDetailById(int id);


    /**
     * 修改功能
     * @param goodsDetail
     * @return
     */
    public int updateDetail(GoodsDetail goodsDetail);


    /**
     * 总记录数
     * @return
     */
    public int getTotalCount(String sortId);


}
