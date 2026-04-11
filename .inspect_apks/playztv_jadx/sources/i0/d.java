package i0;

import android.graphics.Insets;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f6160e = new d(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6164d;

    public d(int i, int i10, int i11, int i12) {
        this.f6161a = i;
        this.f6162b = i10;
        this.f6163c = i11;
        this.f6164d = i12;
    }

    public static d a(d dVar, d dVar2) {
        return c(Math.max(dVar.f6161a, dVar2.f6161a), Math.max(dVar.f6162b, dVar2.f6162b), Math.max(dVar.f6163c, dVar2.f6163c), Math.max(dVar.f6164d, dVar2.f6164d));
    }

    public static d b(d dVar, d dVar2) {
        return c(Math.min(dVar.f6161a, dVar2.f6161a), Math.min(dVar.f6162b, dVar2.f6162b), Math.min(dVar.f6163c, dVar2.f6163c), Math.min(dVar.f6164d, dVar2.f6164d));
    }

    public static d c(int i, int i10, int i11, int i12) {
        return (i == 0 && i10 == 0 && i11 == 0 && i12 == 0) ? f6160e : new d(i, i10, i11, i12);
    }

    public static d d(Insets insets) {
        return c(insets.left, insets.top, insets.right, insets.bottom);
    }

    public final Insets e() {
        return a.c(this.f6161a, this.f6162b, this.f6163c, this.f6164d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f6164d == dVar.f6164d && this.f6161a == dVar.f6161a && this.f6163c == dVar.f6163c && this.f6162b == dVar.f6162b;
    }

    public final int hashCode() {
        return (((((this.f6161a * 31) + this.f6162b) * 31) + this.f6163c) * 31) + this.f6164d;
    }

    public final String toString() {
        return "Insets{left=" + this.f6161a + ", top=" + this.f6162b + ", right=" + this.f6163c + ", bottom=" + this.f6164d + '}';
    }
}
