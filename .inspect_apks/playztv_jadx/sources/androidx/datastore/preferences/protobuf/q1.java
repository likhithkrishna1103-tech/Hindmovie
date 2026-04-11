package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q1 extends r1 {
    @Override // androidx.datastore.preferences.protobuf.r1
    public final boolean c(long j5, Object obj) {
        return this.f1110a.getBoolean(obj, j5);
    }

    @Override // androidx.datastore.preferences.protobuf.r1
    public final byte d(long j5, Object obj) {
        return this.f1110a.getByte(obj, j5);
    }

    @Override // androidx.datastore.preferences.protobuf.r1
    public final double e(long j5, Object obj) {
        return this.f1110a.getDouble(obj, j5);
    }

    @Override // androidx.datastore.preferences.protobuf.r1
    public final float f(long j5, Object obj) {
        return this.f1110a.getFloat(obj, j5);
    }

    @Override // androidx.datastore.preferences.protobuf.r1
    public final void k(Object obj, long j5, boolean z2) {
        this.f1110a.putBoolean(obj, j5, z2);
    }

    @Override // androidx.datastore.preferences.protobuf.r1
    public final void l(Object obj, long j5, byte b10) {
        this.f1110a.putByte(obj, j5, b10);
    }

    @Override // androidx.datastore.preferences.protobuf.r1
    public final void m(Object obj, long j5, double d10) {
        this.f1110a.putDouble(obj, j5, d10);
    }

    @Override // androidx.datastore.preferences.protobuf.r1
    public final void n(Object obj, long j5, float f) {
        this.f1110a.putFloat(obj, j5, f);
    }
}
