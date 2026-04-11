package o2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o0 extends l {
    public static final p1.g0 M;
    public final a[] E;
    public final ArrayList F;
    public final p1.f1[] G;
    public final ArrayList H;
    public final k8.c0 I;
    public int J;
    public long[][] K;
    public c6.c L;

    static {
        p1.w wVar = new p1.w();
        aa.h0 h0Var = aa.j0.f690v;
        aa.c1 c1Var = aa.c1.f650y;
        List list = Collections.EMPTY_LIST;
        aa.c1 c1Var2 = aa.c1.f650y;
        e2.t tVar = new e2.t();
        M = new p1.g0("MergingMediaSource", new p1.y(wVar), null, new p1.b0(tVar), p1.j0.K, p1.d0.f9694d);
    }

    public o0(a... aVarArr) {
        k8.c0 c0Var = new k8.c0(19);
        this.E = aVarArr;
        this.I = c0Var;
        this.H = new ArrayList(Arrays.asList(aVarArr));
        this.J = -1;
        this.F = new ArrayList(aVarArr.length);
        for (int i = 0; i < aVarArr.length; i++) {
            this.F.add(new ArrayList());
        }
        this.G = new p1.f1[aVarArr.length];
        this.K = new long[0][];
        new HashMap();
        aa.q.c("expectedKeys", 8);
        aa.q.c("expectedValuesPerKey", 2);
        new aa.x0(aa.u.a(8)).f762z = new aa.w0();
    }

    @Override // o2.l
    public final void B(Object obj, a aVar, p1.f1 f1Var) {
        Integer num = (Integer) obj;
        if (this.L != null) {
            return;
        }
        if (this.J == -1) {
            this.J = f1Var.h();
        } else if (f1Var.h() != this.J) {
            this.L = new c6.c();
            return;
        }
        int length = this.K.length;
        p1.f1[] f1VarArr = this.G;
        if (length == 0) {
            this.K = (long[][]) Array.newInstance((Class<?>) Long.TYPE, this.J, f1VarArr.length);
        }
        ArrayList arrayList = this.H;
        arrayList.remove(aVar);
        f1VarArr[num.intValue()] = f1Var;
        if (arrayList.isEmpty()) {
            q(f1VarArr[0]);
        }
    }

    @Override // o2.a
    public final boolean a(p1.g0 g0Var) {
        a[] aVarArr = this.E;
        return aVarArr.length > 0 && aVarArr[0].a(g0Var);
    }

    @Override // o2.a
    public final b0 c(d0 d0Var, s2.e eVar, long j5) {
        a[] aVarArr = this.E;
        int length = aVarArr.length;
        b0[] b0VarArr = new b0[length];
        p1.f1[] f1VarArr = this.G;
        int iB = f1VarArr[0].b(d0Var.f9090a);
        for (int i = 0; i < length; i++) {
            d0 d0VarA = d0Var.a(f1VarArr[i].l(iB));
            b0VarArr[i] = aVarArr[i].c(d0VarA, eVar, j5 - this.K[iB][i]);
            ((List) this.F.get(i)).add(new n0(d0VarA, b0VarArr[i]));
        }
        return new m0(this.I, this.K[iB], b0VarArr);
    }

    @Override // o2.a
    public final p1.g0 j() {
        a[] aVarArr = this.E;
        return aVarArr.length > 0 ? aVarArr[0].j() : M;
    }

    @Override // o2.l, o2.a
    public final void n() throws c6.c {
        c6.c cVar = this.L;
        if (cVar != null) {
            throw cVar;
        }
        super.n();
    }

    @Override // o2.a
    public final void p(v1.e0 e0Var) {
        this.D = e0Var;
        this.C = s1.b0.n(null);
        int i = 0;
        while (true) {
            a[] aVarArr = this.E;
            if (i >= aVarArr.length) {
                return;
            }
            C(Integer.valueOf(i), aVarArr[i]);
            i++;
        }
    }

    @Override // o2.a
    public final void r(b0 b0Var) {
        m0 m0Var = (m0) b0Var;
        int i = 0;
        while (true) {
            a[] aVarArr = this.E;
            if (i >= aVarArr.length) {
                return;
            }
            List list = (List) this.F.get(i);
            b0[] b0VarArr = m0Var.f9163u;
            boolean[] zArr = m0Var.f9164v;
            b0 b0Var2 = zArr[i] ? ((m1) b0VarArr[i]).f9169u : b0VarArr[i];
            int i10 = 0;
            while (true) {
                if (i10 >= list.size()) {
                    break;
                }
                if (((n0) list.get(i10)).f9175b.equals(b0Var2)) {
                    list.remove(i10);
                    break;
                }
                i10++;
            }
            a aVar = aVarArr[i];
            b0[] b0VarArr2 = m0Var.f9163u;
            aVar.r(zArr[i] ? ((m1) b0VarArr2[i]).f9169u : b0VarArr2[i]);
            i++;
        }
    }

    @Override // o2.l, o2.a
    public final void t() {
        super.t();
        Arrays.fill(this.G, (Object) null);
        this.J = -1;
        this.L = null;
        ArrayList arrayList = this.H;
        arrayList.clear();
        Collections.addAll(arrayList, this.E);
    }

    @Override // o2.a
    public final void x(p1.g0 g0Var) {
        this.E[0].x(g0Var);
    }

    @Override // o2.l
    public final d0 y(Object obj, d0 d0Var) {
        int iIntValue = ((Integer) obj).intValue();
        ArrayList arrayList = this.F;
        List list = (List) arrayList.get(iIntValue);
        for (int i = 0; i < list.size(); i++) {
            if (((n0) list.get(i)).f9174a.equals(d0Var)) {
                return ((n0) ((List) arrayList.get(0)).get(i)).f9174a;
            }
        }
        return null;
    }
}
