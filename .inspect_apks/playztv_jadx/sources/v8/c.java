package v8;

import android.view.View;
import j9.i0;
import j9.j0;
import java.util.WeakHashMap;
import q0.o0;
import q0.r1;
import w2.b0;
import w2.h0;
import w2.n;
import w2.q;
import yc.f;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements i0, q {
    public static f a(int i) {
        if (i == -1) {
            return f.f14667w;
        }
        f fVar = f.f14668x;
        return i != 0 ? i != 1 ? i != 2 ? fVar : f.f14670z : f.f14669y : fVar;
    }

    @Override // j9.i0
    public r1 b(View view, r1 r1Var, j0 j0Var) {
        j0Var.f6890d = r1Var.a() + j0Var.f6890d;
        WeakHashMap weakHashMap = o0.f10475a;
        boolean z2 = view.getLayoutDirection() == 1;
        int iB = r1Var.b();
        int iC = r1Var.c();
        int i = j0Var.f6887a + (z2 ? iC : iB);
        j0Var.f6887a = i;
        int i10 = j0Var.f6889c;
        if (!z2) {
            iB = iC;
        }
        int i11 = i10 + iB;
        j0Var.f6889c = i11;
        view.setPaddingRelative(i, j0Var.f6888b, i11, j0Var.f6890d);
        return r1Var;
    }

    @Override // w2.q
    public h0 q(int i, int i10) {
        return new n();
    }

    @Override // w2.q
    public void e() {
    }

    @Override // w2.q
    public void j(b0 b0Var) {
    }
}
