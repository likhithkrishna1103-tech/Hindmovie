package ag;

import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends sd.d implements RandomAccess {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h[] f446v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int[] f447w;

    public m(h[] hVarArr, int[] iArr) {
        this.f446v = hVarArr;
        this.f447w = iArr;
    }

    @Override // sd.a
    public final int a() {
        return this.f446v.length;
    }

    @Override // sd.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof h) {
            return super.contains((h) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i) {
        return this.f446v[i];
    }

    @Override // sd.d, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof h) {
            return super.indexOf((h) obj);
        }
        return -1;
    }

    @Override // sd.d, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof h) {
            return super.lastIndexOf((h) obj);
        }
        return -1;
    }
}
