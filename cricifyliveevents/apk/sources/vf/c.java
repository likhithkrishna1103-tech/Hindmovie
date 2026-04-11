package vf;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kf.u;
import sd.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet f13725a = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f13726b;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r22 = u.class.getPackage();
        String name = r22 != null ? r22.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        linkedHashMap.put(u.class.getName(), "okhttp.OkHttpClient");
        linkedHashMap.put(rf.h.class.getName(), "okhttp.Http2");
        linkedHashMap.put(nf.d.class.getName(), "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        f13726b = s.C(linkedHashMap);
    }

    public static void a(String str, int i, String str2, Throwable th) {
        int iMin;
        String strS0 = (String) f13726b.get(str);
        if (strS0 == null) {
            strS0 = ne.h.s0(23, str);
        }
        if (Log.isLoggable(strS0, i)) {
            if (th != null) {
                str2 = str2 + '\n' + Log.getStackTraceString(th);
            }
            int length = str2.length();
            int i10 = 0;
            while (i10 < length) {
                int iH0 = ne.h.h0(str2, '\n', i10, 4);
                if (iH0 == -1) {
                    iH0 = length;
                }
                while (true) {
                    iMin = Math.min(iH0, i10 + 4000);
                    String strSubstring = str2.substring(i10, iMin);
                    ge.i.d(strSubstring, "substring(...)");
                    Log.println(i, strS0, strSubstring);
                    if (iMin >= iH0) {
                        break;
                    } else {
                        i10 = iMin;
                    }
                }
                i10 = iMin + 1;
            }
        }
    }

    public static void b(String str, String str2) {
        Logger logger = Logger.getLogger(str);
        if (f13725a.add(logger)) {
            logger.setUseParentHandlers(false);
            logger.setLevel(Log.isLoggable(str2, 3) ? Level.FINE : Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING);
            logger.addHandler(d.f13727a);
        }
    }
}
