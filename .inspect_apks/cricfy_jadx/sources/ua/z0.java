package ua;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z0 extends i0 {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final z0 f12413z = new z0(0, new Object[0]);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final transient Object[] f12414x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final transient int f12415y;

    public z0(int i, Object[] objArr) {
        this.f12414x = objArr;
        this.f12415y = i;
    }

    @Override // ua.i0, ua.d0
    public final int b(int i, Object[] objArr) {
        Object[] objArr2 = this.f12414x;
        int i10 = this.f12415y;
        System.arraycopy(objArr2, 0, objArr, i, i10);
        return i + i10;
    }

    @Override // ua.d0
    public final Object[] c() {
        return this.f12414x;
    }

    @Override // ua.d0
    public final int d() {
        return this.f12415y;
    }

    @Override // ua.d0
    public final int f() {
        return 0;
    }

    @Override // ua.d0
    public final boolean g() {
        return false;
    }

    @Override // java.util.List
    public final Object get(int i) {
        com.bumptech.glide.d.g(i, this.f12415y);
        Object obj = this.f12414x[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f12415y;
    }
}
