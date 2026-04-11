package n2;

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import ua.i0;
import ua.z0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f8662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f8663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f8664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f8665e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f8666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List f8667h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f8668j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f8669k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i0 f8670l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final i0 f8671m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final z0 f8672n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f8673o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f8674p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f8675q;

    public f(String str, Uri uri, Uri uri2, long j4, long j7, long j10, long j11, ArrayList arrayList, boolean z10, long j12, long j13, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, boolean z11, String str2, String str3) {
        y1.d.b((uri == null || uri2 == null) && !(uri == null && uri2 == null));
        this.f8661a = str;
        this.f8662b = uri;
        this.f8663c = uri2;
        this.f8664d = j4;
        this.f8665e = j7;
        this.f = j10;
        this.f8666g = j11;
        this.f8667h = arrayList;
        this.i = z10;
        this.f8668j = j12;
        this.f8669k = j13;
        this.f8670l = i0.k(arrayList2);
        this.f8671m = i0.k(arrayList3);
        this.f8672n = i0.r(new g4.d(5), arrayList4);
        this.f8673o = z11;
        this.f8674p = str2;
        this.f8675q = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f8664d == fVar.f8664d && this.f8665e == fVar.f8665e && this.f == fVar.f && this.f8666g == fVar.f8666g && this.i == fVar.i && this.f8668j == fVar.f8668j && this.f8669k == fVar.f8669k && this.f8673o == fVar.f8673o && Objects.equals(this.f8661a, fVar.f8661a) && Objects.equals(this.f8662b, fVar.f8662b) && Objects.equals(this.f8663c, fVar.f8663c) && Objects.equals(this.f8667h, fVar.f8667h) && Objects.equals(this.f8670l, fVar.f8670l) && Objects.equals(this.f8671m, fVar.f8671m) && Objects.equals(this.f8672n, fVar.f8672n) && Objects.equals(this.f8674p, fVar.f8674p) && Objects.equals(this.f8675q, fVar.f8675q);
    }

    public final int hashCode() {
        return Objects.hash(this.f8661a, this.f8662b, this.f8663c, Long.valueOf(this.f8664d), Long.valueOf(this.f8665e), Long.valueOf(this.f), Long.valueOf(this.f8666g), this.f8667h, Boolean.valueOf(this.i), Long.valueOf(this.f8668j), Long.valueOf(this.f8669k), this.f8670l, this.f8671m, this.f8672n, Boolean.valueOf(this.f8673o), this.f8674p, this.f8675q);
    }
}
