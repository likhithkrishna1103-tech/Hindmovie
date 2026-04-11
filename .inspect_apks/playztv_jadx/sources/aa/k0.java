package aa;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f695c;

    public k0(Object obj, Object obj2, Object obj3) {
        this.f693a = obj;
        this.f694b = obj2;
        this.f695c = obj3;
    }

    public final IllegalArgumentException a() {
        StringBuilder sb2 = new StringBuilder("Multiple entries with same key: ");
        Object obj = this.f693a;
        sb2.append(obj);
        sb2.append("=");
        sb2.append(this.f694b);
        sb2.append(" and ");
        sb2.append(obj);
        sb2.append("=");
        sb2.append(this.f695c);
        return new IllegalArgumentException(sb2.toString());
    }
}
