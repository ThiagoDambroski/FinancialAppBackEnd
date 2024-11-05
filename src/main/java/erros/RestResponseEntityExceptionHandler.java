package erros;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorMessage> userNotFoundException(UserNotFoundException exception, WebRequest request){
		
		ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
		
		
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<ErrorMessage> accountNotFoundException(AccountNotFoundException exception, WebRequest request){
		
		
		ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
		
	}
	
	@ExceptionHandler(IncomePlanNotFoundException.class)
	public ResponseEntity<ErrorMessage> incomePlanNotFoundException(IncomePlanNotFoundException exception, WebRequest request){
		
		ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
				
		
	}
	
	
	@ExceptionHandler(IncomeNotFoundException.class)
	public ResponseEntity<ErrorMessage> incomeNotFoundException(IncomeNotFoundException exception,WebRequest request){
		
		ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
		
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
	
	@ExceptionHandler(IncomeCategoryNotFoundException.class)
	public ResponseEntity<ErrorMessage> incomeCategoryNotFoundException(IncomeCategoryNotFoundException exception,WebRequest request){
		
		ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
	@ExceptionHandler(InvestmentNotFoundException.class)
	public ResponseEntity<ErrorMessage> investmentNotFoundException(InvestmentNotFoundException exception,WebRequest request){
		
		ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
	@ExceptionHandler(PagamentNotFoundException.class)
	public ResponseEntity<ErrorMessage> pagamentNotFoundException(PagamentNotFoundException exception,WebRequest request){
		
		ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
	@ExceptionHandler(PagamentPlanNotFoundException.class)
	public ResponseEntity<ErrorMessage> pagamentPlanNotFoundException(PagamentPlanNotFoundException exception, WebRequest request){
		
		ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
	
	
}
