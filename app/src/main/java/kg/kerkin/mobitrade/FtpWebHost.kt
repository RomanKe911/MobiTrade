package kg.kerkin.mobitrade

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.apache.commons.net.ftp.FTPClient
import org.apache.commons.net.ftp.FTPReply
import java.io.IOException
import java.util.logging.Logger

class FtpWebHost(
     val ftp_server: String,
     val ftp_port: Int,
     val ftp_user_name: String,
     val ftp_password: String
) {

    fun FTPisConnect(): Int {
        var myReturn = 0
        try {
            val myTag = "FTPConnect";
            Log.e(myTag, "Проверка подключения к FTP")
            val ftpClient = FTPClient()
            ftpClient.connect(ftp_server, ftp_port)
            ftpClient.login(ftp_user_name, ftp_password)
            val replyCode = ftpClient.replyCode
            if (FTPReply.isPositiveCompletion(replyCode))
                myReturn = Log.e(myTag, "Есть соединение с сервером!")
            else myReturn = Log.e(myTag, "Oops, is not connect")
            ftpClient.logout()
            ftpClient.disconnect()
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return myReturn
    }
}