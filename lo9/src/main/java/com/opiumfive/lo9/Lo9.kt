package com.opiumfive.lo9

import android.content.Context
import android.util.Log
import timber.log.Timber

object Lo9 {

    private var tree: Timber.Tree? = null

    @JvmStatic
    fun startWithFileLogger(context: Context) {
        val file = generateFile(context)
        if (file != null) {
            tree = FileLoggingTree(file)
            tree?.let{
                Timber.tag(context.appName())
                Timber.plant(it, DebugLogTree())
            }
        } else {
            Timber.e("Failed to create logs file")
        }
    }

    @JvmStatic
    fun start(context: Context, minimumDebugLevel: Int = Log.DEBUG) {
        tree = if (BuildConfig.DEBUG) {
            DebugLogTree()
        } else {
            ReleaseLogTree(minimumDebugLevel)
        }
        tree?.let {
            Timber.tag(context.appName())
            Timber.plant(it)
        }
    }

    internal fun isInitialised(): Boolean {
        if (tree == null) {
            Timber.plant(DebugLogTree())
        }
        return tree != null
    }

    internal fun logNotInitialised() {
        Timber.e("Please initialise lo9\nCall start() or startWithFileLogger()")
    }

}

fun logAssert(message: String) {
    if (Lo9.isInitialised()) {
        Timber.wtf(message)
    } else {
        Lo9.logNotInitialised()
    }
}

fun logAssert(t: Throwable, message: String) {
    if (Lo9.isInitialised()) {
        Timber.wtf(t, message)
    } else {
        Lo9.logNotInitialised()
    }
}

fun logAssert(t: Throwable) {
    if (Lo9.isInitialised()) {
        Timber.wtf(t)
    } else {
        Lo9.logNotInitialised()
    }
}

fun logError(message: String) {
    if (Lo9.isInitialised()) {
        Timber.e(message)
    } else {
        Lo9.logNotInitialised()
    }
}

fun logError(t: Throwable, message: String) {
    if (Lo9.isInitialised()) {
        Timber.e(t, message)
    } else {
        Lo9.logNotInitialised()
    }
}

fun logError(t: Throwable) {
    if (Lo9.isInitialised()) {
        Timber.e(t)
    } else {
        Lo9.logNotInitialised()
    }
}

fun logWarn(message: String) {
    if (Lo9.isInitialised()) {
        Timber.w(message)
    } else {
        Lo9.logNotInitialised()
    }
}

fun logWarn(t: Throwable, message: String) {
    if (Lo9.isInitialised()) {
        Timber.w(t, message)
    } else {
        Lo9.logNotInitialised()
    }
}

fun logWarn(t: Throwable) {
    if (Lo9.isInitialised()) {
        Timber.w(t)
    } else {
        Lo9.logNotInitialised()
    }
}

fun logInfo(message: String) {
    if (Lo9.isInitialised()) {
        Timber.i(message)
    } else {
        Lo9.logNotInitialised()
    }
}

fun logInfo(t: Throwable,message: String) {
    if (Lo9.isInitialised()) {
        Timber.i(t, message)
    } else {
        Lo9.logNotInitialised()
    }
}

fun logInfo(t: Throwable) {
    if (Lo9.isInitialised()) {
        Timber.i(t)
    } else {
        Lo9.logNotInitialised()
    }
}

fun logDebug(message: String) {
    if (Lo9.isInitialised()) {
        Timber.d(message)
    } else {
        Lo9.logNotInitialised()
    }
}

fun logDebug(t: Throwable, message: String) {
    if (Lo9.isInitialised()) {
        Timber.d(t, message)
    } else {
        Lo9.logNotInitialised()
    }
}

fun logDebug(t: Throwable) {
    if (Lo9.isInitialised()) {
        Timber.d(t)
    } else {
        Lo9.logNotInitialised()
    }
}

fun logVerbose(message: String) {
    if (Lo9.isInitialised()) {
        Timber.v(message)
    } else {
        Lo9.logNotInitialised()
    }
}

fun logVerbose(t: Throwable, message: String) {
    if (Lo9.isInitialised()) {
        Timber.v(t, message)
    } else {
        Lo9.logNotInitialised()
    }
}

fun logVerbose(t: Throwable) {
    if (Lo9.isInitialised()) {
        Timber.v(t)
    } else {
        Lo9.logNotInitialised()
    }
}