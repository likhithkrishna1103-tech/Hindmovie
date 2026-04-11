package q9;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import nb.w;
import t0.p1;
import t0.z0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a7.a {
    public final int[] A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final View f10460x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f10461y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f10462z;

    public b(View view) {
        super(5, false);
        this.A = new int[2];
        this.f10460x = view;
    }

    @Override // a7.a
    public final void f1(z0 z0Var) {
        this.f10460x.setTranslationY(0.0f);
    }

    @Override // a7.a
    public final void g1(z0 z0Var) {
        View view = this.f10460x;
        int[] iArr = this.A;
        view.getLocationOnScreen(iArr);
        this.f10461y = iArr[1];
    }

    @Override // a7.a
    public final p1 h1(p1 p1Var, List list) {
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if ((((z0) it.next()).f11831a.d() & 8) != 0) {
                this.f10460x.setTranslationY(l9.a.c(r0.f11831a.c(), this.f10462z, 0));
                break;
            }
        }
        return p1Var;
    }

    @Override // a7.a
    public final w i1(z0 z0Var, w wVar) {
        View view = this.f10460x;
        int[] iArr = this.A;
        view.getLocationOnScreen(iArr);
        int i = this.f10461y - iArr[1];
        this.f10462z = i;
        view.setTranslationY(i);
        return wVar;
    }
}
