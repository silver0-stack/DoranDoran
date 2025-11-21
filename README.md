# DoranDoran

[![Android Build](https://github.com/silver0-stack/DoranDoran/actions/workflows/android-build.yml/badge.svg)](https://github.com/silver0-stack/DoranDoran/actions/workflows/android-build.yml)

## Demo / Try it without building

Want to test the app without building from source? We automatically build a debug APK on every push to the main branch!

### Option 1: Download APK from GitHub Actions

1. Go to the [GitHub Actions page](https://github.com/silver0-stack/DoranDoran/actions/workflows/android-build.yml)
2. Click on the latest successful workflow run (green checkmark ✓)
3. Scroll down to the "Artifacts" section
4. Download the `app-debug` artifact (it's a ZIP file)
5. Extract the ZIP file to get `app-debug.apk`

### Option 2: Run in Android Emulator

Once you have the APK, you can run it in an Android emulator:

#### Prerequisites
- Install [Android Studio](https://developer.android.com/studio)
- Or install Android SDK command-line tools

#### Steps
1. **Create an Android Virtual Device (AVD):**
   - Open Android Studio
   - Go to `Tools` → `Device Manager`
   - Click `Create Device`
   - Select a device (e.g., Pixel 5)
   - Select a system image (API 28 or higher, as the app's minSdk is 28)
   - Click `Finish`

2. **Start the emulator:**
   - In Device Manager, click the ▶️ (Play) button next to your AVD

3. **Install the APK:**
   
   **Method A - Drag and Drop:**
   - Simply drag the `app-debug.apk` file and drop it into the running emulator window
   
   **Method B - Using adb:**
   ```bash
   # Make sure adb is in your PATH (typically in Android SDK platform-tools)
   adb install -r path/to/app-debug.apk
   ```
   
   **Method C - Using Android Studio:**
   - With the emulator running, go to `Run` → `Install APK from file`
   - Select the `app-debug.apk` file

4. **Launch the app:**
   - Find "Doran" in the app drawer of your emulator
   - Tap to launch

### Option 3: Web-based Demo (Appetize.io)

For a quick browser-based demo without installing anything:

1. Go to [Appetize.io](https://appetize.io/)
2. Sign up for a free account (100 minutes free per month)
3. Click `Upload` and select your `app-debug.apk`
4. Wait for the upload and processing to complete
5. You'll get a shareable link to run the app in your browser
6. Share this link with reviewers for instant access

**Note:** Free tier limitations apply (session length, concurrent users)

### Option 4: Automated Testing with Firebase Test Lab (Optional)

For automated UI testing across multiple device configurations:

#### Manual Upload
1. Go to [Firebase Console](https://console.firebase.google.com/)
2. Select your project (or create one)
3. Navigate to `Test Lab` in the left sidebar
4. Click `Run a test`
5. Select the test type (Robo test for automatic exploration, or Instrumentation for custom tests)
6. Upload `app-debug.apk`
7. Select device matrix (devices, OS versions, locales)
8. Click `Start test`

#### Automated via GitHub Actions
You can also trigger Firebase Test Lab tests automatically by extending the workflow. Add this to `.github/workflows/android-build.yml`:

```yaml
- name: Run Firebase Test Lab tests
  uses: google-github-actions/auth@v1
  with:
    credentials_json: ${{ secrets.FIREBASE_SERVICE_ACCOUNT }}
    
- name: Test with Firebase Test Lab
  run: |
    gcloud firebase test android run \
      --type robo \
      --app app/build/outputs/apk/debug/app-debug.apk \
      --device model=Pixel2,version=28,locale=en,orientation=portrait
```

**Note:** Requires Firebase project setup and service account credentials stored in GitHub Secrets.

## Building from Source

If you prefer to build the app yourself:

1. Clone this repository
2. Open the project in Android Studio
3. Let Gradle sync
4. Run the app on an emulator or physical device

## Requirements

- Android Studio Arctic Fox or later
- JDK 11
- Android SDK API 28 or higher
- Gradle 7.0.2