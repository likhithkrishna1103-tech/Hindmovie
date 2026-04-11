package kf;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f7580a = 0;

    static {
        ge.i.e(ag.h.f430y, "<this>");
    }

    public static final w c(byte[] bArr) {
        ge.i.e(bArr, "<this>");
        int length = bArr.length;
        lf.d.a(bArr.length, 0, length);
        return new w(null, length, bArr);
    }

    public abstract long a();

    public abstract s b();

    public abstract void d(ag.p pVar);
}
