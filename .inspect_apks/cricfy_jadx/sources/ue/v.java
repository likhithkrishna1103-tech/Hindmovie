package ue;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v implements vd.g {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ThreadLocal f12491v;

    public v(ThreadLocal threadLocal) {
        this.f12491v = threadLocal;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof v) && ge.i.a(this.f12491v, ((v) obj).f12491v);
    }

    public final int hashCode() {
        return this.f12491v.hashCode();
    }

    public final String toString() {
        return "ThreadLocalKey(threadLocal=" + this.f12491v + ')';
    }
}
