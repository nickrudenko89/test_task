package Validators;

import Forms.RequestForm;
import Utils.Constants;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class NewRequestValidator implements Validator {
    public boolean supports(Class<?> aClass) {
        return RequestForm.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors errors) {
        RequestForm requestForm = (RequestForm) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "request", "request.empty", Constants.Errors.EMPTY_REQUEST_ERROR);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bid", "bid.empty", Constants.Errors.EMPTY_BID_ERROR);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dueDate", "dueDate.empty", Constants.Errors.EMPTY_DATE_ERROR);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dateFormat.parse(requestForm.getDueDate());
        } catch (ParseException e) {
            errors.rejectValue("dueDate", "dueDate.incorrectFormat", Constants.Errors.INCORRECT_DATE_ERROR);
        }

    }
}
