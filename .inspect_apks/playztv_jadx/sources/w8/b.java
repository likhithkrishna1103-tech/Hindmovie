package w8;

import android.view.View;
import c3.e;
import java.util.Iterator;
import java.util.List;
import pb.c;
import q0.b1;
import q0.r1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends e {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final View f13756w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f13757x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f13758y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int[] f13759z;

    public b(View view) {
        super(6, false);
        this.f13759z = new int[2];
        this.f13756w = view;
    }

    @Override // c3.e
    public final void f1(b1 b1Var) {
        this.f13756w.setTranslationY(0.0f);
    }

    @Override // c3.e
    public final void g1(b1 b1Var) {
        View view = this.f13756w;
        int[] iArr = this.f13759z;
        view.getLocationOnScreen(iArr);
        this.f13757x = iArr[1];
    }

    @Override // c3.e
    public final r1 h1(r1 r1Var, List list) {
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if ((((b1) it.next()).f10421a.d() & 8) != 0) {
                this.f13756w.setTranslationY(q8.a.c(r0.f10421a.c(), this.f13758y, 0));
                break;
            }
        }
        return r1Var;
    }

    @Override // c3.e
    public final c i1(b1 b1Var, c cVar) {
        View view = this.f13756w;
        int[] iArr = this.f13759z;
        view.getLocationOnScreen(iArr);
        int i = this.f13757x - iArr[1];
        this.f13758y = i;
        view.setTranslationY(i);
        return cVar;
    }
}
