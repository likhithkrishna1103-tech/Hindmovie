package hb;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements hc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Set f5904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Set f5905b;

    public final synchronized void a() {
        try {
            Iterator it = this.f5904a.iterator();
            while (it.hasNext()) {
                this.f5905b.add(((hc.b) it.next()).get());
            }
            this.f5904a = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // hc.b
    public final Object get() {
        if (this.f5905b == null) {
            synchronized (this) {
                try {
                    if (this.f5905b == null) {
                        this.f5905b = Collections.newSetFromMap(new ConcurrentHashMap());
                        a();
                    }
                } finally {
                }
            }
        }
        return Collections.unmodifiableSet(this.f5905b);
    }
}
