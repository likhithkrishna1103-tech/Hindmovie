package g1;

import fe.l;
import java.util.logging.Logger;
import pe.v;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Object f4612c;

    public a(Class cls) {
        this.f4610a = new Object();
        this.f4611b = cls.getName();
    }

    public Logger a() {
        Logger logger = (Logger) this.f4612c;
        if (logger != null) {
            return logger;
        }
        synchronized (this.f4610a) {
            try {
                Logger logger2 = (Logger) this.f4612c;
                if (logger2 != null) {
                    return logger2;
                }
                Logger logger3 = Logger.getLogger(this.f4611b);
                this.f4612c = logger3;
                return logger3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public a(String str, e1.a aVar, l lVar, v vVar) {
        ge.i.e(str, "name");
        this.f4611b = str;
        this.f4610a = new Object();
    }
}
