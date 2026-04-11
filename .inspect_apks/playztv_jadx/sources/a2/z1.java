package a2;

import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z1 extends p1.f1 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f523n = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f524e;
    public final o2.f1 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f525g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f526h;
    public final int[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f527j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final p1.f1[] f528k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object[] f529l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HashMap f530m;

    /* JADX WARN: Illegal instructions before constructor call */
    public z1(ArrayList arrayList, o2.f1 f1Var) {
        p1.f1[] f1VarArr = new p1.f1[arrayList.size()];
        int size = arrayList.size();
        int i = 0;
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            f1VarArr[i10] = ((i1) obj).b();
            i10++;
        }
        Object[] objArr = new Object[arrayList.size()];
        int size2 = arrayList.size();
        int i12 = 0;
        while (i12 < size2) {
            Object obj2 = arrayList.get(i12);
            i12++;
            objArr[i] = ((i1) obj2).a();
            i++;
        }
        this(f1VarArr, objArr, f1Var);
    }

    @Override // p1.f1
    public final int a(boolean z2) {
        if (this.f524e != 0) {
            int iQ = 0;
            if (z2) {
                int[] iArr = this.f.f9109b;
                iQ = iArr.length > 0 ? iArr[0] : -1;
            }
            do {
                p1.f1[] f1VarArr = this.f528k;
                if (!f1VarArr[iQ].p()) {
                    return f1VarArr[iQ].a(z2) + this.f527j[iQ];
                }
                iQ = q(iQ, z2);
            } while (iQ != -1);
        }
        return -1;
    }

    @Override // p1.f1
    public final int b(Object obj) {
        int iB;
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            Object obj2 = pair.first;
            Object obj3 = pair.second;
            Integer num = (Integer) this.f530m.get(obj2);
            int iIntValue = num == null ? -1 : num.intValue();
            if (iIntValue != -1 && (iB = this.f528k[iIntValue].b(obj3)) != -1) {
                return this.i[iIntValue] + iB;
            }
        }
        return -1;
    }

    @Override // p1.f1
    public final int c(boolean z2) {
        int iR;
        int i = this.f524e;
        if (i != 0) {
            if (z2) {
                int[] iArr = this.f.f9109b;
                iR = iArr.length > 0 ? iArr[iArr.length - 1] : -1;
            } else {
                iR = i - 1;
            }
            do {
                p1.f1[] f1VarArr = this.f528k;
                if (!f1VarArr[iR].p()) {
                    return f1VarArr[iR].c(z2) + this.f527j[iR];
                }
                iR = r(iR, z2);
            } while (iR != -1);
        }
        return -1;
    }

    @Override // p1.f1
    public final int e(int i, int i10, boolean z2) {
        int[] iArr = this.f527j;
        int iD = s1.b0.d(iArr, i + 1, false, false);
        int i11 = iArr[iD];
        p1.f1[] f1VarArr = this.f528k;
        int iE = f1VarArr[iD].e(i - i11, i10 != 2 ? i10 : 0, z2);
        if (iE != -1) {
            return i11 + iE;
        }
        int iQ = q(iD, z2);
        while (iQ != -1 && f1VarArr[iQ].p()) {
            iQ = q(iQ, z2);
        }
        if (iQ != -1) {
            return f1VarArr[iQ].a(z2) + iArr[iQ];
        }
        if (i10 == 2) {
            return a(z2);
        }
        return -1;
    }

    @Override // p1.f1
    public final p1.c1 f(int i, p1.c1 c1Var, boolean z2) {
        int[] iArr = this.i;
        int iD = s1.b0.d(iArr, i + 1, false, false);
        int i10 = this.f527j[iD];
        this.f528k[iD].f(i - iArr[iD], c1Var, z2);
        c1Var.f9678c += i10;
        if (z2) {
            Object obj = this.f529l[iD];
            Object obj2 = c1Var.f9677b;
            obj2.getClass();
            c1Var.f9677b = Pair.create(obj, obj2);
        }
        return c1Var;
    }

    @Override // p1.f1
    public final p1.c1 g(Object obj, p1.c1 c1Var) {
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        Integer num = (Integer) this.f530m.get(obj2);
        int iIntValue = num == null ? -1 : num.intValue();
        int i = this.f527j[iIntValue];
        this.f528k[iIntValue].g(obj3, c1Var);
        c1Var.f9678c += i;
        c1Var.f9677b = obj;
        return c1Var;
    }

    @Override // p1.f1
    public final int h() {
        return this.f526h;
    }

    @Override // p1.f1
    public final int k(int i, int i10, boolean z2) {
        int[] iArr = this.f527j;
        int iD = s1.b0.d(iArr, i + 1, false, false);
        int i11 = iArr[iD];
        p1.f1[] f1VarArr = this.f528k;
        int iK = f1VarArr[iD].k(i - i11, i10 != 2 ? i10 : 0, z2);
        if (iK != -1) {
            return i11 + iK;
        }
        int iR = r(iD, z2);
        while (iR != -1 && f1VarArr[iR].p()) {
            iR = r(iR, z2);
        }
        if (iR != -1) {
            return f1VarArr[iR].c(z2) + iArr[iR];
        }
        if (i10 == 2) {
            return c(z2);
        }
        return -1;
    }

    @Override // p1.f1
    public final Object l(int i) {
        int[] iArr = this.i;
        int iD = s1.b0.d(iArr, i + 1, false, false);
        return Pair.create(this.f529l[iD], this.f528k[iD].l(i - iArr[iD]));
    }

    @Override // p1.f1
    public final p1.e1 m(int i, p1.e1 e1Var, long j5) {
        int[] iArr = this.f527j;
        int iD = s1.b0.d(iArr, i + 1, false, false);
        int i10 = iArr[iD];
        int i11 = this.i[iD];
        this.f528k[iD].m(i - i10, e1Var, j5);
        Object objCreate = this.f529l[iD];
        if (!p1.e1.f9703q.equals(e1Var.f9713a)) {
            objCreate = Pair.create(objCreate, e1Var.f9713a);
        }
        e1Var.f9713a = objCreate;
        e1Var.f9724n += i11;
        e1Var.f9725o += i11;
        return e1Var;
    }

    @Override // p1.f1
    public final int o() {
        return this.f525g;
    }

    public final int q(int i, boolean z2) {
        if (!z2) {
            if (i < this.f524e - 1) {
                return i + 1;
            }
            return -1;
        }
        o2.f1 f1Var = this.f;
        int i10 = f1Var.f9110c[i] + 1;
        int[] iArr = f1Var.f9109b;
        if (i10 < iArr.length) {
            return iArr[i10];
        }
        return -1;
    }

    public final int r(int i, boolean z2) {
        if (!z2) {
            if (i > 0) {
                return i - 1;
            }
            return -1;
        }
        o2.f1 f1Var = this.f;
        int i10 = f1Var.f9110c[i] - 1;
        if (i10 >= 0) {
            return f1Var.f9109b[i10];
        }
        return -1;
    }

    public z1(p1.f1[] f1VarArr, Object[] objArr, o2.f1 f1Var) {
        this.f = f1Var;
        this.f524e = f1Var.f9109b.length;
        int length = f1VarArr.length;
        this.f528k = f1VarArr;
        this.i = new int[length];
        this.f527j = new int[length];
        this.f529l = objArr;
        this.f530m = new HashMap();
        int length2 = f1VarArr.length;
        int i = 0;
        int iO = 0;
        int iH = 0;
        int i10 = 0;
        while (i < length2) {
            p1.f1 f1Var2 = f1VarArr[i];
            this.f528k[i10] = f1Var2;
            this.f527j[i10] = iO;
            this.i[i10] = iH;
            iO += f1Var2.o();
            iH += this.f528k[i10].h();
            this.f530m.put(objArr[i10], Integer.valueOf(i10));
            i++;
            i10++;
        }
        this.f525g = iO;
        this.f526h = iH;
    }
}
