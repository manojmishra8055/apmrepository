package com.apm.Master.eu.bi;

import java.util.ArrayList;

import com.apm.Master.eu.entity.Master;
import com.apm.common.utils.Pagination;

public interface MasterDAO {

	ArrayList<Master> getOccupationList(Pagination pagination);

	int getTotalOccupationCount();

	int saveOccupation(Master master);

	Master getOccupation(int id, Master master);

	int updateOccupation(Master master, int id);

	int deleteOccupation(int id, Master master);

	int getTotalJobTitleCount();

	ArrayList<Master> getJobTitleList(Pagination pagination);

	int saveJobTitle(Master master);

	Master getJobTitle(int id, Master master);

	int updateJobTitle(Master master, int id);

	int deleteJobTitle(int id, Master master);

	int getTotalReferenceCount();

	ArrayList<Master> getReferenceList(Pagination pagination);

	int saveReference(Master master);

	Master getReference(int id, Master master);

	int updateReference(Master master, int id);

	int deleteReference(int id, Master master);


}
