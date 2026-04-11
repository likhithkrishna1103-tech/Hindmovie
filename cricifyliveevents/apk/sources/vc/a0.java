package vc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {
    public static final z Companion = new z();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13566b;

    public /* synthetic */ a0(int i, int i10, String str) {
        if (3 != (i & 3)) {
            df.k.a(i, 3, y.f13714a.d());
            throw null;
        }
        this.f13565a = i10;
        this.f13566b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return this.f13565a == a0Var.f13565a && ge.i.a(this.f13566b, a0Var.f13566b);
    }

    public final int hashCode() {
        return this.f13566b.hashCode() + (this.f13565a * 31);
    }

    public final String toString() {
        return "ProcessData(pid=" + this.f13565a + ", uuid=" + this.f13566b + ')';
    }

    public a0(int i, String str) {
        ge.i.e(str, "uuid");
        this.f13565a = i;
        this.f13566b = str;
    }
}
