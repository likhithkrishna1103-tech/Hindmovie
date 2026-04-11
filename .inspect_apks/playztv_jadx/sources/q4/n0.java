package q4;

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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f10881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f10882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f10883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f10884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10885e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public m0 f10886g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f10887h;

    public n0(RecyclerView recyclerView) {
        this.f10887h = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.f10881a = arrayList;
        this.f10882b = null;
        this.f10883c = new ArrayList();
        this.f10884d = Collections.unmodifiableList(arrayList);
        this.f10885e = 2;
        this.f = 2;
    }

    public final void a(x0 x0Var, boolean z2) {
        RecyclerView.l(x0Var);
        View view = x0Var.f10962a;
        RecyclerView recyclerView = this.f10887h;
        y0 y0Var = recyclerView.H0;
        if (y0Var != null) {
            e1.b bVar = y0Var.f10981e;
            q0.o0.n(view, bVar != null ? (q0.b) ((WeakHashMap) bVar.f).remove(view) : null);
        }
        if (z2) {
            ArrayList arrayList = recyclerView.I;
            if (arrayList.size() > 0) {
                arrayList.get(0).getClass();
                throw new ClassCastException();
            }
            z zVar = recyclerView.G;
            if (zVar != null) {
                zVar.f(x0Var);
            }
            if (recyclerView.A0 != null) {
                recyclerView.A.u(x0Var);
            }
            if (RecyclerView.W0) {
                Log.d("RecyclerView", "dispatchViewRecycled: " + x0Var);
            }
        }
        x0Var.f10978s = null;
        x0Var.f10977r = null;
        m0 m0VarC = c();
        m0VarC.getClass();
        int i = x0Var.f;
        ArrayList arrayList2 = m0VarC.a(i).f10868a;
        if (((l0) m0VarC.f10878a.get(i)).f10869b <= arrayList2.size()) {
            w0.a.a(view);
        } else {
            if (RecyclerView.V0 && arrayList2.contains(x0Var)) {
                throw new IllegalArgumentException("this scrap item already exists");
            }
            x0Var.m();
            arrayList2.add(x0Var);
        }
    }

    public final int b(int i) {
        RecyclerView recyclerView = this.f10887h;
        if (i >= 0 && i < recyclerView.A0.b()) {
            return !recyclerView.A0.f10940g ? i : recyclerView.f1670y.h(i, 0);
        }
        throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + recyclerView.A0.b() + recyclerView.B());
    }

    public final m0 c() {
        if (this.f10886g == null) {
            m0 m0Var = new m0();
            m0Var.f10878a = new SparseArray();
            m0Var.f10879b = 0;
            m0Var.f10880c = Collections.newSetFromMap(new IdentityHashMap());
            this.f10886g = m0Var;
            d();
        }
        return this.f10886g;
    }

    public final void d() {
        RecyclerView recyclerView;
        z zVar;
        m0 m0Var = this.f10886g;
        if (m0Var == null || (zVar = (recyclerView = this.f10887h).G) == null || !recyclerView.M) {
            return;
        }
        m0Var.f10880c.add(zVar);
    }

    public final void e(z zVar, boolean z2) {
        m0 m0Var = this.f10886g;
        if (m0Var != null) {
            SparseArray sparseArray = m0Var.f10878a;
            Set set = m0Var.f10880c;
            set.remove(zVar);
            if (set.size() != 0 || z2) {
                return;
            }
            for (int i = 0; i < sparseArray.size(); i++) {
                ArrayList arrayList = ((l0) sparseArray.get(sparseArray.keyAt(i))).f10868a;
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    w0.a.a(((x0) arrayList.get(i10)).f10962a);
                }
            }
        }
    }

    public final void f() {
        ArrayList arrayList = this.f10883c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            g(size);
        }
        arrayList.clear();
        if (RecyclerView.a1) {
            k kVar = this.f10887h.f1673z0;
            int[] iArr = kVar.f10859a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            kVar.f10862d = 0;
        }
    }

    public final void g(int i) {
        if (RecyclerView.W0) {
            Log.d("RecyclerView", "Recycling cached view at index " + i);
        }
        ArrayList arrayList = this.f10883c;
        x0 x0Var = (x0) arrayList.get(i);
        if (RecyclerView.W0) {
            Log.d("RecyclerView", "CachedViewHolder to be recycled: " + x0Var);
        }
        a(x0Var, true);
        arrayList.remove(i);
    }

    public final void h(View view) {
        x0 x0VarM = RecyclerView.M(view);
        boolean zJ = x0VarM.j();
        RecyclerView recyclerView = this.f10887h;
        if (zJ) {
            recyclerView.removeDetachedView(view, false);
        }
        if (x0VarM.i()) {
            x0VarM.f10973n.l(x0VarM);
        } else if (x0VarM.p()) {
            x0VarM.f10969j &= -33;
        }
        i(x0VarM);
        if (recyclerView.f1651i0 == null || x0VarM.g()) {
            return;
        }
        recyclerView.f1651i0.d(x0VarM);
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
    public final void i(q4.x0 r13) {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.n0.i(q4.x0):void");
    }

    public final void j(View view) {
        e0 e0Var;
        x0 x0VarM = RecyclerView.M(view);
        int i = x0VarM.f10969j & 12;
        RecyclerView recyclerView = this.f10887h;
        if (i == 0 && x0VarM.k() && (e0Var = recyclerView.f1651i0) != null) {
            h hVar = (h) e0Var;
            if (x0VarM.c().isEmpty() && hVar.f10806g && !x0VarM.f()) {
                if (this.f10882b == null) {
                    this.f10882b = new ArrayList();
                }
                x0VarM.f10973n = this;
                x0VarM.f10974o = true;
                this.f10882b.add(x0VarM);
                return;
            }
        }
        if (x0VarM.f() && !x0VarM.h() && !recyclerView.G.f10983b) {
            throw new IllegalArgumentException(e6.j.k(recyclerView, new StringBuilder("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
        }
        x0VarM.f10973n = this;
        x0VarM.f10974o = false;
        this.f10881a.add(x0VarM);
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
    public final q4.x0 k(int r29, long r30) {
        /*
            Method dump skipped, instruction units count: 1676
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.n0.k(int, long):q4.x0");
    }

    public final void l(x0 x0Var) {
        if (x0Var.f10974o) {
            this.f10882b.remove(x0Var);
        } else {
            this.f10881a.remove(x0Var);
        }
        x0Var.f10973n = null;
        x0Var.f10974o = false;
        x0Var.f10969j &= -33;
    }

    public final void m() {
        h0 h0Var = this.f10887h.H;
        this.f = this.f10885e + (h0Var != null ? h0Var.f10824j : 0);
        ArrayList arrayList = this.f10883c;
        for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f; size--) {
            g(size);
        }
    }
}
