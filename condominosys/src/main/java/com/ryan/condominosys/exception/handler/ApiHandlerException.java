package com.ryan.condominosys.exception.handler;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ryan.condominosys.exception.generic.EntidadeEmUsoException;
import com.ryan.condominosys.exception.generic.EntidadeNaoEncontradaException;
import com.ryan.condominosys.exception.generic.NegocioException;

import org.springframework.lang.Nullable;
import org.springframework.validation.BindingResult;

@ControllerAdvice
public class ApiHandlerException extends ResponseEntityExceptionHandler {

    private static final String MSG_USUARIO_ERRO_GENERICO = "Ocorreu um erro inesperado no sistema. Tente novamente mais tarde ou contate o suporte";

    // ===========================================================================================

    // Exceptiosn genericas da api

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<?> handlerEntidadeNaoEncontradaExeption(EntidadeNaoEncontradaException e,
            WebRequest _request) {

        TypeErrorException type = TypeErrorException.ENTIDADE_NAO_ENCONTRADA;
        HttpStatus status = type.getStatus();
        String _detail = e.getMessage();
        HttpHeaders headers = new HttpHeaders();

        ModelOutput layotOutput = createReadyBody(e, status, type, _detail)
                .userMessage(_detail)
                .build();

        return handleExceptionInternal(e, layotOutput, headers, status, _request);
    }

    @ExceptionHandler(EntidadeEmUsoException.class)
    public ResponseEntity<?> handlerEntidadeEmUsoException(EntidadeEmUsoException e, WebRequest request) {

        TypeErrorException type = TypeErrorException.ENTIDADE_EM_USO;
        HttpStatus status = type.getStatus();
        String _detail = e.getMessage();
        HttpHeaders headers = new HttpHeaders();

        ModelOutput layoutBodyOutput = createReadyBody(e, status, type, _detail)
                .userMessage(_detail)
                .build();

        return handleExceptionInternal(e, layoutBodyOutput, headers, status, request);
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<?> handlerNegocioException(NegocioException e, WebRequest request) {

        TypeErrorException type = TypeErrorException.ERRO_NEGOCIO;
        HttpStatus status = type.getStatus();
        String _detail = e.getMessage();
        HttpHeaders headers = new HttpHeaders();

        ModelOutput layoutBodyOutput = createReadyBody(e, status, type, _detail)
                .userMessage(_detail)
                .build();

        return handleExceptionInternal(e, layoutBodyOutput, headers, status, request);
    }

    // ===========================================================================================

    // Gerador de Bodys

    private ModelOutput.ModelOutputBuilder createReadyBody(Exception ex, HttpStatusCode statusCode,
            TypeErrorException typeError, String detail) {
        return ModelOutput.builder()
                .status(statusCode.value())
                .type(typeError.getUri())
                .title(typeError.getTitle())
                .detail(detail);
    }

    // SUbstitui o corpo da resposta padrao

    @Override
    @Nullable
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers,
            HttpStatusCode statusCode, WebRequest request) {

        if (body == null) {
            body = ModelOutput.builder()
                    .timestamp(OffsetDateTime.now())
                    .status(statusCode.value())
                    .title(((HttpStatus) statusCode).getReasonPhrase())
                    .build();
        } else if (body instanceof String) {
            body = ModelOutput.builder()
                    .timestamp(OffsetDateTime.now())
                    .status(statusCode.value())
                    .title(((String) body))
                    .build();
        }

        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }

    // ===========================================================================================

    // Classe ResponseEntityExceptionHandler possui essas impplementacoes de
    // exceptions]

    // Onde procurar as exceptions
    // https://docs.spring.io/spring-framework/docs/5.0.2.RELEASE/kdoc-api/spring-framework/org.springframework.web.method.annotation/index.html

    /*
     * HttpRequestMethodNotSupportedException.class,
     * HttpMediaTypeNotSupportedException.class,
     * HttpMediaTypeNotAcceptableException.class,
     * MissingPathVariableException.class,
     * MissingServletRequestParameterException.class,
     * MissingServletRequestPartException.class,
     * ServletRequestBindingException.class,
     * MethodArgumentNotValidException.class,
     * HandlerMethodValidationException.class,
     * NoHandlerFoundException.class,
     * NoResourceFoundException.class,
     * AsyncRequestTimeoutException.class,
     * ErrorResponseException.class,
     * MaxUploadSizeExceededException.class,
     * ConversionNotSupportedException.class,
     * TypeMismatchException.class,
     * HttpMessageNotReadableException.class,
     * HttpMessageNotWritableException.class,
     * MethodValidationException.class,
     * AsyncRequestNotUsableException.class
     */

    /*
     * Ver possivel erro de Exception
     * 
     * Throwable root = ExceptionUtils.getRootCause(ex);
     * String _detail = String.format("Erro: " + root.getClass().getName());
     */

    // ===========================================================================================

    // Verificador de subclasses

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {

        if (ex instanceof MethodArgumentTypeMismatchException) {
            return handleMethodArgumentTypeMismatch((MethodArgumentTypeMismatchException) ex, headers, status, request);
        }

        return super.handleTypeMismatch(ex, headers, status, request);
    }

    // Trata rota com id invalido: .../aa
    private ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
            HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {

        String path = ex.getName();
        TypeErrorException type = TypeErrorException.PARAMETRO_INVALIDO;
        HttpStatus _status = type.getStatus();

        @SuppressWarnings("null")
        String _detail = String.format("O parâmetro de URL '%s' recebeu o valor '%s', "
                + "que é de um tipo inválido. Tipo esperado: %s.",
                path, ex.getValue(),
                ex.getRequiredType().getSimpleName());

        ModelOutput layoutBodyOutput = createReadyBody(ex, _status, type, _detail)
                .userMessage(MSG_USUARIO_ERRO_GENERICO)
                .build();

        return handleExceptionInternal(ex, layoutBodyOutput, headers, _status, request);
    }

    // ===========================================================================================

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        TypeErrorException type = TypeErrorException.PARAMETRO_INVALIDO;
        HttpStatus _status = type.getStatus();
        String _detail = String
                .format("Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.");

        // Obtém o objeto que contém todos os resultados da validação.
        BindingResult bindResult = ex.getBindingResult();

        List<ModelOutput.PropertiesS> propertiesS = bindResult.getFieldErrors().stream()
                .map(fieldError -> ModelOutput.PropertiesS.builder()
                        .name(fieldError.getField())
                        .userMessage(fieldError.getDefaultMessage())
                        .build())
                .collect(Collectors.toList());

        ModelOutput layoutBodyOutput = createReadyBody(ex, _status, type, _detail)
                .field(propertiesS)
                .userMessage(_detail)
                .build();

        return handleExceptionInternal(ex, layoutBodyOutput, headers, _status, request);

    }

    // ===========================================================================================

}
