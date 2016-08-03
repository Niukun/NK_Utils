package business.com.fzhong.service.kg.dto.req;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于存储单例所有信息，包括名称及地址
 * @author Revan
 *
 */
public class DataReqDto {
	private EntityReqDto entity;
	private List<AddressReqDto> address;

	public DataReqDto(EntityReqDto entity) {
		super();
		this.entity = entity;
		this.address = new ArrayList<AddressReqDto>();
	}

	public EntityReqDto getEntity() {
		return entity;
	}

	public void setEntity(EntityReqDto entity) {
		this.entity = entity;
	}

	public List<AddressReqDto> getAddress() {
		return address;
	}

	public void setAddress(List<AddressReqDto> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "{" + entity + ", address=" + address + "}";
	}

}
