package pb;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f10160c = new h(0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10162b;

    public h(int i, int i10) {
        this.f10161a = i;
        this.f10162b = i10;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(h.class.getSimpleName());
        sb.append("[position = ");
        sb.append(this.f10161a);
        sb.append(", length = ");
        return q4.a.o(sb, this.f10162b, "]");
    }
}
