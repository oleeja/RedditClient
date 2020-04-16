import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import reditclient.di.commonModule
import reditclient.di.dataSourceModule
import reditclient.di.retrofitNetworkModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(commonModule + dataSourceModule + retrofitNetworkModule)
        }
    }
}