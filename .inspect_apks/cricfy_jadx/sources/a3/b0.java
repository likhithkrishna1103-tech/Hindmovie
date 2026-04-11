package a3;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f147b;

    public b0(d0 d0Var, d0 d0Var2) {
        this.f146a = d0Var;
        this.f147b = d0Var2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b0.class == obj.getClass()) {
            b0 b0Var = (b0) obj;
            if (this.f146a.equals(b0Var.f146a) && this.f147b.equals(b0Var.f147b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f147b.hashCode() + (this.f146a.hashCode() * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("[");
        d0 d0Var = this.f146a;
        sb.append(d0Var);
        d0 d0Var2 = this.f147b;
        if (d0Var.equals(d0Var2)) {
            str = "";
        } else {
            str = ", " + d0Var2;
        }
        return q4.a.q(sb, str, "]");
    }
}
