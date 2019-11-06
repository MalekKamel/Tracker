
package tracker.common.presentation.navigation

import com.sha.kamel.navigator.modular.AddressableActivity

/**
 * All addressable activities.
 *
 * Can contain intent extra names or functions associated with the activity creation.
 */
object Activities {
    object Main: AddressableActivity {
        override val className: String = "com.tracker.app.MainActivity"
    }
}
