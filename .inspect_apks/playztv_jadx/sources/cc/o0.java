package cc;

import java.util.Locale;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x0 f2684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ae.a f2685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g0 f2688e;

    public o0() {
        n0 n0Var = n0.C;
        this.f2684a = x0.f2725a;
        this.f2685b = n0Var;
        this.f2686c = a();
        this.f2687d = -1;
    }

    public final String a() {
        String string = ((UUID) this.f2685b.b()).toString();
        be.h.d(string, "uuidGenerator().toString()");
        String lowerCase = ie.n.K(string, "-", "").toLowerCase(Locale.ROOT);
        be.h.d(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    public final g0 b() {
        g0 g0Var = this.f2688e;
        if (g0Var != null) {
            return g0Var;
        }
        be.h.i("currentSession");
        throw null;
    }
}
