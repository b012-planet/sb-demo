package b012.demo

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.queryParamOrNull
import reactor.core.publisher.Mono

@Component
class GreetingHandler {
    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    fun hello(request: ServerRequest): Mono<ServerResponse> {
        val msg = request.queryParamOrNull("msg") ?: "empty"
        logger.info(">> $msg")
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(Greeting(msg)))
    }
}