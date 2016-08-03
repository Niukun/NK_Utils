package business.com.fzhong.service.kg.dto.req;

import business.com.fzhong.service.kg.enums.DataSourceEnums;

/**
 * 用于存储企业信息
 * @author Revan
 *
 */
public class CompanyReqDto extends EntityReqDto {
	private String companyName; // 企业名
	private String companyID; // 企业id（ERP企业数据存，PC数据不存）
	private String industry; // 行业

	// constructors
	public CompanyReqDto() {
		super();
	}

	/**
	 * constructors with three parameters
	 * @param companyName
	 * @param dataSource
	 * @param sourceAddress
	 */
	public CompanyReqDto(String companyName, DataSourceEnums dataSource, String sourceAddress) {
		super();
		this.companyName = companyName;
		this.setDataSource(dataSource);
		this.setSourceAddress(sourceAddress);
	}
	/**
	 * constructors with four parameters that may be used when "new DataDto" 
	 * @param companyName
	 * @param dataSource
	 * @param sourceAddress
	 * @param industry
	 */
	public CompanyReqDto(String companyName, DataSourceEnums dataSource, String sourceAddress,String industry) {
		super();
		this.companyName = companyName;
		this.setDataSource(dataSource);
		this.setSourceAddress(sourceAddress);
		this.setIndustry(industry);
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	@Override
	public String toString() {
		return "companyName:" + this.getCompanyName() + ", dataSource:" + this.getDataSource().getName()
				+ ", sourceAddress:" + this.getSourceAddress() + ", " + this.mapToString(this.getOtherMaps());
	}
}
