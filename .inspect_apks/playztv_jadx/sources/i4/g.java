package i4;

import aa.c1;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;
import p1.l1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends q4.z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f6223d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ s f6224e;
    public final /* synthetic */ int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ s f6225g;

    public g(s sVar, int i) {
        this.f = i;
        this.f6225g = sVar;
        this.f6224e = sVar;
    }

    @Override // q4.z
    public final int a() {
        if (this.f6223d.isEmpty()) {
            return 0;
        }
        return this.f6223d.size() + 1;
    }

    @Override // q4.z
    public /* bridge */ /* synthetic */ void d(q4.x0 x0Var, int i) {
        switch (this.f) {
            case 1:
                i((o) x0Var, i);
                break;
            default:
                i((o) x0Var, i);
                break;
        }
    }

    @Override // q4.z
    public final q4.x0 e(ViewGroup viewGroup, int i) {
        return new o(LayoutInflater.from(this.f6224e.getContext()).inflate(j0.exo_styled_sub_settings_list_item, viewGroup, false));
    }

    public boolean g(l1 l1Var) {
        for (int i = 0; i < this.f6223d.size(); i++) {
            if (l1Var.D.containsKey(((p) this.f6223d.get(i)).f6244a.f9944b)) {
                return true;
            }
        }
        return false;
    }

    public void h(List list) {
        s sVar = this.f6225g;
        ImageView imageView = sVar.Q;
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (i >= ((c1) list).f652x) {
                break;
            }
            p pVar = (p) ((c1) list).get(i);
            if (pVar.f6244a.f9947e[pVar.f6245b]) {
                z2 = true;
                break;
            }
            i++;
        }
        if (imageView != null) {
            imageView.setImageDrawable(z2 ? sVar.f6277t0 : sVar.f6279u0);
            imageView.setContentDescription(z2 ? sVar.f6281v0 : sVar.f6283w0);
        }
        this.f6223d = list;
    }

    public void i(o oVar, int i) {
        switch (this.f) {
            case 1:
                j(oVar, i);
                if (i > 0) {
                    p pVar = (p) this.f6223d.get(i - 1);
                    oVar.f6241v.setVisibility(pVar.f6244a.f9947e[pVar.f6245b] ? 0 : 4);
                }
                break;
            default:
                j(oVar, i);
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(i4.o r7, int r8) {
        /*
            r6 = this;
            i4.s r0 = r6.f6224e
            p1.w0 r0 = r0.B0
            if (r0 != 0) goto L7
            return
        L7:
            if (r8 != 0) goto L78
            int r8 = r6.f
            switch(r8) {
                case 0: goto L4c;
                default: goto Le;
            }
        Le:
            android.widget.TextView r8 = r7.f6240u
            int r0 = i4.l0.exo_track_selection_none
            r8.setText(r0)
            r8 = 0
            r0 = r8
        L17:
            java.util.List r1 = r6.f6223d
            int r1 = r1.size()
            if (r0 >= r1) goto L36
            java.util.List r1 = r6.f6223d
            java.lang.Object r1 = r1.get(r0)
            i4.p r1 = (i4.p) r1
            p1.m1 r2 = r1.f6244a
            int r1 = r1.f6245b
            boolean[] r2 = r2.f9947e
            boolean r1 = r2[r1]
            if (r1 == 0) goto L33
            r0 = r8
            goto L37
        L33:
            int r0 = r0 + 1
            goto L17
        L36:
            r0 = 1
        L37:
            android.view.View r1 = r7.f6241v
            if (r0 == 0) goto L3c
            goto L3d
        L3c:
            r8 = 4
        L3d:
            r1.setVisibility(r8)
            android.view.View r7 = r7.f10962a
            com.google.android.material.datepicker.n r8 = new com.google.android.material.datepicker.n
            r0 = 5
            r8.<init>(r0, r6)
            r7.setOnClickListener(r8)
            goto L77
        L4c:
            android.widget.TextView r8 = r7.f6240u
            int r0 = i4.l0.exo_track_selection_auto
            r8.setText(r0)
            i4.s r8 = r6.f6225g
            p1.w0 r8 = r8.B0
            r8.getClass()
            p1.l1 r8 = r8.E0()
            boolean r8 = r6.g(r8)
            android.view.View r0 = r7.f6241v
            if (r8 == 0) goto L68
            r8 = 4
            goto L69
        L68:
            r8 = 0
        L69:
            r0.setVisibility(r8)
            android.view.View r7 = r7.f10962a
            com.google.android.material.datepicker.n r8 = new com.google.android.material.datepicker.n
            r0 = 3
            r8.<init>(r0, r6)
            r7.setOnClickListener(r8)
        L77:
            return
        L78:
            java.util.List r1 = r6.f6223d
            r2 = 1
            int r8 = r8 - r2
            java.lang.Object r8 = r1.get(r8)
            i4.p r8 = (i4.p) r8
            p1.m1 r1 = r8.f6244a
            p1.g1 r1 = r1.f9944b
            p1.l1 r3 = r0.E0()
            aa.m0 r3 = r3.D
            java.lang.Object r3 = r3.get(r1)
            r4 = 0
            if (r3 == 0) goto L9e
            p1.m1 r3 = r8.f6244a
            int r5 = r8.f6245b
            boolean[] r3 = r3.f9947e
            boolean r3 = r3[r5]
            if (r3 == 0) goto L9e
            goto L9f
        L9e:
            r2 = r4
        L9f:
            android.widget.TextView r3 = r7.f6240u
            java.lang.String r5 = r8.f6246c
            r3.setText(r5)
            android.view.View r3 = r7.f6241v
            if (r2 == 0) goto Lab
            goto Lac
        Lab:
            r4 = 4
        Lac:
            r3.setVisibility(r4)
            android.view.View r7 = r7.f10962a
            i4.q r2 = new i4.q
            r2.<init>()
            r7.setOnClickListener(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i4.g.j(i4.o, int):void");
    }

    private final void k(String str) {
    }
}
