package bg;

import ag.r;
import ag.s;
import ag.u;
import ag.y;
import ge.i;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements u {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final OutputStream f1920v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final e f1921w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ b6.f f1922x;

    public c(b6.f fVar) {
        this.f1922x = fVar;
        Socket socket = (Socket) fVar.f1800w;
        this.f1920v = socket.getOutputStream();
        this.f1921w = new e(socket);
    }

    @Override // ag.u
    public final void a0(long j4, ag.e eVar) throws IOException {
        u8.a.f(eVar.f429w, 0L, j4);
        while (j4 > 0) {
            e eVar2 = this.f1921w;
            eVar2.f();
            r rVar = eVar.f428v;
            i.b(rVar);
            int iMin = (int) Math.min(j4, rVar.f464c - rVar.f463b);
            eVar2.h();
            try {
                try {
                    this.f1920v.write(rVar.f462a, rVar.f463b, iMin);
                    if (eVar2.i()) {
                        throw eVar2.j(null);
                    }
                    int i = rVar.f463b + iMin;
                    rVar.f463b = i;
                    long j7 = iMin;
                    j4 -= j7;
                    eVar.f429w -= j7;
                    if (i == rVar.f464c) {
                        eVar.f428v = rVar.a();
                        s.a(rVar);
                    }
                } catch (IOException e9) {
                    if (!eVar2.i()) {
                        throw e9;
                    }
                    throw eVar2.j(e9);
                }
            } catch (Throwable th) {
                eVar2.i();
                throw th;
            }
        }
    }

    @Override // ag.u, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws IOException {
        int i;
        OutputStream outputStream = this.f1920v;
        b6.f fVar = this.f1922x;
        e eVar = this.f1921w;
        eVar.h();
        try {
            AtomicInteger atomicInteger = (AtomicInteger) fVar.f1801x;
            Socket socket = (Socket) fVar.f1800w;
            i.e(atomicInteger, "<this>");
            while (true) {
                int i10 = atomicInteger.get();
                if ((i10 & 1) != 0) {
                    i = 0;
                    break;
                }
                int i11 = i10 | 1;
                if (atomicInteger.compareAndSet(i10, i11)) {
                    i = i11;
                    break;
                }
            }
            if (i != 0) {
                if (i != 3) {
                    if (!socket.isClosed() && !socket.isOutputShutdown()) {
                        outputStream.flush();
                        try {
                            socket.shutdownOutput();
                        } catch (UnsupportedOperationException unused) {
                            outputStream.close();
                        }
                    }
                    return;
                }
                socket.close();
                if (eVar.i()) {
                    throw eVar.j(null);
                }
            }
        } catch (IOException e9) {
            if (!eVar.i()) {
                throw e9;
            }
            throw eVar.j(e9);
        } finally {
            eVar.i();
        }
    }

    @Override // ag.u
    public final y d() {
        return this.f1921w;
    }

    @Override // ag.u, java.io.Flushable
    public final void flush() throws IOException {
        e eVar = this.f1921w;
        eVar.h();
        try {
            this.f1920v.flush();
            if (eVar.i()) {
                throw eVar.j(null);
            }
        } catch (IOException e9) {
            if (!eVar.i()) {
                throw e9;
            }
            throw eVar.j(e9);
        } finally {
            eVar.i();
        }
    }

    public final String toString() {
        return "sink(" + ((Socket) this.f1922x.f1800w) + ')';
    }
}
