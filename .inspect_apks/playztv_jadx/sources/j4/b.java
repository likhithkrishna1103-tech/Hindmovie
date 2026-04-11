package j4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f6771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f6772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f6773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f6774e;

    public b(int i, float f, float f4, float f10, long j5) {
        this.f6770a = i;
        this.f6771b = f;
        this.f6772c = f4;
        this.f6773d = f10;
        this.f6774e = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            return this.f6772c == bVar.f6772c && this.f6773d == bVar.f6773d && this.f6771b == bVar.f6771b && this.f6770a == bVar.f6770a && this.f6774e == bVar.f6774e;
        }
        return false;
    }

    public final int hashCode() {
        int iFloatToIntBits = (((Float.floatToIntBits(this.f6771b) + ((Float.floatToIntBits(this.f6773d) + (Float.floatToIntBits(this.f6772c) * 31)) * 31)) * 31) + this.f6770a) * 31;
        long j5 = this.f6774e;
        return iFloatToIntBits + ((int) (j5 ^ (j5 >>> 32)));
    }

    public final String toString() {
        return "NavigationEvent(touchX=" + this.f6772c + ", touchY=" + this.f6773d + ", progress=" + this.f6771b + ", swipeEdge=" + this.f6770a + ", frameTimeMillis=" + this.f6774e + ')';
    }
}
