package be;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class c implements ge.a, Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public transient ge.a f2032u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f2033v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Class f2034w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f2035x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f2036y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f2037z;

    public c(Object obj, Class cls, String str, String str2, boolean z2) {
        this.f2033v = obj;
        this.f2034w = cls;
        this.f2035x = str;
        this.f2036y = str2;
        this.f2037z = z2;
    }

    public abstract ge.a c();

    public final d e() {
        boolean z2 = this.f2037z;
        Class cls = this.f2034w;
        if (!z2) {
            return o.a(cls);
        }
        o.f2046a.getClass();
        return new j(cls);
    }
}
