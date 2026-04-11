package bg;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends ag.c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Socket f1926n;

    public e(Socket socket) {
        this.f1926n = socket;
    }

    @Override // ag.c
    public final IOException j(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // ag.c
    public final void k() {
        Socket socket = this.f1926n;
        try {
            socket.close();
        } catch (AssertionError e9) {
            if (!f.a(e9)) {
                throw e9;
            }
            f.f1927a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e9);
        } catch (Exception e10) {
            f.f1927a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e10);
        }
    }
}
