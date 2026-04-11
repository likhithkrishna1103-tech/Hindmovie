package ua;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f12345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f12347c;

    public j0(Object obj, Object obj2, Object obj3) {
        this.f12345a = obj;
        this.f12346b = obj2;
        this.f12347c = obj3;
    }

    public final IllegalArgumentException a() {
        StringBuilder sb = new StringBuilder("Multiple entries with same key: ");
        Object obj = this.f12345a;
        sb.append(obj);
        sb.append("=");
        sb.append(this.f12346b);
        sb.append(" and ");
        sb.append(obj);
        sb.append("=");
        sb.append(this.f12347c);
        return new IllegalArgumentException(sb.toString());
    }
}
