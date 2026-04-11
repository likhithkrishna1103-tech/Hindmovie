package z6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f15259a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f15260b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bumptech.glide.g f15261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f15262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f15263e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Class f15264g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public l8.i f15265h;
    public x6.h i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map f15266j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Class f15267k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f15268l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f15269m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public x6.e f15270n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bumptech.glide.h f15271o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public m f15272p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f15273q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f15274r;

    public final ArrayList a() {
        boolean z10 = this.f15269m;
        ArrayList arrayList = this.f15260b;
        if (!z10) {
            this.f15269m = true;
            arrayList.clear();
            ArrayList arrayListB = b();
            int size = arrayListB.size();
            for (int i = 0; i < size; i++) {
                d7.s sVar = (d7.s) arrayListB.get(i);
                x6.e eVar = sVar.f3507a;
                List list = sVar.f3508b;
                if (!arrayList.contains(eVar)) {
                    arrayList.add(sVar.f3507a);
                }
                for (int i10 = 0; i10 < list.size(); i10++) {
                    if (!arrayList.contains(list.get(i10))) {
                        arrayList.add((x6.e) list.get(i10));
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList b() {
        boolean z10 = this.f15268l;
        ArrayList arrayList = this.f15259a;
        if (!z10) {
            this.f15268l = true;
            arrayList.clear();
            List listG = this.f15261c.b().g(this.f15262d);
            int size = listG.size();
            for (int i = 0; i < size; i++) {
                d7.s sVarA = ((d7.t) listG.get(i)).a(this.f15262d, this.f15263e, this.f, this.i);
                if (sVarA != null) {
                    arrayList.add(sVarA);
                }
            }
        }
        return arrayList;
    }

    public final z c(Class cls) {
        z zVar;
        Class cls2;
        com.bumptech.glide.k kVarB = this.f15261c.b();
        Class cls3 = this.f15264g;
        Class cls4 = this.f15267k;
        n7.b bVar = kVarB.i;
        s7.k kVar = (s7.k) bVar.f8852b.getAndSet(null);
        if (kVar == null) {
            kVar = new s7.k();
        }
        kVar.f11603a = cls;
        kVar.f11604b = cls3;
        kVar.f11605c = cls4;
        synchronized (bVar.f8851a) {
            zVar = (z) bVar.f8851a.get(kVar);
        }
        bVar.f8852b.set(kVar);
        kVarB.i.getClass();
        if (n7.b.f8850c.equals(zVar)) {
            return null;
        }
        if (zVar != null) {
            return zVar;
        }
        z zVar2 = null;
        ArrayList arrayListE = kVarB.e(cls, cls3, cls4);
        if (arrayListE.isEmpty()) {
            cls2 = cls;
        } else {
            cls2 = cls;
            zVar2 = new z(cls2, cls3, cls4, arrayListE, kVarB.f2221j);
        }
        z zVar3 = zVar2;
        kVarB.i.a(cls2, cls3, cls4, zVar3);
        return zVar3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0026, code lost:
    
        r1 = r5.f8849b;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final x6.b d(java.lang.Object r8) {
        /*
            r7 = this;
            com.bumptech.glide.g r0 = r7.f15261c
            com.bumptech.glide.k r0 = r0.b()
            kf.o r0 = r0.f2215b
            java.lang.Class r1 = r8.getClass()
            monitor-enter(r0)
            java.util.ArrayList r2 = r0.f7512a     // Catch: java.lang.Throwable -> L2a
            int r3 = r2.size()     // Catch: java.lang.Throwable -> L2a
            r4 = 0
        L14:
            if (r4 >= r3) goto L2c
            java.lang.Object r5 = r2.get(r4)     // Catch: java.lang.Throwable -> L2a
            int r4 = r4 + 1
            n7.a r5 = (n7.a) r5     // Catch: java.lang.Throwable -> L2a
            java.lang.Class r6 = r5.f8848a     // Catch: java.lang.Throwable -> L2a
            boolean r6 = r6.isAssignableFrom(r1)     // Catch: java.lang.Throwable -> L2a
            if (r6 == 0) goto L14
            x6.b r1 = r5.f8849b     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r0)
            goto L2e
        L2a:
            r8 = move-exception
            goto L49
        L2c:
            monitor-exit(r0)
            r1 = 0
        L2e:
            if (r1 == 0) goto L31
            return r1
        L31:
            com.bumptech.glide.j r0 = new com.bumptech.glide.j
            java.lang.Class r8 = r8.getClass()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to find source encoder for data class: "
            r1.<init>(r2)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        L49:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: z6.h.d(java.lang.Object):x6.b");
    }

    public final x6.l e(Class cls) {
        x6.l lVar = (x6.l) this.f15266j.get(cls);
        if (lVar == null) {
            Iterator it = this.f15266j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    lVar = (x6.l) entry.getValue();
                    break;
                }
            }
        }
        if (lVar != null) {
            return lVar;
        }
        if (!this.f15266j.isEmpty() || !this.f15273q) {
            return f7.c.f3990b;
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }
}
