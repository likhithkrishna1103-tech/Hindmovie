package u2;

import android.os.SystemClock;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.NoSuchElementException;
import o2.i0;
import p1.m0;
import p1.r1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p2.c f12544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f12545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q3.a f12546c = new q3.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q3.d f12547d = new q3.d();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q3.d f12548e = new q3.d();
    public final e4.e f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f12549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f12550h;
    public long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public r1 f12551j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f12552k;

    public a0(p2.c cVar, v vVar) {
        this.f12544a = cVar;
        this.f12545b = vVar;
        e4.e eVar = new e4.e();
        int iHighestOneBit = Integer.bitCount(16) != 1 ? Integer.highestOneBit(15) << 1 : 16;
        eVar.f4414u = 0;
        eVar.f4415v = -1;
        eVar.f4416w = 0;
        eVar.f4418y = new long[iHighestOneBit];
        eVar.f4417x = iHighestOneBit - 1;
        this.f = eVar;
        this.f12549g = -9223372036854775807L;
        this.f12551j = r1.f10046d;
        this.f12550h = -9223372036854775807L;
        this.i = -9223372036854775807L;
    }

    public final void a(long j5, long j8) {
        final p2.c cVar = this.f12544a;
        c cVar2 = (c) cVar.f10131w;
        while (true) {
            e4.e eVar = this.f;
            int i = eVar.f4416w;
            if (i == 0) {
                return;
            }
            if (i == 0) {
                throw new NoSuchElementException();
            }
            long j10 = ((long[]) eVar.f4418y)[eVar.f4414u];
            Long l10 = (Long) this.f12548e.f(j10);
            v vVar = this.f12545b;
            if (l10 != null && l10.longValue() != this.f12552k) {
                this.f12552k = l10.longValue();
                vVar.f(2);
            }
            long j11 = this.f12552k;
            v vVar2 = this.f12545b;
            q3.a aVar = this.f12546c;
            int iA = vVar2.a(j10, j5, j8, j11, false, false, aVar);
            if (iA == 0 || iA == 1) {
                this.f12550h = j10;
                boolean z2 = iA == 0;
                long jD = eVar.d();
                r1 r1Var = (r1) this.f12547d.f(jD);
                if (r1Var != null && !r1Var.equals(r1.f10046d) && !r1Var.equals(this.f12551j)) {
                    this.f12551j = r1Var;
                    p1.p pVar = new p1.p();
                    pVar.f9974t = r1Var.f10049a;
                    pVar.f9975u = r1Var.f10050b;
                    pVar.f9967m = m0.p("video/raw");
                    cVar.f10130v = new p1.q(pVar);
                    cVar2.f12563h.execute(new i0(cVar, 12, r1Var));
                }
                long jNanoTime = z2 ? System.nanoTime() : aVar.f10599b;
                boolean z10 = vVar.f12656e != 3;
                vVar.f12656e = 3;
                vVar.f12661l.getClass();
                vVar.f12657g = s1.b0.O(SystemClock.elapsedRealtime());
                if (z10 && cVar2.f12560d != null) {
                    final int i10 = 0;
                    cVar2.f12563h.execute(new Runnable() { // from class: u2.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i10) {
                                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                    ((c) cVar.f10131w).f12562g.f();
                                    break;
                                default:
                                    ((c) cVar.f10131w).f12562g.g();
                                    break;
                            }
                        }
                    });
                }
                p1.q qVar = (p1.q) cVar.f10130v;
                cVar2.i.c(jD, jNanoTime, qVar == null ? new p1.q(new p1.p()) : qVar, null);
                g gVar = (g) cVar2.f12559c.remove();
                gVar.f12580c.I0(gVar.f12578a, gVar.f12579b, jNanoTime);
            } else if (iA == 2 || iA == 3) {
                this.f12550h = j10;
                eVar.d();
                final int i11 = 1;
                cVar2.f12563h.execute(new Runnable() { // from class: u2.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i11) {
                            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                ((c) cVar.f10131w).f12562g.f();
                                break;
                            default:
                                ((c) cVar.f10131w).f12562g.g();
                                break;
                        }
                    }
                });
                g gVar2 = (g) cVar2.f12559c.remove();
                gVar2.f12580c.M0(gVar2.f12578a, gVar2.f12579b);
            } else {
                if (iA != 4) {
                    if (iA != 5) {
                        throw new IllegalStateException(String.valueOf(iA));
                    }
                    return;
                }
                this.f12550h = j10;
            }
        }
    }
}
