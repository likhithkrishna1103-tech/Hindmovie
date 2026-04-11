package g4;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p1 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final p1.v0 f5158k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final p1 f5159l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f5160m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f5161n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f5162o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f5163p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f5164q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f5165r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f5166s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f5167t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f5168u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f5169v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p1.v0 f5170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f5173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f5174e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f5175g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f5176h;
    public final long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f5177j;

    static {
        p1.v0 v0Var = new p1.v0(null, 0, null, null, 0, 0L, 0L, -1, -1);
        f5158k = v0Var;
        f5159l = new p1(v0Var, false, -9223372036854775807L, -9223372036854775807L, 0L, 0, 0L, -9223372036854775807L, -9223372036854775807L, 0L);
        int i = s1.b0.f11647a;
        f5160m = Integer.toString(0, 36);
        f5161n = Integer.toString(1, 36);
        f5162o = Integer.toString(2, 36);
        f5163p = Integer.toString(3, 36);
        f5164q = Integer.toString(4, 36);
        f5165r = Integer.toString(5, 36);
        f5166s = Integer.toString(6, 36);
        f5167t = Integer.toString(7, 36);
        f5168u = Integer.toString(8, 36);
        f5169v = Integer.toString(9, 36);
    }

    public p1(p1.v0 v0Var, boolean z2, long j5, long j8, long j10, int i, long j11, long j12, long j13, long j14) {
        s1.d.b(z2 == (v0Var.f10086h != -1));
        this.f5170a = v0Var;
        this.f5171b = z2;
        this.f5172c = j5;
        this.f5173d = j8;
        this.f5174e = j10;
        this.f = i;
        this.f5175g = j11;
        this.f5176h = j12;
        this.i = j13;
        this.f5177j = j14;
    }

    public final p1 a(boolean z2, boolean z10) {
        if (z2 && z10) {
            return this;
        }
        return new p1(this.f5170a.b(z2, z10), z2 && this.f5171b, this.f5172c, z2 ? this.f5173d : -9223372036854775807L, z2 ? this.f5174e : 0L, z2 ? this.f : 0, z2 ? this.f5175g : 0L, z2 ? this.f5176h : -9223372036854775807L, z2 ? this.i : -9223372036854775807L, z2 ? this.f5177j : 0L);
    }

    public final Bundle b(int i) {
        Bundle bundle = new Bundle();
        p1.v0 v0Var = this.f5170a;
        if (i < 3 || !f5158k.a(v0Var)) {
            bundle.putBundle(f5160m, v0Var.c(i));
        }
        boolean z2 = this.f5171b;
        if (z2) {
            bundle.putBoolean(f5161n, z2);
        }
        long j5 = this.f5172c;
        if (j5 != -9223372036854775807L) {
            bundle.putLong(f5162o, j5);
        }
        long j8 = this.f5173d;
        if (j8 != -9223372036854775807L) {
            bundle.putLong(f5163p, j8);
        }
        long j10 = this.f5174e;
        if (i < 3 || j10 != 0) {
            bundle.putLong(f5164q, j10);
        }
        int i10 = this.f;
        if (i10 != 0) {
            bundle.putInt(f5165r, i10);
        }
        long j11 = this.f5175g;
        if (j11 != 0) {
            bundle.putLong(f5166s, j11);
        }
        long j12 = this.f5176h;
        if (j12 != -9223372036854775807L) {
            bundle.putLong(f5167t, j12);
        }
        long j13 = this.i;
        if (j13 != -9223372036854775807L) {
            bundle.putLong(f5168u, j13);
        }
        long j14 = this.f5177j;
        if (i >= 3 && j14 == 0) {
            return bundle;
        }
        bundle.putLong(f5169v, j14);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && p1.class == obj.getClass()) {
            p1 p1Var = (p1) obj;
            if (this.f5172c == p1Var.f5172c && this.f5170a.equals(p1Var.f5170a) && this.f5171b == p1Var.f5171b && this.f5173d == p1Var.f5173d && this.f5174e == p1Var.f5174e && this.f == p1Var.f && this.f5175g == p1Var.f5175g && this.f5176h == p1Var.f5176h && this.i == p1Var.i && this.f5177j == p1Var.f5177j) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f5170a, Boolean.valueOf(this.f5171b));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("SessionPositionInfo {PositionInfo {mediaItemIndex=");
        p1.v0 v0Var = this.f5170a;
        sb2.append(v0Var.f10081b);
        sb2.append(", periodIndex=");
        sb2.append(v0Var.f10084e);
        sb2.append(", positionMs=");
        sb2.append(v0Var.f);
        sb2.append(", contentPositionMs=");
        sb2.append(v0Var.f10085g);
        sb2.append(", adGroupIndex=");
        sb2.append(v0Var.f10086h);
        sb2.append(", adIndexInAdGroup=");
        sb2.append(v0Var.i);
        sb2.append("}, isPlayingAd=");
        sb2.append(this.f5171b);
        sb2.append(", eventTimeMs=");
        sb2.append(this.f5172c);
        sb2.append(", durationMs=");
        sb2.append(this.f5173d);
        sb2.append(", bufferedPositionMs=");
        sb2.append(this.f5174e);
        sb2.append(", bufferedPercentage=");
        sb2.append(this.f);
        sb2.append(", totalBufferedDurationMs=");
        sb2.append(this.f5175g);
        sb2.append(", currentLiveOffsetMs=");
        sb2.append(this.f5176h);
        sb2.append(", contentDurationMs=");
        sb2.append(this.i);
        sb2.append(", contentBufferedPositionMs=");
        return l4.a.n(sb2, this.f5177j, "}");
    }
}
