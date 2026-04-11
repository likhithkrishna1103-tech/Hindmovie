package va;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f13446c = new i(0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13448b;

    public i(int i, int i10) {
        this.f13447a = i;
        this.f13448b = i10;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i.class.getSimpleName());
        sb2.append("[position = ");
        sb2.append(this.f13447a);
        sb2.append(", length = ");
        return x.c.a(sb2, this.f13448b, "]");
    }
}
