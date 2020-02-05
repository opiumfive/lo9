package com.opiumfive.lo9demo

import android.app.Activity
import android.content.Context
import android.net.Uri
import com.opiumfive.lo9.*

class log {

    companion object {

        fun debug(message: String?) = message?.let { logDebug(it) }
        fun debug(throwable: Throwable?) = throwable?.let { logDebug(it) }

        fun error(message: String?) = message?.let { logError(it) }
        fun error(throwable: Throwable?) = throwable?.let { logError(it) }

        fun startLoggingToFile(context: Context) = Lo9.startWithFileLogger(context.applicationContext)
        fun shareLogFile(activity: Activity, emailAddress: String) = shareLogsFile(activity, emailAddress)
        fun deleteLogFile(context: Context) = deleteLogsFile(context)
        fun getLogFile(context: Context): Uri? = getLogsFile(context)
        fun openLogFile(context: Context) = openLogsFile(context)
    }

}