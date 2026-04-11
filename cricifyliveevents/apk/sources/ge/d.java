package ge;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d implements le.a, Serializable {
    public final boolean A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public transient le.a f5242v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f5243w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Class f5244x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f5245y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f5246z;

    public d(Object obj, Class cls, String str, String str2, boolean z10) {
        this.f5243w = obj;
        this.f5244x = cls;
        this.f5245y = str;
        this.f5246z = str2;
        this.A = z10;
    }

    public abstract le.a c();

    public final e d() {
        boolean z10 = this.A;
        Class cls = this.f5244x;
        if (!z10) {
            return q.a(cls);
        }
        q.f5255a.getClass();
        return new k(cls);
    }
}
