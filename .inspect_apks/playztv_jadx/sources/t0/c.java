package t0;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f11977a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f11978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i0.d f11979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i0.d f11980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11981e;
    public boolean f;

    public c(g gVar, ArrayList arrayList) {
        i0.d dVar = i0.d.f6160e;
        this.f11979c = dVar;
        this.f11980d = dVar;
        a(arrayList, false);
        a(arrayList, true);
        ArrayList arrayList2 = gVar.f11990b;
        if (!arrayList2.contains(this)) {
            arrayList2.add(this);
            i0.d dVar2 = gVar.f11991c;
            i0.d dVar3 = gVar.f11992d;
            this.f11979c = dVar2;
            this.f11980d = dVar3;
            c();
            b(gVar.f11993e);
        }
        this.f11978b = gVar;
    }

    public final void a(List list, boolean z2) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a aVar = (a) list.get(i);
            aVar.getClass();
            if (true == z2) {
                c cVar = aVar.f11967e;
                if (cVar != null) {
                    throw new IllegalStateException(aVar + " is already controlled by " + cVar);
                }
                aVar.f11967e = this;
                this.f11977a.add(aVar);
            }
        }
    }

    public final void b(int i) {
        ArrayList arrayList = this.f11977a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            a aVar = (a) arrayList.get(size);
            if (!aVar.f11968g) {
                ColorDrawable colorDrawable = aVar.f;
                if (aVar.f11969h != i) {
                    aVar.f11969h = i;
                    colorDrawable.setColor(i);
                    b bVar = aVar.f11964b;
                    bVar.f11974e = colorDrawable;
                    p2.c cVar = bVar.i;
                    if (cVar != null) {
                        ((View) cVar.f10131w).setBackground(colorDrawable);
                    }
                }
            }
        }
    }

    public final void c() {
        int i;
        i0.d dVarC;
        ArrayList arrayList = this.f11977a;
        i0.d dVar = i0.d.f6160e;
        i0.d dVarA = dVar;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            a aVar = (a) arrayList.get(size);
            i0.d dVar2 = this.f11979c;
            i0.d dVar3 = this.f11980d;
            aVar.f11965c = dVar2;
            b bVar = aVar.f11964b;
            aVar.f11966d = dVar3;
            if (!bVar.f11972c.equals(dVarA)) {
                bVar.f11972c = dVarA;
                p2.c cVar = bVar.i;
                if (cVar != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) cVar.f10130v;
                    layoutParams.leftMargin = dVarA.f6161a;
                    layoutParams.topMargin = dVarA.f6162b;
                    layoutParams.rightMargin = dVarA.f6163c;
                    layoutParams.bottomMargin = dVarA.f6164d;
                    ((View) cVar.f10131w).setLayoutParams(layoutParams);
                }
            }
            int i10 = aVar.f11963a;
            if (i10 == 1) {
                i = aVar.f11965c.f6161a;
                int i11 = aVar.f11966d.f6161a;
                if (bVar.f11970a != i11) {
                    bVar.f11970a = i11;
                    p2.c cVar2 = bVar.i;
                    if (cVar2 != null) {
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) cVar2.f10130v;
                        layoutParams2.width = i11;
                        ((View) cVar2.f10131w).setLayoutParams(layoutParams2);
                    }
                }
                dVarC = i0.d.c(i, 0, 0, 0);
            } else if (i10 == 2) {
                i = aVar.f11965c.f6162b;
                int i12 = aVar.f11966d.f6162b;
                if (bVar.f11971b != i12) {
                    bVar.f11971b = i12;
                    p2.c cVar3 = bVar.i;
                    if (cVar3 != null) {
                        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) cVar3.f10130v;
                        layoutParams3.height = i12;
                        ((View) cVar3.f10131w).setLayoutParams(layoutParams3);
                    }
                }
                dVarC = i0.d.c(0, i, 0, 0);
            } else if (i10 == 4) {
                i = aVar.f11965c.f6163c;
                int i13 = aVar.f11966d.f6163c;
                if (bVar.f11970a != i13) {
                    bVar.f11970a = i13;
                    p2.c cVar4 = bVar.i;
                    if (cVar4 != null) {
                        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) cVar4.f10130v;
                        layoutParams4.width = i13;
                        ((View) cVar4.f10131w).setLayoutParams(layoutParams4);
                    }
                }
                dVarC = i0.d.c(0, 0, i, 0);
            } else if (i10 != 8) {
                dVarC = dVar;
                i = 0;
            } else {
                i = aVar.f11965c.f6164d;
                int i14 = aVar.f11966d.f6164d;
                if (bVar.f11971b != i14) {
                    bVar.f11971b = i14;
                    p2.c cVar5 = bVar.i;
                    if (cVar5 != null) {
                        FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) cVar5.f10130v;
                        layoutParams5.height = i14;
                        ((View) cVar5.f10131w).setLayoutParams(layoutParams5);
                    }
                }
                dVarC = i0.d.c(0, 0, 0, i);
            }
            boolean z2 = i > 0;
            if (bVar.f11973d != z2) {
                bVar.f11973d = z2;
                p2.c cVar6 = bVar.i;
                if (cVar6 != null) {
                    ((View) cVar6.f10131w).setVisibility(z2 ? 0 : 4);
                }
            }
            float f = 0.0f;
            aVar.a(i > 0 ? 1.0f : 0.0f);
            if (i > 0) {
                f = 1.0f;
            }
            aVar.b(f);
            dVarA = i0.d.a(dVarA, dVarC);
        }
    }
}
