# SpringChat - Chat & Video Call Application

A real-time chat and video calling application built with Spring Boot, WebSocket, and WebRTC technologies.

## Features

### 🔐 Authentication & Security
- JWT-based authentication system
- User registration and login
- Secure password encryption with BCrypt
- MySQL database integration
- User session management
- Online status tracking
- Role-based access control

### 💬 Chat Functionality
- Real-time messaging using WebSocket
- Authenticated users only
- Multiple users can join and chat simultaneously
- Simple and clean user interface
- Message history display
- User identification in messages

### 📹 Video Call Functionality
- Peer-to-peer video calling using WebRTC
- Start video calls with other authenticated users
- Accept/decline incoming video calls
- End calls functionality
- Real-time video and audio streaming
- Camera and microphone access management

## Technologies Used

### Backend
- **Spring Boot 3.5.0** - Main framework
- **Spring Security** - Authentication and authorization
- **Spring Data JPA** - Database operations
- **Spring WebSocket** - Real-time communication
- **JWT (JSON Web Tokens)** - Secure authentication
- **MySQL** - Database storage
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
- MySQL 8.0 or higher
- Modern web browser with WebRTC support (Chrome, Firefox, Safari, Edge)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/jayanthcse/SpringChat.git
   cd SpringChat
   ```

2. **Setup MySQL Database**
   - Install MySQL 8.0+
   - Create a database named `springchat` (or let the app auto-create it)
   - Default credentials: username=`root`, password=`jay@2004`
   - Update `src/main/resources/application.properties` if needed

3. **Build the application**
   ```bash
   ./mvnw clean compile
   ```

4. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

5. **Access the application**
   - Open your browser and navigate to `http://localhost:8080`
   - You'll be redirected to the login page
   - Register a new account or login with existing credentials
   - Access the chat and video features after authentication

## How to Use

### Authentication
1. **Registration:**
   - Navigate to `http://localhost:8080`
   - Click "Sign up here" on the login page
   - Fill in username, email, and password (min 6 characters)
   - Click "Register" to create your account

2. **Login:**
   - Enter your username and password
   - Click "Login" to access the application
   - You'll be redirected to the chat interface

### Chat Features
1. Your username is automatically filled (from login)
2. Type your message in the message field
3. Click "Send" to send the message
4. Messages appear in real-time for all authenticated users
5. Click "Logout" to end your session

### Video Call Features
1. **Starting a Call:**
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
│   │   │   ├── SecurityConfig.java      # Spring Security configuration
│   │   │   └── WebSocketConfig.java     # WebSocket configuration
│   │   ├── controller/
│   │   │   ├── AuthController.java      # Authentication endpoints
│   │   │   └── ChatController.java      # Chat and video call endpoints
│   │   ├── dto/                         # Data Transfer Objects
│   │   │   ├── JwtResponse.java
│   │   │   ├── LoginRequest.java
│   │   │   ├── MessageResponse.java
│   │   │   └── SignupRequest.java
│   │   ├── model/
│   │   │   ├── ChatMessage.java         # Message model with video support
│   │   │   └── User.java                # User entity
│   │   ├── repository/
│   │   │   └── UserRepository.java      # User data access
│   │   ├── security/                    # Security components
│   │   │   ├── AuthTokenFilter.java
│   │   │   ├── JwtUtils.java
│   │   │   └── UserPrincipal.java
│   │   └── service/
│   │       └── UserDetailsServiceImpl.java
│   └── resources/
│       ├── templates/
│       │   ├── chat.html               # Main chat interface
│       │   ├── login.html              # Login page
│       │   └── register.html           # Registration page
│       └── application.properties      # Application configuration
```

## API Endpoints

### Authentication Endpoints
- `POST /api/auth/signin` - User login
- `POST /api/auth/signup` - User registration
- `POST /api/auth/logout` - User logout
- `GET /api/auth/login` - Login page
- `GET /api/auth/register` - Registration page

### WebSocket Endpoints
- `/chat-websocket` - WebSocket connection endpoint (authenticated)
- `/app/sendMessage` - Send chat messages
- `/app/videoCall` - Handle video call signaling
- `/topic/messages` - Subscribe to receive messages

### HTTP Endpoints
- `GET /` - Redirects to login
- `GET /chat` - Main chat page (authenticated)

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
