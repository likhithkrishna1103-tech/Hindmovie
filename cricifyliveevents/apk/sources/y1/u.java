package y1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final u f14612c = new u(-1, -1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14614b;

    static {
        new u(0, 0);
    }

    public u(int i, int i10) {
        d.b((i == -1 || i >= 0) && (i10 == -1 || i10 >= 0));
        this.f14613a = i;
        this.f14614b = i10;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            if (this.f14613a == uVar.f14613a && this.f14614b == uVar.f14614b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f14613a;
        return ((i >>> 16) | (i << 16)) ^ this.f14614b;
    }

    public final String toString() {
        return this.f14613a + "x" + this.f14614b;
    }
}
