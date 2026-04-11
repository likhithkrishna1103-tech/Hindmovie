package s;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j implements Cloneable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public /* synthetic */ int[] f11636u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public /* synthetic */ Object[] f11637v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public /* synthetic */ int f11638w;

    public j() {
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
        this.f11636u = new int[i12];
        this.f11637v = new Object[i12];
    }

    public final void a(int i, Object obj) {
        int i10 = this.f11638w;
        if (i10 != 0 && i <= this.f11636u[i10 - 1]) {
            d(i, obj);
            return;
        }
        if (i10 >= this.f11636u.length) {
            int i11 = (i10 + 1) * 4;
            int i12 = 4;
            while (true) {
                if (i12 >= 32) {
                    break;
                }
                int i13 = (1 << i12) - 12;
                if (i11 <= i13) {
                    i11 = i13;
                    break;
                }
                i12++;
            }
            int i14 = i11 / 4;
            int[] iArrCopyOf = Arrays.copyOf(this.f11636u, i14);
            be.h.d(iArrCopyOf, "copyOf(this, newSize)");
            this.f11636u = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f11637v, i14);
            be.h.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f11637v = objArrCopyOf;
        }
        this.f11636u[i10] = i;
        this.f11637v[i10] = obj;
        this.f11638w = i10 + 1;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final j clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        be.h.c(objClone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        j jVar = (j) objClone;
        jVar.f11636u = (int[]) this.f11636u.clone();
        jVar.f11637v = (Object[]) this.f11637v.clone();
        return jVar;
    }

    public final Object c(int i) {
        Object obj;
        int iA = t.a.a(this.f11638w, i, this.f11636u);
        if (iA < 0 || (obj = this.f11637v[iA]) == h.f11632b) {
            return null;
        }
        return obj;
    }

    public final void d(int i, Object obj) {
        int iA = t.a.a(this.f11638w, i, this.f11636u);
        if (iA >= 0) {
            this.f11637v[iA] = obj;
            return;
        }
        int i10 = ~iA;
        int i11 = this.f11638w;
        if (i10 < i11) {
            Object[] objArr = this.f11637v;
            if (objArr[i10] == h.f11632b) {
                this.f11636u[i10] = i;
                objArr[i10] = obj;
                return;
            }
        }
        if (i11 >= this.f11636u.length) {
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
            int[] iArrCopyOf = Arrays.copyOf(this.f11636u, i15);
            be.h.d(iArrCopyOf, "copyOf(this, newSize)");
            this.f11636u = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f11637v, i15);
            be.h.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f11637v = objArrCopyOf;
        }
        int i16 = this.f11638w;
        if (i16 - i10 != 0) {
            int[] iArr = this.f11636u;
            int i17 = i10 + 1;
            od.h.S(i17, i10, i16, iArr, iArr);
            Object[] objArr2 = this.f11637v;
            od.h.T(i17, i10, this.f11638w, objArr2, objArr2);
        }
        this.f11636u[i10] = i;
        this.f11637v[i10] = obj;
        this.f11638w++;
    }

    public final String toString() {
        int i = this.f11638w;
        if (i <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(i * 28);
        sb2.append('{');
        int i10 = this.f11638w;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            sb2.append(this.f11636u[i11]);
            sb2.append('=');
            Object obj = this.f11637v[i11];
            if (obj != this) {
                sb2.append(obj);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        be.h.d(string, "buffer.toString()");
        return string;
    }
}
