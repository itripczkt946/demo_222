package com.controller;

import com.entity.GoodsDetail;
import com.entity.GoodsSort;
import com.service.GoodsDetailService;
import com.util.PageTool;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/goodsdetail")
public class GoodsDetailController {

    @Resource(name = "goodsDetailService")
    private GoodsDetailService goodsDetailService;

    @RequestMapping("/findAll")
    public String findAll(String sortId, int pageNo, Model model){
        System.out.println("添加数据");
        PageTool<GoodsDetail> pageTool = new PageTool<GoodsDetail>();
        pageTool.setCurrentPageNo(pageNo);
        pageTool.setTotalCount(goodsDetailService.getTotalCount(sortId));
        pageTool.setList(goodsDetailService.findDetail(sortId,(pageNo -1) * pageTool.getPageSize(), pageTool.getPageSize()));
        List<GoodsSort> goodsSortsList =  goodsDetailService.findSort();

        model.addAttribute("pageTool",pageTool);
        model.addAttribute("goodsSortsList",goodsSortsList);
        return "index";
    }

    /**
     * 详情
     * @return
     */
    @RequestMapping("/toDetailPage")
    public String toDetailPage(int id,Model model){
        GoodsDetail detail =  goodsDetailService.getDetailById(id);
        model.addAttribute("detail",detail);
        return "detail";
    }

    /**
     * 修改操作
     * @return
     */
    @RequestMapping("/doUpdate")
    public String doUpdate(GoodsDetail goodsDetail){
        int result =  goodsDetailService.updateDetail(goodsDetail);
        if (result > 0) {
            return "redirect:findAll?pageNo=1";
        }else{
            return "detail";
        }
    }


}
