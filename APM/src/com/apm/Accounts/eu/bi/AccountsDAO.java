package com.apm.Accounts.eu.bi;

import java.util.ArrayList;

import com.apm.Accounts.eu.entity.Accounts;

public interface AccountsDAO {

	

	ArrayList<Accounts> getAccountList(String clientId,String payby);

	ArrayList<Accounts> getAssesmentList(int invoiceid);

	int updatePayment(String invoiceid, String payAmount, String howpaid,
			String invoiceDate,String paid);

	int getPayAmount(int invoiceid);

	int updatePayBy(int invoiceid, String payby);

}
