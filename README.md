# Getting Started

### Documentation
This project uses Java simple encryption, jasypt-spring-boot-starter library for encrypting and decrypting Strings.

Without wasting much time, Lets get into the usage details.

1. Download the project and import it as a gradle project.
2. Refresh gradle project of run a gradle build to get all the dependencies downloaded.
3. Start the application by running ComEncryptorApplication.java.
4. Encryption/Decryption happens based on a password or an encryption key.
5. The application exposes two endpoints encrypt and decrypt.
	* encrypt : Use this endpoint to encrypt a string. The `strToEncrypt` parameter is the input string to be encrypted and is mandatory. `encPass` is the password or an encryption key to be used to encrypt. The `encPass` parameter is not mandatory and if not passed, it uses a random UUID to encrypt the input string.  
	* decrypt : Use this endpoint to encrypt a string. The `strToDecrypt` parameter is the input string to be decrypted and is mandatory. `encPass` is the password or an encryption key to be used to decrypt. The `encPass` parameter is not mandatory and if not passed, it uses a random UUID to encrypt the input string.
	* `encPass` will be the same for a JVM lifecycle. If you want to use another custom `encPass`, just restart the JVM.

[Official jasypt documentation](http://www.jasypt.org/index.html)
