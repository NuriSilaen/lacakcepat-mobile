package id.lacakcepat.covidnineteen.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Suppress("UNCHECKED_CAST")
@Singleton
class ViewModelFactory @Inject internal constructor(
    private val creators: Map<Class<out ViewModel?>?, @JvmSuppressWildcards Provider<ViewModel>?>
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator: Provider<out ViewModel>? = creators[modelClass]
        if (creator == null) {
            for ((key, value) in creators) {
                if (key != null && modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        return try {
            creator?.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}