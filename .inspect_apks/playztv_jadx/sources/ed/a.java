package ed;

import be.h;
import java.util.ArrayList;
import zc.e;
import zc.g;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f4676a;

    public /* synthetic */ a(g gVar) {
        this.f4676a = gVar;
    }

    public ArrayList a(int i, e eVar) {
        h.e(eVar, "download");
        ArrayList arrayList = (ArrayList) this.f4676a.d(i);
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                i10 = -1;
                break;
            }
            Object obj = arrayList.get(i11);
            i11++;
            if (((e) obj).f14950u == eVar.f14950u) {
                break;
            }
            i10++;
        }
        if (i10 != -1) {
            arrayList.set(i10, eVar);
        }
        return arrayList;
    }

    public void b(e eVar) {
        h.e(eVar, "downloadInfo");
        this.f4676a.G(eVar);
    }
}
