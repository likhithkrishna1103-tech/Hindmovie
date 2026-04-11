package s2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 extends l {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final v1.g0 f11267s;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a[] f11268k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f11269l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final v1.f1[] f11270m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList f11271n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final f9.z f11272o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f11273p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long[][] f11274q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public a2.a f11275r;

    static {
        v1.v vVar = new v1.v();
        ua.g0 g0Var = ua.i0.f12341w;
        ua.z0 z0Var = ua.z0.f12413z;
        List list = Collections.EMPTY_LIST;
        ua.z0 z0Var2 = ua.z0.f12413z;
        k2.t tVar = new k2.t();
        f11267s = new v1.g0("MergingMediaSource", new v1.x(vVar), null, new v1.a0(tVar), v1.j0.K, v1.d0.f12622d);
    }

    public m0(a... aVarArr) {
        f9.z zVar = new f9.z(23);
        this.f11268k = aVarArr;
        this.f11272o = zVar;
        this.f11271n = new ArrayList(Arrays.asList(aVarArr));
        this.f11273p = -1;
        this.f11269l = new ArrayList(aVarArr.length);
        for (int i = 0; i < aVarArr.length; i++) {
            this.f11269l.add(new ArrayList());
        }
        this.f11270m = new v1.f1[aVarArr.length];
        this.f11274q = new long[0][];
        new HashMap();
        ua.q.d(8, "expectedKeys");
        ua.q.d(2, "expectedValuesPerKey");
        new ua.v0(ua.u.a(8)).A = new ua.u0();
    }

    @Override // s2.a
    public final boolean a(v1.g0 g0Var) {
        a[] aVarArr = this.f11268k;
        return aVarArr.length > 0 && aVarArr[0].a(g0Var);
    }

    @Override // s2.a
    public final a0 c(c0 c0Var, w2.e eVar, long j4) {
        a[] aVarArr = this.f11268k;
        int length = aVarArr.length;
        a0[] a0VarArr = new a0[length];
        v1.f1[] f1VarArr = this.f11270m;
        int iB = f1VarArr[0].b(c0Var.f11156a);
        for (int i = 0; i < length; i++) {
            c0 c0VarA = c0Var.a(f1VarArr[i].l(iB));
            a0VarArr[i] = aVarArr[i].c(c0VarA, eVar, j4 - this.f11274q[iB][i]);
            ((List) this.f11269l.get(i)).add(new l0(c0VarA, a0VarArr[i]));
        }
        return new k0(this.f11272o, this.f11274q[iB], a0VarArr);
    }

    @Override // s2.a
    public final v1.g0 i() {
        a[] aVarArr = this.f11268k;
        return aVarArr.length > 0 ? aVarArr[0].i() : f11267s;
    }

    @Override // s2.l, s2.a
    public final void k() throws a2.a {
        a2.a aVar = this.f11275r;
        if (aVar != null) {
            throw aVar;
        }
        super.k();
    }

    @Override // s2.a
    public final void m(b2.h0 h0Var) {
        this.f11257j = h0Var;
        this.i = y1.a0.n(null);
        int i = 0;
        while (true) {
            a[] aVarArr = this.f11268k;
            if (i >= aVarArr.length) {
                return;
            }
            y(Integer.valueOf(i), aVarArr[i]);
            i++;
        }
    }

    @Override // s2.a
    public final void o(a0 a0Var) {
        k0 k0Var = (k0) a0Var;
        int i = 0;
        while (true) {
            a[] aVarArr = this.f11268k;
            if (i >= aVarArr.length) {
                return;
            }
            List list = (List) this.f11269l.get(i);
            a0[] a0VarArr = k0Var.f11248v;
            boolean[] zArr = k0Var.f11249w;
            a0 a0Var2 = zArr[i] ? ((k1) a0VarArr[i]).f11253v : a0VarArr[i];
            int i10 = 0;
            while (true) {
                if (i10 >= list.size()) {
                    break;
                }
                if (((l0) list.get(i10)).f11259b.equals(a0Var2)) {
                    list.remove(i10);
                    break;
                }
                i10++;
            }
            a aVar = aVarArr[i];
            a0[] a0VarArr2 = k0Var.f11248v;
            aVar.o(zArr[i] ? ((k1) a0VarArr2[i]).f11253v : a0VarArr2[i]);
            i++;
        }
    }

    @Override // s2.l, s2.a
    public final void q() {
        super.q();
        Arrays.fill(this.f11270m, (Object) null);
        this.f11273p = -1;
        this.f11275r = null;
        ArrayList arrayList = this.f11271n;
        arrayList.clear();
        Collections.addAll(arrayList, this.f11268k);
    }

    @Override // s2.a
    public final void t(v1.g0 g0Var) {
        this.f11268k[0].t(g0Var);
    }

    @Override // s2.l
    public final c0 u(Object obj, c0 c0Var) {
        int iIntValue = ((Integer) obj).intValue();
        ArrayList arrayList = this.f11269l;
        List list = (List) arrayList.get(iIntValue);
        for (int i = 0; i < list.size(); i++) {
            if (((l0) list.get(i)).f11258a.equals(c0Var)) {
                return ((l0) ((List) arrayList.get(0)).get(i)).f11258a;
            }
        }
        return null;
    }

    @Override // s2.l
    public final void x(Object obj, a aVar, v1.f1 f1Var) {
        Integer num = (Integer) obj;
        if (this.f11275r != null) {
            return;
        }
        if (this.f11273p == -1) {
            this.f11273p = f1Var.h();
        } else if (f1Var.h() != this.f11273p) {
            this.f11275r = new a2.a();
            return;
        }
        int length = this.f11274q.length;
        v1.f1[] f1VarArr = this.f11270m;
        if (length == 0) {
            this.f11274q = (long[][]) Array.newInstance((Class<?>) Long.TYPE, this.f11273p, f1VarArr.length);
        }
        ArrayList arrayList = this.f11271n;
        arrayList.remove(aVar);
        f1VarArr[num.intValue()] = f1Var;
        if (arrayList.isEmpty()) {
            n(f1VarArr[0]);
        }
    }
}
