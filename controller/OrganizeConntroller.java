package com.example.demomvc.controller;


import com.example.demomvc.entity.OrganizeEntity;
import com.example.demomvc.service.OrganizeService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.Console;
import java.util.List;

@Controller
public class OrganizeConntroller {
    @Autowired
    private OrganizeService organizeService;


    @RequestMapping(value = "/organize")
    public String organizeAll(ModelMap model){
        List<OrganizeEntity> data = organizeService.findAll();
        model.addAttribute("organize" ,data);
        if(data.isEmpty()){
            return "redirect:/createForm";
        }
        return "Organize/organize";
    }
    @RequestMapping(value = "/createForm")
    public String createForm(ModelMap model){

        return "Organize/createOrganize";
    }

    @RequestMapping(value = "/createOrganize",method = RequestMethod.POST)
    public String createOrg(HttpServletRequest request){
        OrganizeEntity organizeEntity = new OrganizeEntity();
        organizeEntity.setOrgName(request.getParameter("orgName"));
        organizeEntity.setAddress(request.getParameter("address"));
        organizeEntity.setTel(request.getParameter("tel"));
        organizeService.createOrganize(organizeEntity);
        return "redirect:/organize";
    }

    @RequestMapping(value = "/deleteOrg/{id}")
    public String deleteOrg(@PathVariable int id){
        if(organizeService.findAll().size() == 1){
            return "redirect:/organize";
        }
        organizeService.deleteOrg(id);
        return "redirect:/organize";
    }

    @RequestMapping(value = "/editForm/{id}")
    public  String editForm(@PathVariable int id,ModelMap model){
        model.addAttribute("organize",organizeService.getOne(id));
        return "Organize/editForm";
    }

    @RequestMapping(value = "/editForm/updateOrg",method = RequestMethod.POST)
    public String updateOrg(HttpServletRequest request){
        OrganizeEntity data = new OrganizeEntity();
        data.setOrgName(request.getParameter("orgName"));
        data.setAddress(request.getParameter("address"));
        data.setTel(request.getParameter("tel"));
        data.setOrgId(Integer.parseInt(request.getParameter("orgId")));
        organizeService.update(data);
        return "redirect:/organize";
    }
    @RequestMapping(value = "/editForm/cancelEdit")
    public String cancelEdit(ModelMap model){
        return "redirect:/organize";
    }
}
