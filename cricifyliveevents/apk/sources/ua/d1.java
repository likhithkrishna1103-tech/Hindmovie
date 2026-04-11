package ua;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d1 extends i0 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final transient Object[] f12319x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final transient int f12320y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final transient int f12321z;

    public d1(Object[] objArr, int i, int i10) {
        this.f12319x = objArr;
        this.f12320y = i;
        this.f12321z = i10;
    }

    @Override // ua.d0
    public final boolean g() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        com.bumptech.glide.d.g(i, this.f12321z);
        Object obj = this.f12319x[(i * 2) + this.f12320y];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f12321z;
    }
}
