package br.com.brunoeas.tourofheroes.enumeration;

/**
 * Enum de exceções tratadas
 *
 * @author Bruno Eduardo <bruno.soares@kepha.com.br>
 */
public enum ExceptionEnum {

    /**
     * 0 - ID inexistente na base de dados
     */
    ID_INEXISTENTE("O ID não existe na base de dados");

    /**
     * Mensagem do erro
     */
    private final String message;

    /**
     * Construtor padrão
     */
    ExceptionEnum(final String message) {
        this.message = message;
    }

    /**
     * @return Mensagem do erro
     */
    public String getMessage() {
        return this.message;
    }

}