package p1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class x {
    public static final x i = new x(new w());

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f10092j = Integer.toString(0, 36);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f10093k = Integer.toString(1, 36);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f10094l = Integer.toString(2, 36);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f10095m = Integer.toString(3, 36);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f10096n = Integer.toString(4, 36);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f10097o = Integer.toString(5, 36);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f10098p = Integer.toString(6, 36);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f10099q = Integer.toString(7, 36);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f10100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f10101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f10102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f10103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f10104e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f10105g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f10106h;

    public x(w wVar) {
        this.f10100a = s1.b0.b0(wVar.f10087a);
        this.f10102c = s1.b0.b0(wVar.f10088b);
        this.f10101b = wVar.f10087a;
        this.f10103d = wVar.f10088b;
        this.f10104e = wVar.f10089c;
        this.f = wVar.f10090d;
        this.f10105g = wVar.f10091e;
        this.f10106h = wVar.f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return this.f10101b == xVar.f10101b && this.f10103d == xVar.f10103d && this.f10104e == xVar.f10104e && this.f == xVar.f && this.f10105g == xVar.f10105g && this.f10106h == xVar.f10106h;
    }

    public final int hashCode() {
        long j5 = this.f10101b;
        int i10 = ((int) (j5 ^ (j5 >>> 32))) * 31;
        long j8 = this.f10103d;
        return ((((((((i10 + ((int) ((j8 >>> 32) ^ j8))) * 31) + (this.f10104e ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + (this.f10105g ? 1 : 0)) * 31) + (this.f10106h ? 1 : 0);
    }
}
