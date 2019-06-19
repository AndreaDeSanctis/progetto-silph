package progettosilph.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import progettosilph.model.Funzionario;

@Component
public class FunzionarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Funzionario.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		
	}
}
