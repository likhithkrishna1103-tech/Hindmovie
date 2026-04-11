package com.bumptech.glide;

import i6.r;
import i6.s;
import i6.t;
import i6.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f2785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q2.d f2786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p2.c f2787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ld.c f2788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bumptech.glide.load.data.i f2789e;
    public final q6.c f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final q6.c f2790g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final pb.c f2791h = new pb.c(7);
    public final s6.b i = new s6.b();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final kc.b f2792j;

    public i() {
        kc.b bVar = new kc.b(new p0.e(20), new w2.f(), new ua.c());
        this.f2792j = bVar;
        this.f2785a = new u(bVar);
        this.f2786b = new q2.d(1);
        this.f2787c = new p2.c(11);
        this.f2788d = new ld.c(1);
        this.f2789e = new com.bumptech.glide.load.data.i();
        this.f = new q6.c(0);
        this.f2790g = new q6.c(2);
        List listAsList = Arrays.asList("Animation", "Bitmap", "BitmapDrawable");
        ArrayList arrayList = new ArrayList(listAsList.size());
        arrayList.add("legacy_prepend_all");
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        arrayList.add("legacy_append");
        p2.c cVar = this.f2787c;
        synchronized (cVar) {
            try {
                ArrayList arrayList2 = new ArrayList((ArrayList) cVar.f10130v);
                ((ArrayList) cVar.f10130v).clear();
                int size = arrayList.size();
                int i = 0;
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    ((ArrayList) cVar.f10130v).add((String) obj);
                }
                int size2 = arrayList2.size();
                while (i < size2) {
                    Object obj2 = arrayList2.get(i);
                    i++;
                    String str = (String) obj2;
                    if (!arrayList.contains(str)) {
                        ((ArrayList) cVar.f10130v).add(str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(Class cls, c6.b bVar) {
        q2.d dVar = this.f2786b;
        synchronized (dVar) {
            dVar.f10591a.add(new s6.a(cls, bVar));
        }
    }

    public final void b(Class cls, c6.l lVar) {
        ld.c cVar = this.f2788d;
        synchronized (cVar) {
            cVar.f8125a.add(new s6.d(cls, lVar));
        }
    }

    public final void c(Class cls, Class cls2, s sVar) {
        u uVar = this.f2785a;
        synchronized (uVar) {
            uVar.f6424a.a(cls, cls2, sVar);
            ((HashMap) uVar.f6425b.f11562v).clear();
        }
    }

    public final void d(String str, Class cls, Class cls2, c6.k kVar) {
        p2.c cVar = this.f2787c;
        synchronized (cVar) {
            cVar.i(str).add(new s6.c(cls, cls2, kVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ArrayList e(Class cls, Class cls2, Class cls3) {
        ArrayList arrayList;
        Class cls4 = cls;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayListK = this.f2787c.k(cls4, cls2);
        int size = arrayListK.size();
        int i = 0;
        while (i < size) {
            int i10 = i + 1;
            Class cls5 = (Class) arrayListK.get(i);
            ArrayList arrayListB = this.f.b(cls5, cls3);
            int size2 = arrayListB.size();
            int i11 = 0;
            while (i11 < size2) {
                int i12 = i11 + 1;
                Class cls6 = (Class) arrayListB.get(i11);
                p2.c cVar = this.f2787c;
                synchronized (cVar) {
                    arrayList = new ArrayList();
                    ArrayList arrayList3 = (ArrayList) cVar.f10130v;
                    int size3 = arrayList3.size();
                    int i13 = 0;
                    while (i13 < size3) {
                        Object obj = arrayList3.get(i13);
                        i13++;
                        ArrayList arrayList4 = arrayList3;
                        String str = (String) obj;
                        int i14 = size3;
                        List list = (List) ((HashMap) cVar.f10131w).get(str);
                        if (list != null) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                s6.c cVar2 = (s6.c) it.next();
                                Iterator it2 = it;
                                if (cVar2.f11869a.isAssignableFrom(cls4) && cls5.isAssignableFrom(cVar2.f11870b)) {
                                    arrayList.add(cVar2.f11871c);
                                }
                                it = it2;
                            }
                        }
                        size3 = i14;
                        arrayList3 = arrayList4;
                    }
                }
                arrayList2.add(new e6.l(cls4, cls5, cls6, arrayList, this.f.a(cls5, cls6), this.f2792j));
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
        q6.c cVar = this.f2790g;
        synchronized (cVar) {
            arrayList = cVar.f11021u;
        }
        if (arrayList.isEmpty()) {
            throw new h("Failed to find image header parser.");
        }
        return arrayList;
    }

    public final List g(Object obj) {
        List listUnmodifiableList;
        u uVar = this.f2785a;
        uVar.getClass();
        Class<?> cls = obj.getClass();
        synchronized (uVar) {
            t tVar = (t) ((HashMap) uVar.f6425b.f11562v).get(cls);
            listUnmodifiableList = tVar == null ? null : tVar.f6423a;
            if (listUnmodifiableList == null) {
                listUnmodifiableList = Collections.unmodifiableList(uVar.f6424a.c(cls));
                if (((t) ((HashMap) uVar.f6425b.f11562v).put(cls, new t(listUnmodifiableList))) != null) {
                    throw new IllegalStateException("Already cached loaders for model: " + cls);
                }
            }
        }
        if (listUnmodifiableList.isEmpty()) {
            throw new h("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }
        int size = listUnmodifiableList.size();
        List arrayList = Collections.EMPTY_LIST;
        boolean z2 = true;
        for (int i = 0; i < size; i++) {
            r rVar = (r) listUnmodifiableList.get(i);
            if (rVar.b(obj)) {
                if (z2) {
                    arrayList = new ArrayList(size - i);
                    z2 = false;
                }
                arrayList.add(rVar);
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        throw new h("Found ModelLoaders for model class: " + listUnmodifiableList + ", but none that handle this specific model instance: " + obj);
    }

    public final com.bumptech.glide.load.data.g h(Object obj) {
        com.bumptech.glide.load.data.g gVarB;
        com.bumptech.glide.load.data.i iVar = this.f2789e;
        synchronized (iVar) {
            try {
                x6.f.b(obj);
                com.bumptech.glide.load.data.f fVar = (com.bumptech.glide.load.data.f) ((HashMap) iVar.f2811v).get(obj.getClass());
                if (fVar == null) {
                    Iterator it = ((HashMap) iVar.f2811v).values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.bumptech.glide.load.data.f fVar2 = (com.bumptech.glide.load.data.f) it.next();
                        if (fVar2.a().isAssignableFrom(obj.getClass())) {
                            fVar = fVar2;
                            break;
                        }
                    }
                }
                if (fVar == null) {
                    fVar = com.bumptech.glide.load.data.i.f2809w;
                }
                gVarB = fVar.b(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVarB;
    }

    public final void i(c6.e eVar) {
        q6.c cVar = this.f2790g;
        synchronized (cVar) {
            cVar.f11021u.add(eVar);
        }
    }

    public final void j(com.bumptech.glide.load.data.f fVar) {
        com.bumptech.glide.load.data.i iVar = this.f2789e;
        synchronized (iVar) {
            ((HashMap) iVar.f2811v).put(fVar.a(), fVar);
        }
    }

    public final void k(Class cls, Class cls2, q6.a aVar) {
        q6.c cVar = this.f;
        synchronized (cVar) {
            cVar.f11021u.add(new q6.b(cls, cls2, aVar));
        }
    }

    public final void l(b6.b bVar) {
        u uVar = this.f2785a;
        synchronized (uVar) {
            ArrayList arrayListF = uVar.f6424a.f(bVar);
            int size = arrayListF.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayListF.get(i);
                i++;
                ((s) obj).getClass();
            }
            ((HashMap) uVar.f6425b.f11562v).clear();
        }
    }
}
