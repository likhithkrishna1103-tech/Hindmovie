package we;

import ge.p;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends Thread {
    public static final /* synthetic */ AtomicIntegerFieldUpdater D = AtomicIntegerFieldUpdater.newUpdater(a.class, "workerCtl$volatile");
    public int A;
    public boolean B;
    public final /* synthetic */ c C;
    private volatile int indexInArray;
    private volatile Object nextParkedWorker;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final m f14145v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final p f14146w;
    private volatile /* synthetic */ int workerCtl$volatile;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public b f14147x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f14148y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f14149z;

    public a(c cVar, int i) {
        this.C = cVar;
        setDaemon(true);
        setContextClassLoader(c.class.getClassLoader());
        this.f14145v = new m();
        this.f14146w = new p();
        this.f14147x = b.f14153y;
        this.nextParkedWorker = c.F;
        int iNanoTime = (int) System.nanoTime();
        this.A = iNanoTime == 0 ? 42 : iNanoTime;
        f(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        r12 = we.m.f14176d.get(r9);
        r0 = we.m.f14175c.get(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
    
        if (r12 == r0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
    
        if (we.m.f14177e.get(r9) != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
    
        r0 = r0 - 1;
        r1 = r9.b(r0, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        if (r1 == null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
    
        r7 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final we.i a(boolean r12) {
        /*
            r11 = this;
            we.b r0 = r11.f14147x
            we.c r2 = r11.C
            r7 = 0
            r8 = 1
            we.m r9 = r11.f14145v
            we.b r10 = we.b.f14150v
            if (r0 != r10) goto Le
            goto L84
        Le:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = we.c.D
        L10:
            long r3 = r0.get(r2)
            r5 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
            long r5 = r5 & r3
            r1 = 42
            long r5 = r5 >> r1
            int r1 = (int) r5
            if (r1 != 0) goto L73
            r9.getClass()
        L23:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = we.m.f14174b
            java.lang.Object r0 = r12.get(r9)
            we.i r0 = (we.i) r0
            if (r0 != 0) goto L2e
            goto L41
        L2e:
            boolean r1 = r0.f14166w
            if (r1 != r8) goto L41
        L32:
            boolean r1 = r12.compareAndSet(r9, r0, r7)
            if (r1 == 0) goto L3a
            r7 = r0
            goto L61
        L3a:
            java.lang.Object r1 = r12.get(r9)
            if (r1 == r0) goto L32
            goto L23
        L41:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r12 = we.m.f14176d
            int r12 = r12.get(r9)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = we.m.f14175c
            int r0 = r0.get(r9)
        L4d:
            if (r12 == r0) goto L61
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = we.m.f14177e
            int r1 = r1.get(r9)
            if (r1 != 0) goto L58
            goto L61
        L58:
            int r0 = r0 + (-1)
            we.i r1 = r9.b(r0, r8)
            if (r1 == 0) goto L4d
            r7 = r1
        L61:
            if (r7 != 0) goto L72
            we.f r12 = r2.A
            java.lang.Object r12 = r12.d()
            we.i r12 = (we.i) r12
            if (r12 != 0) goto L71
            we.i r12 = r11.i(r8)
        L71:
            return r12
        L72:
            return r7
        L73:
            r5 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
            long r5 = r3 - r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = we.c.D
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L10
            r11.f14147x = r10
        L84:
            if (r12 == 0) goto Lb8
            int r12 = r2.f14155v
            int r12 = r12 * 2
            int r12 = r11.d(r12)
            if (r12 != 0) goto L91
            goto L92
        L91:
            r8 = 0
        L92:
            if (r8 == 0) goto L9b
            we.i r12 = r11.e()
            if (r12 == 0) goto L9b
            return r12
        L9b:
            r9.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = we.m.f14174b
            java.lang.Object r12 = r12.getAndSet(r9, r7)
            we.i r12 = (we.i) r12
            if (r12 != 0) goto Lac
            we.i r12 = r9.a()
        Lac:
            if (r12 == 0) goto Laf
            return r12
        Laf:
            if (r8 != 0) goto Lbf
            we.i r12 = r11.e()
            if (r12 == 0) goto Lbf
            return r12
        Lb8:
            we.i r12 = r11.e()
            if (r12 == 0) goto Lbf
            return r12
        Lbf:
            r12 = 3
            we.i r12 = r11.i(r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: we.a.a(boolean):we.i");
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i) {
        int i10 = this.A;
        int i11 = i10 ^ (i10 << 13);
        int i12 = i11 ^ (i11 >> 17);
        int i13 = i12 ^ (i12 << 5);
        this.A = i13;
        int i14 = i - 1;
        return (i14 & i) == 0 ? i13 & i14 : (i13 & Integer.MAX_VALUE) % i;
    }

    public final i e() {
        int iD = d(2);
        c cVar = this.C;
        if (iD == 0) {
            i iVar = (i) cVar.f14159z.d();
            return iVar != null ? iVar : (i) cVar.A.d();
        }
        i iVar2 = (i) cVar.A.d();
        return iVar2 != null ? iVar2 : (i) cVar.f14159z.d();
    }

    public final void f(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.C.f14158y);
        sb.append("-worker-");
        sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
        setName(sb.toString());
        this.indexInArray = i;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(b bVar) {
        b bVar2 = this.f14147x;
        boolean z10 = bVar2 == b.f14150v;
        if (z10) {
            c.D.addAndGet(this.C, 4398046511104L);
        }
        if (bVar2 != bVar) {
            this.f14147x = bVar;
        }
        return z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006b, code lost:
    
        r7 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009f, code lost:
    
        r7 = -2;
        r5 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final we.i i(int r26) {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: we.a.i(int):we.i");
    }

    /* JADX WARN: Code restructure failed: missing block: B:124:0x0004, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0004, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0004, code lost:
    
        continue;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: we.a.run():void");
    }
}
