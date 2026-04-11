package hf;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v extends d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Socket f6154m;

    public v(Socket socket) {
        this.f6154m = socket;
    }

    @Override // hf.d
    public final void j() {
        Socket socket = this.f6154m;
        try {
            socket.close();
        } catch (AssertionError e10) {
            if (!cf.l.u(e10)) {
                throw e10;
            }
            m.f6128a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e10);
        } catch (Exception e11) {
            m.f6128a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e11);
        }
    }

    public final IOException k(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
