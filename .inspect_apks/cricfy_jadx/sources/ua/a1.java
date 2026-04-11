package ua;

import java.util.AbstractMap;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a1 extends i0 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ b1 f12301x;

    public a1(b1 b1Var) {
        this.f12301x = b1Var;
    }

    @Override // ua.d0
    public final boolean g() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        b1 b1Var = this.f12301x;
        com.bumptech.glide.d.g(i, b1Var.B);
        Object[] objArr = b1Var.f12304z;
        int i10 = i * 2;
        int i11 = b1Var.A;
        Object obj = objArr[i10 + i11];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[i10 + (i11 ^ 1)];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f12301x.B;
    }
}
