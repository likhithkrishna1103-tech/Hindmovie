package l0;

import android.graphics.Insets;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f7601e = new c(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7605d;

    public c(int i, int i10, int i11, int i12) {
        this.f7602a = i;
        this.f7603b = i10;
        this.f7604c = i11;
        this.f7605d = i12;
    }

    public static c a(c cVar, c cVar2) {
        return c(Math.max(cVar.f7602a, cVar2.f7602a), Math.max(cVar.f7603b, cVar2.f7603b), Math.max(cVar.f7604c, cVar2.f7604c), Math.max(cVar.f7605d, cVar2.f7605d));
    }

    public static c b(c cVar, c cVar2) {
        return c(Math.min(cVar.f7602a, cVar2.f7602a), Math.min(cVar.f7603b, cVar2.f7603b), Math.min(cVar.f7604c, cVar2.f7604c), Math.min(cVar.f7605d, cVar2.f7605d));
    }

    public static c c(int i, int i10, int i11, int i12) {
        return (i == 0 && i10 == 0 && i11 == 0 && i12 == 0) ? f7601e : new c(i, i10, i11, i12);
    }

    public static c d(Insets insets) {
        return c(insets.left, insets.top, insets.right, insets.bottom);
    }

    public final Insets e() {
        return a.c(this.f7602a, this.f7603b, this.f7604c, this.f7605d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f7605d == cVar.f7605d && this.f7602a == cVar.f7602a && this.f7604c == cVar.f7604c && this.f7603b == cVar.f7603b;
    }

    public final int hashCode() {
        return (((((this.f7602a * 31) + this.f7603b) * 31) + this.f7604c) * 31) + this.f7605d;
    }

    public final String toString() {
        return "Insets{left=" + this.f7602a + ", top=" + this.f7603b + ", right=" + this.f7604c + ", bottom=" + this.f7605d + '}';
    }
}
