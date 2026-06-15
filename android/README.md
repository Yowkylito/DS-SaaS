# DropShipping Android App

A modern Android application for drop shipping using Jetpack Compose, Koin DI, and Clean Architecture principles.

## Architecture Overview

This project follows Clean Architecture with the following layers:

### 1. **Presentation Layer** (`ui/`)
- Jetpack Compose UI components
- Navigation using Compose Navigation
- Screen implementations
- Theme configuration

### 2. **Domain Layer** (`domain/`)
- Use cases (business logic)
- Repository interfaces (abstract)
- Domain models

### 3. **Data Layer** (`data/`)
- Repository implementations
- API services (Retrofit)
- Database entities (Room)
- Data models

## Project Structure

```
android/
├── app/
│   ├── src/main/
│   │   ├── kotlin/com/dropshipping/saas/
│   │   │   ├── data/
│   │   │   │   ├── api/          # Retrofit services
│   │   │   │   ├── models/       # Data models
│   │   │   │   └── repository/   # Repository implementations
│   │   │   ├── di/               # Koin dependency injection
│   │   │   ├── domain/
│   │   │   │   └── usecase/      # Business logic
│   │   │   ├── ui/
│   │   │   │   ├── navigation/   # Navigation routes
│   │   │   │   ├── screens/      # Screens
│   │   │   │   └── theme/        # Material 3 theme
│   │   │   ├── DropShippingApp.kt    # App class
│   │   │   └── MainActivity.kt       # Main activity
│   │   └── AndroidManifest.xml
│   ├── build.gradle.kts
│   └── proguard-rules.pro
├── build.gradle.kts
├── settings.gradle.kts
└── gradle.properties
```

## Technologies Used

- **Jetpack Compose**: Modern declarative UI framework
- **Material Design 3**: Latest Material design system
- **Koin**: Lightweight DI framework
- **Retrofit**: HTTP client for API calls
- **OkHttp**: HTTP interceptor for logging
- **Kotlinx Serialization**: JSON serialization
- **Navigation Compose**: Navigation between screens
- **Room Database**: Local data persistence (optional)
- **Kotlin Coroutines**: Asynchronous programming

## Features

### Index/Home Screen
- Hero section with app introduction
- Featured products showcase
- Quick statistics display
- Call-to-action buttons
- Bottom navigation bar
- Material 3 theming

## Getting Started

### Prerequisites
- Android Studio 2023.1+
- Kotlin 1.9.0+
- Gradle 8.1.0+
- Java 17

### Setup

1. Open the project in Android Studio
2. Build the project:
   ```bash
   ./gradlew build
   ```
3. Run on emulator or device:
   ```bash
   ./gradlew installDebug
   ```

## Dependency Injection with Koin

The app uses Koin for DI. Configuration is in `DropShippingApp.kt` and modules are defined in `di/AppModule.kt`:

```kotlin
startKoin {
    androidLogger(Level.DEBUG)
    androidContext(this@DropShippingApp)
    modules(appModule)
}
```

## API Integration

The app is configured to communicate with a drop shipping API. Update the `BASE_URL` in `di/AppModule.kt` with your API endpoint:

```kotlin
private const val BASE_URL = "https://your-api-url.com"
```

## Building for Production

1. Update build config for release:
   ```bash
   ./gradlew bundleRelease
   ```

2. Sign the APK/Bundle:
   - Use Android Studio's signing wizard
   - Or configure signing in `build.gradle.kts`

## Testing

- Unit tests go in `src/test/`
- Integration tests go in `src/androidTest/`
- Run tests: `./gradlew test`

## Future Enhancements

- [ ] Product detail screen
- [ ] Product list with pagination
- [ ] Search functionality
- [ ] User authentication
- [ ] Shopping cart
- [ ] Order management
- [ ] Offline support with Room
- [ ] Unit and integration tests
- [ ] Dark mode improvements

## Contributing

Contributions are welcome! Please follow the clean architecture principles and the existing code structure.

## License

This project is part of the DropShipping SaaS platform.
