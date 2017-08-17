package com.mkyong.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import net.fragma.test.model.CropDataVO;

public class CSVReader {

    public static void main(String[] args) {

       String csvFile = "src/main/resources/apy.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            br.readLine();
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                
            	CropDataVO cropDataVO = new CropDataVO();
            	 // use comma as separator
                String[] cropData = line.split(cvsSplitBy);
                
            	cropDataVO.setStateName(cropData[0]);
            	cropDataVO.setDistrictName(cropData[1]);
                cropDataVO.setCropYear(Integer.parseInt(cropData[2]));  
            	cropDataVO.setCrop(cropData[4]);
            	cropDataVO.setSeason(cropData[3]);
            	if(!(("").equals(cropData[5])))
             	 cropDataVO.setArea( Float.parseFloat(cropData[5]));
            	try{
            	if(!(("").equals(cropData[6].trim()) || (cropData[6].trim().equals(null))) )
	            	  cropDataVO.setProduction( Float.parseFloat(cropData[6]));
            	}catch(Exception e){
            		System.out.println(e.getMessage());
            	}
            	System.out.println(cropDataVO);
            	// System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}