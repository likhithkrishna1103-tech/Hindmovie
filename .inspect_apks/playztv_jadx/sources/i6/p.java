package i6;

import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayDeque f6418b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f6419a;

    static {
        char[] cArr = x6.m.f14291a;
        f6418b = new ArrayDeque(0);
    }

    public static p a(Object obj) {
        p pVar;
        ArrayDeque arrayDeque = f6418b;
        synchronized (arrayDeque) {
            pVar = (p) arrayDeque.poll();
        }
        if (pVar == null) {
            pVar = new p();
        }
        pVar.f6419a = obj;
        return pVar;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof p) && this.f6419a.equals(((p) obj).f6419a);
    }

    public final int hashCode() {
        return this.f6419a.hashCode();
    }
}
