package v4;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f13385a;

    public /* synthetic */ x(RecyclerView recyclerView) {
        this.f13385a = recyclerView;
    }

    public void a(a aVar) {
        int i = aVar.f13174a;
        RecyclerView recyclerView = this.f13385a;
        if (i == 1) {
            recyclerView.I.Z(aVar.f13175b, aVar.f13177d);
            return;
        }
        if (i == 2) {
            recyclerView.I.c0(aVar.f13175b, aVar.f13177d);
        } else if (i == 4) {
            recyclerView.I.d0(aVar.f13175b, aVar.f13177d);
        } else {
            if (i != 8) {
                return;
            }
            recyclerView.I.b0(aVar.f13175b, aVar.f13177d);
        }
    }

    public x0 b(int i) {
        RecyclerView recyclerView = this.f13385a;
        int iY = recyclerView.A.y();
        int i10 = 0;
        x0 x0Var = null;
        while (true) {
            if (i10 >= iY) {
                break;
            }
            x0 x0VarM = RecyclerView.M(recyclerView.A.x(i10));
            if (x0VarM != null && !x0VarM.h() && x0VarM.f13389c == i) {
                if (!((ArrayList) recyclerView.A.f4602z).contains(x0VarM.f13387a)) {
                    x0Var = x0VarM;
                    break;
                }
                x0Var = x0VarM;
            }
            i10++;
        }
        if (x0Var != null) {
            if (!((ArrayList) recyclerView.A.f4602z).contains(x0Var.f13387a)) {
                return x0Var;
            }
            if (RecyclerView.X0) {
                Log.d("RecyclerView", "assuming view holder cannot be find because it is hidden");
            }
        }
        return null;
    }

    public void c(int i, int i10, Object obj) {
        int i11;
        int i12;
        RecyclerView recyclerView = this.f13385a;
        int iY = recyclerView.A.y();
        int i13 = i10 + i;
        for (int i14 = 0; i14 < iY; i14++) {
            View viewX = recyclerView.A.x(i14);
            x0 x0VarM = RecyclerView.M(viewX);
            if (x0VarM != null && !x0VarM.o() && (i12 = x0VarM.f13389c) >= i && i12 < i13) {
                x0VarM.a(2);
                if (obj == null) {
                    x0VarM.a(1024);
                } else if ((1024 & x0VarM.f13394j) == 0) {
                    if (x0VarM.f13395k == null) {
                        ArrayList arrayList = new ArrayList();
                        x0VarM.f13395k = arrayList;
                        x0VarM.f13396l = Collections.unmodifiableList(arrayList);
                    }
                    x0VarM.f13395k.add(obj);
                }
                ((i0) viewX.getLayoutParams()).f13263c = true;
            }
        }
        n0 n0Var = recyclerView.f1451x;
        ArrayList arrayList2 = n0Var.f13309c;
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            x0 x0Var = (x0) arrayList2.get(size);
            if (x0Var != null && (i11 = x0Var.f13389c) >= i && i11 < i13) {
                x0Var.a(2);
                n0Var.h(size);
            }
        }
        recyclerView.F0 = true;
    }

    public void d(int i, int i10) {
        RecyclerView recyclerView = this.f13385a;
        int iY = recyclerView.A.y();
        for (int i11 = 0; i11 < iY; i11++) {
            x0 x0VarM = RecyclerView.M(recyclerView.A.x(i11));
            if (x0VarM != null && !x0VarM.o() && x0VarM.f13389c >= i) {
                if (RecyclerView.X0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert attached child " + i11 + " holder " + x0VarM + " now at position " + (x0VarM.f13389c + i10));
                }
                x0VarM.l(i10, false);
                recyclerView.B0.f = true;
            }
        }
        ArrayList arrayList = recyclerView.f1451x.f13309c;
        int size = arrayList.size();
        for (int i12 = 0; i12 < size; i12++) {
            x0 x0Var = (x0) arrayList.get(i12);
            if (x0Var != null && x0Var.f13389c >= i) {
                if (RecyclerView.X0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert cached " + i12 + " holder " + x0Var + " now at position " + (x0Var.f13389c + i10));
                }
                x0Var.l(i10, false);
            }
        }
        recyclerView.requestLayout();
        recyclerView.E0 = true;
    }

    public void e(int i, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        RecyclerView recyclerView = this.f13385a;
        int iY = recyclerView.A.y();
        if (i < i10) {
            i12 = i;
            i11 = i10;
            i13 = -1;
        } else {
            i11 = i;
            i12 = i10;
            i13 = 1;
        }
        boolean z10 = false;
        for (int i19 = 0; i19 < iY; i19++) {
            x0 x0VarM = RecyclerView.M(recyclerView.A.x(i19));
            if (x0VarM != null && (i18 = x0VarM.f13389c) >= i12 && i18 <= i11) {
                if (RecyclerView.X0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForMove attached child " + i19 + " holder " + x0VarM);
                }
                if (x0VarM.f13389c == i) {
                    x0VarM.l(i10 - i, false);
                } else {
                    x0VarM.l(i13, false);
                }
                recyclerView.B0.f = true;
            }
        }
        ArrayList arrayList = recyclerView.f1451x.f13309c;
        if (i < i10) {
            i15 = i;
            i14 = i10;
            i16 = -1;
        } else {
            i14 = i;
            i15 = i10;
            i16 = 1;
        }
        int size = arrayList.size();
        int i20 = 0;
        while (i20 < size) {
            x0 x0Var = (x0) arrayList.get(i20);
            if (x0Var != null && (i17 = x0Var.f13389c) >= i15 && i17 <= i14) {
                if (i17 == i) {
                    x0Var.l(i10 - i, z10);
                } else {
                    x0Var.l(i16, z10);
                }
                if (RecyclerView.X0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForMove cached child " + i20 + " holder " + x0Var);
                }
            }
            i20++;
            z10 = false;
        }
        recyclerView.requestLayout();
        recyclerView.E0 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(v4.x0 r9, d4.e r10, d4.e r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r8.f13385a
            r0.getClass()
            r1 = 0
            r9.n(r1)
            v4.e0 r1 = r0.f1436j0
            r2 = r1
            v4.h r2 = (v4.h) r2
            if (r10 == 0) goto L20
            r2.getClass()
            int r4 = r10.f3356a
            int r6 = r11.f3356a
            if (r4 != r6) goto L22
            int r1 = r10.f3357b
            int r3 = r11.f3357b
            if (r1 == r3) goto L20
            goto L22
        L20:
            r3 = r9
            goto L2c
        L22:
            int r5 = r10.f3357b
            int r7 = r11.f3357b
            r3 = r9
            boolean r9 = r2.g(r3, r4, r5, r6, r7)
            goto L3b
        L2c:
            r2.l(r3)
            android.view.View r9 = r3.f13387a
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
        throw new UnsupportedOperationException("Method not decompiled: v4.x.f(v4.x0, d4.e, d4.e):void");
    }

    public void g(x0 x0Var, d4.e eVar, d4.e eVar2) {
        boolean zG;
        RecyclerView recyclerView = this.f13385a;
        recyclerView.f1451x.m(x0Var);
        recyclerView.h(x0Var);
        x0Var.n(false);
        h hVar = (h) recyclerView.f1436j0;
        hVar.getClass();
        int i = eVar.f3356a;
        int i10 = eVar.f3357b;
        View view = x0Var.f13387a;
        int left = eVar2 == null ? view.getLeft() : eVar2.f3356a;
        int top = eVar2 == null ? view.getTop() : eVar2.f3357b;
        if (x0Var.h() || (i == left && i10 == top)) {
            hVar.l(x0Var);
            hVar.f13237h.add(x0Var);
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
