package d7;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f3448e = new c(6);
    public static final e0 f = new e0(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l7.a f3452d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f3449a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet f3451c = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f3450b = f3448e;

    public a0(l7.a aVar) {
        this.f3452d = aVar;
    }

    public final synchronized void a(Class cls, Class cls2, u uVar) {
        z zVar = new z(cls, cls2, uVar);
        ArrayList arrayList = this.f3449a;
        arrayList.add(arrayList.size(), zVar);
    }

    public final synchronized t b(Class cls, Class cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = this.f3449a;
            int size = arrayList2.size();
            boolean z10 = false;
            int i = 0;
            while (true) {
                boolean z11 = true;
                if (i >= size) {
                    break;
                }
                Object obj = arrayList2.get(i);
                i++;
                z zVar = (z) obj;
                if (this.f3451c.contains(zVar)) {
                    z10 = true;
                } else {
                    if (!zVar.f3519a.isAssignableFrom(cls) || !zVar.f3520b.isAssignableFrom(cls2)) {
                        z11 = false;
                    }
                    if (z11) {
                        this.f3451c.add(zVar);
                        arrayList.add(zVar.f3521c.a(this));
                        this.f3451c.remove(zVar);
                    }
                }
            }
            if (arrayList.size() > 1) {
                c cVar = this.f3450b;
                l7.a aVar = this.f3452d;
                cVar.getClass();
                return new b(2, arrayList, aVar);
            }
            if (arrayList.size() == 1) {
                return (t) arrayList.get(0);
            }
            if (z10) {
                return f;
            }
            throw new com.bumptech.glide.j("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        } catch (Throwable th) {
            this.f3451c.clear();
            throw th;
        }
    }

    public final synchronized ArrayList c(Class cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            ArrayList arrayList2 = this.f3449a;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                z zVar = (z) obj;
                if (!this.f3451c.contains(zVar) && zVar.f3519a.isAssignableFrom(cls)) {
                    this.f3451c.add(zVar);
                    arrayList.add(zVar.f3521c.a(this));
                    this.f3451c.remove(zVar);
                }
            }
        } finally {
        }
        return arrayList;
    }

    public final synchronized ArrayList d(Class cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        ArrayList arrayList2 = this.f3449a;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            z zVar = (z) obj;
            if (!arrayList.contains(zVar.f3520b) && zVar.f3519a.isAssignableFrom(cls)) {
                arrayList.add(zVar.f3520b);
            }
        }
        return arrayList;
    }

    public final synchronized ArrayList e() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f3449a.iterator();
        while (it.hasNext()) {
            z zVar = (z) it.next();
            if (zVar.f3519a.isAssignableFrom(j.class) && zVar.f3520b.isAssignableFrom(InputStream.class)) {
                it.remove();
                arrayList.add(zVar.f3521c);
            }
        }
        return arrayList;
    }

    public final synchronized ArrayList f(w6.b bVar) {
        ArrayList arrayListE;
        arrayListE = e();
        a(j.class, InputStream.class, bVar);
        return arrayListE;
    }
}
