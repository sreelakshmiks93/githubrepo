/**
 * 
 */
package net.fragma.test.assembler;

import java.util.List;

import net.fragma.test.model.CropDataVO;
import net.fragma.test.model.ResponseVO;

import org.springframework.stereotype.Component;

/**
 * @author SreeLakshmi
 *
 */
@Component
public class CropDataAssembler {

	public ResponseVO assemble(List<CropDataVO> cropDataVOs) {
		ResponseVO responseVO = new ResponseVO(200,"success" , cropDataVOs);
		return responseVO;
	}

}
