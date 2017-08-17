package net.fragma.test.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.fragma.test.assembler.CropDataAssembler;
import net.fragma.test.model.CropDataVO;
import net.fragma.test.model.ResponseVO;
import net.fragma.test.service.CropDataService;
import net.fragma.test.service.ICropDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FragmaController {

	@Autowired
	ICropDataService CropDataService;
	
	@Autowired
	CropDataAssembler cropDataAssembler;
	 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String dashboard(ModelMap model) {

		return "index";

	}

	@RequestMapping(value = "/cropData", method = RequestMethod.GET)
	@ResponseBody
	public Object getAllCropData(@RequestParam(required = false) Map<String,Object> dataMap){
		List<CropDataVO> cropDataVOs = new ArrayList<CropDataVO>();
		if(dataMap.isEmpty()){
			 cropDataVOs = CropDataService.getAllCropData();
		}else{
			cropDataVOs = CropDataService.getAllCropDataFiltered(dataMap);
		}
		ResponseVO responseVO = cropDataAssembler.assemble(cropDataVOs);
		return responseVO;
	}
	
	 
}
