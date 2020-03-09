

import com.example.work.exception.DuplicateUrlException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RestControllerAdvice

/*
@RestControllerAdvice(annotations = [RestController::class])
class RestControllerAdvice {

    @ExceptionHandler(value = [DuplicateUrlException::class,Exception::class])
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    fun handle400Exception(e: Exception) =
        ErrorResponse(e.javaClass.simpleName, HttpStatus.BAD_REQUEST.name, "${e.message}")
}
*/

data class ErrorResponse(val className: String?,val errorName: String,val msg: String)
