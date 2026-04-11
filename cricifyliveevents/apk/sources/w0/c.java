package w0;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f13761a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f13762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l0.c f13763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l0.c f13764d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13765e;
    public boolean f;

    public c(g gVar, ArrayList arrayList) {
        l0.c cVar = l0.c.f7601e;
        this.f13763c = cVar;
        this.f13764d = cVar;
        a(arrayList, false);
        a(arrayList, true);
        ArrayList arrayList2 = gVar.f13774b;
        if (!arrayList2.contains(this)) {
            arrayList2.add(this);
            l0.c cVar2 = gVar.f13775c;
            l0.c cVar3 = gVar.f13776d;
            this.f13763c = cVar2;
            this.f13764d = cVar3;
            c();
            b(gVar.f13777e);
        }
        this.f13762b = gVar;
    }

    public final void a(List list, boolean z10) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a aVar = (a) list.get(i);
            aVar.getClass();
            if (true == z10) {
                c cVar = aVar.f13751e;
                if (cVar != null) {
                    throw new IllegalStateException(aVar + " is already controlled by " + cVar);
                }
                aVar.f13751e = this;
                this.f13761a.add(aVar);
            }
        }
    }

    public final void b(int i) {
        ArrayList arrayList = this.f13761a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            a aVar = (a) arrayList.get(size);
            if (!aVar.f13752g) {
                ColorDrawable colorDrawable = aVar.f;
                if (aVar.f13753h != i) {
                    aVar.f13753h = i;
                    colorDrawable.setColor(i);
                    b bVar = aVar.f13748b;
                    bVar.f13758e = colorDrawable;
                    vb.b bVar2 = bVar.i;
                    if (bVar2 != null) {
                        ((View) bVar2.f13552x).setBackground(colorDrawable);
                    }
                }
            }
        }
    }

    public final void c() {
        int i;
        l0.c cVarC;
        ArrayList arrayList = this.f13761a;
        l0.c cVar = l0.c.f7601e;
        l0.c cVarA = cVar;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            a aVar = (a) arrayList.get(size);
            l0.c cVar2 = this.f13763c;
            l0.c cVar3 = this.f13764d;
            aVar.f13749c = cVar2;
            b bVar = aVar.f13748b;
            aVar.f13750d = cVar3;
            if (!bVar.f13756c.equals(cVarA)) {
                bVar.f13756c = cVarA;
                vb.b bVar2 = bVar.i;
                if (bVar2 != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bVar2.f13551w;
                    layoutParams.leftMargin = cVarA.f7602a;
                    layoutParams.topMargin = cVarA.f7603b;
                    layoutParams.rightMargin = cVarA.f7604c;
                    layoutParams.bottomMargin = cVarA.f7605d;
                    ((View) bVar2.f13552x).setLayoutParams(layoutParams);
                }
            }
            int i10 = aVar.f13747a;
            if (i10 == 1) {
                i = aVar.f13749c.f7602a;
                int i11 = aVar.f13750d.f7602a;
                if (bVar.f13754a != i11) {
                    bVar.f13754a = i11;
                    vb.b bVar3 = bVar.i;
                    if (bVar3 != null) {
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) bVar3.f13551w;
                        layoutParams2.width = i11;
                        ((View) bVar3.f13552x).setLayoutParams(layoutParams2);
                    }
                }
                cVarC = l0.c.c(i, 0, 0, 0);
            } else if (i10 == 2) {
                i = aVar.f13749c.f7603b;
                int i12 = aVar.f13750d.f7603b;
                if (bVar.f13755b != i12) {
                    bVar.f13755b = i12;
                    vb.b bVar4 = bVar.i;
                    if (bVar4 != null) {
                        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) bVar4.f13551w;
                        layoutParams3.height = i12;
                        ((View) bVar4.f13552x).setLayoutParams(layoutParams3);
                    }
                }
                cVarC = l0.c.c(0, i, 0, 0);
            } else if (i10 == 4) {
                i = aVar.f13749c.f7604c;
                int i13 = aVar.f13750d.f7604c;
                if (bVar.f13754a != i13) {
                    bVar.f13754a = i13;
                    vb.b bVar5 = bVar.i;
                    if (bVar5 != null) {
                        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) bVar5.f13551w;
                        layoutParams4.width = i13;
                        ((View) bVar5.f13552x).setLayoutParams(layoutParams4);
                    }
                }
                cVarC = l0.c.c(0, 0, i, 0);
            } else if (i10 != 8) {
                cVarC = cVar;
                i = 0;
            } else {
                i = aVar.f13749c.f7605d;
                int i14 = aVar.f13750d.f7605d;
                if (bVar.f13755b != i14) {
                    bVar.f13755b = i14;
                    vb.b bVar6 = bVar.i;
                    if (bVar6 != null) {
                        FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) bVar6.f13551w;
                        layoutParams5.height = i14;
                        ((View) bVar6.f13552x).setLayoutParams(layoutParams5);
                    }
                }
                cVarC = l0.c.c(0, 0, 0, i);
            }
            boolean z10 = i > 0;
            if (bVar.f13757d != z10) {
                bVar.f13757d = z10;
                vb.b bVar7 = bVar.i;
                if (bVar7 != null) {
                    ((View) bVar7.f13552x).setVisibility(z10 ? 0 : 4);
                }
            }
            float f = 0.0f;
            aVar.a(i > 0 ? 1.0f : 0.0f);
            if (i > 0) {
                f = 1.0f;
            }
            aVar.b(f);
            cVarA = l0.c.a(cVarA, cVarC);
        }
    }
}
