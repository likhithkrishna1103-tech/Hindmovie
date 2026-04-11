package q4;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f10979a;

    public /* synthetic */ y(RecyclerView recyclerView) {
        this.f10979a = recyclerView;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(q4.x0 r9, b2.m r10, b2.m r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r8.f10979a
            r0.getClass()
            r1 = 0
            r9.n(r1)
            q4.e0 r1 = r0.f1651i0
            r2 = r1
            q4.h r2 = (q4.h) r2
            if (r10 == 0) goto L20
            r2.getClass()
            int r4 = r10.f1761a
            int r6 = r11.f1761a
            if (r4 != r6) goto L22
            int r1 = r10.f1762b
            int r3 = r11.f1762b
            if (r1 == r3) goto L20
            goto L22
        L20:
            r3 = r9
            goto L2c
        L22:
            int r5 = r10.f1762b
            int r7 = r11.f1762b
            r3 = r9
            boolean r9 = r2.g(r3, r4, r5, r6, r7)
            goto L3b
        L2c:
            r2.l(r3)
            android.view.View r9 = r3.f10962a
            r10 = 0
            r9.setAlpha(r10)
            java.util.ArrayList r9 = r2.i
            r9.add(r3)
            r9 = 1
        L3b:
            if (r9 == 0) goto L40
            r0.W()
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.y.a(q4.x0, b2.m, b2.m):void");
    }

    public void b(x0 x0Var, b2.m mVar, b2.m mVar2) {
        boolean zG;
        RecyclerView recyclerView = this.f10979a;
        recyclerView.f1666w.l(x0Var);
        recyclerView.h(x0Var);
        x0Var.n(false);
        h hVar = (h) recyclerView.f1651i0;
        hVar.getClass();
        int i = mVar.f1761a;
        int i10 = mVar.f1762b;
        View view = x0Var.f10962a;
        int left = mVar2 == null ? view.getLeft() : mVar2.f1761a;
        int top = mVar2 == null ? view.getTop() : mVar2.f1762b;
        if (x0Var.h() || (i == left && i10 == top)) {
            hVar.l(x0Var);
            hVar.f10807h.add(x0Var);
            zG = true;
        } else {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            zG = hVar.g(x0Var, i, i10, left, top);
        }
        if (zG) {
            recyclerView.W();
        }
    }
}
