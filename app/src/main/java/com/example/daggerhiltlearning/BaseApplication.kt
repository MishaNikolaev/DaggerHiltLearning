package com.example.daggerhiltlearning

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/*All applications that use Hilt must be annotated with @HiltAndroidApp*/

@HiltAndroidApp
class BaseApplication : Application()