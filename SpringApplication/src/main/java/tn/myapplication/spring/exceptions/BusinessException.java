package tn.myapplication.spring.exceptions;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message="";

    public BusinessException(String message) {
        this.message = message;
    }

}
