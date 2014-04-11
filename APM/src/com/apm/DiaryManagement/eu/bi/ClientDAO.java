package com.apm.DiaryManagement.eu.bi;

import java.util.ArrayList;

import com.apm.DiaryManagement.eu.entity.Client;
import com.apm.common.utils.Pagination;

public interface ClientDAO {

	ArrayList<Client> getAllPatient();

	int savePatient(Client client);

	Client getPatient(int id);

	int updatePatient(Client client, int id);

	int deleteClient(int id, Client client);

	ArrayList<Client> getThirdPartyType();

	ArrayList<Client> getThirdPartyTypeName();

	ArrayList<Client> getThirdTypeNameList(int id);

	int updateThirdPartyDetails(Client client, String id);

	ArrayList<String> getOccupationList();

	ArrayList<String> getReferenceList();

	int insertOtherOccupation(Client client, String otherOccupation);

	int insertOtherReference(Client client, String otherReference);

	ArrayList<String> getInitialList();

	ArrayList<Client> getClient(String searchClient);

	ArrayList<String> getSourceOfIntroList();

	int getTotalClientCount();

	ArrayList<Client> getAllPatient(Pagination pagination);



	

}
