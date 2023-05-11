package com.example.spring_exception_validation.Exception;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
public class PersonException {
    private int status;
    private String message;
    private String details;
    private Date timeStamp;

    public PersonException(int status,String message,Date timeStamp)
    {
        this.status=status;
        this.message=message;
        this.timeStamp=timeStamp;
    }
    public PersonException(int status,String message,Date timeStamp,String details)
    {
        this.status=status;
        this.message=message;
        this.timeStamp=timeStamp;
        this.details=details;
    }


}
