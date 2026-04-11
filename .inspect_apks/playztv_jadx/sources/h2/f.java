package h2;

import aa.c1;
import aa.j0;
import android.net.Uri;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f5686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f5687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f5688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f5689e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f5690g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List f5691h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f5692j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f5693k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final j0 f5694l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final j0 f5695m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c1 f5696n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f5697o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f5698p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f5699q;

    public f(String str, Uri uri, Uri uri2, long j5, long j8, long j10, long j11, ArrayList arrayList, boolean z2, long j12, long j13, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, boolean z10, String str2, String str3) {
        s1.d.b((uri == null || uri2 == null) && !(uri == null && uri2 == null));
        this.f5685a = str;
        this.f5686b = uri;
        this.f5687c = uri2;
        this.f5688d = j5;
        this.f5689e = j8;
        this.f = j10;
        this.f5690g = j11;
        this.f5691h = arrayList;
        this.i = z2;
        this.f5692j = j12;
        this.f5693k = j13;
        this.f5694l = j0.r(arrayList2);
        this.f5695m = j0.r(arrayList3);
        this.f5696n = j0.x(new c4.d(3), arrayList4);
        this.f5697o = z10;
        this.f5698p = str2;
        this.f5699q = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f5688d == fVar.f5688d && this.f5689e == fVar.f5689e && this.f == fVar.f && this.f5690g == fVar.f5690g && this.i == fVar.i && this.f5692j == fVar.f5692j && this.f5693k == fVar.f5693k && this.f5697o == fVar.f5697o && Objects.equals(this.f5685a, fVar.f5685a) && Objects.equals(this.f5686b, fVar.f5686b) && Objects.equals(this.f5687c, fVar.f5687c) && Objects.equals(this.f5691h, fVar.f5691h) && Objects.equals(this.f5694l, fVar.f5694l) && Objects.equals(this.f5695m, fVar.f5695m) && Objects.equals(this.f5696n, fVar.f5696n) && Objects.equals(this.f5698p, fVar.f5698p) && Objects.equals(this.f5699q, fVar.f5699q);
    }

    public final int hashCode() {
        return Objects.hash(this.f5685a, this.f5686b, this.f5687c, Long.valueOf(this.f5688d), Long.valueOf(this.f5689e), Long.valueOf(this.f), Long.valueOf(this.f5690g), this.f5691h, Boolean.valueOf(this.i), Long.valueOf(this.f5692j), Long.valueOf(this.f5693k), this.f5694l, this.f5695m, this.f5696n, Boolean.valueOf(this.f5697o), this.f5698p, this.f5699q);
    }
}
