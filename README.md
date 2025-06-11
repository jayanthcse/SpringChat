# SpringChat - Chat & Video Call Application

A real-time chat and video calling application built with Spring Boot, WebSocket, and WebRTC technologies.

## Features

### 💬 Chat Functionality
- Real-time messaging using WebSocket
- Multiple users can join and chat simultaneously
- Simple and clean user interface
- Message history display

### 📹 Video Call Functionality
- Peer-to-peer video calling using WebRTC
- Start video calls with other connected users
- Accept/decline incoming video calls
- End calls functionality
- Real-time video and audio streaming
- Camera and microphone access management

## Technologies Used

### Backend
- **Spring Boot 3.5.0** - Main framework
- **Spring WebSocket** - Real-time communication
- **Thymeleaf** - Template engine
- **Lombok** - Reduce boilerplate code
- **Maven** - Dependency management

### Frontend
- **HTML5** - Structure
- **CSS3** - Styling
- **JavaScript** - Client-side logic
- **WebRTC** - Peer-to-peer video communication
- **SockJS** - WebSocket fallback
- **STOMP.js** - WebSocket messaging protocol

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher
- Modern web browser with WebRTC support (Chrome, Firefox, Safari, Edge)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/jayanthcse/SpringChat.git
   cd SpringChat
   ```

2. **Build the application**
   ```bash
   ./mvnw clean compile
   ```

3. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the application**
   - Open your browser and navigate to `http://localhost:8080/chat`
   - Open multiple tabs/windows to test with different users

## How to Use

### Chat Features
1. Enter your name in the "Your name" field
2. Type your message in the message field
3. Click "Send" to send the message
4. Messages appear in real-time for all connected users

### Video Call Features
1. **Starting a Call:**
   - Enter your name
   - Click "Start Video Call"
   - Allow camera/microphone access when prompted
   - Wait for other users to accept

2. **Receiving a Call:**
   - You'll see a notification when someone calls
   - Click "Accept" to join the video call
   - Click "Decline" to reject the call

3. **During a Call:**
   - Your video appears on the left
   - Remote user's video appears on the right
   - Click "End Call" to terminate the call

## Project Structure

```
src/
├── main/
│   ├── java/com/chat/app/
│   │   ├── AppApplication.java          # Main Spring Boot application
│   │   ├── config/
│   │   │   └── WebSocketConfig.java     # WebSocket configuration
│   │   ├── controller/
│   │   │   └── ChatController.java      # Chat and video call endpoints
│   │   └── model/
│   │       └── ChatMessage.java         # Message model with video support
│   └── resources/
│       ├── templates/
│       │   └── chat.html               # Main UI template
│       └── application.properties      # Application configuration
```

## API Endpoints

### WebSocket Endpoints
- `/chat` - WebSocket connection endpoint
- `/app/sendMessage` - Send chat messages
- `/app/videoCall` - Handle video call signaling
- `/topic/messages` - Subscribe to receive messages

### HTTP Endpoints
- `GET /chat` - Main chat page

## Message Types

The application supports various message types for different functionalities:

- `CHAT` - Regular text messages
- `VIDEO_CALL_REQUEST` - Initiate video call
- `VIDEO_CALL_ACCEPT` - Accept incoming call
- `VIDEO_CALL_DECLINE` - Decline incoming call
- `VIDEO_CALL_END` - End active call
- `WEBRTC_OFFER` - WebRTC connection offer
- `WEBRTC_ANSWER` - WebRTC connection answer
- `WEBRTC_ICE_CANDIDATE` - ICE candidate for NAT traversal

## Browser Compatibility

### Supported Browsers
- Chrome 56+
- Firefox 44+
- Safari 11+
- Edge 79+

### Required Permissions
- Camera access for video calls
- Microphone access for audio
- Secure context (HTTPS in production)

## Development

### Running in Development Mode
```bash
./mvnw spring-boot:run
```

### Building for Production
```bash
./mvnw clean package
java -jar target/app-0.0.1-SNAPSHOT.jar
```

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is open source and available under the [MIT License](LICENSE).

## Troubleshooting

### Common Issues

1. **Video call not working:**
   - Ensure browser supports WebRTC
   - Check camera/microphone permissions
   - Use HTTPS in production environments

2. **Connection issues:**
   - Check if port 8080 is available
   - Verify WebSocket connection in browser console

3. **Build issues:**
   - Ensure Java 17+ is installed
   - Check Maven configuration

## Future Enhancements

- [ ] Screen sharing functionality
- [ ] Group video calls
- [ ] File sharing in chat
- [ ] User authentication
- [ ] Chat rooms/channels
- [ ] Message persistence
- [ ] Mobile responsive design improvements

## Support

For support and questions, please open an issue in the GitHub repository.
