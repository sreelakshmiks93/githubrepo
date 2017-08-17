/**
 * 
 */
package net.fragma.test.service;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;

import net.fragma.test.model.CropDataVO;

/**
 * @author SreeLakshmi
 *
 */

@Service
public class CropDataService implements ICropDataService {
	public List<CropDataVO> getAllCropData() {
		String cvsSplitBy = ",";
		List<CropDataVO> cropDataVOs = new ArrayList<CropDataVO>();
		InputStream is = CropDataService.class.getResourceAsStream("/apy.csv");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		String line;
		try {
			reader.readLine();
			while ((line = reader.readLine()) != null) {

				// use comma as separator
				String[] cropData = line.split(cvsSplitBy);

				CropDataVO cropDataVO = new CropDataVO();
				cropDataVO.setStateName(cropData[0].trim());
				cropDataVO.setDistrictName(cropData[1].trim());
				cropDataVO.setCropYear(Integer.parseInt(cropData[2].trim()));
				cropDataVO.setCrop(cropData[4].trim());
				cropDataVO.setSeason(cropData[3].trim());
				if (!(("").equals(cropData[5].trim())))
					cropDataVO.setArea(Float.parseFloat(cropData[5].trim()));
				try {
					if (!(("").equals(cropData[6].trim()) || (cropData[6]
							.trim().equals(null))))
						cropDataVO.setProduction(Float.parseFloat(cropData[6]
								.trim()));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				cropDataVOs.add(cropDataVO);
			}
		} catch (FileNotFoundException e) {
			CropDataVO cropDataVO = new CropDataVO();
			cropDataVO.setSeason("dddd");
			cropDataVOs.add(cropDataVO);
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			CropDataVO cropDataVO = new CropDataVO();
			cropDataVO.setSeason("finally");
			cropDataVOs.add(cropDataVO);
		}

		return cropDataVOs;

	}

	@Override
	public List<CropDataVO> getAllCropDataFiltered(Map<String, Object> dataMap) {
		List<CropDataVO> cropDataVOs = getAllCropData();

		List<CropDataVO> filteredCropDataVOs = new ArrayList<CropDataVO>();
		for (CropDataVO cropDataVO : cropDataVOs) {
			try{
			boolean match = true;
			if (dataMap.containsKey("state")) {
				if (!dataMap.get("state").toString()
						.equalsIgnoreCase(cropDataVO.getStateName())) {
				continue;
				}
			}
			if (dataMap.containsKey("district")) {
				if (!dataMap.get("district").toString()
						.equalsIgnoreCase(cropDataVO.getDistrictName())) {
					continue;
				}
			}
			if (dataMap.containsKey("season")) {
				if (!dataMap.get("season").toString()
						.equalsIgnoreCase(cropDataVO.getSeason())) {
					continue;
				}
			}
			if (dataMap.containsKey("crop")) {
				if (!dataMap.get("crop").toString()
						.equalsIgnoreCase(cropDataVO.getCrop())) {
					continue;
				}
			}
			if (dataMap.containsKey("crop_year")) {
				if (!(Integer.parseInt(dataMap.get("crop_year").toString())
						 ==(cropDataVO.getCropYear()))) {
					continue;
				}
			}
			if (dataMap.containsKey("crop_year")) {
				if (!(Integer.parseInt(dataMap.get("crop_year").toString())
						 ==(cropDataVO.getCropYear()))) {
					continue;
				}
			}
			if (dataMap.containsKey("production")) {
				if (!(Float.parseFloat(dataMap.get("production").toString())
						 ==(cropDataVO.getProduction()))) {
					continue;
				}
			}
			if (dataMap.containsKey("production_min")) {
				if (!(Float.parseFloat(dataMap.get("production_min").toString())
						 <=(cropDataVO.getProduction()))) {
					continue;
				}
			}
			if (dataMap.containsKey("production_max")) {
				if (!(Float.parseFloat(dataMap.get("production_max").toString())
						 >=(cropDataVO.getProduction()))) {
					continue;
				}
			}
			if (dataMap.containsKey("area")) {
				if (!(Float.parseFloat(dataMap.get("area").toString())
						 ==(cropDataVO.getArea()))) {
					continue;
				}
			}
			if (dataMap.containsKey("area_min")) {
				if (!(Float.parseFloat(dataMap.get("area_min").toString())
						 <=(cropDataVO.getArea()))) {
					continue;
				}
			}
			if (dataMap.containsKey("area_max")) {
				if (!(Float.parseFloat(dataMap.get("area_max").toString())
						 >=(cropDataVO.getArea()))) {
					continue;
				}
			}
			if (dataMap.containsKey("start_year")) {
				if (!(Integer.parseInt(dataMap.get("start_year").toString())
						 <=(cropDataVO.getCropYear()))) {
					continue;
				}
			}
			if (dataMap.containsKey("end_year")) {
				if (!(Integer.parseInt(dataMap.get("end_year").toString())
						 >=(cropDataVO.getCropYear()))) {
					continue;
				}
			}
			if (match) {
				filteredCropDataVOs.add(cropDataVO);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		}
		return filteredCropDataVOs;
	}

}
