package t2;

import a3.c0;
import a3.i0;
import a3.r;
import a3.t;
import android.util.SparseArray;
import nb.w;
import v1.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements r {
    public static final t E = new t();
    public w A;
    public long B;
    public c0 C;
    public p[] D;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a3.p f11843v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f11844w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final p f11845x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final SparseArray f11846y = new SparseArray();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f11847z;

    public d(a3.p pVar, int i, p pVar2) {
        this.f11843v = pVar;
        this.f11844w = i;
        this.f11845x = pVar2;
    }

    public final void a(w wVar, long j4, long j7) {
        this.A = wVar;
        this.B = j7;
        boolean z10 = this.f11847z;
        a3.p pVar = this.f11843v;
        if (!z10) {
            pVar.c(this);
            if (j4 != -9223372036854775807L) {
                pVar.e(0L, j4);
            }
            this.f11847z = true;
            return;
        }
        if (j4 == -9223372036854775807L) {
            j4 = 0;
        }
        pVar.e(0L, j4);
        int i = 0;
        while (true) {
            SparseArray sparseArray = this.f11846y;
            if (i >= sparseArray.size()) {
                return;
            }
            c cVar = (c) sparseArray.valueAt(i);
            if (wVar == null) {
                cVar.f11842e = cVar.f11840c;
            } else {
                cVar.f = j7;
                i0 i0VarQ = wVar.Q(cVar.f11838a);
                cVar.f11842e = i0VarQ;
                p pVar2 = cVar.f11841d;
                if (pVar2 != null) {
                    i0VarQ.f(pVar2);
                }
            }
            i++;
        }
    }

    @Override // a3.r
    public final void e() {
        SparseArray sparseArray = this.f11846y;
        p[] pVarArr = new p[sparseArray.size()];
        for (int i = 0; i < sparseArray.size(); i++) {
            p pVar = ((c) sparseArray.valueAt(i)).f11841d;
            y1.d.h(pVar);
            pVarArr[i] = pVar;
        }
        this.D = pVarArr;
    }

    @Override // a3.r
    public final i0 p(int i, int i10) {
        SparseArray sparseArray = this.f11846y;
        c cVar = (c) sparseArray.get(i);
        if (cVar == null) {
            y1.d.g(this.D == null);
            cVar = new c(i, i10, i10 == this.f11844w ? this.f11845x : null);
            w wVar = this.A;
            long j4 = this.B;
            if (wVar == null) {
                cVar.f11842e = cVar.f11840c;
            } else {
                cVar.f = j4;
                i0 i0VarQ = wVar.Q(i10);
                cVar.f11842e = i0VarQ;
                p pVar = cVar.f11841d;
                if (pVar != null) {
                    i0VarQ.f(pVar);
                }
            }
            sparseArray.put(i, cVar);
        }
        return cVar;
    }

    @Override // a3.r
    public final void s(c0 c0Var) {
        this.C = c0Var;
    }
}
