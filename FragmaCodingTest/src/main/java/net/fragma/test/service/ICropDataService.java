/**
 * 
 */
package net.fragma.test.service;

import java.util.List;
import java.util.Map;

import net.fragma.test.model.CropDataVO;

/**
 * @author SreeLakshmi
 *
 */
public interface ICropDataService {

	List<CropDataVO> getAllCropData();

	List<CropDataVO> getAllCropDataFiltered(Map<String, Object> dataMap);
}
