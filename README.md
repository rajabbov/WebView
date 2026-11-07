# WebView

A single app collecting 60+ screens of Android fundamentals — from WebView and dialogs to SQLite and RecyclerView — each one a self-contained, runnable example.

## Features

- WebView screen with loading progress
- Spinner, TimePicker, DatePicker and other input widgets
- RecyclerView in list and grid form, with custom adapters
- Gallery and image picker screens
- SQLite persistence via a hand-written `MyDbManager`
- Custom dialogs, fragments and a contacts screen

## Tech stack

- **Language:** Kotlin
- **UI:** XML layouts with View binding
- **SDK:** min 24, target 34
- **Package:** `com.example.webview`
- **Libraries:** Navigation component

<sub>74 source files · 1926 lines of code · 64 layouts</sub>

## Getting started

```bash
git clone https://github.com/rajabbov/WebView.git
```

Open the folder in Android Studio, let Gradle sync, and run the `app` configuration on a device or emulator.

### Configuration

Each feature lives in its own package and activity, so screens can be read in isolation.

## License

MIT
