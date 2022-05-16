package com.example.EEmployee.appuser.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ConfirmationTokenService {
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenRepository.save(token);
    }
    public Optional<ConfirmationToken>  getToken(String token){
      return confirmationTokenRepository.findByToken(token);

    }


        public void updateToken(ConfirmationToken confirmationToken) {
            confirmationTokenRepository.save(confirmationToken);


        }

}
