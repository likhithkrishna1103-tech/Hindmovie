package q6;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nb.w f10429a = nb.w.I("k");

    public static ArrayList a(r6.a aVar, g6.i iVar, float f, e0 e0Var, boolean z10) {
        r6.a aVar2;
        g6.i iVar2;
        float f10;
        e0 e0Var2;
        boolean z11;
        ArrayList arrayList = new ArrayList();
        if (aVar.R() == 6) {
            iVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        aVar.g();
        while (aVar.A()) {
            if (aVar.g0(f10429a) != 0) {
                aVar.i0();
            } else if (aVar.R() == 1) {
                aVar.a();
                if (aVar.R() == 7) {
                    r6.a aVar3 = aVar;
                    g6.i iVar3 = iVar;
                    float f11 = f;
                    e0 e0Var3 = e0Var;
                    boolean z12 = z10;
                    t6.a aVarB = p.b(aVar3, iVar3, f11, e0Var3, false, z12);
                    aVar2 = aVar3;
                    iVar2 = iVar3;
                    f10 = f11;
                    e0Var2 = e0Var3;
                    z11 = z12;
                    arrayList.add(aVarB);
                } else {
                    aVar2 = aVar;
                    iVar2 = iVar;
                    f10 = f;
                    e0Var2 = e0Var;
                    z11 = z10;
                    while (aVar2.A()) {
                        arrayList.add(p.b(aVar2, iVar2, f10, e0Var2, true, z11));
                    }
                }
                aVar2.q();
                aVar = aVar2;
                iVar = iVar2;
                f = f10;
                e0Var = e0Var2;
                z10 = z11;
            } else {
                r6.a aVar4 = aVar;
                arrayList.add(p.b(aVar4, iVar, f, e0Var, false, z10));
                aVar = aVar4;
            }
        }
        aVar.s();
        b(arrayList);
        return arrayList;
    }

    public static void b(ArrayList arrayList) {
        int i;
        Object obj;
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            i = size - 1;
            if (i10 >= i) {
                break;
            }
            t6.a aVar = (t6.a) arrayList.get(i10);
            i10++;
            t6.a aVar2 = (t6.a) arrayList.get(i10);
            aVar.f11937h = Float.valueOf(aVar2.f11936g);
            if (aVar.f11933c == null && (obj = aVar2.f11932b) != null) {
                aVar.f11933c = obj;
                if (aVar instanceof j6.l) {
                    ((j6.l) aVar).d();
                }
            }
        }
        t6.a aVar3 = (t6.a) arrayList.get(i);
        if ((aVar3.f11932b == null || aVar3.f11933c == null) && arrayList.size() > 1) {
            arrayList.remove(aVar3);
        }
    }
}
