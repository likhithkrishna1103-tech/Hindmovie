package u3;

import java.util.ArrayDeque;
import o8.j;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class i implements t3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque f12756a = new ArrayDeque();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque f12757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque f12758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f12759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f12760e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f12761g;

    public i() {
        for (int i = 0; i < 10; i++) {
            this.f12756a.add(new g(1));
        }
        this.f12757b = new ArrayDeque();
        for (int i10 = 0; i10 < 2; i10++) {
            ArrayDeque arrayDeque = this.f12757b;
            nc.c cVar = new nc.c(13, this);
            h hVar = new h();
            hVar.f12755w = cVar;
            arrayDeque.add(hVar);
        }
        this.f12758c = new ArrayDeque();
        this.f12761g = -9223372036854775807L;
    }

    @Override // t3.e
    public final void a(long j5) {
        this.f12760e = j5;
    }

    public abstract j b();

    public abstract void c(g gVar);

    @Override // y1.d
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public t3.j dequeueOutputBuffer() {
        ArrayDeque arrayDeque = this.f12757b;
        if (arrayDeque.isEmpty()) {
            return null;
        }
        while (true) {
            ArrayDeque arrayDeque2 = this.f12758c;
            if (arrayDeque2.isEmpty()) {
                return null;
            }
            g gVar = (g) arrayDeque2.peek();
            int i = b0.f11647a;
            if (gVar.timeUs > this.f12760e) {
                return null;
            }
            g gVar2 = (g) arrayDeque2.poll();
            boolean zIsEndOfStream = gVar2.isEndOfStream();
            ArrayDeque arrayDeque3 = this.f12756a;
            if (zIsEndOfStream) {
                t3.j jVar = (t3.j) arrayDeque.pollFirst();
                jVar.addFlag(4);
                gVar2.clear();
                arrayDeque3.add(gVar2);
                return jVar;
            }
            c(gVar2);
            if (e()) {
                j jVarB = b();
                t3.j jVar2 = (t3.j) arrayDeque.pollFirst();
                long j5 = gVar2.timeUs;
                jVar2.timeUs = j5;
                jVar2.f12090u = jVarB;
                jVar2.f12091v = j5;
                gVar2.clear();
                arrayDeque3.add(gVar2);
                return jVar2;
            }
            gVar2.clear();
            arrayDeque3.add(gVar2);
        }
    }

    @Override // y1.d
    public final Object dequeueInputBuffer() {
        s1.d.g(this.f12759d == null);
        ArrayDeque arrayDeque = this.f12756a;
        if (arrayDeque.isEmpty()) {
            return null;
        }
        g gVar = (g) arrayDeque.pollFirst();
        this.f12759d = gVar;
        return gVar;
    }

    public abstract boolean e();

    @Override // y1.d
    public void flush() {
        ArrayDeque arrayDeque;
        this.f = 0L;
        this.f12760e = 0L;
        while (true) {
            ArrayDeque arrayDeque2 = this.f12758c;
            boolean zIsEmpty = arrayDeque2.isEmpty();
            arrayDeque = this.f12756a;
            if (zIsEmpty) {
                break;
            }
            g gVar = (g) arrayDeque2.poll();
            int i = b0.f11647a;
            gVar.clear();
            arrayDeque.add(gVar);
        }
        g gVar2 = this.f12759d;
        if (gVar2 != null) {
            gVar2.clear();
            arrayDeque.add(gVar2);
            this.f12759d = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    @Override // y1.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void queueInputBuffer(java.lang.Object r7) {
        /*
            r6 = this;
            t3.i r7 = (t3.i) r7
            u3.g r0 = r6.f12759d
            if (r7 != r0) goto L8
            r0 = 1
            goto L9
        L8:
            r0 = 0
        L9:
            s1.d.b(r0)
            u3.g r7 = (u3.g) r7
            boolean r0 = r7.isEndOfStream()
            if (r0 != 0) goto L34
            long r0 = r7.timeUs
            r2 = -9223372036854775808
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L34
            long r2 = r6.f12761g
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 == 0) goto L34
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L34
            r7.clear()
            java.util.ArrayDeque r0 = r6.f12756a
            r0.add(r7)
            goto L42
        L34:
            long r0 = r6.f
            r2 = 1
            long r2 = r2 + r0
            r6.f = r2
            r7.f12754v = r0
            java.util.ArrayDeque r0 = r6.f12758c
            r0.add(r7)
        L42:
            r7 = 0
            r6.f12759d = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.i.queueInputBuffer(java.lang.Object):void");
    }

    @Override // y1.d
    public final void setOutputStartTimeUs(long j5) {
        this.f12761g = j5;
    }

    @Override // y1.d
    public void release() {
    }
}
