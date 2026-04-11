package v;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements Cloneable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public /* synthetic */ boolean f12543v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public /* synthetic */ int[] f12544w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public /* synthetic */ Object[] f12545x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public /* synthetic */ int f12546y;

    public l() {
        int i;
        int i10 = 4;
        while (true) {
            i = 40;
            if (i10 >= 32) {
                break;
            }
            int i11 = (1 << i10) - 12;
            if (40 <= i11) {
                i = i11;
                break;
            }
            i10++;
        }
        int i12 = i / 4;
        this.f12544w = new int[i12];
        this.f12545x = new Object[i12];
    }

    public final void a(int i, Object obj) {
        int i10 = this.f12546y;
        if (i10 != 0 && i <= this.f12544w[i10 - 1]) {
            d(i, obj);
            return;
        }
        if (this.f12543v && i10 >= this.f12544w.length) {
            i.a(this);
        }
        int i11 = this.f12546y;
        if (i11 >= this.f12544w.length) {
            int i12 = (i11 + 1) * 4;
            int i13 = 4;
            while (true) {
                if (i13 >= 32) {
                    break;
                }
                int i14 = (1 << i13) - 12;
                if (i12 <= i14) {
                    i12 = i14;
                    break;
                }
                i13++;
            }
            int i15 = i12 / 4;
            int[] iArrCopyOf = Arrays.copyOf(this.f12544w, i15);
            ge.i.d(iArrCopyOf, "copyOf(...)");
            this.f12544w = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f12545x, i15);
            ge.i.d(objArrCopyOf, "copyOf(...)");
            this.f12545x = objArrCopyOf;
        }
        this.f12544w[i11] = i;
        this.f12545x[i11] = obj;
        this.f12546y = i11 + 1;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final l clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        ge.i.c(objClone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        l lVar = (l) objClone;
        lVar.f12544w = (int[]) this.f12544w.clone();
        lVar.f12545x = (Object[]) this.f12545x.clone();
        return lVar;
    }

    public final Object c(int i) {
        Object obj;
        int iA = w.a.a(this.f12546y, i, this.f12544w);
        if (iA < 0 || (obj = this.f12545x[iA]) == i.f12533b) {
            return null;
        }
        return obj;
    }

    public final void d(int i, Object obj) {
        int iA = w.a.a(this.f12546y, i, this.f12544w);
        if (iA >= 0) {
            this.f12545x[iA] = obj;
            return;
        }
        int i10 = ~iA;
        int i11 = this.f12546y;
        if (i10 < i11) {
            Object[] objArr = this.f12545x;
            if (objArr[i10] == i.f12533b) {
                this.f12544w[i10] = i;
                objArr[i10] = obj;
                return;
            }
        }
        if (this.f12543v && i11 >= this.f12544w.length) {
            i.a(this);
            i10 = ~w.a.a(this.f12546y, i, this.f12544w);
        }
        int i12 = this.f12546y;
        if (i12 >= this.f12544w.length) {
            int i13 = (i12 + 1) * 4;
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
            int i16 = i13 / 4;
            int[] iArrCopyOf = Arrays.copyOf(this.f12544w, i16);
            ge.i.d(iArrCopyOf, "copyOf(...)");
            this.f12544w = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f12545x, i16);
            ge.i.d(objArrCopyOf, "copyOf(...)");
            this.f12545x = objArrCopyOf;
        }
        int i17 = this.f12546y;
        if (i17 - i10 != 0) {
            int[] iArr = this.f12544w;
            int i18 = i10 + 1;
            sd.i.g(i18, i10, i17, iArr, iArr);
            Object[] objArr2 = this.f12545x;
            sd.i.h(i18, i10, this.f12546y, objArr2, objArr2);
        }
        this.f12544w[i10] = i;
        this.f12545x[i10] = obj;
        this.f12546y++;
    }

    public final int e() {
        if (this.f12543v) {
            i.a(this);
        }
        return this.f12546y;
    }

    public final Object f(int i) {
        if (this.f12543v) {
            i.a(this);
        }
        Object[] objArr = this.f12545x;
        if (i < objArr.length) {
            return objArr[i];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final String toString() {
        if (e() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f12546y * 28);
        sb.append('{');
        int i = this.f12546y;
        for (int i10 = 0; i10 < i; i10++) {
            if (i10 > 0) {
                sb.append(", ");
            }
            if (this.f12543v) {
                i.a(this);
            }
            sb.append(this.f12544w[i10]);
            sb.append('=');
            Object objF = f(i10);
            if (objF != this) {
                sb.append(objF);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        ge.i.d(string, "toString(...)");
        return string;
    }
}
