package ninjaone.hexagonal.infrastructure.response;

import ninjaone.hexagonal.domain.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        var response = new Response();
        response.setMessage(message);
        response.setStatus(status.value());
        response.setData(responseObj);

        return new ResponseEntity<>(response,status);
    }
}