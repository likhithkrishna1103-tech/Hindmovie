package v5;

import androidx.fragment.app.a1;
import androidx.fragment.app.r0;
import androidx.fragment.app.y;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r extends p5.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r0 f13446b;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ s f13450g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public androidx.fragment.app.a f13448d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y f13449e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13447c = 1;

    public r(s sVar, r0 r0Var) {
        this.f13450g = sVar;
        this.f13446b = r0Var;
    }

    @Override // p5.a
    public final void a(Object obj) {
        y yVar = (y) obj;
        if (this.f13448d == null) {
            r0 r0Var = this.f13446b;
            r0Var.getClass();
            this.f13448d = new androidx.fragment.app.a(r0Var);
        }
        androidx.fragment.app.a aVar = this.f13448d;
        aVar.getClass();
        r0 r0Var2 = yVar.N;
        if (r0Var2 != null && r0Var2 != aVar.f925q) {
            throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + yVar.toString() + " is already attached to a FragmentManager.");
        }
        aVar.b(new a1(6, yVar));
        if (yVar.equals(this.f13449e)) {
            this.f13449e = null;
        }
    }

    @Override // p5.a
    public final void b() {
        androidx.fragment.app.a aVar = this.f13448d;
        if (aVar != null) {
            if (!this.f) {
                try {
                    this.f = true;
                    if (aVar.f916g) {
                        throw new IllegalStateException("This transaction is already being added to the back stack");
                    }
                    aVar.f917h = false;
                    aVar.f925q.B(aVar, true);
                } finally {
                    this.f = false;
                }
            }
            this.f13448d = null;
        }
    }

    @Override // p5.a
    public final int c() {
        return this.f13450g.J0.size();
    }

    @Override // p5.a
    public final void e(p5.g gVar) {
        if (gVar.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }
}
