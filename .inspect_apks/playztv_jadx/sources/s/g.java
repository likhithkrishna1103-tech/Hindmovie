package s;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Cloneable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public /* synthetic */ boolean f11627u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public /* synthetic */ long[] f11628v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public /* synthetic */ Object[] f11629w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public /* synthetic */ int f11630x;

    public g(int i) {
        if (i == 0) {
            this.f11628v = t.a.f11960b;
            this.f11629w = t.a.f11961c;
            return;
        }
        int i10 = i * 8;
        int i11 = 4;
        while (true) {
            if (i11 >= 32) {
                break;
            }
            int i12 = (1 << i11) - 12;
            if (i10 <= i12) {
                i10 = i12;
                break;
            }
            i11++;
        }
        int i13 = i10 / 8;
        this.f11628v = new long[i13];
        this.f11629w = new Object[i13];
    }

    public final void a(long j5, Long l10) {
        int i = this.f11630x;
        if (i != 0 && j5 <= this.f11628v[i - 1]) {
            h(j5, l10);
            return;
        }
        if (this.f11627u) {
            long[] jArr = this.f11628v;
            if (i >= jArr.length) {
                Object[] objArr = this.f11629w;
                int i10 = 0;
                for (int i11 = 0; i11 < i; i11++) {
                    Object obj = objArr[i11];
                    if (obj != h.f11631a) {
                        if (i11 != i10) {
                            jArr[i10] = jArr[i11];
                            objArr[i10] = obj;
                            objArr[i11] = null;
                        }
                        i10++;
                    }
                }
                this.f11627u = false;
                this.f11630x = i10;
            }
        }
        int i12 = this.f11630x;
        if (i12 >= this.f11628v.length) {
            int i13 = (i12 + 1) * 8;
            int i14 = 4;
            while (true) {
                if (i14 >= 32) {
                    break;
                }
                int i15 = (1 << i14) - 12;
                if (i13 <= i15) {
                    i13 = i15;
                    break;
                }
                i14++;
            }
            int i16 = i13 / 8;
            long[] jArrCopyOf = Arrays.copyOf(this.f11628v, i16);
            be.h.d(jArrCopyOf, "copyOf(this, newSize)");
            this.f11628v = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f11629w, i16);
            be.h.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f11629w = objArrCopyOf;
        }
        this.f11628v[i12] = j5;
        this.f11629w[i12] = l10;
        this.f11630x = i12 + 1;
    }

    public final void b() {
        int i = this.f11630x;
        Object[] objArr = this.f11629w;
        for (int i10 = 0; i10 < i; i10++) {
            objArr[i10] = null;
        }
        this.f11630x = 0;
        this.f11627u = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final g clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        be.h.c(objClone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        g gVar = (g) objClone;
        gVar.f11628v = (long[]) this.f11628v.clone();
        gVar.f11629w = (Object[]) this.f11629w.clone();
        return gVar;
    }

    public final Object d(long j5) {
        Object obj;
        int iB = t.a.b(this.f11628v, this.f11630x, j5);
        if (iB < 0 || (obj = this.f11629w[iB]) == h.f11631a) {
            return null;
        }
        return obj;
    }

    public final Object e(long j5) {
        Object obj;
        int iB = t.a.b(this.f11628v, this.f11630x, j5);
        if (iB < 0 || (obj = this.f11629w[iB]) == h.f11631a) {
            return -1L;
        }
        return obj;
    }

    public final int f(long j5) {
        if (this.f11627u) {
            int i = this.f11630x;
            long[] jArr = this.f11628v;
            Object[] objArr = this.f11629w;
            int i10 = 0;
            for (int i11 = 0; i11 < i; i11++) {
                Object obj = objArr[i11];
                if (obj != h.f11631a) {
                    if (i11 != i10) {
                        jArr[i10] = jArr[i11];
                        objArr[i10] = obj;
                        objArr[i11] = null;
                    }
                    i10++;
                }
            }
            this.f11627u = false;
            this.f11630x = i10;
        }
        return t.a.b(this.f11628v, this.f11630x, j5);
    }

    public final long g(int i) {
        int i10;
        if (i < 0 || i >= (i10 = this.f11630x)) {
            throw new IllegalArgumentException(e6.j.l("Expected index to be within 0..size()-1, but was ", i).toString());
        }
        if (this.f11627u) {
            long[] jArr = this.f11628v;
            Object[] objArr = this.f11629w;
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                Object obj = objArr[i12];
                if (obj != h.f11631a) {
                    if (i12 != i11) {
                        jArr[i11] = jArr[i12];
                        objArr[i11] = obj;
                        objArr[i12] = null;
                    }
                    i11++;
                }
            }
            this.f11627u = false;
            this.f11630x = i11;
        }
        return this.f11628v[i];
    }

    public final void h(long j5, Object obj) {
        Object obj2 = h.f11631a;
        int iB = t.a.b(this.f11628v, this.f11630x, j5);
        if (iB >= 0) {
            this.f11629w[iB] = obj;
            return;
        }
        int i = ~iB;
        int i10 = this.f11630x;
        if (i < i10) {
            Object[] objArr = this.f11629w;
            if (objArr[i] == obj2) {
                this.f11628v[i] = j5;
                objArr[i] = obj;
                return;
            }
        }
        if (this.f11627u) {
            long[] jArr = this.f11628v;
            if (i10 >= jArr.length) {
                Object[] objArr2 = this.f11629w;
                int i11 = 0;
                for (int i12 = 0; i12 < i10; i12++) {
                    Object obj3 = objArr2[i12];
                    if (obj3 != obj2) {
                        if (i12 != i11) {
                            jArr[i11] = jArr[i12];
                            objArr2[i11] = obj3;
                            objArr2[i12] = null;
                        }
                        i11++;
                    }
                }
                this.f11627u = false;
                this.f11630x = i11;
                i = ~t.a.b(this.f11628v, i11, j5);
            }
        }
        int i13 = this.f11630x;
        if (i13 >= this.f11628v.length) {
            int i14 = (i13 + 1) * 8;
            int i15 = 4;
            while (true) {
                if (i15 >= 32) {
                    break;
                }
                int i16 = (1 << i15) - 12;
                if (i14 <= i16) {
                    i14 = i16;
                    break;
                }
                i15++;
            }
            int i17 = i14 / 8;
            long[] jArrCopyOf = Arrays.copyOf(this.f11628v, i17);
            be.h.d(jArrCopyOf, "copyOf(this, newSize)");
            this.f11628v = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f11629w, i17);
            be.h.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f11629w = objArrCopyOf;
        }
        int i18 = this.f11630x - i;
        if (i18 != 0) {
            long[] jArr2 = this.f11628v;
            int i19 = i + 1;
            be.h.e(jArr2, "<this>");
            System.arraycopy(jArr2, i, jArr2, i19, i18);
            Object[] objArr3 = this.f11629w;
            od.h.T(i19, i, this.f11630x, objArr3, objArr3);
        }
        this.f11628v[i] = j5;
        this.f11629w[i] = obj;
        this.f11630x++;
    }

    public final int i() {
        if (this.f11627u) {
            int i = this.f11630x;
            long[] jArr = this.f11628v;
            Object[] objArr = this.f11629w;
            int i10 = 0;
            for (int i11 = 0; i11 < i; i11++) {
                Object obj = objArr[i11];
                if (obj != h.f11631a) {
                    if (i11 != i10) {
                        jArr[i10] = jArr[i11];
                        objArr[i10] = obj;
                        objArr[i11] = null;
                    }
                    i10++;
                }
            }
            this.f11627u = false;
            this.f11630x = i10;
        }
        return this.f11630x;
    }

    public final Object j(int i) {
        int i10;
        if (i < 0 || i >= (i10 = this.f11630x)) {
            throw new IllegalArgumentException(e6.j.l("Expected index to be within 0..size()-1, but was ", i).toString());
        }
        if (this.f11627u) {
            long[] jArr = this.f11628v;
            Object[] objArr = this.f11629w;
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                Object obj = objArr[i12];
                if (obj != h.f11631a) {
                    if (i12 != i11) {
                        jArr[i11] = jArr[i12];
                        objArr[i11] = obj;
                        objArr[i12] = null;
                    }
                    i11++;
                }
            }
            this.f11627u = false;
            this.f11630x = i11;
        }
        return this.f11629w[i];
    }

    public final String toString() {
        if (i() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f11630x * 28);
        sb2.append('{');
        int i = this.f11630x;
        for (int i10 = 0; i10 < i; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(g(i10));
            sb2.append('=');
            Object objJ = j(i10);
            if (objJ != sb2) {
                sb2.append(objJ);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        be.h.d(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public g() {
        this(10);
    }
}
