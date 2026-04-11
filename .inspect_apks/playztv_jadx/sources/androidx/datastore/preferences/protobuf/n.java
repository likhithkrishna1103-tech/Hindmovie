package androidx.datastore.preferences.protobuf;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile n f1090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f1091b;

    static {
        try {
            Class.forName("androidx.datastore.preferences.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
        }
        n nVar = new n();
        Map map = Collections.EMPTY_MAP;
        f1091b = nVar;
    }

    public static n a() {
        n nVar;
        n nVar2 = f1090a;
        if (nVar2 != null) {
            return nVar2;
        }
        synchronized (n.class) {
            try {
                nVar = f1090a;
                if (nVar == null) {
                    Class cls = m.f1087a;
                    if (cls != null) {
                        try {
                            nVar = (n) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                        } catch (Exception unused) {
                            nVar = f1091b;
                        }
                        f1090a = nVar;
                    } else {
                        nVar = f1091b;
                        f1090a = nVar;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nVar;
    }
}
