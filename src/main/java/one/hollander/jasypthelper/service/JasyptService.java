package one.hollander.jasypthelper.service;

import lombok.RequiredArgsConstructor;
import one.hollander.jasypthelper.enums.JasyptVersion;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.iv.NoIvGenerator;
import org.jasypt.iv.RandomIvGenerator;
import org.jasypt.salt.RandomSaltGenerator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JasyptService {
    public String encrypt(String input, String secret, JasyptVersion jasyptVersion) {
        return getEncryptor(secret, jasyptVersion).encrypt(input);
    }

    public String decrypt(String input, String secret, JasyptVersion jasyptVersion) {
        return getEncryptor(secret, jasyptVersion).decrypt(input);
    }

    private PooledPBEStringEncryptor getEncryptor(String secret, JasyptVersion jasyptVersion) {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setPassword(secret);
        encryptor.setPoolSize(1);
        encryptor.setKeyObtentionIterations(1000);
        encryptor.setSaltGenerator(new RandomSaltGenerator());
        encryptor.setStringOutputType("base64");

        switch (jasyptVersion) {
            case V2 -> {
                encryptor.setAlgorithm("PBEWithMD5AndDES");
                encryptor.setIvGenerator(new NoIvGenerator());
            }
            case V3 -> {
                encryptor.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
                encryptor.setIvGenerator(new RandomIvGenerator());
            }
            default -> throw new IllegalArgumentException("Unsupported Jasypt Version");
        }
        return encryptor;
    }
}
