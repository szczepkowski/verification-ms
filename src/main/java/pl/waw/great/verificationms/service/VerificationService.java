package pl.waw.great.verificationms.service;

import org.springframework.stereotype.Service;
import pl.waw.great.verificationms.controller.ActionType;
import pl.waw.great.verificationms.controller.VerificationResponse;
import pl.waw.great.verificationms.controller.VerificationState;

import java.time.LocalDateTime;

@Service
public class VerificationService {

    public VerificationResponse doAction(String ean, ActionType actionType) {
        Integer eanInt = Integer.valueOf(ean);

        return doAction(ean, actionType, eanInt);
    }

    private VerificationResponse doAction(String ean, ActionType actionType, Integer eanInt) {
        VerificationState state = null;
        if (eanInt < 100) {
                state = VerificationState.VERIFIED;
            } else if (eanInt < 200) {
                state = VerificationState.DESTROYED;
            } else if (eanInt < 300) {
                state = VerificationState.RELEASED;
            } else if (eanInt < 400) {
                state = VerificationState.SAMPLE;
            } else {
                state = VerificationState.EXPIRED;
            }

        if( ActionType.CHECK.equals(actionType)){
            return  new VerificationResponse(ean, state, LocalDateTime.now());
        }
        throw new IllegalArgumentException("Only actionType CHECK is handled");

    }
}
