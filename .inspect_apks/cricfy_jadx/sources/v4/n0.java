package v4;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f13307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f13308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f13309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f13310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13311e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public m0 f13312g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f13313h;

    public n0(RecyclerView recyclerView) {
        this.f13313h = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.f13307a = arrayList;
        this.f13308b = null;
        this.f13309c = new ArrayList();
        this.f13310d = Collections.unmodifiableList(arrayList);
        this.f13311e = 2;
        this.f = 2;
    }

    public final void a(x0 x0Var, boolean z10) {
        RecyclerView.l(x0Var);
        View view = x0Var.f13387a;
        RecyclerView recyclerView = this.f13313h;
        y0 y0Var = recyclerView.I0;
        if (y0Var != null) {
            j1.b bVar = y0Var.f13406e;
            t0.m0.n(view, bVar != null ? (t0.b) ((WeakHashMap) bVar.f).remove(view) : null);
        }
        if (z10) {
            ArrayList arrayList = recyclerView.J;
            if (arrayList.size() > 0) {
                throw q4.a.k(0, arrayList);
            }
            z zVar = recyclerView.H;
            if (zVar != null) {
                zVar.g(x0Var);
            }
            if (recyclerView.B0 != null) {
                recyclerView.B.O(x0Var);
            }
            if (RecyclerView.X0) {
                Log.d("RecyclerView", "dispatchViewRecycled: " + x0Var);
            }
        }
        x0Var.f13403s = null;
        x0Var.f13402r = null;
        m0 m0VarC = c();
        m0VarC.getClass();
        int i = x0Var.f;
        ArrayList arrayList2 = m0VarC.a(i).f13299a;
        if (((l0) m0VarC.f13303a.get(i)).f13300b <= arrayList2.size()) {
            z0.a.a(view);
        } else {
            if (RecyclerView.W0 && arrayList2.contains(x0Var)) {
                throw new IllegalArgumentException("this scrap item already exists");
            }
            x0Var.m();
            arrayList2.add(x0Var);
        }
    }

    public final int b(int i) {
        RecyclerView recyclerView = this.f13313h;
        if (i >= 0 && i < recyclerView.B0.b()) {
            return !recyclerView.B0.f13366g ? i : recyclerView.f1455z.u(i, 0);
        }
        StringBuilder sbM = l0.e.m(i, "invalid position ", ". State item count is ");
        sbM.append(recyclerView.B0.b());
        sbM.append(recyclerView.B());
        throw new IndexOutOfBoundsException(sbM.toString());
    }

    public final m0 c() {
        if (this.f13312g == null) {
            m0 m0Var = new m0();
            m0Var.f13303a = new SparseArray();
            m0Var.f13304b = 0;
            m0Var.f13305c = Collections.newSetFromMap(new IdentityHashMap());
            this.f13312g = m0Var;
            e();
        }
        return this.f13312g;
    }

    public final View d(int i) {
        return l(i, Long.MAX_VALUE).f13387a;
    }

    public final void e() {
        RecyclerView recyclerView;
        z zVar;
        m0 m0Var = this.f13312g;
        if (m0Var == null || (zVar = (recyclerView = this.f13313h).H) == null || !recyclerView.N) {
            return;
        }
        m0Var.f13305c.add(zVar);
    }

    public final void f(z zVar, boolean z10) {
        m0 m0Var = this.f13312g;
        if (m0Var != null) {
            SparseArray sparseArray = m0Var.f13303a;
            Set set = m0Var.f13305c;
            set.remove(zVar);
            if (set.size() != 0 || z10) {
                return;
            }
            for (int i = 0; i < sparseArray.size(); i++) {
                ArrayList arrayList = ((l0) sparseArray.get(sparseArray.keyAt(i))).f13299a;
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    z0.a.a(((x0) arrayList.get(i10)).f13387a);
                }
            }
        }
    }

    public final void g() {
        ArrayList arrayList = this.f13309c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            h(size);
        }
        arrayList.clear();
        if (RecyclerView.f1424b1) {
            v.g gVar = this.f13313h.A0;
            int[] iArr = gVar.f12526c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            gVar.f12527d = 0;
        }
    }

    public final void h(int i) {
        if (RecyclerView.X0) {
            Log.d("RecyclerView", "Recycling cached view at index " + i);
        }
        ArrayList arrayList = this.f13309c;
        x0 x0Var = (x0) arrayList.get(i);
        if (RecyclerView.X0) {
            Log.d("RecyclerView", "CachedViewHolder to be recycled: " + x0Var);
        }
        a(x0Var, true);
        arrayList.remove(i);
    }

    public final void i(View view) {
        x0 x0VarM = RecyclerView.M(view);
        boolean zJ = x0VarM.j();
        RecyclerView recyclerView = this.f13313h;
        if (zJ) {
            recyclerView.removeDetachedView(view, false);
        }
        if (x0VarM.i()) {
            x0VarM.f13398n.m(x0VarM);
        } else if (x0VarM.p()) {
            x0VarM.f13394j &= -33;
        }
        j(x0VarM);
        if (recyclerView.f1436j0 == null || x0VarM.g()) {
            return;
        }
        recyclerView.f1436j0.d(x0VarM);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ae, code lost:
    
        r6 = r6 - 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(v4.x0 r13) {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.n0.j(v4.x0):void");
    }

    public final void k(View view) {
        e0 e0Var;
        x0 x0VarM = RecyclerView.M(view);
        int i = x0VarM.f13394j & 12;
        RecyclerView recyclerView = this.f13313h;
        if (i == 0 && x0VarM.k() && (e0Var = recyclerView.f1436j0) != null) {
            h hVar = (h) e0Var;
            if (x0VarM.c().isEmpty() && hVar.f13236g && !x0VarM.f()) {
                if (this.f13308b == null) {
                    this.f13308b = new ArrayList();
                }
                x0VarM.f13398n = this;
                x0VarM.f13399o = true;
                this.f13308b.add(x0VarM);
                return;
            }
        }
        if (x0VarM.f() && !x0VarM.h() && !recyclerView.H.f13408b) {
            throw new IllegalArgumentException(l0.e.i(recyclerView, new StringBuilder("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
        }
        x0VarM.f13398n = this;
        x0VarM.f13399o = false;
        this.f13307a.add(x0VarM);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:120:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0641  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x064b  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0665  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0080  */
    /* JADX WARN: Type inference failed for: r7v59 */
    /* JADX WARN: Type inference failed for: r7v61 */
    /* JADX WARN: Type inference failed for: r7v64 */
    /* JADX WARN: Type inference failed for: r7v75 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final v4.x0 l(int r29, long r30) {
        /*
            Method dump skipped, instruction units count: 1676
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.n0.l(int, long):v4.x0");
    }

    public final void m(x0 x0Var) {
        if (x0Var.f13399o) {
            this.f13308b.remove(x0Var);
        } else {
            this.f13307a.remove(x0Var);
        }
        x0Var.f13398n = null;
        x0Var.f13399o = false;
        x0Var.f13394j &= -33;
    }

    public final void n() {
        h0 h0Var = this.f13313h.I;
        this.f = this.f13311e + (h0Var != null ? h0Var.f13254j : 0);
        ArrayList arrayList = this.f13309c;
        for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f; size--) {
            h(size);
        }
    }
}
