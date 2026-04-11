package e6;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c0 implements g, com.bumptech.glide.load.data.d {
    public int A;
    public volatile i6.q B;
    public File C;
    public d0 D;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final k f4476u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h f4477v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f4478w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f4479x = -1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public c6.f f4480y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public List f4481z;

    public c0(h hVar, k kVar) {
        this.f4477v = hVar;
        this.f4476u = kVar;
    }

    @Override // e6.g
    public final boolean a() {
        List list;
        boolean z2;
        List list2;
        boolean z10;
        ArrayList arrayListA = this.f4477v.a();
        if (arrayListA.isEmpty()) {
            return false;
        }
        h hVar = this.f4477v;
        com.bumptech.glide.i iVarB = hVar.f4508c.b();
        Class<?> cls = hVar.f4509d.getClass();
        Class cls2 = hVar.f4511g;
        Class cls3 = hVar.f4514k;
        pb.c cVar = iVarB.f2791h;
        x6.k kVar = (x6.k) ((AtomicReference) cVar.f10310v).getAndSet(null);
        if (kVar == null) {
            kVar = new x6.k(cls, cls2, cls3);
        } else {
            kVar.f14287a = cls;
            kVar.f14288b = cls2;
            kVar.f14289c = cls3;
        }
        synchronized (((s.e) cVar.f10311w)) {
            list = (List) ((s.e) cVar.f10311w).get(kVar);
        }
        ((AtomicReference) cVar.f10310v).set(kVar);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayListA2 = iVarB.f2785a.a(cls);
            int size = arrayListA2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayListA2.get(i);
                i++;
                ArrayList arrayListK = iVarB.f2787c.k((Class) obj, cls2);
                int size2 = arrayListK.size();
                int i10 = 0;
                while (i10 < size2) {
                    Object obj2 = arrayListK.get(i10);
                    i10++;
                    Class cls4 = (Class) obj2;
                    if (!iVarB.f.b(cls4, cls3).isEmpty() && !arrayList.contains(cls4)) {
                        arrayList.add(cls4);
                    }
                }
            }
            z2 = false;
            iVarB.f2791h.l(cls, cls2, cls3, Collections.unmodifiableList(arrayList));
            list2 = arrayList;
        } else {
            z2 = false;
            list2 = list;
        }
        if (list2.isEmpty()) {
            if (File.class.equals(this.f4477v.f4514k)) {
                return z2;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f4477v.f4509d.getClass() + " to " + this.f4477v.f4514k);
        }
        while (true) {
            List list3 = this.f4481z;
            if (list3 != null && this.A < list3.size()) {
                this.B = null;
                boolean z11 = z2;
                while (!z11 && this.A < this.f4481z.size()) {
                    List list4 = this.f4481z;
                    int i11 = this.A;
                    this.A = i11 + 1;
                    i6.r rVar = (i6.r) list4.get(i11);
                    File file = this.C;
                    h hVar2 = this.f4477v;
                    this.B = rVar.a(file, hVar2.f4510e, hVar2.f, hVar2.i);
                    if (this.B != null && this.f4477v.c(this.B.f6422c.a()) != null) {
                        this.B.f6422c.e(this.f4477v.f4518o, this);
                        z11 = true;
                    }
                }
                return z11;
            }
            int i12 = this.f4479x + 1;
            this.f4479x = i12;
            if (i12 >= list2.size()) {
                int i13 = this.f4478w + 1;
                this.f4478w = i13;
                if (i13 >= arrayListA.size()) {
                    return z2;
                }
                this.f4479x = z2 ? 1 : 0;
            }
            c6.f fVar = (c6.f) arrayListA.get(this.f4478w);
            Class cls5 = (Class) list2.get(this.f4479x);
            c6.m mVarE = this.f4477v.e(cls5);
            h hVar3 = this.f4477v;
            this.D = new d0(hVar3.f4508c.f2772a, fVar, hVar3.f4517n, hVar3.f4510e, hVar3.f, mVarE, cls5, hVar3.i);
            File fileF = hVar3.f4512h.a().f(this.D);
            this.C = fileF;
            if (fileF != null) {
                this.f4480y = fVar;
                this.f4481z = this.f4477v.f4508c.b().g(fileF);
                z10 = false;
                this.A = 0;
            } else {
                z10 = false;
            }
            z2 = z10;
        }
    }

    @Override // e6.g
    public final void cancel() {
        i6.q qVar = this.B;
        if (qVar != null) {
            qVar.f6422c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void l(Exception exc) {
        this.f4476u.c(this.D, exc, this.B.f6422c, 4);
    }

    @Override // com.bumptech.glide.load.data.d
    public final void r(Object obj) {
        this.f4476u.b(this.f4480y, obj, this.B.f6422c, 4, this.D);
    }
}
