package v1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class w {
    public static final w i = new w(new v());

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f13020j = Integer.toString(0, 36);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f13021k = Integer.toString(1, 36);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f13022l = Integer.toString(2, 36);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f13023m = Integer.toString(3, 36);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f13024n = Integer.toString(4, 36);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f13025o = Integer.toString(5, 36);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f13026p = Integer.toString(6, 36);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f13027q = Integer.toString(7, 36);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f13029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f13030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f13031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f13032e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f13033g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f13034h;

    public w(v vVar) {
        this.f13028a = y1.a0.b0(vVar.f13001a);
        this.f13030c = y1.a0.b0(vVar.f13002b);
        this.f13029b = vVar.f13001a;
        this.f13031d = vVar.f13002b;
        this.f13032e = vVar.f13003c;
        this.f = vVar.f13004d;
        this.f13033g = vVar.f13005e;
        this.f13034h = vVar.f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f13029b == wVar.f13029b && this.f13031d == wVar.f13031d && this.f13032e == wVar.f13032e && this.f == wVar.f && this.f13033g == wVar.f13033g && this.f13034h == wVar.f13034h;
    }

    public final int hashCode() {
        long j4 = this.f13029b;
        int i10 = ((int) (j4 ^ (j4 >>> 32))) * 31;
        long j7 = this.f13031d;
        return ((((((((i10 + ((int) ((j7 >>> 32) ^ j7))) * 31) + (this.f13032e ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + (this.f13033g ? 1 : 0)) * 31) + (this.f13034h ? 1 : 0);
    }
}
