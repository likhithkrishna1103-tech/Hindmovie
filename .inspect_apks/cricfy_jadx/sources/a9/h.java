package a9;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends g {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final h f369z = new h(0, new Object[0]);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final transient Object[] f370x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final transient int f371y;

    public h(int i, Object[] objArr) {
        this.f370x = objArr;
        this.f371y = i;
    }

    @Override // a9.c
    public final Object[] a() {
        return this.f370x;
    }

    @Override // a9.c
    public final int b() {
        return 0;
    }

    @Override // a9.c
    public final int c() {
        return this.f371y;
    }

    @Override // a9.g, a9.c
    public final int d(Object[] objArr) {
        Object[] objArr2 = this.f370x;
        int i = this.f371y;
        System.arraycopy(objArr2, 0, objArr, 0, i);
        return i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        sd.i.J(i, this.f371y);
        Object obj = this.f370x[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f371y;
    }
}
