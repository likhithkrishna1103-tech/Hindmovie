package v;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements Cloneable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public /* synthetic */ boolean f12528v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public /* synthetic */ long[] f12529w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public /* synthetic */ Object[] f12530x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public /* synthetic */ int f12531y;

    public h(int i) {
        if (i == 0) {
            this.f12529w = w.a.f13744b;
            this.f12530x = w.a.f13745c;
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
        this.f12529w = new long[i13];
        this.f12530x = new Object[i13];
    }

    public final void a(long j4, Long l10) {
        int i = this.f12531y;
        if (i != 0 && j4 <= this.f12529w[i - 1]) {
            h(j4, l10);
            return;
        }
        if (this.f12528v) {
            long[] jArr = this.f12529w;
            if (i >= jArr.length) {
                Object[] objArr = this.f12530x;
                int i10 = 0;
                for (int i11 = 0; i11 < i; i11++) {
                    Object obj = objArr[i11];
                    if (obj != i.f12532a) {
                        if (i11 != i10) {
                            jArr[i10] = jArr[i11];
                            objArr[i10] = obj;
                            objArr[i11] = null;
                        }
                        i10++;
                    }
                }
                this.f12528v = false;
                this.f12531y = i10;
            }
        }
        int i12 = this.f12531y;
        if (i12 >= this.f12529w.length) {
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
            long[] jArrCopyOf = Arrays.copyOf(this.f12529w, i16);
            ge.i.d(jArrCopyOf, "copyOf(...)");
            this.f12529w = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f12530x, i16);
            ge.i.d(objArrCopyOf, "copyOf(...)");
            this.f12530x = objArrCopyOf;
        }
        this.f12529w[i12] = j4;
        this.f12530x[i12] = l10;
        this.f12531y = i12 + 1;
    }

    public final void b() {
        int i = this.f12531y;
        Object[] objArr = this.f12530x;
        for (int i10 = 0; i10 < i; i10++) {
            objArr[i10] = null;
        }
        this.f12531y = 0;
        this.f12528v = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final h clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        ge.i.c(objClone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        h hVar = (h) objClone;
        hVar.f12529w = (long[]) this.f12529w.clone();
        hVar.f12530x = (Object[]) this.f12530x.clone();
        return hVar;
    }

    public final Object d(long j4) {
        Object obj;
        int iB = w.a.b(this.f12529w, this.f12531y, j4);
        if (iB < 0 || (obj = this.f12530x[iB]) == i.f12532a) {
            return null;
        }
        return obj;
    }

    public final Object e(long j4) {
        Object obj;
        int iB = w.a.b(this.f12529w, this.f12531y, j4);
        if (iB < 0 || (obj = this.f12530x[iB]) == i.f12532a) {
            return -1L;
        }
        return obj;
    }

    public final int f(long j4) {
        if (this.f12528v) {
            int i = this.f12531y;
            long[] jArr = this.f12529w;
            Object[] objArr = this.f12530x;
            int i10 = 0;
            for (int i11 = 0; i11 < i; i11++) {
                Object obj = objArr[i11];
                if (obj != i.f12532a) {
                    if (i11 != i10) {
                        jArr[i10] = jArr[i11];
                        objArr[i10] = obj;
                        objArr[i11] = null;
                    }
                    i10++;
                }
            }
            this.f12528v = false;
            this.f12531y = i10;
        }
        return w.a.b(this.f12529w, this.f12531y, j4);
    }

    public final long g(int i) {
        int i10;
        if (i < 0 || i >= (i10 = this.f12531y)) {
            w.a.c("Expected index to be within 0..size()-1, but was " + i);
            throw null;
        }
        if (this.f12528v) {
            long[] jArr = this.f12529w;
            Object[] objArr = this.f12530x;
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                Object obj = objArr[i12];
                if (obj != i.f12532a) {
                    if (i12 != i11) {
                        jArr[i11] = jArr[i12];
                        objArr[i11] = obj;
                        objArr[i12] = null;
                    }
                    i11++;
                }
            }
            this.f12528v = false;
            this.f12531y = i11;
        }
        return this.f12529w[i];
    }

    public final void h(long j4, Object obj) {
        Object obj2 = i.f12532a;
        int iB = w.a.b(this.f12529w, this.f12531y, j4);
        if (iB >= 0) {
            this.f12530x[iB] = obj;
            return;
        }
        int i = ~iB;
        int i10 = this.f12531y;
        if (i < i10) {
            Object[] objArr = this.f12530x;
            if (objArr[i] == obj2) {
                this.f12529w[i] = j4;
                objArr[i] = obj;
                return;
            }
        }
        if (this.f12528v) {
            long[] jArr = this.f12529w;
            if (i10 >= jArr.length) {
                Object[] objArr2 = this.f12530x;
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
                this.f12528v = false;
                this.f12531y = i11;
                i = ~w.a.b(this.f12529w, i11, j4);
            }
        }
        int i13 = this.f12531y;
        if (i13 >= this.f12529w.length) {
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
            long[] jArrCopyOf = Arrays.copyOf(this.f12529w, i17);
            ge.i.d(jArrCopyOf, "copyOf(...)");
            this.f12529w = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f12530x, i17);
            ge.i.d(objArrCopyOf, "copyOf(...)");
            this.f12530x = objArrCopyOf;
        }
        int i18 = this.f12531y - i;
        if (i18 != 0) {
            long[] jArr2 = this.f12529w;
            int i19 = i + 1;
            ge.i.e(jArr2, "<this>");
            System.arraycopy(jArr2, i, jArr2, i19, i18);
            Object[] objArr3 = this.f12530x;
            sd.i.h(i19, i, this.f12531y, objArr3, objArr3);
        }
        this.f12529w[i] = j4;
        this.f12530x[i] = obj;
        this.f12531y++;
    }

    public final int i() {
        if (this.f12528v) {
            int i = this.f12531y;
            long[] jArr = this.f12529w;
            Object[] objArr = this.f12530x;
            int i10 = 0;
            for (int i11 = 0; i11 < i; i11++) {
                Object obj = objArr[i11];
                if (obj != i.f12532a) {
                    if (i11 != i10) {
                        jArr[i10] = jArr[i11];
                        objArr[i10] = obj;
                        objArr[i11] = null;
                    }
                    i10++;
                }
            }
            this.f12528v = false;
            this.f12531y = i10;
        }
        return this.f12531y;
    }

    public final Object j(int i) {
        int i10;
        if (i < 0 || i >= (i10 = this.f12531y)) {
            w.a.c("Expected index to be within 0..size()-1, but was " + i);
            throw null;
        }
        if (this.f12528v) {
            long[] jArr = this.f12529w;
            Object[] objArr = this.f12530x;
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                Object obj = objArr[i12];
                if (obj != i.f12532a) {
                    if (i12 != i11) {
                        jArr[i11] = jArr[i12];
                        objArr[i11] = obj;
                        objArr[i12] = null;
                    }
                    i11++;
                }
            }
            this.f12528v = false;
            this.f12531y = i11;
        }
        return this.f12530x[i];
    }

    public final String toString() {
        if (i() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f12531y * 28);
        sb.append('{');
        int i = this.f12531y;
        for (int i10 = 0; i10 < i; i10++) {
            if (i10 > 0) {
                sb.append(", ");
            }
            sb.append(g(i10));
            sb.append('=');
            Object objJ = j(i10);
            if (objJ != sb) {
                sb.append(objJ);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        ge.i.d(string, "toString(...)");
        return string;
    }

    public h() {
        this(10);
    }
}
