package id;

import dd.e;
import dd.g;
import ge.i;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f6439a;

    public /* synthetic */ a(g gVar) {
        this.f6439a = gVar;
    }

    public ArrayList a(int i, e eVar) {
        i.e(eVar, "download");
        ArrayList arrayList = (ArrayList) this.f6439a.g(i);
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
            if (((e) obj).f3676v == eVar.f3676v) {
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
        i.e(eVar, "downloadInfo");
        this.f6439a.A(eVar);
    }
}
