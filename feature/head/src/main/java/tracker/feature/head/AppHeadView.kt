package tracker.feature.head

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.os.Build
import android.util.AttributeSet
import android.view.Gravity
import android.view.MotionEvent
import android.view.WindowManager
import android.widget.RelativeLayout
import com.sha.kamel.navigator.modular.ActivityModuleNavigator
import tracker.common.presentation.navigation.Activities

class AppHeadView : RelativeLayout {
    
    private var lastAction: Int = 0
    private var initialX: Int = 0
    private var initialY: Int = 0
    private var initialTouchX: Float = 0.toFloat()
    private var initialTouchY: Float = 0.toFloat()

    lateinit var params: WindowManager.LayoutParams
    lateinit var onDismiss: () ->Unit

    constructor(context: Context) : super(context) {
        setupParams()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setupParams()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int)
            : super(context, attrs, defStyle) {
        setupParams()
    }

    init {
        setupParams()
    }

    private fun setupParams() {
        val overlayParam = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
        else
            WindowManager.LayoutParams.TYPE_PHONE

        params = WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                overlayParam,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT
        )

        // Specify the chat head position
        params.gravity = Gravity.TOP or Gravity.START
        params.x = 0
        params.y = 100
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {

            MotionEvent.ACTION_DOWN -> {
                //remember the initial position.
                initialX = params.x
                initialY = params.y

                //get the touch location
                initialTouchX = event.rawX
                initialTouchY = event.rawY

                lastAction = event.action
                return true
            }

            MotionEvent.ACTION_UP -> {
                //As we implemented on touch listener with ACTION_MOVE,
                //we have to check if the previous action was ACTION_DOWN
                //to identify if the user clicked the view or not.
                if (lastAction == MotionEvent.ACTION_DOWN) {
                    //Open the chat conversation click.
                    ActivityModuleNavigator(context, context.packageName)
                            .withFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            .navigate(Activities.Main)
                    //close the service and remove the chat heads
                    onDismiss()
                }
                lastAction = event.action
                return true
            }

            MotionEvent.ACTION_MOVE -> {
                //Calculate the X and Y coordinates of the view.
                params.x = initialX + (event.rawX - initialTouchX).toInt()
                params.y = initialY + (event.rawY - initialTouchY).toInt()

                //Update the layout with new X & Y coordinate

                (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager)
                        .updateViewLayout(this, params)

                lastAction = event.action
                return true
            }

            else -> return super.onTouchEvent(event)
        }
    }

}