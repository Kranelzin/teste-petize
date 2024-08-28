package io.github.marceloRodrigo.configuracoes;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfRabbitMQ {

    @Value("${rabbitmq.resposta.sucesso.queue.name}")
    private String queueRespostaSucesso;

    @Value("${rabbitmq.resposta.sucesso.exchange.name}")
    private String exchangeRespostaSucesso;

    @Value("${rabbitmq.resposta.sucesso.router.key.name}")
    private String routerRespostaSucesso;

    @Value("${rabbitmq.resposta.erro.queue.name}")
    private String queueRespostaErro;

    @Value("${rabbitmq.resposta.erro.exchange.name}")
    private String exchangeRespostaErro;

    @Value("${rabbitmq.resposta.erro.router.key.name}")
    private String routerRespostaErro;


    @Value("${rabbitmq.cadastrarpedido.queue.name}")
    private String queueCadastrarPedido;

    @Value("${rabbitmq.cadastrarpedido.exchange.name}")
    private String exchangeCadastrarPedido;

    @Value("${rabbitmq.cadastrarpedido.router.key.name}")
    private String routerCadastrarPedido;

    @Value("${rabbitmq.cadastrarproduto.queue.name}")
    private String queueCadastrarProduto;

    @Value("${rabbitmq.cadastrarproduto.exchange.name}")
    private String exchangeCadastrarProduto;

    @Value("${rabbitmq.cadastrarproduto.router.key.name}")
    private String routerCadastrarProduto;

    @Value("${rabbitmq.buscarproduto.queue.name}")
    private String queueBuscarProduto;

    @Value("${rabbitmq.buscarproduto.exchange.name}")
    private String exchangeBuscarProduto;

    @Value("${rabbitmq.buscarproduto.router.key.name}")
    private String routerBuscarProduto;

    @Value("${rabbitmq.buscarpedido.queue.name}")
    private String queueBuscarPedido;

    @Value("${rabbitmq.buscarpedido.exchange.name}")
    private String exchangeBuscarPedido;

    @Value("${rabbitmq.buscarpedido.router.key.name}")
    private String routerBuscarPedido;

    @Value("${rabbitmq.atualizarpedido.queue.name}")
    private String queueAtualizarPedido;

    @Value("${rabbitmq.atualizarpedido.exchange.name}")
    private String exchangeAtualizarPedido;

    @Value("${rabbitmq.atualizarpedido.router.key.name}")
    private String routerAtualizarPedido;

    @Value("${rabbitmq.atualizarproduto.queue.name}")
    private String queueAtualizarProduto;

    @Value("${rabbitmq.atualizarproduto.exchange.name}")
    private String exchangeAtualizarProduto;

    @Value("${rabbitmq.atualizarproduto.router.key.name}")
    private String routerAtualizarProduto;

    @Value("${rabbitmq.deletarpedido.queue.name}")
    private String queueDeletarPedido;

    @Value("${rabbitmq.deletarpedido.exchange.name}")
    private String exchangeDeletarPedido;

    @Value("${rabbitmq.deletarpedido.router.key.name}")
    private String routerDeletarPedido;

    @Value("${rabbitmq.deletarproduto.queue.name}")
    private String queueDeletarProduto;

    @Value("${rabbitmq.deletarproduto.exchange.name}")
    private String exchangeDeletarProduto;

    @Value("${rabbitmq.deletarproduto.router.key.name}")
    private String routerDeletarProduto;

    @Value("${rabbitmq.respostabuscarproduto.queue.name}")
    private String queueRespostaBuscarProduto;

    @Value("${rabbitmq.respostabuscarproduto.exchange.name}")
    private String exchangeRespostaBuscarProduto;

    @Value("${rabbitmq.respostabuscarproduto.router.key.name}")
    private String routerRespostaBuscarProduto;

    @Value("${rabbitmq.respostabuscarpedido.queue.name}")
    private String queueRespostaBuscarPedido;

    @Value("${rabbitmq.respostabuscarpedido.exchange.name}")
    private String exchangeRespostaBuscarPedido;

    @Value("${rabbitmq.respostabuscarpedido.router.key.name}")
    private String routerRespostaBuscarPedido;

    @Bean
    public Queue queueRespostaBuscarPedido() {
        return new Queue(queueRespostaBuscarPedido);
    }

    @Bean
    public TopicExchange exchangeRespostaBuscarPedido() {
        return new TopicExchange(exchangeRespostaBuscarPedido);
    }

    @Bean
    public Binding bindingRespostaBuscarPedido() {
        return BindingBuilder.bind(queueRespostaBuscarPedido())
                .to(exchangeRespostaBuscarPedido())
                .with(routerRespostaBuscarPedido);
    }

    @Bean
    public Queue queueRespostaBuscarProduto() {
        return new Queue(queueRespostaBuscarProduto);
    }

    @Bean
    public TopicExchange exchangeRespostaBuscarProduto() {
        return new TopicExchange(exchangeRespostaBuscarProduto);
    }

    @Bean
    public Binding bindingRespostaBuscarProduto() {
        return BindingBuilder.bind(queueRespostaBuscarProduto())
                .to(exchangeRespostaBuscarProduto())
                .with(routerRespostaBuscarProduto);
    }

    @Bean
    public Queue queueRespostaSucesso() {
        return new Queue(queueRespostaSucesso);
    }

    @Bean
    public TopicExchange exchangeRespostaSucesso() {
        return new TopicExchange(exchangeRespostaSucesso);
    }

    @Bean
    public Binding bindingRespostaSucesso() {
        return BindingBuilder.bind(queueRespostaSucesso()).to(exchangeRespostaSucesso()).with(routerRespostaSucesso);
    }

    @Bean
    public Queue queueRespostaErro() {
        return new Queue(queueRespostaErro);
    }

    @Bean
    public TopicExchange exchangeRespostaErro() {
        return new TopicExchange(exchangeRespostaErro);
    }

    @Bean
    public Binding bindingRespostaErro() {
        return BindingBuilder.bind(queueRespostaErro()).to(exchangeRespostaErro()).with(routerRespostaErro);
    }

    @Bean
    public Queue queueCadastrarPedido() {
        return new Queue(queueCadastrarPedido);
    }

    @Bean
    public TopicExchange exchangeCadastrarPedido() {
        return new TopicExchange(exchangeCadastrarPedido);
    }

    @Bean
    public Binding bindingCadastrarPedido() {
        return BindingBuilder.bind(queueCadastrarPedido()).to(exchangeCadastrarPedido()).with(routerCadastrarPedido);
    }

    @Bean
    public Queue queueCadastrarProduto() {
        return new Queue(queueCadastrarProduto);
    }

    @Bean
    public TopicExchange exchangeCadastrarProduto() {
        return new TopicExchange(exchangeCadastrarProduto);
    }

    @Bean
    public Binding bindingCadastrarProduto() {
        return BindingBuilder.bind(queueCadastrarProduto()).to(exchangeCadastrarProduto()).with(routerCadastrarProduto);
    }

    @Bean
    public Queue queueBuscarProduto() {
        return new Queue(queueBuscarProduto);
    }

    @Bean
    public TopicExchange exchangeBuscarProduto() {
        return new TopicExchange(exchangeBuscarProduto);
    }

    @Bean
    public Binding bindingBuscarProduto() {
        return BindingBuilder.bind(queueBuscarProduto()).to(exchangeBuscarProduto()).with(routerBuscarProduto);
    }

    @Bean
    public Queue queueBuscarPedido() {
        return new Queue(queueBuscarPedido);
    }

    @Bean
    public TopicExchange exchangeBuscarPedido() {
        return new TopicExchange(exchangeBuscarPedido);
    }

    @Bean
    public Binding bindingBuscarPedido() {
        return BindingBuilder.bind(queueBuscarPedido()).to(exchangeBuscarPedido()).with(routerBuscarPedido);
    }

    @Bean
    public Queue queueAtualizarPedido() {
        return new Queue(queueAtualizarPedido);
    }

    @Bean
    public TopicExchange exchangeAtualizarPedido() {
        return new TopicExchange(exchangeAtualizarPedido);
    }

    @Bean
    public Binding bindingAtualizarPedido() {
        return BindingBuilder.bind(queueAtualizarPedido()).to(exchangeAtualizarPedido()).with(routerAtualizarPedido);
    }

    @Bean
    public Queue queueAtualizarProduto() {
        return new Queue(queueAtualizarProduto);
    }

    @Bean
    public TopicExchange exchangeAtualizarProduto() {
        return new TopicExchange(exchangeAtualizarProduto);
    }

    @Bean
    public Binding bindingAtualizarProduto() {
        return BindingBuilder.bind(queueAtualizarProduto()).to(exchangeAtualizarProduto()).with(routerAtualizarProduto);
    }

    @Bean
    public Queue queueDeletarPedido() {
        return new Queue(queueDeletarPedido);
    }

    @Bean
    public TopicExchange exchangeDeletarPedido() {
        return new TopicExchange(exchangeDeletarPedido);
    }

    @Bean
    public Binding bindingDeletarPedido() {
        return BindingBuilder.bind(queueDeletarPedido()).to(exchangeDeletarPedido()).with(routerDeletarPedido);
    }

    @Bean
    public Queue queueDeletarProduto() {
        return new Queue(queueDeletarProduto);
    }

    @Bean
    public TopicExchange exchangeDeletarProduto() {
        return new TopicExchange(exchangeDeletarProduto);
    }

    @Bean
    public Binding bindingDeletarProduto() {
        return BindingBuilder.bind(queueDeletarProduto()).to(exchangeDeletarProduto()).with(routerDeletarProduto);
    }
}
