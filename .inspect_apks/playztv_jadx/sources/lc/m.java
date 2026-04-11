package lc;

import androidx.fragment.app.n0;
import androidx.fragment.app.v;
import androidx.fragment.app.v0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m extends k5.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n0 f8108b;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ n f8112g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public androidx.fragment.app.a f8110d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public v f8111e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8109c = 1;

    public m(n nVar, n0 n0Var) {
        this.f8112g = nVar;
        this.f8108b = n0Var;
    }

    @Override // k5.a
    public final void a(Object obj) {
        v vVar = (v) obj;
        if (this.f8110d == null) {
            n0 n0Var = this.f8108b;
            n0Var.getClass();
            this.f8110d = new androidx.fragment.app.a(n0Var);
        }
        androidx.fragment.app.a aVar = this.f8110d;
        aVar.getClass();
        n0 n0Var2 = vVar.M;
        if (n0Var2 != null && n0Var2 != aVar.f1239q) {
            throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + vVar.toString() + " is already attached to a FragmentManager.");
        }
        aVar.b(new v0(6, vVar));
        if (vVar.equals(this.f8111e)) {
            this.f8111e = null;
        }
    }

    @Override // k5.a
    public final void b() {
        androidx.fragment.app.a aVar = this.f8110d;
        if (aVar != null) {
            if (!this.f) {
                try {
                    this.f = true;
                    if (aVar.f1230g) {
                        throw new IllegalStateException("This transaction is already being added to the back stack");
                    }
                    aVar.f1231h = false;
                    aVar.f1239q.y(aVar, true);
                } finally {
                    this.f = false;
                }
            }
            this.f8110d = null;
        }
    }

    @Override // k5.a
    public final int c() {
        return this.f8112g.I0.size();
    }

    @Override // k5.a
    public final void e(k5.i iVar) {
        if (iVar.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }
}
