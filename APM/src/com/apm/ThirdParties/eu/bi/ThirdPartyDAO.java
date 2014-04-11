package com.apm.ThirdParties.eu.bi;

import java.util.ArrayList;

import com.apm.ThirdParties.eu.entity.ThirdParty;
import com.apm.common.utils.Pagination;

public interface ThirdPartyDAO {

	ArrayList<ThirdParty> getThirdPartyList();

	int saveDetails(String type,ThirdParty thirdParty);

	

	int editDetails(String type, int id, ThirdParty thirdParty);

	int deleteDetail(int id);

	int saveType(ThirdParty thirdParty);

	ThirdParty getTypeDetail(int id);

	int updateType(int id, ThirdParty thirdParty);

	int deleteType(int id);

	ArrayList<ThirdParty> getThirdPartyDetailsList();

	int getThirdPartyCount(String type);

	ArrayList<ThirdParty> getThirdPartyDetailsList(String type,
			Pagination pagination);

	int getThirdPartyTypeCount();

	ArrayList<ThirdParty> getThirdPartyList(Pagination pagination);

	ArrayList<ThirdParty> getThirdPartyDetailsList(String type);

	
	
	

}
