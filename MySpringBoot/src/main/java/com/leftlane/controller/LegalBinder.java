package com.leftlane.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aspose.words.Document;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jnit.entities.Customer;
import com.jnit.entities.Ira;
import com.jnit.entities.UploadFile;
import com.leftlane.controller.HandleMergeField;

@RestController
public class LegalBinder {
	
	public static String dataDir = ".\\src\\main\\resources\\";
	
	@RequestMapping(method = RequestMethod.POST, value = "/Customer" , consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	private static void generateLegalBinder(@RequestBody Customer cust) throws Exception {
	//System.out.println(emp.getClientId());
	
		List<Object> out=asList(cust);

		Document doc = new Document(dataDir + "agreement.docx");
		doc.getMailMerge().setFieldMergingCallback(new HandleMergeField());
		String[] fieldNames = new String[] { "employerplan", "ira", "basicplan", "signatureplan", "preminumplan",
				"noticedeliveryaddress", "county", "clientname", "signature", "date", "address", "email",
				"employerplan1", "plan1sponsor", "plan1custodian", "employerplan2", "plan2sponsor", "plan2custodian",
				"iracustodian1", "iraaccno1", "iracustodian2", "iraaccno2", "iracustodian3", "iraaccno3",
				"iracustodian4", "iraaccno4", "by", "name", "title", "date" };

	


     Object[] fieldvalue = out.toArray(); // Execute the mail merge.
	  doc.getMailMerge().execute(fieldNames, fieldvalue);
	  
	 // Save the finished document. String vars=dataDir
	 String vars=dataDir+cust.getName()+"_"+cust.getClientName()+'_'+cust.getCurrentDate()+".pdf";
	 String variable=cust.getName()+"_"+cust.getClientName()+'_'+cust.getCurrentDate()+".pdf";
	 doc.save(vars);
	 
	  System.out.println(vars);
	 
	  UploadFile uf = new UploadFile();
	  uf.Upload(variable);
	  
	  
	}
	
	public static  List<Object> asList(Customer emp) {
		List<Object> list= new ArrayList<Object>();
		list.add(emp.isEmployerPlanning());
		list.add(emp.isIrat());
		list.add(emp.isBasicPlan());
		list.add(emp.isSignaturePlan());
		list.add(emp.isPreminumPlan());
		list.add(emp.getNoticeDeliveryAdd()==null?"":emp.getNoticeDeliveryAdd());
		list.add(emp.getCounty()==null?"":emp.getCounty());
		list.add(emp.getClientName()==null?"":emp.getClientName());
		list.add(emp.getSignature()==null?"":emp.getSignature());
		list.add(emp.getCurrentDate()==null?"":emp.getCurrentDate());
		list.add(emp.getAddress()==null?"":emp.getAddress());
		list.add(emp.getEmail()==null?"":emp.getEmail());
		for(int i = 0;i<emp.getEmployerPlan().size();i++) {
	 if ( emp.getEmployerPlan().get(i).getPlanId()!=null)
	 {
		
		list.add(emp.getEmployerPlan().get(i).getPlanName()==null?"":emp.getEmployerPlan().get(i).getPlanName());
		list.add(emp.getEmployerPlan().get(i).getPlanSponsor()==null?"":emp.getEmployerPlan().get(i).getPlanSponsor());
		list.add(emp.getEmployerPlan().get(i).getPlanCustodian()==null?"":emp.getEmployerPlan().get(i).getPlanCustodian());
			}
	else {
		
		list.add("");
		list.add("");
		list.add("");
	}

	}
		
		for(int i = 0;i<emp.getIra().size();i++) {
			 if ( emp.getIra().get(i).getIraId()!=null)
			 {
				
				list.add(emp.getIra().get(i).getIraCustodian()==null?"":emp.getIra().get(i).getIraCustodian());
				list.add(emp.getIra().get(i).getIraAccno()==null?"":emp.getIra().get(i).getIraAccno());
				
					}
			else {
				
				list.add("");
				list.add("");
			}

			}
		list.add(emp.getBy()==null?"":emp.getBy());
		list.add(emp.getName()==null?"":emp.getName());
		list.add(emp.getTitle()==null?"":emp.getTitle());
		list.add(emp.getCurrentDate()==null?"":emp.getCurrentDate());
		System.out.println("List returned");
		return  list;
		
		
		 
	}
	


}
