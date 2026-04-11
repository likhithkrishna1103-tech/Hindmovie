package i6;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f6435e = new c(6);
    public static final b0 f = new b0(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final kc.b f6439d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f6436a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet f6438c = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f6437b = f6435e;

    public x(kc.b bVar) {
        this.f6439d = bVar;
    }

    public final synchronized void a(Class cls, Class cls2, s sVar) {
        w wVar = new w(cls, cls2, sVar);
        ArrayList arrayList = this.f6436a;
        arrayList.add(arrayList.size(), wVar);
    }

    public final synchronized r b(Class cls, Class cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = this.f6436a;
            int size = arrayList2.size();
            boolean z2 = false;
            int i = 0;
            while (true) {
                boolean z10 = true;
                if (i >= size) {
                    break;
                }
                Object obj = arrayList2.get(i);
                i++;
                w wVar = (w) obj;
                if (this.f6438c.contains(wVar)) {
                    z2 = true;
                } else {
                    if (!wVar.f6432a.isAssignableFrom(cls) || !wVar.f6433b.isAssignableFrom(cls2)) {
                        z10 = false;
                    }
                    if (z10) {
                        this.f6438c.add(wVar);
                        arrayList.add(wVar.f6434c.a(this));
                        this.f6438c.remove(wVar);
                    }
                }
            }
            if (arrayList.size() > 1) {
                c cVar = this.f6437b;
                kc.b bVar = this.f6439d;
                cVar.getClass();
                return new b(arrayList, 2, bVar);
            }
            if (arrayList.size() == 1) {
                return (r) arrayList.get(0);
            }
            if (z2) {
                return f;
            }
            throw new com.bumptech.glide.h("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        } catch (Throwable th) {
            this.f6438c.clear();
            throw th;
        }
    }

    public final synchronized ArrayList c(Class cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            ArrayList arrayList2 = this.f6436a;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                w wVar = (w) obj;
                if (!this.f6438c.contains(wVar) && wVar.f6432a.isAssignableFrom(cls)) {
                    this.f6438c.add(wVar);
                    arrayList.add(wVar.f6434c.a(this));
                    this.f6438c.remove(wVar);
                }
            }
        } finally {
        }
        return arrayList;
    }

    public final synchronized ArrayList d(Class cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        ArrayList arrayList2 = this.f6436a;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            w wVar = (w) obj;
            if (!arrayList.contains(wVar.f6433b) && wVar.f6432a.isAssignableFrom(cls)) {
                arrayList.add(wVar.f6433b);
            }
        }
        return arrayList;
    }

    public final synchronized ArrayList e() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f6436a.iterator();
        while (it.hasNext()) {
            w wVar = (w) it.next();
            if (wVar.f6432a.isAssignableFrom(h.class) && wVar.f6433b.isAssignableFrom(InputStream.class)) {
                it.remove();
                arrayList.add(wVar.f6434c);
            }
        }
        return arrayList;
    }

    public final synchronized ArrayList f(b6.b bVar) {
        ArrayList arrayListE;
        arrayListE = e();
        a(h.class, InputStream.class, bVar);
        return arrayListE;
    }
}
