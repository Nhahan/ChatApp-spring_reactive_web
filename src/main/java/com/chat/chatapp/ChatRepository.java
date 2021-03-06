package com.chat.chatapp;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface ChatRepository extends ReactiveMongoRepository<Chat, String> {

    @Tailable // 커서를 닫지 않고 계속 유지(무한스트림)
    @Query("{sender:?0, receiver:?1}")
    Flux<Chat> findBySender(String sender, String receiver);
}
