package com.iu2java.controller;

import com.iu2java.pojo.DormRepair;
import com.iu2java.pojo.PageInfo;
import com.iu2java.service.DormRepairService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
//@Slf4j
public class DormRepairController {
    // 依赖注入
    @Autowired
    private DormRepairService dormRepairService;

    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findDormRepair")
    public String findDormRepair(Integer d_id,Integer pageIndex, Integer pageSize, Model model) {

        System.out.println("这里的d_id:" + d_id);
        PageInfo<DormRepair> di = dormRepairService.findPageInfo(d_id, pageIndex,pageSize);
        model.addAttribute("di",di);
        return "dormrepair_list";
    }

    /**
     * 显示当前登录的学生的宿舍报修信息
     * @return
     */
    @RequestMapping(value = "/findDormRepair2")
    public String userDormRepair(@RequestParam("s_dormitoryid")Integer s_dormitoryid, Integer pageIndex, Integer pageSize, Model model){

        System.out.println("此时登录的学生id:"+s_dormitoryid);
        PageInfo<DormRepair> di2 = dormRepairService.findPageInfo(s_dormitoryid, pageIndex, pageSize);
        model.addAttribute("di2",di2);
        return "dormrepair_list_dorm";
//        return "redirect:dormrepair_list_dorm";
    }

    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportdormrepairlist", method = RequestMethod.POST)
    @ResponseBody
    public List<DormRepair> exportDormrepair(){
        List<DormRepair> dormRepairList = dormRepairService.getAll();
        return dormRepairList;
    }


    /**
     * 添加宿舍信息
     */
    @RequestMapping(value = "/addDormRepair" ,method = RequestMethod.POST)
    @ResponseBody
    public String addDormitory( @RequestBody DormRepair dormrepair) {
        int d = dormRepairService.insert(dormrepair);
        return "dormrepair_list";
    }

    @RequestMapping(value = "/addDormRepair2" ,method = RequestMethod.POST)
    @ResponseBody
    public String addDormitory2( @RequestBody DormRepair dormrepair) {
        int d = dormRepairService.insert(dormrepair);
        return "dormrepair_list_dorm";
    }

    /**
     * 删除宿舍信息
     */
    @RequestMapping( "/deleteDormRepair")
    @ResponseBody
    public String deleteDormRepair(Integer r_id) {
        int d = dormRepairService.deleteByPrimaryKey(r_id);
        return "dormrepair_list";
    }

    @RequestMapping( "/deleteDormRepair2")
    @ResponseBody
    public String deleteDormRepair2(Integer r_id) {
        int d = dormRepairService.deleteByPrimaryKey(r_id);
        return "dormrepair_list_dorm";
    }

    /**
     * 修改学生信息
     */
    @RequestMapping( "/updateDormRepair")
    public String updateDormRepair( DormRepair dormrepair) {
        int d = dormRepairService.updateByPrimaryKey(dormrepair);
        return "redirect:/findDormRepair";
    }

    @RequestMapping( "/updateDormRepair2")
    public String updateDormRepair2( DormRepair dormrepair) {
        int d = dormRepairService.updateByPrimaryKey(dormrepair);
        return "redirect:/findDormRepair2?s_dormitoryid="+dormrepair.getD_id();
    }


    @RequestMapping( "/findDormRepairById")
    public String findDormRepairById(Integer r_id, HttpSession session) {

        DormRepair d= dormRepairService.selectByPrimaryKey(r_id);
        session.setAttribute("d",d);
        return "dormrepair_edit";
    }

    @RequestMapping( "/findDormRepairById2")
    public String findDormRepairById2(Integer r_id, HttpSession session) {

        DormRepair d= dormRepairService.selectByPrimaryKey(r_id);
        session.setAttribute("d",d);
        return "dormrepair_edit_dorm";
    }

}

