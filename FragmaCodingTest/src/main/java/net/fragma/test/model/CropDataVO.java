/**
 * 
 */
package net.fragma.test.model;

/**
 * @author SreeLakshmi
 *
 */
public class CropDataVO {

	private String stateName;
	
	private String districtName;
	
	private int cropYear;
	
	private String crop;
	
	private String season;
	
	private float area;
	
	private float production;
	
	public CropDataVO() {
		// TODO Auto-generated constructor stub
	}

	public CropDataVO(String stateName, String districtName, int cropYear,
			 String season,String crop, float area, float production) {
		super();
		this.stateName = stateName;
		this.districtName = districtName;
		this.cropYear = cropYear;
		this.crop = crop;
		this.season = season;
		this.area = area;
		this.production = production;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public int getCropYear() {
		return cropYear;
	}

	public void setCropYear(int cropYear) {
		this.cropYear = cropYear;
	}

	public String getCrop() {
		return crop;
	}

	public void setCrop(String crop) {
		this.crop = crop;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public float getProduction() {
		return production;
	}

	public void setProduction(float production) {
		this.production = production;
	}

	@Override
	public String toString() {
		return "CropDataVO [stateName=" + stateName + ", districtName="
				+ districtName + ", cropYear=" + cropYear + ", crop=" + crop
				+ ", season=" + season + ", area=" + area + ", production="
				+ production + "]";
	}
	
	
}
