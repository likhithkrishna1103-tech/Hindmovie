package qf;

import ge.i;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kf.q;
import ne.h;
import ne.o;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends a {
    public boolean A;
    public final /* synthetic */ g B;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f10817z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(g gVar, q qVar) {
        super(gVar, qVar);
        i.e(qVar, "url");
        this.B = gVar;
        this.f10817z = -1L;
        this.A = true;
    }

    @Override // qf.a, ag.w
    public final long U(long j4, ag.e eVar) throws IOException {
        long j7;
        byte bS;
        g gVar = this.B;
        l7.a aVar = gVar.f10825c;
        i.e(eVar, "sink");
        if (this.f10812x) {
            throw new IllegalStateException("closed");
        }
        long j10 = -1;
        if (!this.A) {
            return -1L;
        }
        long j11 = this.f10817z;
        if (j11 == 0 || j11 == -1) {
            if (j11 != -1) {
                ((ag.q) aVar.f7867x).I(Long.MAX_VALUE);
            }
            try {
                ag.q qVar = (ag.q) aVar.f7867x;
                ag.e eVar2 = qVar.f460w;
                qVar.W(1L);
                int i = 0;
                while (true) {
                    int i10 = i + 1;
                    j7 = j10;
                    if (!qVar.o(i10)) {
                        break;
                    }
                    bS = eVar2.s(i);
                    if ((bS < 48 || bS > 57) && ((bS < 97 || bS > 102) && (bS < 65 || bS > 70))) {
                        break;
                    }
                    j10 = j7;
                    i = i10;
                }
                if (i == 0) {
                    t1.b(16);
                    String string = Integer.toString(bS, 16);
                    i.d(string, "toString(...)");
                    throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(string));
                }
                this.f10817z = eVar2.C();
                String string2 = h.t0(((ag.q) aVar.f7867x).I(Long.MAX_VALUE)).toString();
                if (this.f10817z < 0 || (string2.length() > 0 && !o.Z(string2, ";", false))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f10817z + string2 + '\"');
                }
                if (this.f10817z == 0) {
                    this.A = false;
                    a(gVar.f10827e.I());
                }
                if (!this.A) {
                    return j7;
                }
            } catch (NumberFormatException e9) {
                throw new ProtocolException(e9.getMessage());
            }
        } else {
            j7 = -1;
        }
        long jU = super.U(Math.min(8192L, this.f10817z), eVar);
        if (jU != j7) {
            this.f10817z -= jU;
            return jU;
        }
        gVar.f10824b.h();
        ProtocolException protocolException = new ProtocolException("unexpected end of stream");
        a(g.f);
        throw protocolException;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean zF;
        if (this.f10812x) {
            return;
        }
        if (this.A) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            TimeZone timeZone = lf.f.f7964a;
            i.e(timeUnit, "timeUnit");
            try {
                zF = lf.f.f(this, 100);
            } catch (IOException unused) {
                zF = false;
            }
            if (!zF) {
                this.B.f10824b.h();
                a(g.f);
            }
        }
        this.f10812x = true;
    }
}
