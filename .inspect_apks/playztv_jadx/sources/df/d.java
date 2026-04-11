package df;

import android.util.Log;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f4200a = new d();

    @Override // java.util.logging.Handler
    public final void publish(LogRecord logRecord) {
        int iMin;
        be.h.e(logRecord, "record");
        CopyOnWriteArraySet copyOnWriteArraySet = c.f4198a;
        String loggerName = logRecord.getLoggerName();
        be.h.d(loggerName, "record.loggerName");
        int iIntValue = logRecord.getLevel().intValue();
        Level level = Level.INFO;
        int i = iIntValue > level.intValue() ? 5 : logRecord.getLevel().intValue() == level.intValue() ? 4 : 3;
        String message = logRecord.getMessage();
        be.h.d(message, "record.message");
        Throwable thrown = logRecord.getThrown();
        String strA0 = (String) c.f4199b.get(loggerName);
        if (strA0 == null) {
            strA0 = ie.e.a0(loggerName, 23);
        }
        if (Log.isLoggable(strA0, i)) {
            if (thrown != null) {
                message = message + '\n' + Log.getStackTraceString(thrown);
            }
            int length = message.length();
            int i10 = 0;
            while (i10 < length) {
                int iS = ie.e.S(message, '\n', i10, 4);
                if (iS == -1) {
                    iS = length;
                }
                while (true) {
                    iMin = Math.min(iS, i10 + 4000);
                    String strSubstring = message.substring(i10, iMin);
                    be.h.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Log.println(i, strA0, strSubstring);
                    if (iMin >= iS) {
                        break;
                    } else {
                        i10 = iMin;
                    }
                }
                i10 = iMin + 1;
            }
        }
    }

    @Override // java.util.logging.Handler
    public final void close() {
    }

    @Override // java.util.logging.Handler
    public final void flush() {
    }
}
