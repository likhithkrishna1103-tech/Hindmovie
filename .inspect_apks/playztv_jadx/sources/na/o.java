package na;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o implements nb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Set f8908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Set f8909b;

    public final synchronized void a() {
        try {
            Iterator it = this.f8908a.iterator();
            while (it.hasNext()) {
                this.f8909b.add(((nb.b) it.next()).get());
            }
            this.f8908a = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // nb.b
    public final Object get() {
        if (this.f8909b == null) {
            synchronized (this) {
                try {
                    if (this.f8909b == null) {
                        this.f8909b = Collections.newSetFromMap(new ConcurrentHashMap());
                        a();
                    }
                } finally {
                }
            }
        }
        return Collections.unmodifiableSet(this.f8909b);
    }
}
