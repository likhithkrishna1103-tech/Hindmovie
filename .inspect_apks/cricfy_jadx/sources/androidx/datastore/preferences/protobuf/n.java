package androidx.datastore.preferences.protobuf;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile n f759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f760b;

    static {
        n nVar = new n();
        Map map = Collections.EMPTY_MAP;
        f760b = nVar;
    }

    public static n a() {
        n nVar;
        r0 r0Var = r0.f786c;
        n nVar2 = f759a;
        if (nVar2 != null) {
            return nVar2;
        }
        synchronized (n.class) {
            try {
                nVar = f759a;
                if (nVar == null) {
                    Class cls = m.f745a;
                    n nVar3 = null;
                    if (cls != null) {
                        try {
                            nVar3 = (n) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                        } catch (Exception unused) {
                        }
                    }
                    nVar = nVar3 != null ? nVar3 : f760b;
                    f759a = nVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nVar;
    }
}
