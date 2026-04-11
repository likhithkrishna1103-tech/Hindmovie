package y2;

import android.os.SystemClock;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.NoSuchElementException;
import v1.m0;
import v1.r1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vb.b f14623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f14624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u3.a f14625c = new u3.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final pa.o f14626d = new pa.o();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final pa.o f14627e = new pa.o();
    public final com.google.android.material.datepicker.o f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f14628g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f14629h;
    public long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public r1 f14630j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f14631k;

    public a0(vb.b bVar, v vVar) {
        this.f14623a = bVar;
        this.f14624b = vVar;
        com.google.android.material.datepicker.o oVar = new com.google.android.material.datepicker.o();
        int iHighestOneBit = Integer.bitCount(16) != 1 ? Integer.highestOneBit(15) << 1 : 16;
        oVar.f2875v = 0;
        oVar.f2876w = -1;
        oVar.f2877x = 0;
        oVar.f2879z = new long[iHighestOneBit];
        oVar.f2878y = iHighestOneBit - 1;
        this.f = oVar;
        this.f14628g = -9223372036854775807L;
        this.f14630j = r1.f12978d;
        this.f14629h = -9223372036854775807L;
        this.i = -9223372036854775807L;
    }

    public final void a(long j4, long j7) {
        final vb.b bVar = this.f14623a;
        c cVar = (c) bVar.f13552x;
        while (true) {
            com.google.android.material.datepicker.o oVar = this.f;
            int i = oVar.f2877x;
            if (i == 0) {
                return;
            }
            if (i == 0) {
                throw new NoSuchElementException();
            }
            long j10 = ((long[]) oVar.f2879z)[oVar.f2875v];
            Long l10 = (Long) this.f14627e.f(j10);
            v vVar = this.f14624b;
            if (l10 != null && l10.longValue() != this.f14631k) {
                this.f14631k = l10.longValue();
                vVar.f(2);
            }
            long j11 = this.f14631k;
            v vVar2 = this.f14624b;
            u3.a aVar = this.f14625c;
            int iA = vVar2.a(j10, j4, j7, j11, false, false, aVar);
            if (iA == 0 || iA == 1) {
                this.f14629h = j10;
                boolean z10 = iA == 0;
                long jD = oVar.d();
                r1 r1Var = (r1) this.f14626d.f(jD);
                if (r1Var != null && !r1Var.equals(r1.f12978d) && !r1Var.equals(this.f14630j)) {
                    this.f14630j = r1Var;
                    v1.o oVar2 = new v1.o();
                    oVar2.f12900t = r1Var.f12981a;
                    oVar2.f12901u = r1Var.f12982b;
                    oVar2.f12893m = m0.p("video/raw");
                    bVar.f13551w = new v1.p(oVar2);
                    cVar.f14642h.execute(new nc.i(18, bVar, r1Var));
                }
                long jNanoTime = z10 ? System.nanoTime() : aVar.f12078b;
                boolean z11 = vVar.f14732e != 3;
                vVar.f14732e = 3;
                vVar.f14737l.getClass();
                vVar.f14733g = y1.a0.O(SystemClock.elapsedRealtime());
                if (z11 && cVar.f14639d != null) {
                    final int i10 = 0;
                    cVar.f14642h.execute(new Runnable() { // from class: y2.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i10) {
                                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                    ((c) bVar.f13552x).f14641g.d();
                                    break;
                                default:
                                    ((c) bVar.f13552x).f14641g.f();
                                    break;
                            }
                        }
                    });
                }
                v1.p pVar = (v1.p) bVar.f13551w;
                cVar.i.d(jD, jNanoTime, pVar == null ? new v1.p(new v1.o()) : pVar, null);
                g gVar = (g) cVar.f14638c.remove();
                gVar.f14659c.I0(gVar.f14657a, gVar.f14658b, jNanoTime);
            } else if (iA == 2 || iA == 3) {
                this.f14629h = j10;
                oVar.d();
                final int i11 = 1;
                cVar.f14642h.execute(new Runnable() { // from class: y2.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i11) {
                            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                ((c) bVar.f13552x).f14641g.d();
                                break;
                            default:
                                ((c) bVar.f13552x).f14641g.f();
                                break;
                        }
                    }
                });
                g gVar2 = (g) cVar.f14638c.remove();
                gVar2.f14659c.M0(gVar2.f14657a, gVar2.f14658b);
            } else {
                if (iA != 4) {
                    if (iA != 5) {
                        throw new IllegalStateException(String.valueOf(iA));
                    }
                    return;
                }
                this.f14629h = j10;
            }
        }
    }
}
