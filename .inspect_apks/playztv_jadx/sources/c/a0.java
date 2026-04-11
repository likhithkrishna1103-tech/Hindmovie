package c;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.fragment.app.f0 f2148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f2149b;

    public a0(androidx.fragment.app.f0 f0Var, androidx.lifecycle.s sVar) {
        be.h.e(f0Var, "callback");
        this.f2148a = f0Var;
        this.f2149b = sVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return be.h.a(this.f2148a, a0Var.f2148a) && this.f2149b.equals(a0Var.f2149b);
    }

    public final int hashCode() {
        return this.f2149b.hashCode() + (this.f2148a.hashCode() * 31);
    }

    public final String toString() {
        return "OnBackPressedCallbackInfo(callback=" + this.f2148a + ", owner=" + this.f2149b + ')';
    }
}
