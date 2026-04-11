package v4;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z0 extends k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13410a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f13411b;

    public z0(v vVar) {
        this.f13411b = vVar;
    }

    @Override // v4.k0
    public final void a(int i) {
        if (i == 0 && this.f13410a) {
            this.f13410a = false;
            this.f13411b.f();
        }
    }

    @Override // v4.k0
    public final void b(RecyclerView recyclerView, int i, int i10) {
        if (i == 0 && i10 == 0) {
            return;
        }
        this.f13410a = true;
    }
}
