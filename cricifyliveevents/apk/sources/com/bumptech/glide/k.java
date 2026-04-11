package com.bumptech.glide;

import d7.t;
import d7.u;
import d7.v;
import d7.x;
import f9.a0;
import f9.b0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f2214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kf.o f2215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i2.k f2216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m6.c f2217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bumptech.glide.load.data.h f2218e;
    public final kf.o f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i6.c f2219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i2.k f2220h = new i2.k(23);
    public final n7.b i = new n7.b();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final l7.a f2221j;

    public k() {
        l7.a aVar = new l7.a(new s0.e(20), new a0(25), new b0(25));
        this.f2221j = aVar;
        this.f2214a = new x(aVar);
        this.f2215b = new kf.o(2);
        this.f2216c = new i2.k(24);
        this.f2217d = new m6.c(1);
        this.f2218e = new com.bumptech.glide.load.data.h();
        this.f = new kf.o(1);
        this.f2219g = new i6.c(1);
        List listAsList = Arrays.asList("Animation", "Bitmap", "BitmapDrawable");
        ArrayList arrayList = new ArrayList(listAsList.size());
        arrayList.add("legacy_prepend_all");
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        arrayList.add("legacy_append");
        i2.k kVar = this.f2216c;
        synchronized (kVar) {
            try {
                ArrayList arrayList2 = new ArrayList((ArrayList) kVar.f6085v);
                ((ArrayList) kVar.f6085v).clear();
                int size = arrayList.size();
                int i = 0;
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    ((ArrayList) kVar.f6085v).add((String) obj);
                }
                int size2 = arrayList2.size();
                while (i < size2) {
                    Object obj2 = arrayList2.get(i);
                    i++;
                    String str = (String) obj2;
                    if (!arrayList.contains(str)) {
                        ((ArrayList) kVar.f6085v).add(str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(Class cls, Class cls2, u uVar) {
        x xVar = this.f2214a;
        synchronized (xVar) {
            xVar.f3512a.a(cls, cls2, uVar);
            xVar.f3513b.f3511a.clear();
        }
    }

    public final void b(Class cls, x6.b bVar) {
        kf.o oVar = this.f2215b;
        synchronized (oVar) {
            oVar.f7512a.add(new n7.a(cls, bVar));
        }
    }

    public final void c(Class cls, x6.k kVar) {
        m6.c cVar = this.f2217d;
        synchronized (cVar) {
            cVar.f8373v.add(new n7.d(cls, kVar));
        }
    }

    public final void d(String str, Class cls, Class cls2, x6.j jVar) {
        i2.k kVar = this.f2216c;
        synchronized (kVar) {
            kVar.k(str).add(new n7.c(cls, cls2, jVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ArrayList e(Class cls, Class cls2, Class cls3) {
        ArrayList arrayList;
        Class cls4 = cls;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayListL = this.f2216c.l(cls4, cls2);
        int size = arrayListL.size();
        int i = 0;
        while (i < size) {
            int i10 = i + 1;
            Class cls5 = (Class) arrayListL.get(i);
            ArrayList arrayListD = this.f.d(cls5, cls3);
            int size2 = arrayListD.size();
            int i11 = 0;
            while (i11 < size2) {
                int i12 = i11 + 1;
                Class cls6 = (Class) arrayListD.get(i11);
                i2.k kVar = this.f2216c;
                synchronized (kVar) {
                    arrayList = new ArrayList();
                    ArrayList arrayList3 = (ArrayList) kVar.f6085v;
                    int size3 = arrayList3.size();
                    int i13 = 0;
                    while (i13 < size3) {
                        Object obj = arrayList3.get(i13);
                        i13++;
                        ArrayList arrayList4 = arrayList3;
                        String str = (String) obj;
                        int i14 = size3;
                        List list = (List) ((HashMap) kVar.f6086w).get(str);
                        if (list != null) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                n7.c cVar = (n7.c) it.next();
                                Iterator it2 = it;
                                if (cVar.f8853a.isAssignableFrom(cls4) && cls5.isAssignableFrom(cVar.f8854b)) {
                                    arrayList.add(cVar.f8855c);
                                }
                                it = it2;
                            }
                        }
                        size3 = i14;
                        arrayList3 = arrayList4;
                    }
                }
                arrayList2.add(new z6.l(cls4, cls5, cls6, arrayList, this.f.c(cls5, cls6), this.f2221j));
                cls4 = cls;
                i11 = i12;
            }
            cls4 = cls;
            i = i10;
        }
        return arrayList2;
    }

    public final ArrayList f() {
        ArrayList arrayList;
        i6.c cVar = this.f2219g;
        synchronized (cVar) {
            arrayList = cVar.f6231a;
        }
        if (arrayList.isEmpty()) {
            throw new j("Failed to find image header parser.");
        }
        return arrayList;
    }

    public final List g(Object obj) {
        List listUnmodifiableList;
        x xVar = this.f2214a;
        xVar.getClass();
        Class<?> cls = obj.getClass();
        synchronized (xVar) {
            v vVar = (v) xVar.f3513b.f3511a.get(cls);
            listUnmodifiableList = vVar == null ? null : vVar.f3510a;
            if (listUnmodifiableList == null) {
                listUnmodifiableList = Collections.unmodifiableList(xVar.f3512a.c(cls));
                if (((v) xVar.f3513b.f3511a.put(cls, new v(listUnmodifiableList))) != null) {
                    throw new IllegalStateException("Already cached loaders for model: " + cls);
                }
            }
        }
        if (listUnmodifiableList.isEmpty()) {
            throw new j("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }
        int size = listUnmodifiableList.size();
        List arrayList = Collections.EMPTY_LIST;
        boolean z10 = true;
        for (int i = 0; i < size; i++) {
            t tVar = (t) listUnmodifiableList.get(i);
            if (tVar.b(obj)) {
                if (z10) {
                    arrayList = new ArrayList(size - i);
                    z10 = false;
                }
                arrayList.add(tVar);
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        throw new j("Found ModelLoaders for model class: " + listUnmodifiableList + ", but none that handle this specific model instance: " + obj);
    }

    public final com.bumptech.glide.load.data.f h(Object obj) {
        com.bumptech.glide.load.data.f fVarB;
        com.bumptech.glide.load.data.h hVar = this.f2218e;
        synchronized (hVar) {
            try {
                s7.f.b(obj);
                com.bumptech.glide.load.data.e eVar = (com.bumptech.glide.load.data.e) ((HashMap) hVar.f2236w).get(obj.getClass());
                if (eVar == null) {
                    Iterator it = ((HashMap) hVar.f2236w).values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.bumptech.glide.load.data.e eVar2 = (com.bumptech.glide.load.data.e) it.next();
                        if (eVar2.a().isAssignableFrom(obj.getClass())) {
                            eVar = eVar2;
                            break;
                        }
                    }
                }
                if (eVar == null) {
                    eVar = com.bumptech.glide.load.data.h.f2234x;
                }
                fVarB = eVar.b(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVarB;
    }

    public final void i(com.bumptech.glide.load.data.e eVar) {
        com.bumptech.glide.load.data.h hVar = this.f2218e;
        synchronized (hVar) {
            ((HashMap) hVar.f2236w).put(eVar.a(), eVar);
        }
    }

    public final void j(Class cls, Class cls2, l7.b bVar) {
        kf.o oVar = this.f;
        synchronized (oVar) {
            oVar.f7512a.add(new l7.c(cls, cls2, bVar));
        }
    }

    public final void k(x6.d dVar) {
        i6.c cVar = this.f2219g;
        synchronized (cVar) {
            cVar.f6231a.add(dVar);
        }
    }

    public final void l(w6.b bVar) {
        x xVar = this.f2214a;
        synchronized (xVar) {
            ArrayList arrayListF = xVar.f3512a.f(bVar);
            int size = arrayListF.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayListF.get(i);
                i++;
                ((u) obj).getClass();
            }
            xVar.f3513b.f3511a.clear();
        }
    }
}
