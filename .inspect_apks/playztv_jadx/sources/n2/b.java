package n2;

import java.util.List;
import p1.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f8643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8645e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f8646g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f8647h;
    public final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final q[] f8648j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f8649k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f8650l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f8651m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List f8652n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long[] f8653o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f8654p;

    public b(String str, String str2, int i, String str3, long j5, String str4, int i10, int i11, int i12, int i13, String str5, q[] qVarArr, List list, long[] jArr, long j8) {
        this.f8650l = str;
        this.f8651m = str2;
        this.f8641a = i;
        this.f8642b = str3;
        this.f8643c = j5;
        this.f8644d = str4;
        this.f8645e = i10;
        this.f = i11;
        this.f8646g = i12;
        this.f8647h = i13;
        this.i = str5;
        this.f8648j = qVarArr;
        this.f8652n = list;
        this.f8653o = jArr;
        this.f8654p = j8;
        this.f8649k = list.size();
    }

    public final b a(q[] qVarArr) {
        return new b(this.f8650l, this.f8651m, this.f8641a, this.f8642b, this.f8643c, this.f8644d, this.f8645e, this.f, this.f8646g, this.f8647h, this.i, qVarArr, this.f8652n, this.f8653o, this.f8654p);
    }

    public final long b(int i) {
        if (i == this.f8649k - 1) {
            return this.f8654p;
        }
        long[] jArr = this.f8653o;
        return jArr[i + 1] - jArr[i];
    }
}
