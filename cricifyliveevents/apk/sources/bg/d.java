package bg;

import ag.r;
import ag.s;
import ag.w;
import ag.y;
import ge.i;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements w {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final InputStream f1923v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final e f1924w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ b6.f f1925x;

    public d(b6.f fVar) {
        this.f1925x = fVar;
        Socket socket = (Socket) fVar.f1800w;
        this.f1923v = socket.getInputStream();
        this.f1924w = new e(socket);
    }

    @Override // ag.w
    public final long U(long j4, ag.e eVar) throws IOException {
        i.e(eVar, "sink");
        e eVar2 = this.f1924w;
        eVar2.f();
        r rVarR = eVar.R(1);
        int iMin = (int) Math.min(8192L, 8192 - rVarR.f464c);
        try {
            eVar2.h();
            try {
                int i = this.f1923v.read(rVarR.f462a, rVarR.f464c, iMin);
                if (eVar2.i()) {
                    throw eVar2.j(null);
                }
                if (i != -1) {
                    rVarR.f464c += i;
                    long j7 = i;
                    eVar.f429w += j7;
                    return j7;
                }
                if (rVarR.f463b != rVarR.f464c) {
                    return -1L;
                }
                eVar.f428v = rVarR.a();
                s.a(rVarR);
                return -1L;
            } catch (IOException e9) {
                if (eVar2.i()) {
                    throw eVar2.j(e9);
                }
                throw e9;
            } finally {
                eVar2.i();
            }
        } catch (AssertionError e10) {
            if (f.a(e10)) {
                throw new IOException(e10);
            }
            throw e10;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        int i;
        b6.f fVar = this.f1925x;
        e eVar = this.f1924w;
        eVar.h();
        try {
            AtomicInteger atomicInteger = (AtomicInteger) fVar.f1801x;
            Socket socket = (Socket) fVar.f1800w;
            i.e(atomicInteger, "<this>");
            while (true) {
                int i10 = atomicInteger.get();
                if ((i10 & 2) != 0) {
                    i = 0;
                    break;
                }
                int i11 = i10 | 2;
                if (atomicInteger.compareAndSet(i10, i11)) {
                    i = i11;
                    break;
                }
            }
            if (i != 0) {
                if (i == 3) {
                    socket.close();
                } else {
                    if (socket.isClosed() || socket.isInputShutdown()) {
                        return;
                    }
                    try {
                        socket.shutdownInput();
                    } catch (UnsupportedOperationException unused) {
                        this.f1923v.close();
                    }
                }
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

    @Override // ag.w, ag.u
    public final y d() {
        return this.f1924w;
    }

    public final String toString() {
        return "source(" + ((Socket) this.f1925x.f1800w) + ')';
    }
}
