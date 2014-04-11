package com.apm.TreatmentEpisode.web.form;

import java.util.ArrayList;

import com.apm.DiaryManagement.eu.entity.DiaryManagement;
import com.apm.TreatmentEpisode.eu.entity.TreatmentEpisode;

public class TreatmentEpisodeForm {
	
	private int id;
	
	private int clientId;
	
	private String clientName;
	
	private String diaryUser;
	
	private String treatmentStartDate;
	
	private String treatmentEpisodeName;
	
	private String referalDate;
	
	private String referralName;
	
	private String referralSource;
	
	private String referralContact;
	
	private String referralLetter;
	
	private String payby;
	
	private String spendLimit;
	
	private String consultationLimit;
	
	private String dischargeLetter;
	
	private String authorisationCode;
	
	private String invoicee;
	
	private ArrayList<DiaryManagement>userList;
	
	private ArrayList<TreatmentEpisode>treatmentEpisodeList;
	private String client;
	
	private ArrayList<TreatmentEpisode> sourceOfReferralList;

	public ArrayList<TreatmentEpisode> getSourceOfReferralList() {
		return sourceOfReferralList;
	}

	public void setSourceOfReferralList(
			ArrayList<TreatmentEpisode> sourceOfReferralList) {
		this.sourceOfReferralList = sourceOfReferralList;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public ArrayList<TreatmentEpisode> getTreatmentEpisodeList() {
		return treatmentEpisodeList;
	}

	public void setTreatmentEpisodeList(
			ArrayList<TreatmentEpisode> treatmentEpisodeList) {
		this.treatmentEpisodeList = treatmentEpisodeList;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public ArrayList<DiaryManagement> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<DiaryManagement> userList) {
		this.userList = userList;
	}

	public String getDiaryUser() {
		return diaryUser;
	}

	public void setDiaryUser(String diaryUser) {
		this.diaryUser = diaryUser;
	}

	public String getTreatmentStartDate() {
		return treatmentStartDate;
	}

	public void setTreatmentStartDate(String treatmentStartDate) {
		this.treatmentStartDate = treatmentStartDate;
	}

	public String getTreatmentEpisodeName() {
		return treatmentEpisodeName;
	}

	public void setTreatmentEpisodeName(String treatmentEpisodeName) {
		this.treatmentEpisodeName = treatmentEpisodeName;
	}

	public String getReferalDate() {
		return referalDate;
	}

	public void setReferalDate(String referalDate) {
		this.referalDate = referalDate;
	}

	public String getReferralName() {
		return referralName;
	}

	public void setReferralName(String referralName) {
		this.referralName = referralName;
	}

	public String getReferralSource() {
		return referralSource;
	}

	public void setReferralSource(String referralSource) {
		this.referralSource = referralSource;
	}

	public String getReferralContact() {
		return referralContact;
	}

	public void setReferralContact(String referralContact) {
		this.referralContact = referralContact;
	}

	public String getReferralLetter() {
		return referralLetter;
	}

	public void setReferralLetter(String referralLetter) {
		this.referralLetter = referralLetter;
	}

	public String getPayby() {
		return payby;
	}

	public void setPayby(String payby) {
		this.payby = payby;
	}

	public String getSpendLimit() {
		return spendLimit;
	}

	public void setSpendLimit(String spendLimit) {
		this.spendLimit = spendLimit;
	}

	public String getConsultationLimit() {
		return consultationLimit;
	}

	public void setConsultationLimit(String consultationLimit) {
		this.consultationLimit = consultationLimit;
	}

	public String getDischargeLetter() {
		return dischargeLetter;
	}

	public void setDischargeLetter(String dischargeLetter) {
		this.dischargeLetter = dischargeLetter;
	}

	public String getAuthorisationCode() {
		return authorisationCode;
	}

	public void setAuthorisationCode(String authorisationCode) {
		this.authorisationCode = authorisationCode;
	}

	public String getInvoicee() {
		return invoicee;
	}

	public void setInvoicee(String invoicee) {
		this.invoicee = invoicee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
