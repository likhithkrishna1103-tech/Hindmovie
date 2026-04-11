package fd;

import be.h;
import dd.j;
import id.o;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import yc.k;
import zc.e;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f4816a = new LinkedHashSet();

    public final void a(List list, e eVar, o oVar) {
        h.e(list, "downloads");
        h.e(oVar, "reason");
        List list2 = list;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            if (((e) obj).D == k.f14689x) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list2) {
            if (((e) obj2).D == k.F) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : list2) {
            if (((e) obj3).D == k.f14691z) {
                arrayList3.add(obj3);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj4 : list2) {
            if (((e) obj4).D == k.f14690y) {
                arrayList4.add(obj4);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Object obj5 : list2) {
            if (((e) obj5).D == k.A) {
                arrayList5.add(obj5);
            }
        }
        ArrayList arrayList6 = new ArrayList();
        for (Object obj6 : list2) {
            if (((e) obj6).D == k.B) {
                arrayList6.add(obj6);
            }
        }
        ArrayList arrayList7 = new ArrayList();
        for (Object obj7 : list2) {
            if (((e) obj7).D == k.C) {
                arrayList7.add(obj7);
            }
        }
        ArrayList arrayList8 = new ArrayList();
        for (Object obj8 : list2) {
            if (((e) obj8).D == k.E) {
                arrayList8.add(obj8);
            }
        }
        ArrayList arrayList9 = new ArrayList();
        for (Object obj9 : list2) {
            if (((e) obj9).D == k.D) {
                arrayList9.add(obj9);
            }
        }
        if (oVar != o.B) {
            j.f4167c.post(new a2.a(this, list, oVar, eVar));
        }
    }
}
