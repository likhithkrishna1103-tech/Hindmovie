package pb;

import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f10152a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10153b = 64;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10154c;

    public d(int i) {
        this.f10154c = i;
    }

    public static String b(int i, String str) {
        if (str != null) {
            str = str.trim();
            if (str.length() > i) {
                return str.substring(0, i);
            }
        }
        return str;
    }

    public final synchronized Map a() {
        return Collections.unmodifiableMap(new HashMap(this.f10152a));
    }

    public final synchronized boolean c(String str) {
        String strB = b(this.f10154c, "com.crashlytics.version-control-info");
        if (this.f10152a.size() >= this.f10153b && !this.f10152a.containsKey(strB)) {
            Log.w("FirebaseCrashlytics", "Ignored entry \"com.crashlytics.version-control-info\" when adding custom keys. Maximum allowable: " + this.f10153b, null);
            return false;
        }
        String strB2 = b(this.f10154c, str);
        String str2 = (String) this.f10152a.get(strB);
        if (str2 == null ? strB2 == null : str2.equals(strB2)) {
            return false;
        }
        this.f10152a.put(strB, strB2);
        return true;
    }

    public final synchronized void d(Map map) {
        try {
            int i = 0;
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw new IllegalArgumentException("Custom attribute key must not be null.");
                }
                String strB = b(this.f10154c, str);
                if (this.f10152a.size() < this.f10153b || this.f10152a.containsKey(strB)) {
                    String str2 = (String) entry.getValue();
                    this.f10152a.put(strB, str2 == null ? "" : b(this.f10154c, str2));
                } else {
                    i++;
                }
            }
            if (i > 0) {
                Log.w("FirebaseCrashlytics", "Ignored " + i + " entries when adding custom keys. Maximum allowable: " + this.f10153b, null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
