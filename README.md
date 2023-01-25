# horoproject
Consist of 2 apps: Android App and Wear OS.

Simple Application that shows daily horoscope information to different sign.
App module can be deployed on mobile pones, wear module is for WearOS devices.

Dependencies vs libraries
- Jetpack Compose / Wear Compose
- Retrofit
- Coroutines
- Dagger ( Hilt )
- Compose Accompanist

Project structure
- MVVM

Layers
- Data ( Get remote data from network, use Retrofit )
- DI ( provide repositories )
- Presentation ( User interfaces )
