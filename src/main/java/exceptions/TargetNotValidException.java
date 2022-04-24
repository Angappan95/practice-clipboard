package exceptions;

public class TargetNotValidException extends IllegalArgumentException{
    public TargetNotValidException(String target){
        super(String.format("Target %s not supported", target));
    }
}
