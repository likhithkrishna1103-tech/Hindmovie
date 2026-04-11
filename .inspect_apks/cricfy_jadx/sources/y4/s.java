package y4;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fe.a f14881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReentrantLock f14882c = new ReentrantLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f14884e;
    public final h[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final xe.h f14885g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final sd.h f14886h;

    public s(int i, fe.a aVar) {
        this.f14880a = i;
        this.f14881b = aVar;
        this.f = new h[i];
        int i10 = xe.i.f14497a;
        this.f14885g = new xe.h(i, 0);
        this.f14886h = new sd.h(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
    
        r1.k(r4, r3.f14496w);
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(xd.c r7) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.s.a(xd.c):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:14|50|48|29|(0)(0)|38|19|44|20|21|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0060, code lost:
    
        r10 = r10;
        r9 = r9;
        r1 = r0;
        r0 = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0053 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0069 A[Catch: all -> 0x006d, TryCatch #2 {all -> 0x006d, blocks: (B:29:0x0065, B:31:0x0069, B:35:0x0071, B:39:0x0078), top: B:48:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0054 -> B:25:0x0056). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(long r7, y4.d r9, xd.c r10) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r10 instanceof y4.r
            if (r0 == 0) goto L13
            r0 = r10
            y4.r r0 = (y4.r) r0
            int r1 = r0.D
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.D = r1
            goto L18
        L13:
            y4.r r0 = new y4.r
            r0.<init>(r6, r10)
        L18:
            java.lang.Object r10 = r0.B
            int r1 = r0.D
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            long r7 = r0.f14878y
            ge.p r9 = r0.A
            fe.a r1 = r0.f14879z
            com.bumptech.glide.c.C(r10)     // Catch: java.lang.Throwable -> L2c
            goto L56
        L2c:
            r10 = move-exception
            goto L60
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            com.bumptech.glide.c.C(r10)
        L39:
            ge.p r10 = new ge.p
            r10.<init>()
            d1.u r1 = new d1.u     // Catch: java.lang.Throwable -> L5b
            r1.<init>(r10, r6, r3)     // Catch: java.lang.Throwable -> L5b
            r0.f14879z = r9     // Catch: java.lang.Throwable -> L5b
            r0.A = r10     // Catch: java.lang.Throwable -> L5b
            r0.f14878y = r7     // Catch: java.lang.Throwable -> L5b
            r0.D = r2     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r1 = pe.x.t(r7, r1, r0)     // Catch: java.lang.Throwable -> L5b
            wd.a r4 = wd.a.f14143v
            if (r1 != r4) goto L54
            return r4
        L54:
            r1 = r9
            r9 = r10
        L56:
            r10 = r9
            r9 = r1
            r1 = r0
            r0 = r3
            goto L65
        L5b:
            r1 = move-exception
            r5 = r1
            r1 = r9
            r9 = r10
            r10 = r5
        L60:
            r5 = r10
            r10 = r9
            r9 = r1
            r1 = r0
            r0 = r5
        L65:
            boolean r4 = r0 instanceof pe.j1     // Catch: java.lang.Throwable -> L6d
            if (r4 == 0) goto L6f
            r9.b()     // Catch: java.lang.Throwable -> L6d
            goto L76
        L6d:
            r7 = move-exception
            goto L79
        L6f:
            if (r0 != 0) goto L78
            java.lang.Object r10 = r10.f5254v     // Catch: java.lang.Throwable -> L6d
            if (r10 == 0) goto L76
            return r10
        L76:
            r0 = r1
            goto L39
        L78:
            throw r0     // Catch: java.lang.Throwable -> L6d
        L79:
            java.lang.Object r8 = r10.f5254v
            y4.h r8 = (y4.h) r8
            if (r8 == 0) goto L82
            r6.e(r8)
        L82:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: y4.s.b(long, y4.d, xd.c):java.lang.Object");
    }

    public final void c() {
        ReentrantLock reentrantLock = this.f14882c;
        reentrantLock.lock();
        try {
            this.f14884e = true;
            for (h hVar : this.f) {
                if (hVar != null) {
                    hVar.close();
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void d(StringBuilder sb) {
        sd.h hVar = this.f14886h;
        ReentrantLock reentrantLock = this.f14882c;
        reentrantLock.lock();
        try {
            td.c cVarH = n5.a.h();
            int i = hVar.f11665x;
            for (int i10 = 0; i10 < i; i10++) {
                cVarH.add(hVar.get(i10));
            }
            td.c cVarA = n5.a.a(cVarH);
            sb.append('\t' + toString() + " (");
            sb.append("capacity=" + this.f14880a + ", ");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("permits=");
            xe.h hVar2 = this.f14885g;
            hVar2.getClass();
            sb2.append(Math.max(xe.g.B.get(hVar2), 0));
            sb2.append(", ");
            sb.append(sb2.toString());
            sb.append("queue=(size=" + cVarA.a() + ")[" + sd.j.l0(cVarA, null, null, null, null, 63) + ']');
            sb.append(")");
            sb.append('\n');
            h[] hVarArr = this.f;
            int length = hVarArr.length;
            int i11 = 0;
            for (int i12 = 0; i12 < length; i12++) {
                h hVar3 = hVarArr[i12];
                i11++;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("\t\t[");
                sb3.append(i11);
                sb3.append("] - ");
                sb3.append(hVar3 != null ? hVar3.f14853v.toString() : null);
                sb.append(sb3.toString());
                sb.append('\n');
                if (hVar3 != null) {
                    hVar3.q(sb);
                }
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void e(h hVar) {
        ge.i.e(hVar, "connection");
        ReentrantLock reentrantLock = this.f14882c;
        reentrantLock.lock();
        try {
            this.f14886h.addLast(hVar);
            reentrantLock.unlock();
            this.f14885g.c();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
