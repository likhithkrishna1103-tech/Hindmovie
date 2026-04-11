package v;

import java.util.ConcurrentModificationException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f12532a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f12533b = new Object();

    public static final void a(l lVar) {
        int i = lVar.f12546y;
        int[] iArr = lVar.f12544w;
        Object[] objArr = lVar.f12545x;
        int i10 = 0;
        for (int i11 = 0; i11 < i; i11++) {
            Object obj = objArr[i11];
            if (obj != f12533b) {
                if (i11 != i10) {
                    iArr[i10] = iArr[i11];
                    objArr[i10] = obj;
                    objArr[i11] = null;
                }
                i10++;
            }
        }
        lVar.f12543v = false;
        lVar.f12546y = i10;
    }

    public static final void b(f fVar, int i) {
        fVar.f12521v = new int[i];
        fVar.f12522w = new Object[i];
    }

    public static final int c(f fVar, Object obj, int i) {
        int i10 = fVar.f12523x;
        if (i10 == 0) {
            return -1;
        }
        try {
            int iA = w.a.a(i10, i, fVar.f12521v);
            if (iA < 0 || ge.i.a(obj, fVar.f12522w[iA])) {
                return iA;
            }
            int i11 = iA + 1;
            while (i11 < i10 && fVar.f12521v[i11] == i) {
                if (ge.i.a(obj, fVar.f12522w[i11])) {
                    return i11;
                }
                i11++;
            }
            for (int i12 = iA - 1; i12 >= 0 && fVar.f12521v[i12] == i; i12--) {
                if (ge.i.a(obj, fVar.f12522w[i12])) {
                    return i12;
                }
            }
            return ~i11;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }
}
