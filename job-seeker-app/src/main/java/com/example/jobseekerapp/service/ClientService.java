package com.example.jobseekerapp.service;

import com.example.jobseekerapp.repository.ClientRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.CustomValidatorBean;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ClientService {

    private static ClientRepository clientRepository;

    @Autowired
    private static Validator validator;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

//    private static final String EMAIL_REGEX = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]" +
//            "+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";

//    public static boolean isValidClient(@Valid Client client) {
//        Set<ConstraintViolation<Client>> violations = validator.validate(client);
//
//        if (!violations.isEmpty()) {
//            StringBuilder sb = new StringBuilder();
//            for (ConstraintViolation<Client> constraintViolation : violations) {
//                sb.append(constraintViolation.getMessage());
//            }
//            return false;
//        }
//
//        return isValidEmail(client.getEmail()) && clientRepository.existsById(client.getClientId().toString());
//    }

//    private static boolean isValidEmail(String email) {
//        Pattern pattern = Pattern.compile(EMAIL_REGEX);
//        Matcher matcher = pattern.matcher(email);
//        return matcher.matches();
//    }

}
