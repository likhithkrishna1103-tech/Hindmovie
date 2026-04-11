package w2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f13569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f13570b;

    public a0(c0 c0Var, c0 c0Var2) {
        this.f13569a = c0Var;
        this.f13570b = c0Var2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a0.class == obj.getClass()) {
            a0 a0Var = (a0) obj;
            if (this.f13569a.equals(a0Var.f13569a) && this.f13570b.equals(a0Var.f13570b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f13570b.hashCode() + (this.f13569a.hashCode() * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("[");
        c0 c0Var = this.f13569a;
        sb2.append(c0Var);
        c0 c0Var2 = this.f13570b;
        if (c0Var.equals(c0Var2)) {
            str = "";
        } else {
            str = ", " + c0Var2;
        }
        return l4.a.o(sb2, str, "]");
    }
}
