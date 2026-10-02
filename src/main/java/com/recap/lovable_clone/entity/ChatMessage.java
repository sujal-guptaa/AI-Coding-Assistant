package com.recap.lovable_clone.entity;

import java.time.Instant;

public class ChatMessage {
    Long id;
    ChatSession chatSession;
    String content;
    String toolCalls;
    Integer tokenUsed;
    Instant createdAt;
}
