package com.leftlane.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.aspose.words.Document;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jnit.entities.Customer;
import com.jnit.entities.Ira;

public class Test {
	
	public static String dataDir = "C:\\Users\\susritha gade\\Desktop\\";
	static Customer emp;
	public int i=0;
	//@RequestMapping(method = RequestMethod.POST, value = "/Customer")
	//@ResponseBody
	private static void generateLegalBinder() throws Exception {

		ObjectMapper objectMapper = new ObjectMapper();
		 emp = objectMapper.readValue(
				new File("C:\\Users\\susritha gade\\eclipse-workspace\\Aspose\\src\\main\\resources\\customer.json"),
				Customer.class);
		Document doc = new Document(dataDir + "agreement.docx");

		//System.out.println(emp.getEmployerPlan().get(0).getPlanName());

		// Setup mail merge event handler to do the custom work.
		doc.getMailMerge().setFieldMergingCallback(new HandleMergeField());

		System.out.println(emp.getEmployerPlan());

		// This is the data for mail merge.
		// create a new method to map all the field Names and Field Values.
		
		
		String[] fieldNames = new String[] { "employerplan", "ira", "basicplan", "signatureplan", "preminumplan",
				"noticedeliveryaddress", "county", "clientname", "signature", "date", "address", "email",
				"employerplan1", "plan1sponsor", "plan1custodian", "employerplan2", "plan2sponsor", "plan2custodian",
				"iracustodian1", "iraaccno1", "iracustodian2", "iraaccno2", "iracustodian3", "iraaccno3",
				"iracustodian4", "iraaccno4", "by", "name", "title", "date" };

		Object[] fieldValues = new Object[] { emp.isEmployerPlanning(), emp.isIrat(), emp.isBasicPlan(),
				emp.isSignaturePlan(), emp.isPreminumPlan(), emp.getNoticeDeliveryAdd(), emp.getCounty(),
				emp.getClientName(), emp.getSignature(), emp.getCurrentDate(), emp.getAddress(), emp.getEmail(),
				emp.getEmployerPlan().get(0).getPlanName(), emp.getEmployerPlan().get(0).getPlanSponsor(),
				emp.getEmployerPlan().get(0).getPlanCustodian(), emp.getEmployerPlan().get(1).getPlanName(),
				emp.getEmployerPlan().get(1).getPlanSponsor(), emp.getEmployerPlan().get(1).getPlanCustodian(),
				emp.getIra().get(0).getIraCustodian(), emp.getIra().get(0).getIraAccno(),
				emp.getIra().get(1).getIraCustodian(), emp.getIra().get(1).getIraAccno(),
				emp.getIra().get(2).getIraCustodian(), emp.getIra().get(2).getIraAccno(),
				emp.getIra().get(3).getIraCustodian(), emp.getIra().get(3).getIraAccno(), emp.getBy(), emp.getName(),
				emp.getTitle(), emp.getCurrentDate() };
		
		// Execute the mail merge.
		doc.getMailMerge().execute(fieldNames, fieldValues);

		// Save the finished document.
		doc.save(dataDir + "Asposeout.docx");	
	}		
	public void gettingIra()
	
	{
		Map<String,Object> map;
	 for(Ira emp: emp.getIra()) {
		 map= new HashMap<>();
		 if(emp.getIra()!=null) {
			 
		 }
	 }
	}
	public static void DocToPdf() throws Exception {
		Document doc1 = new Document(dataDir + "Asposeout.docx");
		// Save as PDF
		doc1.save(dataDir + "output.pdf");
		System.out.println("Done");
	}


}
