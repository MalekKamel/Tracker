package tracker.feature.head

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.PixelFormat
import android.os.Build
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.WindowManager
import android.widget.RelativeLayout

class AppHeadView : RelativeLayout {
    
    private var lastAction: Int = 0
    private var initialX: Int = 0
    private var initialY: Int = 0
    private var initialTouchX: Float = 0.toFloat()
    private var initialTouchY: Float = 0.toFloat()

    lateinit var params: WindowManager.LayoutParams
    var onHeadClicked: ((AppHeadView) -> Unit)? = null

    private lateinit var windowManager: WindowManager

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
        setup()
    }

    private fun setup() {
        windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
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
                    onHeadClicked?.invoke(this)
                }
                lastAction = event.action
                return true
            }

            MotionEvent.ACTION_MOVE -> {
                //Calculate the X and Y coordinates of the view.
                params.x = initialX + (event.rawX - initialTouchX).toInt()
                params.y = initialY + (event.rawY - initialTouchY).toInt()

                //Update the layout with new X & Y coordinate

                windowManager.updateViewLayout(this, params)

                lastAction = event.action
                return true
            }

            else -> return super.onTouchEvent(event)
        }
    }

    companion object {
        fun show(context: Context, layoutId: Int): AppHeadView {
            val head = LayoutInflater.from(context).inflate(layoutId, null) as AppHeadView
            val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            windowManager.addView(head, head.params)
            return head
        }
    }

}