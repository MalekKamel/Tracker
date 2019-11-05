package tracker.common.maps

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.google.android.gms.maps.SupportMapFragment

class TouchableMap : SupportMapFragment() {
    private var mOriginalContentView: View? = null
    private var mTouchView: MapTouchableFrame? = null
    private var motionEventCallback: ((MotionEvent) -> Unit)? = null

    override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup?, savedInstanceState: Bundle?): View? {
        mOriginalContentView = super.onCreateView(inflater, parent, savedInstanceState)
        mTouchView = MapTouchableFrame(activity)
        mTouchView!!.addView(mOriginalContentView)
        return mTouchView
    }

    override fun getView(): View? {
        return mOriginalContentView
    }

    fun motionEvents(onMotionEventListener: ((MotionEvent) -> Unit)?) {
        this.motionEventCallback = onMotionEventListener
    }

    internal inner class MapTouchableFrame(activity: Activity?) : FrameLayout(activity) {

        override fun dispatchTouchEvent(event: MotionEvent): Boolean {

            if (motionEventCallback != null)
                motionEventCallback!!.invoke(event)

            return super.dispatchTouchEvent(event)
        }
    }

    companion object {

        fun newInstance(): SupportMapFragment {
            return TouchableMap()
        }
    }
}