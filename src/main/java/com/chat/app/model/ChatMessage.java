package com.chat.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatMessage {
    private Long id;
    private String sender;
    private String content;
    private MessageType type;
    private String targetUser; // For video calls - who the call is for
    private Object data; // For WebRTC signaling data (offer, answer, ice candidates)

    public enum MessageType {
        CHAT,
        VIDEO_CALL_REQUEST,
        VIDEO_CALL_ACCEPT,
        VIDEO_CALL_DECLINE,
        VIDEO_CALL_END,
        WEBRTC_OFFER,
        WEBRTC_ANSWER,
        WEBRTC_ICE_CANDIDATE
    }
}
