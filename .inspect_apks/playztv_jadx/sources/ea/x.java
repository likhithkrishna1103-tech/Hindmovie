package ea;

import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4637a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Logger f4639c;

    public x(Class cls) {
        this.f4638b = cls.getName();
    }

    public final Logger a() {
        Logger logger = this.f4639c;
        if (logger != null) {
            return logger;
        }
        synchronized (this.f4637a) {
            try {
                Logger logger2 = this.f4639c;
                if (logger2 != null) {
                    return logger2;
                }
                Logger logger3 = Logger.getLogger(this.f4638b);
                this.f4639c = logger3;
                return logger3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
