package com.encryptor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.encrypter.dao.EncryptorDecryptor;

@RestController
public class ComEncryptorController {
	
	@Autowired
	EncryptorDecryptor encryptorDecryptor;
		
	@RequestMapping("/encrypt")
	public String encrypt(@RequestParam(required=true) String strToEncrypt, @RequestParam(required=false) String encPass){
		return encryptorDecryptor.encrypt(strToEncrypt, encPass).toString();
//		return "Hello!";
	}
	
	@RequestMapping("/decrypt")
	public String decrypt(@RequestParam(required=true) String strToDecrypt, @RequestParam(required=false) String encPass){
		return encryptorDecryptor.decrypt(strToDecrypt, encPass).toString();
	}
}
