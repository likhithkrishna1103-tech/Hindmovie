package h2;

import java.util.Objects;
import s2.c0;
import v1.f1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f5480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f1 f5481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0 f5483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f5484e;
    public final f1 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f5485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c0 f5486h;
    public final long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f5487j;

    public a(long j4, f1 f1Var, int i, c0 c0Var, long j7, f1 f1Var2, int i10, c0 c0Var2, long j10, long j11) {
        this.f5480a = j4;
        this.f5481b = f1Var;
        this.f5482c = i;
        this.f5483d = c0Var;
        this.f5484e = j7;
        this.f = f1Var2;
        this.f5485g = i10;
        this.f5486h = c0Var2;
        this.i = j10;
        this.f5487j = j11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f5480a == aVar.f5480a && this.f5482c == aVar.f5482c && this.f5484e == aVar.f5484e && this.f5485g == aVar.f5485g && this.i == aVar.i && this.f5487j == aVar.f5487j && Objects.equals(this.f5481b, aVar.f5481b) && Objects.equals(this.f5483d, aVar.f5483d) && Objects.equals(this.f, aVar.f) && Objects.equals(this.f5486h, aVar.f5486h)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.f5480a), this.f5481b, Integer.valueOf(this.f5482c), this.f5483d, Long.valueOf(this.f5484e), this.f, Integer.valueOf(this.f5485g), this.f5486h, Long.valueOf(this.i), Long.valueOf(this.f5487j));
    }
}
