package com.apm.TreatmentEpisode.eu.bi;

import java.util.ArrayList;

import com.apm.TreatmentEpisode.eu.entity.TreatmentEpisode;

public interface TreatmentEpisodeDAO {

	int saveTreatmentEpisode(TreatmentEpisode treatmentEpisode);

	ArrayList<TreatmentEpisode> getTreatmentEpisodeList(String clientId);

	TreatmentEpisode getTreatmentEpisodeDetails(String tratmentepisodeid);

	int updateConsultationLimit(String sessions, String treatmentepisodeid);

	TreatmentEpisode getParticularTreatEpiDetails(String id);

	ArrayList<TreatmentEpisode> getSourceOfReferralList();

	int updateTreatmentEpisode(TreatmentEpisode treatmentEpisode, int id);

	int deleteTreatmentEpisode(String id);

}
