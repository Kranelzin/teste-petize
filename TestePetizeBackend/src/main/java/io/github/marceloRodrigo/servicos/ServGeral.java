package io.github.marceloRodrigo.servicos;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServGeral {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void gerarRespostaSucesso(String json){
        amqpTemplate.convertAndSend(
                "resposta_sucesso_exchange",
                "resposta.sucesso.routing.key",
                json
        );
    }

    public void gerarRespostaErro(String json){
        amqpTemplate.convertAndSend(
                "resposta_erro_exchange",
                "resposta.erro.routing.key",
                json
        );
    }
}
