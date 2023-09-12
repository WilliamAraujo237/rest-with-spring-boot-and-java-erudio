package br.com.erudio.Entity;

public class Greeting_saldacao {

    private final Long id;
    private final String content;


    public Greeting_saldacao(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}
