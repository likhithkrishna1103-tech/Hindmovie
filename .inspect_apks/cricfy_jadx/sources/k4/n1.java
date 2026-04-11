package k4;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n1 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final v1.v0 f7094k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final n1 f7095l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f7096m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f7097n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f7098o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f7099p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f7100q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f7101r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f7102s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f7103t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f7104u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f7105v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v1.v0 f7106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f7107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f7108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f7109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f7110e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f7111g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f7112h;
    public final long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f7113j;

    static {
        v1.v0 v0Var = new v1.v0(null, 0, null, null, 0, 0L, 0L, -1, -1);
        f7094k = v0Var;
        f7095l = new n1(v0Var, false, -9223372036854775807L, -9223372036854775807L, 0L, 0, 0L, -9223372036854775807L, -9223372036854775807L, 0L);
        int i = y1.a0.f14551a;
        f7096m = Integer.toString(0, 36);
        f7097n = Integer.toString(1, 36);
        f7098o = Integer.toString(2, 36);
        f7099p = Integer.toString(3, 36);
        f7100q = Integer.toString(4, 36);
        f7101r = Integer.toString(5, 36);
        f7102s = Integer.toString(6, 36);
        f7103t = Integer.toString(7, 36);
        f7104u = Integer.toString(8, 36);
        f7105v = Integer.toString(9, 36);
    }

    public n1(v1.v0 v0Var, boolean z10, long j4, long j7, long j10, int i, long j11, long j12, long j13, long j14) {
        y1.d.b(z10 == (v0Var.f13019h != -1));
        this.f7106a = v0Var;
        this.f7107b = z10;
        this.f7108c = j4;
        this.f7109d = j7;
        this.f7110e = j10;
        this.f = i;
        this.f7111g = j11;
        this.f7112h = j12;
        this.i = j13;
        this.f7113j = j14;
    }

    public final n1 a(boolean z10, boolean z11) {
        if (z10 && z11) {
            return this;
        }
        return new n1(this.f7106a.b(z10, z11), z10 && this.f7107b, this.f7108c, z10 ? this.f7109d : -9223372036854775807L, z10 ? this.f7110e : 0L, z10 ? this.f : 0, z10 ? this.f7111g : 0L, z10 ? this.f7112h : -9223372036854775807L, z10 ? this.i : -9223372036854775807L, z10 ? this.f7113j : 0L);
    }

    public final Bundle b(int i) {
        Bundle bundle = new Bundle();
        v1.v0 v0Var = this.f7106a;
        if (i < 3 || !f7094k.a(v0Var)) {
            bundle.putBundle(f7096m, v0Var.c(i));
        }
        boolean z10 = this.f7107b;
        if (z10) {
            bundle.putBoolean(f7097n, z10);
        }
        long j4 = this.f7108c;
        if (j4 != -9223372036854775807L) {
            bundle.putLong(f7098o, j4);
        }
        long j7 = this.f7109d;
        if (j7 != -9223372036854775807L) {
            bundle.putLong(f7099p, j7);
        }
        long j10 = this.f7110e;
        if (i < 3 || j10 != 0) {
            bundle.putLong(f7100q, j10);
        }
        int i10 = this.f;
        if (i10 != 0) {
            bundle.putInt(f7101r, i10);
        }
        long j11 = this.f7111g;
        if (j11 != 0) {
            bundle.putLong(f7102s, j11);
        }
        long j12 = this.f7112h;
        if (j12 != -9223372036854775807L) {
            bundle.putLong(f7103t, j12);
        }
        long j13 = this.i;
        if (j13 != -9223372036854775807L) {
            bundle.putLong(f7104u, j13);
        }
        long j14 = this.f7113j;
        if (i >= 3 && j14 == 0) {
            return bundle;
        }
        bundle.putLong(f7105v, j14);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && n1.class == obj.getClass()) {
            n1 n1Var = (n1) obj;
            if (this.f7108c == n1Var.f7108c && this.f7106a.equals(n1Var.f7106a) && this.f7107b == n1Var.f7107b && this.f7109d == n1Var.f7109d && this.f7110e == n1Var.f7110e && this.f == n1Var.f && this.f7111g == n1Var.f7111g && this.f7112h == n1Var.f7112h && this.i == n1Var.i && this.f7113j == n1Var.f7113j) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f7106a, Boolean.valueOf(this.f7107b));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SessionPositionInfo {PositionInfo {mediaItemIndex=");
        v1.v0 v0Var = this.f7106a;
        sb.append(v0Var.f13014b);
        sb.append(", periodIndex=");
        sb.append(v0Var.f13017e);
        sb.append(", positionMs=");
        sb.append(v0Var.f);
        sb.append(", contentPositionMs=");
        sb.append(v0Var.f13018g);
        sb.append(", adGroupIndex=");
        sb.append(v0Var.f13019h);
        sb.append(", adIndexInAdGroup=");
        sb.append(v0Var.i);
        sb.append("}, isPlayingAd=");
        sb.append(this.f7107b);
        sb.append(", eventTimeMs=");
        sb.append(this.f7108c);
        sb.append(", durationMs=");
        sb.append(this.f7109d);
        sb.append(", bufferedPositionMs=");
        sb.append(this.f7110e);
        sb.append(", bufferedPercentage=");
        sb.append(this.f);
        sb.append(", totalBufferedDurationMs=");
        sb.append(this.f7111g);
        sb.append(", currentLiveOffsetMs=");
        sb.append(this.f7112h);
        sb.append(", contentDurationMs=");
        sb.append(this.i);
        sb.append(", contentBufferedPositionMs=");
        return q4.a.p(sb, this.f7113j, "}");
    }
}
