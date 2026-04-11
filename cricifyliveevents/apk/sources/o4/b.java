package o4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f9482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f9483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f9484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f9485e;

    public b(int i, float f, float f10, float f11, long j4) {
        this.f9481a = i;
        this.f9482b = f;
        this.f9483c = f10;
        this.f9484d = f11;
        this.f9485e = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            return this.f9483c == bVar.f9483c && this.f9484d == bVar.f9484d && this.f9482b == bVar.f9482b && this.f9481a == bVar.f9481a && this.f9485e == bVar.f9485e;
        }
        return false;
    }

    public final int hashCode() {
        int iFloatToIntBits = (((Float.floatToIntBits(this.f9482b) + ((Float.floatToIntBits(this.f9484d) + (Float.floatToIntBits(this.f9483c) * 31)) * 31)) * 31) + this.f9481a) * 31;
        long j4 = this.f9485e;
        return iFloatToIntBits + ((int) (j4 ^ (j4 >>> 32)));
    }

    public final String toString() {
        return "NavigationEvent(touchX=" + this.f9483c + ", touchY=" + this.f9484d + ", progress=" + this.f9482b + ", swipeEdge=" + this.f9481a + ", frameTimeMillis=" + this.f9485e + ')';
    }
}
