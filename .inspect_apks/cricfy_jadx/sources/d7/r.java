package d7;

import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayDeque f3505b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f3506a;

    static {
        char[] cArr = s7.m.f11607a;
        f3505b = new ArrayDeque(0);
    }

    public static r a(Object obj) {
        r rVar;
        ArrayDeque arrayDeque = f3505b;
        synchronized (arrayDeque) {
            rVar = (r) arrayDeque.poll();
        }
        if (rVar == null) {
            rVar = new r();
        }
        rVar.f3506a = obj;
        return rVar;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof r) && this.f3506a.equals(((r) obj).f3506a);
    }

    public final int hashCode() {
        return this.f3506a.hashCode();
    }
}
