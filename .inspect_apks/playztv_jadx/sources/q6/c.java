package q6;

import java.util.ArrayList;
import java.util.List;
import o5.j;
import o5.m;
import r5.e;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements e {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList f11021u;

    public c(int i) {
        switch (i) {
            case 2:
                this.f11021u = new ArrayList();
                break;
            default:
                this.f11021u = new ArrayList();
                break;
        }
    }

    @Override // r5.e
    public o5.e D0() {
        ArrayList arrayList = this.f11021u;
        return ((y5.a) arrayList.get(0)).c() ? new j(1, arrayList) : new m(arrayList);
    }

    @Override // r5.e
    public List S0() {
        return this.f11021u;
    }

    @Override // r5.e
    public boolean Y0() {
        ArrayList arrayList = this.f11021u;
        return arrayList.size() == 1 && ((y5.a) arrayList.get(0)).c();
    }

    public synchronized a a(Class cls, Class cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return d.f11022v;
        }
        ArrayList arrayList = this.f11021u;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            b bVar = (b) obj;
            if (bVar.f11018a.isAssignableFrom(cls) && cls2.isAssignableFrom(bVar.f11019b)) {
                return bVar.f11020c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized ArrayList b(Class cls, Class cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        ArrayList arrayList2 = this.f11021u;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            b bVar = (b) obj;
            if ((bVar.f11018a.isAssignableFrom(cls) && cls2.isAssignableFrom(bVar.f11019b)) && !arrayList.contains(bVar.f11019b)) {
                arrayList.add(bVar.f11019b);
            }
        }
        return arrayList;
    }

    public c(ArrayList arrayList) {
        this.f11021u = arrayList;
    }
}
