package ua.softserve.clientbanking.security;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
 
public class PasswordEncoder implements org.springframework.security.authentication.encoding.PasswordEncoder {
 
    public static final int SALT_LENGTH = 16;
    public static final int SALT_PLACE = 73;
 
    @Override
    public String encodePassword(String rawPass, Object salt) throws DataAccessException {
        try {
            String saltStr = randomSalt();
            return encrypt(rawPass, saltStr);
        } catch (Exception e) {
            throw new DataAccessResourceFailureException("Failed to encode password.", e);
        }
    }
 
    @Override
    public boolean isPasswordValid(String encPass, String rawPass, Object salt) throws DataAccessException {
        try {
            String saltStr = extractSaltFromHash(encPass);
            return encrypt(rawPass, saltStr).equals(encPass);
        } catch (Exception e) {
            throw new DataAccessResourceFailureException("Failed to validate password.", e);
        }
    }
 
    public String encrypt(String pass, String salt) {
 
        String saltPassStr = addSaltToPassword(pass, salt);
        String hash = getSHA(saltPassStr);
        return addSaltToHash(hash, salt);
    }
 
    public String getSHA(String raw) {
        return DigestUtils.shaHex(raw);
    }
 
    public String randomSalt() {
        return RandomStringUtils.random(SALT_LENGTH, "abcdef0123456789");
    }
 
    public String addSaltToPassword(String password, String salt) {
        return new StringBuilder(password).append(salt).toString();
    }
 
    public String addSaltToHash(String hash, String salt) {
        String part1 = StringUtils.substring(hash, 0, SALT_PLACE);
        String part2 = StringUtils.substring(hash, SALT_PLACE);
 
        return new StringBuilder(part1).append(salt).append(part2).toString();
    }
 
    public String extractSaltFromHash(String hash) {
        return StringUtils.substring(hash, SALT_PLACE, SALT_PLACE + SALT_LENGTH);
    }
}