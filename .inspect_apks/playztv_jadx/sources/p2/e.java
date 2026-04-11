package p2;

import android.util.SparseArray;
import w2.b0;
import w2.h0;
import w2.q;
import w2.s;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements q {
    public static final s D = new s();
    public long A;
    public b0 B;
    public p1.q[] C;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final w2.o f10137u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f10138v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final p1.q f10139w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final SparseArray f10140x = new SparseArray();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f10141y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public c f10142z;

    public e(w2.o oVar, int i, p1.q qVar) {
        this.f10137u = oVar;
        this.f10138v = i;
        this.f10139w = qVar;
    }

    public final void a(c cVar, long j5, long j8) {
        this.f10142z = cVar;
        this.A = j8;
        boolean z2 = this.f10141y;
        w2.o oVar = this.f10137u;
        if (!z2) {
            oVar.c(this);
            if (j5 != -9223372036854775807L) {
                oVar.f(0L, j5);
            }
            this.f10141y = true;
            return;
        }
        if (j5 == -9223372036854775807L) {
            j5 = 0;
        }
        oVar.f(0L, j5);
        int i = 0;
        while (true) {
            SparseArray sparseArray = this.f10140x;
            if (i >= sparseArray.size()) {
                return;
            }
            d dVar = (d) sparseArray.valueAt(i);
            if (cVar == null) {
                dVar.f10136e = dVar.f10134c;
            } else {
                dVar.f = j8;
                h0 h0VarW = cVar.w(dVar.f10132a);
                dVar.f10136e = h0VarW;
                p1.q qVar = dVar.f10135d;
                if (qVar != null) {
                    h0VarW.d(qVar);
                }
            }
            i++;
        }
    }

    @Override // w2.q
    public final void e() {
        SparseArray sparseArray = this.f10140x;
        p1.q[] qVarArr = new p1.q[sparseArray.size()];
        for (int i = 0; i < sparseArray.size(); i++) {
            p1.q qVar = ((d) sparseArray.valueAt(i)).f10135d;
            s1.d.h(qVar);
            qVarArr[i] = qVar;
        }
        this.C = qVarArr;
    }

    @Override // w2.q
    public final void j(b0 b0Var) {
        this.B = b0Var;
    }

    @Override // w2.q
    public final h0 q(int i, int i10) {
        SparseArray sparseArray = this.f10140x;
        d dVar = (d) sparseArray.get(i);
        if (dVar == null) {
            s1.d.g(this.C == null);
            dVar = new d(i, i10, i10 == this.f10138v ? this.f10139w : null);
            c cVar = this.f10142z;
            long j5 = this.A;
            if (cVar == null) {
                dVar.f10136e = dVar.f10134c;
            } else {
                dVar.f = j5;
                h0 h0VarW = cVar.w(i10);
                dVar.f10136e = h0VarW;
                p1.q qVar = dVar.f10135d;
                if (qVar != null) {
                    h0VarW.d(qVar);
                }
            }
            sparseArray.put(i, dVar);
        }
        return dVar;
    }
}
