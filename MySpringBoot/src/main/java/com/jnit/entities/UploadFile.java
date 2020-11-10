package com.jnit.entities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
@Component
public class UploadFile {
	public static String dataDir = "C:\\Users\\susritha gade\\Desktop\\";
	@Value("${aws.access_key_id}")
	String key_id;
	@Value("${aws.secret_access_key}")
	String access_key;
	
	public void Upload(String filepath) throws IOException {
	//public static void main(String args[]) throws IOException {
	final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
	String bucket_name= "legalagreement";
	String key_name = filepath ;
	String file_path = dataDir+filepath;
	
	
	
//	
	AWSCredentials credentials = new BasicAWSCredentials("AKIAYDKCACXY4Y2OITVB","0KXq6D5oohmqaq93uJCmAIOurXdwgkj2gitYKBQo");
	AmazonS3 s3client = AmazonS3ClientBuilder
			  .standard()
			  .withCredentials(new AWSStaticCredentialsProvider(credentials))
			  .withRegion(Regions.US_EAST_1)
			  .build();
	
//	String bucketName = filepath;
//	s3client.createBucket(bucketName);
	
	
//	S3Object s3object = s3client.getObject(bucket_name, "1_11-09-2020_Asposeout.pdf");
//	S3ObjectInputStream inputStream = s3object.getObjectContent();
//	FileUtils.copyInputStreamToFile(inputStream, new File("C:\\Users\\susritha gade\\Desktop\\1_11-09-2020_Asposeout3.pdf"));

		//s3.putObject(bucket_name,key_name,new File(file_path));
	s3client.putObject(
			bucket_name, 
			  key_name, 
			  new File(file_path)
			);
	
	}	
	
}
	
	
	


