package tracker.common.core.util

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import tracker.common.core.CoreApp
import tracker.common.core.R

object NotificationHelper {

    init {
        createNotificationChannel()
    }

    private enum class Channel constructor(var value: String) {
        PRIMARY("default")
    }

    fun tripRunning(): Notification {
        return createBuilder(
                CoreApp.string(R.string.app_name),
                CoreApp.string(R.string.on_way),
                Channel.PRIMARY.value,
                null)
                .build()
    }

    private fun createBuilder(
            title: String,
            content: String,
            channel: String,
            resultIntent: Intent?
    ): NotificationCompat.Builder {
        val defaultSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val builder = NotificationCompat.Builder(CoreApp.context, channel)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(content)
                .setTicker(title)
                .setSound(defaultSound)
                .setCategory(Notification.CATEGORY_SERVICE)
                .setAutoCancel(true)

        resultIntent?.apply {
            val intent = PendingIntent.getActivity(
                    CoreApp.context,
                    2,
                    this,
                    PendingIntent.FLAG_UPDATE_CURRENT
            )
            builder.setContentIntent(intent)
        }

        val bigTextStyle = NotificationCompat.BigTextStyle()
        bigTextStyle.setBigContentTitle(title)
        bigTextStyle.bigText(content)
        builder.setStyle(bigTextStyle)
        return builder
    }

    private fun createNotificationChannel() {
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.O)  return

        val channel = NotificationChannel(Channel.PRIMARY.value,
                CoreApp.string(R.string.app_name), NotificationManager.IMPORTANCE_DEFAULT)
        channel.lightColor = ContextCompat.getColor(CoreApp.context, R.color.orange)
        channel.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        getManager().createNotificationChannel(channel)
    }

    private fun getManager(): NotificationManager {
        return CoreApp.context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }
}
