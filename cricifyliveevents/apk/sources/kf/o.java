package kf;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f7512a;

    public o(int i) {
        switch (i) {
            case 1:
                this.f7512a = new ArrayList();
                break;
            case 2:
                this.f7512a = new ArrayList();
                break;
            default:
                this.f7512a = new ArrayList(20);
                break;
        }
    }

    public void a(String str, String str2) {
        ge.i.e(str, "name");
        ge.i.e(str2, "value");
        n5.a.t(str);
        n5.a.u(str2, str);
        n5.a.f(this, str, str2);
    }

    public p b() {
        return new p((String[]) this.f7512a.toArray(new String[0]));
    }

    public synchronized l7.b c(Class cls, Class cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return l7.d.f7872w;
        }
        ArrayList arrayList = this.f7512a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            l7.c cVar = (l7.c) obj;
            if (cVar.f7869a.isAssignableFrom(cls) && cls2.isAssignableFrom(cVar.f7870b)) {
                return cVar.f7871c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized ArrayList d(Class cls, Class cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        ArrayList arrayList2 = this.f7512a;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            l7.c cVar = (l7.c) obj;
            if ((cVar.f7869a.isAssignableFrom(cls) && cls2.isAssignableFrom(cVar.f7870b)) && !arrayList.contains(cVar.f7870b)) {
                arrayList.add(cVar.f7870b);
            }
        }
        return arrayList;
    }

    public void e(String str) {
        ge.i.e(str, "name");
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f7512a;
            if (i >= arrayList.size()) {
                return;
            }
            if (str.equalsIgnoreCase((String) arrayList.get(i))) {
                arrayList.remove(i);
                arrayList.remove(i);
                i -= 2;
            }
            i += 2;
        }
    }
}
