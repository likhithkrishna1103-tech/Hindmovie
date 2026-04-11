package jd;

import androidx.emoji2.text.w;
import cd.l;
import dd.e;
import ge.i;
import hd.g;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import md.n;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f6745a = new LinkedHashSet();

    public final void a(List list, e eVar, n nVar) {
        i.e(list, "downloads");
        i.e(nVar, "reason");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((e) obj).E == l.f2187y) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list) {
            if (((e) obj2).E == l.G) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : list) {
            if (((e) obj3).E == l.A) {
                arrayList3.add(obj3);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj4 : list) {
            if (((e) obj4).E == l.f2188z) {
                arrayList4.add(obj4);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Object obj5 : list) {
            if (((e) obj5).E == l.B) {
                arrayList5.add(obj5);
            }
        }
        ArrayList arrayList6 = new ArrayList();
        for (Object obj6 : list) {
            if (((e) obj6).E == l.C) {
                arrayList6.add(obj6);
            }
        }
        ArrayList arrayList7 = new ArrayList();
        for (Object obj7 : list) {
            if (((e) obj7).E == l.D) {
                arrayList7.add(obj7);
            }
        }
        ArrayList arrayList8 = new ArrayList();
        for (Object obj8 : list) {
            if (((e) obj8).E == l.F) {
                arrayList8.add(obj8);
            }
        }
        ArrayList arrayList9 = new ArrayList();
        for (Object obj9 : list) {
            if (((e) obj9).E == l.E) {
                arrayList9.add(obj9);
            }
        }
        if (nVar != n.C) {
            g.f5941c.post(new w(this, list, nVar, eVar));
        }
    }
}
