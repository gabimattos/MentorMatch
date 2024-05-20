import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.support.annotation.DrawableRes
import androidx.core.app.NotificationCompat
import br.com.fiap.mentormatch.R
import kotlin.random.Random

class MatchNotificationService(
    private val context: Context
){
    private val notificationManager=context.getSystemService(NotificationManager::class.java)
    fun showBasicNotification(){
        val notification= NotificationCompat.Builder(context,"match_notification")
            .setContentTitle("Match")
            .setContentText("Você teve um Match com outro usuário do MentorMatch.")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(
            Random.nextInt(),
            notification
        )
    }


    private fun Context.bitmapFromResource(
        @DrawableRes resId:Int
    )= BitmapFactory.decodeResource(
        resources,
        resId
    )
}