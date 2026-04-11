package ua;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b1 extends m0 {
    public final transient int A;
    public final transient int B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final transient k0 f12303y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final transient Object[] f12304z;

    public b1(k0 k0Var, Object[] objArr, int i, int i10) {
        this.f12303y = k0Var;
        this.f12304z = objArr;
        this.A = i;
        this.B = i10;
    }

    @Override // ua.d0
    public final int b(int i, Object[] objArr) {
        return a().b(i, objArr);
    }

    @Override // ua.d0, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f12303y.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // ua.d0
    public final boolean g() {
        return true;
    }

    @Override // ua.d0
    /* JADX INFO: renamed from: h */
    public final n1 iterator() {
        return a().listIterator(0);
    }

    @Override // ua.m0
    public final i0 l() {
        return new a1(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.B;
    }
}
