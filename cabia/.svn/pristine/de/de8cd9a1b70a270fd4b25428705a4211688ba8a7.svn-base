package business.com.fzhong.service.kg.preprocess.normalize;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import business.com.fzhong.service.kg.dto.req.AddressReqDto;
import business.com.fzhong.service.kg.dto.req.DataReqDto;

/**
 * 对来源地址进行信息抽取前的预处理
 * 删除不可能正确地址
 * 处理地址中的特殊字符（非中英文，数字）
 * 将来源地址处理为单地址形式
 * @author Revan
 *
 */
public class AddrPreprocessService {
	
	/**
	 * 预处理集合
	 * 按顺序对地址列表进行处理
	 * @param dataList 地址信息列表
	 */
	public void preprocess(List<DataReqDto> dataList){
		Iterator<DataReqDto> dataIter = dataList.iterator();
		while(dataIter.hasNext()){
			DataReqDto data = dataIter.next();
			//若为通过源地址筛选，将地址信息实体从列表中删除
			if(filterSourceAddressByLength(data)){
				List<AddressReqDto> addressList = data.getAddress();
				//移除备注信息
				removeComment(addressList);
				//规范化有用符号
				formatUsefulChar(addressList);
				//删除无用符号
				removeUnusefulChar(addressList);
				//拆分多地址
				splitMultiAddress(addressList);
			}else{
				dataIter.remove();
			}
		}
	}
	
	/**
	 * 通过长度筛选源地址
	 * 地址长度不大于ADDRESS_MIN_LENGTH的地址肯定为不正确地址
	 * 通过筛选的源地址为其添加地址列表
	 * @param data 单例地址信息实体
	 * @return 是否通过筛选
	 */
	private boolean filterSourceAddressByLength(DataReqDto data){
		String sourceAddress = data.getEntity().getSourceAddress();
		if(sourceAddress.length() <= NormalizeService.ADDRESS_MIN_LENGTH){
			return false;
		}else{
			data.getAddress().add(new AddressReqDto(sourceAddress));
			return true;
		}
	}
	
	/**
	 * 消除各种备注信息
	 * @param addressList 地址信息列表
	 */
	private void removeComment(List<AddressReqDto> addressList){
		//消除中英文小括号
		removeBracket(addressList, "\\(（", "\\)）");
		//消除英文中括号
		removeBracket(addressList, "\\[", "\\]");
	}

	/**
	 * 规范化有用符号
	 * @param addressList 地址信息列表
	 */
	private void formatUsefulChar(List<AddressReqDto> addressList){
		//替换特殊数字
		replaceSpecialNumber(addressList);
		//替换连接符
		replaceConnector(addressList);
		//替换多地址分隔符
		replaceMultipleAddressSplitChar(addressList);
	}
	
	/**
	 * 消除无用符号
	 * @param addressList 地址信息列表
	 */
	private void removeUnusefulChar(List<AddressReqDto> addressList){
		//消除空格
		removeSpace(addressList);
		//消除地址末尾无用符号
		removeLastChar(addressList);
		//消除其它无用符号
		removeUnuseChar(addressList);
	}

	/**
	 * 拆分多地址为单地址
	 * @param addressList 地址信息列表
	 */
	private void splitMultiAddress(List<AddressReqDto> addressList){
		//拆分非相邻多地址,如上海市卢湾区斜土路501弄11号，斜土路435弄1号
		splitNotNearbyAddresss(addressList);
		//拆分相邻多地址,如上海市徐汇区梅陇路10号,11号,123号
		splitNearbyAddress(addressList);
	}
	
	/**
	 * 消除备注内容，将备注作为地址添加到地址信息列表中
	 * @param addressList 地址信息列表
	 * @param frontChars 备注的前半部字符
	 * @param latterChars 备注的后半部字符
	 */
	private void removeBracket(List<AddressReqDto> addressList, String frontChars, String latterChars){
		int listSize = addressList.size();
		for(int i = 0; i < listSize; i++){
			String addr = addressList.get(i).getAddress();
			if(addr.matches(".*[" + frontChars + latterChars + "].*")){
				Pattern pattern = Pattern.compile("(.*)[" + frontChars + "]([^" + frontChars + latterChars + "]*)[" + latterChars + "](.*)");
				Matcher matcher = pattern.matcher(addr);
				while(matcher.find()){
					addressList.add(new AddressReqDto(matcher.group(2)));
					addr = matcher.group(1)+matcher.group(3);
					matcher = pattern.matcher(addr);
				}
				addressList.get(i).setAddress(addr);
			}
		}
	}

	/**
	 * 替换特殊数字
	 * 特殊数字utf8编码为\uff10-\uff19
	 * @param addressList 地址信息列表
	 */
	private void replaceSpecialNumber(List<AddressReqDto> addressList){
		Iterator<AddressReqDto> addressIter = addressList.iterator();
		Pattern pattern = Pattern.compile("[\\uff10-\\uff19]");
		Matcher matcher;
		while(addressIter.hasNext()){
			AddressReqDto addr = addressIter.next();
			matcher = pattern.matcher(addr.getAddress());
			if(matcher.find()){
				String newAdd = addr.getAddress();
				newAdd = newAdd.replaceAll("\\uff10", String.valueOf(0));
				newAdd = newAdd.replaceAll("\\uff11", String.valueOf(1));
				newAdd = newAdd.replaceAll("\\uff12", String.valueOf(2));
				newAdd = newAdd.replaceAll("\\uff13", String.valueOf(3));
				newAdd = newAdd.replaceAll("\\uff14", String.valueOf(4));
				newAdd = newAdd.replaceAll("\\uff15", String.valueOf(5));
				newAdd = newAdd.replaceAll("\\uff16", String.valueOf(6));
				newAdd = newAdd.replaceAll("\\uff17", String.valueOf(7));
				newAdd = newAdd.replaceAll("\\uff18", String.valueOf(8));
				newAdd = newAdd.replaceAll("\\uff19", String.valueOf(9));
				addr.setAddress(newAdd);
			}
		}
	}

	/**
	 * 规范化连接符（-－—~等）
	 * 都替换为~
	 * @param addressList 地址信息列表
	 */
	private void replaceConnector(List<AddressReqDto> addressList){
		Iterator<AddressReqDto> addressIter = addressList.iterator();
		String toCharSet = NormalizeService.TO_CHAR_SET;
		Pattern pattern = Pattern.compile("[" + toCharSet + "]");
		Matcher matcher;
		while(addressIter.hasNext()){
			AddressReqDto addr = addressIter.next();
			matcher = pattern.matcher(addr.getAddress());
			if(matcher.find()){
				String newAdd = addr.getAddress();
				for(int i = 1; i < toCharSet.length(); i++){
					newAdd = newAdd.replaceAll(toCharSet.substring(i, i + 1), toCharSet.substring(0, 1));
				}
				newAdd = newAdd.replaceAll("~+", "~");
				//此处需要更新,卢湾区打浦路398弄4号-2临
				newAdd = newAdd.replaceAll("[\\u4e00-\\u9fa5]+~", "~");
				addr.setAddress(newAdd);
			}
		}
	}

	/**
	 * 统一多地址分隔符
	 * 多地址分割符统一为","
	 * @param addressList 地址信息列表
	 */
	private void replaceMultipleAddressSplitChar(List<AddressReqDto> addressList){
		Iterator<AddressReqDto> addressIter = addressList.iterator();
		String splitCharSet = NormalizeService.SPLIT_CHAR_SET;
		Pattern pattern = Pattern.compile("[" + splitCharSet + "]");
		Matcher matcher;
		while (addressIter.hasNext()) {
			AddressReqDto addr = addressIter.next();
			matcher = pattern.matcher(addr.getAddress());
			if (matcher.find()) {
				String newAdd = addr.getAddress();
				for(int i = 1; i < splitCharSet.length(); i++){
					String splitChar = splitCharSet.substring(i, i + 1);
					if(".".equals(splitChar)){
						newAdd = newAdd.replaceAll("\\.", splitCharSet.substring(0, 1));
					}else{
						newAdd = newAdd.replaceAll(splitChar, splitCharSet.substring(0, 1));
					}
				}
				newAdd = newAdd.replaceAll(",+", ",");
				addr.setAddress(newAdd);
			}
		}
	}

	/**
	 * 消除空格符
	 * 若空格两端为数字，将其替换为","
	 * 否则消除空格
	 * @param addressList 地址信息列表
	 */
	private void removeSpace(List<AddressReqDto> addressList){
		Iterator<AddressReqDto> addressIter = addressList.iterator();
		Pattern pattern = Pattern.compile("\\d( +)\\d");
		Matcher matcher;
		while(addressIter.hasNext()){
			AddressReqDto addr = addressIter.next();
			matcher = pattern.matcher(addr.getAddress());
			while(matcher.find()){
				String newAdd = addr.getAddress();
				newAdd = newAdd.substring(0, matcher.start(1))+","+newAdd.substring(matcher.end(1));
				addr.setAddress(newAdd);
			}
			addr.setAddress(addr.getAddress().replaceAll(" ", ""));
		}
	}

	/**
	 * 消除最后的非中文、英文、数字字符
	 * 最后的字符如果不是中文、英文、数字，必定为无用字符
	 * @param addressList 地址信息列表
	 */
	private void removeLastChar(List<AddressReqDto> addressList){
		Iterator<AddressReqDto> addressIter = addressList.iterator();
		Pattern pattern = Pattern.compile("([^0-9a-zA-Z\\u4e00-\\u9fa5]*)$");
		Matcher matcher;
		while(addressIter.hasNext()){
			AddressReqDto addr = addressIter.next();
			matcher = pattern.matcher(addr.getAddress());
			while(matcher.find()){
				addr.setAddress(addr.getAddress().substring(0, addr.getAddress().length()-matcher.group(1).length()));
			}
		}
	}
	
	/**
	 * 消除其它无用符号
	 * @param addressList 地址信息列表
	 */
	private void removeUnuseChar(List<AddressReqDto> addressList){
		Iterator<AddressReqDto> addressIter = addressList.iterator();
		Pattern pattern = Pattern.compile("(.*)[^" + NormalizeService.USEFUL_CHAR + "](.*)");
		Matcher matcher;
		while(addressIter.hasNext()){
			AddressReqDto addr = addressIter.next();
			matcher = pattern.matcher(addr.getAddress());
			while(matcher.find()){
				addr.setAddress(matcher.group(1) + matcher.group(2));
				matcher = pattern.matcher(addr.getAddress());
			}
		}
	}

	/**
	 * 拆分非相邻多地址
	 * 如上海市卢湾区斜土路501弄11号，斜土路435弄1号
	 * @param addressList 地址信息列表
	 */
	private void splitNotNearbyAddresss(List<AddressReqDto> addressList){
		//若分隔符左右都是非数字，则认为此地址为非相邻多地址
		Pattern pattern = Pattern.compile("(.+?[^0-9]),([^0-9].+)");
		Matcher matcher;
		int listSize = addressList.size();
		for(int i = 0; i < listSize; i++){
			String addr = addressList.get(i).getAddress();
			matcher = pattern.matcher(addr);
			//循环判断，使可以处理多非相邻多地址，如（斜土路501弄，斜土路435弄，斜土路423弄）
			while (matcher.find()) {
				addressList.add(new AddressReqDto(matcher.group(1)));
				addr = matcher.group(2);
				matcher = pattern.matcher(addr);
			}
			addressList.get(i).setAddress(addr);
		}
	}
	
	/**
	 * 拆分相邻多地址
	 * 如上海市徐汇区梅陇路10号,11号,123号
	 * 如上海市徐汇区梅陇路134,131号
	 * @param addressList 地址信息列表
	 */
	private void splitNearbyAddress(List<AddressReqDto> addressList){
		Pattern pattern = Pattern.compile(",");
		Matcher matcher;
		int listSize = addressList.size();
		for(int i = 0; i < listSize; i++){
			String addr = addressList.get(i).getAddress();
			matcher = pattern.matcher(addr);
			//按","分割原地址，并进行地址补全
			if(matcher.find()){
				String newAddrs[] = addr.split(",");
				completeAddrs(newAddrs);
				addressList.get(i).setAddress(newAddrs[0]);
				for(int j = 1; j < newAddrs.length; j++){
					addressList.add(new AddressReqDto(newAddrs[j]));
				}
			}
		}
	}
	
	/**
	 * 根据分割后String数组补全地址，并生成Address
	 * @param newAddrs 原地址分割后的String数组
	 */
	private void completeAddrs(String [] newAddrs){
		if(newAddrs != null){
			String numSuffix = NormalizeService.NUM_SUFFIX;
			//用于抽取地址的公共信息，如（上海市徐汇区梅陇路10号,11号,123号）中（上海市徐汇区梅陇路）
			Pattern patternCommon = Pattern.compile("(.+[\\u4e00-\\u9fa5])[0-9~]+([" + numSuffix + "])?$");
			//用于抽取地址中的单位信息，如（上海市徐汇区梅陇路10号,11号,123号）中（号）
			Pattern patternUnit = Pattern.compile("\\d([" + numSuffix + "]+)");
			//用于判断是否存在单位信息
			Pattern patternAddr = Pattern.compile("\\d$");
			Matcher matcherUnit = patternUnit.matcher(newAddrs[newAddrs.length-1]);
			Matcher matcherCommon = patternCommon.matcher(newAddrs[0]);
			//补充公共信息
			if(matcherCommon.find()){
				for(int i = 1; i < newAddrs.length; i++){
					newAddrs[i] = matcherCommon.group(1) + newAddrs[i];
				}
			}
			//补充单位信息
			if(matcherUnit.find()){
				for(int i = 0; i < newAddrs.length-1; i++){
					Matcher matcherAddr = patternAddr.matcher(newAddrs[i]);
					if(matcherAddr.find()){
						newAddrs[i] = newAddrs[i] + matcherUnit.group(1);
					}
				}
			}
		}
	}

}
