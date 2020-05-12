package com.encrypter.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author E5Z6
 *
 */
@Component
public class EncryptorDecryptor {
	
	StandardPBEStringEncryptor enc;
	String encAlgorithm;
	String encPass;
	
	Logger logger = LoggerFactory.getLogger(EncryptorDecryptor.class);
	
	/**
	 * @param strToEncrypt
	 * @param encPassInput
	 * @return
	 */
	public Map<String, String> encrypt(String strToEncrypt, String encPassInput){
		Map<String, String> resultMap = new HashMap<String, String>();
		
		encAlgorithm = "PBEWithMD5AndDES";
		getEncryptorInstance(encPassInput);
		String encryptedString = enc.encrypt(strToEncrypt);
		logger.debug("encryptedString - "+encryptedString);
		resultMap.put("strToEncrypt", strToEncrypt);
		resultMap.put("EncryptionAlgorithm", encAlgorithm);
		resultMap.put("EncryptionPassCode", encPass);
		resultMap.put("EncryptedString", encryptedString);
		
		return resultMap;
	}
	
	/**
	 * @param strToDecrypt
	 * @param encPassInput
	 * @return
	 */
	public Map<String, String> decrypt(String strToDecrypt, String encPassInput){
		Map<String, String> resultMap = new HashMap<String, String>();
		encAlgorithm = "PBEWithMD5AndDES";
		getEncryptorInstance(encPassInput);
		String decryptedString = enc.decrypt(strToDecrypt);
		logger.debug("decryptedPass - "+decryptedString);
		resultMap.put("strToDecrypt", strToDecrypt);
		resultMap.put("EncryptionAlgorithm", encAlgorithm);
		resultMap.put("EncryptionPassCode", encPass);
		resultMap.put("DecryptedString", decryptedString);
		return resultMap;
	}
	
	/**
	 * Always create a single encryptor instance
	 * @param encPassInput
	 */
	public void getEncryptorInstance(String encPassInput){
		if(enc == null)
		{
			encPass = Optional.ofNullable(encPassInput).isPresent()?encPassInput: UUID.randomUUID().toString();
			enc = new StandardPBEStringEncryptor();
			enc.setPassword(encPass);
			enc.setAlgorithm(encAlgorithm);
			if(!enc.isInitialized()){
				enc.initialize();
			}
		}
	}
	
	
	
}
