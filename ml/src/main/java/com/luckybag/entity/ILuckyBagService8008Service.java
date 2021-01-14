package com.luckybag.entity;

import com.lgc.MessageDto;
import com.lgc.SqlConditionDto;

import java.util.List;

public interface ILuckyBagService8008Service
{
	    List <ThemeInfoDto> QueryThemeInfoByType(List <SqlConditionDto> ilist); 
	    List <RecordInfoDto> QueryLastRecordByUserId(List <SqlConditionDto> ilist); 
	    List <BagInfoDto> QueryBagInfoById(List <SqlConditionDto> ilist); 
	    List <SnatchInfoDto> QueryOpenLuckyBag(List <SqlConditionDto> ilist); 
	    List <ThemeTypeInfoDto> QueryThemeTypeInfoByCode(List <SqlConditionDto> ilist);
	    List <RecordInfoDto> QueryRecordFlowWaterInfo(List <SqlConditionDto> ilist); 
	    List <ResultInfoDto> QueryBusinessCultureTopic(List <SqlConditionDto> ilist); 
	    List <ResultInfoDto> QueryBlessingTopic(List <SqlConditionDto> ilist); 
	String SaveBag(List<MessageDto<List<String>, BagSendInfoDto>> ilist);
	String SaveMsgInfo(List<MessageDto<List<String>, MsgInfoDto>> ilist);
}

