package kf;

import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b0 implements Closeable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a0 f7439v;

    static {
        ag.h hVar = ag.h.f430y;
        ge.i.e(hVar, "<this>");
        ag.e eVar = new ag.e();
        eVar.g0(hVar);
        f7439v = new a0(hVar.f431v.length, eVar);
    }

    public abstract long a();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        lf.d.b(q());
    }

    public abstract s g();

    public abstract ag.g q();
}
