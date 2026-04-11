package e6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f4506a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f4507b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bumptech.glide.e f4508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f4509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4510e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Class f4511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q7.h f4512h;
    public c6.i i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map f4513j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Class f4514k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f4515l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f4516m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public c6.f f4517n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bumptech.glide.f f4518o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public m f4519p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f4520q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f4521r;

    public final ArrayList a() {
        boolean z2 = this.f4516m;
        ArrayList arrayList = this.f4507b;
        if (!z2) {
            this.f4516m = true;
            arrayList.clear();
            ArrayList arrayListB = b();
            int size = arrayListB.size();
            for (int i = 0; i < size; i++) {
                i6.q qVar = (i6.q) arrayListB.get(i);
                c6.f fVar = qVar.f6420a;
                List list = qVar.f6421b;
                if (!arrayList.contains(fVar)) {
                    arrayList.add(qVar.f6420a);
                }
                for (int i10 = 0; i10 < list.size(); i10++) {
                    if (!arrayList.contains(list.get(i10))) {
                        arrayList.add(list.get(i10));
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList b() {
        boolean z2 = this.f4515l;
        ArrayList arrayList = this.f4506a;
        if (!z2) {
            this.f4515l = true;
            arrayList.clear();
            List listG = this.f4508c.b().g(this.f4509d);
            int size = listG.size();
            for (int i = 0; i < size; i++) {
                i6.q qVarA = ((i6.r) listG.get(i)).a(this.f4509d, this.f4510e, this.f, this.i);
                if (qVarA != null) {
                    arrayList.add(qVarA);
                }
            }
        }
        return arrayList;
    }

    public final z c(Class cls) {
        z zVar;
        Class cls2;
        com.bumptech.glide.i iVarB = this.f4508c.b();
        Class cls3 = this.f4511g;
        Class cls4 = this.f4514k;
        s6.b bVar = iVarB.i;
        x6.k kVar = (x6.k) bVar.f11868b.getAndSet(null);
        if (kVar == null) {
            kVar = new x6.k();
        }
        kVar.f14287a = cls;
        kVar.f14288b = cls3;
        kVar.f14289c = cls4;
        synchronized (bVar.f11867a) {
            zVar = (z) bVar.f11867a.get(kVar);
        }
        bVar.f11868b.set(kVar);
        iVarB.i.getClass();
        if (s6.b.f11866c.equals(zVar)) {
            return null;
        }
        if (zVar != null) {
            return zVar;
        }
        z zVar2 = null;
        ArrayList arrayListE = iVarB.e(cls, cls3, cls4);
        if (arrayListE.isEmpty()) {
            cls2 = cls;
        } else {
            cls2 = cls;
            zVar2 = new z(cls2, cls3, cls4, arrayListE, iVarB.f2792j);
        }
        z zVar3 = zVar2;
        iVarB.i.a(cls2, cls3, cls4, zVar3);
        return zVar3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0026, code lost:
    
        r1 = r5.f11865b;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c6.b d(java.lang.Object r8) {
        /*
            r7 = this;
            com.bumptech.glide.e r0 = r7.f4508c
            com.bumptech.glide.i r0 = r0.b()
            q2.d r0 = r0.f2786b
            java.lang.Class r1 = r8.getClass()
            monitor-enter(r0)
            java.util.ArrayList r2 = r0.f10591a     // Catch: java.lang.Throwable -> L2a
            int r3 = r2.size()     // Catch: java.lang.Throwable -> L2a
            r4 = 0
        L14:
            if (r4 >= r3) goto L2c
            java.lang.Object r5 = r2.get(r4)     // Catch: java.lang.Throwable -> L2a
            int r4 = r4 + 1
            s6.a r5 = (s6.a) r5     // Catch: java.lang.Throwable -> L2a
            java.lang.Class r6 = r5.f11864a     // Catch: java.lang.Throwable -> L2a
            boolean r6 = r6.isAssignableFrom(r1)     // Catch: java.lang.Throwable -> L2a
            if (r6 == 0) goto L14
            c6.b r1 = r5.f11865b     // Catch: java.lang.Throwable -> L2a
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
            com.bumptech.glide.h r0 = new com.bumptech.glide.h
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
        throw new UnsupportedOperationException("Method not decompiled: e6.h.d(java.lang.Object):c6.b");
    }

    public final c6.m e(Class cls) {
        c6.m mVar = (c6.m) this.f4513j.get(cls);
        if (mVar == null) {
            Iterator it = this.f4513j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    mVar = (c6.m) entry.getValue();
                    break;
                }
            }
        }
        if (mVar != null) {
            return mVar;
        }
        if (!this.f4513j.isEmpty() || !this.f4520q) {
            return k6.c.f7064b;
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }
}
