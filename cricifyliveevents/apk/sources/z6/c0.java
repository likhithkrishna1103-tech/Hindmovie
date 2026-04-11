package z6;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 implements g, com.bumptech.glide.load.data.c {
    public List A;
    public int B;
    public volatile d7.s C;
    public File D;
    public d0 E;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final k f15237v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final h f15238w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f15239x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f15240y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public x6.e f15241z;

    public c0(h hVar, k kVar) {
        this.f15238w = hVar;
        this.f15237v = kVar;
    }

    @Override // z6.g
    public final boolean b() {
        List list;
        boolean z10;
        List list2;
        boolean z11;
        ArrayList arrayListA = this.f15238w.a();
        if (arrayListA.isEmpty()) {
            return false;
        }
        h hVar = this.f15238w;
        com.bumptech.glide.k kVarB = hVar.f15261c.b();
        Class<?> cls = hVar.f15262d.getClass();
        Class cls2 = hVar.f15264g;
        Class cls3 = hVar.f15267k;
        i2.k kVar = kVarB.f2220h;
        s7.k kVar2 = (s7.k) ((AtomicReference) kVar.f6085v).getAndSet(null);
        if (kVar2 == null) {
            kVar2 = new s7.k(cls, cls2, cls3);
        } else {
            kVar2.f11603a = cls;
            kVar2.f11604b = cls2;
            kVar2.f11605c = cls3;
        }
        synchronized (((v.e) kVar.f6086w)) {
            list = (List) ((v.e) kVar.f6086w).get(kVar2);
        }
        ((AtomicReference) kVar.f6085v).set(kVar2);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayListA2 = kVarB.f2214a.a(cls);
            int size = arrayListA2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayListA2.get(i);
                i++;
                ArrayList arrayListL = kVarB.f2216c.l((Class) obj, cls2);
                int size2 = arrayListL.size();
                int i10 = 0;
                while (i10 < size2) {
                    Object obj2 = arrayListL.get(i10);
                    i10++;
                    Class cls4 = (Class) obj2;
                    if (!kVarB.f.d(cls4, cls3).isEmpty() && !arrayList.contains(cls4)) {
                        arrayList.add(cls4);
                    }
                }
            }
            z10 = false;
            kVarB.f2220h.s(cls, cls2, cls3, Collections.unmodifiableList(arrayList));
            list2 = arrayList;
        } else {
            z10 = false;
            list2 = list;
        }
        if (list2.isEmpty()) {
            if (File.class.equals(this.f15238w.f15267k)) {
                return z10;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f15238w.f15262d.getClass() + " to " + this.f15238w.f15267k);
        }
        while (true) {
            List list3 = this.A;
            if (list3 != null && this.B < list3.size()) {
                this.C = null;
                boolean z12 = z10;
                while (!z12 && this.B < this.A.size()) {
                    List list4 = this.A;
                    int i11 = this.B;
                    this.B = i11 + 1;
                    d7.t tVar = (d7.t) list4.get(i11);
                    File file = this.D;
                    h hVar2 = this.f15238w;
                    this.C = tVar.a(file, hVar2.f15263e, hVar2.f, hVar2.i);
                    if (this.C != null && this.f15238w.c(this.C.f3509c.a()) != null) {
                        this.C.f3509c.f(this.f15238w.f15271o, this);
                        z12 = true;
                    }
                }
                return z12;
            }
            int i12 = this.f15240y + 1;
            this.f15240y = i12;
            if (i12 >= list2.size()) {
                int i13 = this.f15239x + 1;
                this.f15239x = i13;
                if (i13 >= arrayListA.size()) {
                    return z10;
                }
                this.f15240y = z10 ? 1 : 0;
            }
            x6.e eVar = (x6.e) arrayListA.get(this.f15239x);
            Class cls5 = (Class) list2.get(this.f15240y);
            x6.l lVarE = this.f15238w.e(cls5);
            h hVar3 = this.f15238w;
            this.E = new d0(hVar3.f15261c.f2201a, eVar, hVar3.f15270n, hVar3.f15263e, hVar3.f, lVarE, cls5, hVar3.i);
            File fileF = hVar3.f15265h.a().f(this.E);
            this.D = fileF;
            if (fileF != null) {
                this.f15241z = eVar;
                this.A = this.f15238w.f15261c.b().g(fileF);
                z11 = false;
                this.B = 0;
            } else {
                z11 = false;
            }
            z10 = z11;
        }
    }

    @Override // com.bumptech.glide.load.data.c
    public final void c(Exception exc) {
        this.f15237v.a(this.E, exc, this.C.f3509c, 4);
    }

    @Override // z6.g
    public final void cancel() {
        d7.s sVar = this.C;
        if (sVar != null) {
            sVar.f3509c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.c
    public final void d(Object obj) {
        this.f15237v.c(this.f15241z, obj, this.C.f3509c, 4, this.E);
    }
}
