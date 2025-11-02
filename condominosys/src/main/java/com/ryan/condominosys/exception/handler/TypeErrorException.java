package com.ryan.condominosys.exception.handler;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum TypeErrorException {

    ERRO_INTERNO("/erro_interno", "Erro interno de sistema", HttpStatus.INTERNAL_SERVER_ERROR),
    ENTIDADE_NAO_ENCONTRADA("/entidade_nao_encontrada", "Entidade nao encontrada", HttpStatus.NOT_FOUND),
    ENTIDADE_EM_USO("/entidade_em_uso", "Entidade em uso", HttpStatus.CONFLICT),
    PARAMETRO_INVALIDO("/parametro_invalido","Parametro invalido",HttpStatus.BAD_REQUEST),
    DADOS_INVALIDO("/dados_invalido","Dados invalido",HttpStatus.BAD_REQUEST),
    ERRO_NEGOCIO("/erro_negocio", "Violação de regra de negócio", HttpStatus.BAD_REQUEST);

    private String title;
    private String uri;
    private HttpStatus status;

    TypeErrorException(String path, String title, HttpStatus status) {
        this.title = title;
        this.uri = "https://r_Kibe.com.br" + path;
        this.status = status;
    }
}
