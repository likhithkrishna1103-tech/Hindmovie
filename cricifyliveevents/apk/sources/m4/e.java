package m4;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;
import ua.z0;
import v1.l1;
import v4.x0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends v4.z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f8170d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ q f8171e;
    public final /* synthetic */ int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ q f8172g;

    public e(q qVar, int i) {
        this.f = i;
        this.f8172g = qVar;
        this.f8171e = qVar;
    }

    @Override // v4.z
    public final int a() {
        if (this.f8170d.isEmpty()) {
            return 0;
        }
        return this.f8170d.size() + 1;
    }

    @Override // v4.z
    public /* bridge */ /* synthetic */ void e(x0 x0Var, int i) {
        switch (this.f) {
            case 1:
                j((m) x0Var, i);
                break;
            default:
                j((m) x0Var, i);
                break;
        }
    }

    @Override // v4.z
    public final x0 f(ViewGroup viewGroup, int i) {
        return new m(LayoutInflater.from(this.f8171e.getContext()).inflate(h0.exo_styled_sub_settings_list_item, viewGroup, false));
    }

    public boolean h(l1 l1Var) {
        for (int i = 0; i < this.f8170d.size(); i++) {
            if (l1Var.D.containsKey(((n) this.f8170d.get(i)).f8194a.f12873b)) {
                return true;
            }
        }
        return false;
    }

    public void i(List list) {
        q qVar = this.f8172g;
        ImageView imageView = qVar.R;
        boolean z10 = false;
        int i = 0;
        while (true) {
            if (i >= ((z0) list).f12415y) {
                break;
            }
            n nVar = (n) ((z0) list).get(i);
            if (nVar.f8194a.f12876e[nVar.f8195b]) {
                z10 = true;
                break;
            }
            i++;
        }
        if (imageView != null) {
            imageView.setImageDrawable(z10 ? qVar.f8247u0 : qVar.f8249v0);
            imageView.setContentDescription(z10 ? qVar.f8251w0 : qVar.f8253x0);
        }
        this.f8170d = list;
    }

    public void j(m mVar, int i) {
        switch (this.f) {
            case 1:
                k(mVar, i);
                if (i > 0) {
                    n nVar = (n) this.f8170d.get(i - 1);
                    mVar.f8188v.setVisibility(nVar.f8194a.f12876e[nVar.f8195b] ? 0 : 4);
                }
                break;
            default:
                k(mVar, i);
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(m4.m r7, int r8) {
        /*
            r6 = this;
            m4.q r0 = r6.f8171e
            v1.w0 r0 = r0.C0
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
            android.widget.TextView r8 = r7.f8187u
            int r0 = m4.j0.exo_track_selection_none
            r8.setText(r0)
            r8 = 0
            r0 = r8
        L17:
            java.util.List r1 = r6.f8170d
            int r1 = r1.size()
            if (r0 >= r1) goto L36
            java.util.List r1 = r6.f8170d
            java.lang.Object r1 = r1.get(r0)
            m4.n r1 = (m4.n) r1
            v1.m1 r2 = r1.f8194a
            int r1 = r1.f8195b
            boolean[] r2 = r2.f12876e
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
            android.view.View r1 = r7.f8188v
            if (r0 == 0) goto L3c
            goto L3d
        L3c:
            r8 = 4
        L3d:
            r1.setVisibility(r8)
            android.view.View r7 = r7.f13387a
            com.google.android.material.datepicker.n r8 = new com.google.android.material.datepicker.n
            r0 = 4
            r8.<init>(r0, r6)
            r7.setOnClickListener(r8)
            goto L77
        L4c:
            android.widget.TextView r8 = r7.f8187u
            int r0 = m4.j0.exo_track_selection_auto
            r8.setText(r0)
            m4.q r8 = r6.f8172g
            v1.w0 r8 = r8.C0
            r8.getClass()
            v1.l1 r8 = r8.E0()
            boolean r8 = r6.h(r8)
            android.view.View r0 = r7.f8188v
            if (r8 == 0) goto L68
            r8 = 4
            goto L69
        L68:
            r8 = 0
        L69:
            r0.setVisibility(r8)
            android.view.View r7 = r7.f13387a
            com.google.android.material.datepicker.n r8 = new com.google.android.material.datepicker.n
            r0 = 2
            r8.<init>(r0, r6)
            r7.setOnClickListener(r8)
        L77:
            return
        L78:
            java.util.List r1 = r6.f8170d
            r2 = 1
            int r8 = r8 - r2
            java.lang.Object r8 = r1.get(r8)
            m4.n r8 = (m4.n) r8
            v1.m1 r1 = r8.f8194a
            v1.g1 r1 = r1.f12873b
            v1.l1 r3 = r0.E0()
            ua.k0 r3 = r3.D
            java.lang.Object r3 = r3.get(r1)
            r4 = 0
            if (r3 == 0) goto L9e
            v1.m1 r3 = r8.f8194a
            int r5 = r8.f8195b
            boolean[] r3 = r3.f12876e
            boolean r3 = r3[r5]
            if (r3 == 0) goto L9e
            goto L9f
        L9e:
            r2 = r4
        L9f:
            android.widget.TextView r3 = r7.f8187u
            java.lang.String r5 = r8.f8196c
            r3.setText(r5)
            android.view.View r3 = r7.f8188v
            if (r2 == 0) goto Lab
            goto Lac
        Lab:
            r4 = 4
        Lac:
            r3.setVisibility(r4)
            android.view.View r7 = r7.f13387a
            m4.o r2 = new m4.o
            r2.<init>()
            r7.setOnClickListener(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.e.k(m4.m, int):void");
    }

    private final void l(String str) {
    }
}
