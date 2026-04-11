package y3;

import j9.q;
import java.util.ArrayDeque;
import x3.m;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i implements x3.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque f14832a = new ArrayDeque();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque f14833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque f14834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f14835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f14836e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f14837g;

    public i() {
        for (int i = 0; i < 10; i++) {
            this.f14832a.add(new g(1));
        }
        this.f14833b = new ArrayDeque();
        for (int i10 = 0; i10 < 2; i10++) {
            ArrayDeque arrayDeque = this.f14833b;
            kb.d dVar = new kb.d(24, this);
            h hVar = new h();
            hVar.f14831x = dVar;
            arrayDeque.add(hVar);
        }
        this.f14834c = new ArrayDeque();
        this.f14837g = -9223372036854775807L;
    }

    @Override // x3.h
    public final void a(long j4) {
        this.f14836e = j4;
    }

    public abstract q b();

    public abstract void c(g gVar);

    @Override // e2.d
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public m dequeueOutputBuffer() {
        ArrayDeque arrayDeque = this.f14833b;
        if (arrayDeque.isEmpty()) {
            return null;
        }
        while (true) {
            ArrayDeque arrayDeque2 = this.f14834c;
            if (arrayDeque2.isEmpty()) {
                return null;
            }
            g gVar = (g) arrayDeque2.peek();
            int i = a0.f14551a;
            if (gVar.timeUs > this.f14836e) {
                return null;
            }
            g gVar2 = (g) arrayDeque2.poll();
            boolean zIsEndOfStream = gVar2.isEndOfStream();
            ArrayDeque arrayDeque3 = this.f14832a;
            if (zIsEndOfStream) {
                m mVar = (m) arrayDeque.pollFirst();
                mVar.addFlag(4);
                gVar2.clear();
                arrayDeque3.add(gVar2);
                return mVar;
            }
            c(gVar2);
            if (e()) {
                q qVarB = b();
                m mVar2 = (m) arrayDeque.pollFirst();
                long j4 = gVar2.timeUs;
                mVar2.timeUs = j4;
                mVar2.f14311v = qVarB;
                mVar2.f14312w = j4;
                gVar2.clear();
                arrayDeque3.add(gVar2);
                return mVar2;
            }
            gVar2.clear();
            arrayDeque3.add(gVar2);
        }
    }

    @Override // e2.d
    public final Object dequeueInputBuffer() {
        y1.d.g(this.f14835d == null);
        ArrayDeque arrayDeque = this.f14832a;
        if (arrayDeque.isEmpty()) {
            return null;
        }
        g gVar = (g) arrayDeque.pollFirst();
        this.f14835d = gVar;
        return gVar;
    }

    public abstract boolean e();

    @Override // e2.d
    public void flush() {
        ArrayDeque arrayDeque;
        this.f = 0L;
        this.f14836e = 0L;
        while (true) {
            ArrayDeque arrayDeque2 = this.f14834c;
            boolean zIsEmpty = arrayDeque2.isEmpty();
            arrayDeque = this.f14832a;
            if (zIsEmpty) {
                break;
            }
            g gVar = (g) arrayDeque2.poll();
            int i = a0.f14551a;
            gVar.clear();
            arrayDeque.add(gVar);
        }
        g gVar2 = this.f14835d;
        if (gVar2 != null) {
            gVar2.clear();
            arrayDeque.add(gVar2);
            this.f14835d = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    @Override // e2.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void queueInputBuffer(java.lang.Object r7) {
        /*
            r6 = this;
            x3.l r7 = (x3.l) r7
            y3.g r0 = r6.f14835d
            if (r7 != r0) goto L8
            r0 = 1
            goto L9
        L8:
            r0 = 0
        L9:
            y1.d.b(r0)
            y3.g r7 = (y3.g) r7
            boolean r0 = r7.isEndOfStream()
            if (r0 != 0) goto L34
            long r0 = r7.timeUs
            r2 = -9223372036854775808
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L34
            long r2 = r6.f14837g
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 == 0) goto L34
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L34
            r7.clear()
            java.util.ArrayDeque r0 = r6.f14832a
            r0.add(r7)
            goto L42
        L34:
            long r0 = r6.f
            r2 = 1
            long r2 = r2 + r0
            r6.f = r2
            r7.f14830w = r0
            java.util.ArrayDeque r0 = r6.f14834c
            r0.add(r7)
        L42:
            r7 = 0
            r6.f14835d = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.i.queueInputBuffer(java.lang.Object):void");
    }

    @Override // e2.d
    public final void setOutputStartTimeUs(long j4) {
        this.f14837g = j4;
    }

    @Override // e2.d
    public void release() {
    }
}
