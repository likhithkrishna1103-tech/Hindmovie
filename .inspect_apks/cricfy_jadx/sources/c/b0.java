package c;

import androidx.fragment.app.i0;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f1931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public nc.p f1933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i0 f1934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1935e;

    public b0(i0 i0Var, c0 c0Var) {
        ge.i.e(i0Var, "onBackPressedCallback");
        boolean z10 = i0Var.f998b;
        this.f1931a = c0Var;
        this.f1932b = z10;
        this.f1934d = i0Var;
        this.f1935e = true;
    }

    public final void a() {
        nc.p pVar = this.f1933c;
        if (pVar == null || !((LinkedHashSet) pVar.f9071c).remove(this)) {
            return;
        }
        o4.e eVar = (o4.e) pVar.f9070b;
        eVar.getClass();
        if (equals(eVar.f)) {
            if (eVar.f9495g == -1) {
                this.f1934d.getClass();
            }
            eVar.f = null;
            eVar.f9495g = 0;
            eVar.f9496h = null;
        }
        eVar.f9493d.remove(this);
        eVar.f9494e.remove(this);
        this.f1933c = null;
        eVar.b();
    }

    public final void b(boolean z10) {
        o4.e eVar;
        if (this.f1932b == z10) {
            return;
        }
        this.f1932b = z10;
        nc.p pVar = this.f1933c;
        if (pVar == null || (eVar = (o4.e) pVar.f9070b) == null) {
            return;
        }
        eVar.b();
    }

    public final void c(boolean z10) {
        this.f1935e = z10;
        b(z10 && this.f1934d.f998b);
    }
}
