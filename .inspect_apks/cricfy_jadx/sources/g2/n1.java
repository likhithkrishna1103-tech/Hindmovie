package g2;

import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n1 extends v1.f1 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f4811n = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f4812e;
    public final s2.d1 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f4813g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f4814h;
    public final int[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f4815j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final v1.f1[] f4816k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object[] f4817l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HashMap f4818m;

    /* JADX WARN: Illegal instructions before constructor call */
    public n1(ArrayList arrayList, s2.d1 d1Var) {
        v1.f1[] f1VarArr = new v1.f1[arrayList.size()];
        int size = arrayList.size();
        int i = 0;
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            f1VarArr[i10] = ((x0) obj).b();
            i10++;
        }
        Object[] objArr = new Object[arrayList.size()];
        int size2 = arrayList.size();
        int i12 = 0;
        while (i12 < size2) {
            Object obj2 = arrayList.get(i12);
            i12++;
            objArr[i] = ((x0) obj2).a();
            i++;
        }
        this(f1VarArr, objArr, d1Var);
    }

    @Override // v1.f1
    public final int a(boolean z10) {
        if (this.f4812e != 0) {
            int iQ = 0;
            if (z10) {
                int[] iArr = this.f.f11167b;
                iQ = iArr.length > 0 ? iArr[0] : -1;
            }
            do {
                v1.f1[] f1VarArr = this.f4816k;
                if (!f1VarArr[iQ].p()) {
                    return f1VarArr[iQ].a(z10) + this.f4815j[iQ];
                }
                iQ = q(iQ, z10);
            } while (iQ != -1);
        }
        return -1;
    }

    @Override // v1.f1
    public final int b(Object obj) {
        int iB;
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            Object obj2 = pair.first;
            Object obj3 = pair.second;
            Integer num = (Integer) this.f4818m.get(obj2);
            int iIntValue = num == null ? -1 : num.intValue();
            if (iIntValue != -1 && (iB = this.f4816k[iIntValue].b(obj3)) != -1) {
                return this.i[iIntValue] + iB;
            }
        }
        return -1;
    }

    @Override // v1.f1
    public final int c(boolean z10) {
        int iR;
        int i = this.f4812e;
        if (i != 0) {
            if (z10) {
                int[] iArr = this.f.f11167b;
                iR = iArr.length > 0 ? iArr[iArr.length - 1] : -1;
            } else {
                iR = i - 1;
            }
            do {
                v1.f1[] f1VarArr = this.f4816k;
                if (!f1VarArr[iR].p()) {
                    return f1VarArr[iR].c(z10) + this.f4815j[iR];
                }
                iR = r(iR, z10);
            } while (iR != -1);
        }
        return -1;
    }

    @Override // v1.f1
    public final int e(int i, int i10, boolean z10) {
        int[] iArr = this.f4815j;
        int iD = y1.a0.d(iArr, i + 1, false, false);
        int i11 = iArr[iD];
        v1.f1[] f1VarArr = this.f4816k;
        int iE = f1VarArr[iD].e(i - i11, i10 != 2 ? i10 : 0, z10);
        if (iE != -1) {
            return i11 + iE;
        }
        int iQ = q(iD, z10);
        while (iQ != -1 && f1VarArr[iQ].p()) {
            iQ = q(iQ, z10);
        }
        if (iQ != -1) {
            return f1VarArr[iQ].a(z10) + iArr[iQ];
        }
        if (i10 == 2) {
            return a(z10);
        }
        return -1;
    }

    @Override // v1.f1
    public final v1.c1 f(int i, v1.c1 c1Var, boolean z10) {
        int[] iArr = this.i;
        int iD = y1.a0.d(iArr, i + 1, false, false);
        int i10 = this.f4815j[iD];
        this.f4816k[iD].f(i - iArr[iD], c1Var, z10);
        c1Var.f12618c += i10;
        if (z10) {
            Object obj = this.f4817l[iD];
            Object obj2 = c1Var.f12617b;
            obj2.getClass();
            c1Var.f12617b = Pair.create(obj, obj2);
        }
        return c1Var;
    }

    @Override // v1.f1
    public final v1.c1 g(Object obj, v1.c1 c1Var) {
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        Integer num = (Integer) this.f4818m.get(obj2);
        int iIntValue = num == null ? -1 : num.intValue();
        int i = this.f4815j[iIntValue];
        this.f4816k[iIntValue].g(obj3, c1Var);
        c1Var.f12618c += i;
        c1Var.f12617b = obj;
        return c1Var;
    }

    @Override // v1.f1
    public final int h() {
        return this.f4814h;
    }

    @Override // v1.f1
    public final int k(int i, int i10, boolean z10) {
        int[] iArr = this.f4815j;
        int iD = y1.a0.d(iArr, i + 1, false, false);
        int i11 = iArr[iD];
        v1.f1[] f1VarArr = this.f4816k;
        int iK = f1VarArr[iD].k(i - i11, i10 != 2 ? i10 : 0, z10);
        if (iK != -1) {
            return i11 + iK;
        }
        int iR = r(iD, z10);
        while (iR != -1 && f1VarArr[iR].p()) {
            iR = r(iR, z10);
        }
        if (iR != -1) {
            return f1VarArr[iR].c(z10) + iArr[iR];
        }
        if (i10 == 2) {
            return c(z10);
        }
        return -1;
    }

    @Override // v1.f1
    public final Object l(int i) {
        int[] iArr = this.i;
        int iD = y1.a0.d(iArr, i + 1, false, false);
        return Pair.create(this.f4817l[iD], this.f4816k[iD].l(i - iArr[iD]));
    }

    @Override // v1.f1
    public final v1.e1 m(int i, v1.e1 e1Var, long j4) {
        int[] iArr = this.f4815j;
        int iD = y1.a0.d(iArr, i + 1, false, false);
        int i10 = iArr[iD];
        int i11 = this.i[iD];
        this.f4816k[iD].m(i - i10, e1Var, j4);
        Object objCreate = this.f4817l[iD];
        if (!v1.e1.f12633q.equals(e1Var.f12643a)) {
            objCreate = Pair.create(objCreate, e1Var.f12643a);
        }
        e1Var.f12643a = objCreate;
        e1Var.f12654n += i11;
        e1Var.f12655o += i11;
        return e1Var;
    }

    @Override // v1.f1
    public final int o() {
        return this.f4813g;
    }

    public final int q(int i, boolean z10) {
        if (!z10) {
            if (i < this.f4812e - 1) {
                return i + 1;
            }
            return -1;
        }
        s2.d1 d1Var = this.f;
        int i10 = d1Var.f11168c[i] + 1;
        int[] iArr = d1Var.f11167b;
        if (i10 < iArr.length) {
            return iArr[i10];
        }
        return -1;
    }

    public final int r(int i, boolean z10) {
        if (!z10) {
            if (i > 0) {
                return i - 1;
            }
            return -1;
        }
        s2.d1 d1Var = this.f;
        int i10 = d1Var.f11168c[i] - 1;
        if (i10 >= 0) {
            return d1Var.f11167b[i10];
        }
        return -1;
    }

    public n1(v1.f1[] f1VarArr, Object[] objArr, s2.d1 d1Var) {
        this.f = d1Var;
        this.f4812e = d1Var.f11167b.length;
        int length = f1VarArr.length;
        this.f4816k = f1VarArr;
        this.i = new int[length];
        this.f4815j = new int[length];
        this.f4817l = objArr;
        this.f4818m = new HashMap();
        int length2 = f1VarArr.length;
        int i = 0;
        int iO = 0;
        int iH = 0;
        int i10 = 0;
        while (i < length2) {
            v1.f1 f1Var = f1VarArr[i];
            this.f4816k[i10] = f1Var;
            this.f4815j[i10] = iO;
            this.i[i10] = iH;
            iO += f1Var.o();
            iH += this.f4816k[i10].h();
            this.f4818m.put(objArr[i10], Integer.valueOf(i10));
            i++;
            i10++;
        }
        this.f4813g = iO;
        this.f4814h = iH;
    }
}
